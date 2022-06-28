package 二分查找;

import java.util.*;

class Solution {
    int ram=0;
    public int search(int[] nums, int target) {

        int a=0,b=nums.length-1,p=(a+b)/2;
        while(a<=b){
            if(target==nums[p]) return p;
            else if(target<nums[p]) b=p-1;
            else  a=p+1;
            p=(a+b)/2;
        }


        Set<Integer> set =new HashSet<>();


        return -1;
    }

    Map<Integer, List<Integer>> mpp;
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            if(mpp.containsKey(nums[i])) mpp.get(nums[i]).add(i);
            else {  List<Integer> p= new ArrayList<>();p.add(i); mpp.put(nums[i],p );}
        }
    }

    public int pick(int target) {
     ram++;
        return  mpp.get(target).get(ram%(mpp.get(target).size()));
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(){{ add(1);add(2);add(-5);add(99);
        add(89);add(7);}};

        Iterator it = set.iterator();
        while (it.hasNext()) System.out.println(it.next());

    }



}