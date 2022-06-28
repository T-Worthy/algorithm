package zhousai_5_29;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;


public class Solution {

    int[] nums;
    public int totalSteps(int[] nnn) {
        nums=nnn;
        int n= nums.length;
        int ans=0;


        int tp[] = new int[n];
        int j;
        for(int i=0; i< n;i++){
            j =i+1;
            while(j<n && nums[j]<nums[i] ) j++;

            tp[i]=j-i-1;

            System.out.println("TP["+i+"]=="+tp[i]);
        }
        int k ;
        for (int i = 0; i < n; i++) {
            int kk =tp[i],pp=0;
            if(tp[i]!=0){
                for ( k = i+1; k < i+tp[i]+1; ) {
                    pp++;
                   kk-=tp[k]+1;

                    if(kk<=0)
                        break;

                    if(i==2) System.out.println(pp+","+kk);

                    k+=tp[k]+1;
                }

                ans= Math.max(ans,pp);
            }

        }


        return  ans;
    }

}