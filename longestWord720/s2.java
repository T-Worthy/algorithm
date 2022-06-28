package longestWord720;

import java.util.Arrays;

public class s2 {
    public String longestWord(String[] words) {
        Arrays.sort(words);

        printArray(words);

        int nowLen=0,maxLen=0; String ans="";
        int i=0;

        int n =words.length;

        while (i<n && words[i].length()!=1) i++;
        if(i==n )return "";
        {nowLen++; maxLen++;ans=words[0];}
        i++;

        for( ;i< words.length;i++){
           int len= words[i].length();
           if(len==1) nowLen=1;
             else if( (len==nowLen+1 ) &&  words[i].substring(0,nowLen).equals(words[i-1])){
                nowLen++;
                if(nowLen>maxLen) {maxLen=nowLen; ans =words[i]; }
            }
            else {  //是否部分相同
                if(len<= words[i-1].length()&&  words[i].substring(0,len-1).equals(words[i-1].substring(0,len-1)))
                    nowLen=len;
                else nowLen=0;

            }

            System.out.println("I： "+i+ " , words: "+ words[i]+ ",  nowLen :" +nowLen+" max: "+ans) ;
        }
  return  ans;
    }

    public static void printArray(String[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }

    public static void main(String[] args) {

        String a[] = {"wo","wor","worl","world"};s2 s=new s2();
        s.longestWord(a);
    }
}
