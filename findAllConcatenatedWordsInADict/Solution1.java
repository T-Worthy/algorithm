package findAllConcatenatedWordsInADict;

import java.util.*;



class Solution1 {


    public List<String> findAllConcatenatedWordsInADict(String[] words) {





        //---长度升序排序
        Set<String> addressSet = sort(words);
        List<String> dicSet = new ArrayList<>();
        out(addressSet);

        List<String> ans= new ArrayList<>();

        for (String   s  : addressSet){
             boolean did =false;
             String sub_s=s;  //--参与迭代替换
             for(int k = dicSet.size()-1; k>-1 ;k--) //倒序遍历 大到小
             {
                 if (sub_s.contains(dicSet.get(k))){
                     sub_s=sub_s.replaceAll(dicSet.get(k),"" );
                     if (sub_s.equals("")){ ans.add(s); did=true; break;}
                 }

             }
             if(!did) dicSet.add(s);
           //  out(dicSet);
        }

        return  ans;
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
                if(num==0) {
                    return 1;
                }
                return num;
            }
        });
        for (String s : strs)
            set.add(s);
        return set;
    }

    public static void main(String[] args) {

        String a []= {"cat","dog","catdog"};


        Solution1 s= new Solution1();

        List<String >  aaa= s.findAllConcatenatedWordsInADict(a);


        for (String ss : aaa){
            System.out.print(ss+" , ");
        }



    }
    public static void out(List<String > list){
        for (String ss : list){
            System.out.print(ss+" , ");
        }
        System.out.println();

    }

    public static void out(Set<String > list){
        for (String ss : list){
            System.out.print(ss+" , ");
        }
        System.out.println();

    }


}