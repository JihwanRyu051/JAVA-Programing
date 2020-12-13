package Assignment2;
import java.util.Scanner;

public class TicTacToeBoard extends Board {

	public TicTacToeBoard() {
		super(3);
	}
	public TicTacToeBoard(int size) {
		super(size);
	}
	public void placePlayer(String player){
		int i,j;
		Scanner sc = new Scanner(System.in);
		System.out.println(player+"'s turn.");
		
		while(true){
			System.out.print("row: ");
			i = sc.nextInt();

			System.out.print("col: ");
			j = sc.nextInt();
			
			if(!(i<size && i>=0) || !(j<size && j>=0)) {
				System.out.println("Please enter an integer between 0 and "+(size-1)+".");
				continue;
			}
			if(map[i][j] == ".") break;
			else System.out.println("That seat already done. Please choose another seat.");
		}
		map[i][j] = player;
	}
	
	public boolean full() {
		int countSeat=0;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size;j++){
				if(map[i][j] == ".") break;
				countSeat++;
			}
		}
		if(countSeat == (size)*(size))
			return true;
		else return false;
	}
	
	public boolean win(String player) {
		int score;
		for(int i=0; i<size; i++) {
			score = 0;
			for(int j=0; j<size; j++) 
				if(map[i][j] == player) score++;
				if(score == size) return true;
		}	
		
		for(int j=0; j<size; j++) {
			score = 0;
			for(int i=0; i<size; i++)
				if(map[i][j] == player) score++;
			
			if(score == size) return true;
		}
		int diagonalScore01 = 0, diagonalScore02=0;
		for(int k=0; k<=size/2; k++) {
			if(map[k][k]==player && map[k][k] == map[size-1-k][size-1-k])
				diagonalScore01++;
			if(map[k][size-1-k] == player && map[k][size-1-k] == map[size-1-k][k])
				diagonalScore02++;
		}
		
		if(diagonalScore01 > size/2 || diagonalScore02 > size/2)
			return true;
		
		return false;
	}
	
	public void run() {
		String player;
		System.out.println("Let's play the game. Board size is " + size + "x"+size+".");
		System.out.println("Bound: 0<=row<="+(size-1)+", 0<=col<="+(size-1));
		while(true) {
			player = "X";
			placePlayer(player);
			this.print();
			if(this.win(player)) {
				System.out.println(player + " is Winner!");
				return;
			}
			if(this.full()) break;
			player = "O";
			placePlayer(player);
			this.print();
			if(this.win(player)) {
				System.out.println(player + " is Winner!");
				return;
			}
			if(this.full()) break;
		}
		System.out.println("Tie");
		return;
	}
}
