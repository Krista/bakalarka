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
public class MostPossible extends Logical_rules {

    Inicializacia inic;
    boolean[][] step_1;
    boolean[][] step_2;
    boolean[] c_white = new boolean[inic.p_stlpcov];
    boolean[][] c_black;
    public MostPossible(Inicializacia start) {
        super(start);
    }

//    public MostPossible(int number) {
//
//    }
    /**
     * 
     * @param num riadok krizovky
     * @param i pocet indicii
     * @param j pocet policok od zaciatku
     * @return true, ak existuje riesenie, ze na prvych j policok ulozime prvych i indicii
     */
    public boolean step1( int num, int i, int j) {
        if (i == 0) {
            if (super.najdi_cierne(num, 0, j-1).isEmpty()) {
                return true;
            } else {
                return false;
            }
        } 
        if (inic.riesenie.get(num).get(j-1).value == 0)return step1(num, i, j-1);
        if (inic.riesenie.get(num).get(j-1).value == 1)
            return step1(num, i-1, j-1-inic.zadanie.get(num).get(i-1));
        return step1(num, i, j-1) || step1(num, i-1, j-1-inic.zadanie.get(num).get(i-1));
    }
    
    /**
     * 
     * @param num riadok krizovky
     * @param i pocet indicii
     * @param j pocet policok od konca
     * @return true, ak existuje riesenie, ze na j policok od konca, ulozime poslednych i indicii
     */
     public boolean step2( int num, int i, int j) {
        int from = inic.p_stlpcov-j-1;
        int to = inic.p_stlpcov-1;        
        if (i == 0) {
            if (super.najdi_cierne(num, from, to).isEmpty()) {
                return true;
            } else {
                return false;
            }
        } 
        if (j<=0)return false;
        if (inic.riesenie.get(num).get(from).value == 0)return step2(num, i, j-1);
        if (inic.riesenie.get(num).get(from).value == 1){
            return step2(num, i-1, j-1-inic.zadanie.get(num).get(i-1));}
        return step2(num, i, j-1) || step2(num, i-1, j-1-inic.zadanie.get(num).get(i-1));
    }
     
     public void step3(int num){
         for(int w=0; w< inic.p_stlpcov; w++){
             if(inic.riesenie.get(num).get(w).value == 3){
                 for(int i=0; i<inic.zadanie.size(); i++){
                 if(step1(num,i,w)&&step2(num,inic.zadanie.get(num).size()-i,inic.p_stlpcov-w-1)) break;
             }c_white[w]=false;//toto policko nemoze byt biele
            }
         }
     }
     
     public void step4(int num){
         c_black = new boolean[inic.zadanie.get(num).size()][inic.p_stlpcov];
         for (int w=0; w<inic.zadanie.get(num).size(); w++){
             int indi = inic.zadanie.get(num).get(w);
          for (int i=0; i<inic.p_stlpcov; i++){
                 if (i ==0|| inic.riesenie.get(num).get(i-1).value==1  || i+indi> inic.p_stlpcov || inic.riesenie.get(num).get(i+indi).value==1)break;
                 if (super.najdi_biele(num, i, i+indi).isEmpty());
                 if (step1(num,w+1,i) && step2(num,inic.zadanie.size()-w,inic.p_stlpcov-w-i));
            
         }
     }
     } 
     
}
