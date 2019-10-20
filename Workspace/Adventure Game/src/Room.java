
public class Room {
	int width;
	int height;
	int playerX;
	int playerY;
	
	boolean checked = false;
	Chest[] Chests = {new Chest(1, 30), new Chest(1, 18)};

	String orientation;

	Room(int width, int height, String orientation) {
		this.width = width + 2;
		this.height = height + 2;
		this.orientation = orientation;	
		System.out.println("length: " + Chests.length);
	}

	public String toString() {
		String s = "";
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (y == playerY && x == playerX) {
					s += "@ ";
				} else if (y == 0 || y == height-1 || (y == 14 && x > 6)  || (y == 18 && x > 25) || (y == 18 && x < 6) || (y == 25 && x > 25) || (y == 29 && x < 6)) {
					if ((x == (width/2)-1 && y == height-1) || (x == 27 && y == 25) || (x == 5 && y == 29)) {
						s += "- ";
					} else {
						s += "# ";
					}
				} else if ((y == 4) && (x<6)) {
					s += "# ";
				} else {
					if (y == playerY && x == playerX) {
						s += "@ ";
					}/* else if (x == Chests[0].x && y == Chests[0].y) {
						s += "H ";
					}*/ else if ((x == 0) || (x == width-1) || (x == 6) || (x == 25)) {
						if ( ((y == 2 || y == 10 || y == 15 || y == 23) && x == 6) || ((y == 10 || y == 17 || y == 29) && x == 25) ) {
							s += "| ";
						} else {
							s += "# ";
						}
					} else  {			
						if (chestCheck(x, y)) {
							s += "H ";
						} else {
							s += "  ";
						}
					}
				}

			}
			s += "\n";
		}

		return s;
	}

	public void update(int playerX, int playerY) {
		this.playerX = playerX;
		this.playerY = playerY;
	}
	
	boolean chestCheck(int x, int y) {
		for (int i = 0; i < Chests.length; i++) {
			/*if (y == Chests[1].y) {
				System.out.println("yee");
			}
			if (x == Chests[1].x) {
				System.out.println("yoo");
			}if (x == Chests[1].x && y == Chests[1].y) {
				System.out.println("yoo");
			}
			if (i == 1) {
				System.out.println(x + " == " + Chests[0].x);
				System.out.println(y + " == " + Chests[0].y);
			}*/
			if (x == Chests[i].x && y == Chests[i].y) {
				return true;
			}
		}
		return false;
	}
}