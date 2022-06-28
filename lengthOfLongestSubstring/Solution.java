package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map =new HashMap<>();
        int n = s.length();
        if(n==1) return 1;
        int MAX=0,nowLen=0;
        for(int i =0;i< n ;i++ ){
            char c= s.charAt(i);

            if(map.containsKey(c)) {   i = map.get(c)+1;   map.clear();   MAX =Math.max(MAX,nowLen);nowLen=0;}
            else{map.put(c,i);  nowLen++;}
        }
        MAX =Math.max(MAX,nowLen);
        return MAX;
    }
}