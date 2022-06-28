package crossRoad;

class Solution {
    public boolean isbecomeSmall(int [] D,int start){
        int n =D.length;
        for(int i = start+2 ;i<n;i++) {
            if (D[i]-D[i-2] >= 0  ) return true;
        }
        return false;
    }
    public boolean isSelfCrossing(int[] distance) {

         int n = distance.length;
         if(n<4)return false;
         if(distance[2]-distance[0]>0) {
             int i = 3;
             for (; i < n; i++) {
                 if (distance[i] - distance[i - 2] == 0) {
                     if ( i + 1 < n && distance[i + 1] + distance[i - 3] >= distance[i - 1])   return true;
                     else  return isbecomeSmall(distance,i);
                 }
                 else if(distance[i] - distance[i - 2] <0){
                     if(i+1<n ){
                         int ff=0; if(i-4>=0) ff=distance[i-4];
                         if(ff+distance[i]>=distance[i-2] && distance[i + 1] + distance[i - 3] >= distance[i - 1])
                             return true;
                         return isbecomeSmall(distance,i);
                     }
                     else return false;

                 }
             }
         }
         else  return isbecomeSmall(distance,1);  //小只能一直变小
        return  false;
    }



    public static void main(String[] args) throws Exception {
        Solution s= new Solution();
        int [] d= {1,3,3,4,2,2};
        System.out.println(s.isSelfCrossing(d));
        //System.out.println(d[-1]);
    }

}