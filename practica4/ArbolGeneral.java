/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import practica2.ColaGenerica;
import practica2.ListaEnlazadaGenerica;
import practica2.ListaGenerica;


public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
                int alt = -1;
		if (!this.esVacio()){
                   if (!this.esHoja()){
                        ListaGenerica<ArbolGeneral<T>> h= this.getHijos();
			h.comenzar();
			while (!h.fin()){
                            alt = Math.max(alt, h.proximo().altura());
                        }
                        
                   }alt = alt + 1;
                }
		return alt; //si es vacio devuelve -1 y si tiene un solo nodo devuelve 0
	}

	public Integer nivel(T dato) {
            boolean encontro = false;
	    int niv = 0;
            ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
            cola.encolar(this);
            cola.encolar(null);
            ArbolGeneral<T> arb;
            while ((!this.esVacio())&& (encontro!= true)){
                arb = cola.desencolar();
                if(arb!=null){
                    if (arb.getDato() == dato)
                        encontro = true;
                    else{
                        if (arb.tieneHijos()){
                           ListaGenerica<ArbolGeneral<T>> h= arb.getHijos();
			   h.comenzar();
			   while (!h.fin()){
			        cola.encolar(h.proximo());
					} 
                        }
                    }
                } else{
                    if (!cola.esVacia()){
                       cola.encolar(null);
		       niv++;
                         }
                     }
            }
            if (encontro == false) //si el arbol es vacio encontro nunca puede ser true entonces devolvemos -1
                    niv = -1;
            
	    return niv;
	}

	public Integer ancho() {
	    Integer cant;
            Integer cantmax = -1;
            ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
            cola.encolar(this);
            cola.encolar(null);
            ArbolGeneral<T> arb;
            while ((!this.esVacio())){
                arb = cola.desencolar();
                if(arb!=null){
                        cant = 0;
                        if (arb.tieneHijos()){
                           ListaGenerica<ArbolGeneral<T>> h= arb.getHijos();
			   h.comenzar();
			   while (!h.fin()){
                                cant++;
			        cola.encolar(h.proximo());
					} 
                        }
                        if (cant > cantmax)
                            cantmax = cant;
                } else{
                    if (!cola.esVacia()){
                       cola.encolar(null);
                         }
                     }
            }     
	return cantmax;
	}
        
    public Boolean esAncestro(T a, T b){
       boolean es = false;
       ArbolGeneral<T> nodoB = null;
       ArbolGeneral<T> nodoA= buscar(this, a); //recorro el arbol hasta encontrar el nodo en donde esta a
       if (nodoA != null)
          nodoB= buscar (nodoA, b); //desde ese nodo buscar b
       if (nodoB != null)
           es = true;
       return es;
    }   

    private ArbolGeneral<T> buscar(ArbolGeneral<T> arb, T a){
        boolean encontro = false;
        ArbolGeneral<T> elem = null;
        if (!arb.esVacio()){
            ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
            cola.encolar(arb);
            cola.encolar(null);
            while (!cola.esVacia()&& (encontro != true)){
               elem = cola.desencolar();
               if (elem!=null){
                   if (elem.getDato()== a)
                       encontro = true;
                   else {if (elem.tieneHijos()){
                       ListaGenerica<ArbolGeneral<T>> hijos = elem.getHijos();
                       hijos.comenzar();
                       while(!hijos.fin())
                           cola.encolar(hijos.proximo());
                   }    
                   }             
               } else{
                   if(!cola.esVacia()){
                       cola.encolar(null);
                   }
               }
            }
        }
        
        return elem;
    }
    
    
}
