package aTEST;

public class tes2 {
    public static void printBiInt(int bi){  //整型数字二进制形式输出
        int temp =1<<31;
        for(int j=0; j<Integer.SIZE-1; j++) {
            //System.out.print(number &amp;(tmp&gt;&gt;&gt;&#61;1));
            System.out.print( ((bi& (temp >>>=1)) == 0)? 1:0);

        }
        System.out.println();
    }
    public static void main(String[] args) {

        int a = -12;
        int b= ~a;
        int c=-a;


        System.out.println(a+"\n"+Integer.toBinaryString(a));  printBiInt(a);
        System.out.println(b+"\n"+Integer.toBinaryString(b));  printBiInt(b);
        System.out.println(c+"\n"+Integer.toBinaryString(c));  printBiInt(c);
    }
    }
