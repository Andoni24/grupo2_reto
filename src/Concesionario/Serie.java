
package Concesionario;
/**
 * Clase para representar la serie a la que pertenece un vehiculo determinado
 * por su marca modelo y aniofab
 * 
 * @version 1.0 06/04/2022
 * @author Andoni de la Iglesia & Eneko Huarte
 */
public class Serie {

	private int numSerie;
	private String marca;
	private String modelo;
	private int anioFab;
	
/** 
 * constructor vacio para instanciar una serie
 */
	public Serie() {
		
	}

/**
 * Constructor que crea una serie al completo
 * 
 * @param numSerie identificador de la serie 
 * @param marca Pequeña informacion de la serie
 * @param modelo Pequeña informacion de la serie
 * @param anioFab año en el que se ha fabricado
 */
	
	public Serie(int numSerie, String marca, String modelo, int anioFab) {
		super();
		this.numSerie = numSerie;
		this.marca = marca;
		this.modelo = modelo;
		this.anioFab = anioFab;
	}

/**
 *Constructor guarda el identificador de la serie
 * 
 * @param numSerie identificador de la serie 
 */

	public Serie(int numSerie) {
		super();
		this.numSerie = numSerie;
	}

/**
 * Constructo guarda todos los atributos menos el numero de serie
 * 
 * @param marca Pequeña informacion de la serie
 * @param modelo Pequeña informacion de la serie
 * @param anioFab año en el que se ha fabricado
 */

	public Serie(String marca, String modelo, int anioFab) {
		this.marca = marca;
		this.modelo = modelo;
		this.anioFab = anioFab;
	}

/**
 * 
 * @return devuelve el numero de serie
 */
	public int getNumSerie() {
		return numSerie;
	}
/**
 * 
 * @param numSerie identificador de la serie
 */

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}


/**
 * 
 * @return devuelve la marca de la serie
 */
	public String getMarca() {
		return marca;
	}

/**
 *  @param marca Pequeña informacion de la serie
 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
/**
 * 
 * @return devuelve el modelo de la serie
 */

	public String getModelo() {
		return modelo;
	}

/**
 * 
 * @param modelo Pequeña informacion de la serie
 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

/**
 * 
 * @return devuelve el año de fabricacion
 */
	public int getAnioFab() {
		return anioFab;
	}

/**
 * 
 * @param anioFab el año que se fabricó el vehiculo
 */
	public void setAnioFab(int anioFab) {
		this.anioFab = anioFab;
	}
/**
 * @return devuelve todos los datos de la serie
 */

	@Override
	public String toString() {
		return "Serie [marca=" + marca + ", modelo=" + modelo + ", anioFab=" + anioFab + "]";
	}
	
	
}
