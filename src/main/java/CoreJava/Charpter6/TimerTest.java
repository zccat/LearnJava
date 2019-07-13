package CoreJava.Charpter6;

import org.apache.poi.ss.formula.functions.T;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest {

    public static void main(String[] args) {
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(1000,listener);
        t.start();
        JOptionPane.showConfirmDialog(null,"Quit program?");
        System.exit(0);

    }
}

class TimerPrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("At the tone, the time is "+ new Date());
//        Toolkit.getDefaultToolkit().beep();
    }



}
