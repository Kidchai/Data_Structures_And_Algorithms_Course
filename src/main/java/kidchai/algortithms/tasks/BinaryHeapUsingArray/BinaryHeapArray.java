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

    public int min() {
        return binaryHeap[0].value;
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;

        //сохраняем указатель на сына и сыновей сына
        Node bufLeftChild = binaryHeap[index].leftChild;
        Node bufRightChild = binaryHeap[index].rightChild;
        Node buf = binaryHeap[index];

        //меняем местами в ячейках
        binaryHeap[index] = binaryHeap[parentIndex];
        binaryHeap[parentIndex] = buf;

        //меняем указатели на детей
        if (binaryHeap[parentIndex].value == binaryHeap[index].leftChild.value) {
            binaryHeap[parentIndex].leftChild = binaryHeap[index];
            binaryHeap[parentIndex].rightChild = binaryHeap[index].rightChild;
        } else {
            binaryHeap[parentIndex].leftChild = binaryHeap[index].leftChild;
            binaryHeap[parentIndex].rightChild = binaryHeap[index];
        }

        binaryHeap[index].leftChild = bufLeftChild;
        binaryHeap[index].rightChild = bufRightChild;


        int grandParentIndex = (parentIndex - 1) / 2;

        //меняем указатель "деда" (родителя родителя)
        if (parentIndex != 0) {
            if (binaryHeap[index].value == binaryHeap[grandParentIndex].leftChild.value) {
                binaryHeap[grandParentIndex].leftChild = binaryHeap[parentIndex];
            } else {
                binaryHeap[grandParentIndex].rightChild = binaryHeap[parentIndex];
            }
        }

        if (parentIndex > 0 && binaryHeap[parentIndex].value < binaryHeap[grandParentIndex].value) {
            siftUp(parentIndex);
        }
    }

    //- push() - закинуть значение
    //- pop_min() - извлечь минимальное значение
    //- min() - посмотреть минимальное значениеl

}
