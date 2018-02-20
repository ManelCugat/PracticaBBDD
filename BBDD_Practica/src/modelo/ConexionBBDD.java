
package modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

import controlador.AccesoFichero;


public class ConexionBBDD {
	
	private Connection miConexion=null;
	
	
	public ConexionBBDD(){
		
		AccesoFichero baseDatos = new AccesoFichero();
		
		String ruta = baseDatos.leerFichero();
		
		try {
			
			miConexion = DriverManager.getConnection(ruta, "root", "root");
	
			}catch (Exception e) {
				
				System.out.println("");
				e.printStackTrace();					
			}
		
	}
	
	public ResultSet getMetadatosTablas () {
		
		
		DatabaseMetaData dataBase=null;
		ResultSet resultadoMetadatos=null;
		
		try {
			
			dataBase = getConexion().getMetaData();
			
			resultadoMetadatos=dataBase.getTables(null, null, null, null);
			
			getConexion().close();
	
		} catch (SQLException e) {
			
			System.out.println("Error realizando la consulta a Base de Datos (MetaData)");
			
			e.printStackTrace();
		
		}
	
		
		return resultadoMetadatos;
	
	}
	
	
	public ResultSet getResultadoConsulta (String s) {
		
		
		//PreparedStatement miSentencia=null;
		Statement statement=null;
		ResultSet resultado=null;
		
		try {
			
	
			
			System.out.println("Se realiza la consulta en la tabla: " + s);
			statement = getConexion().createStatement();
			resultado = statement.executeQuery("SELECT * FROM "+s);
		
			
		}catch (Exception e) {
			
			System.out.println("Error realizando la consulta a Base de Datos (Resultset)");
			
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	
	public Connection getConexion () {
		
		return miConexion;
		
	}
	

	
}

