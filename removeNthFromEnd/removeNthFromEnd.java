package removeNthFromEnd;


  class ListNode {
     int val;
    ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     void print(){ ListNode p =this; while (p !=null) {System.out.print(p.val+",");p=p.next;}System.out.println();}
  }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;

        ListNode h = head;
        ListNode h2 = head.next;//保存上一次的第二个
        ListNode point;
        int i = 1;

       while (true) {

           i=1;
           point=h2;
           for (; i < n; i++)  //后退n步
           {
               if (point.next == null) break;
                   point = point.next;
           }
           if(i!=n){//后退失败，删除为h

               return h.next;  //只可能头节点
           }
           else {//后退成功
               //System.out.println("后退成功"+i);
               if(point.next==null){//找到
                   h.next=h2.next;
                   return head;
               }
               h=h2;
               h2=h.next;
             //  System.out.print("asdd::");h.print();;h2.print();
           }
       }

    }
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        ListNode e= new ListNode(5);
        ListNode d =new ListNode(4,e);
        ListNode c= new ListNode(3,d);
        ListNode b=new ListNode(2,c);
        ListNode a=new ListNode(1,b);
        a.print();
        ListNode hh= s.removeNthFromEnd(a,2);
        hh.print();

    }

}