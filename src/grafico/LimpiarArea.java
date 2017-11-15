package grafico;

import java.awt.Graphics;

import app.Inicio;


public class LimpiarArea implements DibujoTDA {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	public LimpiarArea() {
		x = y = 0;
		ancho = Inicio.panelLienzo.getLienzo().getWidth();
		alto = Inicio.panelLienzo.getLienzo().getHeight();
	}
	
	public LimpiarArea(Area area) {
		this.x = area.getCoordenadas()[0];
		this.y = area.getCoordenadas()[1];
		this.ancho= area.getCoordenadas()[2];
		this.alto = area.getCoordenadas()[3];
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.clearRect(x, y, ancho, alto);
	}

}
