package com.grand.ch03;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class DataType {

    public void stringFunc(){
        String hello = "hello";
        int n = hello.length();
        char cpCount = hello.charAt(0);
        int cp = hello.codePointAt(0);
        System.out.println(n);
        System.out.println(cpCount);
        System.out.println(cp);
        for (int i = 0; i <hello.length() ; i++) {
            System.out.print(hello.charAt(i));
        }
        System.out.println();
        int[] codePoints = hello.codePoints().toArray();
        for (int i = 0; i <codePoints.length ; i++) {
            System.out.print(codePoints[i] +  ' ');
        }
        System.out.println();
        System.out.println(hello.equals("hello"));
        String str = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(str.substring(10));
        System.out.println(str.substring(10,20));
    }

    public void StringBuildFunc(){
        // string 构建字符串需要重新构造一个字符串，效率比较低，使用stringbuild
        StringBuilder builder = new StringBuilder();
        builder.append('H');
        builder.append("ello");
        System.out.println(builder.toString());
    }

    public void ScanFunc(){
        Scanner in = new Scanner(System.in);
        System.out.println("What`s your name:");
        String name = in.nextLine();
        System.out.println(name);
        System.out.println("How old are you?");
        int age = in.nextInt();
        System.out.println(age);
        System.out.println(in.hasNext());
    }

    public void InputOutputFunc(){
        double x = 1000.0/3.0;
        System.out.printf("%8.2f",x);
        String str = System.getProperty("user.dir");
        System.out.println(str);
        try{
            Scanner in = new Scanner(Paths.get(str+"/resource/readfile.txt"),"UTF-8");
            PrintWriter out = new PrintWriter(str + "/resource/createFile.txt");
            while(in.hasNext()){
                System.out.println(in.nextLine());
                out.println(in.nextLine());
            }
            in.close();
            out.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void loopControllerFunc(){
        while(true){
            System.out.println("This is the first level loop");
            while(true){
                System.out.println("this is the second level loop");
                break;
            }
            System.out.println("break finished");
            break;
        }
        int num = 1;

        while(true){
            System.out.println("this is the first level");
            first_level:
            while(true){
                if(num > 3){
                    break first_level;
                }else{
                    System.out.println(num);
                    num++;
                }

            }
            System.out.println("skip the loop");
            break;
        }
    }

    public void bigDataFunc(){
        // Big Number
        BigInteger a = BigInteger.valueOf(100);//使用valueOf方法将普通数值转成大数据
        BigInteger d = a.add(BigInteger.valueOf(5));
        System.out.println(d);
        System.out.println(a.mod(BigInteger.valueOf(5)));
    }

    public void arrayFunc(){
        // 数组
        int[] a = new int[100];
        for (int i = 0; i <100 ; i++) {
            a[i] = i;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <a.length ; i++) {
            builder.append(a[i]).append('-');
        }
        builder.delete(builder.length()-1,builder.length());
        System.out.println(builder.toString());
        builder.delete(0,builder.length());
        for(int ele:a){
            builder.append(ele).append("-");
        }
        builder.delete(builder.length()-1,builder.length());
        System.out.println(builder.toString());

        // array copy
        int[] smallPries = {11,22,33,44,55};
        // 此时指向同一引用
        int[] lucyNumber = smallPries;
        System.out.println(Arrays.toString(smallPries));
        System.out.println(Arrays.toString(lucyNumber));
        lucyNumber[1]=66;
        System.out.println(Arrays.toString(smallPries));
        System.out.println(Arrays.toString(lucyNumber));
        // 真正的数组复制
        int[] trueCopyArray = Arrays.copyOf(smallPries,smallPries.length);
        trueCopyArray[1] = 99;
        System.out.println(Arrays.toString(trueCopyArray));
        System.out.println(Arrays.toString(smallPries));
        System.out.println("Array Sort");
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int[] result = new int[6];
        int n = 10;
        for (int i = 0; i < result.length ; i++) {
            int r = (int)(Math.random() * n);
            result[i] = r;
            // 保证数据不重复取值
            numbers[r] = numbers[n-1];
            n--;
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        // 二分查找
        int[] searchAray = {1,4,9,2,7,0,5,8};
        System.out.println(Arrays.binarySearch(searchAray,5));
        // 比较两个数组是否相同
        System.out.println(Arrays.equals(trueCopyArray,smallPries));

        final int NMAX = 10;
        int[][] odds = new int[NMAX+1][];
        for(int nn=0;nn<=NMAX;nn++){
            odds[nn] = new int[nn+1];
        }
        for (int nn = 0; nn < odds.length; nn++) {
            for (int k = 0; k < odds[nn].length ; k++) {
                int lotterOdds = 1;
                for (int i = 1; i <= k ; i++) {
                    lotterOdds = lotterOdds * (nn-i+1)/i;
                }
                odds[nn][k] = lotterOdds;
            }
        }
        for(int[] row: odds){
            for(int odd: row){
                System.out.println(odd);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Object and Class");

    }
}
