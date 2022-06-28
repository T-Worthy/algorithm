package findLUSlength;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    int[][] dic;
    public  boolean contain(int i ,int  j){
        for (int k = 0; k < 26; k++) {
            if(dic[i][k]-dic[j][k]>0) continue;
            else  return false;
        }
        return  true;
    }

    public int findLUSlength(String[] strs) {
        int n =strs.length;
         dic = new  int [n][26];

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                dic[i][  strs[i].charAt(j)-'a'   ]++;
            }
        }

        int len = strs[0].length();
        int i =0;

        for (int j = 0; j < n; j++) {
            if(strs[j].length()!=len){
                for (int k = i; k < j; k++) {  //check_ s[k] ?
                    boolean is_one=true;
                        for (int l =0; l < j; l++) {

                          if( (l>k && strs[k].equals(strs[l]))  || ((l<k ) && contain( l,k )) ) {
                              is_one=false;
                              break;
                          }
                          if(is_one) return  len;
                    }
                }

                i=j;
                len =strs[j].length();

            }

        }

        return  -1;


    }
}