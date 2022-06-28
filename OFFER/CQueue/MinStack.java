package OFFER.CQueue;

import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> sta ,minSta;
    public MinStack() {
        sta =new Stack<>();
        minSta = new Stack<>();
    }

    public void push(int x) {
       if(minSta.isEmpty()) minSta.push(x);
       else  { if( x<minSta.peek()) minSta.push(x);}
       sta.push(x);


    }

    public void pop() {
        if(minSta.peek().equals(sta.pop()) )  minSta.pop();
    }

    public int top() {
             return  sta.peek();
    }

    public int min() {
            return  minSta.peek();
    }
}
