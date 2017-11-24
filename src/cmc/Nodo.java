package cmc;

import java.util.PriorityQueue;

import graficos.Punto;

public class Nodo {
	
	private Nodo siguiente;
	private Nodo anterior;
	private Punto actual;
	private PriorityQueue<Punto> vecinos;
	
	public Nodo(Punto actual) {
		this.actual = actual;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public Punto getActual() {
		return actual;
	}

	public void setActual(Punto actual) {
		this.actual = actual;
	}

	public PriorityQueue<Punto> getVecinos() {
		return vecinos;
	}

	public void setVecinos(PriorityQueue<Punto> vecinos) {
		this.vecinos = vecinos;
	}
}
