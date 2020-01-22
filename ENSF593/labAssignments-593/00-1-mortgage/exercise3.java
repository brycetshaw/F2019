package assignment1;
import javax.swing.*;
public class exercise3 {
	public static void main (String [] args) {
	
		String morgageType;
		String answer;
		int morgageLength;
		
		JOptionPane.showMessageDialog(null, "Ok. so you want a morgage...");
do {
		do {	
			answer = JOptionPane.showInputDialog("Would you like a closed or open morgage?");
			morgageType = answer;
			
			if (!(morgageType.equals("closed") || morgageType.equals("open"))) {
				JOptionPane.showMessageDialog(null, "The option are 'closed' or 'open'. Thanks.");
			}
		} while (!(morgageType.equals("closed") || morgageType.equals("open")));
		
		
		do {
			answer = JOptionPane.showInputDialog("What term length would you like? Options are 1, 3, 5 year.");
			morgageLength = Integer.parseInt(answer); 
			if (!(morgageLength == 1 || morgageLength == 3 || morgageLength == 5)) {
				JOptionPane.showMessageDialog(null, "The option are 1,3,5. Thanks.");
			}
		} while (!(morgageLength == 1 || morgageLength == 3 || morgageLength == 5));
		
		
		if(morgageType.equals("open") && morgageLength == 5) {
			JOptionPane.showMessageDialog(null, "A 5 year morgage is not available with an open term. Sorry.");
			}

} while (morgageType.equals("open") && morgageLength == 5);
		
			
				
	int rateColumn = (morgageType.equals("open"))?0:1;
	double[][] rateArray = {{7.1, 7.5, -999}, {5.3, 5.00, 5.75}};		
	double rate = rateArray[rateColumn][(morgageLength+1)/2-1];		
	JOptionPane.showMessageDialog(null, "Your interest rate would be " + rate + "% for a " + morgageLength + " year " + morgageType + " morgage. Congrats.");
				
		}
		}









