
package atmPackage;

import javax.swing.JOptionPane;

 

public class CIS163Dialog
{
    public static String getString( String prompt, String suggestion )
    {
        String response = (String)JOptionPane.showInputDialog( prompt, suggestion );

        if (response == null)
        {
            response = "";
        }
        return response;
    }

    public static double getDouble( String prompt, String suggestion )
    {
        String response = CIS163Dialog.getString( prompt, suggestion );

        if (response.equals( "" ))
        {
            response = "0.0";
        }

        return Double.parseDouble( response );
    }
    
    public static int getInt( String prompt, String suggestion )
    {
        String response = CIS163Dialog.getString( prompt, suggestion );

        if (response.equals( "" ))
        {
            response = "0";
        }

        return Integer.parseInt( response );
    }
}