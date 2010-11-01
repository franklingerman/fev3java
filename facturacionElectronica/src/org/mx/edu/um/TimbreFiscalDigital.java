package org.mx.edu.um;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Complemento  requerido  para  el  Timbrado  Fiscal  Digital  del  SAT  que  da  validez  a  un 
 * Comprobante Fiscal Digital por Internet. 
 * REQUERIDO
 * @author set
 * 
 */
public class TimbreFiscalDigital extends ObjetoBase{

    /**
     * Atributo requerido para la expresi�n de la version del estandar del Timbre Fiscal Digital
     * Valor: 1.0
     * REQUERIDO
     */
    private String version = Constants.VERSION_TIMBRE_FISCAL;
    /**
     * Atributo requerido para expresar los 36 caracteres del UUID de
     * la transacci�n de timbrado conforme al est�ndar (RFC) 4122
     * Longitud: 36 caracteres
     * Patron: [a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}
     * REQUERIDO
     */
    private String uuid;
    /**
     * Atributo   requerido   para   expresar   la   fecha   y   hora   de   la
     * generaci�n   del   timbre   por   la   certificaci�n   digital   del   SAT
     * conforme con la especificaci�n ISO 8601.
     * REQUERIDO
     */
    private Date fechaTimbrado;
    /**
     * Atributo requerido para contener el sello digital del comprobante
     * fiscal,  que  ser�  timbrado.  El  sello  deber�  ser  expresado  como
     * una cadena de texto en formato Base 64.
     * REQUERIDO
     */
    private String selloCFD;
    /**
     * Atributo   requerido   para   expresar   el   n�mero   de   serie   del
     * certificado del SAT usado para el Timbre
     * Longitud: 20 caracteres
     * REQUERIDO
     */
    private String noCertificadoSAT;
    /**
     * Atributo requerido para contener el sello digital del Timbre Fiscal
     * Digital,  al  que  hacen  referencia  las  reglas  de  Resoluci�n
     * Miscel�nea aplicable. El sello deber� ser expresado como una
     * cadena de texto en formato Base 64.
     * REQUERIDO
     */
    private String selloSAT;

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
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the fechaTimbrado
     */
    public Date getFechaTimbrado() {
        return fechaTimbrado;
    }

    /**
     * @param fechaTimbrado the fechaTimbrado to set
     */
    public void setFechaTimbrado(Date fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    /**
     * @return the selloCFD
     */
    public String getSelloCFD() {
        return selloCFD;
    }

    /**
     * @param selloCFD the selloCFD to set
     */
    public void setSelloCFD(String selloCFD) {
        this.selloCFD = selloCFD;
    }

    /**
     * @return the noCertificadoSAT
     */
    public String getNoCertificadoSAT() {
        return noCertificadoSAT;
    }

    /**
     * @param noCertificadoSAT the noCertificadoSAT to set
     */
    public void setNoCertificadoSAT(String noCertificadoSAT) {
        this.noCertificadoSAT = noCertificadoSAT;
    }

    /**
     * @return the selloSAT
     */
    public String getSelloSAT() {
        return selloSAT;
    }

    /**
     * @param selloSAT the selloSAT to set
     */
    public void setSelloSAT(String selloSAT) {
        this.selloSAT = selloSAT;
    }

    /**
     * Regresa la Cadena Original correspondiente al Timbre Fiscal Digital
     * @return
     */
    public String getCadenaOriginal() {
        String cadena = "";

        sdf = new SimpleDateFormat(Constants.DATE_FORMATO_CFDI); //para formatear la fecha

        cadena += version + "|" + (uuid != null && !uuid.equals("") ? uuid + "|" : "")
                + sdf.format(fechaTimbrado) + "|" + (selloCFD != null && !selloCFD.equals("") ? selloCFD + "|" : "")
                + (noCertificadoSAT != null && !noCertificadoSAT.equals("") ? noCertificadoSAT : "");

        return cadena;
    }
}
