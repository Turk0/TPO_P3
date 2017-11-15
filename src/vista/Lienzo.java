package vista;

import grafico.DibujoTDA;

import java.awt.Canvas;
import java.awt.Graphics;

public class Lienzo extends Canvas {
	
	private static final long serialVersionUID = 1L;
	private DibujoTDA dibujo;
	 
	public DibujoTDA getDibujo() {
		return dibujo;
	}

	public void setDibujo(DibujoTDA dibujo) {
		this.dibujo = dibujo;
	}

	public void paint(Graphics g) {}
	
	public void update(Graphics g) {
		dibujo.dibujar(g);
		paint(g);
	}
	
}
