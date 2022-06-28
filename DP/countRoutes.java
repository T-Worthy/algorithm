package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class countRoutes {

    public static void printArray(int[][] b){
        System.out.print("[");
        for(int [] a:b) {
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + ",");
            System.out.println("]");
        }
    }


        int mod = 1000000007;
    public int getCost(int[][] cost ,int i ,int j){
        if(i<j) return cost[i][j];
        return cost[j][i];
    }


        public int countRoutes(int[] ls, int start, int end, int fuel) {
            int n = ls.length;

            // f[i][j] 代表从位置 i 出发，当前油量为 j 时，到达目的地的路径数
            int[][] f = new int[n][fuel + 1];

            //Integer [][] cost = new Integer [n*(n+1)/2][3];
            List<Integer[]> cost =new ArrayList<>();

            // 对于本身位置就在目的地的状态，路径数为 1
            for (int i = 0; i <= fuel; i++) f[end][i] = 1;

            int minFuel =9999999;
            for(int i = 0 ;i< n;i++)
                if(i!=end) minFuel=Math.min(minFuel,Math.abs(ls[i]-ls[end]));


                for(int i=0;i< n ;i++){

                    for(int j =i+1 ;j< n;j++ ){
                        Integer [] temp=new Integer[3];
                        temp[0]=Math.abs( ls[i]-ls[j]);
                        temp[1]=i;temp[2]=j;
                        cost.add(temp);
                    }
                }
            Collections.sort(cost,  new Comparator<Integer[]>() {
                        public int compare( Integer[] u1, Integer[] u2 ) {
                            if(u1[0]==u2[0]) return 0;
                            else if(u1[0]> u2[0]) return 1;
                            return -1;
                        }});
                for(Integer [] a : cost){
                    System.out.println(a[0]+","+a[1]+","+a[2]);
                }

            printArray(f);
            System.out.println();

            // 从状态转移方程可以发现 f[i][fuel]=f[i][fuel]+f[k][fuel-need]
            // 在计算 f[i][fuel] 的时候依赖于 f[k][fuel-need]
            // 其中 i 和 k 并无严格的大小关系
            // 而 fuel 和 fuel-need 具有严格大小关系：fuel >= fuel-need
            // 因此需要先从小到大枚举油量
            for (int cur = minFuel; cur <= fuel; cur++) {

                int i =0;
                while(cost.get(i)[0]<= cur){
                    f[cost.get(i)[1]][cur] += f[cost.get(i)[2]][cur-cost.get(i)[0]];
                    f[cost.get(i)[2]][cur] += f[cost.get(i)[1]][cur-cost.get(i)[0]];
                    f[cost.get(i)[1]][cur] %= mod;
                    f[cost.get(i)[2]][cur]%= mod;
                    i++;
                }



               /* for (int i = 0; i < n; i++) {
                    for (int k = 0; k < n; k++) {
                        if (i != k) {
                            int need = Math.abs(ls[i] - ls[k]);
                            if (cur >= need) {
                                f[i][cur] += f[k][cur-need];
                                f[i][cur] %= mod;
                            }
                        }
                    }
                }*/

                printArray(f);
                System.out.println("------------------------------------------------------");
            }
            return f[start][fuel];
    }


    public static   void   main(String [] ssa){
        countRoutes s = new countRoutes();
          int []a ={2,3,6,8,4};

          System.out.println(s.countRoutes(a,1,2,5));

    }



}
