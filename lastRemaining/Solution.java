package lastRemaining;

public class Solution {


        public int lastRemaining(int n) {
            int head = 1;
            int step = 1;
            boolean left = true;
            //int n = n;

            while (n > 1) {
                //从左边开始移除 or（从右边开始移除，数列总数为奇数）
                if (left || n % 2 != 0) {
                    head += step;
                }
                step *= 2; //步长 * 2
                left = !left; //取反移除方向
                n /= 2; //总数 / 2
            }

            return head;
        }

        public static void main(String[] args) throws Exception {
          Solution s =new Solution();
            for (int i = 1 ;i<100 ;i++)
                System.out.print(i+", ");
            System.out.println();
          for (int i = 1 ;i<100 ;i++)
          System.out.print(s.lastRemaining(i)+", ");
        }


}
