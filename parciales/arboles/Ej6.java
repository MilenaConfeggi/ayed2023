/*
 Implemente en la clase Parcial un método que reciba un árbol general de enteros y retorne una lista
con los valores mayores a un valor recibido por parámetro. Para cada valor, retornar el nivel en el que se
encuentra. Considerar que el árbol podría estar vacio, que ningún elemento del árbol o todos los
elementos del árbol podrían cumplir la condición. Realice un recorrido inorden.
El método debe tener la siguiente firma:
resolver(int valor, ArbolGeneral<Integer> arbol)
 */
package Parciales;

import practica2.ListaGenerica;
import practica2.ListaEnlazadaGenerica;
import practica4.ArbolGeneral;
/**
 *
 * @author Milena
 */
public class Ejercicio6 {
    public ListaGenerica<String> resolver (int valor, ArbolGeneral<Integer> a){
        ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
        int nivel = 0;
        if (!a.esVacio())
            inorden (valor, a, lista, nivel);
        return lista;
    }
    
    private void inorden (int valor, ArbolGeneral<Integer> a, ListaGenerica<String> lista, int nivel){
        if(!a.esHoja()){
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            inorden (valor, hijos.proximo(), lista, nivel+ 1);
            
            if (a.getDato()>= valor)
                agregaralista(a.getDato(), nivel, lista);
            
            while (!hijos.fin())
                inorden (valor, hijos.proximo(), lista, nivel+ 1);
        }
        else
           if (a.getDato()>= valor)
                agregaralista(a.getDato() , nivel, lista); 
    }
    
    private void agregaralista (Integer n, int nivel, ListaGenerica<String> lista){
        String string = (n + " nivel " + nivel);
        lista.agregarFinal(string);
        
    }
}
