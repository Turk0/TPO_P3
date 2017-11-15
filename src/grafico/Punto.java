package grafico;

import java.awt.Color;
import java.awt.Graphics;

public class Punto implements DibujoTDA {
	
	private int x;
	private int y;
	
	public Punto(int x, int y) {
		this.x = (x < 0 ? 0 : (x > LARGO - 1 ? LARGO - 1 : x));
		this.y = (y < 0 ? 0 : (y > ALTO - 1 ? ALTO - 1 : y));
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.red);
	    g.drawOval(x - 5, y - 5, 9, 9);
	}
	
	public boolean esIgual(Punto p) {
		return (this.x == p.x && this.y == p.y);
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
