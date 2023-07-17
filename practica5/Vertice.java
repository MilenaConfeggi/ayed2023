/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

/**
 *
 * @author Milena
 */

/**
 * Representa una Vertice de un grafo.
 * 
 * @author juan
 * @param <T>
 *
 */
public interface Vertice<T> {
	
	public T dato();
	public void setDato(T dato);
	public int getPosicion();

}
