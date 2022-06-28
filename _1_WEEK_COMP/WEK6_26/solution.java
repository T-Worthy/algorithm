package _1_WEEK_COMP.WEK6_26;

class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
             int sum1=0,sum2=0;

             int n = nums1.length;
             //int cha[] = new int[n];
             int max= Integer.MIN_VALUE,min=Integer.MAX_VALUE;
             //int max2=max,min2=min;
        for (int i = 0; i < n; i++) {
              sum1+=nums1[i];
              sum2+=nums2[i];
        }
       // if(sum2<sum1){int [] tp =nums2; nums2=nums1;nums1=tp;  int t= sum1;sum1=sum2;sum2=t;}

        for (int i = 0; i < n; i++) {
            int nowVal=0;
            for (int j = i; j < n; j++) {
                  nowVal+=(nums1[i]-nums2[i]);
                  max=Math.max(max,nowVal);
                  min=Math.min(min,nowVal);
            }
        }


        return  sum2+max;

    }
}