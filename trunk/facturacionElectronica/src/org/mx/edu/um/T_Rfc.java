package org.mx.edu.um;

/**
 * Utilizado apra expresar RFC's. No debe llevar espacios ni guiones
 * @author set
 *
 */
public class T_Rfc {
	
	private String rfc;

	/**
	 * 
	 * @param rfc
	 */
	public T_Rfc(String rfc){
		this.rfc = rfc.toUpperCase().trim();
	}
	
	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	/**
	 * Regresa la Cadena Original correspondiente al RFC.
	 * @return
	 */
	public String getCadenaOriginal(){
		return this.rfc;
	}
}
