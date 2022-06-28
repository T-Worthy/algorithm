package __Data_structure.SegTree;

public class segTree {


    public int [] tree  ,nums; public int n ;
    public int [] lazy;

    public segTree(int[] p){  //初始化构造
        nums=p;
        n= p.length;
        tree= new int[2*n+2];
        lazy= new int[2*n+2];//记录该区间的修改
        bulid(0,0,n-1);
    }
     int  handle(int le ,int ri){  //处理函数： 最值 / 求和----
        return  le+ri;
    }
    void bulid(int tr_pos, int l, int r){    //初始数组构造 线段树
           if(l==r) {tree[tr_pos]=nums[l]; }
           else {
               int m =(l+r)>>1;
               int left_node=tr_pos<<1|1,right_node=(tr_pos+1)<<1;
               bulid(left_node, l, m );
               bulid(right_node,m+1,r);
               tree[tr_pos]=handle(tree[left_node],tree[right_node]);
           }
    }


   public void updata(int idx, int val){
          _updataOne(0,0,n-1,idx,val);
    }
    void updata(int idx_l,int idx_r, int val){
         _updataSeg( 0, 0, n-1, idx_l, idx_r,  val);
    }

        //递归方式更新; 单点修改
    void _updataOne(int tr_pos,int l,int r,int idx, int val){    //tr_pos为下标，val为修改后的值，l，r为结点区间，k为结点下标  idx修改下表
        if(l == r){    //左端点等于右端点，即为叶子结点，直接加上v即可
            nums[idx] = val;  tree[tr_pos] = val;}
        else{
            int m =(l+r)>>1;
            int left_node=tr_pos<<1|1,right_node=(tr_pos+1)<<1;
            if(idx<=m)
                _updataOne(left_node, l, m ,idx,val);
            else
                _updataOne(right_node,m+1,r,idx,val);
            tree[tr_pos]=handle(tree[left_node],tree[right_node]);
        }
    }
    void _updataSeg(int tr_pos,int l,int r,int idx_l,int idx_r, int val){
        if( (idx_l<=l && r<=idx_r)|| (l==r) )    //如果当前结点的区间真包含于要查询的区间内，则返回结点信息且不需要往下递归
        {
            lazy[tr_pos]+=val;  return;
        }
        else{
            if(idx_r<l || r< idx_l) return;
            int m =(l+r)>>1;
            int left_node=tr_pos<<1|1,right_node=(tr_pos+1)<<1;
            _updataSeg(left_node, l, m , idx_l, idx_r ,val );
            _updataSeg(right_node, m+1, r ,idx_l ,idx_r,val);
        }

    }


    public int  query(int l ,int r){
        return _query(0,0,n-1,l,r);
    }

     int _query(int tr_pos,int l,int r,int q_l ,int q_r){    //[L,R]即为要查询的区间，l，r为结点区间，k为结点下标
          System.out.println(l+","+r+":: "+tree[tr_pos]);
         if(lazy[tr_pos]!=0) {tree[tr_pos]+=lazy[tr_pos]*(r-l+1);}

         if(q_r<l || r< q_l ) return 0;

        if( (q_l<=l&& r<=q_r) )    //如果当前结点的区间真包含于要查询的区间内，则返回结点信息且不需要往下递归
        {
            lazy[tr_pos]=0;
            return tree[tr_pos];
        }
            int m =(l+r)>>1;
            int left_node=tr_pos<<1|1,right_node=(tr_pos+1)<<1;
            lazy[right_node]+=lazy[tr_pos]; lazy[left_node]+=lazy[tr_pos]; lazy[tr_pos]=0;
            System.out.println(l+","+r+":: "+tree[tr_pos]+"RETURN "+_query(left_node, l, m , q_l, q_r  )+" + "+_query(right_node, m+1, r ,q_l ,q_r));
            return handle (_query(left_node, l, m , q_l, q_r  ),_query(right_node, m+1, r ,q_l ,q_r));    //返回当前结点得到的信息
    }
}
