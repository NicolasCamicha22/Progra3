package p3_tp;
import java.util.*;

public class floyd{
	
    public static void main(String[] args) {
        int[][] pre;
        int[][] resultado;
        int[] vector = {0,1,2,3,4,5};

        /*Crear la matriz de adyacencia*/
        int[][] matriz = new int[vector.length][vector.length];
        final short N = Short.MAX_VALUE;
        matriz[0] = new int[]{ 0, 24,  N,  N,  N, 28};
        matriz[1] = new int[]{24,  0, 11,  N,  N,  N};
        matriz[2] = new int[]{ N, 11,  0, 13,  N,  N};
        matriz[3] = new int[]{ N,  N, 13,  0, 20, 12};
        matriz[4] = new int[]{ N,  N,  N, 20,  0, 15};
        matriz[5] = new int[]{28,  N,  N, 12, 15,  0};
        
  
        pre = new int[vector.length][vector.length];
        //Inicializamos la matriz
        for (int i = 0; i < vector.length; i++) {
            Arrays.fill(pre[i], i);
        }
        
        floyd(matriz, pre);
		Scanner scan = new Scanner(System.in);
	    System.out.println("1 - Mostar un vertice determinado ");
	    System.out.println("2 - Mostrar Todos los vertices ");
	    System.out.println("Ingreso Opcion: ");
	    int opcion = scan.nextInt();
	    
	    
	    if (opcion==1) {
	        System.out.println("Ingreso vertice: ");
		    int vertice = scan.nextInt();
	        mostarUnVertice(matriz, pre, vector,vertice);
	    }
	    if (opcion==2) {
	        mostarTodosLosVertice(matriz, pre, vector);	    	
	    }
	    scan.close();
    }
    
    //Algoritmo de floyd
    public static void floyd(int[][] dis, int[][] pre){
        int largo;
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    largo = dis[i][k] + dis[k][j];
                    if (largo < dis[i][j]) {
                    	dis[i][j] = largo;
                    	pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }

    public static void mostarTodosLosVertice(int[][] dis, int[][] pre, int[] vector){
    for (int k = 0; k < dis.length; k++) {
        System.out.println("Esta viendo el vertice " + vector[k]);
        for (int i = 0; i < dis.length; i++) {
            		System.out.println(" <" + vector[k] + "," + vector[i] + "> => " + dis[k][i]);
        		}
        System.out.println();
    	}
    }

    public static void mostarUnVertice(int[][] dis, int[][] pre, int[] vector, int k){
    	System.out.println();
        System.out.println("Esta viendo el vertice " + vector[k]);
        for (int i = 0; i < dis.length; i++) {
            		System.out.println( vector[k] + "->" + vector[i] + " => " + dis[k][i]);
        		}
        System.out.println();
    }
}

