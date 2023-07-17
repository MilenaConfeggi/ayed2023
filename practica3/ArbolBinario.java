/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import practica2.ColaGenerica;



public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 
        
        public int contarHojas() {
          int cant=0;
	  if (!this.esHoja()){
             if (this.tieneHijoIzquierdo()){
		cant+= this.getHijoIzquierdo().contarHojas();
			}
	     if (this.tieneHijoDerecho()){
		cant+=this.getHijoDerecho().contarHojas();			
			}	
		}
	     else
	         return 1;
			
	   return cant;

	}
        
        public ArbolBinario<T> espejo() {
		ArbolBinario<T> nuevo= new ArbolBinario<T>(this.dato);
		if (this.tieneHijoIzquierdo()){
			nuevo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		}
		if (this.tieneHijoDerecho()){
			nuevo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		}
		return nuevo;
	}
         
        public void entreNiveles (int n, int m){
                ArbolBinario<T> arbol= null;
		ColaGenerica<ArbolBinario<T>> cola= new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int nivel=0;
		while (!cola.esVacia() && nivel <= m){
			arbol= cola.desencolar();
			if (arbol!= null){
				if (nivel >= n)
					System.out.println(arbol.getDato());
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoDerecho());
			}
			else if (!cola.esVacia()){
				nivel++;
				cola.encolar(null); 

		}
		}
             }
        
        
                
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	
	

}
