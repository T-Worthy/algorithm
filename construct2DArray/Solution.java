package construct2DArray;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {

        if (original.length != m * n) {
            return new int[0][0];
        }

        int[][] ans = new int[m][n];

        for (int i = 0 ;i< original.length;i++)
            ans[i/n][i%n]=original[i];

        return ans;

    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        int[] a = {1, 2, 3, 6, 2, 3};
       // System.out.println(s.construct2DArray(a, 1, 3)[0].equals(null));
        int [][]b= s.construct2DArray(a,3,2);

        for(int [] pp :b){
            for (int p :pp){
                System.out.print(p+", ");
            }
                   System.out.println();
        }

    }
}