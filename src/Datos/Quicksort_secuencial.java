package Datos;

public class Quicksort_secuencial {
	
	
	public static void quickSort(int[] arr, int low, int high) {
		
		if (low < high) { //Condicion de corte de recursividad
			
			//Elige el pivote y acomoda los mas chicos a su izquierda y mas grandes a su derecha
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1); //Se repite el ciclo con sub arreglo izq
			quickSort(arr, pi + 1, high); //Se repite el ciclo con sub arreglo der
		}
		
	}

	private static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[low]; //Se elige el primer elemento como pivote
		int i = low - 1; //Posicion del ultimo elemento mas pequeño que el pivote
		
		for (int j = low; j < high; j++) { //Se recorre todo el array
			
			if (arr[j] < pivot) { //Si el elemento es menor que el pivote
				
				i++; //Actualizamos la posicion del ultimo elemento mas pequeño que el pivote
				int temp = arr[i]; 
				arr[i] = arr[j]; //Se realiza el cambio de elementos
				arr[j] = temp;
			}
			
		}
		
		//Intercambiamos el pivote por ultimo, acomodando donde debe estar
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return i + 1; // Retornamos la posicion final del pivote
		
	}
	
}
