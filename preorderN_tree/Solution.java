package preorderN_tree;

import java.util.*;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public List<Integer> preorder(Node root) {

        Stack<List> nb= new Stack<List>();
        List<Integer> ans =new ArrayList<>();
        if(root==null) return ans;

        ans.add(root.val);
        if(root.children==null) return  ans;
        nb.push(root.children);

        List<Node> temp;

        while(!nb.isEmpty()){
           temp =nb.peek();
           if(temp.size()==0) {nb.pop(); }
           else {//必定有值
               ans.add(temp.get(0).val);
               if (temp.get(0).children!=null){
                   nb.push(temp.get(0).children);
               }
               else {
               }
               temp.remove(0);
           }

        }
         return  ans;

    }
}