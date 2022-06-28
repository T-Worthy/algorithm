package platesBetweenCandles2055;

public class Solution1 {

    public static void printArray(int[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int  n = s.length();
        char []  cArr =s.toCharArray();
        int [] ans=new int[queries.length];
          int xingnum [] =new int[n];
          int  backnum[] =new int[n];
           int xing=0;
         int lastxing=0;

          for(int i = 0 ;i< n;i++){
              if(cArr[i]=='*') {xing++;  xingnum[i]=-lastxing;}
              else { xingnum[lastxing=i]=xing;}
          }
           lastxing=0;
          for(int  i = n-1;i>=0;i--){
              if(xingnum[i]>0) lastxing=i;
              else  {backnum[i]=-lastxing; }
          }

  printArray(xingnum);printArray(backnum);
  int left,right;
        for(int i = 0 ;i< queries.length;i++){
             left =queries[i][0];right= queries[i][1];

            if (right-left<2) {ans[i]=0;continue;}
            if(cArr[left]=='*') left=-backnum[left];
            if(cArr[right]=='*') right=-xingnum[right];

            if (right-left<2) {ans[i]=0;continue;}
            else  ans[i]=xingnum[right]-xingnum[left];
        }
  return  ans;
    }

    public static void main(String[] args) throws Exception {
        Solution1 s= new Solution1();

        int[] q[]= {{3,3}};
        String sp = "|*|*";
        int [] and=s.platesBetweenCandles(sp,q);
        for (int i : and){
            System.out.print(i +"  、 ");

        }
    }

}
