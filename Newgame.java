
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Newgame {
	public static void main(String [] args) {
		System.out.println("Oooo Sh*t! Your girlfriend is locked in a tiny box!");
		System.out.println("Quick, solve the 4 letter code before she gets cramp and dumps your a**.");
		System.out.println( " ");
		System.out.println("The code is in a random order and made from the following letters:");
		System.out.println("a, b, c, d, e, f ");
		System.out.println( " ");

		Code deCode = new Code();
		deCode.codemaken();
		
		Regels regels = new Regels();
		
		Speler speler = new Speler();
		speler.spelen();
		
		
	}
}
class Regels extends Speler{
	
	static void eerstevergelijking() {
		if(spelervergelijking[0] == teraden[0]) {
			dezelfdeplek += 1;
			spelervergelijking [0] = 0;
			teraden[0] = 1;
			return;
		}
	}
	static void tweedevergelijking() {
		if(spelervergelijking[1] == teraden[1]) {
			dezelfdeplek += 1;
			spelervergelijking [1] = 0;
			teraden[1] = 1;
			return;
		}
	}
	static void derdevergelijking() {
		if(spelervergelijking[2] == teraden[2]) {
			dezelfdeplek += 1;
			spelervergelijking [2] = 0;
			teraden[2] = 1;
			return;
		}
	}
	static void vierdevergelijking() {
		if(spelervergelijking[3] == teraden[3]) {
			dezelfdeplek += 1;
			spelervergelijking [3] = 0;
			teraden[3] = 1;
			return;
		}
	}
	
	/* DIT WERKT NIET MEER ........
	 * 
	static void vijfdevergelijking() {
		if(spelervergelijking[0] == teraden[1]){
			inderij += 1;
			System.out.println("works");
			spelervergelijking [0] = 0;
			teraden[1] = 1;
			return;
		}else if(spelervergelijking[0] == teraden[2]) {
			inderij += 1;
			spelervergelijking [0] = 0;
			teraden[2] = 1;
			return;
		}else if(spelervergelijking[0] == teraden[3]) {
			inderij += 1;
			spelervergelijking [0] = 0;
			teraden[3] = 1;
			return;
		}
	}
	static void sesdevergelijking() {
		if(spelervergelijking[1] == teraden[0]) {
			inderij += 1;
			spelervergelijking [1] = 0;
			teraden[0] = 1;
			return;
		}else if(spelervergelijking[1] == teraden[2]) {
			inderij += 1;
			spelervergelijking [1] = 0;
			teraden[2] = 1;
			return;
		}else if(spelervergelijking[1] == teraden[3]) {
			inderij += 1;
			spelervergelijking [1] = 0;
			teraden[3] = 1;
			return;
		}
	}
	static void sevendevergelijking() {
		if(spelervergelijking[2] == teraden[0]) {
			inderij += 1;
			spelervergelijking [2] = 0;
			teraden[0] = 1;
			return;
		}else if(spelervergelijking[2] == teraden[1]) {
			inderij += 1;
			spelervergelijking [2] = 0;
			teraden[1] = 1;
			return;
		}else if(spelervergelijking[2] == teraden[3]) {
			inderij += 1;
			spelervergelijking [2] = 0;
			teraden[3] = 1;
			return;

		}
	}
	static void achtstevergelijking() {
		if(spelervergelijking[3] == teraden[0]) {
			inderij += 1;
			spelervergelijking [3] = 0;
			teraden[0] = 1;
			return;
		}else if(spelervergelijking[3] == teraden[1]) {
			inderij += 1;
			spelervergelijking [3] = 0;
			teraden[1] = 1;
			return;
		}else if(spelervergelijking[3] == teraden[2]) {
			inderij += 1;
			spelervergelijking [3] = 0;
			teraden[2] = 1;
			return;
		}
	}
	*/
	
}



class Speler extends Code{
	static int beurten = 11;
	static String spelerinvoer;
	static char [] spelervergelijking = new char[4];
	static int dezelfdeplek = 0;
	static int inderij = 0;
	
	void spelen() {
		for(int i = 11; i >= 0; i--) {
			Scanner invoer = new Scanner(System.in);
			String scan = invoer.nextLine();
			spelerinvoer = scan;
			
			if(scan.length()<4) {
				System.out.println("You did not enter enough letters. Please start again and enter exactly 4 letters.");
				return;
			}else if(scan.length()>4) {
				System.out.println("You entered too many letters. Please start again and enter exactly 4 letters.");
				return;
			}
			
			spelervergelijking[0] = spelerinvoer.charAt(0);
			spelervergelijking[1] = spelerinvoer.charAt(1);
			spelervergelijking[2] = spelerinvoer.charAt(2);
			spelervergelijking[3] = spelerinvoer.charAt(3);

			Regels.eerstevergelijking();
			Regels.tweedevergelijking();
			Regels.derdevergelijking();
			Regels.vierdevergelijking();
	//		Regels.vijfdevergelijking();
	//		Regels.sesdevergelijking();
	//		Regels.sevendevergelijking();
	//		Regels.achtstevergelijking();
			
			teraden [0] = vasthouden [0];
			teraden [1] = vasthouden [1];
			teraden [2] = vasthouden [2];
			teraden [3] = vasthouden [3];
			
			System.out.println(spelerinvoer + "    On the right spot: " + dezelfdeplek + "    In the row: " + inderij + "    Attempts: " + beurten);
			if(dezelfdeplek == 4) {
				System.out.println(" ");
				System.out.println("You did it! You have unlocked the code and saved your girlfriend from endless cramp in a tiny box!");
				return;
			}	
			dezelfdeplek = 0;
			inderij = 0;
			beurten--;

		}System.out.println(" ");
		System.out.println("You have been dumped! Your girlfriend is getting crazy cramps in this tiny box ... ");
		System.out.println("You moron. You did not crack the code in all your 12 attempts.");
	}
}

class Code{
	char codecomp;
	static char [] teraden = new char [4];
	static char [] vasthouden = new char [4];
	char deString;
	
	void RandomLetter(){
		char[] LetterKeuze = {'a','b','c','d','e','f'};
		Random schudden = new Random();
		int geschud = schudden.nextInt(5);
		int i = geschud;
		deString = LetterKeuze[i];
	}
	void codemaken() {
		for( int i = 0; i < teraden.length; i++) {
			Code L1 = new Code();
			L1.RandomLetter();
			teraden[i] = L1.deString;
		}
		for(int x = 0; x < teraden.length ; x++) {
		}
		System.out.print(Code.teraden[0]);
		System.out.print(Code.teraden[1]);
		System.out.print(Code.teraden[2]);
		System.out.println(Code.teraden[3]);
		
		vasthouden [0] = teraden [0];
		vasthouden [1] = teraden [1];
		vasthouden [2] = teraden [2];
		vasthouden [3] = teraden [3];
	}
}




