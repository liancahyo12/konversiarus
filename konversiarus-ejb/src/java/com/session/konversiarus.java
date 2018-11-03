/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Lian CahJaya
 */
@Stateless
@LocalBean
public class konversiarus {
    
    DecimalFormat a = new DecimalFormat("0.0");
    String result;
    
    public String arus(double param, double param2) {
        return result = a.format(param/param2);
    }

    public String hambatan(double param, double param2) {
        return result = a.format(param/param2);
    }

    public String tegangan(double param, double param2) {
        return result = a.format(param*param2);
    }

    
}
