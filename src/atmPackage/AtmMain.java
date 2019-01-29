package atmPackage;

import java.awt.*;
import javax.swing.*;


public class AtmMain {

	final static int SIZE = 650;
	final static int SIZE_2 = 700;
    
    public static void main(String[] args) {

    	
        JFrame frame = new JFrame("          ATM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFrame frame2 = new JFrame("          ATM");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFrame frame3 = new JFrame("          ATM");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AtmPanel panel = new AtmPanel();
        frame.getContentPane().add(panel);

        AtmPanel panel2 = new AtmPanel();
        frame2.getContentPane().add(panel2);
        
        AtmPanel panel3 = new AtmPanel();
        frame3.getContentPane().add(panel3);
        
        

        frame.pack();
        frame.setVisible(true);
        frame2.pack();
        frame2.setVisible(true);
        frame3.pack();
        frame3.setVisible(true);
        
        frame.setSize(SIZE, SIZE_2);
        frame2.setSize(SIZE, SIZE_2);
        frame3.setSize(SIZE, SIZE_2);
        
    }
}