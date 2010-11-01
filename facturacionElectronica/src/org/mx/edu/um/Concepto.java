package org.mx.edu.um;

import java.math.BigDecimal;


/**
 * Utilizado para introducir informacion detallada de un bien o servicio amparado por el Comprobante
 * @author set
 */
public class Concepto implements Comparable<Concepto>{
	
	/**
	 * Atributo  requerido  para  precisar  la  cantidad  de  bienes  o
	 * servicios del tipo particular definido por el presente concepto. 
	 * REQUERIDO
	 */
	private Double cantidad;
	
	/**
	 * Atributo  opcional  para  precisar  la  unidad  de  medida  aplicable
	 * para la cantidad expresada en el concepto.
	 * OPCIONAL 
	 */
	private String unidad;
	
	/**
	 * Atributo  opcional para  expresar el n�mero  de serie del  bien o
	 * identificador del servicio amparado por el presente concepto.
	 * OPCIONAL 
	 */
	private String noIdentificacion; 
	
	/**
	 * Atributo  requerido  para  precisar  la  descripci�n  del  bien  o
	 * servicio cubierto por el presente concepto.
	 * REQUERIDO 
	 */
	private String descripcion; 
	
	/**
	 * Atributo  requerido  para  precisar  el  valor  o  precio  unitario  del
	 * bien o servicio cubierto por el presente concepto.
	 * REQUERIDO 
	 */
	private T_Importe valorUnitario;
	
	//IMPORTE
	
	/**
	 * Nodo opcional para introducir la informaci�n aduanera aplicable cuando se trate de ventas
	 * de primera mano de mercanc�as importadas. 
	 * OPCIONAL
	 * Longitud: 0-Ilimitado elementos
	 */
	private InformacionAduanera informacionAduanera; 
	
	/**
	 *Nodo opcional para asentar el n�mero de cuenta predial con el que fue registrado el
	 *inmueble, en el sistema catastral de la entidad federativa de que trate. 
	 * OPCIONAL
	 */
	private CuentaPredial cuentaPredial;
	
	/**
	 * Nodo  opcional  donde  se  incluir�n  los  nodos  complementarios  de  extensi�n  al  concepto,
	 * definidos  por  el  SAT,  de  acuerdo  a  disposiciones  particulares  a  un  sector  o  actividad
	 * especifica. 
	 * OPCIONAL
	 */
	private ComplementoConcepto complementoConcepto;
	
	/**
	 * Nodo  opcional  para  expresar  las  partes  o  componentes  que  integran  la  totalidad  del
	 * concepto expresado en el comprobante fiscal digital por Internet 
	 * OPCIONAL
	 */
	private Parte parte; 
	
	/**
	 * @return the cantidad
	 */
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * @return the unidad
	 */
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
	/**
	 * @return the noIdentificacion
	 */
	public String getNoIdentificacion() {
		return noIdentificacion;
	}
	public void setNoIdentificacion(String noIdentificacion) {
		this.noIdentificacion = noIdentificacion;
	}
	
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @return the valorUnitario
	 */
	public T_Importe getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(T_Importe valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	/**
	 * Atributo requerido para precisar el importe total de los bienes o
	 * servicios  del  presente  concepto.  Debe  ser  equivalente  al
	 * resultado   de   multiplicar   la   cantidad   por   el   valor   unitario
	 * expresado en el concepto.
	 * REQUERIDO 
	 * NOTA: Si por alguna razon valorUnitario o cantidad fueran nulos, se devuelve un -1
	 * @return the importe = cantidad * valorUnitario
	 */
	public T_Importe getImporte() {
		T_Importe importe;
		
		if(valorUnitario != null && cantidad != null){
			importe = new T_Importe((valorUnitario.getImporte().multiply(new BigDecimal(cantidad.toString()))).toString());
		}
		else{
			importe = new T_Importe("-1.0");
		}
		
		return importe;
	}
	
	/**
	 * @return the cuentaPredial
	 */
	public CuentaPredial getCuentaPredial() {
		return cuentaPredial;
	}
	public void setCuentaPredial(CuentaPredial cuentaPredial) {
		this.cuentaPredial = cuentaPredial;
	}
	
	/**
	 * @return the informacionAduanera
	 */
	public InformacionAduanera getInformacionAduanera() {
		return informacionAduanera;
	}
	public void setInformacionAduanera(InformacionAduanera informacionAduanera) {
		this.informacionAduanera = informacionAduanera;
	}
	
	/**
	 * @return the complementoConcepto
	 */
	public ComplementoConcepto getComplementoConcepto() {
		return complementoConcepto;
	}
	public void setComplementoConcepto(ComplementoConcepto complementoConcepto) {
		this.complementoConcepto = complementoConcepto;
	}
	
	/**
	 * @return the parte
	 */
	public Parte getParte() {
		return parte;
	}
	public void setParte(Parte parte) {
		this.parte = parte;
	}
	
	/**
	 * Regresa la Cadena Original correspondiente a un Concepto
	 * NOTA: NOTA: Si por alguna razon valorUnitario o cantidad fueran nulos, se devuelve un -1
	 * @return
	 */
	public String getCadenaOriginal() {
		String cadena = "";
		
		//Informacion del Nodo Concepto
		cadena = (cantidad != null ? cantidad.toString() + "|": "-1.0") + (unidad != null ? unidad + "|": "") +
		(noIdentificacion != null ? noIdentificacion + "|" : "") + descripcion  + "|" +
		(valorUnitario != null ? valorUnitario.getImporte().toString() + "|" : "-1.0") + 
		 (getImporte() != null ? getImporte().getImporte().toString() : "-1.0");
		
		//Informacion del Nodo Informacion Aduanera
		if(informacionAduanera != null && !informacionAduanera.getCadenaOriginal().equals("")){
			cadena += "|" + informacionAduanera.getCadenaOriginal();
		}

		//Informacion del Nodo CuentaPredial
		if(cuentaPredial != null && !cuentaPredial.getCadenaOriginal().equals("")){
			cadena += "|" + cuentaPredial.getCadenaOriginal();
		}
		
		return cadena;
	}	

    public int compareTo(Concepto o) {
        if (!(o instanceof Concepto)) {
            return -1;
        }

        Concepto concepto = (Concepto) o;
        return this.getCantidad().compareTo(concepto.getCantidad());
    }
}
