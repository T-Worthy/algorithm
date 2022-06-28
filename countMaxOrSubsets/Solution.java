package countMaxOrSubsets;

class Solution {

    int num[] ;
    int max,n;
    int ans=1;

    public void dfs(int deep,int orVal){
        if(deep==n && orVal==max){
            ans++;
        }
        dfs(deep+1,orVal|num[deep]);
        dfs(deep+1,orVal);

    }
    public int countMaxOrSubsets(int[] nums) {

        num=nums;
        n = nums.length;
        max=0;

        for(int i =0;i< n ;i++) {
            max|=nums[i];
        }


        n=n-1;
        dfs(0,1);





        return  ans;
    }
}