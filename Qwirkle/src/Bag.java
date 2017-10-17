import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Bag extends Tiles{

	private ArrayList<Tile> bag;

	
	public Bag(File tilesFile, SpriteSheet spriteSheet) {
		super(tilesFile, spriteSheet);
		this.bag= new ArrayList<Tile>();
		
	}

	//Fill the bag 
	public void fillBag() {
		
		ArrayList<Tile> tilesArray = new ArrayList<Tile>();
		tilesArray = getTilesArray();

		int count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < tilesArray.size(); j++) {
				bag.add(tilesArray.get(j));
//				System.out.println(tilesArray.get(i).getTileID());
				count++;
			}
		}
//		return bag;
	}

	//Remove a random tile from the bag
	public  Tile takeTile() {
		int index = 400;
		while(index > bag.size()) {
			index = (int) Math.round((bag.size()*(Math.random())));
		}
	
//		System.out.println(index);
		Tile tile = bag.get(index);
		checkTile(index, bag);
		bag.remove(index);
		return tile;
	}

	//Checks the attributes of all tiles in a tile array
	public void checkBag() {

		System.out.println("number of tiles in bag: " + bag.size());

		for(int k = 0; k < bag.size(); k++) {
			System.out.println(bag.get(k).tileID+" "+bag.get(k).tileColor + " "+ bag.get(k).tileShape);
		}

	}
	
	//Checks the attributes of a specific tile in a tile array
	public void checkTile(int tileID, ArrayList<Tile> tilesArray) {
		Tile placedTile = tilesArray.get(tileID);
		
		System.out.println(placedTile.tileColor + " " + placedTile.tileShape);
	}
	
	
	

}


	

	
	
	
	

