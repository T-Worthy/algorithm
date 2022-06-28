package WXQ;

 class MyThread extends Thread {
     public static int flag=1;
     int wxq;
     MyThread(int i){wxq=i;}
     public void run(){
          super.run();
          if(wxq==1) {
               while (MyThread.flag !=1);
               System.out.print("A");
               MyThread.flag = 2;
          }
          else if(wxq ==2){
              while (MyThread.flag !=2);
               System.out.print("B");
               MyThread.flag = 3;
          }
          else if(wxq==3) {
              while (MyThread.flag !=3);
               System.out.print("C");
               MyThread.flag = 1;
          }
     }
}
class wxq {
     public static void main(String[] args) {
          MyThread t1 = new MyThread(1);
          MyThread t2 = new MyThread(2);
          MyThread t3 = new MyThread(3);
              t1.start();
              t2.start();
              t3.start();

     }
}