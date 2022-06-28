package longestWord720;


import java.util.Arrays;
import java.util.List;

public class Solution {

    class TreeNode{
        char letter;
        boolean get;
        TreeNode [] next;
        TreeNode(char c){
            letter=c;
            next = new TreeNode[26];
        }
    }

    public String longestWord(String[] words) {
          TreeNode root=new TreeNode('0');

          for( String word: words){
              TreeNode point = root;
                for ( int i =0;i< word.length();i++){
                       point= point.next[word.charAt(i)-'a'];
                }
          }
          return null;
    }



    public static void printArray(String[] a){
        System.out.print("[");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("]");
    }

    public static void main(String[] args) {

        String a[]= {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        Arrays.sort(a);
        System.out.println(a);
        printArray(a);

    }



        int n;
        public int minimumTotal(List<List<Integer>> triangle) {
            n=triangle.size();

            for(int deep = n-2 ;deep>=0 ;deep--){
               List<Integer> temp= triangle.get(deep);
                for( int y =0 ;y< deep+1 ;y++)
                    triangle.get(deep).set(y, triangle.get(deep).get(y)+    Math.min(triangle.get(deep+1).get(y),triangle.get(deep+1).get(y+1))    );

            }


            return triangle.get(0).get(0);

        }





}
