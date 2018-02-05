package map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import main.Globals;

public class Tile {
	int x, y;
	int type;

	Image tileImage;

	public Tile(int type, int x, int y) {
		this.x = x;
		this.y = y;
		this.type = type;

		try {
			tileImage = new Image("res/textures/tiles/tile" + type + ".png");
		} catch (SlickException e) {
			e.printStackTrace();
		}

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
