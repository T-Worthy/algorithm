package findAndReplacePattern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    int patt[] ;int n;
public List<String> findAndReplacePattern(String[] words, String pattern) {
         int dic [] = new int[26];

          n = pattern.length();
         patt=new int[n];
         int index=1;
    for (int i = 0; i < n; i++) {
        int cha = pattern.charAt(i)-'a';
        if(dic[cha]==0) {dic[cha]=index; index++;}
        patt[i]= dic[cha];
    }
    List<String> ans = new LinkedList<>();
    for (String s :words){
        if(chack(s)) ans.add(s);
    }

    //System.out.println(Arrays.toString(patt));

    return  ans;
    }

    boolean chack(String ss){
        int dic [] = new int[26];
        int index=1;
        for (int i = 0; i < n; i++) {
            int cha = ss.charAt(i)-'a';
            if(dic[cha]==0) {dic[cha]=index; index++;}
           if( patt[i]!= dic[cha]) return false;
        }
        return  true;
    }

    public static void main(String[] args) {
        Solution  s = new Solution();
        System.out.println(s.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},   "abb"));
    }
}