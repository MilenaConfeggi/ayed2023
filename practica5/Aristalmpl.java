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
public class AristaImpl<T> implements Arista<T> {
	private Vertice<T> destino;
	private int peso;
	
	public AristaImpl(Vertice<T> dest, int p){
		destino = dest;
		peso = p;
	}
	
	@Override
	public Vertice<T> verticeDestino() {
		return destino;
	}

	@Override
	public int peso() {
		return peso;
	}

}
