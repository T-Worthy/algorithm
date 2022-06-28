package trapRainWater;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Solution2 {
    public  void print(int [][] a){
        for(int i[]:a){
            for (int j:i){
                System.out.print(j+", ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
    public void Checking(int[][] f,boolean[][] chek,int nmt[] ,int i ,int j){//搜素洞的上下左右


        if(j!=0 && j!=nmt[1]-1){
            //上
            if(i-1> 0 && !chek[i-1][j] ){
                chek[i-1][j]=true;
                if(f[i-1][j] !=1){ //paishui
                    nmt[0]--;
                    Checking(f,chek,nmt,i-1,j);
                }
            }
            //xia
            if(i+1<=nmt[2]-2&& !chek[i+1][j] ){
                chek[i+1][j]=true;
                if(f[i+1][j] !=1){ //paishui
                    nmt[0]--;
                    Checking(f,chek,nmt,i+1,j);
                }
            }
        }

        if(i!=0 && i!= nmt[2]-1){
            //左
            if(j-1> 0&& !chek[i][j-1]){
                chek[i][j-1]=true;
                if(f[i][j-1] !=1){ //paishui
                    nmt[0]--;
                    Checking(f,chek,nmt,i,j-1);
                }
            }
            //右
            if(j+1 <= nmt[1]-2 && !chek[i][j+1]){
                chek[i][j+1]=true;
                if(f[i][j+1] !=1){ //paishui
                    nmt[0]--;
                    Checking(f,chek,nmt,i,j+1);
                }
            }
        }



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
        for(   int h=high  ;      h> 0;    h--,time--){////////////////从上到下遍历/-----------------------------------------------------------------------------------

            localSet=map.get(h);
            if(localSet==null) {water+=floorwater;  continue;}//照旧

            wallNum+=localSet.size();  //目前总墙数

            //新建墙
            for (int[] a : localSet) {floor[a[0]][a[1]] = 1;}//1是墙 0 或time=< xx<=0是水

            if(wallNum<4)  continue;  //没有四面墙别装了

            floorwater = (n-2) * (m-2) ;//该层最多那么多水
            int  insWall=wallNum;//保存内圈墙数
            boolean check [][] =new boolean[m][n];  //是否遍历
            int [] nmt= {0,n,m};

            //外圈排水----------------------------------------------------------------------------
            for (i = 0; i < m; i++) {   //meiyi 需要
               // if(!check[i][0])
                {
                    check[i][0]=true;
                    if (floor[i][0] != 1) {Checking(floor,check,nmt,i,0);}
                     else insWall--;
                }
               //if(!check[i][n-1])
               {
                   check[i][n-1]=true;
                   if (floor[i][n - 1] != 1) {Checking(floor,check,nmt,i,n-1);}
                   else insWall--;
               }

            }
            for (j = 1; j < n - 1; j++) {
                //if(!check[0][j])
                {
                    check[0][j]=true;
                    if (floor[0][j] != 1) {Checking(floor,check,nmt,0,j);}
                    else insWall--;//System.out.println("qiang "+0+","+j);}
                }
               // if(!check[m-1][j])
                {
                    check[m-1][j]=true;
                    if (floor[m - 1][j] != 1) {Checking(floor,check,nmt,m-1,j);}
                    else insWall--;
                }

            }
                              //-漏的水(内层)-内层墙
            floorwater=floorwater+nmt[0]-insWall;
           // floorwater=floorwater<0 ? 0:floorwater;

            water+=floorwater;
            //System.out.println("H:"+h+",  flooewater"+floorwater+", 漏水"+nmt[0]+",  内墙"+insWall+",  宗强"+wallNum);
            print(floor);
        }
        return water;
    }










    public static void main(String[] args) throws Exception {
        int [][] floor= { //[[5,8,7,7],[5,2,1,5],[7,1,7,1],[8,9,6,9],[9,8,9,9]]
                {5,8,7,7},{5,2,1,5},{7,1,7,1},{8,9,6,9},{9,8,9,9}
        };
        Solution2 s =new Solution2();


        System.out.println(s.trapRainWater(floor));

    }
}