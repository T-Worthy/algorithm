package maxConsecutiveAnswers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class S2 {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        int n = answerKey.length();
        if (k >= n - 1) return n;
        if (n < 2) return n;
        //   Map<Integer,List<Integer>> indexMap =new HashMap<>();
        List<Integer> list = new ArrayList<>();
       // List<Integer> list2 = new ArrayList<>();
        list.add(0);

        int num = 1;
        boolean last = (answerKey.charAt(0) == 'T');
        for (int i = 1; i < n; i++) {
            if ((last ^ answerKey.charAt(i) == 'T')) {
                last = (answerKey.charAt(i) == 'T');
                list.add(num);
                num = 1;
            } else
                num++;
        }
        list.add(num);  list.add(0);


        int m = list.size();
        if (m == 3) return n;



        int MAX = 0;
        int tk, j, next,nowSum;

        j=0; tk=k;nowSum=0;
        Queue<Integer>  qq= new ArrayDeque<>();

        while(tk>0 && j+1<m  ){
            nowSum+= list.get(j);  qq.offer(list.get(j)); tk-=list.get(j);
            if(tk>=list.get(j+1))
            { nowSum+= list.get(j+1);  qq.offer(list.get(j+1)); tk-=list.get(j+1);}
            else {
                nowSum+= tk;  break;
            }
            j+=2;
        }
        qq.offer(list.get(j));


        MAX=Math.max(MAX,nowSum);

        System.out.println(list);


        while(j<m-1 ){
            System.out.println(qq+" j: "+j);

            int a =qq.poll(), b= qq.poll();
                     nowSum=nowSum- a-b ;
                     tk+=b;

            while(tk>0 && j+1<m  ){
                nowSum+= list.get(j);  qq.offer(list.get(j)); tk-=list.get(j);
                if(tk>=list.get(j+1))
                { nowSum+= list.get(j+1);  qq.offer(list.get(j+1)); tk-=list.get(j+1);}
                else {
                    nowSum+= tk;
                    qq.offer(tk); tk=0;
                }
                j+=2;
            }
            System.out.println("!!   "+qq);



        }





        for(int i =2; i< m ;i=i+2){
             nowSum = list.get(i-1);
             tk=k; j=i;





        }


        /*
        for (int i = 0; i < m - 1; i++) {
             nowSum = list.get(i);
            tk = k;
            j = i + 1;//next=list.get(j);
            while (tk > 0 && j < m) {
                next = list.get(j);
                System.out.println("nowSum： " + nowSum + "  next: " + next + " tk: " + tk + "  --MAX" + MAX);
                if (tk >= next) {
                    nowSum += next;
                    tk -= next;
                    if (j + 1 < m) {
                        nowSum += list.get(j + 1);
                        j++;
                    }

                } else {
                    nowSum += tk;
                    tk = 0;
                    break;
                }
                j++;
            }
            if (tk != 0) nowSum += tk;//----
            nowSum = Math.min(nowSum, n);
            MAX = Math.max(MAX, nowSum);
        }
        */


      //  System.out.println(list2);
        return MAX;
    }

    public static void main(String[] args) throws Exception {
        boolean a=true, b=true;
        S2 s  = new S2();
        System.out.println(s.maxConsecutiveAnswers("FFFTTFTTFT"
                ,3));

        System.out.println(!(a^b));
    }
}
