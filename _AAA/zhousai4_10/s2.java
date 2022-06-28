package _AAA.zhousai4_10;

import java.util.Arrays;

public class s2 {
    public String minimizeResult(String expression) {
             String[] nn=expression.split("[+]");
       if(nn.length==3) return "("+expression+")";
             int n1=Integer.parseInt(nn[0]);

             int n2= Integer.parseInt(nn[1]);
             int len1=nn[0].length(), len2=nn[1].length();

             int A[][]=new int[len1][2];  int B[][]= new int[len2][2];

             A[0][0]=0; A[0][1]=n1;
             int index=1,k=10;
             while(index<len1){
                 A[index][0]= n1/k;
                 A[index][1]= n1%k;
                 k*=10;index++;
             }


        B[0][0]=n2; B[0][1]=0;
         index=1;k=10;
        while(index<len2){
            B[index][0]=n2/k;
            B[index][1]= n2%k;
            k*=10;index++;
        }

      //  Arrays.stream(A).forEach(kk->{ System.out.print("{");  Arrays.stream(kk).forEach(e->{System.out.print(+e+ ",");});System.out.println("}"); });
    //    Arrays.stream(B).forEach( kk->{ System.out.print("{");  Arrays.stream(kk).forEach(e->{System.out.print(+e+ ",");});System.out.println("}"); });


        int Min=n1+n2;
        String ans="("+expression+")";

             int a1,a2,b1,b2;
             for( int i =0; i< len1;i++){
                 a1=A[i][0];
                 a2=A[i][1];
                    for( int j =0;j<len2;j++){
                         b1=B[j][0] ;
                         b2=(B[j][1]);
                         int kkk=   (a1==0?1:a1) * (a2+ b1)*  (b2==0?1:b2);
                         if(kkk<Min) {  Min=kkk;

                             ans=""+(a1==0?"":a1) +"("+(a2==0?"":a2)+"+"+b1+")"+(b2==0? "": b2);
                           //  System.out.println(kkk+" ,"+a1+","+a2+","+b1+","+b2);
                         }
                    }

             }
             return  ans;
    }

    public static void main(String[] args) {
       s2 s= new s2();
        System.out.println(s.minimizeResult("247+38"));
    }

}
