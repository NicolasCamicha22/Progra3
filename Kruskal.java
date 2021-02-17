package TP_Progra3;

import java.util.ArrayList;
import java.util.Arrays;


public class Kruskal {

	public static void main(String[] args) {
		GrafoDinamic grafo = new GrafoDinamic();
		grafo.inicializarGrafo(10);
	    grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);



        grafo.agregarArista(1 , 3 , 1);
        grafo.agregarArista(1 , 4 , 5);
        grafo.agregarArista(1 , 2 , 6);
        grafo.agregarArista(2 , 3 , 1);
        grafo.agregarArista(2 , 5 , 3);
        grafo.agregarArista(5 , 3 , 6);
        grafo.agregarArista(5 , 6 , 6);
        grafo.agregarArista(6 , 3 , 4);
        grafo.agregarArista(4 , 6 , 2);
        grafo.agregarArista(3 , 6 , 1);
		grafo.mostrarMatriz();
		System.out.println("=========");
		
		
		//kruskal(grafo).mostrarMatriz();
		kruskal(grafo).ImprimirKruskal();
		
		
	}
	
	public static void visitarNodo(NodoGrafo nodo, ArrayList<Integer> lista ) {
		nodo.Visitado = true;
		NodoArista aux = nodo.lista; 
		
		while(aux != null) {
			if(!aux.apunta.Visitado) {
				visitarNodo(aux.apunta, lista);
			}
			else {
				aux = aux.sig;
			}
		}
		lista.add(nodo.valor);
	}
	
	public static void visitarNodobfs(NodoGrafo nodo, ArrayList<Integer> lista) {
		NodoArista aux = nodo.lista;
		if(!nodo.Visitado) {
				nodo.Visitado = true;
				//System.out.println(nodo.valor);
				lista.add(nodo.valor);
		}
		while(aux != null) {
			if(!aux.apunta.Visitado) {
				aux.apunta.Visitado = true;
				//System.out.println(aux.apunta.valor);
				lista.add(aux.apunta.valor);
				}
			aux = aux.sig;
		}
		aux = nodo.lista;
		while (aux != null) {
			//System.out.println(aux.apunta.valor);
			if(!aux.Visitado) {
				aux.Visitado = true;
				visitarNodobfs(aux.apunta, lista);
				}
			aux = aux.sig;
				//System.out.println(aux.apunta.valor);
		}
				
	}
	
	public static GrafoDinamic prim(NodoGrafo nodo) {
		ArrayList<NodoArista> aristas = new ArrayList<NodoArista>(); 
		ArrayList<NodoGrafo> nodos = new ArrayList<NodoGrafo>();
			
		NodoGrafo auxNodo = nodo;
		NodoArista aux; 
		auxNodo.Visitado = true;
		GrafoDinamic arbol = new GrafoDinamic();
		int indice = 0;
		arbol.agregarVertice(nodo.valor);	
		nodos.add(nodo);
	while(!nodos.isEmpty()){
			aux = auxNodo.lista;
			while(aux != null) {
				if(!aux.Visitado) {
					aristas.add(aux);
					aux.Visitado = true;
				}
				aux = aux.sig;
			}
			
			indice = menorArista(aristas);
			if(indice != -1) {
				aux = aristas.get(indice);
				arbol.agregarVertice(aux.apunta.valor);
				aux.apunta.Visitado = true;
				arbol.agregarArista(aux.origen, aux.apunta.valor, aux.peso);			
				aristas.remove(indice);
				nodos.add(aux.apunta);
				auxNodo = aux.apunta;
			}else {
				return arbol;
			}
			
		}
		return arbol;
		
	}
	
	public static int menorArista(ArrayList<NodoArista> array ) {
		int menor = 1000;
		int posicion = -1;
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).peso < menor && !array.get(i).apunta.Visitado) {
				menor = array.get(i).peso ; 
				posicion = i;
			}
		}
		return posicion;
		
	}

	public static GrafoDinamic kruskal(GrafoDinamic grafo) {
		NodoGrafo aux = grafo.nodo;
		NodoArista auxArista ;
		ArrayList<NodoArista> aristas = new ArrayList<NodoArista>();
		GrafoDinamic kruskal = new GrafoDinamic();
		while(aux != null) {
			auxArista = aux.lista;
			while(auxArista != null) {
				aristas.add(auxArista);
				auxArista = auxArista.sig;
			}
			aux = aux.sig;
		}
		aristas.sort(null);
		//mostrarAristas(aristas);
		for(int i = 0; i < aristas.size(); i++) {
			//System.out.println(i);
			if(!(aristas.get(i).apunta.Visitado && grafo.encontrarNodo(aristas.get(i).origen).Visitado)){
					kruskal.agregarVertice(aristas.get(i).origen);
					grafo.encontrarNodo(aristas.get(i).origen).Visitado = true;
					//System.out.println(i);
					kruskal.agregarVertice(aristas.get(i).apunta.valor);
					aristas.get(i).apunta.Visitado = true;
					kruskal.agregarArista(aristas.get(i).origen, aristas.get(i).apunta.valor, aristas.get(i).peso);
				}
			}
		
		
		return kruskal;
	}
	
	public static void mostrarAristas(ArrayList<NodoArista> aristas) {
		for(int i = 0; i < aristas.size(); i++) {
			System.out.print( aristas.get(i).peso + "\t");
		}
	}
}	
	
	


