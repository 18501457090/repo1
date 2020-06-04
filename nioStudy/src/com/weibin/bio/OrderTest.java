package com.weibin.bio;

import java.util.Arrays;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/31
 **/
public class OrderTest {

    public static void main(String[] args) {
        int i = 10;
        int c = i++;
        System.out.println(i);
        System.out.println(c);


        int[] arr = {1, 23, 45, 6, 7, 8};

        bubbleSort(arr);

    }

    /**
     * 冒泡排序
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {   // 这里说明为什么需要-1
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
