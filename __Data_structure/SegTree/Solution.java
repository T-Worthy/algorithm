package __Data_structure.SegTree;

import java.util.LinkedList;
import java.util.List;

class Solution {

    class Tree{
        int l,r; int val;
        Tree left, right;
        public Tree(int _l ,int _r){
            l=_l;r=_r;

        }
        public void add(int L ,int R, int addVal){
            System.out.println(L +","+R+"--ADD:["+l+","+r+"] ");
            if(r==l) { System.out.println("????"+r); }
            if((L<= l&& r<= R)){
                val+=addVal;
                return ;
            }
            int mid = (l + r)>>1;
            if (left == null) left = new Tree(l, mid); // 动态开点
            if (right == null) right = new Tree(mid + 1, r); // 动态开点
            if (L <= mid) left.add(L, R,addVal);
            //else System.out.println("????"+L+"..."+mid);
            if (mid < R) right.add(L, R,addVal);
           // else System.out.println("????"+R+"..."+mid);

            val=Math.max(left.val,right.val);
            System.out.println("--FINAL:["+l+","+r+"] "+" : "+val);
        }

    }


    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new LinkedList<>();
        Tree root = new Tree(0,101000001);
        System.out.println("root:"+root.r);
        for(int [] a : positions){
            root.add(a[0],a[1]+a[0],a[1]);
            ans.add(root.val);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int [][]p = {{200, 200},{200,2}};
        System.out.println(s.fallingSquares(p));
    }
}