package org.mx.edu.um;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Total de impuestos retenidos que se desprenden de los conceptos expresados en el comprobante
 * @author set
 *
 */
public class Retenciones extends ArrayList<Retencion>{
	
	/**
	 * Lista de todas las Impuestos de Retenciones
	 */
	private List<Retencion> retenciones;
	
	/**
	 * Se usa para guardar la suma de los Importes de todos las Retenciones
	 */
	private BigDecimal sumaImportesRetenciones = new BigDecimal("0");
	
	/**
	 * Se usa para guardar la concatenacion de las cadenas originales de todas las retenciones
	 */
	private String cadenaOriginal = "";
	
	/**
	 * @return the retenciones
	 */
	public List<Retencion> getRetenciones() {
		return retenciones;
	}
	/**
	 * @param retenciones the retenciones to set
	 */
	public void setRetenciones(List<Retencion> retenciones) {
		this.retenciones = retenciones;
	}
	/**
	 * Regresa la suma de todos los Importes de todas las Retenciones
	 * NOTA: Si por alguna razon la suma de los Importes fuera nula, devuelve un -1
	 * @return the sumaImportesRetenciones
	 */
	public T_Importe getSumaImportesRetenciones() {
		if(sumaImportesRetenciones != null){
			return new T_Importe(sumaImportesRetenciones.toString());
		}
		else{
			return new T_Importe("-1.0");
		}
	}
	/**
	 * @param sumaImportesRetenciones the sumaImportesRetenciones to set
	 */
	public void setSumaImportesRetenciones(BigDecimal sumaImportesRetenciones) {
		this.sumaImportesRetenciones = sumaImportesRetenciones;
	}
	
	public boolean add(Retencion retencion){
		sumaImportesRetenciones = sumaImportesRetenciones.add(retencion.getImporte().getImporte());
		
		if(cadenaOriginal == null || cadenaOriginal.equals("")){
			cadenaOriginal += retencion.getCadenaOriginal();
		}
		else{
			cadenaOriginal += "|" + retencion.getCadenaOriginal();
		}
		
		return super.add(retencion);
	}
	
	/**
	 * Regresa la Cadena Original correspondiente a la lista de Retenciones, es decir la Cadena Original de TODOS las Retenciones
	 * NOTA: Si por alguna razon la suma de los importes de las retenciones fuera nulo, se devuelve un -1
	 * @return
	 */
	public String getCadenaOriginal(){
		String cadena = "";
		
		if(sumaImportesRetenciones != null){
			cadena = cadenaOriginal += "|" + sumaImportesRetenciones.toString();
		}
		else{
			cadena = cadenaOriginal + "|" + "-1.0";
		}
		return cadena;
	}
	
}
