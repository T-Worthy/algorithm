package postorder590;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solutions {


    public List<Integer> postorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<Node> stack =new Stack<>();

        stack.add(root);

        while(!stack.empty()){

            Node temp= stack.pop();
            ans.add(temp.val);
                if(!temp.children.isEmpty())
                for(Node n : temp.children){
                    stack.add(n);
                }
        }
        Collections.reverse(ans);
        return ans;
    }
}