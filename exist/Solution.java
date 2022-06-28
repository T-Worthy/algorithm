package exist;

class Solution {
    char [] wor;
    boolean [][] fid;
    char[][] boar;
    int N ,n,m;
    public boolean exist(char[][] board, String word) {
            wor = word.toCharArray();   N= wor.length;
             n =board.length;
             m= board[0].length;
        fid= new boolean[n][m];
        boar=board;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                  if(board[i][j]==wor[0]){
                      fid[i][j]=true;
                      if(find(i,j,1)) return true;
                      fid[i][j]=false;
                  }
            }

        }
        return false;

    }
    boolean find(int i ,int j ,int index){
               if(index==N)  return true;
               //mei结束，搜索
        boolean ans =false;

              if(i>0 && fid[i-1][j]==false&& boar[i-1][j]==wor[index]){
                    fid[i-1][j]=true;
                   ans= ans|| find(i-1,j,index+1);
                    fid[i-1][j]=false;
              }
              if(j>0&& fid[i][j-1]==false&& boar[i][j-1]==wor[index]){
                  fid[i][j-1]=true;
                  ans= ans|| find(i,j-1,index+1);
                  fid[i][j-1]=false;
              }
              if(i<n-1&&   fid[i+1][j]==false &&boar[i+1][j]==wor[index]){
                  fid[i+1][j]=true;
                  ans= ans|| find(i+1,j,index+1);
                  fid[i+1][j]=false;
              }
              if(j<m-1&&  fid[i][j+1]==false &&  boar[i][j+1]==wor[index]){
                  fid[i][j+1]=true;
                  ans= ans|| find(i,j+1,index+1);
                  fid[i][j+1]=false;
              }
              return ans;
    }

    static  int shuw(int i){
        int ans =0;
        while (i>0){
            ans+=i%10;
            i/=10;
        }
        return ans;
    }
    public static void main(String[] args) {

        int val[]=new int [20];
        System.out.print("{");
        for (int i = 1; i <101 ; i++) {
            System.out.print(shuw(i)+" , ");

        }
        System.out.println("}");


      int n =16,m=8,k=4;
      int MM[][]= new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if( shuw(i)+shuw(j)<=k  ) MM[i][j]=1;
            }

        }
        printArray(MM);


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