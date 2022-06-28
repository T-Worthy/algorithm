package _1_WEEK_COMP.WEK6_19;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class s3 {


    //  Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        Map<Integer,Integer> map= new HashMap<>();
        int max= 0;
        public int[] findFrequentTreeSum(TreeNode root) {
            List<Integer>  ans = new LinkedList<>();

            for(int i : map.keySet()){
                if(map.get(i)==max) ans.add(i);
            }
            int ret[]= new int[ans.size()];
            int j = 0;
            for(int i : ans) ret[j++]=i;

            return  ret;

        }
        public  int  search(TreeNode root){
              if(root==null) return 0;

              int left = search(root.left);
              int right= search(root.right);

              int v= left+right+root.val;
              int num =map.getOrDefault(v,0 )+1;
            map.put( v, num);
            max=Math.max(max,num);

            return  v;


           
        }
    }

}
