package convert_6;

class Solution {
    public String convert(String s, int numRows) {
      StringBuffer ansBuff= new StringBuffer();
      int n = s.length();
      if(n==1 || numRows==1 ) return s;
      for (int i =0;i <numRows ;i++){
          int jump1 = 2*(numRows-1-i);
          int jump2 = 2*i;
          //ansBuff.append(s.charAt(i));
          for (int j = i, flag=1 ;  j< n ; flag++ ){
           add:       ansBuff.append(s.charAt(j));
                  if(jump1==0) j+= jump2;
                  else if(jump2==0) j+=jump1;
                  else j=j+( ( (flag%2==1)   ) ? jump1 :jump2 );
          }

      }

      return ansBuff.toString();
    }

    public static void main(String[] args) throws Exception {

      Solution s= new Solution();
      String a= "0123456789";
      System.out.println(s.convert(a,5));

    }


}