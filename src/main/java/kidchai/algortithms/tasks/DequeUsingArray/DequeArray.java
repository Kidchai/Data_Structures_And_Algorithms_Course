package kidchai.algortithms.tasks.DequeUsingArray;

public class DequeArray {
    int[] deque = new int[10];
    int startIndex = 0;
    int endIndex = 1;
    int elementCounter = 0;

    public int[] pushFront(int element) {
        deque[startIndex] = element;
        startIndex = startIndex == 0 ? deque.length - 1 : --startIndex;
        elementCounter++;
        return deque;
    }

    public int[] pushBack(int element) {
        deque[endIndex] = element;
        endIndex = endIndex == deque.length - 1 ? 0 : ++endIndex;
        elementCounter++;
        return deque;
    }

    public int popFront() {
        int result = deque[startIndex + 1];
        startIndex++;
        elementCounter--;
        return result;
    }

    public int popBack() {
        int result = deque[endIndex - 1];
        startIndex++;
        elementCounter--;
        return result;
    }
}


