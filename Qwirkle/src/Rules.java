import java.util.ArrayList;

public class Rules {
	/* You can do one of three things on your turn:
	 * Trade some or all of your tiles for different tiles.
	 * Add one tile to the grid and draw a tile to bring your deck again to 6.
	 * Add two or more tiles to the grid:
	 * 		All tiles played must share one attribute (color or shape) and must be placed in the same line.
	 * 		The tiles do not all have to touch each other.
	 * 		Draw tiles until your deck has 6 tiles again.
	 */
	private Game game;
	private ArrayList<Player> players=new ArrayList<Player>();
	
	public Rules(Game game) {
		this.game=game;
		players=game.getPlayers();
		
		
	}
	//Player with most tiles sharing one characteristic goes first
	public void assignOrder(){
		
		int[] scores = new int[players.size()]; 	
		
		for (int i = 0; i < players.size(); i++){
			
			int maxColourCombo = 0;
			int maxShapeCombo = 0; 
			
			for (int j = 0; j < 6; j++){
				
				int currentColourCombo = 0;
				int currentShapeCombo = 0;
				
				for (int k = 0; k < 6; k++){
						
//								if (players.get(i).getPlayerTiles().get(j).getColour().getIdColour() == players.get(i).getPlayerTiles().get(k).getColour().getIdColour()){
								if (players.get(i).getPlayerTiles().get(j).tileColor == players.get(i).getPlayerTiles().get(k).tileColor){

									currentColourCombo++;
								}
								if (players.get(i).getPlayerTiles().get(j).tileShape == players.get(i).getPlayerTiles().get(k).tileShape){
									currentShapeCombo++;						
								}
								if(players.get(i).getPlayerTiles().get(j).tileColor == players.get(i).getPlayerTiles().get(k).tileColor &&
										players.get(i).getPlayerTiles().get(j).tileShape == players.get(i).getPlayerTiles().get(k).tileShape){
									currentColourCombo--;
									currentShapeCombo--;
								}
										
				}
				
				if ( currentColourCombo > maxColourCombo){
					maxColourCombo = currentColourCombo + 1;
				}
				if ( currentShapeCombo > maxShapeCombo){
					maxShapeCombo = currentShapeCombo + 1;
				}
							
			}
			
			if(maxColourCombo >= maxShapeCombo){
				scores[i] = maxColourCombo;
			}
			else{
				scores[i] = maxShapeCombo;
			}
			
		}

		ArrayList<Player> buffer = new ArrayList<Player>();
			
		for(int a = 0; a < players.size(); a++){
			
			int max = 0; 
			int maxIndex = 0;
			
			for(int b = 0; b < players.size(); b++){
						
				if(scores[b] > max){
					max = scores[b];
					maxIndex = b;
				}
					
			}
			
			buffer.add(players.get(maxIndex));
			scores[maxIndex] = -1;
		}
		
		for(int g = 0; g < buffer.size(); g++){
			players.remove(0);	
		}
		
		for(int x = 0; x < buffer.size(); x++){
			players.add(buffer.get(x));
		}
	}
	
	public void listPlayers() {
		ArrayList<String> stringPlayers ;
		for(int i = 0; i<players.size(); i++) {
			System.out.println(players.get(i).toString());
		}
	}
}
