package distributeCandies;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
          int n= candyType.length;
          int type =0;
        Set<Integer> s = new HashSet<>();
        for (int i : candyType){
            if(!s.contains(i)){
                type++;
                if((n/2) < type) return (n/2);
                s.add(i);
            }
        }
        return  type;

    }
}