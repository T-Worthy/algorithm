package nextBig1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n=nums1.length;
        //boolean[] nocan=new boolean[n];
        int m = nums2.length;
        Map<Integer,Integer> index=new HashMap<> ();
        for(int i = 0; i< m ;i++)
            index.put(nums2[i],i);

        int ind=0;

        for (int i = 0 ;i < n ;i++){
            ind=index.get(nums1[i])+1;
            while(ind<m && nums2[ind]<nums1[i]) ind++;
            if(ind>=m)nums1[i]=-1;
            else nums1[i]=nums2[ind];
        }
        return nums1;
    }


    public static void main(String[] args) throws Exception {
        Solution s= new Solution();
        int[] aa={4,1,2};
        int[] bb={1,3,4,2};
        int [] a =s.nextGreaterElement(aa,bb);
        for (int i:a) {
            System.out.println(i);

        }
    }

}