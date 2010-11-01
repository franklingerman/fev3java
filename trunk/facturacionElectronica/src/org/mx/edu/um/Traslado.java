package org.mx.edu.um;


/**
 *   Nodo para la informaci�n detallada de un traslado de impuesto espec�fico 
 * @author set
 *
 */
public class Traslado implements Comparable<Traslado>{
	
	/**
	 * Atributo requerido para se�alar el tipo de impuesto trasladado
	 * Valores: IVA IEPS 
	 * REQUERIDO
	 */
	private String impuesto;
	
	/**
	 * Atributo  requerido  para  se�alar  la  tasa  del  impuesto  que  se 
	 * traslada por cada concepto amparado en el comprobante
	 * REQUERIDO 
	 */
	private T_Importe tasa;
	
	/**
	 * Atributo   requerido   para   se�alar   el   importe   del   impuesto
	 * trasladado
	 * REQUERIDO 
	 */
	private T_Importe importe;
	
	/**
	 * @return the impuesto
	 */
	public String getImpuesto() {
		return impuesto;
	}
	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	/**
	 * @return the tasa
	 */
	public T_Importe getTasa() {
		return tasa;
	}
	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(T_Importe tasa) {
		this.tasa = tasa;
	}
	/**
	 * @return the importe
	 */
	public T_Importe getImporte() {
		return importe;
	}
	/**
	 * @param importe the importe to set
	 */
	public void setImporte(T_Importe importe) {
		this.importe = importe;
	}
	
	/**
	 * Regresa la Cadena Original correspondiente a un Traslado
	 * @return
	 */
	public String getCadenaOriginal() {
		String cadena = "";
		
		cadena += impuesto;
		
		if(tasa != null){
			cadena += "|" + tasa.getImporte().toString(); 
		}
		
		if(importe != null){
			cadena += "|" + importe.getImporte().toString();
		}
		
		return cadena;
	}
	
    public int compareTo(Traslado o) {
        if (!(o instanceof Traslado)) {
            return -1;
        }

        Traslado traslado = (Traslado) o;
        return this.getImporte().getImporte().compareTo(traslado.getImporte().getImporte());
    }
	
}
