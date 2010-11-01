/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mx.edu.um;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
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
public class JavaToXMLv2 {
    private Document xml = new Document();
    private Element root;

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

    public void generaRaiz(Comprobante comprobante) {
        root = new Element(Constants.COMPROBANTE_COMPROBANTE,"http://www.sat.gob.mx/cfd/2");
        Namespace namespace=Namespace.getNamespace("xsi", Constants.COMPROBANTE_URI_PREFIX);
        root.addNamespaceDeclaration(namespace);
        root.setAttribute(Constants.COMPROBANTE_SCHEMA,"http://www.sat.gob.mx/cfd/2 http://www.sat.gob.mx/sitio_internet/cfd/2/cfdv2.xsd ",namespace);
        root.setAttribute(Constants.COMPROBANTE_VERSION, Constants.COMPROBANTE_NUM_VERSION);
        root.setAttribute(Constants.COMPROBANTE_VERSION, Constants.COMPROBANTE_NUM_VERSION);
        root.setAttribute(Constants.COMPROBANTE_FOLIO, comprobante.getFolio());
        root.setAttribute(Constants.COMPROBANTE_FECHA, "2010-05-03T14:11:36");
        //root.setAttribute(Constants.COMPROBANTE_FECHA, comprobante.getFecha().toString());
        root.setAttribute(Constants.COMPROBANTE_SELLO, comprobante.getSello());

        root.setAttribute(Constants.COMPROBANTE_NO_CERTIFICADO, comprobante.getNoCertificado());
        root.setAttribute(Constants.COMPROBANTE_SUBTOTAL, comprobante.getSubtotal().getImporte().toString());
        root.setAttribute(Constants.COMPROBANTE_TOTAL, comprobante.getTotal().getImporte().toString());
        root.setAttribute(Constants.COMPROBANTE_NO_APROBACION, comprobante.getNoAprobacion().toString());
        root.setAttribute(Constants.COMPROBANTE_ANO_APROBACION, comprobante.getAnoAprobacion().toString());
        root.setAttribute(Constants.COMPROBANTE_FORMA_PAGO, comprobante.getFormaDePago());
        root.setAttribute(Constants.COMPROBANTE_DESCUENTO, comprobante.getDescuento().getImporte().toString());
        root.setAttribute(Constants.COMPROBANTE_METODO_DE_PAGO, comprobante.getMetodoDePago());
        root.setAttribute(Constants.COMPROBANTE_TIPO_COMPROBANTE, comprobante.getTipoDeComprobante());
        generaEmisor(comprobante.getEmisor());
        generaReceptor(comprobante.getReceptor());
        generaConceptos(comprobante.getConceptos());
        generaImpuestos(comprobante.getImpuestos());
        xml.setRootElement(root);
    }

    public void generaEmisor(Emisor emisor) {
        Element emisorElement = new Element(Constants.COMPROBANTE_EMISOR,"http://www.sat.gob.mx/cfd/2");
        emisorElement.setAttribute(Constants.COMPROBANTE_RFC, emisor.getRfc().getRfc());
        emisorElement.setAttribute(Constants.COMPROBANTE_NOMBRE, emisor.getNombre());
        Element domicilioFiscal = new Element(Constants.COMPROBANTE_DOMICILIO_FISCAL,"http://www.sat.gob.mx/cfd/2");
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_CALLE, emisor.getDomicilioFiscal().getCalle());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_NO_EXTERIOR, emisor.getDomicilioFiscal().getNoExterior());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_NO_INTERIOR, emisor.getDomicilioFiscal().getNoInterior());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_COLONIA, emisor.getDomicilioFiscal().getColonia());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_LOCALIDAD, emisor.getDomicilioFiscal().getLocalidad());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_MUNICIPIO, emisor.getDomicilioFiscal().getMunicipio());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_ESTADO, emisor.getDomicilioFiscal().getEstado());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_PAIS, emisor.getDomicilioFiscal().getPais());
        domicilioFiscal.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_CODIGO_POSTAL, emisor.getDomicilioFiscal().getCodigoPostal());
        emisorElement.addContent(domicilioFiscal);
        root.addContent(emisorElement);
    }

    public void generaReceptor(Receptor receptor) {
        Element rec = new Element(Constants.COMPROBANTE_RECEPTOR,"http://www.sat.gob.mx/cfd/2");
        rec.setAttribute(Constants.COMPROBANTE_RFC, receptor.getRfc().getRfc());
        rec.setAttribute(Constants.COMPROBANTE_NOMBRE, receptor.getNombre());
        Element domicilio = new Element(Constants.COMPROBANTE_DOMICILIO,"http://www.sat.gob.mx/cfd/2");
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_CALLE, receptor.getDomicilio().getCalle());
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_NO_EXTERIOR, receptor.getDomicilio().getNoExterior());
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_COLONIA, receptor.getDomicilio().getColonia());
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_ESTADO, receptor.getDomicilio().getEstado());
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_PAIS, receptor.getDomicilio().getPais());
        domicilio.setAttribute(Constants.COMPROBANTE_DOMICILIO_GENERICO_CODIGO_POSTAL, receptor.getDomicilio().getCodigoPostal());
        rec.addContent(domicilio);
        root.addContent(rec);
    }

    public void generaConceptos(Conceptos concp) {
        Element conceptos = new Element(Constants.COMPROBANTE_CONCEPTOS,"http://www.sat.gob.mx/cfd/2");
        for (Concepto con : concp) {
            Element concepto = new Element(Constants.COMPROBANTE_CONCEPTO,"http://www.sat.gob.mx/cfd/2");
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_CANTIDAD, con.getCantidad().toString());
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_UNIDAD, con.getUnidad());
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_NO_IDENTIFICACION, con.getNoIdentificacion());
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_DESCRIPCION, con.getDescripcion());
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_VALOR_UNITARIO, con.getValorUnitario().getImporte().toString());
            concepto.setAttribute(Constants.COMPROBANTE_CONCEPTO_IMPORTE, con.getImporte().getImporte().toString());
            conceptos.addContent(concepto);
        }
        root.addContent(conceptos);
    }

    public void generaImpuestos(Impuestos imp){
        Element impuestos=new Element(Constants.COMPROBANTE_IMPUESTOS, "http://www.sat.gob.mx/cfd/2");
        root.addContent(impuestos);
    }

    public static void main(String[] args) {
        Comprobante comprobante = new Comprobante();
        comprobante.setFolio("2");
        comprobante.setFecha(new Date());
        comprobante.setSello("uMdBnVYNkXyaLDCHNDCtcrrPZQMEnoXu9dQTVJcEAzaDlvatxHaSh9W7C36yVjALzylWq/f1Aq3BiFxxFtGCwVC7F5AMornrBUT6Cm8xXHiwKjwLH2py33j1QCGAgrHxjJ1hcrLzq+33nAn46C7hBgj93V9LJvyGW7BSKN2E9+E=");
        comprobante.setNoCertificado("20001000000100000377");
        comprobante.setNoAprobacion(new Integer("49"));
        comprobante.setAnoAprobacion(new Integer("2008"));
        comprobante.setFormaDePago("UNA SOLA EXHIBICIÓN");

        Emisor emisor = new Emisor();
        //RFC
        T_Rfc rfc = new T_Rfc("PAMC660606ER9");
        emisor.setRfc(rfc);
        emisor.setNombre("CONTRIBUYENTE PRUEBASEIS PATERNOSEIS MATERNOSEIS");
        //Domicilio Fiscal

        DomicilioFiscal domFiscal = new DomicilioFiscal();
        domFiscal.setCalle("PRUEBA SEIS");
        domFiscal.setNoExterior("6");
        domFiscal.setNoInterior("6");
        domFiscal.setColonia("PUEBLA CENTRO");
        domFiscal.setLocalidad("PUEBLA");
        domFiscal.setMunicipio("PUEBLA");
        domFiscal.setEstado("PUEBLA");
        domFiscal.setPais("MÉXICO");
        domFiscal.setCodigoPostal("72000");
        emisor.setDomicilioFiscal(domFiscal);
        comprobante.setEmisor(emisor);

        Receptor receptor = new Receptor();
        receptor.setNombre("ROSA MARÍA CALDERÓN UIRIEGAS");
        T_Rfc rfcReceptor = new T_Rfc("CAUR390312S87");
        receptor.setRfc(rfcReceptor);

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("TOPOCHICO");
        domicilio.setNoExterior("52");
        domicilio.setColonia("JARDINES DEL VALLE");
        domicilio.setEstado("NUEVO LEON");
        domicilio.setPais("México");
        domicilio.setCodigoPostal("95465");


        receptor.setDomicilio(domicilio);
        comprobante.setReceptor(receptor);

        Conceptos listaConceptos = new Conceptos();
        Concepto conceptoUno = new Concepto();
        conceptoUno.setCantidad(new Double("1"));
        conceptoUno.setValorUnitario(new T_Importe("2000.00"));
        conceptoUno.setUnidad("Servicio");
        conceptoUno.setNoIdentificacion("01");
        conceptoUno.setDescripcion("Asesoria Fiscal y administrativa");
        listaConceptos.add(conceptoUno);
        comprobante.setConceptos(listaConceptos);
        comprobante.setDescuento(new T_Importe("0.00"));
        comprobante.setMetodoDePago("EFECTIVO");
        comprobante.setTipoDeComprobante("ingreso");



        JavaToXMLv2 xml = new JavaToXMLv2();
        xml.generaRaiz(comprobante);
        XMLOutputter outputter = new XMLOutputter();
        //Formato XML Arreglado
        Format formato = Format.getPrettyFormat();
        outputter.setFormat(formato);
        File archivoXml = new File("/home/eder/comprobante.xml");
        try {
            Writer write = new FileWriter(archivoXml);
            outputter.output(xml.getXml(), write);
        } catch (IOException e) {
            System.err.println(e);
        }
        SAXBuilder builder = new SAXBuilder("org.apache.xerces.parsers.SAXParser", true);
        builder.setFeature("http://apache.org/xml/features/validation/schema", true);
        builder.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
        builder.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation", "http://www.sat.gob.mx/cfd/2 http://www.sat.gob.mx/sitio_internet/cfd/2/cfdv2.xsd");
        builder.setValidation(true);
        try {
            Document document = builder.build(archivoXml);
            outputter.output(document, System.out);

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
