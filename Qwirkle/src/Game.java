import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import java.lang.Runnable;
import java.lang.Thread;

import javax.swing.JFrame;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.io.File;

public class Game extends JFrame implements Runnable
{

	public static int alpha = 0xFFFF00DC;

	private Canvas canvas = new Canvas();
	private RenderHandler renderer;

	private SpriteSheet sheet;
	private SpriteSheet playerSheet;

	private int selectedTileID = 2;

	private Rectangle testRectangle = new Rectangle(30, 30, 100, 100);

	private Tiles tiles;
	private Map map;

	private GameObject[] objects;
	private KeyBoardListener keyListener = new KeyBoardListener(this);
	private MouseEventListener mouseListener = new MouseEventListener(this);

	private Camera camera;

	private int xZoom = 1;
	private int yZoom = 1;
	

	public Game() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(0,0, 1000, 800);

		setLocationRelativeTo(null);

		add(canvas);

		//Make our frame visible.
		setVisible(true);

		//Create our object for buffer strategy.
		canvas.createBufferStrategy(3);

		renderer = new RenderHandler(getWidth(), getHeight());

		//Load Assets
		BufferedImage sheetImage = loadImage("Blocks.png");
		sheet = new SpriteSheet(sheetImage);
		sheet.loadSprites(50, 50);



		//Load Tiles
		tiles = new Tiles(new File("Blocks.txt"),sheet);

		//Load Map
		map = new Map(new File("Map.txt"), tiles);



		testRectangle.generateGraphics(2, 12234);

		//Load SDK GUI
		GUIButton[] buttons = new GUIButton[tiles.size()];
//		loads tileSprite on the side
		Sprite[] tileSprites = tiles.getSprites();

		for(int i = 0; i < buttons.length; i++)
		{
			Rectangle tileRectangle = new Rectangle(0,i*(50*xZoom +10), 50*xZoom, 50*yZoom);

			buttons[i] = new SDKButton(this, i, tileSprites[i], tileRectangle);
		}

		GUI gui = new GUI(buttons, 5, 200, true);

		//Load Objects
		objects = new GameObject[2];
		camera = new Camera();
		objects[0] = camera;
		objects[1] = gui;

		//Add Listeners
		canvas.addKeyListener(keyListener);
		canvas.addFocusListener(keyListener);
		canvas.addMouseListener(mouseListener);
		canvas.addMouseMotionListener(mouseListener);
	}

	
	public void update() 
	{
		for(int i = 0; i < objects.length; i++) 
			objects[i].update(this);
	}


	private BufferedImage loadImage(String path)
	{
		try 
		{
			BufferedImage loadedImage = ImageIO.read(Game.class.getResource(path));
			BufferedImage formattedImage = new BufferedImage(loadedImage.getWidth(), loadedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			formattedImage.getGraphics().drawImage(loadedImage, 0, 0, null);

			return formattedImage;
		}
		catch(IOException exception) 
		{
			exception.printStackTrace();
			return null;
		}
	}

	public void handleCTRL(boolean[] keys) 
	{
		if(keys[KeyEvent.VK_S])
			map.saveMap();
	}

	public void leftClick(int x, int y)
	{

		Rectangle mouseRectangle = new Rectangle(x, y, 1, 1);
		boolean stoppedChecking = false;

		for(int i = 0; i < objects.length; i++)
			if(!stoppedChecking)
				stoppedChecking = objects[i].handleMouseClick(mouseRectangle, renderer.getCamera(), xZoom, yZoom);

		if(!stoppedChecking) 
		{
			x = (int) Math.floor((x + renderer.getCamera().x)/50.0);
			y = (int) Math.floor((y + renderer.getCamera().y)/50.0);
			map.setTile(x, y, selectedTileID);
		}
	}

	public void rightClick(int x, int y)
	{
		x = (int) Math.floor((x + renderer.getCamera().x)/50.0);
		y = (int) Math.floor((y + renderer.getCamera().y)/50.0);
		map.removeTile(x, y);
	}


	public void render() 
	{
			BufferStrategy bufferStrategy = canvas.getBufferStrategy();
			Graphics graphics = bufferStrategy.getDrawGraphics();
			super.paint(graphics);

			map.render(renderer, xZoom, yZoom);

			for(int i = 0; i < objects.length; i++) 
				objects[i].render(renderer, xZoom, yZoom);

			renderer.render(graphics);

			graphics.dispose();
			bufferStrategy.show();
			renderer.clear();
	}

	public void changeTile(int tileID) 
	{
		selectedTileID = tileID;
	}

	public int getSelectedTile()
	{
		return selectedTileID;
	}

	public void run() 
	{
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		int i = 0;
		int x = 0;

		long lastTime = System.nanoTime(); //long 2^63
		double nanoSecondConversion = 1000000000.0 / 60; //60 frames per second
		double changeInSeconds = 0;

		while(true) 
		{
			long now = System.nanoTime();

			changeInSeconds += (now - lastTime) / nanoSecondConversion;
			while(changeInSeconds >= 1) {
				update();
				changeInSeconds--;
			}

			render();
			lastTime = now;
		}

	}

	public static void main(String[] args) 
	{
		Game game = new Game();
		Thread gameThread = new Thread(game);
		gameThread.start();
	}

	public KeyBoardListener getKeyListener() 
	{
		return keyListener;
	}

	public MouseEventListener getMouseListener() 
	{
		return mouseListener;
	}

	public RenderHandler getRenderer()
	{
		return renderer;
	}
}