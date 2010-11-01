package org.mx.edu.um;

import java.security.GeneralSecurityException;
import java.util.Date;

public class PruebasComportamiento {

    public static void main(String[] args) {
        //Rellenando los campos de prueba
        Comprobante comprobante = new Comprobante();
        //EMISOR
        Emisor emisor = new Emisor();
        emisor.setNombre("Universidad de Montemorelos");
        //EMISOR-RFC
        T_Rfc rfcEmisor = new T_Rfc("UMO8409105C4");
        emisor.setRfc(rfcEmisor);
        //EMISOR-DOMICILIO FISCAL
        DomicilioFiscal domicilioFiscal = new DomicilioFiscal();
        domicilioFiscal.setCalle("Libertad Poniente");
        domicilioFiscal.setCodigoPostal("67510");
        domicilioFiscal.setColonia("Barrio Matamoros");
        domicilioFiscal.setEstado("Nuevo Leon");
        domicilioFiscal.setLocalidad("Montemorelos");
        domicilioFiscal.setMunicipio("Montemorelos");
        domicilioFiscal.setNoExterior("1300");
        domicilioFiscal.setPais("Mexico");
        domicilioFiscal.setReferencia("La cosa mas grande que hay en Montemorelos. Digale a un taxista que lo lleve");
        emisor.setDomicilioFiscal(domicilioFiscal);
        //RECEPTOR
        Receptor receptor = new Receptor();
        receptor.setNombre("Seth Karim Luis Martinez");
        //RECEPTOR-RFC
        T_Rfc rfcReceptor = new T_Rfc("LUMS890819AU5");
        receptor.setRfc(rfcReceptor);
        //RECEPTOR-DOMICILIO
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Cristobal Colon");
        domicilio.setCodigoPostal("96400");
        domicilio.setColonia("Hernandez Ochoa");
        domicilio.setEstado("Veracruz");
        domicilio.setLocalidad("Coatzacoalcos");
        domicilio.setMunicipio("Coatzacoalcos");
        domicilio.setNoExterior("270");
        domicilio.setPais("Mexico");
        receptor.setDomicilio(domicilio);
        comprobante.setEmisor(emisor);
        comprobante.setReceptor(receptor);
        comprobante.setSello("uMdBnVYNkXyaLDCHNDCtcrrPZQMEnoXu9dQTVJcEAzaDlvatxHaSh9W7C36yVjALzylWq/f1Aq3BiFxxFtGCwVC7F5AMornrBUT6Cm8xXHiwKjwLH2py33j1QCGAgrHxjJ1hcrLzq+33nAn46C7hBgj93V9LJvyGW7BSKN2E9+E=");
        comprobante.setFolio("2");
        comprobante.setSerie("ABCD");
        comprobante.setFecha(new Date());
        comprobante.setNoCertificado("20001000000100000377");
        comprobante.setNoAprobacion(49);
        comprobante.setAnoAprobacion(2010);
        comprobante.setFormaDePago("UNA SOLA EXHIBICION");
        comprobante.setMetodoDePago("EFECTIVO");
        comprobante.setTipoDeComprobante("INGRESO");
        comprobante.setCertificado("MIIE/TCCA+WgAwIBAgIUMzAwMDEwMDAwMDAxMDAwMDA4MDAwDQYJKoZIhvcNAQEFBQAwggFvMRgwFgYDVQQDDA9BLkMuIGRlIHBydWViYXMxLzAtBgNVBAoMJlNlcnZpY2lvIGRlIEFkbWluaXN0cmFjacOzbiBUcmlidXRhcmlhMTgwNgYDVQQLDC9BZG1pbmlzdHJhY2nDs24gZGUgU2VndXJpZGFkIGRlIGxhIEluZm9ybWFjacOzbjEpMCcGCSqGSIb3DQEJARYaYXNpc25ldEBwcnVlYmFzLnNhdC5nb2IubXgxJjAkBgNVBAkMHUF2LiBIaWRhbGdvIDc3LCBDb2wuIEd1ZXJyZXJvMQ4wDAYDVQQRDAUwNjMwMDELMAkGA1UEBhMCTVgxGTAXBgNVBAgMEERpc3RyaXRvIEZlZGVyYWwxEjAQBgNVBAcMCUNveW9hY8OhbjEVMBMGA1UELRMMU0FUOTcwNzAxTk4zMTIwMAYJKoZIhvcNAQkCDCNSZXNwb25zYWJsZTogSMOpY3RvciBPcm5lbGFzIEFyY2lnYTAeFw0xMDA3MzAxNjU4NDBaFw0xMjA3MjkxNjU4NDBaMIGWMRIwEAYDVQQDDAlNYXRyaXogU0ExEjAQBgNVBCkMCU1hdHJpeiBTQTESMBAGA1UECgwJTWF0cml6IFNBMSUwIwYDVQQtExxBQUEwMTAxMDFBQUEgLyBBQUFBMDEwMTAxQUFBMR4wHAYDVQQFExUgLyBBQUFBMDEwMTAxSERGUlhYMDExETAPBgNVBAsMCFVuaWRhZCAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDD0ltQNthUNUfzq0t1GpIyapjzOn1W5fGM5G/pQyMluCzP9YlVAgBjGgzwYp9Z0J9gadg3y2ZrYDwvv8b72goyRnhnv3bkjVRKlus6LDc00K7Jl23UYzNGlXn5+i0HxxuWonc2GYKFGsN4rFWKVy3Fnpv8Z2D7dNqsVyT5HapEqwIDAQABo4HqMIHnMAwGA1UdEwEB/wQCMAAwCwYDVR0PBAQDAgbAMB0GA1UdDgQWBBSYodSwRczzj5H7mcO3+mAyXz+y0DAuBgNVHR8EJzAlMCOgIaAfhh1odHRwOi8vcGtpLnNhdC5nb2IubXgvc2F0LmNybDAzBggrBgEFBQcBAQQnMCUwIwYIKwYBBQUHMAGGF2h0dHA6Ly9vY3NwLnNhdC5nb2IubXgvMB8GA1UdIwQYMBaAFOtZfQQimlONnnEaoFiWKfU54KDFMBAGA1UdIAQJMAcwBQYDKgMEMBMGA1UdJQQMMAoGCCsGAQUFBwMCMA0GCSqGSIb3DQEBBQUAA4IBAQArHQEorApwqumSn5EqDOAjbezi8fLco1cYES/PD+LQRM1Vb1g7VLE3hR4S5NNBv0bMwwWAr0WfL9lRRj0PMKLorO8y4TJjRU8MiYXfzSuKYL5Z16kW8zlVHw7CtmjhfjoIMwjQo3prifWxFv7VpfIBstKKShU0qB6KzUUNwg2Ola4t4gg2JJcBmyIAIInHSGoeinR2V1tQ10aRqJdXkGin4WZ75yMbQH4L0NfotqY6bpF2CqIY3aogQyJGhUJji4gYnS2DvHcyoICwgawshjSaX8Y0Xlwnuh6EusqhqlhTgwPNAPrKIXCmOWtqjlDhho/lhkHJMzuTn8AoVapbBUn");
        comprobante.setVersion(Constants.VERSION_COMPROBANTE_TRES);
        //CONCEPTOS
        Conceptos conceptos = new Conceptos();
        //--Concepto UNO
        Concepto conceptoUno = new Concepto();
        conceptoUno.setCantidad(new Double("2.0"));
        //Concepto UNO-CUENTA PREDIAL
        CuentaPredial cuentaPredial = new CuentaPredial();
        cuentaPredial.setNumero("1595600000");
        conceptoUno.setCuentaPredial(cuentaPredial);
        conceptoUno.setDescripcion("Venta de un semestre de estudios en la FIT en la Universidad de Montemorelos");
        conceptoUno.setNoIdentificacion("255");
        conceptoUno.setUnidad("paquetes");
        conceptoUno.setValorUnitario(new T_Importe("65000"));
        //Concepto DOS
        Concepto conceptoDos = new Concepto();
        conceptoDos.setCantidad(new Double("5.0"));
        //Concepto DOS-CUENTA PREDIAL
        CuentaPredial cuentaPredialDos = new CuentaPredial();
        cuentaPredialDos.setNumero("1605600000");
        conceptoDos.setCuentaPredial(cuentaPredialDos);
        conceptoDos.setDescripcion("Venta de un semestre de estudios EN FACSA en la Universidad de Montemorelos");
        conceptoDos.setNoIdentificacion("155");
        conceptoDos.setUnidad("paquetes");
        conceptoDos.setValorUnitario(new T_Importe("75000"));
        conceptos.add(conceptoUno);
        conceptos.add(conceptoDos);
        comprobante.setConceptos(conceptos);
        //IMPUESTOS
        Impuestos impuestos = new Impuestos();
        //IMPUESTOS-Retenciones
        Retenciones retenciones = new Retenciones();
        //IMPUESTOS-Retencion UNO
        Retencion retencionUno = new Retencion();
        retencionUno.setImpuesto("ISR");
        retencionUno.setImporte(new T_Importe("60000"));
        //IMPUESTOS-Retencion DOS
        Retencion retencionDos = new Retencion();
        retencionDos.setImpuesto("IVA");
        retencionDos.setImporte(new T_Importe("60000"));
        retenciones.add(retencionUno);
        retenciones.add(retencionDos);
        impuestos.setRetenciones(retenciones);
        //IMPUESTOS-Traslados
        Traslados traslados = new Traslados();
        //IMPUESTOS-Traslado UNO
        Traslado trasladoUno = new Traslado();
        trasladoUno.setImpuesto("IEPS");
        trasladoUno.setTasa(new T_Importe("3.5"));
        trasladoUno.setImporte(new T_Importe("10000"));
        //IMPUESTOS-Traslado DOS
        Traslado trasladoDos = new Traslado();
        trasladoDos.setImpuesto("IVA");
        trasladoDos.setTasa(new T_Importe("3.5"));
        trasladoDos.setImporte(new T_Importe("11000"));
        traslados.add(trasladoUno);
        traslados.add(trasladoDos);
        impuestos.setTraslados(traslados);
        comprobante.setImpuestos(impuestos);
        //COMPLEMENTO
        Complemento complemento = new Complemento();
        //TIMBRE FISCAL
        TimbreFiscalDigital timbre = new TimbreFiscalDigital();
        timbre.setVersion(Constants.VERSION_TIMBRE_FISCAL);
        timbre.setUuid("ad662d33-6934-459c-a128-bdf0393e0f44");
        timbre.setFechaTimbrado(new Date());
        timbre.setSelloCFD("iYyIk1MtEPzTxY3h57kYJnEXNae9lvLMgAq3jGMePsDtEOF6XLWbrV2GL/2TX00vP2+YsP" + "N+5UmyRdzMLZGEfESiNQF9fotNbtA487dWnCf5pUu0ikVpgHvpY7YoA4lB1D/JWc+zntkgW+Ig49WnlKy" + "Xi0LOlBOVuxckDb7EAx4=");
        timbre.setNoCertificadoSAT("30001000000100000801");
        complemento.setTimbreFiscalDigital(timbre);
        comprobante.setComplemento(complemento);
        //		System.out.println(comprobante.getConceptos().getSumaImportesConceptos().getImporte().toString());
        //		//Suma de Subtotal - Descuentos_Aplicables + Impuestos_Trasladados - Impuestos_Retenidos
        //		System.out.println(comprobante.getImpuestos().getTotalImpuestosRetenidos().getImporte().toString());
        //		System.out.println(comprobante.getImpuestos().getTotalImpuestosTrasladados().getImporte().toString());

        //Imprimiendo el Comprobante (toString())
        System.out.println("Comprobante");
        System.out.println(comprobante);
        System.out.println("Cadena original");
        System.out.println(comprobante.getCadenaOriginal()); //Imprimiendo la Cadena Original del Comprobante

        //Encripta
        Encriptador encriptador = new Encriptador();//Encriptacion
        try {
            comprobante.setSello(encriptador.getSelloDigital(comprobante.getCadenaOriginal()));
            timbre.setSelloCFD(comprobante.getSello());
            //encriptador.getSelloDigital(comprobante.getCadenaOriginal());
        } catch (GeneralSecurityException ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }

        JavaToXMLv3 xml = new JavaToXMLv3();
        xml.creaAndValidaXML(comprobante);

    }
}
