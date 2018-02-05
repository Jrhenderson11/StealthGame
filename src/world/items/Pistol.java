package world.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Pistol extends Weapon {

	public Pistol() {
		super(10, 8);
		try {
			icon = new Image("res/textures/pistol.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.damage = 10;
	}
	
	
	
}
