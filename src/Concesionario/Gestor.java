package Concesionario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *Clase gestor sirve para hacer las consultas de una bases de datos
 * 
 * @version 1.0 06/04/2022
 * @author Andoni de la Iglesia & Eneko Huarte
 */
public class Gestor {

	Connection c;
	Coche coche;
	Camion camion;
	Serie serie;
/**
 * 
 * @param cn conexion de la base de datos
 * 
 */
	public Gestor(Connection cn) {
		this.c = cn;
	}
/**
 * 
 * @param cn conexion de la base de datos
 * @param s una serie 
 */
	public Gestor(Connection cn,Serie s) {
		this.c = cn;
		this.serie=s;
	}
/**
 * 
 * @param cn conexion de la base de datos
 * @param ch un coche
 */
	public Gestor (Connection cn, Coche ch) {
		this.c=cn;
		this.coche=ch;
	}
/**
 * 
 * @param cn conexion de la base de datos
 * @param ch un camion
 */
	public Gestor (Connection cn, Camion cmn) {
		this.c=cn;
		this.camion=cmn;
	}
	
	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public Camion getCamion() {
		return camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

/**
 * Selecciona todas las serie de la base de datos
 * @return devuelve el resultado de la consulta
 * @exception SQLException si hay un error en la consulta
 */
	public ResultSet selectSerie() {
		Statement stm = null;
		ResultSet rs = null;
		try {
			stm = this.c.createStatement();
			rs = stm.executeQuery("select * from serie");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}
	/**
	 * Selecciona todos los coches de la base de datos
	 * @return devuleve el resultado de la consulta
	 * @exception SQLException si hay un error en la consulta
	 */
	public ResultSet selectCoche() {
		Statement stm = null;
		ResultSet rs = null;
		try {
			stm = this.c.createStatement();
			rs = stm.executeQuery("select * from coche");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}
	/**
	 * Selecciona todos los camiones de la base de datos
	 * @return devuleve el resultado de la consulta
	 * @exception SQLException si hay un error en la consulta
	 */
	public ResultSet selectCamion() {
		Statement stm = null;
		ResultSet rs = null;
		try {
			stm = this.c.createStatement();
			rs = stm.executeQuery("select * from camion");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
/**
 * Verifica si la serie esta creada en la base de datos
 * @return devuleve true si existe. false si no existe
 * @exception SQLException si hay un error en la consulta
 */
	public boolean verificarSerie() {
		ResultSet rs = null;
		boolean existe = false;
		try {
			rs = selectSerie();
			while(rs.next() && !existe) {
					if((rs.getString(2).equalsIgnoreCase(this.serie.getMarca()) && (rs.getString(3).equalsIgnoreCase(this.serie.getModelo()) &&
						(rs.getInt(4) == this.serie.getAnioFab())))) {
						existe = true;
					}
					
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
	}
/**
 * Inserta una serie
 * @return
 * @throws SQLException
 */
	public String  insertarSerie() throws SQLException{
		PreparedStatement ps = null;
		ps = c.prepareStatement("INSERT INTO serie(marca,modelo,anioFabric) VALUES(?,?,?)");
		ps.setString(1, this.serie.getMarca());
		ps.setString(2, this.serie.getModelo());
		ps.setInt(3, this.serie.getAnioFab());
		if(ps.executeUpdate()!=1) {
			return "Error en la insercción";
		}
		return "Insercción realizada correctamente";
	}
	
	public int selectNumSerie() throws SQLException{
		
		Statement stm = this.c.createStatement();
		ResultSet rs = null;
		int numSerie=0;
		try {
			rs = stm.executeQuery("select numSerie from serie where marca like "+"'"+this.serie.getMarca()+"'"+" && modelo like "+
					"'"+this.serie.getModelo()+"'"+" && anioFabric = "+this.serie.getAnioFab());
			while(rs.next()) {
				numSerie = rs.getInt(1);
			 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return numSerie;
	}
	
	public String insertCoche(Coche ch)throws SQLException {
		
		PreparedStatement ps = null;
		ps = this.c.prepareStatement("INSERT INTO coche values(?,?,?,?,?,?,?,?)");
		ps.setString(1, ch.getMatricula());
		ps.setString(2, ch.getNumBastidor());
		ps.setString(3, ch.getColor());
		ps.setDouble(4, ch.getPrecio());
		ps.setInt(5, ch.getNumAsientos());
		ps.setInt(6, ch.getNumPuertas());
		ps.setInt(7, ch.getCapMaletero());
		ps.setInt(8,ch.getSerie().getNumSerie());
		
		if(ps.executeUpdate()!=1) {
			return "Error en la insercción";
		}
		
		return "Coche añadido correctamente";
	}
	
	public String insertCamion(Camion cm)throws SQLException {
			
		PreparedStatement ps = null;
		ps = this.c.prepareStatement("INSERT INTO camion values(?,?,?,?,?,?,?,?)");
		ps.setString(1, cm.getMatricula());
		ps.setString(2, cm.getNumBastidor());
		ps.setString(3, cm.getColor());
		ps.setDouble(4, cm.getPrecio());
		ps.setInt(5, cm.getNumAsientos());
		ps.setInt(6, cm.getCarga());
		ps.setString(7, cm.getTipoMercancia());
		ps.setInt(8,cm.getSerie().getNumSerie());
		
		if(ps.executeUpdate()!=1) {
			return "Error en la insercción";
		}
			
			return "Camión añadido correctamente";
		}

	public String eliminarCoche(String matricula) {
		PreparedStatement ps;
		try {
			ps = this.c.prepareStatement("DELETE FROM coche WHERE matricula like ("+"'"+matricula+"'"+");");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return "Coche vendido correctamente";
		}
	
	public String eliminarCamion(String matricula) {
		try {
		PreparedStatement ps = this.c.prepareStatement("DELETE FROM camion WHERE matricula like ("+"'"+matricula+"'"+");");
        ps.executeUpdate();
        
			if(ps.executeUpdate()==0) {
				return "Error en la venta";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return "Camion vendido correctamente";
		}
	public Coche elegirCoche(String matricula) {
		Statement stm = null;
		ResultSet rs = null;
		Coche coche = null;
		try {
			stm = this.c.createStatement();
			rs = stm.executeQuery("SELECT * from coche where matricula like ("+"'"+matricula+"'"+")");
			while(rs.next()) {
				coche = new Coche(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(8),rs.getDouble(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
			}
			
		}catch(SQLException e) {
			System.out.println("Error en la sentencia");
		}
		
		return coche;
		}
	
	public Camion elegirCamion(String matricula) {
		Statement stm = null;
		ResultSet rs = null;
		Camion camion = null;
		try {
			stm = this.c.createStatement();
			rs = stm.executeQuery("SELECT * from camion where matricula like ("+"'"+matricula+"'"+")");
			while(rs.next()) {
				camion = new Camion(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(8),rs.getDouble(4),rs.getInt(5),rs.getInt(6),rs.getString(7));
			}
			
		}catch(SQLException e) {
			System.out.println("Error en la sentencia");
		}
		
		return camion;
		}
	
	public void pintarCoche(String nuevoColor,Coche c) {
		try {
			PreparedStatement ps=null;
			ps = this.c.prepareStatement("UPDATE coche SET color"+" = "+"'"+nuevoColor+"'" +" WHERE matricula like '"+c.getMatricula()+"'");
	        ps.executeUpdate();
		}catch(SQLException e ) {
			System.out.println("Fallo al pintar");
		}
	}
	
	public void pintarCamion(String nuevoColor,Camion c) {
		try {
			PreparedStatement ps=null;
			ps = this.c.prepareStatement("UPDATE camion SET color"+" = "+"'"+nuevoColor+"'" +" WHERE matricula like '"+c.getMatricula()+"'");
	        ps.executeUpdate();
		}catch(SQLException e ) {
			System.out.println("Fallo al pintar");
		}
	}
	
	public void AlterarCoche(int mod,Coche c) {
		try {
			PreparedStatement ps=null;
			switch(mod) {
			case 1:
				System.out.println("Introduce nuevo precio");
				double precio = Console.readDouble();
				ps = this.c.prepareStatement("UPDATE coche SET precio"+" = "+precio +" WHERE matricula like '"+c.getMatricula()+"'");
				ps.executeUpdate();
				break;
			case 2:
				System.out.println("Introduce nueva cantidad de asientos");
				int numAsientos = Console.readInt();
				ps = this.c.prepareStatement("UPDATE coche SET numAsientos"+" = "+numAsientos +" WHERE matricula like '"+c.getMatricula()+"'");
				ps.executeUpdate();
				break;
			case 3:
				System.out.println("Introduce nueva capacidad de maletero");
				int capMaletero = Console.readInt();
				ps = this.c.prepareStatement("UPDATE coche SET capMaletero"+" = "+capMaletero +" WHERE matricula like '"+c.getMatricula()+"'");
				ps.executeUpdate();
				break;
			case 4:
				System.out.println("Introduce nueva cantidad de puertas");
				int numPuertas = Console.readInt();
				ps = this.c.prepareStatement("UPDATE coche SET numPuertas"+" = "+numPuertas +" WHERE matricula like '"+c.getMatricula()+"'");
				ps.executeUpdate();
				break;
			default:
				System.out.println("No existe esa opción");
			}
			System.out.println("Modificación realizada");
		}catch(SQLException e){
			System.out.println("Error en la sentencia");
		}catch(NumberFormatException e) {
			System.out.println("no existe esa elección");
		}
	}
	
	public void AlterarCamion(int mod,Camion c) {
		try {
			PreparedStatement ps=null;
			switch(mod) {
			case 1:
				System.out.println("Introduce nuevo precio");
				double precio = Console.readDouble();
				ps = this.c.prepareStatement("UPDATE camion SET precio"+" = "+precio +" WHERE matricula like '"+c.getMatricula()+"'");
				ps.executeUpdate();
				break;
			case 2:
				System.out.println("Introduce nueva cantidad de asientos");
				int numAsientos = Console.readInt();
				ps = this.c.prepareStatement("UPDATE camion SET numAsientos"+" = "+numAsientos +" WHERE matricula like '"+c.getMatricula()+"'");
				ps.executeUpdate();
				break;
			case 3:
				System.out.println("Introduce nueva cantidad de carga");
				int carga = Console.readInt();
				ps = this.c.prepareStatement("UPDATE camion SET carga"+" = "+carga +" WHERE matricula like '"+c.getMatricula()+"'");
				ps.executeUpdate();
				break;
			case 4:
				System.out.println("Introduce nuevo tipo de mercancia (General/Arido/Peligroso)");
				String tipoMerca = Console.readString();
				tipoMerca = tipoMerca.substring(0, 1);
				if(tipoMerca.equalsIgnoreCase("G") || tipoMerca.equalsIgnoreCase("P") || tipoMerca.equalsIgnoreCase("A")) {
					throw new SQLException("Error");
				}
				ps = this.c.prepareStatement("UPDATE camion SET tipoMercancia"+" = "+tipoMerca +" WHERE matricula like '"+c.getMatricula()+"'");
				ps.executeUpdate();
				break;
			default:
				System.out.println("No existe esa opción");
			}
			System.out.println("Modificación realizada");
		}catch(SQLException e){
			System.out.println("Error en la sentencia");
		}catch(NumberFormatException e) {
			System.out.println("no existe esa elección");
		}
	}
	
	public ArrayList<Vehiculo> ventasTotales(String fecha1,String fecha2) {
		ArrayList <Vehiculo> vehic = new ArrayList<Vehiculo>();
		Vehiculo vc;
		ResultSet rs = null;
		try {
			PreparedStatement ps = this.c.prepareCall("CALL consulta_ventas(?,?)");
			ps.setDate(1,java.sql.Date.valueOf(fecha1));
			ps.setDate(2,java.sql.Date.valueOf(fecha2));
			rs = ps.executeQuery();
			
			while(rs.next()) {
			vc = new Vehiculo(rs.getString(3),rs.getString(7),rs.getString(4),rs.getInt(8),rs.getDouble(9),rs.getInt(10));
			vehic.add(vc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehic;
	}
	
	public void repintadoCoche(Coche v) {
		ResultSet rs = null;
		try {
			PreparedStatement ps = this.c.prepareCall("CALL repintado(?)");
			ps.setString(1,v.getMatricula());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs!=null) {
					System.out.println("color viejo: "+ rs.getString(4)+", color nuevo: "+rs.getString(5));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void repintadoCamion(Camion v) {
		ResultSet rs = null;
		try {
			PreparedStatement ps = this.c.prepareCall("CALL repintado(?)");
			ps.setString(1,v.getMatricula());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs!=null) {
					System.out.println("color viejo: "+ rs.getString(4)+", color nuevo: "+rs.getString(5));
				}
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList <Vehiculo> comprobarColores(String color) {
		ResultSet rs = null;
		ArrayList <Vehiculo> vehic = new ArrayList<Vehiculo>();
		Vehiculo vc;
		try {
			PreparedStatement ps;
			ps = this.c.prepareCall("CALL buscar_color(?)");
			ps.setString(1,color);
			rs = ps.executeQuery();
			while(rs.next()) {
				vc = new Vehiculo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(6),rs.getDouble(4),rs.getInt(5));
				vehic.add(vc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehic;
	}
	
	public void exportarXML() {
		
		try {
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "C: && cd C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin && mysqldump --xml --skip-triggers -uroot -proot gestion_vehiculo coche camion serie > C:\\Users\\ik012982i9\\Desktop\\XML.xml");
	        builder.redirectErrorStream(true);
	        Process p;
			p = builder.start();
			System.out.println("XML creado correctamente");
		}catch (IOException e) {
			e.printStackTrace();
		} 
    }
}
