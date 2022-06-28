package nearestPalindromic564;

import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public String compare(long a1 ,long a2, long nn){
        System.out.println("COMOARE: "+a1+","+a2);

        if(a1>a2) {long temp=a1; a1=a2; a2=temp;}
        if(nn-a1>a2-nn) return ""+a2;
        else return ""+a1;
    }



    public String nearestPalindromic(String n) {
        int  len = n.length();

        if(len==1) return ""+ (n.charAt(0)-'0'-1);
        boolean isPal = true;
        int i ;
        for (  i = 0 ;i < len/2;i++){
            if(n.charAt(i)!=n.charAt(len-i-1))  {isPal=false; break;}
        }

        char cArr []= n.toCharArray();
        int j ;


        if(cArr[0]=='1'){ for( j = 1; j< len-1 ;j++)  if(cArr[j]!='0') break;  if(j==len-1 && cArr[j]-'0'<2) {String s=""; for ( j = 0;j<len-1;j++) s+="9";  return s;  }
        }
        else if(cArr[0]=='9'){ for( j = 1; j< len ;j++)  if(cArr[j]!='9') break;  if(j==len) {String s="1"; for ( j = 0;j<len-1;j++) s+="0";  return s+"1";  }
        }
         if(cArr[0]-'0'<4){
             for( j = 1; j< len-1 ;j++)  if(cArr[j]!='9') break;  if(j==len-1  && ( (cArr[0]=='3'&& cArr[j]=='9')|| (cArr[0]=='2'&& cArr[j]-'8'>=0) || (cArr[0]=='1'&& cArr[j]-'7'>=0) )) {String s=""+(char)(cArr[0]+1); for ( j = 0;j<len-2;j++) s+="0";  return s+(char)(cArr[0]+1);  }

        }

        if(isPal)//1.本身为回文数
        {
           if(len>3) {
               //X0000..X
               for (j = 1; j < len - 1; j++) if (cArr[j] != '0') break;
               if (j == len - 1) {
                   String s = "" + (char) (cArr[0] - 1);
                   for (j = 0; j < len - 2; j++) s += "9";
                   return s + (char) (cArr[0] - 1);
               }

               //X999...X
               for (j = 1; j < len - 1; j++) if (cArr[j] != '9') break;
               if (j == len - 1) {
                   String s = "" + (char) (cArr[0] + 1);
                   for (j = 0; j < len - 2; j++) s += "0";
                   return s + (char) (cArr[0] + 1);
               }
           }
            //
            char md= cArr[len/2]=='0' ? '1':(char) (cArr[len/2]-1);
                 if(len %2 ==1)   cArr[len/2]=md;
                 else {
                     cArr[len/2-1]=  cArr[len/2]=(md);

                 }

            return new String(cArr);
        }
            else //2. 非回文
        {

            while ( i < len/2) {
                cArr[len - i-1] = n.charAt(i );
                  i++;
            }

            long nn= Long.valueOf(n);
            long a1=Long.valueOf(new String(cArr));

              if(a1>nn && cArr[len/2]=='0') return new String(cArr);


                char[] cArr2= cArr.clone();
                if (len % 2 == 1)
                    cArr2[len / 2 ]  = (char) (cArr[len/2]+1- (a1>nn ? 2 :0) );
                else
                    cArr2[len / 2 - 1] = cArr2[len / 2] = (char) (cArr[len/2-1]+1- (a1>nn? 2 :0) );

                //比较距离
               return compare(a1,Long.valueOf(new String(cArr2)),nn);
            }

       // return new String(cArr);
    }



    public  String gouzao (boolean isOdd, int numLen ,int num){

        int   ansLen=isOdd? numLen*2: numLen*2-1;
        String s =""+num;
        char [] ans= new char[ansLen];
        for (int i = 0 ;i<numLen ;i++){
            ans[i]=ans[ansLen-1-i]=s.charAt(i);
        }
        return  new String(ans);
    }
    public static void main(String[] args) throws Exception {
        Solution s= new Solution();

        System.out.println(s.gouzao(false,4,1234));
        System.out.println(s.nearestPalindromic("500"));
    }
}
