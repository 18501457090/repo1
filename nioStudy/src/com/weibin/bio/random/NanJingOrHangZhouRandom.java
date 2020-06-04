package com.weibin.bio.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/30
 **/
public class NanJingOrHangZhouRandom {


    public static void main(String[] args) {
        List<String> asList1 = new ArrayList<>();
        List<String> asList2 = new ArrayList<>();
        asList1.add("a");
        asList1.add("b");
        asList1.add("c");
        asList2.add("a");
        asList2.add("d");
        asList2.add("e");
        System.out.println(asList1.retainAll(asList2));
        System.out.println(asList1);
        System.out.println(asList2);
        asList2.removeIf(str->str.equalsIgnoreCase("a"));

    }

}
