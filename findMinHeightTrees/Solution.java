package findMinHeightTrees;


import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      //  int [] conNum = new int[n];

        Set<Integer>[] con =new Set[n];
        Queue<Integer> teDel = new ArrayDeque<>();
        Set<Integer>  ansSet = new HashSet<>();

        for(int i =0;i< n ;i++){
            con[i]=new HashSet<>();
            ansSet.add(i);

        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0;i< n-1 ;i++){
            con[edges[i][0]].add(edges[i][1]); con[edges[i][1]].add(edges[i][0]);
        }

        int needNum=n-1;
        while(ansSet.size()>1 && needNum >0){
            System.out.println(needNum);
            int tNum =needNum;
            for(int i : ansSet ){
                if(con[i].size()==tNum)  {ans.add(i);}
                if(con[i].size()==1) teDel.offer(i);
            }
            if(!ans.isEmpty()) return ans;
             while(!teDel.isEmpty()){ int k = teDel.poll();  for(int j : con[k]) con[j].remove(k); ansSet.remove(k); needNum--;}
        }
        for(int i : ansSet )  ans.add(i);
        return  ans;
    }
}