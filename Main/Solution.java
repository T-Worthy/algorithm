package Main;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public  boolean  findSubString(String s1, String s2){
           int n = s1.length();
           int m =s2.length();
           if(m>n) return  false;
           if(s2.equals("") ) return  true;
           int [] wordDic= new int[26];

        for (int i = 0; i <m ; i++) {
               wordDic[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < n-m; i++) {
             int [] tp = wordDic.clone();
             int i2=i; int nowVal= m;
            for (int j = 0; j < m; j++,i2++) {
                   if(  tp[ s1.charAt(i2) -'a']>0 )
                   {tp[ s1.charAt(i2) -'a']--;
                     nowVal--;
                   }
            }
            if(nowVal==0) return  true;
        }
        return  false;


    }
    public static void main(String[] args) {
         Solution s= new Solution();

        System.out.println( s.findSubString("sadsjfhjh","adjss"));
    }
}
