package controlador;

import java.sql.ResultSet;


import modelo.ConexionBBDD;

public class ConsultaBBDD {
	
	
	private ResultSet resultado=null;
	

	private ConexionBBDD conexion=null;
	
	
	public ConsultaBBDD() {
		
		
		ConexionBBDD conexion = new ConexionBBDD ();
		
		setConexion(conexion);
	
		
	}
	
	
	public ResultSet getTablasBBDD () {
		
		setResultado(getConexion().getMetadatosTablas());
		
		return getResultado();
		
	}
	
	public ResultSet consultaEnTablas (String s) {
		
		ResultSet r=getConexion().getResultadoConsulta(s);
		
		return r;
		
	}


	public ConexionBBDD getConexion() {
		return conexion;
	}


	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}


	public ResultSet getResultado() {
		return resultado;
	}


	public void setResultado(ResultSet resultado) {
		this.resultado = resultado;
	}
	
	

}
