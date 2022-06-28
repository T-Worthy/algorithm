package Timer;


import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

class Jpanell extends JPanel {
    private int hour;
    private int minute;
    private int second;
    private  Calendar a=new GregorianCalendar();
    public Jpanell(){
        this.hour=a.get(Calendar.HOUR_OF_DAY);
        this.minute=a.get(Calendar.MINUTE);
        this.second=a.get(Calendar.SECOND);
    }
    public void setTiao(){
        a=new GregorianCalendar();
        this.hour=a.get(Calendar.HOUR_OF_DAY);
        this.minute=a.get(Calendar.MINUTE);
        this.second=a.get(Calendar.SECOND);
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int w=getWidth()/2;
        int h=getHeight()/2;
        int zhi=Math.min(w, h);
        g.drawOval(w-zhi/2, h-zhi/2, zhi,zhi);
        int shi=(int)(zhi/4);
        int fen=(int)(zhi/2*0.6);
        int miao=(int)(zhi/2*0.8);
        g.drawString("12", w-5,h-zhi/2+10);
        g.drawString("6", w, h+zhi/2);
        g.drawString("9", w-zhi/2+1, h);
        g.drawString("3", w+zhi/2-6, h);
        g.drawLine(w, h,w+(int)(shi*Math.sin((hour+minute/60+second/3600)*2*Math.PI/12)), h-(int)(shi*Math.cos((hour+minute/60+second/3600)*2*Math.PI/12)));//时针
        g.drawLine(w, h, w+(int)(fen*Math.sin((minute+second/60)*2*Math.PI/60)), h-(int)(fen*Math.cos((minute+second/60)*2*Math.PI/60)));//分针
        g.drawLine(w, h, w+(int)(miao*Math.sin((second)*2*Math.PI/60)), h-(int)(miao*Math.cos((second)*2*Math.PI/60)));//秒针
        g.drawString(hour+"："+minute+":"+second+" ", w-30, h+zhi/2+20);
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(100,100);}
}

class NewClass extends JFrame {

    Jpanell a1=new Jpanell();
    public NewClass()
    {add(a1);
        Timer a2=new Timer(1000,new TListener());
        a2.start();
    }
    class TListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            a1.setTiao();}}

}


public class timer {

    public static void main(String[] args) {
        NewClass xue=new NewClass();
        xue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        xue.setVisible(true);
        xue.setTitle("xue");
        xue.setSize(500, 500);
        xue.setLocation(xue.getWidth()-50, xue.getHeight()-350);
    }
}
