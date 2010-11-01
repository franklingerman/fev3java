package org.mx.edu.um;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author set
 * Estandar para la expresion de Comprobantes Fiscales Digitales por Internet (CFDI)
 */
public class Comprobante extends ObjetoBase{
    
	/**
	 * Atributo requerido con valor prefijado a 3.0 que indica la versi�n 
	 * del   est�ndar   bajo   el   que   se   encuentra   expresado   el
	 * comprobante. 
	 * REQUERIDO
	 * 	 */
	private String version=Constants.VERSION_COMPROBANTE_TRES;
	
	/**
	 * Atributo opcional para precisar la serie para control interno del 
	 * contribuyente.  Este  atributo  acepta  una  cadena  de  caracteres
	 * alfab�ticos   de   1   a   25   caracteres   sin   incluir   caracteres
	 * acentuados.
	 * OPCIONAL
	 * Longitud: 1-25 caracteres 
	 */
	private String serie;
	
	/**
	 * Atributo  opcional  para  control  interno  del  contribuyente  que 
	 * acepta  un  valor  num�rico  entero  superior  a  0  que  expresa  el
	 * folio del comprobante.
	 * OPCIONAL
	 * Longitud: 20 caracteres 
	 */
	private String folio;
	
	/**
	 * Atributo  requerido  para  la  expresi�n  de  la  fecha  y  hora  de 
	 * expedici�n  del  comprobante  fiscal.  Se  expresa  en  la  forma
	 * aaaa-mm-ddThh:mm:ss, de acuerdo con la especificaci�n ISO 8601. 
	 * REQUERIDO
	 */
	private Date fecha;
	
	/**
	 * Atributo    requerido    para    contener    el    sello    digital    del
	 * comprobante  fiscal,  al  que  hacen  referencia  las  reglas  de
	 * resoluci�n miscel�nea aplicable. El sello deber� ser expresado
	 * c�mo una cadena de texto en formato Base 64.
	 * REQUERIDO 
	 */
	private String sello;
	
	/**
	 * Atributo  requerido  para  precisar  la  forma  de  pago  que  aplica 
	 * para  elcomprobante  fiscal  digital  por  Internet.  Se  utiliza  para
	 * expresar Pago en una sola exhibici�n o n�mero de parcialidad
	 * pagada contra el total de parcialidades, Parcialidad 1 de X.  
	 * REQUERIDO
	 */
	private String formaDePago;
	
	/**
	 * Atributo  requerido  para  expresar  el  n�mero  de  serie  del 
	 * certificado  de  sello  digital  que  ampara  al  comprobante,  de
	 * acuerdo al acuse correspondiente a 20 posiciones otorgado por
	 * el sistema del SAT. 
	 * REQUERIDO
	 * Longitud: 20 caracteres
	 */
	private String noCertificado;
	
	/**
	 * Atributo  requerido  que  sirve  para  expresar  el  certificado  de 
	 * sello digital que ampara al comprobante como texto, en formato base 64.
	 * REQUERIDO 
	 */
	private String certificado;
	
	/**
	 * Atributo  opcional  para  expresar  las  condiciones  comerciales 
	 * aplicables  para  el  pago  del  comprobante  fiscal  digital  por Internet.
	 * OPCIONAL 
	 */
	private String condicionesDePago;
	
	/**
	 * 
	 */
	private Integer noAprobacion;
	
	/**
	 * 
	 */
	private Integer anoAprobacion;
	
	//SUBTOTAL
	
	/**
	 * Atributo  opcional  para  representar  el  importe  total  de  los 
	 * descuentos aplicables antes de impuestos. 
	 * OPCIONAL
	 */
	private T_Importe descuento;
	
	/**
	 * Atributo   opcional   para   expresar   el   motivo   del   descuento 
	 * aplicable.
	 * OPCIONAL 
	 */
	private String motivoDescuento;
	
	/**
	 * Atributo opcional para representar el tipo de cambio conforme a
	 * la moneda usada 
	 * OPCIONAL
	 */
	private String tipoDeCambio;
	
	/**
	 * Atributo  opcional  para  expresar  la  moneda  utilizada  para
	 * expresar los montos  
	 * OPCIONAL
	 */
	private String moneda;
	
	//TOTAL
	
	/**
	 * Atributo  opcional  de  texto  libre  para  expresar  el  m�todo  de 
	 * pago de los bienes o servicios amparados por el comprobante.
	 * Se  entiende  como  m�todo  de  pago  leyendas  tales  como:
	 * cheque, tarjeta de cr�dito o debito, dep�sito en cuenta, etc.
	 * OPCIONAL 
	 */
	private String metodoDePago;
	
	/**
	 * Atributo  requerido  para  expresar  el  efecto  del  comprobante
	 * fiscal para el contribuyente emisor.
	 * REQUERIDO 
	 */
	private String tipoDeComprobante;
	
	/**
	 *  Expresa la informaci�n del contribuyente emisor del comprobante.
	 *  REQUERIDO 
	 */
	private Emisor emisor;
	
	/**
	 *  Precisa la informaci�n del contribuyente receptor del comprobante. 
	 *  REQUERIDO
	 */
	private Receptor receptor;
	
	/**
	 *   Enlista los conceptos cubiertos por el comprobante.
	 *   REQUERIDO 
	 */
	private Conceptos conceptos;
	
	/**
	 *  Captura los impuestos aplicables.
	 *  REQUERIDO 
	 */
	private Impuestos impuestos;
	
	/**
	 *   Nodo  opcional  donde  se  incluir�  el  complemento  Timbre  Fiscal  Digital  de  manera 
	 *   obligatoria  y  los  nodos  complementarios  determinados  por  el  SAT,  de  acuerdo  a  las
	 *   disposiciones particulares a un sector o actividad especifica.  
	 *   OPCIONAL
	 */
	private Complemento complemento;
	
	/**
	 * Nodo  opcional  para  recibir  las  extensiones  al  presente  formato  que  sean  de  utilidad  al 
	 * contribuyente. Para las reglas de uso del mismo, referirse al formato de origen.
	 * OPCIONAL 
	 */
	private Addenda addenda;
	
	
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the sello
	 */
	public String getSello() {
		return sello;
	}

	/**
	 * @param sello the sello to set
	 */
	public void setSello(String sello) {
		this.sello = sello;
	}

	/**
	 * @return the formaDePago
	 */
	public String getFormaDePago() {
		return formaDePago;
	}

	/**
	 * @param formaDePago the formaDePago to set
	 */
	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	/**
	 * @return the noCertificado
	 */
	public String getNoCertificado() {
		return noCertificado;
	}

	/**
	 * @param noCertificado the noCertificado to set
	 */
	public void setNoCertificado(String noCertificado) {
		this.noCertificado = noCertificado;
	}

	/**
	 * @return the certificado
	 */
	public String getCertificado() {
		return certificado;
	}

	/**
	 * @param certificado the certificado to set
	 */
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	/**
	 * @return the condicionesDePago
	 */
	public String getCondicionesDePago() {
		if(condicionesDePago != null && !condicionesDePago.equals("")){
			return condicionesDePago;
		}
		else{
			return "";
		}
	}

	/**
	 * @param condicionesDePago the condicionesDePago to set
	 */
	public void setCondicionesDePago(String condicionesDePago) {
		this.condicionesDePago = condicionesDePago;
	}

	/**
	 * @return the noAprobacion
	 */
	public Integer getNoAprobacion() {
		return noAprobacion;
	}

	/**
	 * @param noAprobacion the noAprobacion to set
	 */
	public void setNoAprobacion(Integer noAprobacion) {
		this.noAprobacion = noAprobacion;
	}

	/**
	 * @return the anoAprobacion
	 */
	public Integer getAnoAprobacion() {
		return anoAprobacion;
	}

	/**
	 * @param anoAprobacion the anoAprobacion to set
	 */
	public void setAnoAprobacion(Integer anoAprobacion) {
		this.anoAprobacion = anoAprobacion;
	}

	/**
	 * @return the descuento
	 */
	public T_Importe getDescuento() {
		if(descuento != null && !descuento.equals("")){
			return descuento;
		}
		else{
			return new T_Importe("0.0");
		}
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(T_Importe descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the motivoDescuento
	 */
	public String getMotivoDescuento() {
		return motivoDescuento;
	}

	/**
	 * @param motivoDescuento the motivoDescuento to set
	 */
	public void setMotivoDescuento(String motivoDescuento) {
		this.motivoDescuento = motivoDescuento;
	}

	/**
	 * @return the tipoDeCambio
	 */
	public String getTipoDeCambio() {
		if(tipoDeCambio != null && !tipoDeCambio.equals("")){
			return tipoDeCambio;
		}
		else{
			return "";
		}
	}

	/**
	 * @param tipoDeCambio the tipoDeCambio to set
	 */
	public void setTipoDeCambio(String tipoDeCambio) {
		this.tipoDeCambio = tipoDeCambio;
	}

	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		if(moneda != null && !moneda.equals("")){
			return moneda;
		}
		else{
			return "";
		}
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	/**
	 * @return the metodoDePago
	 */
	public String getMetodoDePago() {
		return metodoDePago;
	}

	/**
	 * @param metodoDePago the metodoDePago to set
	 */
	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	/**
	 * @return the tipoDeComprobante
	 */
	public String getTipoDeComprobante() {
		return tipoDeComprobante;
	}

	/**
	 * @param tipoDeComprobante the tipoDeComprobante to set
	 */
	public void setTipoDeComprobante(String tipoDeComprobante) {
		this.tipoDeComprobante = tipoDeComprobante;
	}

	/**
	 * @return the emisor
	 */
	public Emisor getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}

	/**
	 * @return the receptor
	 */
	public Receptor getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	/**
	 * @return the conceptos
	 */
	public Conceptos getConceptos() {
		return conceptos;
	}

	/**
	 * @param conceptos the conceptos to set
	 */
	public void setConceptos(Conceptos conceptos) {
		this.conceptos = conceptos;
	}

	/**
	 * @return the impuestos
	 */
	public Impuestos getImpuestos() {
		return impuestos;
	}

	/**
	 * @param impuestos the impuestos to set
	 */
	public void setImpuestos(Impuestos impuestos) {
		this.impuestos = impuestos;
	}

	/**
	 * @return the complemento
	 */
	public Complemento getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(Complemento complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the addenda
	 */
	public Addenda getAddenda() {
		return addenda;
	}

	/**
	 * @param addenda the addenda to set
	 */
	public void setAddenda(Addenda addenda) {
		this.addenda = addenda;
	}

	/**
	 * Atributo  requerido  para  representar  la  suma  de  los  importes antes de descuentos e impuestos.
	 * NOTA� Si por alguna razon la suma de los Importes de los Conceptos es nula, se devuelve un -1
	 * REQUERIDO 
	 * @return the subTotal = Suma de los Importes, antes de Descuentos e Impuestos
	 */
	public T_Importe getSubtotal() {
		return new T_Importe(conceptos.getSumaImportesConceptos().getImporte().toString());
	}
	
	/**
	 * Atributo  requerido  para  representar  la  suma  del  subtotal, 
	 * menos    los    descuentos    aplicables,    m�s    los    impuestos
	 * trasladados, menos los impuestos retenidos.
	 * NOTA: En dado caso de que los descuentos aplicables, o algun impuesto sean nulos, se devuelve un -1
	 * REQUERIDO 
	 * NOTA: Si el resultado es negativo, es que alguno de los valores de subtotal, descuento, impuesto o impuesto retenido son nulos
	 * @return the total = Suma de Subtotal - Descuentos_Aplicables + Impuestos_Trasladados - Impuestos_Retenidos
	 */
	public T_Importe getTotal() {
	T_Importe subtotal = getSubtotal() != null ? getSubtotal() : new T_Importe("0");
	T_Importe descuentosAlicables = getDescuento() != null ? getDescuento() : new T_Importe("0");
	T_Importe impuestosRetenidos = getImpuestos() != null ? getImpuestos().getTotalImpuestosRetenidos() : new T_Importe("0");
	T_Importe impuestosTrasladados = getImpuestos() != null ? getImpuestos().getTotalImpuestosTrasladados() : new T_Importe("0");
	
	return new T_Importe(subtotal.getImporte().subtract(descuentosAlicables.getImporte()).add(impuestosTrasladados.getImporte()).subtract(impuestosRetenidos.getImporte()).toString());
	}
	
	/**
	 * Regresa la Cadena Original del Comprobante
	 * En caso de que ocurran errores al generar alguna cadena original de alguno de los nodos internos, se desplegaran los mensajes
	 * @return
	 */
	public String getCadenaOriginal(){
		String cadena = "||"; //inicio de la cadena original
                sdf = new SimpleDateFormat(Constants.DATE_FORMATO_CFDI); //para formatear la fecha
		
		//Informacion del Nodo Comprobante
		//cadena += version + "|" + fecha.toString() + "|" + tipoDeComprobante + "|" + formaDePago + "|"  +
                cadena += version + "|" + sdf.format(fecha) + "|" + tipoDeComprobante + "|" + formaDePago + "|"  +
		(!getCondicionesDePago().equals("") ? condicionesDePago + "|" : "" ) +
		getSubtotal().getImporte().toString() + "|" + 
		(!getDescuento().getImporte().toString().equals("0.0") ? getDescuento().getImporte().toString() + "|" : "") + 
		(!getTipoDeCambio().equals("") ? getTipoDeCambio()  + "|" : "") + (!getMoneda().equals("") ? getMoneda()  + "|" : "") +
		getTotal().getImporte().toString()+ "|";
		
		//Informacion del Nodo Emisor (Domicilio Fiscal, ExpedidoEn)
		cadena += emisor.getCadenaOriginal() + "|";
		
		//Informacion del Nodo Receptor (Domicilio)
		cadena += receptor.getCadenaOriginal() + "|";
		
		//Informacion del Nodo Conceptos
		cadena += conceptos.getCadenaOriginal() + "|";
		
		//Informacion del Nodo Impuestos
		//Informacion del Nodo Retenciones
		cadena += impuestos.getRetenciones().getCadenaOriginal() + "|";
		//Informacion del Nodo Traslados
		cadena += impuestos.getCadenaOriginalTraslados();
		
                //Informacion del Nodo Complemento
		//Informacion del Timbre Fiscal
		//cadena += complemento.getCadenaOriginal();

		cadena += "||";

		try{
			cadena = new String(cadena.getBytes("UTF-8")); //Codificacion de la Cadena a UTF-8
		}
		catch(UnsupportedEncodingException uee){
			System.out.println("Error al codificar la cadena a UTF-8");
		}

		return cadena;
	}

}