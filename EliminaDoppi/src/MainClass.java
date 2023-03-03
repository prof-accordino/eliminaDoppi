public class MainClass
{
	/*
	 * Ci sono due versioni dell'algoritmo "elimina doppi"
	 * 
	 * Commenta tutte le righe spiegando con poche parole 
	 * a cosa servono all'interno dell'algoritmo
	 * 
	 * ad esempio:
	 * a[0] = b[0]; // Copio il primo elemento perché non ci sono ancora ripetuti.
	 * int k = 1; // questo è l'indice dei nuovo array, parte da 1 perché ...
	 * 
	 * Puoi evitare di commentare il codice nel main e i System.out.println e le parentesi graffe
	 */
	public static void main(String[] args)
	{
		int[] array1 = riempiArray();
		stampaArray("Array con doppi",array1);

		int[] array2 = eliminaDoppi1(array1);
		stampaArray("Array senza doppi - 1",array2);		

		int[] array3 = eliminaDoppi2(array1);
		stampaArray("Array senza doppi - 2",array3);				
	}
	
	static int[] eliminaDoppi1(int[] conDoppi)
	{
		int[] senzaDoppi = new int[conDoppi.length];
		senzaDoppi[0] = conDoppi[0];
		int k = 1;
		for(int i = 1; i < conDoppi.length; i++)
		{
			boolean doppione = false;
			for(int j = i-1; j >= 0; j--)
			{
				if(conDoppi[i] == conDoppi[j])
				{
					doppione = true;
					break;
				}
			}
			if(doppione == false)
				senzaDoppi[k++] = conDoppi[i];			
		}

		int[] arrayFinale = new int[k];		
		copiaArray(senzaDoppi, arrayFinale);		
		return arrayFinale;
	}
	
	static int[] eliminaDoppi2(int[] conDoppi)
	{
		int[] senzaDoppi = new int[conDoppi.length];
		senzaDoppi[0] = conDoppi[0];
		int k = 1;
		for(int i = 1; i < conDoppi.length; i++)
			if(!contiene(senzaDoppi, conDoppi[i]))
					senzaDoppi[k++] = conDoppi[i];		
		
		int[] arrayFinale = new int[k];		
		copiaArray(senzaDoppi, arrayFinale);		
		return arrayFinale;
	}

	static boolean contiene(int a[], int n)
	{
		for (int i = 0; i< a.length; i++)
			if(a[i] == n)
				return true;
		return false;
	}

	static int[] riempiArray()
	{
		int[] array = new int[10];
		for(int i = 0; i < array.length; i++)
			array[i] = (int)(Math.random() * 11) - 5;
		return array;
	}
	
	static void stampaArray(String nome, int[] array)
	{
		System.out.println(nome + ":");
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	static void copiaArray(int[] a1, int[]a2)
	{
		for(int i = 0; i < Math.min(a1.length, a2.length); i++)
			a2[i] = a1[i];
	}
}
