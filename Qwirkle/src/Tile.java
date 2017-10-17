	public class Tile 
	{
		public int tileID;
		public String tileColor;
		public String tileShape;
		public Sprite sprite;

		public Tile(int tileID,String color,String shape, Sprite sprite) 
		{
			this.tileColor =color;
			this.tileShape=shape;
			this.sprite = sprite;
			this.tileID=tileID;
		}
		
		public void setSprite(Sprite sprite){
			this.sprite=sprite;
		}
		
		public Sprite getSprite(){
			return sprite;
		}
		public int getTileID(){
			return tileID;
		}
	}