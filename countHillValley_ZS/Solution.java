package countHillValley_ZS;

class Solution {
    public int countHillValley(int[] nums) {
        int n =nums.length;
        if(n<3)  return 0;

        int [] road = new int[n];
        for(int i = 0;i< n-1 ;i++){
            road[i]= nums[i+1]-nums[i];
        }
        printArray(road);

        int lastFlag=road[0];
        int ans=0;
        for(int i : road){
           // System.out.println(i+"???"+lastFlag);
            if(i==0)  continue;
            else { if(i*lastFlag<0) ans++; lastFlag=i;   }
        }
        return ans;
    }


    public static void printArray(int[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        int []a ={2,4,1,7,6,5,7};
        System.out.println(s.countHillValley(a));
    }
}