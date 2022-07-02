import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Adventure41 {

	
	public static void main(String[] args) {
		ArrayList <Integer> numerosGanadores = new ArrayList<Integer>();
				
		Integer[][][] arrayTodo= new Integer[100][5][5];
		
		numerosGanadores = pasarArrayInt(numerosGanadores);
		arrayTodo = MainWave.rellenarArray(arrayTodo);
		int comprobar=0;
		
		for(int x=0;x<numerosGanadores.size();x++) {
			for(int i=0;i<arrayTodo.length;i++) {
				for(int j=0;j<5;j++) {
					for(int k=0;k<5;k++) {
						
						if(arrayTodo[i][j][k] == numerosGanadores.get(x)) {
							arrayTodo[i][j][k]=100;
						}
						if(arrayTodo[i][j][k]==100) {
							comprobar++;
						}
						
						if(comprobar==5) {	
							System.out.println(resultado(i,numerosGanadores.get(x),arrayTodo));
							System.exit(0);
						
						}else if(arrayTodo[i][0][k]==100 && arrayTodo[i][1][k]==100
								&& arrayTodo[i][2][k]==100 && arrayTodo[i][3][k]==100
								&& arrayTodo[i][4][k]==100 ) {
							System.out.println(resultado(i,numerosGanadores.get(x),arrayTodo));
							System.exit(0);
						}
						
					}
					comprobar=0;
				}
					
			}
		}
	}
		
	
	public static int resultado(int i, int num, Integer[][][] lista) {
		int res=0;
		
		for(int z=0;z<5;z++) {
			for(int x=0;x<5;x++) {
				if(lista[i][z][x] != 100) {
					res = res + lista[i][z][x];
				}
			}
		}
		
		
		return res*num;
	}
	
	//posible metodo comprobar
	public static ArrayList<Integer> pasarArrayInt(ArrayList<Integer> direcciones) {
		try {
			
			FileReader archivo= new FileReader("C:\\Users\\jaime\\eclipse-workspace\\WaveDucks\\src\\input.txt");
			BufferedReader br = new BufferedReader(archivo);
			String palabra = br.readLine();
			String[] splitArray = (String[]) palabra.split(",");
			
			for(int i=0;i<splitArray.length;i++) {
				direcciones.add(Integer.valueOf(splitArray[i]));
			}
			
			
			archivo.close();
			br.close();
			
		}catch(IOException e) {
			System.out.println("Error");
		}
		
		
		return direcciones;
	}
	
	public static Integer[][][] rellenarArray(Integer[][][] direcciones) {
		ArrayList <String> cartones = new ArrayList<String>();
		cartones = pasarArrayCartones(cartones);
		String[] lineas;
		String[] numeros;
		
		
		for(int i=0;i<cartones.size();i++) {
			lineas = (String[]) cartones.get(i).split("\n"); 
			for(int j=0;j<5;j++) {
				numeros = lineas[j].trim().split("\\s+");
				for(int k=0;k<5;k++) {
					direcciones[i][j][k]=Integer.parseInt(numeros[k].trim());
				
				}
			}
		}
		
			
		return direcciones;
	}
	
	public static ArrayList<String> pasarArrayCartones(ArrayList<String> direcciones) {
		String texto="";
		try {
			FileReader archivo= new FileReader("C:\\Users\\jaime\\eclipse-workspace\\WaveDucks\\src\\input.txt");
			BufferedReader br = new BufferedReader(archivo);
			br.readLine();
			br.readLine();
			String palabra=br.readLine();
			while (palabra !=null) {
				texto=texto+palabra+"\n";
				palabra=br.readLine();
				
			}
			archivo.close();
			br.close();
			
		}catch(IOException e) {
			System.out.println("Error");
		}
		
		String[] splitsalto = (String[]) texto.split("\n\n");
		for(int i=0;i<splitsalto.length;i++) {
			direcciones.add(splitsalto[i]);
		}
		
		return direcciones;
	}
	
	
}
