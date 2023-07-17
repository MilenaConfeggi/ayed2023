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
public class Caminos {
    private Grafo<String> g;

    public Caminos(Grafo<String> g) {
        this.g = g;
    }
    
    
    public ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2){
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        boolean[] marca = new boolean[this.g.listaDeVertices().tamanio() + 1];
        if (!this.g.esVacio()){
            Vertice<String> v = BuscarVertice(ciudad1);
            Dfs(v, camino, marca, ciudad2);            
        }
        return camino;
    }
    
    private Vertice<String> BuscarVertice (String a){
        ListaGenerica<Vertice<String>> listaVertices = g.listaDeVertices();
        boolean enc = false;
        Vertice<String> v = null;
        listaVertices.comenzar();
        while ((!listaVertices.fin()) && (enc == false)){
            v = listaVertices.proximo();
            if (v.dato().equals(a)){
                enc = true;
            }
        }
        return v;
    }
    
    private boolean Dfs (Vertice<String> v, ListaGenerica<String> camino, boolean[] marca, String ciudad2){
       boolean enc = false;
       int p = v.getPosicion();
       marca[p] = true;
       camino.agregarFinal(v.dato());
       if (v.dato().equals(ciudad2)){
           enc = true;          
       }else{
           ListaGenerica<Arista<String>> adys = g.listaDeAdyacentes(v);
           adys.comenzar();
           while (!enc && !adys.fin()){
               Arista<String> ar = adys.proximo();
               int j = ar.verticeDestino().getPosicion();
               if (!marca[j]){
                   enc = Dfs (ar.verticeDestino(), camino, marca, ciudad2);
               }
           }               
       }
       if(!enc)
           camino.eliminarEn(camino.tamanio());
       return enc;
               
    }
    
    public ListaGenerica<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, ListaGenerica<String> ciudades){
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        boolean[] marca = new boolean[this.g.listaDeVertices().tamanio() + 1];
        if (!this.g.esVacio()){
            Vertice<String> v = BuscarVertice(ciudad1);
            marcarciudades (ciudades, marca);
            Dfs(v, camino, marca, ciudad2);            
        }
        return camino;
    }
    
    private void marcarciudades(ListaGenerica<String> ciudades, boolean[] marca){
        ciudades.comenzar();
        while (!ciudades.fin()){
            String s = ciudades.proximo();
            Vertice<String> v = BuscarVertice(s);
            int i = v.getPosicion();
            marca[i] = true;
        }
    }
    
    public ListaGenerica<String> caminoMasCorto (String ciudad1, String ciudad2){
        ListaGenerica<String> caminoMin = new ListaEnlazadaGenerica<String>();
        boolean[] marca = new boolean[this.g.listaDeVertices().tamanio() + 1];
        if (!g.esVacio()){
            int pesoMin = 9999;
            int pesoAct = 0;
            ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
            Vertice<String> v = BuscarVertice(ciudad1);
            buscarMinimo(v, caminoActual, caminoMin, marca, ciudad2, pesoAct, pesoMin);            
        }
        return caminoMin;
    }
    private int buscarMinimo (Vertice<String> v, ListaGenerica<String> caminoActual, ListaGenerica<String> caminoMin, boolean[] marca, String ciudad2, int pesoAct, int pesoMin){
       int p = v.getPosicion();
       marca[p] = true;
       caminoActual.agregarFinal(v.dato());
       if (v.dato().equals(ciudad2)){
               if (pesoAct < pesoMin){
                   pesoMin = pesoAct;
                   while (!caminoMin.fin()){
                       caminoMin.eliminarEn(caminoMin.tamanio());
                   }
                   caminoActual.comenzar();
                   while (!caminoActual.fin()){
                       caminoMin.agregarFinal(caminoActual.proximo());
                   }
               }
       }else{
           ListaGenerica<Arista<String>> adys = this.g.listaDeAdyacentes(v);
           adys.comenzar();
           while (!adys.fin()){
               Arista<String> ar = adys.proximo();
               pesoAct = pesoAct + ar.peso();
               int j = ar.verticeDestino().getPosicion();
               if (!marca[j]){
                   pesoMin = buscarMinimo (ar.verticeDestino(), caminoActual, caminoMin, marca, ciudad2, pesoAct, pesoMin);
               }
           }               
       }

        caminoActual.eliminarEn(caminoActual.tamanio());
        marca[p] = false;
        return pesoMin;
    }
    
    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        boolean[] marca = new boolean[this.g.listaDeVertices().tamanio() + 1];
        if (!this.g.esVacio()){
            Vertice<String> v = BuscarVertice(ciudad1);
            buscarCamino(v, camino, marca, ciudad2, tanqueAuto);            
        }
        return camino;
    }
    
    private boolean buscarCamino (Vertice<String> v, ListaGenerica<String> camino, boolean[] marca, String ciudad2, int tanqueAuto){
       boolean enc = false;
       int p = v.getPosicion();
       marca[p] = true;
       camino.agregarFinal(v.dato());
       if (v.dato().equals(ciudad2)){
           enc = true;          
       }else{
           ListaGenerica<Arista<String>> adys = this.g.listaDeAdyacentes(v);
           adys.comenzar();
           while (!enc && !adys.fin()){
               Arista<String> ar = adys.proximo();
               int j = ar.verticeDestino().getPosicion();
               if (!marca[j] && ar.peso() < tanqueAuto){
                   enc = buscarCamino (ar.verticeDestino(), camino, marca, ciudad2, tanqueAuto - ar.peso());
               }
           }               
       }
       if(!enc){
           camino.eliminarEn(camino.tamanio());
           marca[p] = false;
       }
       return enc;
    }
    
    public ListaGenerica<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
        ListaGenerica<String> caminoMin = new ListaEnlazadaGenerica<String>();
        boolean[] marca = new boolean[this.g.listaDeVertices().tamanio() + 1];
        if (!g.esVacio()){
            int cargasMin = 9999;
            int cargasAct = 0;
            ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
            Vertice<String> v = BuscarVertice(ciudad1);
            buscarMinCargas(v, caminoActual, caminoMin, marca, ciudad2, cargasAct, cargasMin, tanqueAuto, tanqueAuto);            
        }
        return caminoMin;
    }
    
    private int buscarMinCargas (Vertice<String> v, ListaGenerica<String> caminoActual, ListaGenerica<String> caminoMin, boolean[] marca, String ciudad2, int cargasAct, int cargasMin, int tanqueAuto, int tanquelleno){
       int p = v.getPosicion();
       marca[p] = true;
       caminoActual.agregarFinal(v.dato());
       if (v.dato().equals(ciudad2)){
               if (cargasAct < cargasMin){
                   cargasMin = cargasAct;
                   while (!caminoMin.fin()){
                       caminoMin.eliminarEn(caminoMin.tamanio());
                   }
                   caminoActual.comenzar();
                   while (!caminoActual.fin()){
                       caminoMin.agregarFinal(caminoActual.proximo());
                   }
               }
       }else{
           ListaGenerica<Arista<String>> adys = this.g.listaDeAdyacentes(v);
           adys.comenzar();
           while (!adys.fin()){
               Arista<String> ar = adys.proximo();
               int j = ar.verticeDestino().getPosicion();
               if (!marca[j]){
                   if (tanqueAuto > ar.peso()){
                      tanqueAuto = tanquelleno;
                      cargasAct++;
                   }
                   tanqueAuto = tanqueAuto - ar.peso();
                   cargasMin = buscarMinCargas (ar.verticeDestino(), caminoActual, caminoMin, marca, ciudad2, cargasAct, cargasMin, tanqueAuto, tanquelleno);                   
               }
           }               
       }

        caminoActual.eliminarEn(caminoActual.tamanio());
        marca[p] = false;
        return cargasMin;
    }

    public Grafo<String> getG() {
        return g;
    }

    public void setG(GrafoImplListAdy<String> g) {
        this.g = g;
    }

}
