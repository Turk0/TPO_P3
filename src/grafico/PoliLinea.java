package grafico;

import java.awt.Color;
import java.awt.Graphics;


public class PoliLinea implements DibujoTDA {
	
	int[] xp;
	int[] yp;
	Color color;
	
	public PoliLinea(int[] xp, int[] yp, Color color) {
		this.xp = xp;
		this.yp = yp;
		this.color = color;
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.setColor(color);
	    g.drawPolyline(xp, yp, xp.length);
	}

}
