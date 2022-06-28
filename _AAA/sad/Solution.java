package _AAA.sad;

import javax.sound.sampled.AudioFormat;
import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int maxTrailingZeros(int[][] gr ){



        int n =gr.length;
        int m = gr[0].length;

        int [][][] grid= new  int[n][m][2];
        int two =0,five=0,tp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tp=gr[i][j];
                while(tp%2==0) {grid[i][j][0]++; tp/=2;}
                while(tp%5==0) {grid[i][j][1]++; tp/=5;}
                //   gr[i][j]=Math.min(grid[i][j][0],grid[i][j][1]);
            }
        }

        int up[][][] =new int[n][m][2];
        int down[][][] =new int[n][m][2];
        int right[][][] =new int[n][m][2];
        int left[][][] =new int[n][m][2];

        for (int i = 0; i < m; i++) {
            two=0; five=0;
            for (int j = n-1; j >=0 ; j--) {

                up[j][i][0]=two;
                up[j][i][1]=five;
                two+=grid[j][i][0];
                five+=grid[j][i][1];
            }
        }

        for (int i = 0; i < m; i++) {
            two=0; five=0;
            for (int j = 0; j < n ; j++) {

                down[j][i][0]=two;
                down[j][i][1]=five;
                two+=grid[j][i][0];
                five+=grid[j][i][1];

            }
        }

        for (int i = 0; i < n; i++) {
            two=0; five=0;
            for (int j = 0; j < m; j++) {

                right[i][j][0]=two;
                right[i][j][1]=five;
                two+=grid[i][j][0];
                five+=grid[i][j][1];
            }

        }

        for (int i = 0; i < n; i++) {
            two=0; five=0;
            for (int j = m-1; j >=0; j--) {

                left[i][j][0]=two;
                left[i][j][1]=five;
                two+=grid[i][j][0];
                five+=grid[i][j][1];

            }
        }

        printArray(grid); System.out.println("-------------------------------");

        printArray(up); System.out.println("-------------------------------");
        printArray(down); System.out.println("-------------------------------");
        printArray(right); System.out.println("-------------------------------");
        printArray(left);







        int ans=0;  int LD,LU,RU,RD;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                RU= Math.min(  right[i][j][0] +grid[i][j][0]+up[i][j][0]  ,grid[i][j][1]+   right[i][j][1]+up[i][j][1]);
                RD= Math.min(grid[i][j][0]+right[i][j][0]+down[i][j][0],   grid[i][j][1] +right[i][j][1]+   down[i][j][1]);
                LU= Math.min(grid[i][j][0]+left[i][j][0]+up[i][j][0],   grid[i][j][1] + left[i][j][1]+   up[i][j][1]);
                LD= Math.min(grid[i][j][0]+left[i][j][0]+down[i][j][0] , grid[i][j][1] +    left[i][j][1]+down[i][j][0]);

                int tp1 = Math.max( RU ,RD  );
                int tp2=Math.max(LU,LD);
                tp=Math.max(tp1,tp2);
                if(tp>ans) System.out.println(i+" , "+j +" , "+RU+"  , "+RD+" , "+LU+" , "+LD);
                ans=Math.max(tp,ans);
            }
        }
        return  ans;
    }


    public static void printArray(int[][][] b){
        System.out.print("{");
        for(int [][] a:b) {
            for (int i = 0; i < a.length; i++)
                System.out.print( "["+a[i][0] + ","+a[i][1]+"] ;");
            System.out.println("}");
        }
    }






    public static void printArray(int[][] b){
        System.out.print("[");
        for(int [] a:b) {
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + ",");
            System.out.println("]");
        }
    }


    public static void main(String[] args) {

        Solution s =new Solution();



    }


}