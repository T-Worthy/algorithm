package findRightInterval;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n= intervals.length;
        int [][] ppp = new int[n][2];
        for (int i = 0; i < n; i++) {
            ppp[i][0]=intervals[i][0];
            //ppp[i][1]=intervals[i][1];
            ppp[i][1]=i;
        }
        Arrays.sort(ppp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int ans[] = new int [n];

        for (int i = 0; i < n; i++) {
            ans[i]=biSearch(intervals[i][1],ppp);
        }
        return ans;

    }
    int biSearch(int end,int [][]nums){
        int i=0,j=nums.length-1;
               if(end>nums[j][1]) return -1;
               int mid;
               while(i<=j){
                   mid=(i+j)/2;
                   if(nums[mid][0]<end) i=mid+1;
                   else j=mid;
               }
               return nums[i][1];
    }
}