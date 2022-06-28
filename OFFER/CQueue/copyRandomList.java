package OFFER.CQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class copyRandomList {
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {

        if(head==null) return head;
        if(head.next==null) { Node  ans =new Node(head.val); if(head.random!=null) ans.random=ans; return ans;}

        List<int[] > data = new ArrayList<>();
        Map<Node , Integer>  map_Node_index =new HashMap<>();

        int n=0;
        Node p =head;
        while(p!=null) {
             map_Node_index.put(p,n);
            int eachData[] = new int[3];
            eachData[0] = p.val;
            data.add(eachData);
            p=p.next; n++;
        }

        p =head;int i=0;
        while(p!=null) {
               data.get(i++)[1]= p.random==null? -1: map_Node_index.get(p.random);
               p=p.next;
        }

        Node[] listNode= new Node[n];

        Node last = null;
        for(i=n-1;i>=0;i--){
            Node temp =new Node(data.get(i++)[0]);
            temp.next=last;
            last=temp;
            listNode[i]=temp;
        }

        for(i=0;i< n ;i++){

            listNode[i].random =data.get(i)[1]==-1 ? null: listNode[data.get(i)[1]];
        }



        return  listNode[0];
    }
}


//------------------
class Solution1 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}

