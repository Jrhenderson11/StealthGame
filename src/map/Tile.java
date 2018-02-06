package map;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import main.Globals;

public class Tile {
	int x, y;
	int type;

	Image tileImage;

	private boolean collides;
	
	public Tile(int type, int x, int y) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.collides = false;
		
		Random random = new Random();
		
		try {
			tileImage = new Image("res/textures/tiles/planks" + random.nextInt(4) + ".png");
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	public boolean getCollide() {
		return this.collides;
	}
	
	public void draw(int xOffset, int yOffset) {
		int imageX = this.x * Globals.TILE_WIDTH - xOffset;
		int imageY = this.y * Globals.TILE_HEIGHT - yOffset;
		
		if (imageX > -Globals.TILE_WIDTH && imageX < Globals.SCREEN_WIDTH && imageY > -Globals.TILE_HEIGHT
				&& imageY < Globals.SCREEN_HEIGHT) {
			tileImage.draw(imageX, imageY, 50, 50);
		}
	}

}
