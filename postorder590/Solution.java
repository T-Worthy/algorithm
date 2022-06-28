package postorder590;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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


class Solution {   ////////---------------------倒层序遍历了
    public List<Integer> postorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        List<Node> stack = new ArrayList<>();

        int index= 0;
        stack.add(root);

         if(root.children.isEmpty()) {ans.add(root.val); return ans;}
        for(int i = root.children.size() - 1; i >= 0; i--){
            stack.add(root.children.get(i));

        }
        index++;

        while(index< stack.size()){

            Node temp= stack.get(index);
            if(!temp.children.isEmpty())
                for(int i = temp.children.size() - 1; i >= 0; i--){
                    stack.add(temp.children.get(i));
                }
            index++;


        }
        for(int i = index-1 ;i>-1;i--){
            ans.add(stack.get(i).val);
        }
return ans;

    }
}