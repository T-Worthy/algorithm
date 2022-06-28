package isNStraightHand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
          int n =hand.length;
          if(n%groupSize!=0) return false;

        Arrays.sort(hand);
        List<Integer> list =new ArrayList<>();

        int nowNUM=1,theH=hand[0],index=0;
        for (int i =1 ;i< n;i++){
            if(hand[i]==theH) nowNUM++;
            else { theH=hand[i];list.add(nowNUM);nowNUM=1;  if(hand[i-1]+1!=hand[i]) list.add(0);   }
        }
        list.add(nowNUM);
        int n2=list.size();
        Integer[] haha=  new Integer[n2];                ///---------------转数组
        list.toArray(haha);


        for(int i =0;i< list.size();i++){
           for (Integer k : haha)   System.out.print(k+" , "); System.out.println();

            if(haha[i]==0 ) continue;
            if(haha[i]<0 || i+groupSize-1 >= n2) return false;

            for (int p =0, num=haha[i];p<groupSize;p++){
                haha[i+p]-=num;
            }

        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        int []a = {1,2,3,6,2,3,4,7,8,1,2,3,5,6,8};
        System.out.println(s.isNStraightHand(a,3));
    }
}