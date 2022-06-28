package isValid2;

import countHighestScoreNodes2049.Solution;

import java.util.*;

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

class Solution2 {
    List<TreeNode> ans = new ArrayList<>();
    int num[] ;
    public List<TreeNode> generateTrees(int n) {
        num= new int[n+1];  for(int i =1;i<=n;i++) num[i]=i;  //可以构造其他数据
        return   build(n,1,n);
    }

    List<TreeNode> build(int n , int i ,int j ) {
        if(n==0) return null;
        if(n==1) {  List<TreeNode> tp=  new ArrayList<>(); tp.add(new TreeNode(num[i])) ;return  tp;}
        if(n==2){
            List<TreeNode> tp=  new ArrayList<>();
            tp.add( new TreeNode(num[i],null,new TreeNode(num[j]) ) );
            tp.add( new TreeNode(num[j],new TreeNode(num[i]) ,null ) );
            return tp;
        }
        List<TreeNode> tp=  new ArrayList<>();
        for (int left = i; left <= j; left++) {
             contact(tp, left,(left==i? null:build(left-i ,i,left-1) ),  (left==j ? null:build(j-left,left+1,j )) );
        }
         return  tp;
    }

    List<TreeNode>  contact( List<TreeNode>  ret, int root,List<TreeNode> left,List<TreeNode> right){
      //  List<TreeNode>  ret= new ArrayList<>();
        int n = left==null? 0: left.size();
        int m = right==null? 0: right.size();
        if(n==0){
            for (int i = 0; i < m; i++) {
                ret.add(new TreeNode(root,null, right.get(i)));
            }
            return  ret;
        }
        else if(m==0){
            for (int i = 0; i < n; i++) {
                ret.add(new TreeNode(root,left.get(i)  ,null));
            }
            return  ret;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret.add(new TreeNode(root,left.get(i)  ,right.get(j)));
            }
        }
         return  ret;
    }
}