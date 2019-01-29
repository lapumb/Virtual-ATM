package atmPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class AtmSubpanel extends JPanel {

	private JLabel dollarsLbl, hundredsLbl, fiftiesLbl, twentiesLbl;
	public JLabel dollars, hundreds, fifties, twenties;

	public AtmSubpanel(String signature, String str2 ) {
		
		this.setLayout(new GridLayout(5, 2));
		this.setPreferredSize(new Dimension(400, 400));
		this.setBackground(Color.green);

		
		Font font = new Font ("Helvetica", Font.PLAIN, 16);

		
		this.dollarsLbl = new JLabel("dollar amount");
		this.dollarsLbl.setFont( font );
		
		this.dollars = new JLabel("");
		this.dollars.setFont( font );
		
		this.hundredsLbl = new JLabel("hundreds");
		this.hundredsLbl.setFont( font );
		
		this.hundreds = new JLabel("");
		this.hundreds.setFont( font );
		
		this.fiftiesLbl = new JLabel("fifties");
		this.fiftiesLbl.setFont( font );
		
		this.fifties = new JLabel("");
		this.fifties.setFont( font );

		this.twentiesLbl = new JLabel("twenties");
		this.twentiesLbl.setFont( font );
		
		this.twenties = new JLabel("");
		this.twenties.setFont( font );


		this.add(this.hundredsLbl);
		this.add(this.hundreds);
		
		this.add(this.fiftiesLbl);
		this.add(this.fifties);
		
		this.add(this.twentiesLbl);
		this.add(this.twenties);
		
		this.add(this.dollarsLbl);
		this.add(this.dollars);
		
		this.add(new JLabel(signature));
		this.add(new JLabel(str2));
	}
}