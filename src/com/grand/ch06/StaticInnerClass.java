package com.grand.ch06;

public class StaticInnerClass {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i=0;i<d.length;i++){
            d[i] = 100*Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.printf("min = %f; max=%f", p.getFirst(),p.getSecond());
    }
}
