package plusone;

import java.util.Arrays;

class Solution {

    public int[] plus(int [] digits, int l ){

        if(digits[l-1]!=9){
            digits[l-1]+=1;
            return digits;
        }
        else {
            digits[l-1]=0;
            plusOne(digits);
            if(l>1){
            return plus(digits,l-1);}
            return digits;
        }

    }
    public int[] plusOne(int[] digits) {
           if (digits==null){ return digits;}
           int l = digits.length;
            plus(digits,l);
            if(digits[0]==0){
                int[] p =new int[l+1];
                p[0]=1;
                System.arraycopy(digits,0,p,1,l);
                return p;
            }
            return digits;

    }
}

