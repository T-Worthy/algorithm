package _AAA.sad.money;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void printArray(int[][] b){
        System.out.print("[");
        for(int [] a:b) {
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + ",");
            System.out.println("]");
        }
    }
    public static void printArray(int[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }


    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int max = 0;
        if (k == 1) {
            for (List<Integer> li : piles) {
                if (li.get(0) > max) max = li.get(0);
            }
            return max;
        } else {

            int n = piles.size();
            int bag[][] = new int[k + 1][n];
            int i = 0;
            int tk ;

            //System.out.print(n+"  ??????????????????"+bag.length+"  , " +bag[0].length);

            for (int bagNum=0;  bagNum < n; bagNum++) {
                int sum = 0;
                for ( i=0;   i+1 <= k;  i++) {
                    sum += (i < piles.get(bagNum).size() ?  piles.get(bagNum).get(i) : 0);
                    bag[i+1][bagNum] = sum;
                }
            }



          //  printArray(bag);//----------
          //  printArray(ans);

            for (int bagNum=1;  bagNum < n; bagNum++) {
                tk=k;
                for (  ;          tk >0 ; tk--) {
                    int ti = 0;
                    while (tk-ti>=0  && ti< piles.get(bagNum).size()){

                        bag[tk][bagNum] = Math.max(  bag[tk-ti][bagNum-1] +  bag[ti][bagNum] , bag[tk][bagNum] );
                        ti++;
                    }

                }

             //   System.out.println ("-----------------------------------");
              //  printArray(ans);

            }

            return bag[k][n-1];
        }
    }

    public static void main(String[] args) throws Exception {
         List<List<Integer>>  aa = new ArrayList<>();
         List<Integer> a1= new ArrayList<>();
         List<Integer> a2=new ArrayList<>();
        List<Integer> a3=new ArrayList<>();
        List<Integer> a4=new ArrayList<>();
        List<Integer> a5=new ArrayList<>();
        List<Integer> a6=new ArrayList<>();
        // a1.add(1); a1.add(100); a1.add(3);
     //    a2.add(7); a2.add(8);a2.add(9);
        a1.add(100); a2.add(100); a3.add(100);
        a4.add(100);a5.add(100);a6.add(1);a6.add(1);a6.add(1);a6.add(1);a6.add(1);a6.add(1);a6.add(700);
        aa.add(a1); aa.add(a2);  aa.add(a3); aa.add(a4);  aa.add(a5); aa.add(a6);

         Solution s = new Solution();
         System.out.print(s.maxValueOfCoins(aa,7));
    }
}