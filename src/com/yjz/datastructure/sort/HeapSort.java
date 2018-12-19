package com.yjz.datastructure.sort;

/**
 * Description: 堆排序，分为大根堆(升序排序)、小根堆(降序排序)
 * Author: yjz
 * CreateDate: 2018-12-19 10:18 AM
 **/
public class HeapSort {

    public static void heapSort(int[] array){
        int length = array.length;
        //当剩下一个元素的时候就不需要建堆了，所以length - 1
        for(int i = 0; i < length - 1; i++) {
            //构建大根堆，每次得出最大根
            buildMaxHeap(array,length - i - 1);
//            buildMinHeap(array,length - i - 1);
            //将根堆最大值或最小值放到数组最后面
            swap(array,0,length - i - 1);
        }
    }

    /**
     * 构建大根堆思路：
     * 从最后一个元素开始找它的父节点，然后父节点与左右孩子比较，如果孩子节点中的最大值比父节点大，则交换位置。
     * 然后向上推，一直将最大值推到二叉树的根节点
     */
    private static void buildMaxHeap(int[] array,int lastIndex) {
        //子节点的下标为(n - 1)/2，父节点的左右孩子节点下标为2*n+1和2*n+2
        for(int i = (lastIndex -1)/2 ;i >= 0; i--) {

            int j = i;
            //存在子节点(至少存在左节点)
            while ((j * 2 + 1) < lastIndex){
                //maxIndex代表左右孩子节点的最大值的下标
                int maxIndex = 2 * j + 1;
                //左节点小于最后一个节点，说明存在右节点
                if(maxIndex < lastIndex) {
                    if(array[maxIndex] < array[maxIndex + 1]) {
                        maxIndex = maxIndex+1;
                    }
                }
                //如果父节点小于孩子节点，交换其位置
                if(array[i] < array[maxIndex]) {
                    swap(array,i,maxIndex);
                    //这里很重要，因为交换了节点，要确保被交换的孩子节点也满足大根堆的标准
                    j = maxIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 构建小根堆，降序
     */
    private static void buildMinHeap(int[] array,int lastIndex) {
        for(int i = (lastIndex-1)/2 ;i >= 0;i-- ) {
            int j = i;
            //有孩子节点
            while ((j * 2 + 1) < lastIndex) {
                //存储左右孩子节点中的最小值
                int minIndex = j * 2 + 1;
                if(minIndex < lastIndex) {

                    if(array[minIndex] > array[minIndex + 1]){
                        minIndex = minIndex + 1;
                    }
                }
                if(array[j] > array[minIndex]) {
                    swap(array,j,minIndex);
                    j = minIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 交换数组中两个元素
     */
    private static void swap(int[] array,int start, int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {8, 1, 3, 5, 7, 11, 4, 6, 10};

        HeapSort.heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }


}
