package com.grand.ch06;

import java.util.Arrays;

public class ComparatorTest {
    public static void main(String[] args) {
        String[] friends = {"Peter","Marry","Paul"};
        Arrays.sort(friends, new LengthComparator());
        for (String s: friends) {
            System.out.println(s);
        }
    }
}
