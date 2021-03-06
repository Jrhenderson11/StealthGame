package main;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import map.Level;
import world.items.Bullet;

public class World {

	Input input;

	private Level level;
	private Player player;
	private float pWidth;
	
	private ArrayList<Bullet> bullets;

	private int xOffset = 0;
	private int yOffset = 0;

	private Main master;

	public World(String mapName, Input newInput, Main newMaster) {
		this.level = new Level(mapName);
		this.player = new Player(3);
		this.pWidth = player.getWidth();
		this.input = newInput;
		this.bullets = new ArrayList<Bullet>();
	}

	public void update(GameContainer gc) {
		double deltaX = 0;
		double deltaY = 0;
		// Move player
		if (input.isKeyDown(Input.KEY_W)) {
			//player.changeY(-player.speed);
			deltaY = -player.speed;
		}
		if (input.isKeyDown(Input.KEY_S)) {
			deltaY = player.speed;
		}
		if (input.isKeyDown(Input.KEY_A)) {
			deltaX = -player.speed;
		}
		if (input.isKeyDown(Input.KEY_D)) {
			deltaX = player.speed;
		}
		if (input.isKeyDown(Input.KEY_SPACE)) {
			this.addToBullets(player.shoot());
		}

		float dir = (float) (Math.atan2(player.getY() - input.getMouseY(), player.getX() - input.getMouseX()));
		dir = (float) Math.toDegrees(dir - Math.PI / 2);
		player.setDirection(dir);

		int collideX = (int) (player.getX() + deltaX) / Globals.TILE_WIDTH;
		int collideY = (int) (player.getY() + deltaY) / Globals.TILE_HEIGHT;
		
		//COLLISIONS
		if (this.level.getTile(collideX, collideY).getCollide()) {
			//dont move?
			//negate delta
		} else {
			player.changeX(deltaX);
			player.changeY(deltaY);
		} 
		
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			gc.exit();
		}

		for (Bullet bullet : this.bullets) {
			bullet.update();

		}
		
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if ((bullet.getX() > xOffset || bullet.getX() < 0) || (bullet.getY() > yOffset || bullet.getY() < 0)) {
		//		bullets.remove(i);
			}
		}
	}

	public void addToBullets(Bullet newbullet) {
		this.bullets.add(newbullet);
	}

	public void display() {

		this.level.display(xOffset, yOffset);
		this.player.draw();
		for (Bullet bullet : this.bullets) {
			bullet.draw();
		}
	}
}
