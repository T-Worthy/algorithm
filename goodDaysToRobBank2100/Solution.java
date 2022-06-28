package goodDaysToRobBank2100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void printArray(boolean[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }


    public List<Integer> goodDaysToRobBank(int[] security, int time) {
                     List<Integer>  ans =new ArrayList<Integer>();
                     int n= security.length;
                     boolean [] downLR = new boolean [n];
                     boolean [] downRL = new boolean [n];

                     if(time==0){
                         for(int i = 0;i < n;i++){
                             ans.add(i);
                         }
                      return ans;
                     }

                    int  startDown=time;
                     //见擦汗两遍，递减
                     for(int i =0; i< n-1 ;i++){
                         int temp =  security[i+1]-security[i];
                         if(temp>0){  //上升
                             startDown=time;
                         }
                         else {//下降
                             startDown--;
                             if(startDown<=0)  downLR[i+1]=true;
                         }
                     }
                      startDown=time;
                        for(int i =n-2; i>-1 ;i--){
                            int temp =  security[i]-security[i+1];
                            if(temp>0){  //上升
                                startDown=time;
                            }
                            else {//下降
                                startDown--;
                                if(startDown<=0)  downRL[i]=true;
                            }
                        }
                        printArray(downLR);printArray(downRL);
                        for (int i = 0 ; i< n ;i++){
                            if(downLR[i]&& downRL[i]) ans.add(i);
                        }

                     return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution s= new Solution();

       int[] a={1,1,1,1};
        System.out.println(s.goodDaysToRobBank(a,0));
    }

}