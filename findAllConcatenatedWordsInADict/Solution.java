package findAllConcatenatedWordsInADict;

import java.util.*;


class  leTree{

    char letter;
    public  boolean is_have;
    public  String next_letter;
    public List <leTree> next;
    leTree(char let ,boolean get){
        letter=let;  is_have =get;
        next_letter="";
        next= new ArrayList<leTree>() ;//-
    }

}

class Solution {




    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        //---长度升序排序
        Set<String> addressSet = sort(words);

        leTree HEAD= new leTree(' ',true);
        List<String> ans= new ArrayList<>();

        for (String s : addressSet){
            leTree print=HEAD;
            for (int i =0 ;i< s.length();i++){
                   char c= s.charAt(i);
                   String cc= ""+c;

                   int temp =print.next_letter.indexOf(c);
                   if (temp!=-1){  //-如果已存在树中

                           if(print.is_have){ //尝试连接
                               //if (i==s.length()-1 || check(HEAD,s.substring(i+1))){//如果已经结束
                              //          ans.add(s); break; }

                               //--连接失败就继续增加
                           }
                           print=print.next.get(temp);
                   }
                   else {
                       print.next_letter+=cc;
                       leTree newNode =new leTree(c,i==s.length()-1);
                       print.next.add(newNode);
                   }
            }

        }




        return  null;
    }

//------------------------------------------------------------------------
    /**
     * 按照字符串的长度从大到小排序
     * @param strs
     * @return
     */
    private static Set<String> sort(String[] strs) {

        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int num = s1.length()-s2.length();
                //如果长度相等，则根据内容排序
                return num;
            }
        });

        for (String s : strs)
            set.add(s);

        return set;

    }

    public static void main(String[] args) {

        String a []= {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};


       Solution s= new Solution();

       List<String >  aaa= s.findAllConcatenatedWordsInADict(a);

       for (String ss : aaa){
           System.out.print(ss+" , ");
       }


    }


}