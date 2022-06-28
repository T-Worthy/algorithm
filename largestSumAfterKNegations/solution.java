package largestSumAfterKNegations;

import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum=0;
        for (Integer i : nums)
            sum+=i;

        if(k==0)  return  sum;

        Arrays.sort(nums);
        int n =nums.length;

        int i =0;
        for ( i =0;i< n && nums[i]<0 && k>0 ;i++){
            sum-=2*nums[i];
            k--;
        }
        if(k>0 && k%2==1) {
            if (i==0 || i < n && (nums[i]+nums[i-1]<0) ) {
                sum -= 2 * nums[i];
            }
            else  if(i<n) sum += 2 * nums[i];
            else sum -= 2 * nums[i-1];
        }
        return sum;
    }
}