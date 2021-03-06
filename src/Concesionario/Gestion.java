package Concesionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Gestion {

	public static int comprobarSerie(Serie s,Connection c) throws SQLException {

		Gestor gs = new Gestor(c,s);;
		boolean existe = false;
		int numSerie = 0;
		
		existe = gs.verificarSerie();
		
		
		if(!existe) {
			System.out.println(gs.insertarSerie());
		}

		numSerie = gs.selectNumSerie();
		return numSerie;
			
	}
	
	public static ArrayList<Coche> cochesStock(Connection c) throws SQLException {
		
		ResultSet rs = null;
		ArrayList <Coche> vehic = new ArrayList<Coche>();
		Coche coche;
		Gestor gs = new Gestor (c);
		
		rs = gs.selectCoche();
		while(rs.next()) {
			coche = new Coche(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getInt(6),rs.getInt(7), rs.getInt(8));
			vehic.add(coche);
		}
		rs.close();
		return vehic;
	}
	
	public static ArrayList<Camion> camionesStock(Connection c) throws SQLException {
		
		ResultSet rs = null;
		ArrayList <Camion> vehic = new ArrayList<Camion>();
		Camion camion;
		Gestor gs = new Gestor(c);
		
		rs = gs.selectCamion();
		while(rs.next()) {
			camion = new Camion(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(8),rs.getDouble(4),rs.getInt(5),rs.getInt(6), rs.getString(7));
			vehic.add(camion);
		}
		return vehic;
	}
	
private static void importarCamion(Connection cn) throws SQLException{
		
		Camion camion;
		Gestor gst = new Gestor(cn);
	
		System.out.println("Introduce la matricula");
		String matricula = Console.readString();
		System.out.println("Introduce el n?mero de Bastidor");
		String numBastidor = Console.readString();
		System.out.println("Introduce el color");
		String color = Console.readString();
		System.out.println("Introduce la marca del vehiculo");
		String marca = Console.readString();
		System.out.println("Introduce el modelo");
		String modelo = Console.readString();
		System.out.println("Introduce el a?o de fabricaci?n");
		int anioFab = Console.readInt();
		System.out.println("Introduce el precio");
		double precio = Console.readDouble();
		System.out.println("Introduce el n?mero de asientos");
		int numAsientos = Console.readInt();
		System.out.println("Cantidad de carga");
		int carga = Console.readInt();
		System.out.println("Tipo mercancia (General/Arido/Peligroso)");
		String tipoMercancia = Console.readString();
		tipoMercancia = tipoMercancia.substring(0,1).toUpperCase();
		
		Serie serie = new Serie(marca,modelo,anioFab);
		int numSerie = comprobarSerie(serie,cn);
		camion = new Camion(matricula,numBastidor,color,numSerie,precio,numAsientos,carga,tipoMercancia);
		System.out.println(gst.insertCamion(camion));
		
		
	}

	private static void importarCoche(Connection cn) throws SQLException{
		
		Coche coche;
		Gestor gst = new Gestor(cn);
	
		System.out.println("Introduce la matricula");
		String matricula = Console.readString();
		System.out.println("Introduce el n?mero de Bastidor");
		String numBastidor = Console.readString();
		System.out.println("Introduce el color");
		String color = Console.readString();
		System.out.println("Introduce la marca del vehiculo");
		String marca = Console.readString();
		System.out.println("Introduce el modelo");
		String modelo = Console.readString();
		System.out.println("Introduce el a?o de fabricaci?n");
		int anioFab = Console.readInt();
		System.out.println("Introduce el precio");
		double precio = Console.readDouble();
		System.out.println("Introduce el n?mero de asientos");
		int numAsientos = Console.readInt();
		System.out.println("NumPuertas");
		int numPuertas = Console.readInt();
		System.out.println("capMaletero");
		int capMaletero = Console.readInt();
		
		Serie serie = new Serie(marca,modelo,anioFab);
		int numSerie = comprobarSerie(serie,cn);
		coche = new Coche(matricula,numBastidor,color,numSerie,precio,numAsientos,capMaletero,numPuertas);
		System.out.println(gst.insertCoche(coche));
		
		
	}
	
	private static void venderCamion(Connection cn) throws SQLException {
		ArrayList<Camion> camiones = new ArrayList<Camion>();
		Gestor gs = new Gestor(cn);
		camiones = camionesStock(cn);
		String matric;
		
		for(Camion i: camiones) {
			System.out.println(i.toString());
			System.out.println();
		}
		System.out.println("Introduzca la matricula del coche que quiere vender");
		matric = Console.readString();
		System.out.println(gs.eliminarCamion(matric));
		
		}
		

	private static void venderCoche(Connection cn) throws SQLException{
		
		ArrayList<Coche> coches = new ArrayList<Coche>();
		Gestor gs = new Gestor(cn);
		coches = cochesStock(cn);
		String matric;
		
		for(Coche i: coches) {
			System.out.println(i.toString());
			System.out.println();
		}
		System.out.println("Introduzca la matricula del coche que quiere vender");
		matric = Console.readString();
		System.out.println(gs.eliminarCoche(matric));
	}
	
	public static void modificarCoche(Connection c) throws SQLException{
		try {
			ArrayList <Coche> coches = new ArrayList<Coche>();
			coches = cochesStock(c);
			String matricula;
			int modificacion;
			Coche cocheMod;
			Gestor gs = new Gestor(c);
			for(Coche i: coches) {
				System.out.println(i.toString());
				System.out.println();
			}
			System.out.println("Introduzca la matricula del coche que desea modificar");
			matricula = Console.readString();
			cocheMod = gs.elegirCoche(matricula);
			System.out.println();
			System.out.println("Coche Seleccionado");
			System.out.println(cocheMod.toString());
			System.out.println("Introduzca el numero del apartado que desea modificar");
			System.out.println("1. precio");
			System.out.println("2. Numero de asientos");
			System.out.println("3. Capacidad de maletero");
			System.out.println("4. Numero de puertas");
			modificacion = Console.readInt();
			gs.AlterarCoche(modificacion, cocheMod);
		}catch(NullPointerException e) {
			System.out.println("No existe el vehiculo");
		}catch(NumberFormatException e) {
			System.out.println("Opci?n no v?lida");
		}
		
	}
	
	public static void modificarCamion(Connection c) throws SQLException{
		try {
			ArrayList <Camion> camiones = new ArrayList<Camion>();
			camiones = camionesStock(c);
			String matricula;
			int modificacion;
			Camion camionMod;
			Gestor gs = new Gestor(c);
			for(Camion i: camiones) {
				System.out.println(i.toString());
				System.out.println();
			}
			System.out.println("Introduzca la matricula del coche que desea modificar");
			matricula = Console.readString();
			camionMod = gs.elegirCamion(matricula);
			System.out.println();
			System.out.println("Coche Seleccionado");
			System.out.println(camionMod.toString());
			System.out.println("Introduzca el numero del apartado que desea modificar");
			System.out.println("1. precio");
			System.out.println("2. Numero de asientos");
			System.out.println("3. Cantidad de carga");
			System.out.println("4. Tipo de mercancia");
			modificacion = Console.readInt();
			gs.AlterarCamion(modificacion, camionMod);
		}catch(NullPointerException e) {
			System.out.println("No existe el vehiculo");
		}catch(NumberFormatException e) {
			System.out.println("Opci?n no v?lida");
		}
		
	}
	
	public static void pintarCoche(Connection c) {
		try {
			ArrayList <Coche> coches = new ArrayList<Coche>();
			coches = cochesStock(c);
			String matricula;
			Coche cocheMod;
			String colorNue;
			Gestor gs = new Gestor(c);
			for(Coche i: coches) {
				System.out.println(i.toString());
				System.out.println();
			}
			System.out.println("Introduzca la matricula del coche que desea modificar");
			matricula = Console.readString();
			cocheMod = gs.elegirCoche(matricula);
			System.out.println("Introduzca el nuevo color");
			colorNue = Console.readString();
			gs.pintarCoche(colorNue, cocheMod);
			
		}catch(NullPointerException e) {
			System.out.println("No existe el vehiculo");
		}catch(SQLException e) {
			System.out.println("Opci?n no v?lida");
		}
	}
	
	public static void pintarCamion(Connection c) {
		try {
			ArrayList <Camion> camiones = new ArrayList<Camion>();
			camiones = camionesStock(c);
			String matricula;
			Camion camionMod;
			String colorNue;
			Gestor gs = new Gestor(c);
			for(Camion i: camiones) {
				System.out.println(i.toString());
				System.out.println();
			}
			System.out.println("Introduzca la matricula del coche que desea modificar");
			matricula = Console.readString();
			camionMod = gs.elegirCamion(matricula);
			System.out.println("Introduzca el nuevo color");
			colorNue = Console.readString();
			gs.pintarCamion(colorNue, camionMod);
			
		}catch(NullPointerException e) {
			System.out.println("No existe el vehiculo");
		}catch(SQLException e) {
			System.out.println("Opci?n no v?lida");
		}
	}
	
	public static void ventas(Connection c) {
		
		String fechaInicio;
		String fechaFin;
		ArrayList <Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Gestor gs = new Gestor(c);
		
		
		try {
		System.out.println("Introduce una fecha (YYYY-MM-DD)");
		fechaInicio = Console.readString();
		System.out.println("Introduce otra fecha(YYYY-MM-DD)");
		fechaFin = Console.readString();
	

		
		vehiculos = gs.ventasTotales(fechaInicio,fechaFin);
		
		for(Vehiculo i: vehiculos) {
			System.out.println(i.toString());
			System.out.println("---------------------------");
		}
		
		}catch(NumberFormatException e) {
			System.out.println("Error");
		}	
	}
	
	public static void verRepintadoCoche(Connection c) {
		ArrayList <Coche> coches = new ArrayList<Coche>();
		String matricula;
		Coche vehiculo;
		Gestor gs = new Gestor(c);
		
		try {
		coches = cochesStock(c);
		for(Coche i : coches) {
			System.out.println(i.toString());
			System.out.println();
		}
		System.out.println("Introduce una matricula");
		matricula = Console.readString();
		vehiculo = gs.elegirCoche(matricula);
		gs.repintadoCoche(vehiculo);
		
		}catch(NumberFormatException e) {
			System.out.println("Error");
		}catch(NullPointerException e) {
			System.out.println("El coche no existe");
		}catch(SQLException e) {
			System.out.println("error");
		}
	}
	
	public static void verRepintadoCamion(Connection c) {
	
		ArrayList <Camion> camiones = new ArrayList<Camion>();
		String matricula;
		Camion vehiculo;
		Gestor gs = new Gestor(c);
		
		try {
		camiones = camionesStock(c);
		
		for(Camion i: camiones) {
			System.out.println(i.toString());
			System.out.println();
		}
		
		System.out.println("Introduce una matricula");
		matricula = Console.readString();
		vehiculo = gs.elegirCamion(matricula);
		gs.repintadoCamion(vehiculo);
		
		}catch(NumberFormatException e) {
			System.out.println("Error");
		}catch(NullPointerException e) {
			System.out.println("El camion no existe");
		}catch(SQLException e) {
			System.out.println("error");
		}
	}

	public static void verColores(Connection c) {
		
		ArrayList <Vehiculo> vehic = new ArrayList<Vehiculo>();
		System.out.println("Introduce un color");
		String color = Console.readString();
		Gestor gs = new Gestor(c);
		vehic = gs.comprobarColores(color);
		
		for(Vehiculo i : vehic) {
			System.out.println(i.toString());
		}
	}
	public static void crearXML(Connection c) {
		Gestor gs = new Gestor(c);
		gs.exportarXML();
	}
	
	public static void main(String[] args)  {
	
		Conexion conexion = new Conexion(); 
		Connection cn = conexion.conectar();
		System.out.println("Bienvenido");
		int elec = 1;
		ArrayList<Coche> coches = new ArrayList<Coche>();
		ArrayList<Camion> camiones = new ArrayList<Camion>();

		
		do {
			try {
				System.out.println();
				System.out.println("Elija una opcion");
				System.out.println("1. Visualizar vehiculos");
				System.out.println("2. Adquirir vehiculo");
				System.out.println("3. Vender vehiculo");
				System.out.println("4. Pintar vehiculo");
				System.out.println("5. Modificar datos del vehiculo");
				System.out.println("6. Ver repintado");
				System.out.println("7. Consultar ventas");
				System.out.println("8. Ver vehiculos del mismo color");
				System.out.println("9. Exportar XML");
				System.out.println("10. Salir");
				System.out.println();
				
				elec = Console.readInt();
				
				switch(elec) {
				case 1:
					try {
						System.out.println();
						coches = cochesStock(cn);
						System.out.println("Coches Stock");
						System.out.println();
						for(Coche i : coches) {
							System.out.println(i.toString());
							System.out.println("---------------");
						}
						System.out.println();
						
						camiones = camionesStock(cn);
						System.out.println("Camiones Stock");
						System.out.println();
						for(Camion i : camiones) {
							System.out.println(i.toString());
							System.out.println("---------------");
						}
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("ERROR");
					}
					break;
				case 2:
					try {
						System.out.println("quieres a?adir un coche o un camion?");
						String respuesta = Console.readString();
						
						if (respuesta.equalsIgnoreCase("coche")) {
							importarCoche(cn);
				
						}else if (respuesta.equalsIgnoreCase("camion")){
							importarCamion(cn);
				
						}else {
							throw new VehiculoException("No se ha establecido bien el tipo de vehiculo");
						}
					}catch(VehiculoException e){
						System.out.println(e.getMessage());
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}catch(NumberFormatException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					try {
						System.out.println("quieres vender un coche o un camion?");
						String respuesta = Console.readString();
						
						if (respuesta.equalsIgnoreCase("coche")) {
							venderCoche(cn);
						
						}else if (respuesta.equalsIgnoreCase("camion")){
							venderCamion(cn);
						}else {
							throw new VehiculoException("No se ha establecido bien el tipo de vehiculo");
						}
					}catch(VehiculoException e){
						System.out.println(e.getMessage());
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}catch(NumberFormatException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					try {
						System.out.println("Desea pintar un coche o un camion?");
						String respuesta = Console.readString();
						
						if (respuesta.equalsIgnoreCase("coche")) {
							pintarCoche(cn);
						}else if (respuesta.equalsIgnoreCase("camion")){
							pintarCamion(cn);
						}else {
							throw new VehiculoException("No se ha establecido bien el tipo de vehiculo");
						}
						System.out.println("Vehiculo pintado");
					}catch(VehiculoException e){
						System.out.println(e.getMessage());
					}catch(NumberFormatException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					try {
						System.out.println("quieres modificar un coche o un camion?");
						String respuesta = Console.readString();
						
						if (respuesta.equalsIgnoreCase("coche")) {
							modificarCoche(cn);
						}else if (respuesta.equalsIgnoreCase("camion")){
							modificarCamion(cn);
						}else {
							throw new VehiculoException("No se ha establecido bien el tipo de vehiculo");
						}
				}catch(VehiculoException e){
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}catch(NumberFormatException e) {
					System.out.println(e.getMessage());
				}
					break;
				case 6:
					try {
					System.out.println("quieres ver un coche o un camion?");
					String respuesta = Console.readString();
					
					if (respuesta.equalsIgnoreCase("coche")) {
						verRepintadoCoche(cn);
					
					}else if (respuesta.equalsIgnoreCase("camion")){
						verRepintadoCamion(cn);
					}else {
						throw new VehiculoException("No se ha establecido bien el tipo de vehiculo");
					}
					}catch(VehiculoException e){
						System.out.println(e.getMessage());
					}
					break;
				case 7:
					ventas(cn);
					break;
				case 8:
					verColores(cn);
					break;
				case 9:
					crearXML(cn);
					break;
				case 10:
					System.out.println("PROGRAMA FINALIZADO");
					break;
				default:
					System.out.println("Elecci?n no valida");
				}
			}catch(NumberFormatException e) {
				System.out.println("Eleccion no v?lida");
			}
			
		
		}while(elec!=10);
	}


	
}
