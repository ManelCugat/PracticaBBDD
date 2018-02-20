package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AccesoFichero {
	
	
	public AccesoFichero() {
		
		leerFichero();
		
		
	}
	
	
	
	public String leerFichero () {
		
		FileReader entrada=null;
		String ruta=null;
		
		try {
			entrada = new FileReader("/USERS/manelcugat/desktop/acceso.txt");
			
			BufferedReader mibuffer = new BufferedReader(entrada);
			
			String linea="";
			
			while (linea!=null) {
				
				try {
					linea=mibuffer.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if (linea!=null) {
					
					//System.out.println(linea);
					ruta=linea;
					
					
				}
				
			}
			
			
			
			try {
				mibuffer.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		
		}
		
		return ruta;
		
		
		
	}

}
