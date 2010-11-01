package org.mx.edu.um;

/**
 * Constant values used throughout the application.
 *
 * <p>
 * <a href="Constants.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class Constants {

    public static final String LOCALE_LANGUAGE = "es";
    public static final String LOCALE_COUNTRY = "MX";
    public static final String LOCALE_VARIANT = "Traditional_WIN";
    /**
     * Formato (dd/MM/yyyy) de la fecha en el cual el mes se representa numericamente
     */
    public static final String DATE_SHORT_HUMAN_PATTERN = "dd/MM/yyyy";
    //Comprobante Fiscal Digital-START
    public static final String COMPROBANTE_COMPROBANTE = "Comprobante";
    public static final String COMPROBANTE_VERSION = "version";
    public static final String COMPROBANTE_NUM_VERSION = "2.0";
    public static final String COMPROBANTE_FOLIO = "folio";
    public static final String COMPROBANTE_SERIE = "serie";
    public static final String COMPROBANTE_FECHA = "fecha";
    public static final String COMPROBANTE_SELLO = "sello";
    public static final String COMPROBANTE_NO_CERTIFICADO = "noCertificado";
    public static final String COMPROBANTE_CERTIFICADO = "certificado";
    public static final String COMPROBANTE_CONDICIONES_PAGO = "condicionesDePago";
    public static final String COMPROBANTE_SUBTOTAL = "subTotal";
    public static final String COMPROBANTE_DESCUENTO = "descuento";
    public static final String COMPROBANTE_MOTIVO_DESCUENTO = "motivoDescuento";
    public static final String COMPROBANTE_TIPO_CAMBIO = "TipoCambio";
    public static final String COMPROBANTE_MONEDA = "Moneda";
    public static final String COMPROBANTE_TOTAL = "total";
    public static final String COMPROBANTE_NO_APROBACION = "noAprobacion";
    public static final String COMPROBANTE_ANO_APROBACION = "anoAprobacion";
    public static final String COMPROBANTE_FORMA_PAGO = "formaDePago";
    public static final String COMPROBANTE_METODO_DE_PAGO = "metodoDePago";
    public static final String COMPROBANTE_TIPO_COMPROBANTE = "tipoDeComprobante";
    public static final Integer NUMERO_DECIMALES_IMPORTE = 6;
    public static final String VERSION_COMPROBANTE_TRES = "3.0";
    public static final String COMPROBANTE_RFC = "rfc";
    public static final String COMPROBANTE_NOMBRE = "nombre";
    //Emisor
    public static final String COMPROBANTE_EMISOR = "Emisor";
    //Receptor
    public static final String COMPROBANTE_RECEPTOR = "Receptor";
    //Domicilios
    public static final String COMPROBANTE_DOMICILIO_FISCAL = "DomicilioFiscal";
    public static final String COMPROBANTE_DOMICILIO = "Domicilio";
    //DomicilioGenerico
    public static final String COMPROBANTE_DOMICILIO_GENERICO_CALLE = "calle";
    public static final String COMPROBANTE_DOMICILIO_GENERICO_NO_EXTERIOR = "noExterior";
    public static final String COMPROBANTE_DOMICILIO_GENERICO_NO_INTERIOR = "noInterior";
    public static final String COMPROBANTE_DOMICILIO_GENERICO_COLONIA = "colonia";
    public static final String COMPROBANTE_DOMICILIO_GENERICO_PAIS = "pais";
    public static final String COMPROBANTE_DOMICILIO_GENERICO_CODIGO_POSTAL = "codigoPostal";
    public static final String COMPROBANTE_DOMICILIO_GENERICO_ESTADO = "estado";
    public static final String COMPROBANTE_DOMICILIO_GENERICO_REFERENCIA = "referencia";
    public static final String COMPROBANTE_DOMICILIO_GENERICO_LOCALIDAD = "localidad";
    public static final String COMPROBANTE_DOMICILIO_GENERICO_MUNICIPIO = "municipio";
    //DomicilioGenerico
    //Conceptos
    public static final String COMPROBANTE_CONCEPTOS = "Conceptos";
    public static final String COMPROBANTE_CONCEPTO = "Concepto";
    public static final String COMPROBANTE_CONCEPTO_CANTIDAD = "cantidad";
    public static final String COMPROBANTE_CONCEPTO_UNIDAD = "unidad";
    public static final String COMPROBANTE_CONCEPTO_NO_IDENTIFICACION = "noIdentificacion";
    public static final String COMPROBANTE_CONCEPTO_DESCRIPCION = "descripcion";
    public static final String COMPROBANTE_CONCEPTO_VALOR_UNITARIO = "valorUnitario";
    public static final String COMPROBANTE_CONCEPTO_IMPORTE = "importe";
    public static final String COMPROBANTE_NAMESPACE_URI = "http://www.sat.gob.mx/cfd/3";
    //Impuestos
    public static final String COMPROBANTE_IMPUESTOS = "Impuestos";
    public static final String COMPROBANTE_IMPUESTOS_TOTAL_IMPUESTOS = "totalImpuestosTrasladados";
    //NameSpaces
    public static final String COMPROBANTE_PREFIX = "xsi";
    public static final String COMPROBANTE_PREFIX_NAMESPACE = "cfdi";
    public static final String COMPROBANTE_URI_PREFIX = "http://www.w3.org/2001/XMLSchema-instance";
    public static final String COMPROBANTE_SCHEMA = "schemaLocation";
    public static final String COMPROBANTE_SCHEMA_XSD = "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv3.xsd";
    //TimbreFiscal-START http://www.sat.gob.mx/cfd/3 
    public static final String COMPROBANTE_TIMBRE_FISCAL = "TimbreFiscalDigital";
    public static final String VERSION_TIMBRE_FISCAL = "2.0";
    public static final String COMPROBANTE_TIMBRE_FISCAL_UUID = "UUID";
    public static final String COMPROBANTE_TIMBRE_FISCAL_FECHA_TIMBRADO = "FechaTimbrado";
    public static final String COMPROBANTE_TIMBRE_FISCAL_SELLO_CFD = "selloCFD";
    public static final String COMPROBANTE_TIMBRE_FISCAL_NO_CERTIFICADO_SAT = "noCertificadoSAT";
    public static final String COMPROBANTE_TIMBRE_FISCAL_SELLO_SAT = "selloSAT";
    //TimbreFiscal-END
    //Encriptacion-START
    public static final String ALGORITMO_DIGESTION_AND_CIFRADO = "SHA1withRSA";
    //Encriptacion-END
    /* Formato que debe llevar la fecha para el CFDI de la Facturacion Digital
     * 2010-03-06T20:38:12
     */
    public static final String DATE_FORMATO_CFDI = "yyyy-MM-dd'T'HH:mm:Ss";
    //Comprobante Fiscal Digital-END
}
