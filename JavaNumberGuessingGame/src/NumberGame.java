import java.util.Scanner;
import java.util.Random;
import java.lang.*;


public class NumberGame {

	public static void main(String[] args) {
		// always declare your variables at the top of your function
		char playAgain = 'y';
		
		// we want to create a loop to keep asking the player if they want to play.
		
		do {
			
			playAgain = startTheGame();
			
		} while (playAgain == 'y');
			
		System.out.println("Thanks for Playing the guessing Game");
	}
		
	
	public static char startTheGame(){
			char answer;
			char answer2;
			int guessingNumber = 0;
			int guess = 0;
			int numberOfguesses = 0;
			boolean correctGuess = false;
			
			Scanner inputFromUser = new Scanner(System.in);
			
			try {
				guessingNumber = new Random().nextInt(101);
				
				do {
					System.out.println("I am guessing of a number between 1 and 100. Try to guess it!");
					guess = inputFromUser.nextInt();
					numberOfguesses++;
					
						if (guess == guessingNumber) {
							System.out.println("You guessed the correct number."+"\nNumber of guesses used:" + numberOfguesses);
							correctGuess = true;
						}
						
						else if (guess < guessingNumber) {
							System.out.println("Your guess is too low.");
						}
						else {
							System.out.println("Your guess is too high.");
						}
				} while(correctGuess == false);
			} 
			catch (Exception e) {
				System.out.println(e);
				System.out.println("Your input was invalid.");
			}
					
			System.out.println("Do you want to continue playing? (y/n)");
			// take the first value. Just in case they put yes or now...
			answer2 = inputFromUser.next().charAt(0); 
			answer = Character.toLowerCase(answer2);
			return answer;
			
		}

}
