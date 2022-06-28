package aTEST;

import java.io.IOException;
import java.math.BigInteger;

public class tes {

    public static void printBiInt(int bi){  //整型数字二进制形式输出
       int temp =1<<31;
        System.out.print("*");
        for(int j=0; j<Integer.SIZE-1; j++) {
            //System.out.print(number &amp;(tmp&gt;&gt;&gt;&#61;1));
            System.out.print( (((bi& (temp >>>=1)) == 0)? 1:0));

        }
        System.out.println("=="+bi );//+" -- \n"+Integer.toBinaryString(bi));


    }

    private  static  final  long app=abb();

    public static  long abb(){
        return 1231;
    }

    private static final long USER_ID=abb();
    static {
        try {
            System.out.println(USER_ID==213);
        } catch (Exception e) {
           // USER_ID =1243444;

            System.out.println("Logging in as guest");
        }
    }


    public static void main(String[] args)  {

      int a =1002;
      int b=1234;
      long c= a&b;



        System.out.println(c);

   /*   int  b=0b10101010101010101010101010101010;

        System.out.println(Integer.SIZE);

      for (int i =0;i< 35 ;i++){

          printBiInt(b);
          System.out.println("=="+b);
          b<<=1;

      }*/




       double e = 1.0e18;

       int bound=100;






}



}
