package missingNumber;

import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(nums[n-1]==n-1) return n;
        if(nums[0]!=0) return 0;
        int a=0;
        int b=n-1;
        int p =(a+b)/2;
        while (0<=p &&p+1<n){
            if(nums[p]==p) {
             if(p+1!=nums[p+1]) return p+1;
             else
                 a=p+1;
                 p = (a+ b) / 2;
            }
            else{
                if(p-1==nums[p-1]) return p;
                b=p-1;
                p=(a+b)/2;
            }
            System.out.println(p);
        }

        return 144;
    }
    public static void main(String[] args) throws Exception {
        Solution s= new Solution();
        int [] a={0,2};
        System.out.println(s.missingNumber(a));
    }
}