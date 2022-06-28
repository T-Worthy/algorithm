package array2D;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m =matrix.length;
        int n = matrix[0].length;
        if(target<matrix[0][0] || matrix[m-1][n-1]<target) return false;

        //斜对角二分遍历
        int l =0;
        int r = (n<m ? n:m)-1;
        int c =0;

        //System.out.println("???"+r);
        if(r==0){  //如果是1维
            if(n==1){
                r=m-1;
                while (l<=r) {
                    c = (l + r) / 2;
                    if (matrix[c][0] == target) return true;
                    else if (matrix[c][0] < target) {
                        l = c + 1;
                    } else {
                        r = c - 1;
                    }
                }
            }
            else if(m==1){
                r=n-1;
                while (l<=r) {
                    c = (l + r) / 2;
                    if (matrix[0][c] == target) return true;
                    else if (matrix[0][c] < target) {
                        l = c + 1;
                    } else {
                        r = c - 1;
                    }
                }
            }

            return false;
        }



        if(matrix[r][r]>=target) {
            while (r - l > 1) {
                c = (l + r) / 2;
                if (matrix[c][c] == target) return true;
                else if (matrix[c][c] < target) {
                    l = c + 1;
                } else {
                    r = c - 1;
                }
            }
        }
        if(target==matrix[l][l] || target ==matrix[r][r]) return true;
        int find= r;
        if(target<matrix[l][l] ) find=l;
        else  if(target>matrix[r][r] ) find=r+1;

        //System.out.println("Find:"+find+" r="+r+" l:"+l);
        //行查找

        int fin=find;
        while(fin<m){
             l=0;
             r= find;
             while(l<=r){
                 c=(l+r)/2;
                 if (matrix[fin][c] == target) return true;
                 else if (matrix[fin][c] < target) {
                     l = c + 1;
                 } else {
                     r = c - 1;
                 }
             }
             fin++;
        }
        //列查找
        fin=find;
        while (fin<n){
            l=0;
            r= find;
            while(l<=r){
                c=(l+r)/2;
                if (matrix[c][fin] == target) return true;
                else if (matrix[c][fin] < target) {
                    l = c + 1;
                } else {
                    r = c - 1;
                }
            }
            fin++;
        }




        return false;

    }
    public static void main2(String[] args) throws Exception {

       int a[][]={{4,6,9,10,15},{9,12,13,15,16}};
       Solution s= new Solution();
       System.out.println(s.searchMatrix(a,15));



    }

}