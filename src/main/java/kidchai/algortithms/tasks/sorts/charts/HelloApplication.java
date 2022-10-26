package kidchai.algortithms.tasks.sorts.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import kidchai.algortithms.tasks.sorts.BubbleSort;

import java.util.Random;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sorts");

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Number of elements");
        yAxis.setLabel("Time (ms)");

        //creating the chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Sorts");

        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Bubble sort");

//      populating the series with data
        for (int i = 0; i < 40; i++) {
            int elements = i * 1000;
            int[] array = createRandomArray(elements);

            long startTime = System.currentTimeMillis();
            BubbleSort.sort(array);
            long time = System.currentTimeMillis() - startTime;
            series.getData().add(new XYChart.Data<>(elements, time));
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
}