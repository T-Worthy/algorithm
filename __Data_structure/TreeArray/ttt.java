package __Data_structure.TreeArray;

import java.io.PrintStream;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ttt {


    public static void main(String[] args) throws Exception {

          int a[] ={0,1,2,3,4,5,6,7,8,9,10,11,100};
          treeArray tr =new treeArray(a);
          tr.add(5,5);
          System.out.println(tr.nums[5]+" , "+tr.tree[5]);
          System.out.println(tr.sumRange(1,3));


        TreeSet<Integer>  ys = new TreeSet<Integer>((x,y)-> x-y );
        ys.add(5); ys.add(4); ys.add(2); ys.add(544); ys.add(25); ys.add(-5); ys.add(425);
       ys.forEach(System.out::println);

       Runnable r1= ()->System.out.println("QQQQ");

        PrintStream ps= System.out;
        Consumer<String > co= (x)-> ps.println(x);
        Consumer<String > co2 = ps::println;

        Comparator<Integer> com1= Integer::compare;

        String s ="ldsds";


        Function<int[],treeArray> fun =treeArray::new;
        treeArray aass=fun.apply(a);

        Function<Integer, String[]> sarr=String[]::new;

        Stream<Integer> steam =Stream.iterate(0,(x)->x+2);

        BiPredicate<String , String> bp2 =String::equals;


        IntSummaryStatistics max =Stream.of(aass ).collect(Collectors.summarizingInt(treeArray::getN));
        System.out.println(max.getMax()+"!!!!!!!!!!!");
       r1.run();

    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<3) return n;

          int last =nums[0];
        for(int i =1;i< n;i++){
               if(nums[i]==last) {nums[i]=Integer.MIN_VALUE;n--;}
               else{last=nums[i];}
        }
        last=0;
        for(int i =1;i< nums.length;i++){
            if(nums[i]==Integer.MIN_VALUE) last++;
            else  nums[i-last]=nums[i];
        }
        return n;
    }

}
