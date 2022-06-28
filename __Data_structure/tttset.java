package __Data_structure;

import java.util.ArrayDeque;
import java.util.Queue;

public class tttset {
    public static void main(String[] args) {
         String  a="he" + "llo";
         String b="he" + "llo";
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(1);
        que.poll();
        System.out.println(a==b);
    }
}
