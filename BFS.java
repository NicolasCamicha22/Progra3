package p3_tp;

import java.util.*;

public class BFS {
	public static void main(String[] args) {
		GrafoDinamic grafoBFS = new GrafoDinamic();
		grafoBFS.inicializarGrafo(10);
		
		// Agregamos los vértices del Grafo
		grafoBFS.agregarVertice(1);
		grafoBFS.agregarVertice(2);
		grafoBFS.agregarVertice(3);
		grafoBFS.agregarVertice(4);
		grafoBFS.agregarVertice(5);
		grafoBFS.agregarVertice(6);
		// Agregamos las arístas del Grafo
		grafoBFS.agregarArista(4, 1, 1);
		grafoBFS.agregarArista(1, 4, 1);
		grafoBFS.agregarArista(2, 3, 1);
		grafoBFS.agregarArista(3, 2, 1);
		grafoBFS.agregarArista(6, 5, 1);
		grafoBFS.agregarArista(5, 6, 1);
		grafoBFS.agregarArista(1, 2, 1);
		grafoBFS.agregarArista(2, 1, 1);
		grafoBFS.agregarArista(5, 4, 1);
		grafoBFS.agregarArista(4, 5, 1);
		
	    System.out.println("-----------------------");
	    System.out.println("Grafo con sus adyacencias");
		grafoBFS.mostrarMatriz();
	    System.out.println("-----------------------");
		Scanner scan = new Scanner(System.in);
	    System.out.print("Ingrese el vertice Origen: ");
	    int num = scan.nextInt();
	    scan.close();

	    System.out.println("El origen por donde se empieza a optimizar el camino es: "+ num);
	    ArrayList<Integer> camino = bfsGrafo(grafoBFS, grafoBFS.encontrarNodo(num));
	    mostrarCamino(camino);
	}

	public static ArrayList<Integer> bfsGrafo(GrafoDinamic grafo,  NodoGrafo origen) {
		ArrayList<Integer> nodos = new ArrayList<Integer>();
		visitarNodobfs(origen, nodos);
		return nodos;
	} 

	public static void visitarNodobfs(NodoGrafo nodo, ArrayList<Integer> lista) {
		NodoArista auxiliar = nodo.lista;
		if(!nodo.Visitado) {
				nodo.Visitado = true;
				lista.add(nodo.valor);
		}
		while(auxiliar != null) {
			if(!auxiliar.apunta.Visitado) {
				auxiliar.apunta.Visitado = true;
				lista.add(auxiliar.apunta.valor);
				}
			auxiliar = auxiliar.sig;
		}
		auxiliar = nodo.lista;
		while (auxiliar != null) {
			if(!auxiliar.Visitado) {
				auxiliar.Visitado = true;
				visitarNodobfs(auxiliar.apunta, lista);
				}
			auxiliar = auxiliar.sig;
		}				
	}
	
	public static void mostrarCamino(ArrayList<Integer> camino){
	    for(int i=0;i<camino.size();i++) {
		  System.out.print(camino.get(i));
		  if (i!=camino.size()-1) {
			  System.out.print(" , "); }
	  }
	}
}