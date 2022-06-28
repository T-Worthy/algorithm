package tree2str606;

public class s2 {
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        if (root == null) return "";
         sb = new StringBuilder(root.val);
        sb.append(root.val);


        if(root.left!= null) DP(root.left);
        else if((root.right!=null)) sb.append("()");
        if(root.right!=null) DP(root.right);

        return sb.toString();
    }
    public void DP(TreeNode node){
        sb.append('(');
        sb.append(node.val);
        if(node.left!= null) DP(node.left);
        else if((node.right!=null)) sb.append("()");
        if(node.right!=null) DP(node.right);
        sb.append(')');

    }


}
