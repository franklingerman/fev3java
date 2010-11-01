package org.mx.edu.um;


/**
 * Impuestos aplicables
 * @author set
 *
 */
public class Impuestos {
	
	/**
	 * Nodo opcional para capturar los impuestos retenidos aplicables 
	 * OPCIONAL
	 */
	private Retenciones retenciones; 
	
	/**
	 *  Nodo opcional para asentar o referir los impuestos trasladados aplicables 
	 *  OPCIONAL
	 */
	private Traslados traslados; 
	
	/**
	 * @return the retenciones
	 */
	public Retenciones getRetenciones() {
		return retenciones;
	}
	/**
	 * @param retenciones the retenciones to set
	 */
	public void setRetenciones(Retenciones retenciones) {
		this.retenciones = retenciones;
	}
	/**
	 * @return the traslados
	 */
	public Traslados getTraslados() {
		return traslados;
	}
	/**
	 * @param traslados the traslados to set
	 */
	public void setTraslados(Traslados traslados) {
		this.traslados = traslados;
	}
	
	/**
	 * Total de Impuestos Retenidos
	 * NOTA: Si por alguna razon la suma de los importes de las retenciones fuera nulo, se devuelve un -1
	 * @return
	 */
	public T_Importe getTotalImpuestosRetenidos(){
		return retenciones.getSumaImportesRetenciones();
	}
	
	/**
	 * Total Impuestos Trasladados
	 * NOTA: Si por alguna razon la suma de los importes de los traslados fuera nulo, se devuelve un -1
	 * @return
	 */
	public T_Importe getTotalImpuestosTrasladados(){
		return traslados.getSumaImportesTraslados();
	}
	
	/**
	 * Regresa la Cadena Original correspondiente a la lista de Retenciones, es decir la Cadena Original de TODAS las Retenciones
	 * @return
	 */
	public String getCadenaOriginalRetenciones(){
		return retenciones.getCadenaOriginal();
	}
	
	/**
	 * Regresa la Cadena Original correspondiente a la lista de Traslados, es decir la Cadena Original de TODOS los Traslados
	 * @return
	 */
	public String getCadenaOriginalTraslados(){
		return traslados.getCadenaOriginal();
	}
	
}
