package maximumBobPoints;
class Solution {
   int MAXSOCRE=0;
   int maxAns[];
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
               DO(11,numArrows,aliceArrows,0,new int[12]);
               System.out.println(MAXSOCRE);
               return  maxAns;
    }

    public  void DO(int deep, int numArr , int alice [],int nowScore,int []nowChoose){
       // printArray(nowChoose); System.out.println(numArr);
        if(deep==0 || numArr<=0 )  {  //--wanshi

             if(nowScore> MAXSOCRE){

                 if(numArr!=0) nowChoose[0]=numArr;
                 MAXSOCRE=nowScore;
                  maxAns=nowChoose;
             }
             return;
        }
 if(numArr>= alice[deep]+1) {
     int [] nowC=nowChoose.clone();
     nowC[deep]=alice[deep]+1;
     DO(deep - 1, numArr - alice[deep]-1, alice, nowScore + deep, nowC);
 }
        int [] nowC2=nowChoose.clone();
        DO(deep-1,numArr,alice,nowScore,nowC2);

    }

    public static void main(String[] args) throws Exception {
        Solution s= new Solution();

        int [] pp={0,0,1,1,2,1,0,0,0,0,1,0};
        int  c[]   =s.maximumBobPoints(6,pp);
        printArray(c);
    }
    public static void printArray(int[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }



}