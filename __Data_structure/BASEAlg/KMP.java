package __Data_structure.BASEAlg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KMP {
    public int strStr(String haystack, String needle) {
        int N=haystack.length();
        int n = needle.length();
        if(N<n ) return -1;
        char need []= needle.toCharArray();
        char goal []= haystack.toCharArray();

        int next []= new int[n];

        int i = 1; int j=0;
        while(i < n)  {  ///---------remmber！！！！！！！！
            if( need[i]==need[j]){ j++; next[i]=j;i++ ;}
            else if(j==0)  i++;
            else{ j=next[j-1]; }
        }//------------------------------------------------------------
   
         i=0;j=0;
//---------------------------------------------------------------------
         while(i<N && j<n){
              if(goal[i]==need[j]) {i++;j++;}
              else if(j==0) i++;
              else {j=next[j-1];}

         }




        System.out.println(i+"  "+j);
        if(j==n) return  i-n;

        return -1;
    }

    public static void main(String[] args) {
        KMP kp = new KMP();
        System.out.println(kp.strStr("mississippi",
                "issip"));

        int[][] accounts= {{1,45,89,45},{485,2,48},{6,78,9},{56,5}};;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
       Integer anss = Arrays.stream(accounts)
               .map(e->{int ans=0; for(int ee : e) ans+=ee; return  ans;})
               .reduce(  0,(e1,e2)->{ if(e1<e2 )return e2; return e1;} );
        System.out.println(anss);
    }
}
