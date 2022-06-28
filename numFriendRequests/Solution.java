package numFriendRequests;

public class Solution {



    public int numFriendRequests(int[] ages) {

        int ans=0;

              int  ageArr[]=new int [121];
              for (int i =0 ;i< ages.length ;i++){
                  ageArr[ages[i]]+=1;
              }

              for (int i = 15 ;i< 121 ;i++){
                  if(ageArr[i]==0) continue;
                  if(ageArr[i]>1) ans+=ageArr[i]*(ageArr[i]-1);
                  for (int j = 7+i/2 +1 ;j < i   ;j++) {
                      if(ageArr[j]==0 ) continue;
                      System.out.println("i:"+i+",j:"+j);
                      ans += ageArr[j]*ageArr[i];
                  }
              }

        return ans;

    }

    public static void main(String[] args) throws Exception {

        Solution s =new Solution();

        int a[] = {109,6,101,18,13,20,106,110,110,108,55,89,81,56,84,37,71,51,88,70,27,16,31,63,99,68,12,120,104,18,110,42,93,106,99,63,3,82,22,17,69,49,88,117,57,37,95,15,50,18,77,103,102,104,87,1,23,97,93,15,9,35,59,103,118,23,52,66,86,7,40,33,60,4,113,43,21,58,31,120,71,56,19,67,68,32,84,14,50,55,98,34,89,32,58,20,93,37,95,40};
        System.out.println(s.numFriendRequests(a));

    }

}
