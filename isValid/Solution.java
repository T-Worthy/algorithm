package isValid;

import java.io.StringReader;
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans  = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        List<Integer> node  = new ArrayList<>();


        node.add(root.val);
        ans.add(node);
        if(root==null)  return ans;

        queue.add(root);
        queue.add(null);
        Node temp;

        while( !queue.isEmpty() ){
            node  = new ArrayList<>();
           while( (temp = queue.poll())!=null){

               node.add(temp.val);
               for(Node no: temp.children){
                   queue.add(no);
               }
           }
            queue.add(null);
            ans.add(node);


        }
        return ans;
    }
}