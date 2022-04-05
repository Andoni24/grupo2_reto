package Concesionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
