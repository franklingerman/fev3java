package org.mx.edu.um;

/**
 * Nodo para la informaci�n detallada de una retenci�n de impuesto espec�fico 
 * @author seth
 *
 */
public class Retencion implements Comparable<Retencion>{
	
	/**
	 * Atributo requerido para se�alar el tipo de impuesto retenido 
	 * REQUERIDO
	 * Valores: ISR, IVA
	 */
	private String impuesto; 
	
	/**
	 * Atributo requerido para se�alar el importe o monto del impuesto 
	 * retenido 
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
	 * Valores; ISR, IVA
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	/**
	 * @return the importe
	 */
	public T_Importe getImporte() {
		return importe;
	}
	/**
	 * 
	 * @param importe the importe to set
	 */
	public void setImporte(T_Importe importe) {
		this.importe = importe;
	}
	
	/**
	 * Regresa la Cadena Original V2 correspondiente a una Retencion
	 * NOTA: Si por alguna razon el importe fuera nulo, se devuelve un -1
	 * @return
	 */
	public String getCadenaOriginal() {
		String cadena = "";
		
		cadena += impuesto;
		
		if(importe != null){
			cadena += "|" + importe.getImporte().toString();
		}
		else{
			cadena += "|" + "-1.0";
		}
		
		return cadena;
	}
	

    public int compareTo(Retencion o) {
        if (!(o instanceof Retencion)) {
            return -1;
        }

        Retencion retencion = (Retencion) o;
        return this.getImporte().getImporte().compareTo(retencion.getImporte().getImporte());
    }
	
}
