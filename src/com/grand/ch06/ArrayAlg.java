package com.grand.ch06;
/*
* 静态内部类
* 考虑一下计算数组中最小值和最大值问题
* 在数组中通过遍历一次获得最大值，最小值
* 静态内部类的对象除了没有对生成它的外围类对象的引用特权以外，
* 与其他内部类完全一样。
* */
public class ArrayAlg {
    /*
    * A pair of floating-point number
    * */
    public static class Pair{
        private double first;
        private double second;

        /*
        * Constructs a pair from two floating-point numbers
        * @param f the first number
        * @param s the second number
        * */
        public Pair(double first,double second){
            this.first = first;
            this.second = second;
        }

        /*
        * Return the first number of the pair
        * @return the first number
        * */
        public double getFirst(){
            return first;
        }

        public double getSecond(){
            return second;
        }
    }

    public static Pair minmax(double[] values){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v: values
             ) {
            if(min > v) min = v;
            if(max < v) max = v;
        }
        return new Pair(min,max);
    }

}
