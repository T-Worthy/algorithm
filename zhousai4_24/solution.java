package zhousai4_24;

import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
    int change(int x, int y ){
        return  1000*x+y;
    }


    public int[] countRectangles(int[][] rectangles, int[][] points) {
                  int n = rectangles.length;
                  int m = points.length;
                  int [] ans = new  int [m];
                 int [][]RR = new int[n+m][4];
                 int ind=0;
                 for(int i [] : rectangles){
                      RR[ind][0]= i[0];
                     RR[ind][1]= i[1];
                     RR[ind][2]= 1;
                     ind++;
                 }
                for (int i = 0; i < points.length; i++) {
                    RR[ind][0]= points[i][0];
                    RR[ind][1]= points[i][1];
                    RR[ind][3]=i;
                    ind++;
                }

                Arrays.sort(RR, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[0]==o2[0] && o1[1]==o2[1]) return o1[2]-o2[2];
                       if(o1[0]>=o2[0] && o1[1]>=o2[1]) return 1;
                       return -1;

                    }
                });

                int recNum=0;
        for (int i = n+m-1; i >=0 ; i--) {
              if(RR[i][2]==1) recNum++;
              else {
                  ans[RR[i][3]]=recNum;
              }
        }

            return  ans;
    }

    public static void main(String[] args) {
        Solution s= new Solution();

    }

}