package _AAA.zhousai4_10;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int largestInteger(int num) {
        if(num<10) return num;

        List<Integer> ji =new ArrayList<>();
        List<Integer> ou = new ArrayList<>();
        Stack<Boolean> Ou =  new Stack<>();
        int t1= num,t2;
        while(t1>0){
             t2= t1%10;
             Ou.push(t2%2==0);
             if(t2%2==0) ou.add(t2);
             else ji.add(t2);
             t1/=10;
        }
        Collections.sort(ji);
        Collections.sort(ou);
        t1=ou.size()-1;t2= ji.size()-1;  int ans=0;
        while(!Ou.isEmpty()){
            if(Ou.pop()){
                ans=ans*10+ou.get(t1--);
            }
            else{
                ans=ans*10+ji.get(t2--);
            }
        }
        return  ans;
    }


    public static void main(String[] args) {
          int  a [] = {0,1,2,4,56,7,8};
        Arrays.stream(a).forEach(e->{System.out.print(e+ ",");}); System.out.println();

        int b[][]={{0,1},{2,3},{5,6,7}};
        Arrays.stream(b).forEach( k->{ System.out.print("{");  Arrays.stream(k).forEach(e->{System.out.print(+e+ ",");});System.out.println("}"); });

    }

}
