
public class Player {
	public int x;
	public int y;
	public int str;
	int strmod;
	public int def;
	int defmod;
	public int spd;
	public int HP;
	public String name;
	
	public boolean moved = false;
	
	Player(String race) {
		x = 2;
		y = 30;
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
	}
	
	public void move(String direction, int spaces) {
		moved = false;
		if (direction.equals("up")) {
			int newY = y - spaces;
			System.out.println(newY);
			if (newY <= 0) {
				System.out.println("Your character can't move through walls.");
			} else {
				y = newY;
				moved = true;
			}	
		} else if (direction.equals("right")) {
			int newX = x + spaces;
			System.out.println(newX);
			if ((newX >= 31) || (newX == 6 && y != 2 && y != 10 && y != 15 && y != 23) || (newX == 25 && y != 10 && y != 17 && y != 29)) {
				System.out.println("Your character can't move through walls.");
			} else {
				x = newX;
				moved = true;
			}
		} else if (direction.equals("down")) {
			int newY = y + spaces;
			System.out.println(newY);
			if (newY >= 31) {
				System.out.println("Your character can't move through walls.");
				newY = y;
			} else {
				y = newY;
				moved = true;
			}
		} else if (direction.equals("left")) {
			int newX = x - spaces;
			System.out.println(newX);
			if (newX <= 0) {
				System.out.println("Your character can't move through walls.");
			} else {
				x = newX;
				moved = true;
			}
		}
	}
	
	public String toString() {
		return ("Your stats: \n  Strength: " + str + "\n  Defense: " + def + "\n  HP: " + HP + "\n  Movement Speed: " + spd);
	}
}
