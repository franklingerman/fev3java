package org.mx.edu.um;

import java.math.BigDecimal;

/**
 * Parte o componentes que integran la totalidad del Concepto expresado
 * @author set
 *
 */
public class Parte {
	
	private Integer cantidad; //Cantidad de bienes o servicios del tipo particular definido en la presente Parte
	private String unidad; //Unidad de medida aplicable para la cantidad expresada en la Parte
	private String noIdentificacion; //# de serie o identificador del bien o servicio amparado por la presente Parte
	private String descripcion; //Descripcion del bien o servicio cubierto por la presente Parte
	private T_Importe valorUnitario; //Valor unitario del bien o servicio cubierto por la presente Parte
	private InformacionAduanera informacionAduanera; //Informacion aduanera aplicable cuando se trate de ventas de mercancias importadas
	
	/**
	 * @return cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
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
	 * return the valorUnitario
	 */
	public T_Importe getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(T_Importe valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	/**
	 * @return the importe = cantidad * valorUnitario
	 */
	public T_Importe getImporte() {
		return new T_Importe((this.valorUnitario.getImporte().multiply(new BigDecimal(this.cantidad.toString()))).toString());
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
		
}
