package array2D;

class Solution2 {

    public  boolean searchline(int [][] M ,int target ,int line,int find){

        int l=0;
        int r= find-1;
        int c;
        while(l<=r){
            c=(l+r)/2;
            if (M[c][line] == target) return true;
            else if (M[c][line] < target) {
                l = c + 1;
            } else {
                r = c - 1;
            }
        }
        return false;
    }
    public  boolean searchrow(int [][] M ,int target ,int row,int find){

        int l=0;
        int r= find-1;
        int c;
        while(l<=r){
            c=(l+r)/2;
            if (M[row][c] == target) return true;
            else if (M[row][c] < target) {
                l = c + 1;
            } else {
                r = c - 1;
            }
        }
        return false;

    }
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
        //列查找
        for(int i =find ; i<n;i++){
            if(target<=matrix[find-1][i]){
                if(searchline(matrix,target,i,find)) return true;
            }
        }



            //行查找
        for(int i =find ; i<m;i++){
            if(target<=matrix[i][find-1])
                if(searchrow(matrix,target,i,find)) return true;
        }

        return false;
    }
    public static void main(String[] args) throws Exception {

        //int a[][]={{4,6,9,10,15},{9,12,13,15,16}};
        int a[][]={{1,2,3,4,5},{6,7,8,9,10}};
        Solution2 s= new Solution2();
        System.out.println(s.searchMatrix(a,4));
       // System.out.println(s.searchline(a,9,3,3));



    }

}