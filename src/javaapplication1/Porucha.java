/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author krista
 */
public class Porucha extends Exception {

    String pravidlo;
    int riadok, indicia;
   
    public Porucha() {
    }

    /**
     * Constructs an instance of <code>Porucha</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public Porucha(String pravidlo, int riadok, int indicia) {
        this.indicia = indicia;
        this.pravidlo = pravidlo;
        this.riadok = riadok;
    }
    
     @Override
        public String getMessage() {
            return "chyba pri pravidle " + pravidlo + " na riadku " + riadok + " v indicii " +  indicia;
        }
}
//