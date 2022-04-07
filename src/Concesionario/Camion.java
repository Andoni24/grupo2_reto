package Concesionario;

/**
 *Clase que representa un coche y todos sus datos que se extiende de vehiculo
 * 
 * @version 1.0 06/04/2022
 * @author Andoni de la Iglesia & Eneko Huarte
 */
public class Camion extends Vehiculo{

		private int carga;
		private String tipoMercancia;

/**
 * Constructor de camion
 * 
 * @param matricula sirve como identificador del vehiculo
 * @param numBastidor cmomo la matricula sirve para identificar el vehiculo
 * @param color el color de un vehiculo	 
 * @param numSerie numero de serie al que pertenece el vehiculo	 
 * @param precio precio del vehiculo	
 * @param numAsientos numero de asientos que tiene el vehiculo
 * @param carga cantidad de carga que puede llevar
 * @param tipoMercancia que tipo de mercanica lleva
 */
		public Camion(String matricula, String numBastidor, String color, int numSerie,double precio, int numAsientos, int carga,
				String tipoMercancia) {
			super(matricula, numBastidor, color,numSerie, precio, numAsientos);
			this.carga = carga;
			this.tipoMercancia = tipoMercancia;
		}
		public int getCarga() {
			return carga;
		}

		public void setCarga(int carga) {
			this.carga = carga;
		}

		public String getTipoMercancia() {
			return tipoMercancia;
		}

		public void setTipoMercancia(String tipoMercancia) {
			this.tipoMercancia = tipoMercancia;
		}
		@Override
		public String toString() {
			return "Camion ["+super.toString()+" carga=" + carga + ", tipoMercancia=" + tipoMercancia + "]";
		}

}
