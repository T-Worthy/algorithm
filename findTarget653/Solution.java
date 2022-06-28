package findTarget653;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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

    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> set =new HashSet<>();

        Stack<TreeNode> sta =new Stack<>();
        if(root.left==null && root.right==null) return  2*root.val==k;
        sta.push(root);

        while ( ! sta.isEmpty()){
            TreeNode temp =sta.pop();
          //  if(set.contains(temp.val)) {if(temp.val*2 == k) return true;}
            set.add(temp.val);
            if(temp.left!=null)
            sta.push(temp.left);
            if(temp.right!= null)
                sta.push(temp.right);
        }

       for (Integer a  :set){
           if (set.contains(k-a)) return true;
       }
       return false;



    }

}