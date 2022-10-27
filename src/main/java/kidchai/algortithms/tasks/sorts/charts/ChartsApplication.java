package kidchai.algortithms.tasks.sorts.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import kidchai.algortithms.tasks.sorts.*;

import java.util.Random;

public class ChartsApplication extends Application {
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
        XYChart.Series<Number, Number> seriesBubble = new XYChart.Series<>();
        seriesBubble.setName("Bubble sort");
        for (int i = 0; i < 100; i++) {
            int elements = i * 1000;
            int[] array = createRandomArray(elements);

            long startTime = System.currentTimeMillis();
            BubbleSort.sort(array);
            long time = System.currentTimeMillis() - startTime;
            seriesBubble.getData().add(new XYChart.Data<>(elements, time));
        }

        XYChart.Series<Number, Number> seriesInsertion = new XYChart.Series<>();
        seriesInsertion.setName("Insertion sort");
        for (int i = 0; i < 100; i++) {
            int elements = i * 1000;
            int[] array = createRandomArray(elements);

            long startTime = System.currentTimeMillis();
            InsertionSort.sort(array);
            long time = System.currentTimeMillis() - startTime;
            seriesInsertion.getData().add(new XYChart.Data<>(elements, time));
        }


        XYChart.Series<Number, Number> seriesSelection = new XYChart.Series<>();
        seriesSelection.setName("Selection sort");
        for (int i = 0; i < 100; i++) {
            int elements = i * 1000;
            int[] array = createRandomArray(elements);

            long startTime = System.currentTimeMillis();
            SelectionSort.sort(array);
            long time = System.currentTimeMillis() - startTime;
            seriesSelection.getData().add(new XYChart.Data<>(elements, time));
        }

        XYChart.Series<Number, Number> seriesMerge = new XYChart.Series<>();
        seriesMerge.setName("Merge sort");
        for (int i = 0; i < 50; i++) {
            int elements = i * 3000;
            int[] array = createRandomArray(elements);

            long startTime = System.currentTimeMillis();
            MergeSort.sort(array);
            long time = System.currentTimeMillis() - startTime;
            seriesMerge.getData().add(new XYChart.Data<>(elements, time));
        }

        XYChart.Series<Number, Number> seriesQuick = new XYChart.Series<>();
        seriesQuick.setName("Quick sort");
        for (int i = 0; i < 50; i++) {
            int elements = i * 3000;
            int[] array = createRandomArray(elements);

            long startTime = System.currentTimeMillis();
            QuickSort.sort(array, 0, array.length);
            long time = System.currentTimeMillis() - startTime;
            seriesQuick.getData().add(new XYChart.Data<>(elements, time));
        }

        XYChart.Series<Number, Number> seriesQuickOptimized = new XYChart.Series<>();
        seriesQuickOptimized.setName("Quick sort with insertions");
        for (int i = 0; i < 50; i++) {
            int elements = i * 3000;
            int[] array = createRandomArray(elements);

            long startTime = System.currentTimeMillis();
            QuickSort.optimizedSort(array, 0, array.length);
            long time = System.currentTimeMillis() - startTime;
            seriesQuickOptimized.getData().add(new XYChart.Data<>(elements, time));
        }

        XYChart.Series<Number, Number> seriesHeap = new XYChart.Series<>();
        seriesHeap.setName("Heap sort");
        for (int i = 0; i < 50; i++) {
            int elements = i * 3000;
            int[] array = createRandomArray(elements);

            long startTime = System.currentTimeMillis();
            Heapsort.sort(array, array.length);
            long time = System.currentTimeMillis() - startTime;
            seriesHeap.getData().add(new XYChart.Data<>(elements, time));
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(seriesBubble, seriesInsertion, seriesSelection, seriesMerge,
                seriesQuick, seriesQuickOptimized, seriesHeap);

        stage.setScene(scene);
        stage.show();
    }

    private static int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
}