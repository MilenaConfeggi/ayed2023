/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import practica2.ColaGenerica;
import practica2.ListaGenerica;

/**
 *
 * @author Milena
 */
public class Empresa {

    
    
    
    public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa>arbol){
        int cant;
        int maximo = -1;
        int suma;
        if (!arbol.esVacio()){
            ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
            cola.encolar(arbol);
            cola.encolar(null);
            while (!cola.esVacia()){
               ArbolGeneral<AreaEmpresa> elem = cola.desencolar();
               cant = 0;
               suma = 0;
               if (elem!=null){
                   cant++;
                   suma = suma + elem.getDato().getTardanza();
                   if (elem.tieneHijos()){
                       ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = elem.getHijos();
                       hijos.comenzar();
                       while(!hijos.fin())
                           cola.encolar(hijos.proximo());
                   }                 
               } else{
                   if(!cola.esVacia()){
                       cola.encolar(null);
                       suma = suma/cant;
                       if (suma > maximo)
                           maximo = suma;
                   }
               }
            }
        }
        return maximo;
    }
}
