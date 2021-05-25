package com.grand.ch06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TalkingClock {
    private int interval;
    private boolean beep;

    /*
    * Constructs a talking clock
    * @param interval the interval between messages (in milliseconds)
    * @param beep true if the clock should beep
    * */
    public TalkingClock(int interval,boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    /*
    * Starts the clock
    * */
    public void start(){
        ActionListener listener = new TimePrinter();
        javax.swing.Timer t = new Timer(interval, listener);
        t.start();
    }

    /*
    * 局部内部类
    * 由于上文中内部类只在start方法中使用过一次，其实可以使用局部内部类来代替
    * 局部类不能使用public或private访问说明符进行声明。它的作用域被限定在声明这个局部类的块中。
    * 局部内部类中有一个优势，对外部世界 可以完全隐藏起来，除了start1方法外谁也不能访问它。
    * */
    public void start2(){
        class TimePrinter implements ActionListener{
            public void actionPerformed(ActionEvent event){
                System.out.println("At the tone, the time is" + new Date());
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval,listener);
        t.start();
    }
    /*
    * 内部类不仅能够访问包含他们的外部类，还可以访问局部变量
    * 不过这些局部变量必须事实上为final，说明一旦赋值就不会改变
    * */
    public void start3(int interval, boolean beep){
        class TimerPrinter implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is" + new Date());
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(interval,listener);
        t.start();
    }

    public class TimePrinter implements ActionListener{
        public void actionPerformed(ActionEvent event){
            System.out.println("At the tone, the time is" + new Date());
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
