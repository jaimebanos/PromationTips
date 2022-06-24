import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainWave {

	
	public static void main (String[] args) {
	
		ArrayList <String> direccion = new ArrayList<String>();
		//PASAR EL TXT A LA ARRAY
		direccion = pasarArray(direccion);
		String oxigeno="",dioxido="";
		int num0=0,num1=0;
		//OXIGENO
			for(int i=0;i<12;i++) {
				for(int j=0;j<direccion.size();j++) {
					if(Character.compare(direccion.get(j).charAt(i), '0')==0){
						num0++;
					}else {
						num1++;
						
					}
							
				}/////
				
				if(num0>num1) {
					direccion = arrayborrado(direccion, i, false);
				}else{
					direccion = arrayborrado(direccion, i, true);
				}
				num1=0;
				num0=0;
			}//////////////		
		
		oxigeno = direccion.get(0);
		direccion.clear();
		direccion = pasarArray(direccion);
		
		
		
	//CO2
			for(int i=0;i<12 && direccion.size()!=1;i++) {
				for(int j=0;j<direccion.size();j++) {
					if(Character.compare(direccion.get(j).charAt(i), '0')==0){
						num0++;
					}else {
						num1++;
						
					}
						
				}/////
				if(num0>num1) {
					direccion = arrayborrado(direccion, i, true);
				}else {
					direccion = arrayborrado(direccion, i, false);
				}
				
				num1=0;
				num0=0;
			}//////////////		

		dioxido = direccion.get(0);

		
		
		System.out.println(dioxido+" "+oxigeno);
		
		
		
	}
	
	
	
	
	
	
	public static ArrayList <String >arrayborrado(ArrayList<String> direccion,int poss,boolean eleccion) {
		
		ArrayList <String> arraycopia = new ArrayList <String>();
		if(eleccion == true) {
			for(int z=0;z<direccion.size();z++) {
				if(Character.compare(direccion.get(z).charAt(poss), '1')==0) {
					arraycopia.add(direccion.get(z));
				}
			}
		}else {
			for(int z=0;z<direccion.size();z++) {
				if(Character.compare(direccion.get(z).charAt(poss), '0')==0) {
					arraycopia.add(direccion.get(z));
				}
			}
		}
		
		return arraycopia;
	}
	
	
	
	
	
	
	
	
	
	public static ArrayList<String> pasarArray(ArrayList<String> direcciones) {
		try {
			FileReader archivo= new FileReader("C:\\Users\\jaime\\eclipse-workspace\\WaveDucks\\src\\input.txt");
			BufferedReader br = new BufferedReader(archivo);
			String palabra = br.readLine();
			while(palabra!=null) {
				direcciones.add(palabra);
				palabra=br.readLine();
			}
			archivo.close();
			br.close();
			
		}catch(IOException e) {
			System.out.println("Error");
		}
		
		
		return direcciones;
	}
	
	
	
}
