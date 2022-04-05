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
		rs.close();
		return vehic;
	}
	
private static void importarCamion(Connection cn) throws SQLException{
		
		Camion camion;
		Gestor gst = new Gestor(cn);
	
		System.out.println("Introduce la matricula");
		String matricula = Console.readString();
		System.out.println("Introduce el número de Bastidor");
		String numBastidor = Console.readString();
		System.out.println("Introduce el color");
		String color = Console.readString();
		System.out.println("Introduce la marca del vehiculo");
		String marca = Console.readString();
		System.out.println("Introduce el modelo");
		String modelo = Console.readString();
		System.out.println("Introduce el año de fabricación");
		int anioFab = Console.readInt();
		System.out.println("Introduce el precio");
		double precio = Console.readDouble();
		System.out.println("Introduce el número de asientos");
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

	private static void inportarCoche(Connection cn) throws SQLException{
		
		Coche coche;
		Gestor gst = new Gestor(cn);
	
		System.out.println("Introduce la matricula");
		String matricula = Console.readString();
		System.out.println("Introduce el número de Bastidor");
		String numBastidor = Console.readString();
		System.out.println("Introduce el color");
		String color = Console.readString();
		System.out.println("Introduce la marca del vehiculo");
		String marca = Console.readString();
		System.out.println("Introduce el modelo");
		String modelo = Console.readString();
		System.out.println("Introduce el año de fabricación");
		int anioFab = Console.readInt();
		System.out.println("Introduce el precio");
		double precio = Console.readDouble();
		System.out.println("Introduce el número de asientos");
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
				System.out.println("4. Modificar datos del vehiculo");
				System.out.println("5. Ver repintado");
				System.out.println("6. Consultar ventas");
				System.out.println("7. Salir");
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
						System.out.println("quieres añadir un coche o un camion?");
						String respuesta = Console.readString();
						
						if (respuesta.equalsIgnoreCase("coche")) {
							inportarCoche(cn);
				
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
	
					break;
				case 4:

					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				default:
					System.out.println("Elección no valida");
				}
			}catch(NumberFormatException e) {
				System.out.println("Eleccion no válida");
			}
			
		
		}while(elec!=7);
	}


	
}
