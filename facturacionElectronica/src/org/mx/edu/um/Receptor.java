package org.mx.edu.um;

/**
 * @author set
 * REQUERIDO para expresar la informacion del contribuyente REceptor del Comprobante
 */
public class Receptor {

    /**
     * Atributo requerido para la Clave del Registro Federal de
     * Contribuyentes correspondiente al contribuyente receptor del
     * comprobante SIN GUIONES O ESPACIOS.
     * REQUERIDO
     */
    private T_Rfc rfc;
    /**
     * Atributo  opcional  para  precisar  el  nombre  o  raz�n  social  del
     * contribuyente receptor.
     * REQUERIDO
     */
    private String nombre;
    /**
     * Nodo opcional para la definici�n de la ubicaci�n donde se da el domicilio del receptor del
     * comprobante fiscal.
     * OPCIONAL
     */
    private Domicilio domicilio; //Ubicacion del Receptor del Comprobante

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
     * @return the domicilio
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Regresa la Cadena Original correspondiente a RECEPTOR.
     * @return
     */
    public String getCadenaOriginal() {
        String cadena = "";

        //Informacion del Nodo Receptor
        cadena = rfc.getCadenaOriginal() + "|" + nombre;

        //Informacion del Nodo Domicilio
        if (domicilio != null && !domicilio.getCadenaOriginal().equals("")) {
            cadena += "|" + domicilio.getCadenaOriginal();
        }

        return cadena;
    }
}
