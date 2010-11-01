package org.mx.edu.um;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Total de impuestos trasladados que se desprenden de los conceptos expresados en el comprobante
 * @author seth
 *
 */
public class Traslados extends ArrayList<Traslado>{
	
	/**
	 * Lista de todos los Impuestos de Traslados
	 */
	private List<Traslado> traslados;
	
	/**
	 * Se usa para guardar la suma de los Importes de todos los Traslados
	 */
	private BigDecimal sumaImportesTraslados = new BigDecimal("0");
	
	/**
	 * Se usa para guardar la concatenacion de las cadenas originales de todos los traslados
	 */
	private String cadenaOriginal = "";
	
	/**
	 * @return the traslados
	 */
	public List<Traslado> getTraslados() {
		return traslados;
	}
	/**
	 * @param traslados the traslados to set
	 */
	public void setTraslados(List<Traslado> traslados) {
		this.traslados = traslados;
	}
	/**
	 * Regresa la suma de todos los Importes de todos los Traslados
	 * NOTA: Si por alguna razon la suma de los Importes fuera nula, devuelve un -1
	 * @return the sumaImportesTraslados
	 */
	public T_Importe getSumaImportesTraslados() {
		if(sumaImportesTraslados != null){
			return new T_Importe(sumaImportesTraslados.toString());
		}
		else{
			return new T_Importe("-1.0");
		}
	}
	
	/**
	 * @param sumaImportesTraslados the sumaImportesTraslados to set
	 */
	public void setSumaImportesTraslados(BigDecimal sumaImportesTraslados) {
		this.sumaImportesTraslados = sumaImportesTraslados;
	}
	
	public boolean add(Traslado traslado){
		sumaImportesTraslados = sumaImportesTraslados.add(traslado.getImporte().getImporte());
		
		if(cadenaOriginal == null || cadenaOriginal.equals("")){
			cadenaOriginal += traslado.getCadenaOriginal();
		}
		else{
			cadenaOriginal += "|" + traslado.getCadenaOriginal();
		}
		
		return super.add(traslado);
	}
	
	/**
	 * Regresa la Cadena Original correspondiente a la lista de Traslados, es decir la Cadena Original de TODOS los Traslados
	 * NOTA: Si por alguna razon la suma de los importes de los traslados fuera nulo, se devuelve un -1
	 * @return
	 */
	public String getCadenaOriginal(){
		String cadena = "";
		
		if(sumaImportesTraslados != null){
			cadena = cadenaOriginal += "|" + sumaImportesTraslados.toString();
		}
		else{
			cadena = cadenaOriginal + "|" + "-1.0";
		}
		
		return cadena;
	}
}
