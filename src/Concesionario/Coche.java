package Concesionario;

/**
 *Clase que representa un coche y todos sus datos que se extiende de vehiculo
 * 
 * @version 1.0 06/04/2022
 * @author Andoni de la Iglesia & Eneko Huarte
 */

public class Coche extends Vehiculo{
	
	private int capMaletero;
	private int numPuertas;
	
/**
 * Constructor de coche
 * 
 * @param matricula sirve como identificador del vehiculo
 * @param numBastidor cmomo la matricula sirve para identificar el vehiculo
 * @param color el color de un vehiculo	 
 * @param numSerie numero de serie al que pertenece el vehiculo	 
 * @param precio precio del vehiculo	
 * @param numAsientos numero de asientos que tiene el vehiculo
 * @param capMaletero capacidad del maletero
 * @param numPuertas numero de puertas
 */
	public Coche(String matricula, String numBastidor, String color,int numSerie, double precio, int numAsientos, int capMaletero,
			int numPuertas) {
		super(matricula, numBastidor, color,numSerie, precio, numAsientos);
		this.capMaletero = capMaletero;
		this.numPuertas = numPuertas;
	}
	
	public int getCapMaletero() {
		return capMaletero;
	}
	public void setCapMaletero(int capMaletero) {
		this.capMaletero = capMaletero;
	}
	public int getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	@Override
	public String toString() {
		return "Coche  "+super.toString()+", capMaletero=" + capMaletero + ", numPuertas=" + numPuertas;
	}

}
