package com.hackhu;

public class Heap {
    int[] heap;
    int len = 0;
    public Heap(int[] heap) {
        this.heap=heap;
        len = heap.length-1;
        for (int i = heap.length/2; i >=1; i--) {
            heaping(i);
        }
    }

    private void heaping(int index) {
        while (true) {
            int maxPos = index;
            if (index * 2 <= len&&heap[index]<heap[index*2]) {
                swap(index, index * 2);
                maxPos = index * 2;
            }
            if (index * 2 + 1 <= len && heap[index] < heap[index * 2]) {
                swap(index,index*2+1);
                maxPos = index * 2+1;
            }
            if (maxPos == index) { // 索引未发生改变，说明左右子树都小于当前结点
                break;
            }
            index = maxPos;
        }
    }

    private void swap(int index1, int index2) {
        int tem = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tem;
    }
}
