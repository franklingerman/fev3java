/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mx.edu.um;

import java.io.IOException;
import java.util.Date;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author eder
 */
public class JavaToXML {

    private Document xml = new Document();
    private Element raiz;

    public void createNodoRaiz(Comprobante comprobante) {
        Element nodoRaiz = new Element("Comprobante");
        nodoRaiz.setAttribute(new Attribute("serie", comprobante.getSerie()));
        nodoRaiz.setAttribute(new Attribute("version", "2.0"));
        nodoRaiz.setAttribute(new Attribute("folio", comprobante.getFolio()));
        nodoRaiz.setAttribute(new Attribute("fecha", new Date().toString()));
        nodoRaiz.setAttribute(new Attribute("sello", comprobante.getSello()));
        nodoRaiz.setAttribute(new Attribute("noCertificado", comprobante.getNoCertificado()));
        nodoRaiz.setAttribute(new Attribute("subTotal", comprobante.getSubtotal().getImporte().toString()));
        nodoRaiz.setAttribute(new Attribute("total", comprobante.getTotal().toString()));
        nodoRaiz.setAttribute(new Attribute("noAprobacion", comprobante.getNoAprobacion().toString()));
        nodoRaiz.setAttribute(new Attribute("anoAprobacion", comprobante.getAnoAprobacion().toString()));
        nodoRaiz.setAttribute(new Attribute("formaDePago", comprobante.getFormaDePago().toString()));
        nodoRaiz.setAttribute(new Attribute("descuento", comprobante.getDescuento().getImporte().toString()));
        nodoRaiz.setAttribute(new Attribute("metodoPago", comprobante.getMetodoDePago()));
        setRaiz(nodoRaiz);
        manejaEmisor(comprobante.getEmisor());
        manejaReceptor(comprobante.getReceptor());
        xml.setRootElement(nodoRaiz);
    }

    public void manejaReceptor(Receptor receptor) {
        Element rec = new Element("Receptor");
        rec.setAttribute(new Attribute("rfc", receptor.getRfc().getRfc()));
        rec.setAttribute(new Attribute("nombre", receptor.getNombre()));
        /*
        Element domicilio=new Element("Domicilio");
        domicilio.setAttribute(new Attribute("calle", receptor.getDomicilio().getCalle()));
        domicilio.setAttribute(new Attribute("noExterior", receptor.getDomicilio().getNoExterior()));
        domicilio.setAttribute(new Attribute("colonia", receptor.getDomicilio().getColonia()));
        domicilio.setAttribute(new Attribute("estado", receptor.getDomicilio().getEstado()));
        domicilio.setAttribute(new Attribute("pais", receptor.getDomicilio().getPais()));
        domicilio.setAttribute(new Attribute("codigoPostal", receptor.getDomicilio().getCodigoPostal()));
        rec.addContent(domicilio);
         */
        raiz.addContent(rec);
    }

    public void manejaEmisor(Emisor emisor) {
        Element emi = new Element("Emisor");
        emi.setAttribute(new Attribute("rfc", emisor.getRfc().getRfc()));
        emi.setAttribute(new Attribute("nombre", emisor.getNombre()));
        Element domicilioFiscal = new Element("DomicilioFiscal");
        domicilioFiscal.setAttribute(new Attribute("calle", emisor.getDomicilioFiscal().getCalle()));
        domicilioFiscal.setAttribute(new Attribute("noExterior", emisor.getDomicilioFiscal().getNoExterior()));
        domicilioFiscal.setAttribute(new Attribute("noInterior", emisor.getDomicilioFiscal().getNoInterior()));
        domicilioFiscal.setAttribute(new Attribute("colonia", emisor.getDomicilioFiscal().getColonia()));
        domicilioFiscal.setAttribute(new Attribute("localidad", emisor.getDomicilioFiscal().getLocalidad()));
        domicilioFiscal.setAttribute(new Attribute("municipio", emisor.getDomicilioFiscal().getMunicipio()));
        domicilioFiscal.setAttribute(new Attribute("estado", emisor.getDomicilioFiscal().getEstado()));
        domicilioFiscal.setAttribute(new Attribute("pais", emisor.getDomicilioFiscal().getPais()));
        domicilioFiscal.setAttribute(new Attribute("codigoPostal", emisor.getDomicilioFiscal().getCodigoPostal()));
        emi.addContent(domicilioFiscal);
        raiz.addContent(emi);
    }

    public static void main(String[] args) {
        //Raiz
        Comprobante comprobante = new Comprobante();
        comprobante.setSerie("ABCD");
        comprobante.setFolio("2");
        comprobante.setFecha(new Date());
        comprobante.setSello("uMdBnVYNkXyaLDCHNDCtcrrPZQMEnoXu9dQTVJcEAzaDlvatxHaSh9W7C36yVjALzylWq/f1Aq3BiFxxFtGCwVC7F5AMornrBUT6Cm8xXHiwKjwLH2py33j1QCGAgrHxjJ1hcrLzq+33nAn46C7hBgj93V9LJvyGW7BSKN2E9+E=");
        comprobante.setNoCertificado("20001000000100000377");
        T_Importe descuento = new T_Importe("0.00");
        comprobante.setNoAprobacion(new Integer("49"));
        comprobante.setAnoAprobacion(new Integer("2008"));
        comprobante.setFormaDePago("UNA SOLA EXHIBICION");
        comprobante.setDescuento(descuento);
        comprobante.setMetodoDePago("EFECTIVO");
        comprobante.setTipoDeComprobante("Ingreso");
        Conceptos listaConceptos = new Conceptos();
        Concepto conceptoUno = new Concepto();
        conceptoUno.setCantidad(new Double("1"));
        conceptoUno.setValorUnitario(new T_Importe("2000.00"));
        listaConceptos.add(conceptoUno);
        comprobante.setConceptos(listaConceptos);
        //Emisor
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
        //Receptor
        Receptor receptor = new Receptor();
        receptor.setNombre("ROSA MARÍA CALDERÓN UIRIEGAS");






        JavaToXML conversor = new JavaToXML();
        conversor.createNodoRaiz(comprobante);

        XMLOutputter outputter = new XMLOutputter();
        //Formato XML Arreglado
        Format formato = Format.getPrettyFormat();
        outputter.setFormat(formato);
        try {
            outputter.output(conversor.getXml(), System.out);
        } catch (IOException e) {
            System.err.println(e);
        }
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

    /**
     * @return the raiz
     */
    public Element getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(Element raiz) {
        this.raiz = raiz;
    }
}
