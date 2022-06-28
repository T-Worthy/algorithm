package cutOffTree;

import java.util.*;
class Solution {
    boolean visited[][];
    Map<Integer,int[]> treeMap;
     int DiS;
    int n,m;
    int map[][];
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest.get(0).get(0)==0) return -1;
        n = forest.size();
        m= forest.get(0).size();


        map = new int[n][m];
        List<Integer> tree = new LinkedList<>();
        treeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tp = forest.get(i);
            for (int j = 0; j < tp.size(); j++) {
                map[i][j]=tp.get(j);
                if(tp.get(j)>1)tree.add(tp.get(j));
                treeMap.put(tp.get(j),new int[]{i,j} );
            }
        }

        visited= new boolean[n][m];
        tree.sort(Integer::compareTo);


        int ans=0;
        int []p1={0,0};
        int p2[]={0,0};


        boolean isSec=true;
        for (int i = 0; i < tree.size(); i++) {
            int [] theTree= treeMap.get(tree.get(i));
            if(isSec) p2=theTree;
            else p1=theTree;
            if(i==0&&p2[0]==0&&p2[1]==0) {isSec=!isSec; continue;}
            System.out.println("DIS="+p1[0]+","+p1[1]+"=>" +p2[0]+","+p2[1]+"==>"+DiS);
            DiS=-1;  visited= new boolean[n][m];
            search(p1[0],p1[1],p2[0],p2[1],0);
            int dis =DiS;
            if(dis==-1) return -1;
            ans+=dis;
            isSec=!isSec;
        }



        return  ans==0?-1:ans;
    }


    void   search(int x, int y ,int tarI,int tarJ,int dis){

        Queue<int []> que  =new LinkedList<>();
        que.add(new int[]{x,y});

        while (!que.isEmpty()){
             int pp[]= que.poll(); int i =pp[0], j=pp[1];
            if(i<0||j<0||i==n||j==m|| map[i][j]==0|| visited[i][j]) continue;
            if(i==tarI && j==tarJ) {DiS=dis;return;}
            visited[i][j]=true;
            que.add(new int[]{i+1,j});
            que.add(new int[]{i,j+1});
            que.add(new int[]{i-1,j});
            que.add(new int[]{i,j-1});

        }

    }
}