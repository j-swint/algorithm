package com.swint;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 6, 2, 135, 63};

        MaxHeap maxHeap = new MaxHeap(arr1);

        maxHeap.buildMaxHeap();

        System.out.println(maxHeap);

        int[] ints = maxHeap.heapSort();

        System.out.println(Arrays.toString(ints));

        int[] arr2 = {3, 5, 6, 2, 6, 63};

        MinHeap minHeap = new MinHeap(arr2);

        minHeap.buildMinHeap();

        System.out.println(minHeap);

        int[] ints1 = minHeap.heapSort();
        System.out.println(Arrays.toString(ints1));

    }
}
