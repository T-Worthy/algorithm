package _AAA.sad;

public class ttt {

    public int fib(int n) {
        int mod =1000000007;
        if(n==0) return 0;
        if(n<3) return 1;
        int a=1, b=1;
        boolean Aflag =true;
        for(int i =3 ;i<=n ;i++, Aflag=!Aflag){
            if(Aflag) a=(a+b)%mod ;
            else b=(a+b)%mod ;
        }
        if(Aflag) return b;
        return a;

    }

    public boolean dido(int i ){
        boolean last=(i%2==0);
        i/=2;
        boolean now=(i%2==0);

              while(i>0){

                  if( (last && !now) ||(!last && now)) { last=now ;  i/=2; now=(i%2==0); }
                  else  return false;
              }
              return true;
    }
    public static void main(String[] args) throws Exception {

for(int i =0 ;i<100 ;i++)
        System.out.println(i+": "+ ((-i)&i)+"  :: "+Integer.toBinaryString(i));


    }


}
