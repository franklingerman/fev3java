package org.mx.edu.um;

/**
 * @author set
 *   Nodo requerido para expresar la informaci�n del contribuyente emisor del comprobante. 
 */
public class Emisor {
	
	/**
	 * Atributo requerido para la Clave del Registro Federal de 
	 * Contribuyentes correspondiente al contribuyente emisor del
	 * comprobante SIN GUIONES O ESPACIOS. 
	 * REQUERIDO
	 */
	private T_Rfc rfc; 
	
	/**
	 * Atributo requerido para el nombre o raz�n social del 
	 * contribuyente emisor del comprobante.
	 * REQUERIDO 
	 */
	private String nombre;
	
	/**
	 * Nodo requerido para precisar la informaci�n de ubicaci�n del domicilio fiscal del 
	 * contribuyente emisor
	 * REQUERIDO 
	 */
	private DomicilioFiscal domicilioFiscal;
	
	/**
	 * Nodo opcional para precisar la informaci�n de ubicaci�n del domicilio en donde es emitido el 
	 * comprobante fiscal en caso de que sea distinto del domicilio fiscal del contribuyente emisor.
	 * OPCIONAL
	 * 
	 */
	private ExpedidoEn expedidoEn; 
	
	/**
	 * @return the rfc
	 */
	public T_Rfc getRfc() {
		return rfc;
	}
	public void setRfc(T_Rfc rfc) {
		this.rfc = rfc;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	
	/**
	 * @return the domicilioFiscal
	 */
	public DomicilioFiscal getDomicilioFiscal() {
		return domicilioFiscal;
	}
	public void setDomicilioFiscal(DomicilioFiscal domicilioFiscal) {
		this.domicilioFiscal = domicilioFiscal;
	}
	
	/**
	 * @return the expedidoEn
	 */
	public ExpedidoEn getExpedidoEn() {
		return expedidoEn;
	}
	public void setExpedidoEn(ExpedidoEn expedidoEn) {
		this.expedidoEn = expedidoEn;
	}
	
	/**
	 * Regresa la Cadena Original correspondiente a EMISOR.
	 * @return
	 * @throws UMException
	 */
	public String getCadenaOriginal() {
		String cadena = "";
		
		//Informacion del Nodo Emisor
		cadena += this.rfc.getCadenaOriginal() + "|" + nombre; 
		
		//Informacion del Nodo Domicilio Fiscal
		if(domicilioFiscal != null && !domicilioFiscal.getCadenaOriginal().equals("")){
			cadena += "|" + domicilioFiscal.getCadenaOriginal();
		}
		
		//Informacion del Nodo ExpedidoEn
		if(expedidoEn != null && !expedidoEn.getCadenaOriginal().equals("")){
			cadena += "|" + expedidoEn.getCadenaOriginal();
		}

		return cadena;
	}
	
}
