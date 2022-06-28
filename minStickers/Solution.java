package minStickers;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int minStickers(String[] stickers, String target) {

        Map<Character ,Integer> tarMap=new HashMap<>();
        for (int i = 0; i <target.length() ; i++) {
            tarMap.put( target.charAt(i) ,tarMap.getOrDefault(target.charAt(i),0)+1);
        }

        int n = stickers.length;
        Map<Character,Integer> bagsMap[] = new Map[n];
        Set delSet =tarMap.keySet();
        System.out.println(tarMap);

        for (int i = 0; i < n; i++) {
             bagsMap[i]= new HashMap<>();
            for (int j = 0; j <stickers[i].length() ; j++) {
                if(tarMap.containsKey( stickers[i].charAt(j) ))
                {
                    delSet.remove(stickers[i].charAt(j) );
                    System.out.println(delSet);
                    bagsMap[i].put( stickers[i].charAt(j) ,bagsMap[i].getOrDefault(stickers[i].charAt(j),0)+1);
                }
            }
        }
            if(delSet.size()!=0) return  -1;

            Arrays.sort(bagsMap, new Comparator<Map<Character, Integer>>() {
                @Override
                public int compare(Map<Character, Integer> o1, Map<Character, Integer> o2) {
                    return o1.keySet().size()-o2.keySet().size();
                }
            });

            for (int j = 0; j < n; j++) {
                System.out.println(bagsMap[j]);
            }


          return 0;
    }

    public static void main(String[] args) {
        String[] s={"with","example","science"};
        String ta= "thehat";
        Solution ss = new Solution();
        System.out.println(ss.minStickers(s,ta));;
    }
}
