package numUniqueEmails;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Solution {
    double radius,  x_center,  y_center;
    Random ram;
    public Solution(double r, double x, double y) {
               radius=r;
               x_center=x;
               y_center=y;
               ram= new Random();
    }

    public double[] randPoint() {

           double x= (ram.nextBoolean()? 1:-1)*ram.nextDouble()*radius;
           double y=(ram.nextBoolean()? 1:-1)*ram.nextDouble()*radius;

           while(x*x+y*y>radius*radius){
               x= (ram.nextBoolean()? 1:-1)*ram.nextDouble()*radius;
               y=(ram.nextBoolean()? 1:-1)*ram.nextDouble()*radius;
           }
           double ans[] = new double[2];
        ans[0]=x_center+x;
        ans[1]=y_center+y;
        return  ans;
    }
}