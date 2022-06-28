package countCollisions6028;

public class Solution {


    public int countCollisions(String directions) {
              char [] dir= directions.toCharArray();
              char L='L',R='R',S='S';
              int n = dir.length;
              int i =0,j=n-1;
              while(i<n-1 && dir[i]==L ) {dir[i]='0';i++;}
              while (j>-1 &&dir[j]==R){dir[j]='0';j--;}
              if(j<=i) return 0;

              int tempI=i;

              int ans=0;
              for(; i<=j;i++){
                  if(i<1) continue;

                  if(dir[i]==L ){  //--前面没有L只可能R，S
                      if( dir[i-1]==S ) { ans++; dir[i]=S;}
                      else {  ans+=2;  dir[i-1]=S;dir[i]=S; }
                  }
                  else if(dir[i]==S){
                      if(  dir[i-1]==R ){ans++; dir[i-1]=S; }
                  }
              }
             // printArray( dir);
              for( ;tempI<= j;j--){
                  if(j>n-2) continue;
                   if(dir[j]==R){
                       if( dir[j+1]==S ) { ans++; dir[j]=S;}
                       else {    ans+=2; dir[j+1]=S;  dir[j]=S; }
                   }
                   else if(dir[j]==S){
                       if( dir[j+1]==L ){ans++; dir[j+1]=S; }
                   }

              }
       // printArray( dir);

              return  ans;

    }



    public static void printArray(char[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }




    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        int []a ={2,4,1,7,6,5,7};
        System.out.println(s.countCollisions("RLRSLL"));
    }
}
