package _myUtil;

import java.util.Arrays;

public class wxtUtil {
    //整型数字二进制形式输出
    public static void printBiInt(int bi){  //整型数字二进制形式输出
        int temp =1<<31;
        for(int j=0; j<Integer.SIZE-1; j++) {
            //System.out.print(number &amp;(tmp&gt;&gt;&gt;&#61;1));
            System.out.print( ((bi& (temp >>>=1)) == 0)? 1:0);
            System.out.println("=="+bi);
        }
    }
 String s="dsd";

    public static void print(String[] a){
        System.out.print(" [ ");
        Arrays.stream(a).forEach(e->{
            System.out.print(e+" , ");
        });
        System.out.println(" ] ");
    }

    //数组输出
    public static void printArray(int[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }

    public static void printArray(int[][] b){
        System.out.print("[");
        int inf=0;
        for(int [] a:b) {System.out.print(inf+++":[");
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + ",");
            System.out.println("]");
        }
    }
    public static void printArray(boolean[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }


    }
