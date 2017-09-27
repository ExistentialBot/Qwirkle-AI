import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		generateBag();
		createGrid();
		
		// testing calculateScore method with sample game in rules pdf
	/*	grid.get(2).get(4).setColour(Tile.tile6.getColour());
		grid.get(2).get(4).setShape(Tile.tile6.getShape());
		grid.get(3).get(4).setColour(Tile.tile3.getColour());
		grid.get(3).get(4).setShape(Tile.tile3.getShape());
		grid.get(4).get(4).setColour(Tile.tile1.getColour());
		grid.get(4).get(4).setShape(Tile.tile1.getShape());
		
		ArrayList<Location> annaFirst  = new ArrayList<Location>();
		annaFirst.add(new Location(2,4));
		annaFirst.add(new Location(3,4));
		annaFirst.add(new Location(4,4));
		
		System.out.println("Anna should score a 3, she scores: " + calculateScore(annaFirst));
		
		grid.get(5).get(4).setColour(Tile.tile4.getColour());
		grid.get(5).get(4).setShape(Tile.tile4.getShape());
		grid.get(5).get(5).setColour(Tile.tile28.getColour());
		grid.get(5).get(5).setShape(Tile.tile28.getShape());
		grid.get(5).get(6).setColour(Tile.tile34.getColour());
		grid.get(5).get(6).setShape(Tile.tile34.getShape());
		
		ArrayList<Location> chrisFirst = new ArrayList<Location>();
		chrisFirst.add(new Location(5,4));
		chrisFirst.add(new Location(5,5));
		chrisFirst.add(new Location(5,6));
		
		System.out.println("Chris should score a 7, he scores: " + calculateScore(chrisFirst));
		
		grid.get(4).get(5).setColour(Tile.tile25.getColour());
		grid.get(4).get(5).setShape(Tile.tile25.getShape());
		
		ArrayList<Location> sallyFirst = new ArrayList<Location>();
		sallyFirst.add(new Location(4,5));
		
		System.out.println("Sally should score a 4, she scores: " + calculateScore(sallyFirst));
		
		grid.get(2).get(3).setColour(Tile.tile24.getColour());
		grid.get(2).get(3).setShape(Tile.tile24.getShape());
		grid.get(3).get(3).setColour(Tile.tile21.getColour());
		grid.get(3).get(3).setShape(Tile.tile21.getShape());
		
		ArrayList<Location> daveFirst = new ArrayList<Location>();
		daveFirst.add(new Location(2,3));
		daveFirst.add(new Location(3,3));
		
		System.out.println("Dave should score a 6, he scores: " + calculateScore(daveFirst));
		
		grid.get(1).get(3).setColour(Tile.tile23.getColour());
		grid.get(1).get(3).setShape(Tile.tile23.getShape());
		grid.get(4).get(3).setColour(Tile.tile19.getColour());
		grid.get(4).get(3).setShape(Tile.tile19.getShape());
		
		ArrayList<Location> annaSecond = new ArrayList<Location>();
		annaSecond.add(new Location(1,3));
		annaSecond.add(new Location(4,3));
		
		System.out.println("Anna should score a 7, she scores: " + calculateScore(annaSecond));
		
		grid.get(5).get(7).setColour(Tile.tile10.getColour());
		grid.get(5).get(7).setShape(Tile.tile10.getShape());
		grid.get(6).get(7).setColour(Tile.tile4.getColour());
		grid.get(6).get(7).setShape(Tile.tile4.getShape());
		
		ArrayList<Location> chrisSecond = new ArrayList<Location>();
		chrisSecond.add(new Location(5,7));
		chrisSecond.add(new Location(6,7));
		
		System.out.println("Chris shouls score a 6, he scores: " + calculateScore(chrisSecond));
		
		grid.get(1).get(1).setColour(Tile.tile11.getColour());
		grid.get(1).get(1).setShape(Tile.tile11.getShape());
		grid.get(1).get(2).setColour(Tile.tile17.getColour());
		grid.get(1).get(2).setShape(Tile.tile17.getShape());
		
		ArrayList<Location> sallySecond = new ArrayList<Location>();
		sallySecond.add(new Location(1,1));
		sallySecond.add(new Location(1,2));
		
		System.out.println("Sally should score a 3, she scores: " + calculateScore(sallySecond));
		
		grid.get(2).get(1).setColour(Tile.tile8.getColour());
		grid.get(2).get(1).setShape(Tile.tile8.getShape());
		grid.get(3).get(1).setColour(Tile.tile9.getColour());
		grid.get(3).get(1).setShape(Tile.tile9.getShape());
		
		ArrayList<Location> daveSecond = new ArrayList<Location>();
		daveSecond.add(new Location(2,1));
		daveSecond.add(new Location(3,1));
		
		System.out.println("Dave should score a 3, he scores: " + calculateScore(daveSecond));
		
		grid.get(3).get(2).setColour(Tile.tile15.getColour());
		grid.get(3).get(2).setShape(Tile.tile15.getShape());
		grid.get(4).get(2).setColour(Tile.tile13.getColour());
		grid.get(4).get(2).setShape(Tile.tile13.getShape());
		
		ArrayList<Location> annaThird = new ArrayList<Location>();
		annaThird.add(new Location(3,2));
		annaThird.add(new Location(4,2));
		
		System.out.println("Anna should score a 10, she scores: " + calculateScore(annaThird));
		
		grid.get(1).get(4).setColour(Tile.tile5.getColour());
		grid.get(1).get(4).setShape(Tile.tile5.getShape());
		
		ArrayList<Location> chrisThird = new ArrayList<Location>();
		chrisThird.add(new Location(1,4));
		
		System.out.println("Chris should score a 9, he scores: " + calculateScore(chrisThird));
		
		grid.get(6).get(3).setColour(Tile.tile8.getColour());
		grid.get(6).get(3).setShape(Tile.tile8.getShape());
		grid.get(6).get(4).setColour(Tile.tile2.getColour());
		grid.get(6).get(4).setShape(Tile.tile2.getShape());
		grid.get(6).get(5).setColour(Tile.tile26.getColour());
		grid.get(6).get(5).setShape(Tile.tile26.getShape());
		
		ArrayList<Location> sallyThird = new ArrayList<Location>();
		sallyThird.add(new Location(6,3));
		sallyThird.add(new Location(6,4));
		sallyThird.add(new Location(6,5));
		
		System.out.println("Sally should score a 18, she scores: " + calculateScore(sallyThird));
		
		grid.get(5).get(8).setColour(Tile.tile16.getColour());
		grid.get(5).get(8).setShape(Tile.tile16.getShape());
		grid.get(6).get(8).setColour(Tile.tile28.getColour());
		grid.get(6).get(8).setShape(Tile.tile28.getShape());
		
		ArrayList<Location> daveThird = new ArrayList<Location>();
		daveThird.add(new Location(5,8));
		daveThird.add(new Location(6,8));
		
		System.out.println("Dave should score a 9, he scores: " + calculateScore(daveThird)); */
		
		/*grid.get(1).get(1).setColour(Tile.tile1.getColour());
		grid.get(1).get(1).setShape(Tile.tile1.getShape());
		grid.get(1).get(2).setColour(Tile.tile2.getColour());
		grid.get(1).get(2).setShape(Tile.tile2.getShape());
		grid.get(1).get(3).setColour(Tile.tile3.getColour());
		grid.get(1).get(3).setShape(Tile.tile3.getShape());
		//grid.get(2).get(3).setColour(Tile.tile21.getColour());
		//grid.get(2).get(3).setShape(Tile.tile21.getShape());
		grid.get(3).get(3).setColour(Tile.tile27.getColour());
		grid.get(3).get(3).setShape(Tile.tile27.getShape()); 
		
		if (isValidCheck(Tile.tile21, 2, 3)){
			System.out.println("Valid location");
		}
		else {
			System.out.println("invalid location");
		}
		*/
		
		/*
		Player human1 = new Player(1, "human1", 5, new ArrayList<Tile>());
		Player human2 = new Player(2, "human2", 7, new ArrayList<Tile>());
		Player human3 = new Player(2, "human3", 9, new ArrayList<Tile>());
		
		players.add(human1);
		players.add(human2);
		players.add(human3);
		
		givePlayerTiles(human1, 6);
		givePlayerTiles(human2, 6);
		givePlayerTiles(human3, 6);
		
		System.out.println(players.get(0).getPlayerName());
		System.out.println(printTiles(human1.getCurrentTiles()));
		System.out.println(players.get(1).getPlayerName());
		System.out.println(printTiles(human2.getCurrentTiles()));
		System.out.println(players.get(2).getPlayerName());
		System.out.println(printTiles(human3.getCurrentTiles()));
	
		assignOrder();
		
		System.out.println("");
		System.out.println(players.get(0).getPlayerName());
		System.out.println(players.get(1).getPlayerName());
		System.out.println(players.get(2).getPlayerName()); */
		
	/*	printCurrentPlayer();
		endTurn();
		printCurrentPlayer();
		endTurn();
		printCurrentPlayer();
		endTurn();
		printCurrentPlayer();
		endTurn();
		printCurrentPlayer();
		endTurn();
		printCurrentPlayer();
		endTurn();
		printCurrentPlayer();  */
		
	  /*  Player karim = new Player(1, "karim", 0, new ArrayList<Tile>());
	    givePlayerTiles(karim, 6);
	    
	    System.out.println(printTiles(karim.currentTiles));
		
	    ArrayList<Integer> indexes = new ArrayList<Integer>();
	    indexes.add(1);
	    indexes.add(2);
	    indexes.add(3);
	    
	    swapTiles(karim, indexes);
	    System.out.println(printTiles(karim.currentTiles));
	    */
		//  Tile newRandom = giveRandomTile();
	//	grid.get(2).get(2).setColour(newRandom.getColour());
	//	grid.get(2).get(2).setShape(newRandom.getShape());

	    printGrid();
		
	}
	
	public static ArrayList<Tile> bag = new ArrayList<Tile>();
	public static List<ArrayList<Tile>> grid = new ArrayList<ArrayList<Tile>>();
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static int currentTurn = 0;
	
	
	
	// method that given a list of the locations of the tiles a player played it returns the players score
	public static int calculateScore(ArrayList<Location> locations){
		
		int score = 0;
	
		if (locations.get(0).getRow() == locations.get(locations.size() -1).getRow()){
			
			int points = 1;
			
			int checkRowPlus = locations.get(0).getColoumn();
			int checkRowMinus = locations.get(0).getColoumn();
			
			while(grid.get(locations.get(0).getRow()).get(checkRowPlus +1).getColour() != null){
				
				points++;
				checkRowPlus++;
			}
			
			while(grid.get(locations.get(0).getRow()).get(checkRowMinus -1).getColour() != null){
				
				points++;
				checkRowMinus--;
			}
			
			if(points == 6){
				score = score + 6;
			}
			
			score = score + points;
			
			for(int i = 0; i < locations.size(); i++){
				
				int coloumnPoints = 1;
				
				int checkColoumnPlus = locations.get(i).getRow();
				int checkColoumnMinus = locations.get(i).getRow();
				
				while(grid.get(checkColoumnPlus + 1).get(locations.get(i).getColoumn()).getColour() != null){
					
					coloumnPoints++;
					checkColoumnPlus++;
				}
				
				while(grid.get(checkColoumnMinus - 1).get(locations.get(i).getColoumn()).getColour() != null){
					
					coloumnPoints++;
					checkColoumnMinus--;
				}
				
				if(coloumnPoints == 6){
					score = score + 6;
				}
				if(coloumnPoints == 1){
					coloumnPoints = 0;
				}
				score = score + coloumnPoints;
				
			}
		
		}
		else {
			
			int points = 1;
			
			int checkColoumnPlus = locations.get(0).getRow();
			int checkColoumnMinus = locations.get(0).getRow();
			
			while(grid.get(checkColoumnPlus +1).get(locations.get(0).getColoumn()).getColour() != null){
				
				points++;
				checkColoumnPlus++;
			}
			
			while(grid.get(checkColoumnMinus -1).get(locations.get(0).getColoumn()).getColour() != null){
				
				points++;
				checkColoumnMinus--;
			}
			
			if(points == 6){
				score = score + 6;
			}
			
			score = score + points;
			
			for(int i = 0; i < locations.size(); i++){
				
				int rowPoints = 1;
				
				int checkRowPlus = locations.get(i).getColoumn();
				int checkRowMinus = locations.get(i).getColoumn();
				
				while(grid.get(locations.get(i).getRow()).get(checkRowPlus +1).getColour() != null){
					
					rowPoints++;
					checkRowPlus++;
				}
				
				while(grid.get(locations.get(i).getRow()).get(checkRowMinus -1).getColour() != null){
					
					rowPoints++;
					checkRowMinus--;
				}
				
				if(rowPoints == 6){
					score = score + 6;
				}
				if(rowPoints == 1){
					rowPoints = 0;
				}
				
				score = score + rowPoints;
				
			}
			
		}
		
		return score;
	}
		
	// method to assign who plays first based initially on who has the best possible combo and if they have the same score then by who was added first to the list of players
	public static void assignOrder(){
		
		int[] scores = new int[players.size()]; 	
		
		for (int i = 0; i < players.size(); i++){
			
			int maxColourCombo = 0;
			int maxShapeCombo = 0; 
			
			for (int j = 0; j < 6; j++){
				
				int currentColourCombo = 0;
				int currentShapeCombo = 0;
				
				for (int k = 0; k < 6; k++){
						
								if (players.get(i).getCurrentTiles().get(j).getColour().getIdColour() == players.get(i).getCurrentTiles().get(k).getColour().getIdColour()){
									currentColourCombo++;
								}
								if (players.get(i).getCurrentTiles().get(j).getShape().getIdShape() == players.get(i).getCurrentTiles().get(k).getShape().getIdShape()){
									currentShapeCombo++;						
								}
								if(players.get(i).getCurrentTiles().get(j).getColour().getIdColour() == players.get(i).getCurrentTiles().get(k).getColour().getIdColour() &&
										players.get(i).getCurrentTiles().get(j).getShape().getIdShape() == players.get(i).getCurrentTiles().get(k).getShape().getIdShape()){
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
	
	// method that takes in a tile and its row and coloumn and outputs if the place you want to add it to is valid or not
	public static boolean isValidCheck(Tile inputTile, int row, int column){
		
		if (grid.get(row).get(column).getColour() != null){
			
			return false;
		}
		
		int checkRowPlus = row;
		int checkRowMinus = row;
		int checkColumnPlus = column;
		int checkColumnMinus = column;
		
		while (grid.get(checkRowPlus + 1).get(column).getColour() != null){
			
			if (grid.get(checkRowPlus + 1).get(column).getColour().getIdColour() == inputTile.getColour().getIdColour() &&
					grid.get(checkRowPlus + 1).get(column).getShape().getIdShape() == inputTile.getShape().getIdShape()){
				return false;
			}
			else{
				checkRowPlus++;
			}
		}
		
		while (grid.get(checkRowMinus - 1).get(column).getColour() != null){
			
			if (grid.get(checkRowMinus - 1).get(column).getColour().getIdColour() == inputTile.getColour().getIdColour() && 
					grid.get(checkRowMinus - 1).get(column).getShape().getIdShape() == inputTile.getShape().getIdShape()){
				return false;
			}
			else{
				checkRowMinus--;
			}
		}
		
		while (grid.get(row).get(checkColumnPlus + 1).getColour() != null){
			
			if (grid.get(row).get(checkColumnPlus + 1).getColour().getIdColour() == inputTile.getColour().getIdColour() &&
					grid.get(row).get(checkColumnPlus + 1).getShape().getIdShape() == inputTile.getShape().getIdShape()){
				return false;
			}
			else{
				checkColumnPlus++;
			}
		}
		
		while (grid.get(row).get(checkColumnMinus - 1).getColour() != null){
			
			if (grid.get(row).get(checkColumnMinus - 1).getColour().getIdColour() == inputTile.getColour().getIdColour() &&
					grid.get(row).get(checkColumnMinus - 1).getShape().getIdShape() == inputTile.getShape().getIdShape()){
				return false;
			}
			else{
				checkColumnMinus--;
			}
		}
			
		return true;
	}
	
	// method that ptints who the current player is in the command line
	public static void printCurrentPlayer(){
		
		System.out.println("Current player: " + players.get(currentTurn).getPlayerName());
		
	}
	
	// method that returns the current player so that you can perform functions on it
	public static Player currentPlayer(){
	
		return players.get(currentTurn);
		
	}
	
	// method that ends the turn of the current player and moves the current turn to the next in the list
	public static void endTurn(){
	
		if (currentTurn == players.size() - 1){
		   
			currentTurn = 0;
		}
		else { 
			currentTurn++;
		}
	}
	
	// method that gives a player the amount of tiles you specify and if there is not enough the bag gives it the remainder
	public static void swapTiles(Player player, ArrayList<Integer> indexesOfTiles){
		
		ArrayList<Tile> buffer = new ArrayList<Tile>();
		
		if(indexesOfTiles.size() > player.currentTiles.size() || indexesOfTiles.size() > bag.size()){
			
		}
		else {
			
			for (int i = 0; i < indexesOfTiles.size(); i++){
				
				buffer.add(player.currentTiles.get(indexesOfTiles.get(i)));
				
			}
			
			for (int i = 0; i < indexesOfTiles.size(); i++){
				
				player.currentTiles.remove(indexesOfTiles.get(i) - i);
				
			}
			
			for (int i = 0; i < indexesOfTiles.size(); i++){
	
				player.currentTiles.add(giveRandomTile());
	
			}
			
			for (int i = 0; i < buffer.size(); i++){
				
				bag.add(buffer.get(i));
	
			}
			
		}
		
	}
	
	// method that gives a player the amount of tiles you specify and if there is not enough the bag gives the player the remainder
	public static void givePlayerTiles(Player player, int numberOfTiles){
		
		int bagsize = bag.size();
				
		if(numberOfTiles <= bagsize){
			
			for (int i = 0; i < numberOfTiles; i++){
			
				player.currentTiles.add(giveRandomTile());
				
			}
			
		}
		else {
			
			for (int i = 0; i < bagsize; i++){
				
				player.currentTiles.add(giveRandomTile());
				
			}
			
		}
		
	}
	
	// method that creates a 100 by 100 grid of null tiles
	public static void createGrid(){
		
		for (int i = 0; i < 100; i ++){	
			
			grid.add(new ArrayList<Tile>());
			
			for (int j = 0; j < 100; j++){
			
						grid.get(i).add(new Tile(null, null));
			}
		}
		
	}
		
	// method that prints the grid contents and if a space is empty it prints the empty location
	public static void printGrid(){
		
		for (int i = 0; i < 7; i ++){
			for (int j = 0; j < 9; j++){
			
				if (grid.get(i).get(j).getColour() == null){
					System.out.print("empty location, ");
				}
				else {
					String toPrint = new String();
					toPrint = grid.get(i).get(j).getColour().getIdentifier() + " " + grid.get(i).get(j).getShape().getIdentifier() + ", ";
					int length = toPrint.length();
					for (int k = 0; k < (16 - length); k++){
						toPrint = toPrint + " ";
					}
				    System.out.print(toPrint);
				}
			}
			System.out.println("");
		}
		
	}
	
	// method that creates the "bag" which contains 3 of each tile
	public static void generateBag(){
		
		for (int i = 0; i < 3; i++){
			
			bag.add(Tile.tile1);
			bag.add(Tile.tile2);
			bag.add(Tile.tile3);
			bag.add(Tile.tile4);
			bag.add(Tile.tile5);
			bag.add(Tile.tile6);
			bag.add(Tile.tile7);
			bag.add(Tile.tile8);
			bag.add(Tile.tile9);
			bag.add(Tile.tile10);
			bag.add(Tile.tile11);
			bag.add(Tile.tile12);
			bag.add(Tile.tile13);
			bag.add(Tile.tile14);
			bag.add(Tile.tile15);
			bag.add(Tile.tile16);
			bag.add(Tile.tile17);
			bag.add(Tile.tile18);
			bag.add(Tile.tile19);
			bag.add(Tile.tile20);
			bag.add(Tile.tile21);
			bag.add(Tile.tile22);
			bag.add(Tile.tile23);
			bag.add(Tile.tile24);
			bag.add(Tile.tile25);
			bag.add(Tile.tile26);
			bag.add(Tile.tile27);
			bag.add(Tile.tile28);
			bag.add(Tile.tile29);
			bag.add(Tile.tile30);
			bag.add(Tile.tile31);
			bag.add(Tile.tile32);
			bag.add(Tile.tile33);
			bag.add(Tile.tile34);
			bag.add(Tile.tile35);
			bag.add(Tile.tile36);
			
		}				
	}
	
	// method that returns a random tile from the bag
	public static Tile giveRandomTile(){
		
		double random =  Math.random()*bag.size();
		Tile buffer = new Tile(bag.get((int) random).getColour(), bag.get((int) random).getShape());
		bag.remove((int) random);
		return buffer;
			
	}
	
	// method that returns a string representing all the tiles in a given arraylist
	public static String printTiles(ArrayList<Tile> tiles){
		
		if(tiles.size() == 0){		
			return "empty arraylist";
		}
		
		String print = new String();
		print = "( " + tiles.get(0).getColour().getIdentifier() + " " + tiles.get(0).getShape().getIdentifier();
		
		for(int i = 1; i < tiles.size(); i++){
	     
			print = print + ", " + tiles.get(i).getColour().getIdentifier() + " " + tiles.get(i).getShape().getIdentifier();
		}
		
		return print + " )";	
	}
	

}


