package findWords;


import java.util.Locale;
import java.util.Map;


class Solution {
    public String[] findWords(String[] words) {

      //  Set<Integer> se1 = new HashSet<Integer>(Arrays.asList(17,23,5,18,20,25,21,9,15,16));
      //  Set<Integer> se2 = new HashSet<Integer>(Arrays.asList(1,19,4,6,7,8,10,11,12));
      //  Set<Integer> se3 = new HashSet<Integer>(Arrays.asList(26,24,3,22,2,13,14));

     //   Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(112,113,114,116,101,117,119,121,105,111));
      //  Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(97,115,100,102,103,104,106,107,108));
       // Set<Integer> s3 = new HashSet<Integer>(Arrays.asList(98,99,118,120,122,109,110));
                    //a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
        int [] dic = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};

        int n = words.length;


        int flag=0;
        for (int k=0 ;k<words.length ;k++){
            String s=words[k].toLowerCase();
              flag=dic[s.charAt(0)-'a'];
              for (int i = 1;i<s.length();i++){
                  if(dic[s.charAt(i)-'a']!=flag){
                      words[k]="";
                      n--;
                      break;
                  }
              }
        }
        String[] ret =new String[n];
     //   System.out.println(ret.length+","+n);
        int k =0;
        for (String s : words){
            if(s!="")
                ret[k++]=s;
        }

        //if(words[0].contains())
return ret;
    }



    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        String[] a={"omk"};

        System.out.println(s.findWords(a));

        String aa="asdfghjkl";
       System.out.println('a'-0);

    }
}