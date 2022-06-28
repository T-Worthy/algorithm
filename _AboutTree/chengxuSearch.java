package _AboutTree;

import java.util.*;

/**
 * Definition for a binary tree node. */
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public int[] levelOrder(TreeNode root) {
           if(root==null)  return new int[0];
        Queue<TreeNode> que =new ArrayDeque<>();
        List<Integer> ans =new ArrayList<>();
        TreeNode temp;


        que.add(root);
        que.add(null);
        while (!que.isEmpty()){
             temp=que.poll();
             ans.add(temp.val);
             if(temp.left!=null) que.add(temp.left);
             if(temp.right!=null) que.add(temp.right);
        }
        int [] aans =new int[ans.size()];for(int i =0 ;i< ans.size() ;i++) aans[i]=ans.get(i);
        return  aans;

    }
}




public class chengxuSearch {
}
