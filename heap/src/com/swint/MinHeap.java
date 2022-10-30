package com.swint;

import java.util.Arrays;

public class MinHeap {
    final private int[] heapSize;

    public MinHeap(int[] heapSize) {
        this.heapSize = heapSize;
    }

    public void buildMinHeap() {

        if (heapSize.length == 1) {
            return;
        }

        for (int i = 1; i < heapSize.length; i++) {
            inserToHeap(i);
        }

    }

    public int[] heapSort() {

        if (heapSize.length == 1)
            return new int[]{heapSize[0]};

        int[] tmpHeap = Arrays.copyOf(heapSize, heapSize.length);
        int[] orderResult = new int[heapSize.length];

        for (int i = tmpHeap.length; i > 0; i--) {
            orderResult[tmpHeap.length - i] = tmpHeap[0];
            swap(0, i - 1, tmpHeap);
            recoveHeap(tmpHeap, i - 1);
        }

        return orderResult;

    }

    private void recoveHeap(int[] arr, int len) {
        int index = 0;
        int left = 1;
        while (left <= len - 1) {
            int largeIndex = left + 1 <= len - 1 && arr[left + 1] < arr[left] ? left + 1 : left;

            if (arr[largeIndex] >= arr[index]) break;

            swap(largeIndex, index, arr);

            index = largeIndex;
            left = 2 * index + 1;


        }
    }

    private void inserToHeap(int index) {
        while ((index - 1) / 2 >= 0 && heapSize[index] < heapSize[(index - 1) / 2]) {
            swap(index, (index - 1) / 2, heapSize);
            index = (index - 1) / 2;
        }
    }

    private void swap(int index_a, int index_b, int[] arr) {
        arr[index_a] = arr[index_a] ^ arr[index_b];
        arr[index_b] = arr[index_a] ^ arr[index_b];
        arr[index_a] = arr[index_a] ^ arr[index_b];
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "heapSize=" + Arrays.toString(heapSize) +
                '}';
    }
}
