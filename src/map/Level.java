package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Level {
	
	int width;
	int height;

	Tile[][] tileMap;

	public Level(String filepath) {

		readMap(filepath);

	}

	public void display(int xOffset, int yOffset) {
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				tileMap[i][j].draw(xOffset, yOffset);
			}
		}
	}

	public void readMap(String filepath) {
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(filepath));

			int index = -1;

			while ((sCurrentLine = br.readLine()) != null) {
				if (index == -1) {
					String[] size = sCurrentLine.split(" ");
					width = Integer.parseInt(size[0]);
					height = Integer.parseInt(size[1]);

					tileMap = new Tile[width][height];
					index++;
				} else {
					String[] tileStr = sCurrentLine.split(" ");

					for (int i = 0; i < width; i++) {
						int tileType = Integer.parseInt(tileStr[i]);

						Tile t = new Tile(tileType, i, index);
						tileMap[i][index] = t;
					}

					index++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Tile getTile(int x, int y) {
		return this.tileMap[x][y];
	}
	
	private void setSprites() {
		
	}
	
}
