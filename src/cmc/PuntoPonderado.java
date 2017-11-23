package cmc;

import java.awt.Color;
import java.util.Comparator;

import graficos.Punto;

public class PuntoPonderado extends Punto implements Comparator<PuntoPonderado>{

	private static final long serialVersionUID = 1L;
	private int densidad;
	
	public PuntoPonderado(int x, int y) {		
		super(x, y);
		this.densidad = 0;
	}
	
	public PuntoPonderado(int x, int y, int densidad) {
		super(x, y);
		this.densidad = densidad;
	}
	public PuntoPonderado(int x, int y, Color color) {
		super(x, y, color);
		this.densidad = 0;
	}
	
	public PuntoPonderado(int x, int y, int densidad, Color color) {
		super(x, y, color);
		this.densidad = densidad;
	}
	
	public int getDensidad() {
		return densidad;
	}

	public int compare(PuntoPonderado pp0, PuntoPonderado pp1) {
		return (int) (pp0.getDensidad() - pp1.getDensidad());
	}
}
