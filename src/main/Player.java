package main;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import world.items.Bullet;
import world.items.Pistol;
import world.items.Weapon;

/**
 * Created by Vakerrian on 13/10/2016.
 */

public class Player {

	public double speed;
	
	private Image sprite;
	
	private double x;
	private double y;

	private float direction;
	
	private Item[] inventory;
	private Weapon[] weapons;

	private Weapon currentWeapon;
	
	public boolean isTrapped;

	public Player(int inventorySize){
		
		try {
			this.sprite  = new Image("res/textures/shittyplayersprite.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.speed = 1;
		
		setInventory(inventorySize);
		
		isTrapped = false;
	
		this.weapons = new Weapon[2];
		this.weapons[0] = new Pistol();
		this.currentWeapon = weapons[0];
		this.x = 500;
		this.y = 500;
	}

	/* ====== */

	private void setInventory(int inventorySize) {
		inventory = new Item[inventorySize];

		for (int i = 0; i < inventory.length; i++) {
			inventory[i] = Item.EMPTY;
		}
	}

	public Item[] getInventory() {
		return inventory;
	}
	
	public Weapon[] getWeapons() {
		return this.weapons;
	}

	public void addItem(Item item) {
		boolean hasSpace = false;
		for (int index = 0; index < inventory.length; index++) {
			if (inventory[index].equals(Item.EMPTY)) {
				inventory[index] = item;
				hasSpace = true;
				break;
			}
		}
		if (!hasSpace) {
			System.out.println("\n\t[INVENTORY] Inventory is full");
		}
	}

	public void removeItem(Item item) {
		boolean hasRemoved = false;
		for (int index = 0; index < inventory.length; index++) {
			if (inventory[index].equals(item)) {
				inventory[index] = Item.EMPTY;
				hasRemoved = true;
				break;
			}
		}
		if (!hasRemoved) {
			System.out.println("\n\t[INVENTORY] Item not found");
		}
	}

	public void setDirection(float newDir) {
		this.direction =  newDir;
	}

	public void changeX(double dX) {
		this.x +=dX;
	}
	
	public void changeY(double dY) {
		this.y +=dY;
	}
	
	public void setCoordinates(double newX, double newY) {
		this.x = newX;
		this.y = newY;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public boolean isTrapped() {
		return isTrapped;
	}
	
	public float getWidth() {
		return this.sprite.getWidth();
	}
	
	/* ================*/
	//     ACTIONS
	/* ================*/
	
	public Bullet shoot() {
		//shoot in dir
		//animation
		//sound
		System.out.println(this.direction);
		return this.currentWeapon.shoot((float) this.x,(float) this.y, this.direction);
		
	}
	
	public void draw() {
		this.sprite.setRotation(this.direction);
		this.sprite.draw((float) x,(float) y);
	}
	
}