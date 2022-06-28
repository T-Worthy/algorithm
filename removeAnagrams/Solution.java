package removeAnagrams;

import java.util.*;



class Solution {
    public static void main(String[] args) {
         List<Integer> lista= new ArrayList<>();
    }
}



class CountIntervals {

    class  tree{
        boolean isleaf;
        int min,max;
        tree t1,t2;
        public  tree(int a ,int b,boolean bb){
            min=a;max=b; isleaf=bb;
        }

    }

    tree root;
    public CountIntervals() {
           root=new tree(-1,-1,false);
    }
    public void add(int left, int right) {
        if(root.min==-1 || ( left<= root.min && root.max<= right)) {root.min=left;root.max=right;root.t1= new tree(left,right,true);return;}

        if(root.max < left){tree pt= root; root=new tree(pt.min,right,false); root.t1=pt; root.t2= new tree(left,right,true); return; }
        if(right< root.min){tree pt= root; root=new tree(left,pt.max,false); root.t2=pt; root.t1= new tree(left,right,true); return; }

        LinkedList<Integer> li = new LinkedList<>();

    }


}