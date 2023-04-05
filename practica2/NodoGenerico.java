/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author Milena
 * @param <T>
 */
public class NodoGenerico <T> {
    
private T dato;
	private NodoGenerico<T> siguiente;
	
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public NodoGenerico<T> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoGenerico<T> siguiente) {
		this.siguiente = siguiente;
	}
}
