import java.util.ArrayList;

public class Player {

	public Player(int id, String player, int score, ArrayList<Tile> tiles){
		
		iD++;
		playerName = player;
		totalScore = score;
		currentTiles = tiles;
		
	}
	
	static int iD = 1;
	String playerName;
	int totalScore;
	ArrayList<Tile> currentTiles;
	
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public ArrayList<Tile> getCurrentTiles() {
		return currentTiles;
	}
	public void setCurrentTiles(ArrayList<Tile> currentTiles) {
		this.currentTiles = currentTiles;
	}
	
}