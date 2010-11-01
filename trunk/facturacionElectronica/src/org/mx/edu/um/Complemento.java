package org.mx.edu.um;

/**
 *   Nodo opcional donde se incluir�n los nodos complementarios determinados por el SAT, de 
 *   acuerdo a las disposiciones particulares a un sector o actividad especifica. 
 * @author set
 *
 */
public class Complemento {

    /**
     * Complemento  requerido  para  el  Timbrado  Fiscal  Digital  del  SAT  que  da  validez  a  un
     * Comprobante Fiscal Digital por Internet.
     * REQUERIDO
     */
    private TimbreFiscalDigital timbreFiscalDigital;

    /**
     * @return the timbreFiscalDigital
     */
    public TimbreFiscalDigital getTimbreFiscalDigital() {
        return timbreFiscalDigital;
    }

    /**
     * @param timbreFiscalDigital the timbreFiscalDigital to set
     */
    public void setTimbreFiscalDigital(TimbreFiscalDigital timbreFiscalDigital) {
        this.timbreFiscalDigital = timbreFiscalDigital;
    }

    public String getCadenaOriginal() {
        String cadena = "";

        cadena += timbreFiscalDigital.getCadenaOriginal();

        return cadena;
    }
}
