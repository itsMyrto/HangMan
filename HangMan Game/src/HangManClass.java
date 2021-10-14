import java.util.Scanner;
import java.util.Random;

public class HangManClass {

	public static void main(String[] args) {
		
		String[] randomWords = {"serenity","loyalty","therapist","documentary","mortality","invisible","holocaust","visionary","fictitious","sponge","dragon","labour","sailor","summoner","butterfly","sphere","dolphin","smartphone","compiler","declaration","problem","trash","gun","flower","lion","abstract","mountain"};
		int arraylength = randomWords.length;
		Random random = new Random();
		int randnum = random.nextInt(arraylength);
		
		System.out.println("Welcome to the HangMan Game! Al have chosen one word and you have to find it. For each wrong answer you lose one attemp. You have only 7 attemps");
		boolean found = false;
		int attemps = 7;
		char[] finalword = new char[randomWords[randnum].length()];
		for(int i=0;i<finalword.length;i++) {
			finalword[i] = '_';
		}
		System.out.println("Here it is: ");
		for(int i=0;i<finalword.length;i++) {
			System.out.print(finalword[i]+" ");
		}
		System.out.println();
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		char letter;
		int empty = 0;
		boolean foundletter;
		boolean[] alreadysaid = new boolean[26];
		for(int i=0;i<26;i++) {
			alreadysaid[i]=false;
		}
		
		while(found==false && attemps>=1) {
			foundletter=false;
			System.out.println("You have "+attemps+" remaining attemps. Enter a letter: ");
			letter = scanner.next().charAt(0);
			scanner.nextLine();
			while(alreadysaid[(int)letter-97]==true) {
				System.out.println("You have already said that letter. Enter another one: ");
				letter = scanner.next().charAt(0);
				scanner.nextLine();
			}
			alreadysaid[(int)letter-97]=true;
			for(int i=0;i<finalword.length;i++)
			{
				if(finalword[i] == '_' && letter == randomWords[randnum].charAt(i) ) {
					empty++;
					finalword[i]=letter;
					foundletter = true;
				}
		
			}
			
			if(empty == randomWords[randnum].length()) {
				found=true;
			}
			if(foundletter==false) {
				attemps--;
			}
			
			for(int i=0;i<finalword.length;i++) {
				System.out.print(finalword[i]+" ");
			}
			System.out.println();
			System.out.println();
		}
		
		if(found==true) {
			System.out.println("Congratulations! You found the word!!!");
		}
		else {
			System.out.println("The word was "+ randomWords[randnum] +". Better next time");
		}
		scanner.close();
		
	}

}
