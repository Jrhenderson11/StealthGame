package main;

import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

import gui.Button;
import gui.GuiManager;
import map.Level;

public class Main extends BasicGame implements ComponentListener {

	Level testLevel;

	Menu menuState;
	boolean menu = true;

	GuiManager gameGuiManager;

	private World world;
	
	private GameContainer gc;
	
	public Main(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.world = new World("res/levels/mansion.txt", gc.getInput(), this);
		//testLevel = new Level("res/levels/mansion.txt");
		menuState = new Menu(gc, this);

	}

	@Override
	public void update(GameContainer gc, int tpf) throws SlickException {
		if (menu) {
			menuState.update();
		} else {
			world.update(gc);
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if (menu) {
			menuState.render(gc, g);
		} else {
			g.setColor(Color.black);
			g.fillRect(0, 0, Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT);
			
			//testLevel.display(XOffset, YOffset);
			world.display();
		}
	}

	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Main("Simple Slick Game"));
			appgc.setDisplayMode(Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT, Globals.FULLSCREEN);
			appgc.setTargetFrameRate(Globals.MAX_FPS);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		if (menu) {
			for (int i = 0; i < menuState.getGuiManager().getComponents().size(); i++) {
				if (menuState.getGuiManager().getComponents().get(i) instanceof Button) {
					Button b = (Button) (menuState.getGuiManager().getComponents().get(i));
					if (source == b.getComponent()) {
						b.run();
					}
				}
			}
		} else {
			for (int i = 0; i < gameGuiManager.getComponents().size(); i++) {
				if (gameGuiManager.getComponents().get(i) instanceof Button) {
					Button b = (Button) (gameGuiManager.getComponents().get(i));
					if (source == b.getComponent()) {
						b.run();
					}
				}
			}
		}
	}
	
}
