package grafico;

import grafico.Punto;

public class Celda extends Punto implements Comparable<Celda> {
		
	Celda padre;
	int distanciaHeuristica;	//Distancia al nodo destino yendo de forma directa. 
	int esfuerzo;				//Esfuerzo para ir de una Celda a la que le sigue.
	int densidad;
	
	//Esta celda es par caminoMinimo.
	public Celda(int x, int y, Celda padre, int densidad, int distanciaHeuristica) {
		super(x, y);
		this.padre = padre;
		this.densidad = densidad;
		this.distanciaHeuristica = distanciaHeuristica;
	}
	
	public Celda(int x,int y) {
		super(x, y);
	}

	public Celda(Punto p) {
		super(p.getX(), p.getY());
	}

	public Celda getPadre() {
		return padre;
	}

	public void setPadre(Celda padre) {
		this.padre = padre;
	}

	public int getDistanciaHeuristica() {
		return distanciaHeuristica;
	}

	public void setDistanciaHeuristica(int distanciaHeuristica) {
		this.distanciaHeuristica = distanciaHeuristica;
	}


	public int getEsfuerzo() {
		return esfuerzo;
	}


	public void setEsfuerzo(int esfuerzo) {
		this.esfuerzo = esfuerzo;
	}


	public int getDensidad() {
		return densidad;
	}

	public void setDensidad(int densidad) {
		this.densidad = densidad;
	}
	
	public int calcularF() {
		return (this.esfuerzo + this.distanciaHeuristica);
	}

	public int compareTo(Celda dos) {
		if (this.calcularF() < dos.calcularF() || this.getDistanciaHeuristica() < dos.getDistanciaHeuristica()) {
			return -1;
		} else if (this.calcularF() > dos.calcularF() || this.getDistanciaHeuristica() > dos.getDistanciaHeuristica()) {
			return 1;
		} else {
			return 0;
		}
	}

	public boolean celdasIguales(Celda c) {
		return (this.getPunto().esIgual(c.getPunto()) && this.getPadre() == c.getPadre());
	}
	
	public Punto getPunto() {
		return (new Punto(this.getX(), this.getY()));
	}
	
}
