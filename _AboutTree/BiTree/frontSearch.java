package _AboutTree.BiTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        if(root ==null ) return ans;

        Queue<TreeNode> wait=new ArrayDeque<>();
        TreeNode temp =root;


        while(temp.left!=null) {wait.offer(temp.left); temp=temp.left;}


        wait.offer(root);
        while(!wait.isEmpty()){
             temp =wait.poll();
             ans.add(temp.val);
             if (temp.right!=null) {
                 temp=temp.right;
                 while (temp.left != null) {
                     wait.offer(temp.left);
                     temp = temp.left;
                 }
             }


        }
        return ans;

    }
}


public class frontSearch {
}
