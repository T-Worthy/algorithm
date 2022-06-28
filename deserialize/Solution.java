package deserialize;


import java.util.ArrayList;
import java.util.List;

//  Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
       List<Integer> hasNum;
       int Max=-999;

       public  void forEach(TreeNode root){
           hasNum.add(root.val);
           Max=Math.max(Max,root.val);
           if(root.left!=null) forEach(root.left);
           if(root.right!=null) forEach(root.right);
       }
    public int getNumber(TreeNode root, int[][] ops) {
            hasNum= new ArrayList<>();
            if(root==null)  return 0;
            forEach(root);

            int caFen []= new int[Max+1];

            int NodeNum=0;
            for (int i: hasNum){

                caFen[i]=-1;
                NodeNum++;
        }
        System.out.println();
            int n = NodeNum;
            int ans= 0;
             int ty,from,to;
        for (int i = ops.length-1; i >=0 ; i--) {
            System.out.println(n+" : "+ans+" ' "+i);
            ty=ops[i][0];from=ops[i][1];to=ops[i][2];
            for (int j = from; j <=to ; j++) {
                System.out.println(j+" : "+caFen[j]);
                if(caFen[j]==0) continue;
                if(caFen[j]==-1) {
                    if(ty==1) ans++;
                    n--;
                    caFen[j]=to+1;
                }
                else
                {
                    j=caFen[j];
                }
            }
            if(n<=0) return ans;

        }

        return ans;


    }


    public static void main(String[] args) {
        Solution s= new Solution();;

         int limit = 5;

    }
}