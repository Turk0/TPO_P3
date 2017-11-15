package grafico;

import grafico.DibujoTDA;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import mapa.*;

public class Camino extends Mapa implements DibujoTDA {
	
	Celda origen;
	Celda destino;
	PriorityQueue<Celda> abierta;
	LinkedList<Celda> cerrada;
	
	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.GREEN);
		//g.drawPolyline(arg0, arg1, arg2)
		
	}
	
	public Camino(Celda origen, Celda destino) {
		this.origen = origen;
		this.destino = destino;
		this.abierta = new PriorityQueue<Celda>();
		this.cerrada = new LinkedList<Celda>();
	}
	
	public LinkedList<Celda> caminoMinimo() {
		int i = 0;
		this.cerrada.add(origen); //Agrego celda origen
		Celda menor = origen;
		LinkedList<Celda> resultado = new LinkedList<Celda>(); //Lista con el camino recorrido
		Stack<Celda> pila = new Stack<Celda>(); 
			
		do {		
			/*
			 * En esta linea primero obtenemos los adyacentes a una celda origen, sin las infranqueables,
			 * luego le sacamos los adyacentes que ya se encontraban en la lista abierta, y por ultimo 
			 * agregamos los nuevos a la lista.
			 */
			this.abierta.addAll(this.adyacentesMenosLosDeLaAbierta(this.adyacentes(origen)));
			
			System.out.println("Abierta: "+this.abierta.toString());
			menor = this.abierta.poll();
			
			menor.setDistanciaHeuristica(this.calcularH(menor.getPunto(), destino.getPunto())); //Calculamos distancia heuristica.
			this.cerrada.addLast(menor); //Agregamos el menor a la lista cerrada.
			System.out.println(" " + i + " menor: " + menor.toString() + " destino: " + this.destino.toString());
			
		} while (!menor.celdasIguales(destino) /*&& !(this.abierta.isEmpty())*/);
		
		/* Armamos el camino que se guardara en una pila. */
		if (!this.cerrada.isEmpty()) { 
			pila = this.armarCamino();
			resultado.addAll(pila);
		}
	
		return resultado;
	}
	
	public PriorityQueue<Celda> adyacentesMenosLosDeLaAbierta(PriorityQueue<Celda> l) {
		/*
		 * Recibimos una lista con adyacentes y tenemos que quitarle aquellos que ya se encuentren 
		 * en la lista abierta para no agregarlos nuevamente.
		 */
		
		PriorityQueue<Celda> res=new PriorityQueue<Celda>();
		
		while (!l.isEmpty()) {
			if (!this.abierta.contains(l.element())) {
				res.add(l.element());
			}
			l.remove();
		}
		while (!res.isEmpty()) {
			this.abierta.add(res.poll());
		}
		//System.out.println("adyacentes: " + this.imprimirColaPrioridad(res));
		
		return res;
	}
	
	/*
	public Celda buscarCeldaMenor() {
	
		PriorityQueue<Celda> aux = new PriorityQueue<Celda>();
		aux.addAll(this.abierta);
		Celda menor = aux.poll();
		
		while (!aux.isEmpty()) {

			if (menor.compareTo(aux.peek())<0) {
				menor = aux.peek();
			}
			aux.remove();
			System.out.println("buscando menor");
		}
		System.out.println("menor encontrado"+menor.toString());
		
		return menor;
		
	}
	*/
	
	public Stack<Celda> armarCamino() {
		
		Celda aux = this.cerrada.getLast();
		Stack<Celda> s = new Stack<Celda>();
		s.add(aux);
		
		while (aux!=null) {
			s.add(aux.padre);
			aux = aux.padre;
		}
		
		return s;
		
	}
	
	
	
	public String toString(LinkedList<Celda> c) {
		
		String res = "";
		
		while (!c.isEmpty()) {
			res += c.element() + " ";
			c.remove();
		}
		
		return res;
		
	}
	
}
