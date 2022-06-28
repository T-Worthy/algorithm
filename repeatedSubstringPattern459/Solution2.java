package repeatedSubstringPattern459;

public class Solution2 {

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
                while(j!=-1){
                    nodeNum[parents[j]]+=nodeNum[j]+1;
                }
            }
        printArray(nodeNum);


        return  ans;


    }
}
