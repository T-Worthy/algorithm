package repeatedSubstringPattern459;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean repeatedSubstringPattern(String s) {


        List<Integer> index= new ArrayList<>();
        char[] c= s.toCharArray();


        char A=c[0];
        int n = c.length;
        for (int i = 1; i<n;i++){
            if(c[i]==A) index.add(i);
        }

        int nearestA=index.get(0);
        for(int i = 1 ; i< nearestA;i++){
             A=c[i];
            for( int j : index){
                 if(c[j+i]!=A) { index.remove(j); if(index.size()==0) return false; }
             }
            nearestA=index.get(0);
        }
        return true;


    }
}