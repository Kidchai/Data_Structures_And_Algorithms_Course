package kidchai.algortithms.tasks.DequeUsingList;

public class DequeList {
    private Node first;
    private Node last;

    private class Node {
        private int value;
        private Node prevNode;
        private Node nextNode;

        public Node(int value) {
            this.value = value;
        }
    }

    public void pushBack(int element) {
        Node current = new Node(element);
        if (isEmpty()) {
            first = current;
        } else if (first.nextNode == null && last.prevNode == null) {
            current.prevNode = first;
            first.nextNode = current;
        } else {
            last.nextNode = current;
            current.prevNode = last;
        }
        last = current;
    }

    public void pushFront(int element) {
        Node current = new Node(element);
        if (isEmpty()) {
            last = current;
        } else if (first.nextNode == null && last.prevNode == null) {
            current.nextNode = last;
            last.prevNode = current;
        } else {
            first.prevNode = current;
            current.nextNode = first;
        }
        first = current;
    }

    public int popBack() throws NullPointerException  {
        handleIfEmpty();
        int result = last.value;
        last = last.prevNode;
        last.nextNode = null;
        return result;
    }

    public int popFront() throws NullPointerException  {
        handleIfEmpty();
        int result = first.value;
        first = first.nextNode;
        first.prevNode = null;
        return result;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public void clear() {
        first = null;
        last = null;
    }

    private void handleIfEmpty() throws NullPointerException  {
        if (isEmpty()) {
            throw new NullPointerException();
        }
    }
}