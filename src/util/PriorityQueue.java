package util;

public class PriorityQueue {

    int[] Heap;
    private int index;
    private int size;

    public PriorityQueue(int size) {
        this.size = size;
        this.index = 0;
        Heap = new int[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        if (rightChild(i) >= size || leftChild(i) >= size) {
            return true;
        }
        return false;
    }

    public void add(int item) {
        if (index >= size) {
            return;
        }
        Heap[index] = item;
        int current = index;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        index++;
    }

    public int takeMin() {
        int min = Heap[0];
        return min;
    }

    private void bubbleUp(int i) {
        if (!isLeaf(i)) {
            if (Heap[i] > Heap[leftChild(i)] ||
                    Heap[i] > Heap[rightChild(i)]) {
                if (Heap[leftChild(i)] < Heap[rightChild(i)]) {
                    swap(i, leftChild(i));
                    bubbleUp(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    bubbleUp(rightChild(i));
                }
            }
        }
    }

    public void bubble() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            bubbleUp(i);
        }
    }

    public void print() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + Heap[i]);
            if (leftChild(i) < index)
                System.out.print(" Left : " + Heap[leftChild(i)]);
            if (rightChild(i) < index)
                System.out.print(" Right :" + Heap[rightChild(i)]);
            System.out.println();
        }
    }
    private void swap(int x, int y) {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }
    public int size() {
        return this.index;
    }
}
