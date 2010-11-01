package org.mx.edu.um;

import java.math.BigDecimal;
import java.math.MathContext;


/**
 * Utilizado para expresar importes numericos con fraccion a 6 decimales
 * @author set
 *
 */
public class T_Importe {
	
	private BigDecimal importe;
	private MathContext mc= new MathContext(Constants.NUMERO_DECIMALES_IMPORTE);
	
	public T_Importe(String cantidad){
		importe = new BigDecimal(cantidad, mc);
	}
	
	/**
	 * @return the importe
	 */
	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	
}
	
	
