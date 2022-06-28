package countQuadruplets;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {


    public int countQuadruplets(int[] nums) {
        int n=nums.length;


        int [] count =new int[101];
       // int [] ff= new int [101];

         for(int i =0;i<nums.length;i++) {
             if(count[nums[i]]<10000) count[nums[i]]=(i+1)*10000+1;
             else  count[nums[i]] += 1;
         }

            //count[num]++;
         int ans=0;


         int ai=0,bi,ci,d,ccc;
         for ( ;ai<n-3;ai++){
             for(bi=ai+1 ;bi<n-2;bi++){
                 for ( ci =bi+1 ; ci <n-1;ci++){
                     d= nums[ai]+nums[bi]+nums[ci];

                     if(d>100 || (ccc=count[d]%10000)==0) continue;
                     if((count[d]/10000)-1>ci) {
                         ans += (ccc);

                     }
                     else if((ccc)>1) {
                         for(int di=ci+1;di<n ;di++) {
                             if (nums[di] == d) {
                                 ans += 1;
                                // System.out.println("D:"+d+"= "+nums[ai]+" "+nums[bi]+" "+nums[ci]);

                             }
                         }
                     }
                 }

             }
         }

         return ans;


    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        int []a = {1,2,3,6};
        System.out.println(s.countQuadruplets(a));
    }
}