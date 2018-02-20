package vista;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.*;

import controlador.ConsultaBBDD;
import controlador.EventoComboBox;


public class Ventana {
	
	private JTextArea cuadro_texto;
	private JComboBox <String >comboBox;
	
	public Ventana () {
		
		Marco miMarco = new Marco ();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);
		
	}
	
	public JTextArea getCuadro_texto() {
		return cuadro_texto;
	}



	public void setCuadro_texto(JTextArea cuadro_texto) {
		this.cuadro_texto = cuadro_texto;
	}



	public JComboBox<String> getComboBox() {
		return comboBox;
	}



	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}
	
	public void imprimeAreaTexto (ResultSet r) {
		
		int n;
		
		getCuadro_texto().setText(null);
		
		try {
			
			ResultSetMetaData rm = r.getMetaData();
			
			n=rm.getColumnCount();
			
			int i;
			
			System.out.println("Número de columnas: "+n);
			
			while (r.next()){
				
				//System.out.println("Entro en el while");
				
				for (i=1;i<=n;i++) {
					
					getCuadro_texto().append(r.getString(i));
					
				}
				
				getCuadro_texto().append("\n");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	


	private class Marco extends JFrame{
		
		private static final long serialVersionUID = 1L;

		public Marco() {
			
			this.setVisible(true);
			
			this.setSize(900,900);
			
			this.setLocation(400, 200);
			
			this.setTitle("Acceso Base de Datos");
			
			this.add(new Lamina());
			
		}
	
	}
	
	private class Lamina extends JPanel{

		private static final long serialVersionUID = 1L;

		public Lamina() {
		
			
			this.setLayout(new BorderLayout());
					
			comboBox = new JComboBox <String>();
			
			JTextArea cuadroTexto = new JTextArea(); 
			cuadroTexto.setEnabled(false);
			setCuadro_texto(cuadroTexto);
	
			this.add(comboBox,BorderLayout.NORTH);
			this.add(cuadroTexto,BorderLayout.CENTER);
			
			rellenaComboBox();
			
			comboBox.addActionListener(new EventoComboBox(Ventana.this));
			
			
		}
		
		private void rellenaComboBox() {
			
			ResultSet r=null;
			
			ConsultaBBDD consulta = new ConsultaBBDD();
			
			r=consulta.getTablasBBDD();
			
			try {
				while (r.next()) {
					
					getComboBox().addItem(r.getString("TABLE_NAME"));
					
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			
		}
		
	
	}
	
	
	


}
