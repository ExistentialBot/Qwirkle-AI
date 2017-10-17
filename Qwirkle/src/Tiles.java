import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Tiles 
{
	private SpriteSheet spriteSheet;
	private ArrayList<Tile> tilesList = new ArrayList<Tile>();

	//This will only work assuming the sprites in the spriteSheet have been loaded.
	public Tiles(File tilesFile, SpriteSheet spriteSheet)
	{
		this.spriteSheet = spriteSheet;
		try 
		{
			Scanner scanner = new Scanner(tilesFile);
			while(scanner.hasNextLine()) 
			{
				String line = scanner.nextLine();
				if(!line.startsWith("//"))
				{
					String[] splitString = line.split("-");
					int tileID=Integer.parseInt(splitString[0]);
					String tileShape = splitString[1];
					String tileColor = splitString[2];
					int spriteX = Integer.parseInt(splitString[3]);
					int spriteY = Integer.parseInt(splitString[4]);
					Tile tile = new Tile(tileID,tileColor,tileShape, spriteSheet.getSprite(spriteX, spriteY));
					tilesList.add(tile);
				}
			}
		} 
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void renderTile(int tileID, RenderHandler renderer, int xPosition, int yPosition, int xZoom, int yZoom)
	{
//		System.out.println("TIles.renderTiel is called");
		if(tileID >= 0 && tilesList.size() > tileID)
		{
			renderer.renderSprite(tilesList.get(tileID).sprite, xPosition, yPosition, xZoom, yZoom, false);
		}
		else
		{
			System.out.println("TileID " + tileID + " is not within range " + tilesList.size() + ".");
		}
	}

	public int size()
	{
		return tilesList.size();
	}

	public Sprite[] getSprites()
	{
		Sprite[] sprites = new Sprite[size()];

		for(int i = 0; i < sprites.length; i++)
			sprites[i] = tilesList.get(i).sprite;

		return sprites;
	}
	public Sprite getSprite(int i)
	{
		Sprite sprite= tilesList.get(i).sprite;

		return sprite;
	}


	public ArrayList getTilesArray() {
		return tilesList;
	}

	public void removeTile(int id) {
		// TODO Auto-generated method stub
		tilesList.remove(id);
	}


}