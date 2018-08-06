package edu.njpi.fleming.thread;

import java.awt.*;
import java.awt.event.KeyEvent;

public class R8 extends Thread{

    private static boolean isR8Stop;

    public static void setIsR8Stop(boolean newStop){
        isR8Stop = newStop;
    }

    @Override
    public void run() {

        isR8Stop = false;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        while (!isR8Stop) {
            robot.setAutoDelay(2000);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.setAutoDelay(500);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

    }
}
