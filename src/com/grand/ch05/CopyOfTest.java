package com.grand.ch05;

import java.lang.reflect.Array;

public class CopyOfTest {
    /*
    * This method grows an array by allocation a new array of the same type and
    * copying all elements.
    * @param a the array to grow. this can be an object array of a primitive type array
    * @return a large array that contains all elements of a.
    * */
    public static Object goodCopyOf(Object a,int newLength){
        Class cl = a.getClass();
        if(!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray =  Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
