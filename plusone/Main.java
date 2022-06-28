package plusone;

public class Main {
    public int[] plus(int [] digits, int l ){

        if(digits[l-1]!=9){
            digits[l-1]+=1;
            return digits;
        }
        else {
            digits[l-1]=0;
            if(l>1)  return plus(digits,l-1);
            return digits;
        }

    }
    public int[] plusOne(int[] digits) {

        if (digits==null){ return digits;}
        int l = digits.length;

        plus(digits,l);
        if(digits[0]==0){
            int[] p =new int[l+1];
            p[0]=1;
            int i =1;
            System.arraycopy(digits,0,p,1,l);
            return p;
        }
        return digits;

    }
    public static void main(String[] args) throws Exception {
     int[] a={9,9,9,9};
      Main m=new Main();
      int p[]=m.plusOne(a);
      for (int i : p){
        System.out.print(i+" ");}
    }
}