package LRUCache146;


import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class LRUCache {
  class LinkNode{
      int val;
      LinkNode next;
      LinkNode( ){
          val=-1;
      }
      LinkNode(LinkNode n){
          next=n;
          val=-1;
      }
  }

   LinkNode hh, tt;

    Map < Integer,Integer> map;

    //boolean isOne;int k,v;

    public LRUCache(int capacity) {

        hh=new LinkNode();
        LinkNode last=hh;
        for(int i =0;i< capacity -1 ;i++){
            LinkNode temp= new LinkNode(last);
            last=temp;
        }
        hh.next=last;
        tt=hh;
        hh=tt.next;


         map=new HashMap<>();
    }

    public  void Used(int key){
        if(tt.val==key) return;

        if(map.containsKey(key)){
            LinkNode point=hh;
            if(point.val==key)  {hh=hh.next;  tt.next.val=key;  tt=tt.next; return;}
            while (point.next.val!=key) point=point.next;
            LinkNode temp =point.next;
            point.next=temp.next;
            temp.next=tt.next;
            tt.next=temp;
            tt=tt.next;
        }
        else {
            tt.next.val=key;
            tt=tt.next;
        }

    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Used(key);
            return map.get(key);
        }
             return -1;
    }

    public void put(int key, int value) {

           if(map.size()!=0 && tt.next ==hh  && !map.containsKey(key)){  //已经溢出,删除 hh
               map.remove(hh.val);
               hh.val=key;

               hh=hh.next;
               tt=tt.next;
               map.put(key,value);
               return;
           }
           else {

               Used(key);
               map.put(key,value);
           }
    }
}


public class Solution {
}
