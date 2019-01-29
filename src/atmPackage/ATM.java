/*******************************************************
 * The ATM class writes the code for the ATM. 
 * 
 * @author Blake Lapum
 * @version January 2017
 *******************************************************/

package atmPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.util.Scanner;


public class ATM {
    private int hundreds;
    private int fifties;
    private int twenties;
    private boolean suspend = false;
    
    /*****************************************************
    Starting values for ATM. 
    @param Constructor for the class ATM. 
     *****************************************************/  
    public ATM() {
    	hundreds = 0;
    	fifties = 0;
    	twenties = 0;
    }
    
    /*****************************************************
    Creates methods that set the values of the instance variables
    and methods that retrieve the value of the instance variables. 
    @param The setter and getter methods. 
     *****************************************************/  
    
    //sets the amount of hundreds
    public void setHundreds(int h) {
    	hundreds = h;
    }
    
    //sets the amount of fifties
    public void setFifties(int f) {
    	fifties = f;
    }
    
    //sets the amount of twenties
    public void setTwenties(int t) {
    	twenties = t;
    }
    
    //retrieves the amount of hundreds
    public int getHundreds() {
    	return hundreds;
    }
    
    //retrieves the amount of fifties
    public int getFifties() {
    	return fifties;
    }
    
    //retrieves the amount of twenties
    public int getTwenties() {
    	return twenties;
    }
    
    /*****************************************************
    Constructor initializing the instance variables with the parameters
    @param hundreds, fifties, and twenties
     *****************************************************/ 
    public ATM ( int hundreds, int fifties, int twenties ) {
        if(hundreds < 0 || fifties < 0 || twenties < 0) {
            throw new IllegalArgumentException();
        }
        this.hundreds = hundreds;
        this.fifties = fifties;
        this.twenties = twenties;
    }
    
    
    
    /*****************************************************
    Constructor initializing the instance variable with the 
    other ATM parameter
    @param ATM other
     *****************************************************/ 
    public ATM(ATM other) {
        hundreds = other.hundreds;
        fifties = other.fifties;
        twenties = other.twenties;
    }
    
    
    
    /*****************************************************
    Converts the hundreds, fifties, and twenties into total dollars.
    @param 
     *****************************************************/ 
    private int convertToDollars() {
        return (this.hundreds * 100) + (this.fifties * 50) + (this.twenties * 20); 
    }
    
    

    /*****************************************************
    Checks if ATM objects are exactly the same.
    @param ATM other
     *****************************************************/ 
    public boolean equals(ATM s) {
        return (this.convertToDollars() == s.convertToDollars());
    }

    
    
    /*****************************************************
    Returns true if ATM objects are the same. 
    @param Object other
     *****************************************************/ 
    public boolean equals(Object s) {
        return this.equals((ATM)s);
    }


    
    /*****************************************************
    Compares if two dollar amounts are the exact same
    @param ATM other
     *****************************************************/ 
    public int compareTo(ATM s) {
        if(this.convertToDollars() > s.convertToDollars()) {
            return 1;
        } else if (this.convertToDollars() < s.convertToDollars()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    

    /*****************************************************
    sets suspend to not suspend. 
    @param 
     *****************************************************/ 
    public void toggleSuspend() {
        suspend = !suspend;
    }

    
    
    /*****************************************************
    Method adds ATM other to this ATM
    @param ATM other
     *****************************************************/ 
    public void putIn(ATM other) {
        if(suspend) {
            return;
        }
        this.hundreds += other.hundreds;
        this.fifties += other.fifties;
        this.twenties += other.twenties;
    }
 
    
    
    /*****************************************************
    Adds the parameters to this ATM object. 
    @param hundreds, fifties, twenties
     *****************************************************/ 
    public void putIn(int hundreds, int fifties, int twenties) {
    	if(suspend) {
    		return;
    	}
    	if(hundreds >= 0 && fifties >= 0 && twenties >= 0) {
    		this.hundreds += hundreds;
    		this.fifties += fifties;
    		this.twenties += twenties;
    	}
    	else {
			throw new IllegalArgumentException();
    	}	
    }
    

    
    /*****************************************************
    Subtracts the parameters from this ATM object. 
    @param hundreds, fifties, twenties
     *****************************************************/ 
    public void takeOut(int hundreds, int fifties, int twenties) {
    	if(suspend) {
    		return;
    	}
    	if(hundreds >= 0 && fifties >= 0 && twenties >= 0) {
    	this.hundreds -= hundreds;
    	this.fifties -= fifties;
    	this.twenties -= twenties;

    		
    	}
    	else {
			throw new IllegalArgumentException();
    	}
    }
    
    
    
    /*****************************************************
    Subtracts ATM other from this ATM object. 
    @param ATM other
     *****************************************************/ 
    private void subtract(ATM other) {
    	this.hundreds -= other.hundreds;
    	this.fifties -= other.fifties;
    	this.twenties -= other.twenties;

    }
    
    
    
    /*****************************************************
    checks which bills to take out when a certain amount
    is taken out. 
    @param totalAmount withdrawn
     *****************************************************/ 
	public ATM takeOut(int totalAmount) {
		if(suspend) {
			return new ATM ();
		}
		
		int a, b, c;
		if (totalAmount < 0 || totalAmount % 10 != 0) {
			throw new IllegalArgumentException();
		}
		if (totalAmount <= this.convertToDollars()) {
			for (c = 0; c <= this.twenties; c++) {
				for (b = 0; b <= this.fifties; b++) {
					for (a = 0; a <= this.hundreds; a++) {

						if(a * 100 + b * 50 + c * 20 == totalAmount) {
							ATM apple = new ATM(a, b, c);
							this.subtract(apple);
							return apple;
						}
					}
				}
			}
		}
		return new ATM (0, 0, 0);
	}
    
	
	
	/*****************************************************
    Returns the string of how many of each bill there is. 
    @param 
     *****************************************************/ 
    public String toString() {
    	return hundreds + " hundred dollar bills \n" +
    	fifties + " fifty dollar bills \n" + twenties + 
    	" twenty dollar bills \n";
    }
    
    
    
    /*****************************************************
    Saves this ATM file
    @param String filename
     *****************************************************/ 
    public void save(String fileName) {
    	PrintWriter out = null;
    	try {
    		out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	out.println(this.hundreds + " " + this.fifties + " " + this.twenties);
    	out.close();
    }
    
    
    
    /*****************************************************
    Loads a saved ATM file. 
    @param String filename
     *****************************************************/ 
    public void load(String fileName) {
    	Scanner scanner = null;
    	try {
    		scanner = new Scanner(new File(fileName));
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	this.hundreds = scanner.nextInt();
    	this.fifties = scanner.nextInt();
    	this.twenties = scanner.nextInt();
    	scanner.close();
    }
    
    
    /*****************************************************
    Turns on or off specific methods
    @param Boolean on
     *****************************************************/ 
    public void suspend() {
    	if(suspend) {
    		suspend = false;
    	}
    	else {
    		suspend = true;
    	}
    }
}

