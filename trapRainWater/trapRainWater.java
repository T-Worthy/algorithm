package trapRainWater;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Solution {
  public  void print(int [][] a){
      for(int i[]:a){
          for (int j:i){
              System.out.print(j+", ");
          }
          System.out.println();
      }
      System.out.println("---------------------------");
  }
  public boolean check(int[][] floor,int time ,int i ,int j){//检查是否需要排水
      if(floor[i][j]==time-1) return false;

      if(floor[i][j]==1)   return  true;

      else if(floor[i][j]!=time-1) {//是空  看看能不能装
          if(floor[i-1][j]<time|| floor[i+1][j]<time || floor[i][j-1]<time || floor[i][j+1]<time ) {//不饿能装
              floor[i][j]=time-1;//排水
             return true;
              // System.out.println("排水"+i+","+j);
          }
      }
      return false;
  }


    public int trapRainWater(int[][] heightMap) {
         int m =heightMap.length;
         int n =heightMap[0].length;
         if(m<3||n<3) return 0;

        Set<int []>  localSet;
         int high=0;

        Map <Integer, Set> map =new HashMap<>();  //改装地图
        for (int i = 0 ; i <m ;i++){//一次遍历获取信息
            for(int j  =0 ;j< n;j++){
                if(heightMap[i][j]>high) high=heightMap[i][j];
                int local[] ={i,j};
                localSet =map.get(heightMap[i][j]);
                if(localSet==null){localSet =new HashSet<int []>(); }
                localSet.add(local);
                map.put(heightMap[i][j],localSet);
            }
        }

      //  System.out.println("HIGH"+high+","+m+","+n);


        int [][] floor= new int[m][n];//楼层图
        int water=0;
        int time=0;
        int wallNum=0;

        int i,j;
        int floorwater=0;
       for(   int h=high  ;      h> 0;    h--,time--){//从上到下遍历
           //外围开始一次排水
           if (time==0) {
               for (i = 0; i < m; i++) {   //第一次需要
                   if (floor[i][0] != 1) {floor[i][0] = -h;}
                   if (floor[i][n - 1] != 1) {floor[i][n - 1] = -h;}
               }
               for (j = 1; j < n - 1; j++) {
                   if (floor[0][j] != 1) {floor[0][j] = -h;}
                   if (floor[m - 1][j] != 1) {floor[m - 1][j] = -h;}
               }
           }
//-----------------------------------------------------------------------------------

            localSet=map.get(h);
            if(localSet==null) {water+=floorwater;  continue;}
             wallNum+=localSet.size();

                    for (int[] a : localSet) { //造墙
                         floor[a[0]][a[1]] = 1;//1是墙 0 或time=< xx<=0是水
                    }

                 if(wallNum<4)  continue;  //没有四面墙别装了

                    floorwater = (n-2) * (m-2) ;//最多那么多水
        //   System.out.println(floorwater+"!!!!---------------");


                //中间排水 //正序+逆序才能无误 唉  从外而内







                water+=floorwater;
              System.out.println(floorwater);
            }
        return water;
        }







  public  void dod(int [][] a){
      a[0][0]=-1;
  }




    public static void main(String[] args) throws Exception {
        int [][] floor= { //[[13,16,15,18,15,15],[14,1,8,9,7,9],[19,5,4,2,5,10],[13,1,7,9,10,3],[17,7,5,10,6,1],[15,9,8,2,8,3]]
                {13,16,15,18,15,15},{14,1,8,9,7,9},{19,5,4,2,5,10},{13,1,7,9,10,3},{17,7,5,10,6,1},{15,9,8,2,8,3}
        };
        Solution s =new Solution();
        s.dod(floor);
        System.out.println("!@##"+floor[0][0]);

        System.out.println(s.trapRainWater(floor));

    }
}