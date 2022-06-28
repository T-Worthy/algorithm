package bestRotation798;

class Solution {

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int [] zhuanpan = new int [n];
       // boolean isgood[ ][] = new boolean[n][];
        int isgood [] =new int[n];


        for (int i = 0; i < n; i++) {
            if(nums[i]==0) continue;
            int temp = i - nums[i];
            for ( int j = i+1 ;j<n+temp ;j++)
            {
                isgood[j%n]++;
            }
        }

        int maxi=0;
        for (int i = 1 ;i< n;i++){
            if(isgood[i]>isgood[maxi]) maxi=i;
        }
                  return  maxi;

    }
}
