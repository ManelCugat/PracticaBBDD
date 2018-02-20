package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import modelo.ConexionBBDD;
import vista.Ventana;

public class EventoComboBox implements ActionListener{
	
	
	private Ventana ventanaAplicacion;
	private String seleccionComboBox;
	
	public EventoComboBox (Ventana v){
		
		
		ventanaAplicacion=v;
		
	}


	public void actionPerformed(ActionEvent e) {

		ResultSet r=null;
		
		setSeleccionComboBox(getVentanaAplicacion().getComboBox().getSelectedItem().toString());
		
		System.out.println(getSeleccionComboBox());
		
		ConsultaBBDD consulta = new ConsultaBBDD();
	
		r=consulta.consultaEnTablas(getSeleccionComboBox());
		
		getVentanaAplicacion().imprimeAreaTexto(r);
	
		
	}


	public Ventana getVentanaAplicacion() {
		return ventanaAplicacion;
	}


	public void setVentanaAplicacion(Ventana ventanaAplicacion) {
		this.ventanaAplicacion = ventanaAplicacion;
	}


	public String getSeleccionComboBox() {
		return seleccionComboBox;
	}


	public void setSeleccionComboBox(String seleccionComboBox) {
		this.seleccionComboBox = seleccionComboBox;
	}
	
	

}
