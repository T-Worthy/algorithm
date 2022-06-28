package countHighestScoreNodes2049;

public class Solution {
    public static void printArray(int[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        if(n<4) return 2;

        boolean ab[]= new boolean[n];

        int nodeNum [] =new int[n];

        for(int i =1;i< n ;i++)
            ab[parents[i]]=true;

        int ans=0,j=0;
        for( int i=0 ;i<n ;i++ )
            if(!ab[i]) {  //回溯遍历
                j=i;
                while(j!=0){
                    if(nodeNum[j]*nodeNum[parents[j]] ==0 )   nodeNum[parents[j]]+=nodeNum[j]+1;
                    else nodeNum[parents[j]]=nodeNum[j];
                    j=parents[j];
                    printArray(nodeNum);
                }
                nodeNum[0]=n-1;
            }
        printArray(nodeNum);


        return  ans;


    }


    public static void main(String[] args) throws Exception {
        Solution s =new Solution();
        int b[]= {0,1,2,3,4,5};
        printArray(b);
        int  [] a={-1,0,1,0,3,1,3};
        System.out.println(s.countHighestScoreNodes(a));
    }
}
