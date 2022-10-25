package kidchai.algortithms.tasks.BinaryHeapUsingArray;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeapArray {
    List<Node> heap = new ArrayList<>(100);
    int heapSize = 0;

    private static class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    public void push(int element) {
        heapSize++;

        int currentId = heapSize - 1;
        int parentId = (currentId - 1) / 2;

        heap.add(currentId, new Node(element));

        if (currentId > 0) {
            if (heap.get(parentId).leftChild == null) {
                heap.get(parentId).leftChild = heap.get(currentId);
            } else {
                heap.get(parentId).rightChild = heap.get(currentId);
            }
        }

        if (heap.get(currentId).value < heap.get(parentId).value) {
            siftUp(currentId);
        }
    }

    public int popMin() throws IndexOutOfBoundsException {
        if (heapSize == 0) {
            throw new IndexOutOfBoundsException();
        }

        int minValue = min();
        int lastNodeId = heapSize - 1;
        putLastNodeInRoot(lastNodeId);
        heapSize--;

        if (heap.get(0).value > heap.get(0).leftChild.value ||
                heap.get(0).value > heap.get(0).rightChild.value) {
            siftDown(0);
        }

        return minValue;
    }

    public int min() {
        return heap.get(0).value;
    }

    private void siftUp(int id) {
        int parentId = (id - 1) / 2;

        //сохраняем указатель на сына и сыновей сына
        Node bufLeftChild = heap.get(id).leftChild;
        Node bufRightChild = heap.get(id).rightChild;
        Node buf = heap.get(id);

        //меняем местами в ячейках
        heap.set(id, heap.get(parentId));
        heap.set(parentId, buf);

        //меняем указатели на детей
        if (heap.get(parentId).value == heap.get(id).leftChild.value) {
            heap.get(parentId).leftChild = heap.get(id);
            heap.get(parentId).rightChild = heap.get(id).rightChild;
        } else {
            heap.get(parentId).leftChild = heap.get(id).leftChild;
            heap.get(parentId).rightChild = heap.get(id);
        }

        heap.get(id).leftChild = bufLeftChild;
        heap.get(id).rightChild = bufRightChild;

        int grandParentId = (parentId - 1) / 2;

        //меняем указатель "деда"
        if (parentId != 0) {
            if (heap.get(id).value == heap.get(grandParentId).leftChild.value) {
                heap.get(grandParentId).leftChild = heap.get(parentId);
            } else {
                heap.get(grandParentId).rightChild = heap.get(parentId);
            }
        }

        if (parentId > 0 && heap.get(parentId).value < heap.get(grandParentId).value) {
            siftUp(parentId);
        }
    }

    private void siftDown(int id) {
        int childId = heap.get(id).leftChild.value < heap.get(id).rightChild.value ? id * 2 + 1 : id * 2 + 2;
        Node buf = heap.get(id);
        Node leftChildBuf = buf.leftChild;
        Node rightChildBuf = buf.rightChild;

        //меняем местами в ячейках
        heap.set(id, heap.get(childId));
        heap.set(childId, buf);

        //меняем указатели на детей
        heap.get(childId).leftChild = heap.get(id).leftChild;
        heap.get(childId).rightChild = heap.get(id).rightChild;

        if (heap.get(id).value == leftChildBuf.value) {
            heap.get(id).leftChild = buf;
            heap.get(id).rightChild = rightChildBuf;
        } else {
            heap.get(id).leftChild = leftChildBuf;
            heap.get(id).rightChild = buf;
        }

        if (childId >= heapSize - 1) {
            if (heap.get(childId).value < heap.get(childId).leftChild.value ||
                    heap.get(childId).value < heap.get(childId).rightChild.value) {
                siftDown(childId);
            }
        }
    }

    private void putLastNodeInRoot(int lastNodeId) {
        int parentId = (lastNodeId - 1) / 2;

        heap.get(lastNodeId).leftChild = heap.get(0).leftChild;
        heap.get(lastNodeId).rightChild = heap.get(0).rightChild;

        if (heap.get(parentId).rightChild != null) {
            heap.get(parentId).rightChild = null;
        } else {
            heap.get(parentId).leftChild = null;
        }

        heap.set(0, heap.get(lastNodeId));
        heap.set(lastNodeId, null);
    }
}