import TurtleGraphics.Pen;


public class Hexagon implements Shape {
	private double x;
	private double y;
	double side;
	
	public Hexagon() {
		x = 0;
		y = 0;
		side = 5;
	}
	
	public Hexagon(double x, double y, double side) {
		this.x = x;
		this.y = y;
		this.side = side;
	}
	
	@Override
	public double area() {
		return (3 * Math.sqrt(3) * Math.pow(side, 2) / 2);
	}

	@Override
	public void draw(Pen p) {
		p.up();
		p.move(y - side);
		p.turn(-90);
		p.move(x);
		p.turn(30);
		p.down();
		for (int i = 0; i < 6; i++) {
			p.move(side);
			p.turn(60);
		}
		p.up();
		p.turn(-30);
		p.move(-x);
		p.turn(90);
		p.move(-(y - (side)));
		p.down();
	}

	@Override
	public double getXPos() {
		return x;
	}

	@Override
	public double getYPos() {
		return y;
	}

	@Override
	public void move(double xPos, double yPos) {
		x = xPos;
		y = yPos;
	}

	@Override
	public void stretchBy(double factor) {
		side *= factor;
	}

	public String toString() {
		return "Hexagon: Center = (" + x + ", " + y + "); side length = " + side + ";";
	}
}
