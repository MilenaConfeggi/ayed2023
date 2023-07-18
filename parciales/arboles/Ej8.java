/*
 Implemente en la clase Parcial que tiene como variable de instancia un ArbolGeneral<Integer> ,el
método:
ListaEnlazadaGenerica<Integer> resolver()
Que retorna una lista con los elementos de la frontera del árbol con valor par.
Se define como frontera de un árbol general, a las hojas del árbol recorridas de izquierda a
derecha.

 */
package Parciales;
import practica2.ListaGenerica;
import practica2.ListaEnlazadaGenerica;
import practica4.ArbolGeneral;
/**
 *
 * @author Milena
 */
public class Ejercio8 {
    private ArbolGeneral<Integer> a;

    public Ejercio8(ArbolGeneral<Integer> a) {
        this.a = a;
    }
    
    public ListaEnlazadaGenerica<Integer> resolver(){
        ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        if (!this.a.esVacio())
            frontera(lista, this.a);
        return lista;
    }
    
    private void frontera(ListaEnlazadaGenerica<Integer> lista, ArbolGeneral<Integer> a){
        if (!a.esHoja()){
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            while (!hijos.fin())
              frontera(lista, hijos.proximo());
        }
        else
            lista.agregarFinal(a.getDato());
    }
}
