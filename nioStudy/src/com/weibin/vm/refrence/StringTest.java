package com.weibin.vm.refrence;

import java.util.Arrays;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/24
 **/
public class StringTest {

    // 0 的 ascii值为48
    public static void main(String[] args) {
        String s = calculateForStrings("111", "9999");
        System.out.println(s);
        // 2100
        System.out.println(18 % 10);
    }

    static class ComputerClass{
        private int sum;
        private int leftNum;
        private String result;
        public ComputerClass(int sum,int leftNum,String result){
            this.sum = sum;
            this.leftNum = leftNum;
            this.result = result;
        }


    }

    static String calculateForStrings(String numStr1, String numStr2) {

        String result = "";
        if (numStr1 == null || numStr1.length() == 0 ||
                numStr2 == null || numStr2.length() == 0) {
            return result;
        }
        int num1Len = numStr1.length() - 1, num2Len = numStr2.length() - 1;
        char zero = '0';
        Integer sum = 0;
        Integer leftNum = 0;
        while (num1Len >= 0 || num2Len >= 0) {
            // 两者都能相加的情况
            if (num1Len >= 0 && num2Len >= 0) {
                // 两个字符转换为int进行相加然后减去96得到实际的数值
                sum = (numStr1.charAt(num1Len) + numStr2.charAt(num2Len))  + leftNum - 2 * zero;
                if (sum > 9) {// 如果两者计算结果大于9，即双位数
                    leftNum = 1;
                    result = (sum % 10) + result;
                } else {
                    leftNum = 0;
                    result = (sum % 10) + result;
                }
            }
            // 如果numStr1的字符串长度大于numStr2，并且两者的交集都已经计算完毕
            if (num1Len >= 0 && num2Len < 0) {
                char c = numStr1.charAt(num1Len);
                if (leftNum != 0){// 说明上次计算结果是两位数
                    sum = c - zero + leftNum;
                    if (sum > 9){
                        leftNum = 1;
                        result = (sum % 10) + result;
                    } else {
                        leftNum = 0;
                        result = (sum % 10) + result;
                    }
                } else {
                    // 说明两者交集部分计算结果是单位数,直接把多于的数据截取出来，拼接到前面即可
                     result = numStr1.substring(0, num1Len + 1);
                     leftNum = 0;
                     break;
                }
            }
            if (num2Len >= 0 && num1Len < 0) {
                char c = numStr2.charAt(num2Len);
                if (leftNum != 0){// 说明上次计算结果是两位数
                    sum = c - zero + leftNum;
                    if (sum > 9){
                        leftNum = 1;
                        result = (sum % 10) + result;
                    } else {
                        leftNum = 0;
                        result = (sum % 10) + result;
                    }
                } else {
                    // 说明上次计算结果是单位数,直接把多于的数据截取出来，拼接到前面即可
                    result = numStr2.substring(0, num2Len + 1);
                    leftNum = 0;
                    break;
                }
            }
            num1Len--;
            num2Len--;
        }
        // 防止两个数据一般大，同时循环结束而导致没有拼接。在这里进行拼接
        if (leftNum != 0){
            result = leftNum + result;
        }
        return result;
    }

    private static String compute(Integer sum,Integer leftNum,String result){
        if (sum > 9){
            leftNum = 1;
            result = (sum % 10) + result;
        } else {
            leftNum = 0;
            result = (sum % 10) + result;
        }
        return result;
    }

    /*
    * //评测题目: 无
    给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

    注意：

    num1 和num2 的长度都小于 5100.
    num1 和num2 都只包含数字 0-9.
    num1 和num2 都不包含任何前导零。
    你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
    * */
    public static String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int result = 0;
        String s = "";
        int sum;
        while (len1 >= 0 || len2 >= 0) {
            if (len1 < 0 && len2 >= 0) {  //num2 没加完
                sum = num2.charAt(len2) + result - '0';
                if (result != 0) {
                    if (sum > 9) {
                        result = 1;
                        s = String.valueOf(sum % 10) + s;
                    } else {
                        s = String.valueOf(sum % 10) + s;
                        result = 0;
                    }
                } else {
                    s = num2.substring(0, len2 + 1) + s;
                    result = 0;
                    break;
                }
            }
            if (len1 >= 0 && len2 < 0) {
                sum = num1.charAt(len1) + result - '0';
                if (result != 0) {
                    if (sum > 9) {
                        result = 1;
                        s = String.valueOf(sum % 10) + s;
                    } else {
                        s = String.valueOf(sum % 10) + s;
                        result = 0;
                    }
                } else {
                    s = num1.substring(0, len1 + 1) + s;
                    result = 0;
                    break;
                }
            }
            if (len1 >= 0 && len2 >= 0) {
                sum = num1.charAt(len1) + num2.charAt(len2) + result - 2 * '0';
                if (sum > 9) {
                    result = 1;
                    s = String.valueOf(sum % 10) + s;
                } else {
                    s = String.valueOf(sum) + s;
                    result = 0;
                }
            }
            len1--;
            len2--;
        }
        if (result != 0) {
            s = Integer.toString(result) + s;
        }
        return s;

    }

}
