package maxConsecutiveAnswers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        int  n= answerKey.length();
        if(k>=n-1) return n;
        if(n<2) return n;
     //   Map<Integer,List<Integer>> indexMap =new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);

         int num=1;
         boolean last =(answerKey.charAt(0)=='T');
        for(int i =1 ;i< n;i++){
             if( (last  ^ answerKey.charAt(i)=='T') ){
                 last =(answerKey.charAt(i)=='T');
                 list.add(num);
                 num=1;
             }
             else
                 num++;
        }
        list.add(num);

        int m = list.size();

        if(m==2) return n;


        int MAX=0;
        int tk,j,next;


        for(int i = 0 ; i< m-1 ;i++){
            int nowSum =list.get(i);
            tk=k; j=i+1;//next=list.get(j);
            while(tk>0 && j< m){
                next=list.get(j);  System.out.println("nowSum： "+nowSum+"  next: "+next+" tk: "+tk +"  --MAX"+MAX);
                  if(tk>= next) {
                      nowSum+=next; tk-=next;
                      if(j+1<m ) { nowSum+=list.get(j+1);j++;}

                  }
                  else {
                      nowSum+= tk; tk=0; break;
                  }
                j++;
            }
            if(tk!= 0) nowSum+=tk;//----
            nowSum =Math.min(nowSum,n);
            MAX=Math.max(MAX,nowSum);
        }
        System.out.println(list);
        return  MAX;
    }


    public static void main(String[] args) throws Exception {
        boolean a=true, b=true;
        Solution s  = new Solution();
        System.out.println(s.maxConsecutiveAnswers("FFFTTFTTFT"
                ,3));

        System.out.println(!(a^b));
    }
}