package zx.learn.Charpter6;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class innerClassTest {


    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();

        JOptionPane.showConfirmDialog(null,"Exit?");
        System.exit(0);
    }

}


class TalkingClock
{
    private int interVal;
    private boolean beep;

    public TalkingClock(int interVal, boolean beep) {
        this.interVal = interVal;
        this.beep = beep;
    }




    public void start(){
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(interVal, listener);
        t.start();
    }



    public class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
//            if(beep) Toolkit.getDefaultToolkit().beep();
            if(beep) System.out.println("beep!!!");

        }
    }
}

