package validUtf8_393;

public class tesy {

    public static void printArray(int[] a){
        System.out.print("{");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("}");
    }
    public static void printArray(byte[] a){
        System.out.print("{");
        for (int i = 0 ;i< a.length;i++)
            System.out.print(a[i]+",");
        System.out.println("}");
    }

    public static void main(String[] args)  {

        byte a = -0b0000000;
        byte a3= -0b0111111;


        System.out.println(a+"\n"+a3);

        int ans[] =new int[256];
        byte aans[]=new byte [256];

        byte haha[] ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,-99,-99,-99,-99,-99,-99,-99,-99};


        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+haha[250]);

        for(int i =0 ;i<256 ;i++){
            byte b=(byte) i;
            ans[i]=b;
            if(b>=0) aans[i]=0;
            else if(b<=-65) aans[i]=-1;
            else if(b<=-33) aans[i]=1;
            else if(b<=-17) aans[i]=2;
            else if(b<=-9) aans[i]=3;
            else  aans[i]=-99;


            {
                System.out.println(i+" : "+" , "+b);
                System.out.println(Integer.toBinaryString(i));
                // System.out.println(Integer.toBinaryString(a2));
                System.out.println(Integer.toBinaryString(b));

            }
        }
        for(int i =0 ;i<256 ;i++){
            if(aans[i]!=haha[i]) System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        printArray(ans);
        printArray(aans);


    }
}
