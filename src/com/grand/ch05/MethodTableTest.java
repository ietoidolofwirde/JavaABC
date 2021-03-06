package com.grand.ch05;

import java.lang.reflect.Method;

public class MethodTableTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Method square = MethodTableTest.class.getDeclaredMethod("square",double.class);
        Method sqrt = Math.class.getDeclaredMethod("sqrt", double.class);
        //print table of x- and y-values
        printTable(1,10,10,square);
        printTable(1,10,10,sqrt);
    }

    /*
    * Return the square of a numner
    * @param x a number
    * @return x squared
    * */
    public static double square(double x){
        return x*x;
    }
    /*
    * Prints a table with x- and y- values for a method
    * @params form the lower bound for the x-values
    * @params to the upper bound for the x-values
    * @params n the number of rows in the table
    * @params f a method with a double parameter and double return value
    * */
    public static void printTable(double from, double to, int n, Method f){
        System.out.println(f);
        double dx = (to - from) / (n-1);
        for (double x = from; x < to; x+=dx) {
            try {
                double y = (Double)f.invoke(null,x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
