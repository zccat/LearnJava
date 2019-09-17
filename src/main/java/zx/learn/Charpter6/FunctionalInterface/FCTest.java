//package zx.learn.Charpter6.FunctionalInterface;
//
//import org.apache.poi.ss.formula.functions.T;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//
//public class FCTest {
//
//
//    public static void main(String[] args) {
//        TimedGreeter timedGreeter = new TimedGreeter();
//        timedGreeter.greet();
//        JOptionPane.showConfirmDialog(null, "quit?");
//        System.exit(0);
//
//    }
//
//}
//
//
//
//class Greeter
//{
//    public void greet()
//    {
//        System.out.println("Hello World!");
//    }
//}
//
//class TimedGreeter extends Greeter
//{
//    public void greet()
//    {
//        Timer t = new Timer(1000, super::greet);
//        t.start();
//    }
//}