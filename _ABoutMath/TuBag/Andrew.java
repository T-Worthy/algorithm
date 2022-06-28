package _ABoutMath.TuBag;

import java.util.*;

public class Andrew {

      public boolean IsClock(int a[] ,int b [],int c[]){
             int x[] = {b[0]-a[0],b[1]-a[1]};
             int y[] = {c[0]-a[0],c[1]-a[1]};
             return  (x[0]*y[1]-x[1]*y[0])<0;
      }

      public int[][] outerTrees(int[][] trees) {
          Arrays.sort(trees, new Comparator<int[]>() {
              @Override
              public int compare(int[] o1, int[] o2) {
                  return o1[0]-o2[0];
              }
          });

          Stack<int [] > sta = new Stack<>();


          Set<int[]> set = new HashSet<>();

          for(int [] tree : trees){
               if(sta.size()<2) {  sta.push(tree); continue;}
              int [] b = sta.pop();
               while( IsClock(sta.peek(),b,tree ) ) { b = sta.pop(); }
              sta.push(b);sta.push(tree);
          }
          System.out.println(sta);
          for(int[] tr : sta)  set.add(tr);

          sta = new Stack<>();

          for (int i = trees.length-1; i >=0 ; i--) {
              if(sta.size()<2) {  sta.push(trees[i]); continue;}
              int [] b = sta.pop();
              while( IsClock(sta.peek(),b,trees[i] ) ) { b = sta.pop(); }
              sta.push(b);sta.push(trees[i]);
          }
          System.out.println(sta);
          for(int[] tr : sta)  set.add(tr);


          int [][] ans= new int[set.size()][2]; int ind=0;
          for(int [] tr : set){
              ans[ind][0]=tr[0];
              ans[ind][1]=tr[1];
              ind++;
          }

          return ans;
      }
}
