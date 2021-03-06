
package Concesionario;

/**
 *Clase que representa un vehiculo y todos sus datos
 * 
 * @version 1.0 06/04/2022
 * @author Andoni de la Iglesia & Eneko Huarte
 */
public class Vehiculo {

	private String matricula;
	private String numBastidor;
	private String color;
	private Serie serie;
	private double precio;
	private int numAsientos;
	/**
	 * Constructor de vehiculo
	 * 
	 * @param matricula sirve como identificador del vehiculo
	 * @param numBastidor cmomo la matricula sirve para identificar el vehiculo
	 * @param color el color de un vehiculo
	 * @param numSerie numero de serie al que pertenece el vehiculo
	 * @param precio precio del vehiculo
	 * @param numAsientos numero de asientos que tiene el vehiculo
	 */
	public Vehiculo(String matricula, String numBastidor, String color, int numSerie,double precio, int numAsientos) {
		this.matricula = matricula;
		this.numBastidor = numBastidor;
		this.color = color;
		this.serie = new Serie(numSerie);
		this.precio = precio;
		this.numAsientos = numAsientos;
	}
	/**
	 * Constructor de vehiculo
	 * 
	 * @param matricula sirve como identificador del vehiculo
	 * @param numBastidor cmomo la matricula sirve para identificar el vehiculo
	 * @param color el color de un vehiculo
	 * @param Serie Serie completa del vehiculo
	 * @param precio precio del vehiculo
	 * @param numAsientos numero de asientos que tiene el vehiculo
	 */
	public Vehiculo(String matricula, String numBastidor, String color, Serie serie, double precio, int numAsientos) {
		this.matricula = matricula;
		this.numBastidor = numBastidor;
		this.color = color;
		this.serie = serie;
		this.precio = precio;
		this.numAsientos = numAsientos;
	}

	@Override
	public String toString() {
		return " matricula=" + matricula + ", numBastidor=" + numBastidor + ", color=" + color + ", serie="
				+ serie.getNumSerie() + ", precio=" + precio + ", numAsientos=" + numAsientos;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNumBastidor() {
		return numBastidor;
	}

	public void setNumBastidor(String numBastidor) {
		this.numBastidor = numBastidor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}
	
	
}
