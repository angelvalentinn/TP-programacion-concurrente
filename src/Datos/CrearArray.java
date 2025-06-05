package Datos;

import java.util.Random;

public class CrearArray {
	
	public static int[] generarArrayAleatorio(int tam, int min, int max) {
		
		int[] arr = new int[tam];
		Random random = new Random();
		
		for(int i=0; i<tam; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}
		
		return arr;
	}
	
	public static String arrayToString(int[] arr) {
        
		String aux = "[" + arr[0];
		
        for(int i = 1; i < arr.length; i++){
            aux += ", " + arr[i];
        }
        
        return aux + "]";
	}
	
}
