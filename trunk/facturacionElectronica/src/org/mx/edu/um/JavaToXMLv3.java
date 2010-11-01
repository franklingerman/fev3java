/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mx.edu.um;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


/**
 *
 * @author eder
 */
public class JavaToXMLv3 extends ObjetoBase{
    private Document xml=new Document();
    private Element root;
/**
 * Este metodo genera el Elemento Comprobante del XML
 * @param comprobante
 */
    public void generaRaiz(Comprobante comprobante) {
        //crea un elemento raiz y le asigna los namespaces y los xsd
        root = new Element(Constants.COMPROBANTE_COMPROBANTE,Constants.COMPROBANTE_PREFIX_NAMESPACE,Constants.COMPROBANTE_NAMESPACE_URI);
        //root = new Element(Constants.COMPROBANTE_COMPROBANTE,Constants.COMPROBANTE_NAMESPACE_URI);
        Namespace namespace=Namespace.getNamespace(Constants.COMPROBANTE_PREFIX, Constants.COMPROBANTE_URI_PREFIX);
        root.setAttribute(Constants.COMPROBANTE_SCHEMA,Constants.COMPROBANTE_SCHEMA_XSD,namespace);
        root.addNamespaceDeclaration(namespace);
        //se empieza a construir el comprobante
        root.setAttribute(Constants.COMPROBANTE_VERSION, Constants.VERSION_COMPROBANTE_TRES);
        if(comprobante.getSerie()!=null&&!comprobante.getSerie().trim().equals("")){
        root.setAttribute(Constants.COMPROBANTE_SERIE, comprobante.getSerie());
        }
        if(comprobante.getFolio()!=null&&!comprobante.getFolio().trim().equals("")){
        root.setAttribute(Constants.COMPROBANTE_FOLIO, comprobante.getFolio());
        }
        root.setAttribute(Constants.COMPROBANTE_FECHA, sdf.format(comprobante.getFecha()));
        root.setAttribute(Constants.COMPROBANTE_SELLO, comprobante.getSello());
        if(comprobante.getFormaDePago()!=null&&!comprobante.getFormaDePago().trim().equals("")){
        root.setAttribute(Constants.COMPROBANTE_FORMA_PAGO, comprobante.getFormaDePago());
        }
        root.setAttribute(Constants.COMPROBANTE_NO_CERTIFICADO, comprobante.getNoCertificado());
        root.setAttribute(Constants.COMPROBANTE_CERTIFICADO, comprobante.getCertificado());
        if(comprobante.getCondicionesDePago()!=null&&!comprobante.getCondicionesDePago().trim().equals("")){
        root.setAttribute(Constants.COMPROBANTE_CONDICIONES_PAGO, comprobante.getCondicionesDePago());
        }
        root.setAttribute(Constants.COMPROBANTE_SUBTOTAL, comprobante.getSubtotal().getImporte().toString());
        if((comprobante.getDescuento()!=null&&comprobante.getDescuento().getImporte()!=null)&&!comprobante.getDescuento().getImporte().toString().trim().equals("")){
        root.setAttribute(Constants.COMPROBANTE_DESCUENTO, comprobante.getDescuento().getImporte().toString());
        }
        if(comprobante.getMotivoDescuento()!=null&&!comprobante.getMotivoDescuento().trim().equals("")){
        root.setAttribute(Constants.COMPROBANTE_MOTIVO_DESCUENTO, comprobante.getMotivoDescuento());
        }
        if(comprobante.getTipoDeCambio()!=null&&!comprobante.getTipoDeCambio().trim().equals("")){
        root.setAttribute(Constants.COMPROBANTE_TIPO_CAMBIO, comprobante.getTipoDeCambio());
        }
        if(comprobante.getMoneda()!=null&&!comprobante.getMoneda().trim().equals("")){
        root.setAttribute(Constants.COMPROBANTE_MONEDA, comprobante.getMoneda());
        }
        root.setAttribute(Constants.COMPROBANTE_TOTAL, comprobante.getTotal().getImporte().toString());
        //root.setAttribute(Constants.COMPROBANTE_NO_APROBACION, comprobante.getNoAprobacion().toString());
        //root.setAttribute(Constants.COMPROBANTE_ANO_APROBACION, comprobante.getAnoAprobacion().toString());
        if(comprobante.getMetodoDePago()!=null&&!comprobante.getMetodoDePago().trim().equals("")){
        root.setAttribute(Constants.COMPROBANTE_METODO_DE_PAGO, comprobante.getMetodoDePago());
        }
        root.setAttribute(Constants.COMPROBANTE_TIPO_COMPROBANTE, comprobante.getTipoDeComprobante());
        //se generan el Nodo Emisor
        generaEmisor(comprobante.getEmisor());
        generaReceptor(comprobante.getReceptor());
        generaConceptos(comprobante.getConceptos());
        generaImpuestos(comprobante.getImpuestos());
        getXml().setRootElement(root);
    }

    public void generaEmisor(Emisor emisor) {
        //se le agrega el namespace al emisor
        Element emisorElement = new Element(Constants.COMPROBANTE_EMISOR,Constants.COMPROBANTE_PREFIX_NAMESPACE,Constants.COMPROBANTE_NAMESPACE_URI);
        emisorElement.setAttribute(Constants.COMPROBANTE_RFC, emisor.getRfc().getRfc());
        emisorElement.setAttribute(Constants.COMPROBANTE_NOMBRE, emisor.getNombre());
        //se crea el nodo domiciliofiscal
        Element domicilioFiscal = new Element(Constants.COMPROBANTE_DOMICILIO_FISCAL,Constants.COMPROBANTE_PREFIX_NAMESPACE,Constants.COMPROBANTE_NAMESPACE_URI);
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_CALLE, emisor.getDomicilioFiscal().getCalle());

        if(emisor.getDomicilioFiscal().getNoExterior()!=null&&!emisor.getDomicilioFiscal().getNoExterior().trim().equals("")){
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_NO_EXTERIOR, emisor.getDomicilioFiscal().getNoExterior());
        }
        if(emisor.getDomicilioFiscal().getNoInterior()!=null&&!emisor.getDomicilioFiscal().getNoInterior().trim().equals("")){
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_NO_INTERIOR, emisor.getDomicilioFiscal().getNoInterior());
        }
        if(emisor.getDomicilioFiscal().getColonia()!=null&&!emisor.getDomicilioFiscal().getColonia().trim().equals("")){
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_COLONIA, emisor.getDomicilioFiscal().getColonia());
        }
        if(emisor.getDomicilioFiscal().getLocalidad()!=null&&!emisor.getDomicilioFiscal().getLocalidad().trim().equals("")){
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_LOCALIDAD, emisor.getDomicilioFiscal().getLocalidad());
        }
        if(emisor.getDomicilioFiscal().getReferencia()!=null&&!emisor.getDomicilioFiscal().getReferencia().trim().equals("")){
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_REFERENCIA, emisor.getDomicilioFiscal().getReferencia());
        }
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_MUNICIPIO, emisor.getDomicilioFiscal().getMunicipio());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_ESTADO, emisor.getDomicilioFiscal().getEstado());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_PAIS, emisor.getDomicilioFiscal().getPais());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_CODIGO_POSTAL, emisor.getDomicilioFiscal().getCodigoPostal());
        //se agrega el domicilio fiscal al nodo emisor
        emisorElement.addContent(domicilioFiscal);
        //se agrega el nodo emisor al elemento comprobante
        root.addContent(emisorElement);
    }

    public void generaReceptor(Receptor receptor) {
        //se crea el nodo receptor
        Element rec = new Element(Constants.COMPROBANTE_RECEPTOR,Constants.COMPROBANTE_PREFIX_NAMESPACE,Constants.COMPROBANTE_NAMESPACE_URI);
        rec.setAttribute(Constants.COMPROBANTE_RFC, receptor.getRfc().getRfc());
        if(receptor.getNombre()!=null&&!receptor.getNombre().trim().equals("")){
        rec.setAttribute(Constants.COMPROBANTE_NOMBRE, receptor.getNombre());
        }
        //se crea el nodo domicilio
        Element domicilio = new Element(Constants.COMPROBANTE_DOMICILIO,Constants.COMPROBANTE_PREFIX_NAMESPACE,Constants.COMPROBANTE_NAMESPACE_URI);

        if(receptor.getDomicilio().getCalle()!=null&&!receptor.getDomicilio().getCalle().trim().equals("")){
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_CALLE, receptor.getDomicilio().getCalle());
        }
        if(receptor.getDomicilio().getNoExterior()!=null&&!receptor.getDomicilio().getNoExterior().trim().equals("")){
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_NO_EXTERIOR, receptor.getDomicilio().getNoExterior());
        }
        if(receptor.getDomicilio().getNoInterior()!=null&&!receptor.getDomicilio().getNoInterior().trim().equals("")){
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_NO_INTERIOR, receptor.getDomicilio().getNoInterior());
        }
        if(receptor.getDomicilio().getColonia()!=null&&!receptor.getDomicilio().getColonia().trim().equals("")){
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_COLONIA, receptor.getDomicilio().getColonia());
        }
        if(receptor.getDomicilio().getLocalidad()!=null&&!receptor.getDomicilio().getLocalidad().trim().equals("")){
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_LOCALIDAD, receptor.getDomicilio().getLocalidad());
        }
        if(receptor.getDomicilio().getReferencia()!=null&&!receptor.getDomicilio().getReferencia().trim().equals("")){
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_REFERENCIA, receptor.getDomicilio().getReferencia());
        }
        if(receptor.getDomicilio().getMunicipio()!=null&&!receptor.getDomicilio().getMunicipio().trim().equals("")){
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_MUNICIPIO, receptor.getDomicilio().getMunicipio());
        }
        if(receptor.getDomicilio().getEstado()!=null&&!receptor.getDomicilio().getEstado().trim().equals("")){
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_ESTADO, receptor.getDomicilio().getEstado());
        }
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_PAIS, receptor.getDomicilio().getPais());
        if(receptor.getDomicilio().getCodigoPostal()!=null&&!receptor.getDomicilio().getCodigoPostal().trim().equals("")){
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_CODIGO_POSTAL, receptor.getDomicilio().getCodigoPostal());
        }
        //se agrega el domicilio al receptor
        rec.addContent(domicilio);
        //se agrega el nodo receptor al comprobante
        root.addContent(rec);
    }

    public void generaConceptos(Conceptos concp) {
        Element conceptos = new Element(Constants.COMPROBANTE_CONCEPTOS,Constants.COMPROBANTE_PREFIX_NAMESPACE,Constants.COMPROBANTE_NAMESPACE_URI);
        for (Concepto con : concp) {
            Element concepto = new Element(Constants.COMPROBANTE_CONCEPTO,Constants.COMPROBANTE_PREFIX_NAMESPACE,Constants.COMPROBANTE_NAMESPACE_URI);
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_CANTIDAD, con.getCantidad().toString());
            if(con.getUnidad()!=null&&!con.getUnidad().trim().equals("")){
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_UNIDAD, con.getUnidad());
            }
            if(con.getNoIdentificacion()!=null&&!con.getNoIdentificacion().trim().equals("")){
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_NO_IDENTIFICACION, con.getNoIdentificacion());
            }
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_DESCRIPCION, con.getDescripcion());
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_VALOR_UNITARIO, con.getValorUnitario().getImporte().toString());
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_IMPORTE, con.getImporte().getImporte().toString());
            //checar los nodos opcionales de conceptos InformacionAduanera,CuentaPredial,ComplementoConcepto,Parte
            conceptos.addContent(concepto);
        }
        root.addContent(conceptos);
    }

    public void generaImpuestos(Impuestos imp){
        //checar los elementos de impuestos
        Element impuestos=new Element(Constants.COMPROBANTE_IMPUESTOS, Constants.COMPROBANTE_PREFIX_NAMESPACE,Constants.COMPROBANTE_NAMESPACE_URI);
        root.addContent(impuestos);
    }

    public void generaTimbreFiscal(TimbreFiscalDigital timbreFiscalDigital){
        Element timbreFiscal=new Element(Constants.COMPROBANTE_TIMBRE_FISCAL);
        timbreFiscal.setAttribute(Constants.COMPROBANTE_VERSION,Constants.VERSION_TIMBRE_FISCAL);
        timbreFiscal.setAttribute(Constants.COMPROBANTE_TIMBRE_FISCAL_UUID,timbreFiscalDigital.getUuid());
        timbreFiscal.setAttribute(Constants.COMPROBANTE_TIMBRE_FISCAL_FECHA_TIMBRADO,sdf.format(timbreFiscalDigital.getFechaTimbrado()));
        timbreFiscal.setAttribute(Constants.COMPROBANTE_TIMBRE_FISCAL_SELLO_CFD,"");
        timbreFiscal.setAttribute(Constants.COMPROBANTE_TIMBRE_FISCAL_NO_CERTIFICADO_SAT,"");
        timbreFiscal.setAttribute(Constants.COMPROBANTE_TIMBRE_FISCAL_SELLO_SAT,"");
        root.addContent(timbreFiscal);
    }


    public boolean creaAndValidaXML(Comprobante comprobante){
        boolean response=false;
        generaRaiz(comprobante);
        //Instancia La clase que da la salida XML al archivo
        XMLOutputter outputter = new XMLOutputter();
        //Formato XML Arreglado Con Identacion
        Format formato = Format.getPrettyFormat();
        outputter.setFormat(formato);
        //Crea el archivo aunque no de manera logica
        File archivoXml = new File("/home/eder/comprobante.xml");
        try {
            //se instancia la clase que va a escrbir el archivo en disco
            Writer write = new FileWriter(archivoXml);
            //se escribe el archivo en disco
            outputter.output(getXml(),write);
        } catch (IOException e) {
            System.err.println(e);
        }
        //se instancia la clase que validara el XSD
        SAXBuilder builder = new SAXBuilder("org.apache.xerces.parsers.SAXParser", true);
        builder.setFeature("http://apache.org/xml/features/validation/schema", true);
        builder.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
        builder.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation", Constants.COMPROBANTE_SCHEMA_XSD);
        builder.setValidation(true);
        //se imprime el documento si se logro cumplir con el XSD
        try {
            Document document = builder.build(archivoXml);
            outputter.output(document, System.out);
            response=true;
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * @return the xml
     */
    public Document getXml() {
        return xml;
    }

    /**
     * @param xml the xml to set
     */
    public void setXml(Document xml) {
        this.xml = xml;
    }
    

}
