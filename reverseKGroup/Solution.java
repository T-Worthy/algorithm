package reverseKGroup;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class ListNode {
      int val;
      ListNode next;

      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

   class Solution {
public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;

        int num[] =new int [k];
        int nowT=k;
        ListNode p=head,lastp,ans=new ListNode(-1),lasttemp,temp;

        if(p==null ||p.next==null) return p;

                nowT=0;
                while(p!=null && nowT++<k)  { p=p.next;}
                if(nowT!=k-1) return  head;
                else{
                        p=p.next;
                        lasttemp =new ListNode(-1);
                        ans= reverseList(head,lasttemp) ;
                        lastp=p;
                }
                while(p!=null){
                    nowT=0;
                    while(p!=null && nowT++<k)   p=p.next;
                    if(nowT!=k-1) break;
                    else{
                        p=p.next;
                        temp =new ListNode(-1);
                        lasttemp.next= reverseList(lastp,temp) ;
                        lasttemp=temp;
                        lastp=p;
                    }


                }
                p=ans;
                while(p.next!=null){
                    if(p.next.val==-1) p.next=p.next.next;
                }

                return  ans;

        }

           public ListNode reverseList(ListNode head, ListNode Facktail) {
                   if(head==null || head.next==null) return  head;
                   Stack<ListNode> que = new Stack<>();
                   ListNode p =head;
                   while(p!=null && p.val!=-1){
                           que.push(p);
                           p=p.next;
                   }
                   ListNode ans=p;
                   while(!que.isEmpty()){
                           p.next=que.pop();
                           p=p.next;
                   }
                   p.next=Facktail;
                   return  ans;

           }


           public ListNode reverseList(ListNode head) {
                if(head==null || head.next==null) return  head;
                   Stack<ListNode> que = new Stack<>();
                   ListNode p =head;
                   while(p!=null){
                           que.push(p);
                           p=p.next;
                   }
                   ListNode ans=p=que.pop();
                   while(!que.isEmpty()){
                           p.next=que.pop();
                           p=p.next;
                   }
                   p.next=null;
                   return  ans;

           }



        }