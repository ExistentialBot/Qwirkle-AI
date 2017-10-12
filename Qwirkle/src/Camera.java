public class Camera implements GameObject
{
	private Rectangle camRectangle;
	private int speed = 10;

	
	public Camera()
	{
		camRectangle = new Rectangle(32, 16, 16, 32);
		camRectangle.generateGraphics(3, 0xFF00FF90);
	}

	//Call every time physically possible.
	public void render(RenderHandler renderer, int xZoom, int yZoom)
	{

//			renderer.renderRectangle(camRectangle, xZoom, yZoom, false);
	}

	//Call at 60 fps rate.
	public void update(Game game)
	{
		KeyBoardListener keyListener = game.getKeyListener();

		

		if(keyListener.left())
		{

			camRectangle.x -= speed;
		}
		if(keyListener.right())
		{

			camRectangle.x += speed;
		}
		if(keyListener.up()) 
		{
			camRectangle.y -= speed;
	
		}
		if(keyListener.down()) 
		{

			camRectangle.y += speed;
		}


		updateCamera(game.getRenderer().getCamera());


	}

	public void updateCamera(Rectangle camera) {
		camera.x = camRectangle.x - (camera.w / 2);
		camera.y = camRectangle.y - (camera.h / 2);
	}

	//Call whenever mouse is clicked on Canvas.
	public boolean handleMouseClick(Rectangle mouseRectangle, Rectangle camera, int xZoom, int yZoom) { return false; }
}