/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parciales;
import practica2.ListaEnlazadaGenerica;
import practica2.ListaGenerica;
import practica3.ArbolBinario;
import Parciales.Objeto;
/**
 *
 * @author Milena
 */
public class ParcialProgra3tema1 {
    ArbolBinario<Integer> a;

    public ParcialProgra3tema1(ArbolBinario<Integer> a) {
        this.a = a;
    }
    
    public Objeto procesar (){
        ListaGenerica<Integer> LI = new ListaEnlazadaGenerica<Integer>();
        int impares = 0;
        if (!this.a.esVacio())
            impares = Resolver(this.a, LI);
        Objeto ob = new Objeto(LI, impares);
        return ob;
    }
    
    private int Resolver (ArbolBinario<Integer> a, ListaGenerica<Integer> LI){
        int imp = 0;
        if (!a.esHoja()){
            int cant = 0;
            if (a.tieneHijoIzquierdo()){
                cant++;
                imp+= Resolver(a.getHijoIzquierdo(), LI);
            }
            if (a.tieneHijoDerecho()){
                cant++;
                imp+= Resolver(a.getHijoDerecho(), LI);
            }
            if ((cant == 1)&&(a.getDato()%2 == 0))
                LI.agregarFinal(a.getDato());
           
        }
        if (a.getDato()%2 == 1)
            return imp + 1;
        else
            return imp;
    }
}
