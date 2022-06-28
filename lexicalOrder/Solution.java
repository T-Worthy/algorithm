package lexicalOrder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {

    List<Integer> ans = new LinkedList<>();
    int N;
    public List<Integer> lexicalOrder(int n) {

        Set<Integer> set = new HashSet<>();


        for (int i = 1; i < 9; i++) {
            if((i)>N)  return ans;
            ans.add(i);
            Do((i)*10);
        }
        return  ans;
    }
    void Do(int First  )
    {
        if(First>N) return;
        for (int i = 0; i < 10; i++) {
            if((First+i)>N)  return;
                ans.add(First+i);
                Do((First+i)*10);

        }
    }

    public static void main(String[] args) {
        StringBuilder s= new StringBuilder("sdsdadasd fdsfgs gds ");
        String [] ss ="sdfgsdg".split(" ");
        System.out.println();
    }
}