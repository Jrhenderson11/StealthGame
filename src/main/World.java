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

	private ArrayList<Bullet> bullets;
	
	private int xOffset = 0;
	private int yOffset = 0;

	private Main master;

	public World(String mapName, Input newInput, Main newMaster) {
		this.level = new Level(mapName);
		this.player = new Player(3);
		this.input = newInput;
		this.bullets = new ArrayList<Bullet>();
	}

	public void update(GameContainer gc) {

		// Move player
		if (input.isKeyDown(Input.KEY_W)) {
			player.changeY(-player.speed);
		}
		if (input.isKeyDown(Input.KEY_S)) {
			player.changeY(player.speed);
		}
		if (input.isKeyDown(Input.KEY_A)) {
			player.changeX(-player.speed);
		}
		if (input.isKeyDown(Input.KEY_D)) {
			player.changeX(player.speed);
		}
		if (input.isKeyDown(Input.KEY_SPACE)) {
			this.addToBullets(player.shoot());
		}

		float dir = (float) (Math.atan2(player.getY() - input.getMouseY(), player.getX() - input.getMouseX()));	
		dir = (float) Math.toDegrees(dir - Math.PI/2);
		player.setDirection(dir);

		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			gc.exit();
		}

		for (Bullet bullet: this.bullets) {
			bullet.update();
			//bullet.draw();
		}

	}

	public void addToBullets(Bullet newbullet) {
		System.out.println("new bullet");
		this.bullets.add(newbullet);
	}
	
	public void display() {

		this.level.display(xOffset, yOffset);
		this.player.draw();
		for (Bullet bullet: this.bullets) {
			bullet.draw();
		}
	}
}
