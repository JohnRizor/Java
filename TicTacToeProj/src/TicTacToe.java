import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
	
		char [] [] tictac = {{' ', '|', ' ', '|', ' '},
		{'-', '+', '-', '+', '-'},
		{' ', '|', ' ', '|', ' '},
		{'-', '+', '-', '+', '-'},
		{' ', '|', ' ', '|', ' '}};
		
		printBoard(tictac);
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter your placement (1-9): ");
			int playerPosition = scan.nextInt();
			while(playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)){
				System.out.println("Position Taken, please enter a correct position:");
				playerPosition = scan.nextInt();
			}
			
			placePiece(tictac, playerPosition, "player");
			String result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			Random rand = new Random();
			int cpuPosition = rand.nextInt(9) + 1;
			while(playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)){
				System.out.println("Position Taken, please enter a correct position:");
				cpuPosition = rand.nextInt(9) + 1;
			}
			placePiece(tictac, cpuPosition, "cpu");
			
			
			printBoard(tictac);
			
			String result1 = checkWinner();
			if(result1.length() > 0) {
				System.out.println(result1);
				break;
			}
			
			
		}
		
		
	}
	public static void printBoard(char[] [] tictac){
		for(char[] row : tictac) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void placePiece(char[] [] tictac, int position, String user) {
		
		char symbol = ' ';
		
		if(user.equals("player")) {
			symbol = 'X';
			playerPositions.add(position);
		} else if(user.equals("cpu")){
			symbol = 'O';
			cpuPositions.add(position);
		}
		
		switch(position) {
		case 1:
			tictac[0][0] = symbol;
			break;
		case 2:
			tictac[0][2] = symbol;
			break;
		case 3:
			tictac[0][4] = symbol;
			break;
		case 4:
			tictac[2][0] = symbol;
			break;
		case 5:
			tictac[2][2] = symbol;
			break;
		case 6:
			tictac[2][4] = symbol;
			break;
		case 7:
			tictac[4][0] = symbol;
			break;
		case 8:
			tictac[4][2] = symbol;
			break;
		case 9:
			tictac[4][4] = symbol;
			break;
		default:
			break;
		}
	}
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List leftCol = Arrays.asList(1,4,7);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		List<List> winningSet = new ArrayList<List>();
		winningSet.add(topRow);
		winningSet.add(midRow);
		winningSet.add(bottomRow);
		winningSet.add(midCol);
		winningSet.add(rightCol);
		winningSet.add(leftCol);
		winningSet.add(cross1);
		winningSet.add(cross2);
		
		for(List l : winningSet) {
			if(playerPositions.containsAll(l)) {
				return "You won!";
			}else if(cpuPositions.containsAll(l)) {
				return "Sorry, you lost...";
			}
			else if(playerPositions.size() + cpuPositions.size() == 9) {
				return "CAT";
			}
		}
		
		return "";
	}
}
