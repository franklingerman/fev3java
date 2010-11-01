/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mx.edu.um;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author eder
 */
public class ObjetoBase {
    protected Locale local = new java.util.Locale (Constants.LOCALE_LANGUAGE, Constants.LOCALE_COUNTRY, Constants.LOCALE_VARIANT);
    protected SimpleDateFormat sdf = new SimpleDateFormat (Constants.DATE_SHORT_HUMAN_PATTERN, local);

}
