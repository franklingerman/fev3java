package org.mx.edu.um;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Contiene una lista con todos los Conceptos cubiertos por el Comprobante
 * @author set
 *
 */
public class Conceptos extends ArrayList<Concepto>{
	
	/**
	 *  Nodo requerido para enlistar los conceptos cubiertos por el comprobante.
	 *  REQUERIDO
	 *  Longitud: 1 - Ilimitado elementos
	 */
	List<Concepto> conceptos;
	
	/**
	 * Se usa para guardar la suma de los Importes de todos los Conceptos
	 */
	BigDecimal sumaImportesConceptos = new BigDecimal("0");
	
	/**
	 * Se usa para guardar la concatenacion de las cadenas originales de todos los conceptos
	 */
	String cadenaOriginal = "";
	
	/**
	 * @return the conceptos
	 */
	public List<Concepto> getConceptos() {
		return conceptos;
	}

	/**
	 * @param conceptos the conceptos to set
	 */
	public void setConceptos(List<Concepto> conceptos){
		this.conceptos = conceptos;
	}

	public boolean add(Concepto concepto) {
		sumaImportesConceptos = sumaImportesConceptos.add(concepto.getImporte().getImporte());
		if(cadenaOriginal == null || cadenaOriginal.equals("")){
			cadenaOriginal += concepto.getCadenaOriginal();
		}
		else{
			cadenaOriginal += "|" + concepto.getCadenaOriginal();
		}

		return super.add(concepto);
	}
	
	/**
	 * Regresa la Cadena Original correspondiente a la lista de Conceptos, es decir la Cadena Original de TODOS los Conceptos
	 * @return
	 */
	public String getCadenaOriginal(){
		return cadenaOriginal;
	}

	/**
	 * Si la suma de los importes de los conceptos es nula, se devuelve un -1
	 * @return the sumaImportesConceptos
	 */
	public T_Importe getSumaImportesConceptos() {
		if(sumaImportesConceptos != null){
			return new T_Importe(sumaImportesConceptos.toString());
		}
		else{
			return new T_Importe("-1.0");
		}
	}

	/**
	 * @param sumaImportesConceptos the sumaImportesConceptos to set
	 */
	public void setSumaImportesConceptos(BigDecimal sumaImportesConceptos) {
		this.sumaImportesConceptos = sumaImportesConceptos;
	}
}
