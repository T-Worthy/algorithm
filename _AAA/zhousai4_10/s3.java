package _AAA.zhousai4_10;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class s3 {
    public int maximumProduct(int[] nums, int k) {

         int   mod=1000000007;
        TreeMap<Integer,Integer> tm =new TreeMap<>();
        for(int i: nums)   tm.put(i, tm.getOrDefault(i,0)+1);
     //  tm.forEach( (e,y)->{System.out.print(e+":"+y+ ",");}); System.out.println();

          int nm,NN,nx; long ans=1;
          while(k>0){               //  tm.forEach( (e,y)->{System.out.print(e+":"+y+ ",");}); System.out.println(" ::> "+k);
            nm=  tm.firstKey();
            NN =tm.get(nm);  tm.remove(nm);
           if(tm.size()==0) {
                  nx= nm+k/(NN);int yu = k%NN;
                      return  (int) ((  Math.pow(nx, (NN-yu) ) %mod  )*( Math.pow(nx+1,yu ) %mod ) %mod) ;
           }
           nx=tm.firstKey();
              if(k< (nx-nm)*NN){ //凑不多
                  nx= nm+k/(NN);int yu = k%NN;

                  tm.put( nx, tm.getOrDefault( nx,0 ) +((NN-yu)) );
                  tm.put( nx+1, tm.getOrDefault( nx+1,0 ) +((yu)) );
                //  System.out.println(ans);
                  break;
              }
            else {
                tm.put(nx, tm.getOrDefault(nx,0)+NN);
                k-= (nx-nm) * NN;
            }

          }
       // tm.forEach( (e,y)->{System.out.print(e+":"+y+ ",");}); System.out.println("!!"+ans);

          for(int i : tm.keySet()){
              NN=tm.get(i);
              for(int j =0;j< NN;j++ )
                   ans= (ans*i) %mod;
             // else
           //   ans=(long) ( ( ans *  (  Math.pow(i,tm.get(i) ) % mod  )  ) % mod);
          }
     return  (int)ans;

    }

    public static void main(String[] args) {

        int[] a={571,478,284,91,439,93,574,176,236,104,810,137,986,534,330,266,351,629,466,133,94,207,288,27,388,705,248,536,289,879,469,58,350,691,703,238,79,67,410,974,747,664,364,823,422,665,923,886,56,77,317,826,339,264,120,206,215,428,737,386,804,291,293,438,307,599,619,393,95,419,436,564,629,532,993,76,59,535,507,336,998,274,897,985,148,539,34,259,253,281,525,259,674,544,203,104,371,118,344,782,399,606,548,531,612,186,712,756,848,585,293,625,547,62,281,654,536,409,941,700,804,113,883,851,707,826,308,855,582,293,787,141,812,323,413,343,838,537,553,935};
        s3 s = new s3();
        System.out.println(s.maximumProduct(a,955));

       /* int   mod=1000000007;
        long ans= (long)(  Math.pow(145,3)*Math.pow(264,3 )   )%mod;
        System.out.println( ans);
        ans= (long)(  Math.pow(145,3)   *Math.pow(264,3 ) %mod  )%mod;
        System.out.println( ans);

         ans= (long) ((   (Math.pow(145,3) %mod  )*  (Math.pow(264,3 )%mod )  )%mod);
        System.out.println( ((   (Math.pow(145,3) %mod  )*  (Math.pow(264,3 )%mod )  )%mod));

        ans=145;
        System.out.println( (ans*264*264*264)%mod );*/
    }

}
