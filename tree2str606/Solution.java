package tree2str606;

import java.util.Stack;

/**
 * Definition for a binary tree node. */
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

public class Solution {
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        StringBuilder  sb = new StringBuilder();
        sb.append(root.val);
        Stack<TreeNode> wait =new Stack<>();

        TreeNode ccc =new TreeNode(-1);
        if(root.right!= null) {wait.push(root.right);
            if(root.left!=null)  {wait.push(ccc); wait.push(root.left);}
            else {sb.append("()");}
        }
        else if(root.left!=null)  wait.push(root.left);
        //else
boolean  b=(1==2)&(2!=3);

        int pigu=0;


        while(!wait.isEmpty()){
            TreeNode temp =wait.pop();
            if(temp.val==-1) {
                sb.append(')'); continue;
            }
            sb.append("("+temp.val);  pigu++;

            if(root.right!= null) {wait.push(temp.right);
                if(root.left!=null)  {wait.push(ccc); wait.push(temp.left);}
                else {sb.append("()");}
            }
            else if(root.left!=null)  wait.push(temp.left);
            else {sb.append(')'); }

        }

        return sb.toString();
    }
}
