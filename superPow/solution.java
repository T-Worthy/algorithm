package superPow;

import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public int superPow(int a, int[] b) {
        if (a == 1) return 1;
        a = a % 1337;
        int n = b.length;
        int ans = a;
        if (n < 2) {
            for (int i = 0; i < b[0]-1; i++)
                ans = (ans * a) % 1337;
            return ans;
        }

        int m1=a;
        int m2=1;
        StringBuffer sb=new StringBuffer();
        for (int i = 0 ; i <n  ;i++)
            sb.append(b[i]);
        String SB =sb.toString();


        BigInteger B, two, zero;
        B = new BigInteger(SB);
        two = new BigInteger("2");
        zero = BigInteger.ZERO;

        while (!B.equals(BigInteger.ONE)) {
          //  System.out.println("m1:"+m1+"  b: "+B.toString());
            if(B.mod(two).equals(zero)){
                B=B.divide(two);
                m1=(m1*m1)%1337;
            }
            else {
                B=B.subtract(BigInteger.ONE);
                m2=(m2*m1)%1337;
            }
        }
        return (m1*m2)%1337;
    }

    public static void main(String[] args) throws Exception {
        BigInteger B = new BigInteger("122364598749848");
        BigInteger two = new BigInteger("2");
        BigInteger zero = BigInteger.ZERO;

        Solution s=new Solution();
        int a = 2147483647;
        int [] b = {2,0,0};

        System.out.println(Arrays.toString(b));
        System.out.println(s.superPow(a,b));


    }

}


