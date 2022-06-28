package postorder590;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public List<Integer> postorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        BianLi(root,ans);
        return ans;
    }

    public void BianLi(Node n, List<Integer> ans){

        if(!n.children.isEmpty()){
            for(Node d:n.children){
                BianLi(d,ans);
            }
        }
        ans.add(n.val);

    }
}
