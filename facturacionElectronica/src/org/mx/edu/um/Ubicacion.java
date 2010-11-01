package org.mx.edu.um;

/**
 * Este atributo opcional sirve para precisar la avenida, calle, camino 
 * o carretera donde se da la ubicaci�n. 
 * @author set
 *
 */
public abstract class Ubicacion {
	
	/**
	 * Este atributo opcional sirve para precisar la avenida, calle, 
	 * camino o carretera donde se da la ubicaci�n.
	 * OPCIONAL 
	 */
	protected String calle;
	
	/**
	 * Este atributo opcional sirve para expresar el n�mero particular
	 * en donde se da la ubicaci�n sobre una calle dada.
	 * OPCIONAL 
	 */
	protected String noExterior;
	
	/**
	 * Este atributo opcional sirve para expresar informaci�n adicional
	 * para especificar la ubicaci�n cuando calle y n�mero exterior
	 * (noExterior) no resulten suficientes para determinar la ubicaci�n
	 * de forma precisa.
	 * OPCIONAL 
	 */
	protected String noInterior;
	
	/**
	 * Este atributo opcional sirve para precisar la colonia en donde se
	 * da la ubicaci�n cuando se desea ser m�s espec�fico en casos
	 * de ubicaciones urbanas.
	 * OPCIONAL 
	 */
	protected String colonia;
	
	/**
	 * Atributo opcional que sirve para precisar la ciudad o poblaci�n 
	 * donde se da la ubicaci�n.
	 * OPCIONAL 
	 */
	protected String localidad;
	
	/**
	 * Atributo opcional para expresar una referencia de ubicaci�n
	 * adicional.
	 * OPCIONAL 
	 */
	protected String referencia;
	
	/**
	 * Atributo opcional que sirve para precisar el municipio o
	 * delegaci�n (en el caso del Distrito Federal) en donde se da la
	 * ubicaci�n.
	 * OPCIONAL 
	 */
	protected String municipio;
	
	/**
	 * Atributo opcional que sirve para precisar el estado o entidad
	 * federativa donde se da la ubicaci�n.
	 * OPCIONAL 
	 */
	protected String estado;
	
	/**
	 * Atributo requerido que sirve para precisar el pa�s donde se da la
	 * ubicaci�n.
	 * REQUERIDO 
	 */
	protected String pais;
	
	/**
	 * Atributo opcional que sirve para asentar el c�digo postal en
	 * donde se da la ubicaci�n.
	 * OPCIONAL 
	 */
	protected String codigoPostal;
	
	
	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	/**
	 * @return the noExterior
	 */
	public String getNoExterior() {
		return noExterior;
	}
	public void setNoExterior(String noExterior) {
		this.noExterior = noExterior;
	}
	
	/**
	 * return the noInterior
	 */
	public String getNoInterior() {
		return noInterior;
	}
	public void setNoInterior(String noInterior) {
		this.noInterior = noInterior;
	}
	
	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	
	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	/**
	 * Regresa la Cadena Original correspondiente a UBICACION (DOMICILIO FISCAL/EXPEDIDO EN/DOMICILIO).
	 * @return
	 */
	public String getCadenaOriginal(){
		String cadena = "";
		
		cadena = (calle != null ? calle +  "|": "") + (noExterior != null ? noExterior + "|" : "") +
		(noInterior != null ? noInterior + "|": "") + (colonia != null ? colonia + "|" : "") +
		(localidad != null ? localidad + "|" : "") + (referencia != null ? referencia + "|" : "") +
		(municipio != null ? municipio + "|" : "") + (estado != null ? estado + "|" : "") +
		(pais != null ? pais + "|" : "") + (codigoPostal != null ? codigoPostal : "");
		
		return cadena;
	}
}
