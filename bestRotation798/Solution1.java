package bestRotation798;

public class Solution1 {

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int diff [] =new int[n];   //差分
        for (int i = 0; i < n; i++) {
            if(nums[i]==0) continue;
            int temp = i - nums[i];
            diff[(i+1)%n] ++;   diff [(n+temp+1)%n]--;}
        int maxi=0, max=0, score=0;
        for (int i = 1 ;i< n;i++){
            score+=diff[i];
            if(score> max) {max=score; maxi=i;}}
        return  maxi;
    }
}
