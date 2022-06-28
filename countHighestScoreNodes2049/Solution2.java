package countHighestScoreNodes2049;


public class Solution2 {



    public int countHighestScoreNodes(int[] parents) {

        int n = parents.length;
        if(n<4) return 2;
        boolean ab[]= new boolean[n];
        int nodeNum [] =new int[n];

        for(int i =1;i< n ;i++)
            ab[parents[i]]=true;


return 0;
    }


    public static void main(String[] args) throws Exception {
        Solution2 s =new Solution2();
        int b[]= {0,1,2,3,4,5};

        int  [] a={-1,0,1,0,3,1,3};
        System.out.println(s.countHighestScoreNodes(a));
    }
}
