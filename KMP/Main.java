package KMP;

import java.util.Arrays;

public class Main {


      public   int KMP(String s1, String  s2){
            int n1=s1.length(), n2 = s2.length();
            int next []  = new int[n2];

            int k =0,j=2;
            next[0]=-1;next[1]=0;
           while(j<n2-1){
                 if( s2.charAt(k)==s2.charAt(j-1) )  next[j++]=++k;
                 else  if(k>0 ) k=next[k];
                 else next[j++]=0;
           }
                      System.out.println(Arrays.toString(next));
             int p1=0 ,p2= 0;
           while (p1< n1 && p2< n2){
                 if(s1.charAt(p1)==s2.charAt(p2)){ p1++;p2++;}
                 else if(p2>0)  p2= next[p2];
                 else p1++;
           }
           return  p2==n2? p1-p2 :-1;
      }

      public static void main(String[] args) {
            Main m = new Main();

            System.out.println(m.KMP("ababcdabcdabcdababbacbhdbcabcdabcdabcdabacabc","aaaabcdbcdbcdbcdaaa"));
      }

}
