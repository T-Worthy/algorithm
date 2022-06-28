package rectWEB;


class Solution {
    public int[] constructRectangle(int area) {

        int[ ] LW ={1,1};
       // if(area ==1 ) return  LW;

        double f= Math.sqrt(area)+0.999;
        LW[0]= (int) f;
        LW[1]=LW[0];
        while(LW[0]*LW[1]!=area) {
            LW[1]-=1;
            LW[0]=area/LW[1];
        }
        return LW;
    }


    public static void main(String[] args) throws Exception {

     Solution a= new Solution();
    int[] p = a.constructRectangle(1);

       System.out.println(p[0]+"??"+p[1]);
        System.out.println(' '+0);

    }
}