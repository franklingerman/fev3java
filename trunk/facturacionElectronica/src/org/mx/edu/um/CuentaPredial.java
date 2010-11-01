package org.mx.edu.um;

/**
 * 
 * @author set
 *
 */
public class CuentaPredial {

    /**
     * Nodo opcional para asentar el n�mero de cuenta predial con el que fue registrado el
     * inmueble, en el sistema catastral de la entidad federativa de que trate.
     * OPCIONAL
     */
    private String numero;

    /**
     * Atributo requerido para precisar el n�mero de la cuenta predial
     * del inmueble cubierto por el presente concepto en caso de
     * recibos de arrendamiento.
     * REQUERIDO
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Regresa la Cadena Original correspondiente a la CuentaPredial de un Concepto
     * @return
     */
    public String getCadenaOriginal() {
        String cadena = "";
        cadena += numero;
        return cadena;
    }

    public int compareTo(Object o) {
        if (!(o instanceof CuentaPredial)) {
            return -1;
        }

        CuentaPredial cuPe = (CuentaPredial) o;
        return this.getNumero().compareTo(cuPe.getNumero());
    }
}
