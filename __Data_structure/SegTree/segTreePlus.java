
class RangeModule { //动态开点进阶版线段树 删除版阔删除
    int N = (int)1e9+1; //圈定的最大区间重点
    class Node {
        // ls 和 rs 分别代表当前区间的左右子节点
        Node ls, rs;
        // val 代表当前区间的最大高度，add 为懒标记
        int val, add;
    }


    Node root = new Node();//  ----总跟

    void update(Node node, int lc, int rc, int l, int r, int v) {
        //
        if (l <= lc && rc <= r) {

            node.val = v == 1 ?  rc - lc + 1 : 0;
            node.add = v;
            return ;
        }
        pushdown(node, rc - lc + 1);
        int mid = (lc + rc )>> 1;
        if (l <= mid) update(node.ls, lc, mid, l, r, v);
        if (r > mid) update(node.rs, mid + 1, rc, l, r, v);
        pushup(node);

    }
    int query(Node node, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return node.val;
        pushdown(node, rc - lc + 1);
        int mid = (lc + rc) >> 1, ans = 0;
        if (l <= mid) ans = query(node.ls, lc, mid, l, r);
        if (r > mid) ans +=  query(node.rs, mid + 1, rc, l, r);
        return ans;
    }
    void pushdown(Node node,int len ) {
        if (node.ls == null) node.ls = new Node();
        if (node.rs == null) node.rs = new Node();
        if (node.add == 0) return ;
        node.ls.add = node.rs.add= node.add;
        if (node.add == -1) {
            node.ls.val = node.rs.val = 0;
        } else {
            node.ls.val = len - len / 2;
            node.rs.val = len / 2;
        }
        node.add = 0;

    }
    void pushup(Node node) {
        node.val = node.ls.val+ node.rs.val;

    }
    public RangeModule() {

    }

    public void addRange(int left, int right) {
        update (root,1,N,left,right-1,1);
    }

    public boolean queryRange(int left, int right) {
        int ss=query(root,1,N,left,right-1);
        //  System.out.println("QUW: "+left+","+ (right-1)+":  :  "+ss);
        return ss==(right-left);
    }

    public void removeRange(int left, int right) {
        update (root,1,N,left,right-1,-1);
    }


}


