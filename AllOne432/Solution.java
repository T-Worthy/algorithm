package AllOne432;


import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AllOne {

    class  LinkNode{

        LinkNode next;
        String val;
        LinkNode(String s){ val=s;}
    }



    List<LinkNode>     array;
    int max_i , min_i;
    Map<String,Integer> map ;

    public AllOne() {

        array = new ArrayList<LinkNode>();
        array.add(new LinkNode("error"));
        array.add(new LinkNode("This is array1->0"));
        max_i =0;
        min_i=0;
        map = new HashMap<>();

    }
    public void nodeMove(LinkNode from ,LinkNode to, String key){  //---
        //1.从from中找到 val 节点
        //2. 保存并在from中删除
        //3. 添加到to 末尾
        LinkNode point =from;

        while (!point.next.val .equals(key)) point=point.next;

        LinkNode p =point.next; //保存该节点
        if(p.next!=null){ point.next=p.next ;p.next=null;}
        else {point.next=null;   }

        point=to;
        while(point.next !=null) point=point.next; //zhaodao duiwei
        point.next=p;

    }


    public void inc(String key) {

        // System.out.println("INC:"+key);


        if(map.containsKey(key)){   //-----------------------
            int num =map.get(key)+1;
            map.put(key,  num);
            if(array.size()< num+1){
                array.add(new LinkNode(""+num));
            }
            nodeMove(array.get(num-1),array.get(num),key);

            if(num> max_i)  max_i=num;
            if(map.size()==1) min_i=max_i;
            if(min_i==num-1 && array.get(min_i).next==null) min_i++;

        }
        else {//---------------------------------------第一次加入
            map.put(key,1);
            LinkNode head= array.get(1);
            while(head.next !=null) head=head.next;
            head.next=new LinkNode(key);
            min_i=1;
            if(max_i==0) max_i=1;
        }

    }

    public void dec(String key) {

        //  System.out.println("DEC:"+key);

        int num =map.get(key)-1;
        if(num==0){ //------------删除该节点
            LinkNode head =array.get(1);

            while (!head.next.val .equals(key)) head=head.next;
            head.next=head.next.next;
            map.remove(key);

            while(array.get(min_i).next==null) min_i++;

            return;
        }
        else {  //--------降级
            map.put(key,  num);
            nodeMove(array.get(num+1),array.get(num),key);

        }

        if(map.size()==1) { min_i=max_i; return;}
        if(num+1 ==min_i)//删除是最小的
            min_i--;

        else if(num+1==max_i && array.get(max_i).next==null){
            max_i--;
        }

    }

    public String getMaxKey() {
        if(map.size()==0) return "";
        //  System.out.println("MAX:"+max_i);
        return (String)array.get(max_i).next.val;
    }

    public String getMinKey() {
        if(map.size()==0) return "";
        // System.out.println("MIN:"+min_i);
        return (String)array.get(min_i).next.val;
    }
}

public class Solution {
    public static void main(String[] args) {

    }
}
