package Test;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import Datos.*;

public class TestQuicksort {

	public static void main(String[] args) {
		
		//Creacion de array aleatorio
		int[] arr1 = CrearArray.generarArrayAleatorio(10000000, 1, 50000);
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		double arranco, fin;
		
		//System.out.println(Arrays.arrayToString(arr)); //Array aleaotorio desordenado
		
		//--------------------------------------------------------------------------------------------
		//-------------------------------- QUICK SORT, SOLUCIÓN CONCURRENTE ---------------------------
		//--------------------------------------------------------------------------------------------
		
		Quicksort_concurrente quickSort = new Quicksort_concurrente(arr1);

	    ForkJoinPool pool = new ForkJoinPool();
	    
	    arranco = System.currentTimeMillis();
	    
	    pool.invoke(quickSort);
	    
	    fin = System.currentTimeMillis() - arranco;
	    
	    
	    System.out.println("\nSolucion concurrente ---> " + fin + " milisegundos");

	    
	    //System.out.println(Arrays.arrayToString(arr1)); //Array ordenado concurrentemente
		
		//--------------------------------------------------------------------------------------------
		//-------------------------------- QUICK SORT, SOLUCIÓN SECUENCIAL ---------------------------
		//--------------------------------------------------------------------------------------------

		arranco = System.currentTimeMillis();
		
		Quicksort_secuencial.quickSort(arr2, 0, arr2.length - 1);
		
		fin = System.currentTimeMillis() - arranco;
	
		System.out.println("\nSolucion secuencial ---> " + fin + " milisegundos");
		
		//System.out.println(Arrays.arrayToString(arr2)); //Array ordenado secuencialmente
		
		
	}

}
