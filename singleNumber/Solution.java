package singleNumber;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] singleNumber(int[] nums) {

        Set<Integer> s = new HashSet<>();
        for (int i :nums) {
            if(s.contains(i))s.remove(i);
            else s.add(i);
        }
        int[] res =new int[2];
        int i = 0;
        for (Integer value : s) {
            res[i++]=value;
        }
 return res;
    }
    public static void main(String[] args) throws Exception {
        Solution s =new Solution();
        int []a ={1,2,1,3,2,5};
        System.out.println(s.singleNumber(a)[0]);
    }


}