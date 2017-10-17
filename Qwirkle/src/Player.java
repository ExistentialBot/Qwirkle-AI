
import java.util.ArrayList;



public class Player {
	
	private ArrayList<Tile> playerTiles;
	private SDKButton[] playerButtons;

	private int number;
	private int score;
	private Bag bag;
	private Game game;
	int xZoom=1;
	int yZoom=1;

	
	public Player(int number,Bag bag,Game game) {
		
		this.number = number;
		playerTiles=new ArrayList<Tile>(6);
		playerButtons=new SDKButton[6];
		this.bag=bag;
		this.game=game;
		score=0;
	}
	

	public ArrayList<Tile> getPlayerTiles() {
		return playerTiles;
	}

	public void setPlayerTiles(ArrayList<Tile> playerTiles) {
		this.playerTiles = playerTiles;

	}
//	this method fills the player board and returns a gui button 
	public GUIButton[] fillPlayerBoard() {

		
		//Load Player buttons GUI Later will go in player.java
//				GUIButton[] playerButtons = new GUIButton[6];
//				loads tileSprite on the side
				Sprite[] playerSprites=new Sprite[6];
				int []idArray=new int[6];
				
				for (int i=0;i<playerButtons.length;i++){
					Tile temp=bag.takeTile();
					playerSprites[i]=temp.getSprite();
					idArray[i]=temp.getTileID();
					System.out.println("id array at index "+i+"is "+idArray[i]);

				}
				for(int i = 0; i < playerButtons.length; i++)
				{
					Rectangle tileRectangle = new Rectangle(0,i*(50*xZoom +10), 50*xZoom, 50*yZoom);

					playerButtons[i] = new SDKButton(game, idArray[i], playerSprites[i], tileRectangle);

				}
				
				return playerButtons;
	}
//	replaces the tile that is placed with a new tile from the bag
	public void replaceTile(int id){
		
		for (int i=0;i<playerButtons.length;i++){
			
			if (playerButtons[i].getTileID()==id){
				Tile tile=bag.takeTile();
				playerButtons[i]=new SDKButton(game,tile.tileID,tile.getSprite(),new Rectangle(0,i*(50*xZoom+10),50*xZoom,50*yZoom));
				break;
			}
			
		}
	}
	
	public void emptyPlayerBoard() {
		playerTiles.clear(); 
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	//Taking a tile from the bag and placing it in the player board
	public void takeTile(ArrayList<Tile> bag) {
			int index = (int) Math.round(bag.size()*(Math.random()));
			Tile tile = bag.get(index);
			playerTiles.add(tile);
			bag.remove(index);
			
		}
	
	//Swap the last tile in the player board with the last tile in the bag	
		public void swapTile(ArrayList<Tile> bag) {
			Tile tile = bag.get(bag.size());
			Tile tile1 = playerTiles.get(playerTiles.size());
			bag.add(tile1);
			playerTiles.add(tile);
			bag.remove(bag.size());
			playerTiles.remove(bag.size());
			
		}
		
		//conditions for ending game
		
		public boolean checkEmptyBag(ArrayList<Tile> bag) { //this shouldnt be in player .it should be in bag where you check if the arraylist is empty 
			if (bag.isEmpty()) 
			return true;
			else {
				return false;
					
				}
			}
//	this is also obsolete 	
		public boolean checkEmptyPlayerTiles(ArrayList<Tile> playerTiles, Player player) {
			if (player.playerTiles.isEmpty())
			return true;
			else {
				return false;
			}
		}
		
//		public boolean checkGameEnd(Player player) {
//			if (checkEmptyBag(bag) && player.checkEmptyBag(bag) ) { //still some dodgy shit going on here, think i did this wrong(Yes)
//				return true; //end game
//			}
//		}

}
