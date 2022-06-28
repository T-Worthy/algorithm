package findRestaurant599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

         int n1 =list1.length ,n2= list2.length;

        List<String> ret = new ArrayList<String>();

         int indexSum =0;
         boolean flag_fin =false;
         for(  ; indexSum <n1+n2;indexSum++){
             for(int i = 0; i<= indexSum  &&i<n1;i++){
                      int j =indexSum-i;
                      if(j<n2 && list1[i].equals(list2[j])){
                          flag_fin=true;
                          ret.add(list1[i]);

                      }
                      if(flag_fin) return   ret.toArray(new String[ret.size()]);

             }



         }


        return  new String[0];




    }
}