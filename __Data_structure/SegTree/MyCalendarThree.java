package __Data_structure.SegTree;

public class MyCalendarThree {

    int N = (int)1e9; //圈定的最大区间重点
    int  ans = 0;
    class Node {
        // ls 和 rs 分别代表当前区间的左右子节点
        Node ls, rs;
        // val 代表当前区间的最大高度，add 为懒标记
        int val, add;
    }
    Node root = new Node();

    void  update(Node node, int lc, int rc, int l, int r ) {
        if (l <= lc && rc <= r) {
            node.add += 1;
            node.val += 1 ;
            ans= Math.max(ans, node.val);
            return ;
        }
        pushdown(node);
        int mid = lc + rc >> 1;

        if (l <= mid)    update(node.ls, lc, mid, l, r);
        if (r > mid) update(node.rs, mid + 1, rc, l, r);
        pushup(node);  ///---------------------------------回收分支，更新根节点
    }
    void pushdown(Node node) {
        if (node.ls == null) node.ls = new Node();
        if (node.rs == null) node.rs = new Node();
        if (node.add == 0) return ;
        node.ls.add += node.add; node.rs.add += node.add;
        node.ls.val += node.add; node.rs.val += node.add;
        node.add = 0;
    }
    void pushup(Node node) {
        node.val = Math.max(node.ls.val, node.rs.val);
    }

    public MyCalendarThree() {

    }

    public int book(int start, int end) {
        update(root,0,N,start,end);
        return  ans;
    }

}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */