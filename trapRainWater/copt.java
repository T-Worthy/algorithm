package trapRainWater;

import java.util.*;

class copt {
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
        if(floor[i][j]==1){//是墙
            return  true;
            //   System.out.println("wall"+i+","+j);
        }
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



            for (int x1 = 1,y1=1, x2 = m - 2,y2=n-2; (x1 <= x2) &&(y1<=y2); x1++, x2--,y1++,y2--) {

                if(y1!=y2){
                    for( i = x1; i<=x2 ;i++){
                        //heck(i,j);
                    }
                }
            }


            ///--------------------------------------


            for (int x1 = 1,y1=1, x2 = m - 2,y2=n-2; (x1 <= x2) &&(y1<=y2); x1++, x2--,y1++,y2--) {

                if(y1!=y2){//查列
                    for( i = x1; i<=x2 ;i++){
                        if(check(floor,time,i,y1)) floorwater--;  ;
                        if( check(floor,time,i,y2)) floorwater--;}
                }
                else {        for( i = x1; i<=x2 ;i++){
                    if(  check(floor,time,i,y1) ) floorwater--;}
                }

                if(x1!=x2){//查行
                    for( i = y1+1; i<=y2-1 ;i++){
                        if(check(floor,time,x1,i))floorwater--;
                        if(check(floor,time,x2,i)) floorwater--;}
                }
                else{
                    for( i = y1+1; i<=y2-1 ;i++){
                        if(check(floor,time,x1,i)) floorwater--;}
                }


            }
            ///--------------------------------------------------------------



//           for (i=m-2;i>0;i--)
//               for (j=1;j<n-1;j++)
//                   if(floor[i][j]!=1 &&floor[i][j]!=time-1  && (floor[i-1][j]<time|| floor[i+1][j]<time || floor[i][j-1]<time || floor[i][j+1]<time) ) //不饿能装
//                   {floor[i][j]=time-1;//排水
//                       floorwater--;}
//
//           for (i=1;i<m-1;i++)
//               for (j=n-2;j>0;j--)
//                   if(floor[i][j]!=1 &&floor[i][j]!=time-1  && (floor[i-1][j]<time|| floor[i+1][j]<time || floor[i][j-1]<time || floor[i][j+1]<time) ) //不饿能装
//                   {floor[i][j]=time-1;//排水
//                       floorwater--;}
//
//           for (i=m-2;i>0;i--)
//               for (j=n-2;j>0;j--)
//                   if(floor[i][j]!=1  &&floor[i][j]!=time-1 && (floor[i-1][j]<time|| floor[i+1][j]<time || floor[i][j-1]<time || floor[i][j+1]<time) ) //不饿能装
//                   {floor[i][j]=time-1;//排水
//                       floorwater--;}
//           for (i=1;i<m-1;i++){
//                    for (j=1;j<n-1;j++){
//
//                            if(floor[i][j]==1){//是墙
//                                floorwater--;
//                           //   System.out.println("wall"+i+","+j);
//                            }
//                            else if(floor[i][j]!=time-1) {//是空  看看能不能装
//                                if(floor[i-1][j]<time|| floor[i+1][j]<time || floor[i][j-1]<time || floor[i][j+1]<time ) {//不饿能装
//                                    floor[i][j]=time-1;//排水
//                                    floorwater--;
//                                   // System.out.println("排水"+i+","+j);
//                                }
//                            }
//
//                    }
//                }

            water+=floorwater;
            // System.out.println(floorwater);
        }
        return water;
    }







    public  void dod(int [][] a){
        a[0][0]=-1;
    }




    public static void main(String[] args) throws Exception {
        int[] a={1,4,9,16,25,36,49,64,81,100,121,144,169,196,225,256,289,324,361,400,441,484,529,576,625,676,729,784,841,900,961,1024,1089,1156,1225,1296,1369,1444,1521,1600,1681,1764,1849,1936,2025};
   // Set<Integer> set= Set.mutable.of(new Integer[]{1, 2, 3, 4, 5});;

        for (long i =  1 ;i< 50000;i++){
        System.out.print(i*i+",");
    }
    }
}