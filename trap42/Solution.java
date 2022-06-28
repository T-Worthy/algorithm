package trap42;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int [] LRmax=new int[n],RLmax=new int[n];
        int maxRL=0,maxLR=0;
        for(int i = 0; i< n;i++){
            if(height[i]>maxLR) maxLR=height[i];
             LRmax[i]=maxLR;
            if(height[n-i-1]>maxRL) maxRL=height[n-i-1];
            RLmax[i]=maxRL;
        }
        int ans=0;
        for(int i = 0; i< n;i++){
            ans+=(Math.min(LRmax[i],RLmax[i])-height[i]);
        }
        return ans;
    }
}