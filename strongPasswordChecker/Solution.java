package strongPasswordChecker;

class Solution {
    public int strongPasswordChecker(String password) {

        boolean bw= false,lw = false,nm= false;
        int n =password.length();
        if(n<3) return 6-n;

        int sanlian=0;
        int san =1;

        char last = password.charAt(0);

        for(int i =0;i< n;i++){
            if( password.charAt(i) ==last) {san++;if(san==2) {san=0; sanlian++;}}
            else {san=0;}
            last=password.charAt(i);
          if(47< last && last <58) nm=true;
          else  if(64< last &&last <91) bw=true;
          else  if(96< last && last <123) lw=true ;

        }
        if(bw && lw && nm){
            if(5<n && n<21  )  {if(sanlian==0) return 0; else return sanlian;}
            else if( n<6 ) { if (sanlian==0) return 6-n; return 2;}
            else return n-20+Math.max(sanlian-n+20,0);
        }
        else {
            int must =0;
            if(bw) must++; if(lw) must++; if(nm) must++;
            if(n<6){
                return 6-n+ Math.max((3-must),sanlian) ;
            }
            else  if(5<n && n<21) {
                return  Math.max((3-must),sanlian) ;

            }
        }

        return 0;

    }


    public  static  void main(String a[]){
         System.out.println('a'-0);
    }
}