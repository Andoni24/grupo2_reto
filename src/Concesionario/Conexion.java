package Concesionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Clase Conexion para conectarse a un base de datos
 * 
 * @version 1.0 06/04/2022
 * @author Andoni de la Iglesia & Eneko Huarte
 */
public class Conexion {
		
		private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3306/gestion_vehiculo";
		private static final String USUARIO = "root";
		private static final String CLAVE = "root";

		static {
			try {
				Class.forName(CONTROLADOR);
			} catch (ClassNotFoundException e) {
				System.out.println("Error en el controlador");
				e.printStackTrace();
			}
		}
	/**
	 * 	metodo que se llama para conectarse a la base de datos
	 * @return devuelve la conexion
	 * @exception lanza SQLException si no consigue conectarse
	 */
		public Connection conectar() {
			Connection conexion = null;
			try {
				conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
				System.out.println("Conexion OK");
			}
			catch (SQLException e) {
				System.out.println("Error en la conexion");
				e.printStackTrace();
			}
			
			return conexion;
		}
}
