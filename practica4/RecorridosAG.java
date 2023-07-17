/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;
import practica2.ListaGenerica;
import practica2.ListaEnlazadaGenerica;
import practica2.ColaGenerica;

/**
 *
 * @author Milena
 */
public class RecorridosAG {

    public RecorridosAG() {
    }
    
    
    public ListaGenerica<Integer> numerosImparesMayoresQue (ArbolGeneral<Integer> a, Integer n){
          ListaEnlazadaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
          this.preorden(a, lista, n);
          this.postorden(a, lista, n);
          this.niveles(a, lista, n);
          this.inorden(a, lista, n);
          return lista;        
    }
    
    private ListaGenerica<Integer> preorden (ArbolGeneral<Integer> a, ListaGenerica<Integer> lista, Integer n){
      if (!a.esVacio()){
        if ((a.getDato()%2 == 0) && (a.getDato() > n)){
            lista.agregarFinal(a.getDato());
             }
        ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
        lHijos.comenzar();
        while (!lHijos.fin()) {
             preorden (lHijos.proximo(), lista, n);
              }
      }
        return lista;
      
           }
    
    private ListaGenerica<Integer> postorden (ArbolGeneral<Integer> a, ListaGenerica<Integer> lista, Integer n){
        
        if (!a.esVacio()){
            if (a.tieneHijos()){
                ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
                lHijos.comenzar();
                while (!lHijos.fin()) {
                      postorden (lHijos.proximo(), lista, n);
                       }
                if ((a.getDato()%2 == 0) && (a.getDato() > n)){
                      lista.agregarFinal(a.getDato());    
                    }
            }else{
                if ((a.getDato()%2 == 0) && (a.getDato() > n)){  //como hago para no repetir codigo?
                      lista.agregarFinal(a.getDato());    
                    }
        
        }
        }
      return lista;  
    }
    
    private ListaGenerica<Integer> niveles (ArbolGeneral<Integer> a, ListaGenerica<Integer> lista, Integer n){
        if (!a.esVacio()){
            ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
            cola.encolar(a);
            cola.encolar(null);
            while (!cola.esVacia()){
               ArbolGeneral<Integer> elem = cola.desencolar();
               if (elem!=null){
                   if ((a.getDato()%2 == 0) && (a.getDato() > n))
                       lista.agregarFinal(elem.getDato());
                   if (elem.tieneHijos()){
                       ListaGenerica<ArbolGeneral<Integer>> hijos = elem.getHijos();
                       hijos.comenzar();
                       while(!hijos.fin())
                           cola.encolar(hijos.proximo());
                   }                 
               } else{
                   if(!cola.esVacia()){
                       cola.encolar(null);
                   }
               }
            }
        }
        return lista;
        }
    
    
    
    private ListaGenerica<Integer> inorden (ArbolGeneral<Integer> a, ListaGenerica<Integer> lista, Integer n){
        if (!a.esVacio()){
           if (a.tieneHijos()){
               ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
               lHijos.comenzar();
              
               inorden (lHijos.proximo(), lista, n);
               if ((a.getDato()%2 == 0) && (a.getDato() > n)){
                      lista.agregarFinal(a.getDato());   
               }
               while (!lHijos.fin()) {
                      inorden (lHijos.proximo(), lista, n);
                       }
           } 
           else{
              if ((a.getDato()%2 == 0) && (a.getDato() > n)){
                      lista.agregarFinal(a.getDato());   
               } 
           }
        }
               
     return lista;   
    }
    
    }
