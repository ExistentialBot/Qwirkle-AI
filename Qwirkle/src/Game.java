import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.lang.Runnable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Game implements Runnable
{

	public static int alpha = 0xFFFF00DC;

	private Canvas canvas = new Canvas();
	private RenderHandler renderer;
	private JFrame gameFrame;

	private SpriteSheet sheet;

	private int selectedTileID = 2;


	private Tiles tiles;
	private Tiles playerTiles;
	private Map map;
	private Bag bag;
	private Rules rules;
//	private Player player1;
//	private Player player2;
	ArrayList<Player>players=new ArrayList<Player>();
	private int currentPlayer;


	private GameObject[] objects;
	private KeyBoardListener keyListener = new KeyBoardListener(this);
	private MouseEventListener mouseListener = new MouseEventListener(this);

	private Camera camera;

	private int xZoom = 1;
	private int yZoom = 1;
	private int turn;
	private int numberOfPlayers=2;
	

	public Game(int numberOfPlayers) 
	{
		gameFrame=new JFrame("Qwirkle");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gameFrame.setBounds(0,0, 1000, 800);

		gameFrame.setLocationRelativeTo(null);
//		JPanel gamePanel = new JPanel(new GridBagLayout());
//		gameFrame.getContentPane().add(gamePanel,BorderLayout.CENTER);
//		GridBagConstraints c=new GridBagConstraints();
//		c.gridx=0;
//		c.gridy=0;
//		gamePanel.add(canvas, c);
//		c.gridx=0;
//		c.gridy=1;
//		JButton swapButton=new JButton("Swap");
//		gamePanel.add(swapButton,c);
//		this.add(gamePanel);
	//	
//		infoPanel=new JPanel();
//		JPanel canvasPanel = new JPanel();
//		gamePanel.add(infoPanel);
//		canvasPanel.add(canvas);
//		gamePanel.add(canvasPanel);
		
		
		gameFrame.add(canvas);
		
		
		//Make our frame visible.
		gameFrame.setVisible(true);

		//Create our object for buffer strategy.
		canvas.createBufferStrategy(3);
		
		
		
		

		renderer = new RenderHandler(gameFrame.getWidth(), gameFrame.getHeight());

		//Load Assets
		BufferedImage sheetImage = loadImage("Blocks.png");
		sheet = new SpriteSheet(sheetImage);
		sheet.loadSprites(50, 50);
		this.numberOfPlayers=numberOfPlayers;



		//Load Tiles
		tiles = new Tiles(new File("Blocks.txt"),sheet);

		//Load Map
		map = new Map(new File("Map.txt"), tiles,this);
		
//		load bag
		bag=new Bag(new File("Blocks.txt"), sheet);
		bag.fillBag();
		String number;
		
		for (int i=0;i<numberOfPlayers;i++) {
			
			players.add(new Player(i,bag,this));
			
		}
//		player1=new Player("Player 1",bag,this);
//		player1.getPlayerTiles().size();
//		define rules
		Rules rules=new Rules(this);
//		rules.assignOrder();
		
//		System.out.println("bag size: "+bag.size());
//		bag.checkBag();

		

//		//Load Player buttons GUI Later will go in player.java
//		GUIButton[] pButtons = new GUIButton[6];
////		loads tileSprite on the side
//		Sprite[] bagSprites=new Sprite[6];
//		int []idArray=new int[6];
//		
//		for (int i=0;i<pButtons.length;i++){
//			Tile temp=bag.takeTile();
//			bagSprites[i]=temp.getSprite();
//			idArray[i]=temp.getTileID();
//			System.out.println("id array at index "+i+"is "+idArray[i]);
//
//		}
//		for(int i = 0; i < pButtons.length; i++)
//		{
//			Rectangle tileRectangle = new Rectangle(0,i*(50*xZoom +10), 50*xZoom, 50*yZoom);
//
//			pButtons[i] = new SDKButton(this, idArray[i], bagSprites[i], tileRectangle);
//
//		}
		
		GUI gui = new GUI(players.get(0).fillPlayerBoard(), 5, 200, true);

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
		System.out.println("map saved");
		
		
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
//			graphics.setColor(Color.WHITE);
//			graphics.setFont(new Font("Comic Sans MS",Font.BOLD,40));
//			graphics.drawString("doodooli", 20, 20);
//			super.paint(graphics);
			gameFrame.paint(graphics);
			
			
			//If a string was returned, say so.
			
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
//		Object[] possibilities = {"Player 1", "Player 2"};
		
//		String s = (String)JOptionPane.showInputDialog(null,
//		                    							null,
//		                    							"Create a new Game",
//		                    							JOptionPane.PLAIN_MESSAGE,
//		                    							null,
//		                    							null,
//		                    							"Name");
		
		JOptionPane.showMessageDialog(gameFrame, "New Game");

		map.render(renderer, xZoom, yZoom);

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
		Game game = new Game(2);
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
	
	public Sprite[] getTiles(){
		return tiles.getSprites();
		
	}


	public void swap() {
		// TODO Auto-generated method stub
//		for (int i=0;i<buttons.length;i++)
			
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}


	public int getCurrentPlayer() {
		return currentPlayer;
	}


	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}