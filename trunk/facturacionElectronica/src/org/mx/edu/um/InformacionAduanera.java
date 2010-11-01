package org.mx.edu.um;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Nodo opcional para introducir la informaci�n aduanera aplicable cuando se trate de partes
 * o componentes importados vendidos de primera mano. 
 * @author set
 *
 */
public class InformacionAduanera extends ObjetoBase{
	
	/**
	 * Atributo  requerido  para  expresar  el  n�mero  del  documento
	 * aduanero que ampara la importaci�n del bien.
	 * REQUERIDO
	 * Longitud: 1 Min 
	 */
	private String numero;
	
	/**
	 * Atributo  requerido  para  expresar  la  fecha  de  expedici�n  del 
	 * documento aduanero que ampara la importaci�n del bien.
	 * REQUERIDO 
	 */
	private Date fecha;
	
	/**
	 * Atributo  requerido  para  precisar  la  aduana  por  la  que  se
	 * efectu� la importaci�n del bien.
	 * REQUERIDO 
	 */
	private String aduana;
	
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @return the aduana
	 */
	public String getAduana() {
		return aduana;
	}
	public void setAduana(String aduana) {
		this.aduana = aduana;
	}
	
	 /* Regresa la Cadena Original correspondiente a la Informacion Aduanera de un Concepto
	 * @return
	 */
	public String getCadenaOriginal(){
		String cadena = "";

		sdf = new SimpleDateFormat(Constants.DATE_FORMATO_CFDI); //para formatear la fecha

		cadena += numero + "|" + sdf.format(fecha) + "|" + aduana;

		return cadena;
	}
	

    public int compareTo(Object o) {
        if (!(o instanceof InformacionAduanera)) {
            return -1;
        }

        InformacionAduanera ia = (InformacionAduanera) o;
        return this.numero.compareTo(ia.numero);
    }
}
