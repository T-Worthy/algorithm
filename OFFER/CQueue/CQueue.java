package OFFER.CQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class CQueue {

    Stack<Integer> in ,out;
    public CQueue() {
         in=new Stack<>();
         out=new Stack<>();
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(123);
        q.poll();
    }

    public void appendTail(int value) {
              in.push(value);
    }

    public int deleteHead() {
                 if(out.isEmpty()){  while (!in.isEmpty()) out.push(in.pop());}
                 return  out.pop();
    }
}