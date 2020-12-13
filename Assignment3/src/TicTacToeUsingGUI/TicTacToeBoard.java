package TicTacToeUsingGUI;
import javax.swing.*;


public class TicTacToeBoard extends Board {

	public TicTacToeBoard() {
		super(3);
	}
	public TicTacToeBoard(int size) {
		super(size);
	}
	public void placePlayer(JButton btn){
		int i,j;
		
		i = Character.getNumericValue(btn.getName().charAt(0));
		j = Character.getNumericValue(btn.getName().charAt(1));
			
		map[i][j] = btn.getText();
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
	
	public String run(JButton btn) {
		String player = btn.getText();
		placePlayer(btn);
		if(this.win(player)) return "A WINNER IS "+player;
		if(this.full()) 	 return "TIE";
		return "";
	}
	
	public void clear() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) 
				map[i][j] = ".";
		}	
	}
}