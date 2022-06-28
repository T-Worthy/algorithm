package __Data_structure.SegTree;

import __Data_structure.SegTree.segTree;

import java.util.Arrays;


public class ttt {

    public  int one(int i ){
        int ans =0;
        while(i>0){
            if(i%2==1) ans++;
            i/=2;
        }
        return  ans;
    }


    public static void main(String[] args) throws Exception {

          int a[] ={1,3,5,7,9,11};
          segTree tr =new segTree(a);

          int pp[]= tr.tree;
        Arrays.stream(pp).forEach(e->System.out.print(e+" ,"));System.out.println();

       // tr.updataSeg(0,0,tr.n,0,2,-1);
       // Arrays.stream(tr.tree).forEach(e->System.out.print(e+" ,"));System.out.println();

       System.out.println(tr.query(0,3));
       // System.out.println(10^1);








    }
}
