/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;
import practica2.ListaEnlazadaGenerica;
import practica2.ListaGenerica;
/**
 *
 * @author Milena
 */
public class TestCaminos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vertice<String> a = new VerticeImplListAdy<String>("a");
        Vertice<String> b = new VerticeImplListAdy<String>("b");
        Vertice<String> c = new VerticeImplListAdy<String>("c");
        Vertice<String> d = new VerticeImplListAdy<String>("d");
        Vertice<String> e = new VerticeImplListAdy<String>("e");
        Vertice<String> f = new VerticeImplListAdy<String>("f");
        Vertice<String> g = new VerticeImplListAdy<String>("g");
        
        Grafo<String> grafo = new GrafoImplListAdy<String>();
        
        grafo.agregarVertice(a);
        grafo.agregarVertice(b);
        grafo.agregarVertice(c);
        grafo.agregarVertice(d);
        grafo.agregarVertice(e);
        grafo.agregarVertice(f);
        grafo.agregarVertice(g);
        
        grafo.conectar(a, b, 5);
        grafo.conectar(a, c, 2);
        grafo.conectar(a, d, 3);
        grafo.conectar(d, c, 4);
        grafo.conectar(d, f, 3);
        grafo.conectar(c, b, 1);
        grafo.conectar(c, f, 2);
        grafo.conectar(b, e, 6);
        grafo.conectar(f, g, 1);
        grafo.conectar(e, g, 7);
        
        Caminos cam = new Caminos(grafo);
        ListaGenerica<String> camMinimo = cam.caminoMasCorto(a.dato(), g.dato());
        while (!camMinimo.fin())
            System.out.println(camMinimo.proximo());
        
    }
    
}
