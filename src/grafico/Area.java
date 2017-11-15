package grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import mapa.AreaColor;

public class Area implements DibujoTDA {
	
	private Punto a;
	private Punto b;
	private Rectangle rect;
	private AreaColor color;
	private int densidad;
	
	public Area(Punto a, Punto b, AreaColor color) {
		this.a = a;
		this.b = b;
		rect = new Rectangle();
		rect.x = getX();
		rect.y = getY();
		rect.width = getAncho();
		rect.height = getAlto();
		this.color = color;
	}
	
	public Color getColor() {
		return color.getColor(); 
	}
	
	public int getColorOrdinal() {
		return color.ordinal();
	}
	
	public void setColor(AreaColor color) {
		this.color = color;
	}
	
	public int[] getCoordenadas(){
		return new int[]{getX(), getY(), getAncho(), getAlto()};
	}

	public Rectangle getRectangle() {
		return rect;
	}
	
	@Override
	public void dibujar(Graphics g) {
		g.setColor(color.getColor());
	    g.fillRect(getX(), getY(), getAncho(), getAlto());
	}

	@Override
	public String toString() {
		return "Area:" + color + "(" + rect.x + "," + rect.y + "," + rect.width + "," + rect.height + ")";
	}
	
	int getX() {
		return (a.getX() < b.getX() ? a.getX() : b.getX());
	}
	
	int getY() {
		return (a.getY() < b.getY() ? a.getY() : b.getY());
	}
	
	int getAncho() {
		return (a.getX() > b.getX() ? a.getX() - b.getX() + 1 : b.getX() - a.getX() + 1);
	}
	
	int getAlto() {
		return (a.getY() > b.getY() ? a.getY() - b.getY() + 1 : b.getY() - a.getY() + 1);
	}
	
	public void setDensidad(int densidad) {
		this.densidad = densidad;
	}
	
	public int getDensidad(){
		return this.densidad;
	}
	
}
