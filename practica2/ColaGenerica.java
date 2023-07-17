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
public class ColaGenerica<T> {
    private ListaGenerica<T> datos= new ListaEnlazadaGenerica<T>();  

    public void encolar(T elem){
        this.datos.agregarFinal(elem);        
    }

    public T desencolar(){
        T elem= datos.elemento(1);
        this.datos.eliminarEn(1);
        return elem;
    }

    public T tope(){
        T elem= this.datos.elemento(1);
        return elem;
    }
    public boolean esVacia(){
        return this.datos.esVacia();
    }

}
