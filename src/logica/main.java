package logica;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(" " + calcularFactorialRecursivo(5));
	}
	
	
	
	public static int calcularFactorialRecursivo(int n)
	{
		if(n==0)
		{
			return 1;
		}else {
			return n * calcularFactorialRecursivo(n-1);
		}
			
	}
	
	/*      **  
	 *     ****
	 *    ******  
	 *   ******** 
	 *  **********  
	 * ************    
	 * 
	 */
	public static String generarTriangulo(int n)
	{
		String cadena="";
		
		for (int i = 1; i < n; i++) {
			
			for (int j = n-i; j > 0 ; j--) {
				
				cadena += " ";
			}
			
			for (int j = 0; j < i*2; j++) {
				
				cadena += "*";
			}
			cadena+="\n";
		}
		return cadena;
	}
	
	/*
	 * *****
	 *  ****
	 *   ***
	 *    **
	 *     *
	 * 
	 */
	public static String generarTrangulaLado(int n)
	{
		String cadena="";
		
		for(int i=0;i<n;i++)
		{
			for (int j = n-i; j > 0; j--) {
				
				cadena += "*";
				
			}
			cadena+="\n";
			cadena+=" ";
			
			for (int j = 1; j <=i ; j++) {
				
				cadena += " ";
				
			}
		}
		
		
		return cadena;
	}
	/*
	 * 	****
	 * 	*  *
	 * 	*  *
	 * 	****
	 * 	
	 * 
	 */
	public static String generarCuadroVacio(int n)
	{
		
		String cadena="";
		
		for(int i=0;i<n;i++)
		{
			for (int j = 0; j < n; j++) {
				
				if(i==0 || j==n-1 || j==0 || i==n-1)
				{
					cadena += "*";
				}else {
					cadena += " ";
				}
				
				
			}
			cadena+="\n";
		}
		
		
		
		return cadena;
	}
	/*
	 * *
	 * **
	 * * *
	 * *  *
	 * *****
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
	
	public static int recorrerMatriz(int [][] matriz,int i,int j)
	{
		if(matriz.length-1==i && matriz[i].length-1==j)
		{
			return 0;
		}else {
			
			
		}
		return 0;
	}
	
	
	public static int recorrerArregloConRecursion(int [] arreglo,int i)
	{
		if(arreglo.length==i)
		{
			return 0;
		}else {
			
			return  arreglo[i] + recorrerArregloConRecursion(arreglo, i+1);
		}
				
	}
	
	public static String generarPiramideInvertida(int n) {
		String cadena = "";

		for (int i = 0; i <= n; i = i + 2) {

			for (int k = 0; k < (i-1)/2; k++) {

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
	 *  *
	 *	**
	 *	***
	 *	****
	 *	*****
	 *	****
	 *  ***
	 *	**
	 *  *
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
