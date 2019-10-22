import java.util.ArrayList;

public class Player {
	public int x;
	public int y;

	public int str;
	int strmod = 0;
	public int dmg = 2;
	public int def;
	int defmod = 0;
	public int dmgred = 2;
	public int spd;
	public int HP;
	public String name;

	public Item[] inventory = {new Item("Shortsword", 0)};
	public Item weapon;
	public Item gear;
	boolean firstWeapon = true;
	public boolean gearset;

	public boolean moved = false;

	Player(String race) {
		x = 30;
		y = 1;

		if (race.equals("goblin")) {
			HP = 3;
			str = 2;
			def = 1;
			spd = 2;
		} else if (race.equals("human")) {
			HP = 4;
			str = 3;
			def = 3;
			spd = 1;
		} else if (race.equals("orc")) {
			HP = 5;
			str = 5;
			def = 1;
			spd = 1;
		}

		equip(inventory[0]);
	}
	
	Player() {
		x = 30;
		y = 1;
	}

	public void get(Item a) {
		ArrayList<Item> b = new ArrayList<Item>();
		for (int i = 0; i < inventory.length; i++) {
			b.add(inventory[i]);
		}
		b.add(a);
		inventory = new Item[b.size()];
		b.toArray(inventory);
	}

	public void setWeapon(Item a) {
		for (int i = 0; i < inventory.length; i++) {
			if (a.name.equals(inventory[i].name)) {
				equip(inventory[i]);
			}
		}
	}

	public void setWeaponByType(String s) {
		for (int i = 0; i < inventory.length; i++) {
			if (s.equals(inventory[i].type)) {
				equip(inventory[i]);
			}
		}
	}

	public void setWeaponByName(String s) {
		for (int i = 0; i < inventory.length; i++) {
			if (s.equals(inventory[i].name)) {
				equip(inventory[i]);
			}
		}
	}

	public void setGear(Item a) {
		for (int i = 0; i < inventory.length; i++) {
			if (a.name.equals(inventory[i].name)) {
				equip(inventory[i]);
			}
		}
		gearset = true;
	}

	public void setGearByName(String s) {
		for (int i = 0; i < inventory.length; i++) {
			if (s.equals(inventory[i].name)) {
				equip(inventory[i]);
			}
		}
		gearset = true;
	}

	public void setGearByType(String s) {
		for (int i = 0; i < inventory.length; i++) {
			if (s.equals(inventory[i].type)) {
				equip(inventory[i]);
			}
		}
		gearset = true;
	}

	void equip(Item a) {
		if (a.weapon) {
			if (firstWeapon) {
				strmod = a.mod;
				firstWeapon = false;
			} else {
				strmod -= weapon.mod;
				strmod += a.mod;
			}
			weapon = a;
			dmg = str + strmod;
		} else if (a.gear) {
			if (gearset) {
				if (gear.dmgBoost) {
					strmod -= gear.mod;
				} else {
					defmod -= gear.mod;
				}
			}

			if (a.dmgBoost) {
				strmod += a.mod;
				dmg = str + strmod;
			} else {
				defmod += a.mod;
				dmgred = def + defmod;
			}
			gear = a;
		}
	}

	public void move(String direction, int spaces) {
		moved = false;
		if (direction.equals("up")) {
			int newY = y - spaces;
			if (newY <= 0) {
				System.out.println("Your character can't move through walls.");
			} else {
				y = newY;
				moved = true;
			}
		} else if (direction.equals("right")) {
			int newX = x + spaces;
			if ((newX >= 31) || (newX == 6 && y != 2 && y != 10 && y != 15 && y != 23) || (newX == 25 && y != 10 && y != 17 && y != 29)) {
				System.out.println("Your character can't move through walls.");
			} else {
				x = newX;
				moved = true;
			}
		} else if (direction.equals("down")) {
			int newY = y + spaces;
			if (newY >= 31) {
				System.out.println("Your character can't move through walls.");
				newY = y;
			} else {
				y = newY;
				moved = true;
			}
		} else if (direction.equals("left")) {
			int newX = x - spaces;
			if (newX <= 0) {
				System.out.println("Your character can't move through walls.");
			} else {
				x = newX;
				moved = true;
			}
		}
	}

	public String toString() {
		String s = "";
		if (gearset && !gear.dmgBoost) {
			s += "Your stats: \n  Strength: " + dmg + " (base: " + str + " + " + weapon.name + ")\n  Defense: "
					+ dmgred + " (base: " + def + " + " + gear.name + ")\n  HP: " + HP + "\n  Movement Speed: " + spd;
		} else if (gearset) {
			s += "Your stats: \n  Strength: " + dmg + " (base: " + str + " + " + weapon.name + " + " + gear.name
					+")\n  Defense: " + def + "\n  HP: " + HP + "\n  Movement Speed: " + spd;
		} else {
			s += "Your stats: \n  Strength: " + dmg + " (base: " + str + " + " + weapon.name + ")\n  Defense: "
					+ def + "\n  HP: " + HP + "\n  Movement Speed: " + spd;
		}
		return s;
	}
}
