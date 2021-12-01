package com.zjut.algorithm;

/**
 * @author Joya Zou
 * @date 2021年10月24日 10:48
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] num = new int[100];
        for(int i=0; i<100; i++){
            num[i] = 100 -i;
        }
        // 1.一轮heapinsert
        for(int i= 0; i<100; i++){
            heapinsert(num, i);
        }
        // 2.依次执行heapify
        int heapSize = num.length;
        swap(num, 0, --heapSize);
        while(heapSize > 0){
            heapify(num, 0, heapSize);
            swap(num, 0, --heapSize);
        }

        for(int i:num){
            System.out.println(i);
        }
    }

    public static void swap(int[] num, int indexLeft, int indexRight){
        int tmp = num[indexLeft];
        num[indexLeft] = num[indexRight];
        num[indexRight] = tmp;
    }

    private static void heapinsert(int[] num, int i) {

        while(i>0 && num[i] > num[(i-1) /2]){
            swap(num, i, (i-1)/2);
        }
    }

    private static void heapify(int[] num, int index, int heapSize){
        int leftChild = index *2 +1;
        while(leftChild < heapSize){
            int largest = (leftChild +1 < heapSize && num[leftChild] < num[leftChild +1]) ? leftChild +1: leftChild;
            // 判断当前节点是否比子节点大，是否需要下沉
            largest = num[index] > num[largest]? index:largest;
            if(largest == index) {
                // 不需要下沉
                break;
            }
            swap(num, index, largest);
            index = largest;
            leftChild = index *2 +1;
        }

    }

}
