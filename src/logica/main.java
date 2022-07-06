package logica;

import java.util.ArrayList;
import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		// TO

		int numeros1 [] = {2,3,0,1};
		
		int matriz [][] = new int[3][3];
		
		matriz[0][0]=1;
		matriz[0][1]=2;
		matriz[0][2]=3;
		matriz[1][0]=2;
		matriz[1][1]=5;
		matriz[1][2]=0;
		matriz[2][0]=3;
		matriz[2][1]=0;
		matriz[2][2]=5;
		
		int[][] m1 = {{1,1,1,1},
				      {1,1,1,1},
				      {1,1,1,1},
				      {1,1,1,1}};
	
		int[][] m2 = new int[4][4];

		
		
		String palabra= "hola";
		
		palabra=palabra.toUpperCase();
		
		char[] result =new char[palabra.length()];
		
		char[] aux= new char[palabra.length()];
		
		aux=suprimirConsonantesRecursividad(palabra, result, 0);
		
		for (int i = 0; i < result.length; i++) {
		System.out.println(" " + aux[i]);
			
		}
	}
	
	
	
	public static char[] suprimirConsonantesRecursividad(String palabra,char[] result,int i)
	{
		String palabraR="";
		
		if(i<palabra.length())
		{
			if(isVocal(palabra.charAt(i)))
			{
				result[i]=palabra.charAt(i);
			}else {
				result[i]=' ';
			}
			
			result=suprimirConsonantesRecursividad(palabra, result, i+1);
			
		}
		
		
		return result;
	}
	
	/*
	 * Metodo que encripta y desencripta mensajes de manera recursiva 
	 * si la direccion =0 encripta si es ==1 desencripta
	 */
	public static char[] encriptaryDesencriptarMensajeRecursividad(String mensaje,char[] result,int direccion,int clave,int i)
	{
		
		
		if(i<mensaje.length())
		{
			if(direccion==0)
			{
				result[i]=(char)(mensaje.charAt(i)+clave);
			}else {
				result[i]=(char)(mensaje.charAt(i)-clave);
			}
			result=encriptaryDesencriptarMensajeRecursividad(mensaje, result, direccion, clave, i+1);
		}
			
		
		return result;
		
	}
	
	/*
	 * Ejercicio parcialmente  basado en hakerrank dado un numero en formato cadean 1234 y 0
	 * 1+2+3+4=10
	 * 1+0=1
	 * Devolver 1 
	 */
	public static int superDigit(String n, int k) {

		int aux = Integer.parseInt(n);
		if (aux > 0) {
			k = k + aux % 10;
			k = superDigit("" + aux / 10, k);
		} else {
			if (k >= 10) {
				k = superDigit("" + k, 0);
			}
			return k;

		}

		return k;
	}
	
	public static int[][] inicializarMatrizDiagonalRecursiva(int[][] matriz, int i, int j, int indice) {
		if (i < matriz.length) {
			if (j < matriz[i].length) {
				if (i == j) {
					matriz[i][j] = 1;
					matriz = inicializarMatrizDiagonalRecursiva(matriz, i, j + 1, indice);
				} else {

					if (i < j) {

						matriz[i][j] = (int) Math.pow(2, indice);
						matriz = inicializarMatrizDiagonalRecursiva(matriz, i, j + 1, indice + 1);
					} else {
						matriz[i][j] = 0;
						matriz = inicializarMatrizDiagonalRecursiva(matriz, i, j + 1, indice);
					}

				}

			} else {
				inicializarMatrizDiagonalRecursiva(matriz, i + 1, 0, indice);
			}
		}

		return matriz;
	}
	
/*
 * Metodo recursivo que permite saber si una matriz es simetrica
 * Si alguno de los elementos comparados no son iguales , se retorna directamente falso ya
 * que no tenemos necesidad de seguir comparando
 */
	public static boolean isMatrizSimetricaRecursividad(int[][] matriz, int i, int j, boolean bandera) {
		if (i < matriz.length) {
			if (j < matriz[i].length) {
				if (i != j) {
					if (matriz[i][j] == matriz[j][i]) {

						bandera = isMatrizSimetricaRecursividad(matriz, i, j + 1, bandera);
					}else {
						return bandera;
					}
					
				}
				bandera = isMatrizSimetricaRecursividad(matriz, i, j + 1, bandera);
				
			} else {
				bandera = isMatrizSimetricaRecursividad(matriz, i + 1, 0, bandera);
			}
		} else {
			bandera = true;
		}

		return bandera;
	}
	
	public static boolean isVocal(char letra)
	{
		if(letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U' )
		
		{
			return true;
		}
		return false;
	}

	/*
	 * Este metodo recursivo permtie saber si la cadena 2 , es la cadena1 es orden
	 * inverso Si se diferencian en algun caracter directamente se retorna falso ,
	 * ya que no tenemos necesidad de comparar mas , no son exactamente inversos
	 */
	public static boolean isInversaCadenaRecursividad(String cadena1, String cadena2, int i, int j, boolean bandera) {
		if (i >= 0)

		{
			if (cadena1.charAt(i) == cadena2.charAt(j)) {

				bandera = isInversaCadenaRecursividad(cadena1, cadena2, i - 1, j + 1, bandera);
			} else {
				return bandera;
			}

		} else {

			bandera = true;

		}

		return bandera;
	}
	
	/*
	 * Este metodo recursivo agrega a un arrayList las posciones del arreglo 1 en donde la cadena palabras está al reves
	 */
	public static ArrayList<Integer> buscarCadenaInservaArregloRecursividad(String [] palabras,String palabraAComparar,int i,boolean bandera,ArrayList<Integer> result)
	{
		if(i<palabras.length)
		{
			if(isInversaCadenaRecursividad(palabras[i], palabraAComparar, palabras[i].length()-1,0, bandera))
			{
				result.add(i);
				result=buscarCadenaInservaArregloRecursividad(palabras, palabraAComparar, i+1, bandera, result);
			}else {
				result=buscarCadenaInservaArregloRecursividad(palabras, palabraAComparar, i+1, bandera, result);
			}
		}
		
		return result;
	}
	
	public static int recorrerMatrizRecursividad(int matriz[][], int i, int j) {
		if (i != matriz.length) {

			if (j <= matriz.length - 1) {
				return matriz[i][j] + recorrerMatrizRecursividad(matriz, i, j + 1);
			} else {
				return  recorrerMatrizRecursividad(matriz, i + 1, 0);
			}
		}
		return 0;

	}
	
	
	/*
	 * Este metodo retorna true si el arreglo numeros2 esta contenido dentro del arrreglo numero1
	 */
	public static boolean encontrarArregloInversoRecursivo(boolean bandera, int i, int j, int[] numeros1,
			int[] numeros2, int auxIgual) {
		if (i < numeros1.length) {
			if (numeros1[i] == numeros2[j]) {
				bandera = encontrarArregloInversoRecursivo(bandera, i + 1, j - 1, numeros1, numeros2, auxIgual + 1);
			} else {
				bandera = encontrarArregloInversoRecursivo(bandera, i + 1, numeros2.length - 1, numeros1, numeros2,
						auxIgual);
			}
		} else {

			if (auxIgual == numeros2.length) {
				bandera = true;
			}

		}

		return bandera;
	}
	
	
	/*
	 * Genera la serie de la forma 1,4,9,16,25 , retorna el entero
	 */
	public static int generarSerieEntero(int n,int i)
	{
		if(i<=n)
		{
			
			 return (i*i) + generarSerieEntero(n, i+1);
		}
		
		
		return 0;
	}
	/*
	 * Genera la serie de la forma 1,4,9,16,25 , retorna la cadena
	 */
	public static String generarSerieCadena(int n,int i,String serie)
	{
		if(i<=n)
		{
			serie=serie +" " + (i*i);
			
			 serie = generarSerieCadena(n, i+1,serie);
		}
		
		
		return serie;
	}
/*
 * Metodo recursivo que permtie saber si un numero es perfecto	
 */
	public static boolean isPerfecto(int numero, int i, boolean bandera, int acum) {
		if (numero != i) {
			if (numero % i == 0) {
				acum = acum + i;

			}
			bandera = isPerfecto(numero, i + 1, bandera, acum);

		} else {

			if (acum == numero) {
				bandera = true;
			}

		}

		return bandera;
	}
/*
 * Metodo que encuentra el promedio de los numeros recursivos que hay en un arreglo
 */
	public static int encontrarPromedioRecursivo(int [] numeros,int indiceArreglo,int promedio,int cantidadPrimos)
	{
		if(numeros.length!=indiceArreglo)
		{
			if (isPrimoRecursivo(numeros[indiceArreglo],1 , false, 1)) {
				promedio = promedio + numeros[indiceArreglo];
				promedio = encontrarPromedioRecursivo(numeros, indiceArreglo + 1, promedio,cantidadPrimos+1);
			}else {
				promedio = encontrarPromedioRecursivo(numeros, indiceArreglo + 1, promedio,cantidadPrimos);
			}
		}else {
			promedio=(promedio/cantidadPrimos);
		}
		
		return promedio;
	}
	
	/*
	 * Metodo recursivo que permite saber si un numero es primo
	 */
	public static boolean isPrimoRecursivo(int numero,int contador,boolean bandera,int i)
	{
		
		if (i<=numero  ) {
			
			if (numero % i == 0) {

				bandera = isPrimoRecursivo(numero, contador + 1, bandera,i+1);
			} else {
				bandera = isPrimoRecursivo(numero, contador, bandera,i+1);
			}
		}else {
			if(contador==3)
			{
				bandera=true;
			}
		}
		
		return bandera;
	}
	
	
	
	public static double calcularSerieRecursivo(int limite, double vSerie, int i) {

		if (i <= limite) {

			if (i % 2 == 0) {

				return (vSerie / i) - calcularSerieRecursivo(limite, vSerie, i + 1);
			} else {

				return (vSerie / i) + calcularSerieRecursivo(limite, vSerie, i + 1);

			}

		}

		return vSerie;
	}

	public static int mayorDigitosNumerosRecursivo(int n, int numMayor) {

		if (n > 0) {

			if (n % 10 > numMayor) {
				numMayor = mayorDigitosNumerosRecursivo(n / 10, n % 10);
			} else {
				numMayor = mayorDigitosNumerosRecursivo(n / 10, numMayor);
			}

		}

		return numMayor;

	}

	public static int mayorDigitosNumeros(int n) {
		int numMayor = 0;

		for (int i = n; i > 10; i = i / 10) {

			if (i % 10 > numMayor) {
				numMayor = i % 10;
			}

		}

		return numMayor;
	}

	public static int calcularFactorialRecursivo(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * calcularFactorialRecursivo(n - 1);
		}

	}

	/*
	 * **
	 * **** 
	 * ****** 
	 * ******** 
	 * ********** 
	 * ************
	 * 
	 */
	public static String generarTriangulo(int n) {
		String cadena = "";

		for (int i = 1; i < n; i++) {

			for (int j = n - i; j > 0; j--) {

				cadena += " ";
			}

			for (int j = 0; j < i * 2; j++) {

				cadena += "*";
			}
			cadena += "\n";
		}
		return cadena;
	}

	/*
	 * ***** **** *** ** *
	 * 
	 */
	public static String generarTrangulaLado(int n) {
		String cadena = "";

		for (int i = 0; i < n; i++) {
			for (int j = n - i; j > 0; j--) {

				cadena += "*";

			}
			cadena += "\n";
			cadena += " ";

			for (int j = 1; j <= i; j++) {

				cadena += " ";

			}
		}

		return cadena;
	}

	/*
	 * **** * * * * ****
	 * 
	 * 
	 */
	public static String generarCuadroVacio(int n) {

		String cadena = "";

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (i == 0 || j == n - 1 || j == 0 || i == n - 1) {
					cadena += "*";
				} else {
					cadena += " ";
				}

			}
			cadena += "\n";
		}

		return cadena;
	}

	/*
	 * * ** * * * * *****
	 * 
	 */
	public static String generarTrianguloVacio(int n) {
		String cadena = "";

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {

				if (j == 0 || j == i || i == n - 1) {
					cadena += "*";
				} else {
					cadena += " ";

				}

			}

			cadena += "\n";
		}

		return cadena;
	}

	

	public static int recorrerArregloConRecursion(int[] arreglo, int i) {
		if (arreglo.length == i) {
			return 0;
		} else {

			return arreglo[i] + recorrerArregloConRecursion(arreglo, i + 1);
		}

	}

	public static String generarPiramideInvertida(int n) {
		String cadena = "";

		for (int i = 0; i <= n; i = i + 2) {

			for (int k = 0; k < (i - 1) / 2; k++) {

				cadena += " ";
			}

			for (int j = n - i; j >= 0; j--) {

				cadena += "*";
				if (j == 0) {
					cadena += " ";
				}

			}
			cadena += "\n";
			cadena += "  ";

		}

		return cadena;
	}

	/*
	 * 
	 * 
	 * * ** *** **** ***** **** *** ** *
	 * 
	 */
	public static String generarTrianguloCostado(int n) {
		int k = 0;

		String cadena = "" + "\n";

		int h = 0;

		for (int i = 0; i <= n; i++) {

			for (int j = 1; j <= i; j++) {
				cadena += "*";
			}

			cadena += "\n";
		}

		for (int j = 0; j < n; j++) {

			for (k = n - j; k > 1; k--) {

				cadena += "*";

			}
			cadena += "\n";
		}
		return cadena;
	}
}
