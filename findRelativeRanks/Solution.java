package findRelativeRanks;

import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        String[] rank = {"Gold Medal", "Silver Medal", "Bronze Medal" };
        int n = score.length;
        String ans[] = new String[n];
        if (n <= 1) return new String[]{rank[0]};


        for (int i = 0; i < n; i++) {
            dic.put(score[i],i);
        }

        Arrays.sort(score);

        for(int i=0; i<n ;i++){
            int p = dic.get(score[n-1-i]);
            if(i<3) ans[p]=rank[i];
            else  ans[p]=""+(i+1);
        }
       return ans;
    }


    public String[] findRelativeRanks1(int[] score) {
        String[] rank ={"Gold Medal","Silver Medal","Bronze Medal"};
        int n= score.length;
        String ans[] =  new String[n];
        if(n<=1) return new String[]{rank[0]};

        for (int i =0 ; i<n ;i++) {
            int maxindex = i;
            for (int j = 0; j < n; j++){
                if (score[j] > score[maxindex])
                    maxindex = j;
            }
            if(i<3){
                ans[maxindex]=rank[i];
            }
            else{
                ans[maxindex]=""+(i+1);
            }
             score[maxindex] = -1;
        }
        return  ans;
    }

    public static void main(String [] a){
        Solution s =new Solution();
        int []sc ={1,2};
        String ss[]=s.findRelativeRanks(sc);
        for (String k : ss) System.out.print(k+" ,");  System.out.println();

    }
}
