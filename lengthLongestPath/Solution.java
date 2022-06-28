package lengthLongestPath;

import java.util.*;



class Solution {

    int [][] best,visted,visted2;
    String[] MM;
    int n,m; Queue<int []> que;
    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        n =matrix.length;
        m = matrix[0].length();
        MM=matrix;
        best= new int[n][m];
        visted= new int[n][m];
        visted2=new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                best[i][j]=999999;
            }
        }
        int lastDic=0;
        best[end[0]][end[1]]=0;
        que = new ArrayDeque<>();
        que.offer(new int[]{end[0],end[1],0,0});
        while(!que.isEmpty()){
            int [] tp = que.poll();
            int i =tp[0],j=tp[1],val= tp[2];
            if(visted2[i][j]>0) continue;
            best[i][j]=Math.min(best[i][j],val);

            visted2[i][j]++;
            search(i,j,best[i][j]);



            if(i>0 ){  que.offer(new int[]{i-1,j,val+1});}
            if(j>0 ){  que.offer(new int[]{i,j-1,val+1});}
            if(i<n-1 ){ que.offer(new int[]{i+1,j,val+1});}
            if(j<m-1  ){  que.offer(new int[]{i,j+1,val+1});}
            printArray (best);    System.out.println("-----------------------------------------------");
            printArray (visted);    System.out.println("-----------------------------------------------VVISS");
        }


        printArray (best);    System.out.println("-----------------------------------------------");


        return  best[start[0]][start[1]];

    }

    void search(int i ,int j, int lastVal ){

        if(visted[i][j]>0)  return;

        visted[i][j]++;

        if(i>0 ){ if( MM[i-1].charAt(j)=='v' ) {que.offer(new int[]{i-1,j,lastVal});  best[i-1][j]=lastVal; search(i-1,j,lastVal);} }
        if(j>0 ){ if( MM[i].charAt(j-1)=='>' ) {  que.offer(new int[]{i,j-1,lastVal});   best[i][j-1]=lastVal;search(i,j-1,lastVal);}}
        if(i<n-1 ){ if( MM[i+1].charAt(j)=='^' ){ que.offer(new int[]{i+1,j,lastVal});   best[i+1][j]=lastVal;search(i+1,j,lastVal);}}
        if(j<m-1 ){ if( MM[i].charAt(j+1)=='<' ){  que.offer(new int[]{i,j+1,lastVal});   best[i][j+1]=lastVal;search(i,j+1,lastVal);}}
    }



    public static void printArray(int[][] b){
        System.out.print("[");
        for(int [] a:b) {
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + ",");
            System.out.println("]");
        }
    }

}