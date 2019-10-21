import java.util.Scanner;

public class Runner {
	static Room frame = new Room(30, 30, "down");
	static Chest[] Chests = frame.Chests;
	static Scanner reader = new Scanner(System.in);
	static Player you;

	static String name = "";
	static int turn;
	static long ticks = 2000000000L;

	static boolean PlayerTurn = true;
	static boolean EnemyTurn = false;
	static boolean startup = false;
	static boolean running = false;

	public static void main(String[] args) {
		if (startup == true) {
			print("Welcome to Jackson's Adventure Game! What would you like the character's name to be?");
			name = reader.nextLine();
			print("What race would you like to be? Your choices are human, orc, or goblin.");
			String race = reader.nextLine();
			you = new Player(race);
			while (you.HP <= 0) {
				print("That is not an answer. What race would you like to be?");
				race = reader.nextLine();
				you = new Player(race);

			}

			line();
			print("Welcome, " + name + ". In this game, you are an adventurer who has delved into a dungeon. In this view, \"#\"s represent \nthe walls, \"+\"s are locked doors, \"-\"s and |s are open doors, \"H\"s are chests, and \"X\"s are monsters. You \nare the \"@\" symbol.");
			stats();

			startup = false;
			running = true;
			line();
		} else {
			name = "J";
			you = new Player("goblin");
			running = true;
		}

		do {
			frame.update(you.x, you.y);
			System.out.println(frame);
			print("x: " + you.x + "\ny: " + you.y);

			if (PlayerTurn) {
				if (turn == 0) {
					print("What would you like to do? (give commands in lowercase only) (example: move, attack, open)");
				} else {
					print("What would you like to do now?");
				}

				String action = reader.nextLine();
				if (action.equals("")) {
					action = reader.nextLine();
				}

				while (action.equals("help") || action.equals("stats")) {
					if (action.equals("help")) {
						help();
					} else if (action.equals("stats")) {
						stats();
					}
					line();
					print("What would you like to do now?");
					action = reader.nextLine();
				}

				if (action.equals("move")) {
					move();
				} else if (action.equals("wait")) {
					print(name + " waited");
				} else if (action.equals("open")) {
					open();
				} else {
					print("action = " + action);
				}
				line();

				for (long i = 0; i < ticks; i++) {}

				EnemyTurn = true;
			}

			if (EnemyTurn) {
				PlayerTurn = true;
			}

			if (you.HP <= 0) {
				running = false;
			}
			turn++;
		} while (running);
	}

	static void stats() {
		line();
		System.out.println(you);
	}

	static void help() {
		print("The list of commands is as follows: \n - move (lets your character move a space in one direction that you specify) \n - attack (makes your character attack one of the tiles next to him/her) \n - open (opens a chest that is next to your character) \n - stats (lets you see your character's stats) \n - wait (skips straight to the enemies' turn) \n Make sure you give all your commands in lowercase!");
	}

	static void open() {
		for (int i = 0; i < Chests.length ; i++) {if ((Chests[i].x - you.x == -1) && (Chests[i].y == you.y)) {
				Chests[i].open();
			} else if ((Chests[i].x - you.x == 1) && (Chests[i].y == you.y)) {
				Chests[i].open();
			} else if ((Chests[i].y - you.y == -1) && (Chests[i].x == you.x)) {
				Chests[i].open();
			} else if ((Chests[i].y - you.y == 1) && (Chests[i].x == you.x)) {
				Chests[i].open();
			}
		}
	}

	static void move() {
		print("Which direction would you like to move? (up, down, left, or right)");
		String action = reader.nextLine();

		if (you.spd == 1) {
			you.move(action, 1);
			while (!you.moved) {
				print("Which direction would you like to move?");
				action = reader.nextLine();
				you.move(action, 1);
			}
			print(name + " moved " + action);
		} else {
			int spaces = 0;

			do {
				print("How many spaces would you like to move?");
				spaces = reader.nextInt();

				if (spaces > you.spd) {
					print("you can't move faster than your speed will allow.");
					line();
				} else if (spaces == 0) {
					print("you can't move 0 spaces.");
					line();
				} else if (spaces < 0) {
					print("you can't move negative spaces.");
					line();
				}
			} while ((spaces < 0) || (spaces == 0) || (spaces>you.spd));

			you.move(action, spaces);
			while (!you.moved) {
				action = "";
				print("Which direction would you like to move?");
				action = reader.nextLine();
				if (action.equals("")) {
					action = reader.nextLine();
				}
				do {
					print("How many spaces would you like to move?");
					spaces = reader.nextInt();

					if (spaces > you.spd) {
						print("you can't move faster than your speed will allow.");
						line();
					} else if (spaces == 0) {
						print("you can't move 0 spaces.");
						line();
					} else if (spaces < 0) {
						print("you can't move negative spaces.");
						line();
					}
				} while ((spaces < 0) || (spaces == 0) || (spaces>you.spd));

				you.move(action, spaces);
			}

			if (spaces != 1) {
				print(name + " moved " + action + " " + spaces + " spaces");
			} else {
				print(name + " moved " + action + " " + spaces + " space");
			}
		}
	}

	static void line() {
		System.out.println();
	}

	static void print(String s) {
		System.out.println(s);
	}
}
