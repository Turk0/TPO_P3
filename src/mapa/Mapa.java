package mapa;

import java.util.PriorityQueue;

import grafico.Area;
import grafico.Celda;
import grafico.DibujoTDA;
import grafico.Punto;

public class Mapa {
	
    static int VALOR_MAXIMO = AreaColor.values().length;
	private int[][] grilla;
	private Celda grilla1[][];
	private int dimension;
	
    public Mapa() {
    	grilla = new int[DibujoTDA.LARGO][DibujoTDA.ALTO];
    }
	
	public Mapa (int dimension) {
		this.dimension = dimension;
		this.grilla1 = new Celda [dimension + 2][dimension + 2];
		
		for (int i = 0; i < dimension + 2; i++) { 
		  for (int j = 0; j < dimension + 2; j++) {
			if ( (i == 0) || (j == 0) || (i == dimension + 1) || (j == dimension + 1)) {			
				this.grilla1[i][j] = new Celda (i, j, null, 0, 0);			
			} else {
				this.grilla1[i][j] = new Celda (i, j, null, (int) Math.round(Math.random() * 3), 0);
			}
		  }
		}
	}
	

	public int[][] getGrilla() {
		return grilla;
	}
	
	public void setArea(Area area) {
		int[] c = area.getCoordenadas();
		
		for (int w = 0; w < c[2]; w++) {
			for (int h = 0; h < c[3]; h++) {
				grilla[c[0] + w][c[1] + h] = area.getColorOrdinal();
			}
		}
	}
	
	public int getDensidad(int x, int y) {
		return grilla[x][y];
	}
	
	public int getDensidad(Punto p) {
		return grilla[p.getX()][p.getY()];
	}
	
	public int calcularH(Punto o, Punto d) {
		
		int H;
		int i = 0;
		int j = 0;
		
		if (o.getX() <= d.getX()) {
			for (i = o.getX(); i <= d.getX(); i++){}
		} else if (o.getX() > d.getX()) {
			for (i = o.getX(); i >= d.getX(); i--){}
		}
		
		if (o.getY() <= d.getY()) {
			for(j = o.getY(); j <= d.getY(); j++) {}
			
		} else if (o.getY() > d.getY()) {
			for(j = o.getY(); j >= d.getY(); j--) {}
		}
		
		H = i + j;
		
		return H;
		
	}
		
	public PriorityQueue<Celda> adyacentes(Celda origen) {
		
		PriorityQueue<Celda> res = new PriorityQueue<Celda>();
		Punto aux = origen.getPunto();
		Punto p;
		Celda c;
		
		//Busco los adyacentes.
		if (this.getDensidad(aux.getX() - 1, aux.getY()) != AreaColor.NEGRO.ordinal()) {
			p = new Punto(aux.getX() - 1, aux.getY());
			c = new Celda(p);
			c.setPadre(origen);
			res.add(c);
		}
		
		if (this.getDensidad(aux.getX() + 1, aux.getY()) != AreaColor.NEGRO.ordinal()) {
			p = new Punto(aux.getX() + 1, aux.getY());
			c = new Celda(p);
			c.setPadre(origen);
			res.add(c);
		}
		
		if (this.getDensidad(aux.getX(), aux.getY() - 1) != AreaColor.NEGRO.ordinal()) {
			p = new Punto(aux.getX(), aux.getY() - 1);
			c = new Celda(p);
			c.setPadre(origen);
			res.add(c);
		}
		
		if (this.getDensidad(aux.getX(), aux.getY() + 1) != AreaColor.NEGRO.ordinal()) {
			p = new Punto(aux.getX(), aux.getY() + 1);
			c = new Celda(p);
			c.setPadre(origen);
			res.add(c);
		}
		
		return res;
		
	}
	
	public String imprimirColaPrioridad(PriorityQueue<Celda> p) {
		String res = "";
		PriorityQueue<Celda> c = new PriorityQueue<Celda>();
		c.addAll(p);
		
		while (!c.isEmpty()) {
			res += c.poll();
		}
		
		return res;
		
	}
	
	public void setDensidad(Area a, int densidad) {
		a.setDensidad(densidad);
	}
	
	public void calcularDensidad(Celda c) {
		c.setDensidad(c.getDensidad() + c.getPadre().getDensidad());
	}
	
	public String toString () {
		
		String res = "Mapa: \n";
		
		for (int i = 1; i < this.dimension + 1; i++) {
			  
			for (int j = 1; j < this.dimension + 1; j++) {
				  res += " (" + i + "," + j + ") P:" + grilla1[i][j].calcularF();
			  }
			  
			  res += "\n";
		}
		
		return res;
	}
	
}