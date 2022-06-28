package deleteAndEarn;

import java.util.*;

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int zeroIndex=0;

       List<int [] > list =new ArrayList<>();
       Set<Integer> set = new HashSet<>();

        int last = arr[0];
        int index=0;
        int [] firsr={arr[0],0};
        list.add( firsr);    set.add(arr[0]);
        for(int i : arr){
               if(last== i ) list.get(index)[1]++;
               else{
                   int a[]={arr[i],1};
                   last=i;
                   set.add(i);
               }
               if(i<=0) zeroIndex++;
        }

        for(int i =0 ;i<= zeroIndex ;i++){
            if(list.get(i)[1] !=0 ){

            }

        }




//         //////***************************************
//        Arrays.sort(A, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
/*

        int i =0;
        for ( ;i< n && arr[i]<=0  ;i++ ){
            if(arr[i]%2!=0 ||  !map.containsKey(arr[i])) return false;
            else {
                if(map.get(arr[i])==1) map.remove(arr[i]);
                else map.put(arr[i],map.get(i)-1);
            }
        }

        int j=n-1;
        while(i< j){
            if(arr[j]%2!=0 ||  !map.containsKey(arr[j])) return false;
            else {
                if(map.get(arr[j])==1) map.remove(arr[j]);
                else map.put(arr[j],map.get(j)-1);
            }
            j--;
        } */
        return  true;



    }
}