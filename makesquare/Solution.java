package makesquare;

import java.util.*;

class Solution {
    int a,b,c,d;
    int n,avg ;
    boolean ans;
    int []MM;
    public boolean makesquare(int[] matchsticks) {
        for(int i : matchsticks) avg+=i;
        MM=matchsticks;
        if (avg%4!=0) return false;
        avg/=4;

          n= matchsticks.length;
          a+=matchsticks[0];
          search(1);
          return  ans;
    }
    void search(int index){
        if(index>=n-1) {
            if(a==avg&& b==avg && c==avg) ans=true;
            return;
        }

        if(ans || a>avg||b>avg||c>avg||d>avg) return;
        a+=MM[index];
        search(index+1);
        a-=MM[index];

        b+=MM[index];
        search(index+1);
        b-=MM[index];

        c+=MM[index];
        search(index+1);
        c-=MM[index];

        d+=MM[index];
        search(index+1);
        d-=MM[index];

    }
}