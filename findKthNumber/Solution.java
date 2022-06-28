import java.util.*;

class Solution {
    public int findKthNumber(int n, int k) {
        int deep=0;
        int temp =n;
        int ans=0;

        if(n<10 ) return k;

        while(  temp >= 9  ) {deep++; temp/=10; }

        int block=0;

        temp=deep;
        while(temp-- > 0) block=block*10+1;
        int cc= n -(int)Math.pow(10,deep) +1;
        System.out.println("CCCCCCC: "+cc+" DEEP: "+deep +" block: "+block );


        List<Integer> list = new LinkedList<>();
        list.add(0,1);


        if(cc==0 || k> block+cc  || k > cc*deep)
        {
            k-=cc;

            ans =(k/  (block-( 0) ))+1;
            int loc =(k-1) % block  ;

            temp=deep-1;

            System.out.println("DEEP : "+deep+" block : "+block +" ans :" +ans +" , "+ loc + " ,--------  " );



            while(temp-- > 0)
            {
                //   System.out.println(temp);
                block=   block/10 ;
                if(block==1 ) {
                    //  System.out.println(ans+", !!!!!!!!!!!  "+ loc);
                    if(loc==0) return ans/10;
                    else if(loc==1) return ans;

                    ans=ans*10+loc-1;
                    return ans;
                }

                ans=ans*10+ ( (loc-1) / block )   ;

                loc =(loc-1) % block  ;
                System.out.println( temp+"--   ans ="+ans +" , loc ="+ loc + " ,  " +" , "+block);

            }
        }
        Map<Integer,Integer> map =new HashMap<>();

        




        return ans-1;
    }
}