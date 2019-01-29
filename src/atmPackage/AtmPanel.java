package atmPackage;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmPanel extends JPanel {

    private ATM jar;
    private ATM bones;
    

    
 
    private JButton putInBtn, takeOutBtn, suspendBtn;
    
    private JPanel buttonPanel, suspendPanel;
    private AtmSubpanel topPanel, receiptPanel; 
    
    Listener listener1 = new Listener();

    public AtmPanel() {
        this.setLayout (new GridLayout (2, 1));
        this.setBackground (Color.green);
	
        this.jar = new ATM(0,0,0);
        this.bones = new ATM(0, 0, 0);
               
        this.putInBtn = new JButton("Put In");
        this.putInBtn.setBackground( Color.cyan );
        this.takeOutBtn = new JButton("Take Out");
        this.takeOutBtn.setBackground( Color.red );
        this.suspendBtn = new JButton ("Suspend");
        this.suspendBtn.setBackground(Color.ORANGE);

		this.putInBtn.addActionListener(listener1);
		this.takeOutBtn.addActionListener(listener1);
		this.suspendBtn.addActionListener(listener1);

		this.topPanel = new AtmSubpanel("", "ATM current status");
		
		this.buttonPanel = new JPanel();
		this.buttonPanel.setLayout(new GridLayout(1, 2));
		this.buttonPanel.setPreferredSize(new Dimension(200, 40));
		this.buttonPanel.setBackground(Color.blue);
		this.buttonPanel.add(putInBtn);
		this.buttonPanel.add(takeOutBtn);

		this.receiptPanel = new AtmSubpanel("Please take your reciept.", " Thank you.");
		this.receiptPanel.setBackground(Color.white);	
		
		this.suspendPanel = new JPanel();
		this.suspendPanel.setLayout(new GridLayout(1, 2));
		this.suspendPanel.setPreferredSize(new Dimension(200, 40));
		this.suspendPanel.setBackground(Color.ORANGE);
		this.suspendPanel.add(suspendBtn);
		
		
		this.setPreferredSize(new Dimension(300, 300));
		this.setBackground(Color.black);
	
		this.add(this.topPanel);
		this.add(this.buttonPanel);
		this.add(this.receiptPanel);
		this.add(this.suspendPanel);
		
        
       this.updateATM();
       this.writeReceipt();
    }
    
   

    
	private void putIn() {
		String hundreds = CIS163Dialog.getString("Amount of hundreds", "1");
		String fifties = CIS163Dialog.getString("Amount of fifties", "1");
		String twenties = CIS163Dialog.getString("Amount of twenties", "1");

		jar.putIn(Integer.parseInt(hundreds), Integer.parseInt(fifties), Integer.parseInt(twenties));
	}
	
	
  
	
	private void takeOut()
	{
		String amount = CIS163Dialog.getString("Amount", "150");
		
		bones = jar.takeOut(Integer.parseInt(amount));
	}	
	
    private void updateATM()
    {    	


    	this.topPanel.hundreds.setText("" + jar.getHundreds());
    	this.topPanel.fifties.setText("" + jar.getFifties());
    	this.topPanel.twenties.setText("" + jar.getTwenties());
    	

    	this.topPanel.dollars.setText("$" + topTotalDollars());
    	this.receiptPanel.dollars.setText("$" + receiptTotalDollars());
    	
    	writeReceipt();

    }
    
    
    private void writeReceipt()
    {

    	this.receiptPanel.hundreds.setText("" + bones.getHundreds());
    	this.receiptPanel.fifties.setText("" + bones.getFifties());
    	this.receiptPanel.twenties.setText("" + bones.getTwenties());
    }
    
    private int topTotalDollars() {
    	int total = jar.getHundreds() * 100 + jar.getFifties() * 50 + jar.getTwenties() * 20;
    	return total;
    }
    
    private int receiptTotalDollars() {
    	int total = bones.getHundreds() * 100 + bones.getFifties() * 50 + bones.getTwenties() * 20;
    	return total;
    }
    

    
    
   private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == putInBtn) {
				putIn();
			}
			else if(e.getSource() == takeOutBtn) {
				takeOut();
			}
			else if(e.getSource() == suspendBtn) {
				jar.suspend();
			}
			
			updateATM();
		}
    }
    
}