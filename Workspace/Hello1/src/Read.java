import java.util.Scanner;

public class Read {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int x;
		System.out.println("Enter an integer");
		x = reader.nextInt();
		System.out.println("you entered: " + x);
	}
}
