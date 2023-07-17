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
public class PilaGenerica<T> {
    private ListaGenerica<T> datos;

    public void apilar(T elem){
        this.datos.agregarFinal(elem);
    }

    public T desapilar(){
        T elem= datos.elemento(this.datos.tamanio());
        this.datos.eliminarEn(this.datos.tamanio());
        return elem;
    }

    public T tope(){
        return this.datos.elemento(this.datos.tamanio());
    }

    public boolean esVacia(){
        return this.datos.esVacia();
    }
}
