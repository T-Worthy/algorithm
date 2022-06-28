package maxProfit121;

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length<2 ) return 0;
        int min =prices[0],max=0;
        for(int i =0 ;i<prices.length ;i++ ){
            Math.min(min,prices[i]);
            max=(Math.max(max,prices[i]-min));
        }
        return max;



    }
}