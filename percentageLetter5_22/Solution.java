package percentageLetter5_22;

import java.util.Arrays;
import java.util.Comparator;


public class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;

        int mod = 10^9+7;
        int min_left[]= new int[n];
        int min_right[] = new int[n];

        for (int i = 0; i < n; i++) {
            int next_min =i;  int next_min2 =i;
            while(next_min<n && strength[next_min]>= strength[i] ) next_min++;
            while(next_min2>=0 && strength[next_min2]>= strength[i] ) next_min2--;
            if(next_min>n-1) next_min=n-1; if(next_min2<0) next_min2=0;
            min_right[i]=next_min;
            min_left[i]=next_min2;
        }


        var s = new int[n + 1]; // 前缀和
        for (var i = 0; i < n; ++i) s[i + 1] = (s[i] + strength[i]) % mod;
        var ss = new int[n + 2]; // 前缀和的前缀和
        for (var i = 0; i <= n; ++i) ss[i + 1] = (ss[i] + s[i]) % mod;

        long ans = 0;
        for (var i = 0; i < n; ++i) {
            int l = min_left[i] + 1, r = min_right[i] - 1; // [l,r] 左闭右闭
            System.out.println(l+""+r);
            var tot = ((long) (i - l + 1) * (ss[r + 2] - ss[i + 1]) - (long) (r - i + 1) * (ss[i + 1] - ss[l])) % mod;
            ans = (ans + strength[i] * tot) % mod; // 累加贡献
        }
        return (int) (ans + mod) % mod; // 防止算出负数（因为上面算 tot 有个减法）

    }
}