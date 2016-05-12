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
public class Chyba extends Exception {

    String pravidlo;
    int riadok, indicia, krizovka;
   
   
 /**
  * 
  * @param pravidlo nazov pravidla, v ktorom nastala chyba
  * @param riadok na ktorom riadku problem vznikol
  * @param indicia na ktorej indicii to bolo
  */
    public Chyba(String pravidlo, int riadok, int indicia, int krizovka) {
        this.indicia = indicia;
        this.pravidlo = pravidlo;
        this.riadok = riadok;
        this.krizovka = krizovka;
    }
    
     @Override
        public String getMessage() {
            return "chyba v krizovke " + krizovka + " v pravidle "+ pravidlo + " na riadku " + riadok + " v indicii " +  indicia;
        }
}
//