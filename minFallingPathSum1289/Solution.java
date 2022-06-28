package minFallingPathSum1289;
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if(n==1) return grid[0][0];
        if(n==2 ) return Math.min(grid[0][0]+grid[1][1],grid[0][1]+grid[1][0]);
        int [][]  B = new int [n][2];
        for(int i =0;i< n;i++){
            if(grid[i][0]<grid[i][1]) B[i][1]=1;
            else     B[i][0]=1;
            for(int j = 2 ; j< n ;j++){
                if(grid[i][j]<grid[i][ B[i][0]  ]){ B[i][1]=B[i][0];B[i][0]=j;  }
                else if(grid[i][j]<   grid[i][ B[i][1]  ])   { B[i][1]=j;}
            }
        }
        printArray(B);
        int lastChoose=B[0][0];
        int a =grid[0][lastChoose];
        for(  int i =1;i<n ;i++ )
        {
            if(B[i][0]!=lastChoose) {lastChoose=B[i][0];a+= grid[i][lastChoose];}
            else  {lastChoose=B[i][1];a+= grid[i][lastChoose];}

        }
        lastChoose=B[0][1];
        int b =grid[0][lastChoose];
        for(  int i =1;i<n ;i++ )
        {
            if(B[i][0]!=lastChoose) {lastChoose=B[i][0];b+= grid[i][lastChoose];}
            else  {lastChoose=B[i][1];b+= grid[i][lastChoose];}
        }

        System.out.println(a+"  ,  "+b);
        return a<b ? a:b;
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