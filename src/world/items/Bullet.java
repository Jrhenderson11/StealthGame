package world.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet {
	private int damage;
	private float speed;
	private float x;
	private float y;
	private float direction;

	Image icon;
	
	public Bullet(int dmg, float newX, float newY, float dir) {
		this.speed = (float) 16;
		this.damage = dmg;
		this.x = newX;
		this.y = newY;
		try {
			this.icon  = new Image("res/textures/bullet.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		float dY = 0;
		float dX = 0;
		
		if (this.direction < Math.PI/2) {
			//top right
			dY = (float) Math.cos(this.direction) * this.speed;
			dX = (float) Math.sin(this.direction) * this.speed;
			
		} else if (this.direction < Math.PI) {
			//bottom right
			dY = -(float) Math.cos(this.direction - Math.PI/2) * this.speed;
			dX = (float) Math.sin(this.direction- Math.PI/2) * this.speed;
		
		} else if (this.direction < (Math.PI * 1.5)) {
			//bottom left
			dY = -(float) Math.cos(this.direction - Math.PI) * this.speed;
			dX = -(float) Math.sin(this.direction - Math.PI) * this.speed;
		} else if (this.direction < (2*Math.PI)) {
			//top left
			dY = (float) Math.cos(this.direction - (Math.PI * 1.5)) * this.speed;
			dX = -(float) Math.sin(this.direction - (Math.PI * 1.5)) * this.speed;
		}
		System.out.println(dX);
		System.out.println(dY);
		this.x+=dX;
		this.y+=dY;

	}
	
	public void draw() {
		System.out.println("draw");
		//this.icon.rotate(this.direction);
		this.icon.draw(this.x,this.y);
	}
	
}
