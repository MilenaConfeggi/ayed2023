/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author Milena
 */
public abstract class ListaDeEnteros {
    
    public abstract void comenzar();
    public abstract Integer proximo();
    public abstract boolean fin();
	
    public abstract Integer elemento(int pos);
	
    public abstract boolean agregarEn(Integer elem, int pos);
    public abstract boolean agregarInicio(Integer elem);
    public abstract boolean agregarFinal(Integer elem);
	
    public abstract boolean eliminar(Integer elem);
    public abstract boolean eliminarEn(int pos);
	
    public abstract boolean incluye(Integer elem);
    public abstract boolean esVacia();
    public abstract int tamanio();
}
