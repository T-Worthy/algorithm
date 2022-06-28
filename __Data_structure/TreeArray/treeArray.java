package __Data_structure.TreeArray;

public class treeArray {

    // 上来先把三个方法写出来

        int[] nums;
        int[] tree;
        public int n;
        int lowbit(int x) {
        return x & -x;
    }
        // 查询前缀和的方法
     public   int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i) ) ans += tree[i];
        return ans;
    }
        // 在树状数组 x 位置中增加值 u
        public   void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }


    // 初始化「树状数组」，要默认数组是从 1 开始
    treeArray(int p[])
    {
        nums=p; n =p.length;tree=new int [n+1];
        for (int i = 0; i < n; i++) add(i + 1, nums[i]);
    }

    // 使用「树状数组」：

    public   void update ( int i, int val){
        // 原有的值是 nums[i]，要使得修改为 val，需要增加 val - nums[i]
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public  Integer getN (){
            return n;
    }

    public  int sumRange ( int l, int r){
        return query(r + 1) - query(l);
    }






}
