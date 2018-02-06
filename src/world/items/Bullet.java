package world.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet {
	private int damage;
	private float speed;
	private float x;
	private float y;

	private float targetX;
	private float targetY;
	private float direction;

	Image icon;

	public Bullet(int dmg, float newX, float newY, float targetX, float targetY) {
		this.speed = (float) 16;
		this.damage = dmg;
		this.x = newX;
		this.y = newY;
		this.targetX = targetX;
		this.targetY = targetY;
		try {
			this.icon = new Image("res/textures/bullet.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Bullet(int dmg, float newX, float newY, float dir) {
		this.speed = (float) 40;
		this.damage = dmg;
		this.x = newX;
		this.y = newY;
		this.direction = dir;
		try {
			this.icon = new Image("res/textures/bullet.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void update() {
		float dY = 0;
		float dX = 0;
		if (this.direction < 90) {
			// top right
			dY = -(float) Math.cos(Math.toRadians(this.direction)) * this.speed;
			dX = (float) Math.sin(Math.toRadians(this.direction)) * this.speed;

		} else if (this.direction < 180) {
			// bottom right
			dY = (float) Math.cos(Math.toRadians(this.direction)) * this.speed;
			dX = -(float) Math.sin(Math.toRadians(this.direction)) * this.speed;

		} else if (this.direction < 270) {
			// bottom left
			dY = (float) Math.cos(Math.toRadians(this.direction)) * this.speed;
			dX = (float) Math.sin(Math.toRadians(this.direction)) * this.speed;
		} else {
			// top left
			dY = -(float) Math.cos(Math.toRadians(this.direction)) * this.speed;
			dX = (float) Math.sin(Math.toRadians(this.direction)) * this.speed;
		}

		this.x += dX;
		this.y += dY;

	}

	public void draw() {
		//this.icon.rotate((float) Math.toRadians(this.direction));
		this.icon.setRotation(this.direction);
		this.icon.draw(this.x, this.y, 4);
	}

}
