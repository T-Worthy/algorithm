package platesBetweenCandles2055;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {

    public  static void   print (  List<int[]>  list ){
        System.out.print("{");
        for(int[] inrr : list){
            System.out.print("[");
            for (Integer i: inrr){
                System.out.print(i+",");
            }
            System.out.print("]");
        }
        System.out.println("}");

    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<int[]> minRange = new ArrayList<>();
        int begin = 0,end=0 ;
        int n = s.length();

        boolean flagBegin = false;
        int ans[] = new int[queries.length];

        for (int i =0; i<n ; ){
             if(flagBegin){
                 while( i<n   &&s.charAt(i)=='*'  ) i++;
                     if(i==n) break;
                     end=i;
                     minRange.add(new int[]{begin, end,end-begin-1});
                     flagBegin=false;
             }
             else {
                     while(i<n   &&s.charAt(i)!='|'  ) i++;
                     while (i<n   && s.charAt(i)=='|'    ) i++;
                    if(i==n) break;
                     flagBegin=true;
                     begin=i-1;
             }
        }

        int [][] arr=  minRange.toArray(new int[minRange.size()][]);



        //-------开始查询
        int nn= minRange.size();

        for(int i = 0 ;i< queries.length;i++){
            if(queries[i][1]-queries[i][0]<2) {ans[i]=0; continue;}
            int panzi = 0;
            int j=nn/2,jL =0,jR=nn-1;
            if(queries[i][0]> arr[nn-1][0] || queries[i][1]< arr[0][1]) {ans[i]=0; continue;}

          while (jL<jR )  //erfen
            if(queries[i][0]> arr[j][0]){jL=j+1; j=(jR+jL)/2;}
                else if(queries[i][0]< arr[j][0]){ jR =j-1;j=(jR+jL)/2;}
                else {break;}
//System.out.println("!!!!!!!!!!: "+i+ " jjjjjj: "+j);

            while (j<nn && queries[i][0]> arr[j][0]) j++;



                while (j<nn && queries[i][1]>=arr[j][1] ) {
                    panzi+= arr[j][2];
                    j++;
                }


            ans[i]=panzi;


        }
        print(minRange);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution s= new Solution();

        int[] q[]= {{1,17},{4,5},{14,17},{5,11},{15,16}};
        String sp = "***|**|*****|**||**|*";
        int [] and=s.platesBetweenCandles(sp,q);
        for (int i : and){
            System.out.print(i +"  、 ");

        }
    }
}