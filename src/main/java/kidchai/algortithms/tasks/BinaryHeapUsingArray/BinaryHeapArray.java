package kidchai.algortithms.tasks.BinaryHeapUsingArray;

public class BinaryHeapArray {
    Node[] binaryHeap = new Node[100];
    int heapSize = 0;

    private class Node {
        private int value;
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

        binaryHeap[currentId] = new Node(element);

        if (currentId > 0) {
            if (binaryHeap[parentId].leftChild == null) {
                binaryHeap[parentId].leftChild = binaryHeap[currentId];
            } else {
                binaryHeap[parentId].rightChild = binaryHeap[currentId];
            }
        }

        if (binaryHeap[currentId].value < binaryHeap[parentId].value) {
            siftUp(currentId);
        }
    }

    public int popMin() throws NullPointerException {
        int minValue = min();
        int minId = 0;
        int lastId = heapSize - 1;

        if (lastId < 0) {
            throw new NullPointerException();
        }

        int parentLastId = (lastId - 1) / 2;

        binaryHeap[lastId].leftChild = binaryHeap[minId].leftChild;
        binaryHeap[lastId].rightChild = binaryHeap[minId].rightChild;

        if (binaryHeap[parentLastId].rightChild != null) {
            binaryHeap[parentLastId].rightChild = null;
        } else {
            binaryHeap[parentLastId].leftChild = null;
        }

        binaryHeap[minId] = binaryHeap[lastId];
        binaryHeap[lastId] = null;

        heapSize--;

        if (binaryHeap[minId].value > binaryHeap[minId].leftChild.value ||
                binaryHeap[minId].value > binaryHeap[minId].rightChild.value) {
            siftDown(minId);
        }

        return minValue;
    }

    public int min() {
        return binaryHeap[0].value;
    }

    private void siftUp(int id) {
        int parentId = (id - 1) / 2;

        //сохраняем указатель на сына и сыновей сына
        Node bufLeftChild = binaryHeap[id].leftChild;
        Node bufRightChild = binaryHeap[id].rightChild;
        Node buf = binaryHeap[id];

        //меняем местами в ячейках
        binaryHeap[id] = binaryHeap[parentId];
        binaryHeap[parentId] = buf;

        //меняем указатели на детей
        if (binaryHeap[parentId].value == binaryHeap[id].leftChild.value) {
            binaryHeap[parentId].leftChild = binaryHeap[id];
            binaryHeap[parentId].rightChild = binaryHeap[id].rightChild;
        } else {
            binaryHeap[parentId].leftChild = binaryHeap[id].leftChild;
            binaryHeap[parentId].rightChild = binaryHeap[id];
        }

        binaryHeap[id].leftChild = bufLeftChild;
        binaryHeap[id].rightChild = bufRightChild;

        int grandParentId = (parentId - 1) / 2;

        //меняем указатель "деда" (родителя родителя)
        if (parentId != 0) {
            if (binaryHeap[id].value == binaryHeap[grandParentId].leftChild.value) {
                binaryHeap[grandParentId].leftChild = binaryHeap[parentId];
            } else {
                binaryHeap[grandParentId].rightChild = binaryHeap[parentId];
            }
        }

        if (parentId > 0 && binaryHeap[parentId].value < binaryHeap[grandParentId].value) {
            siftUp(parentId);
        }
    }

    private void siftDown(int id) {
        int childId = binaryHeap[id].leftChild.value < binaryHeap[id].rightChild.value ? id * 2 + 1 : id * 2 + 2;
        Node buf = binaryHeap[id];
        Node leftChildBuf = buf.leftChild;
        Node rightChildBuf = buf.rightChild;

        //меняем местами в ячейках
        binaryHeap[id] = binaryHeap[childId];
        binaryHeap[childId] = buf;

        //меняем указатели на детей
        binaryHeap[childId].leftChild = binaryHeap[id].leftChild;
        binaryHeap[childId].rightChild = binaryHeap[id].rightChild;

        if (binaryHeap[id].value == leftChildBuf.value) {
            binaryHeap[id].leftChild = buf;
            binaryHeap[id].rightChild = rightChildBuf;
        } else {
            binaryHeap[id].leftChild = leftChildBuf;
            binaryHeap[id].rightChild = buf;
        }

        if (childId >= heapSize - 1) {
            if (binaryHeap[childId].value < binaryHeap[childId].leftChild.value ||
                    binaryHeap[childId].value < binaryHeap[childId].rightChild.value) {
                siftDown(childId);
            }
        }
    }
}