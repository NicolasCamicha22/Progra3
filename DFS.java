package p3_tp;

import java.util.*;

public class DFS {
	public static void main(String[] args) {
		GrafoDinamic grafoDFS = new GrafoDinamic();
		grafoDFS.inicializarGrafo(10);
		
		// Agregamos los vértices del Grafo
		grafoDFS.agregarVertice(1);
		grafoDFS.agregarVertice(2);
		grafoDFS.agregarVertice(3);
		grafoDFS.agregarVertice(4);
		grafoDFS.agregarVertice(5);
		grafoDFS.agregarVertice(6);
		// Agregamos las arístas del Grafo
		grafoDFS.agregarArista(1, 2, 1);
		grafoDFS.agregarArista(1, 3, 1);
		grafoDFS.agregarArista(1, 4, 1);
		grafoDFS.agregarArista(2, 4, 1);
		grafoDFS.agregarArista(3, 2, 1);
		grafoDFS.agregarArista(4, 3, 1);
		grafoDFS.agregarArista(5, 2, 1);
		grafoDFS.agregarArista(5, 4, 1);
		grafoDFS.agregarArista(5, 6, 1);

	    System.out.println("-----------------------");
	    System.out.println("Grafo con sus adyacencias");
		grafoDFS.mostrarMatriz();
	    System.out.println("-----------------------");
		Scanner scan = new Scanner(System.in);
	    System.out.print("Ingrese el vertice Origen: ");
	    int num = scan.nextInt();
	    scan.close();
		
	    ArrayList<Integer> caminoDFS = dfsGrafo(grafoDFS, grafoDFS.encontrarNodo(num));
	    System.out.print("El camino desde el Origen "+ num +" es: ");	    
	    mostarRecorrido(caminoDFS);
	}
	
	public static ArrayList<Integer> dfsGrafo(GrafoDinamic grafo, NodoGrafo origen) {
		ArrayList<Integer> nodos = new ArrayList<Integer>();
		visitarNodo(origen, nodos);
		return nodos;
	}

	public static void visitarNodo(NodoGrafo nodo, ArrayList<Integer> lista) {
		nodo.Visitado = true;
		NodoArista aux = nodo.lista;
		while (aux != null) {
			if (!aux.apunta.Visitado) {
				visitarNodo(aux.apunta, lista);
			} else {
				aux = aux.sig;
			}
		}
		lista.add(nodo.valor);
	}
	
	public static void mostarRecorrido(ArrayList<Integer> recorrido) {
		for(int i=recorrido.size()-1;i>=0;i--) {
			  System.out.print(recorrido.get(i));
			  if (i!=0) {
				  System.out.print( " -> ");
			  }
		  }
	}
}

