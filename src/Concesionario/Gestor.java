package Concesionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Gestor {

	Connection c;
	Coche coche;
	Camion camion;
	Serie serie;
	
	public Gestor(Connection cn) {
		this.c = cn;
	}
	
	public Gestor(Connection cn,Serie s) {
		this.c = cn;
		this.serie=s;
	}
	
	public Gestor (Connection cn, Coche ch) {
		this.c=cn;
		this.coche=ch;
	}
	
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
	
	public String  insertarSerie() throws SQLException{
		PreparedStatement ps = null;
		ps = c.prepareStatement("INSERT INTO serie(marca,modelo,anioFabric) VALUES(?,?,?)");
		ps.setString(1, this.serie.getMarca());
		ps.setString(2, this.serie.getModelo());
		ps.setInt(3, this.serie.getAnioFab());
		ps.close();
		if(ps.executeUpdate()!=1) {
			return "Error en la insercci�n";
		}
		return "Insercci�n realizada correctamente";
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
			return "Error en la insercci�n";
		}
		
		return "Coche a�adido correctamente";
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
			return "Error en la insercci�n";
		}
			
			return "Cami�n a�adido correctamente";
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
		Coche coche;
		try {
			stm = this.c.createStatement();
			rs = stm.executeQuery("SELECT * from coche where matricula like ("+"'"+matricula+"'"+")");
			
		}catch(SQLException e) {
			System.out.println("Error en la sentencia");
		}
		
		return null;
		}
	
}
