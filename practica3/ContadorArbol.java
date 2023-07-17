/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;
import practica2.ListaGenerica;
import practica2.ListaEnlazadaGenerica;
/**
 *
 * @author Milena
 */
public class ContadorArbol {
    private ArbolBinario<Integer> ab;
	
	public ContadorArbol(ArbolBinario<Integer>abb) {
		this.ab=abb;
	}
	
	public ListaGenerica<Integer> numerosParesInOrden(){
		ListaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
		this.numerosParesInOrden(this.ab,lista);
		return lista;
	}

	private void numerosParesInOrden(ArbolBinario<Integer> abb, ListaGenerica<Integer> lista) {
		
		if (abb.tieneHijoIzquierdo()) {
			this.numerosParesInOrden(abb.getHijoIzquierdo(), lista);
		}
		if ((abb.getDato() % 2) == 0) {
			lista.agregarFinal(abb.getDato());
		}
		if (abb.tieneHijoDerecho()) {
			this.numerosParesInOrden(abb.getHijoDerecho(),lista);
		}
		
	}
	
	public ListaGenerica<Integer> numerosParesPostOrden(){
		ListaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
		this.numerosParesPostOrden(this.ab,lista);
		return lista;
	}

	private void numerosParesPostOrden(ArbolBinario<Integer> abb, ListaGenerica<Integer> lista) {
		if (abb.tieneHijoDerecho()) {
			this.numerosParesPostOrden(abb.getHijoDerecho(),lista);
		}
		if (abb.tieneHijoIzquierdo()) {
			this.numerosParesPostOrden(abb.getHijoIzquierdo(), lista);
		}
		if ((abb.getDato() % 2) == 0) {
			lista.agregarFinal(abb.getDato());
		}
	}
}
