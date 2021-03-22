import java.util.Scanner;


	

	public class DBZQuiz {

		public static void main(String[] args) {
			
			
			PlayTheGame();
			
		}
				
		public static void PlayTheGame() {
			System.out.println("This quiz is to test your knowledge on one of the best Anime series ever created Dragonball Z...\n Would you like to play (1.yes/2.no): ");
			Scanner myObj = new Scanner(System.in);
			Integer answer = myObj.nextInt();
				if (answer == 1) 
				{
					LetTheGamesBegin();
				}
				else
				{
					System.out.println("Thank you for visiting and have a great day...");
				}
			}
				
			

		
		
		
		public static void LetTheGamesBegin() {
			int numberOfGuesses = 0;
			
			String response1 = question1();
			
			if (response1 == "correct") {
				numberOfGuesses++;
				Correct();
			}
			else {
				
				Incorrect();
			}
			
	String response2 = question2();
			
			if (response2 == "correct") {
				numberOfGuesses++;
				Correct();
			}
			else {
				
				Incorrect();
			}
			
	String response3 = question3();
			
			if (response3 == "correct") {
				numberOfGuesses++;
				Correct();
			}
			else {
				
				Incorrect();
			}
	String response4 = question4();
			
			if (response4 == "correct") {
				numberOfGuesses++;
				Correct();
			}
			else {
				
				Incorrect();
			}
	String response5 = question5();
			
			if (response5 == "correct") {
				numberOfGuesses++;
				Correct();
			}
			else {
				
				Incorrect();
			}
			
			System.out.println("Thank you for doing the quiz.\n Your score is " + numberOfGuesses + " out of 5 correct");
			
		}
		
		
		public static String question1(){
			System.out.println("What is the Saiyan name of the main character Goku?");
			System.out.println("1. Nappa\t 2. Bardock\t 3. Kii\t 4. Kakarot\t");
			Scanner myObj = new Scanner(System.in);
			Integer answer = myObj.nextInt();
			if(answer != 4) {
				return "incorrect";
			}
			return "correct";
		}
		public static String question2(){
			System.out.println("Who did Goku fight on Planet Namek?");
			System.out.println("1. Kid Buu\t 2. Andriod 17\t 3. King Picolo\t 4. Freiza\t");
			Scanner myObj = new Scanner(System.in);
			Integer answer = myObj.nextInt();
			if(answer != 4) {
				return "incorrect";
			}
			return "correct";
		}
		public static String question3(){
			System.out.println("Who's power level was at 10,000 when they were first Born?");
			System.out.println("1. Vegeta\t 2. Broly\t 3. Gohan\t 4. Goku\t");
			Scanner myObj = new Scanner(System.in);
			Integer answer = myObj.nextInt();
			if(answer != 2) {
				return "incorrect";
			}
			return "correct";
		}
		public static String question4(){
			System.out.println("Who is the God of Destruction for Universe 7?");
			System.out.println("1. Beerus\t 2. Whis\t 3. Omni King\t 4. Champa\t");
			Scanner myObj = new Scanner(System.in);
			Integer answer = myObj.nextInt();
			if(answer != 1) {
				return "incorrect";
			}
			return "correct";
		}
		public static String question5(){
			System.out.println("Who was the strongest enemy of Goku in the tournament of power?");
			System.out.println("1. Goku Black\t 2. Kefla\t 3. Jiren\t 4. Toppo\t");
			Scanner myObj = new Scanner(System.in);
			Integer answer = myObj.nextInt();
			if(answer != 3) {
				return "incorrect";
			}
			return "correct";
		}
		
		public static String Response() {
			Scanner myObj = new Scanner(System.in);
		    String userName = myObj.nextLine();
			return userName;
		}
		
		public static void Correct(){
			System.out.println("You got it right");
		}
		public static void Incorrect(){
			System.out.println("Sorry wrong answer");
		}

	}