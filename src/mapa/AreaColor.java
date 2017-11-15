package mapa;

import java.awt.Color;

public enum AreaColor {
	
	BLANCO (Color.white),
	AMARILLO (Color.yellow),
	AZUL (Color.blue),
	NEGRO (Color.black),
	GRIS (Color.lightGray);

	private Color color;
	
	AreaColor(Color c) {
		this.color = c; 
	}
	
	public Color getColor() {
		return color;
	}
	
}
