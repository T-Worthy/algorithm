package _1_WEEK_COMP.WEK6_19;

import java.util.*;

public class solution {

     int n;

        public int longestSubsequence(String s, int k) {

              n= s.length();

              if(n==0) return 0;
              if(n==1) return   (k>= (s.charAt(0)-'0'))? 1:0;

              int zero=0;
           Stack<Integer> find = new Stack<>();

            System.out.println();

              for(int i =0;i< n;i++){
                  if(s.charAt(i)=='0') {zero++; find.add(i);}

                  else if(  ( i<n-1 && s.charAt(i+1)=='0')) find.add(i);

              }
              int ans= zero;

               for(int i =n-1 ;i>= n-zero  ; ){
                   int nowLen=zero-(n-1-i);int wei=1;int nowVal=0;
                   int j= i;
                   while(j>=0 && wei<=k){
                       if(s.charAt(j)=='1'  &&  nowVal+wei<=k){
                             nowVal+=wei;
                             nowLen++;
                           System.out.println( j);
                       }
                       wei*=2;
                       j--;
                   }
                   ans=Math.max(ans, nowLen);
                   if(!find.isEmpty())
                   i =find.pop();
                   else break;

               }


                return  ans;

        }



}