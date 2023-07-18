/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;
import practica2.ListaEnlazadaGenerica;
import practica2.ListaGenerica;
import practica3.ArbolBinario;
/**
 *
 * @author Milena
 */
public class Ej10 {
    public ListaGenerica<Integer> Resolver(ArbolBinario<Integer> a){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        if (!a.esVacio())
            Recorrido(a, lista);
        return lista;
    }
    
    private int Recorrido (ArbolBinario<Integer>a, ListaGenerica<Integer> lista){
        int izq = 0;
        int der = 0;
        if (!a.esHoja()){
            if (a.tieneHijoIzquierdo())
                izq = Recorrido(a.getHijoIzquierdo(), lista);
            if (a.tieneHijoDerecho())
                der = Recorrido(a.getHijoDerecho(), lista);
            if (izq == der)
                lista.agregarFinal(a.getDato());
        }
        return izq + der + 1;
    }
}
