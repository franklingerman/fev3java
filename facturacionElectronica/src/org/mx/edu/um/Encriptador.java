/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mx.edu.um;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import org.apache.commons.ssl.PKCS8Key;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Encoder;

/**
 *
 * @author eder
 */
public class Encriptador {

    public String getSelloDigital(String cadenaOriginal) throws GeneralSecurityException{
        Security.addProvider(new BouncyCastleProvider());
        System.out.println("Cadena Original "+cadenaOriginal);
        FileInputStream archivoClavePrivada=null;
        try{
        archivoClavePrivada=new FileInputStream("/home/eder/developing/CFD/CFDI/Certif_PACyEmisor/emisor.key");
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        String password="a0123456789";

        byte[] clavePrivada = getBytes(archivoClavePrivada);
        PKCS8Key pkcs8 = new PKCS8Key(clavePrivada, password.toCharArray());
        PrivateKey pk = pkcs8.getPrivateKey();
        Signature firma = Signature.getInstance(Constants.ALGORITMO_DIGESTION_AND_CIFRADO);
        firma.initSign(pk);
        String selloDigital = null;
        try {
            firma.update(cadenaOriginal.getBytes("UTF-8"));
            BASE64Encoder b64 = new BASE64Encoder();
            selloDigital = b64.encode(firma.sign());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Sello Digital "+selloDigital);
        return selloDigital;
    }

    private byte[] getBytes(InputStream is) {
        int totalBytes = 714;
        byte[] buffer = null;
        try {
            buffer = new byte[totalBytes];
            is.read(buffer, 0, totalBytes);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
