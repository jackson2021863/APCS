/**
 * This class is holds a bunch of information about the enemies around the dungeon.
 * @author Dr. Cheese
 */
public class Enemy {
	int x; // holds the x component of the instance's position
	int y; // holds the y component of the instance's position

	int level; // holds how strong the monster should be, give or take
	int str; // holds how much damage the monster will do
	int def; // holds how much the monster will reduce damage taken
	Item drop; // holds what Item the monster will give on death
	String name; // holds what the monster is called in the text

	int playerX; // holds the player character's given x position
	int playerY; // holds the player character's given y position

	boolean pursuing = false; // this changes the state of the monster

	/**
	 * This constructor initializes an enemy with a name and some level to base the stats on.
	 * @param name String
	 * @param level int
	 */
	Enemy(String name, int level) {
		this.name = name;
		this.level = level;
		str = (int)(Math.ceil(Math.random()*level)); // makes the damage the monster does randonly based on the level
		def = (int)(Math.ceil(Math.random()*level)); // makes the amount the monster reduces damage by randomly based on the level
		x = (int)(Math.ceil(Math.random()*30)); // makes a random x position
		y = (int)(Math.ceil(Math.random()*30)); // makes a random y position
		drop = new Item(); // sets up the monster drop with a random item
	}

	/**
	 * This constructor initializes an enemy at some given x and y position and a level to base the stats on. The String name is not initialized.
	 * @param x int
	 * @param y int
	 * @param level int
	 */
	Enemy(int x, int y, int level) {
		this.x = x; // sets the x position to the given x
		this.y = y; // sets the y position to the given y
		this.level = level; // sets the level
		str = (int)(Math.ceil(Math.random()*level)); // makes the damage the monster does randonly based on the level
		def = (int)(Math.ceil(Math.random()*level)); // makes the amount the monster reduces damage by randomly based on the level
		drop = new Item();
	}
}
