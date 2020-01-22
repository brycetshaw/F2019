package ensf593lab1;
import java.util.Scanner;

public class MultidimensionalArrays {
	public static void main (String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] sentences = new String[3];
		System.out.println("input 3 sentences please. cannot exceed 60 characters.");
		
		for(int i = 0; i < sentences.length; i++) {
			
			do {
				sentences[i] = scan.nextLine();
				if(sentences[i].length() > 60) {System.out.println("sentence can't exceed 60 characters. try again.");}
			}
			while (sentences[i].length() > 60);
			
		//	sentences[i] = scan.nextLine();
		}
		String[] parsedSentences = {"","",""};
		
		for(int i = 0; i < sentences[0].length();i++) {
			parsedSentences[0] += sentences[0].charAt(sentences[0].length()-i-1);
		}
		
		String[] splitted = sentences[1].split("\\s+");	
		for(int j=0; j < splitted.length;j++) {
			parsedSentences[1] += splitted[splitted.length - j -1] + " ";
		}
		
		for(int i = 0; i<sentences[2].length();i++) {
			if(i%5==0) {
				parsedSentences[2] += Character.toUpperCase(sentences[2].charAt(i));
			}
			else {
				parsedSentences[2] += sentences[2].charAt(i);
			}
		}
		for(int i = 0; i<parsedSentences.length;i++) {

			System.out.println(parsedSentences[i]);
		}
		scan.close();
}
}