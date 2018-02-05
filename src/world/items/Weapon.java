package world.items;

import org.newdawn.slick.Image;

public abstract class Weapon {

	public Weapon(int ammo, int magSize) {
		this.magazineSize = magSize;
		this.currentMagSize = 0;
		this.spareAmmo = ammo;
		this.load();
	}
	
	protected Image icon;
	
	protected int spareAmmo;
	
	protected int damage;
	
	protected int magazineSize;	
	
	protected int currentMagSize;

	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}

	public int getAmmo() {
		return spareAmmo;
	}

	public void setAmmo(int ammo) {
		this.spareAmmo = ammo;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMagazineSize() {
		return magazineSize;
	}

	public void setMagazineSize(int magazineSize) {
		this.magazineSize = magazineSize;
	}

	public int getCurrentMagSize() {
		return currentMagSize;
	}

	public void setCurrentMagSize(int currentMagSize) {
		this.currentMagSize = currentMagSize;
	}

	/* ================*/
	//     ACTIONS
	/* ================*/
	
	public void load() {
		if (this.spareAmmo >= this.magazineSize) {
			this.currentMagSize = this.spareAmmo;
			this.spareAmmo -= this.magazineSize;
		} else {
			this.currentMagSize = this.spareAmmo;
			this.spareAmmo = 0;
		}
	}
	
	public Bullet shoot(float x, float y, float direction) {
		
		//shoot in dir
		if (this.currentMagSize > 0) {
			
			//animation
			//sound
			//create bullet
			Bullet bullet = new Bullet(this.damage, x, y, direction);
			return bullet;
			//eject casing
			//sound
			//decrement ammo
		} else {
			//click sound
			return null;
		}
		
	}

}
