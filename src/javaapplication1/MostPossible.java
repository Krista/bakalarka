/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krista
 */
public class MostPossible extends Pravidla {

    //Inicializacia inic;
    public boolean[][] step_1;
    public boolean[][] step_2;
    public boolean[] c_white;
    public boolean[] c_black;

    public MostPossible(Inicializacia start_R, Inicializacia start_S) {
        super(start_R, start_S);
      //  this.inic = start;
        //Start(0);
    }
    
       @Override
        public int getID() {return  14;}
    
        @Override
    public int run(int num, Inicializacia start) throws Porucha {
        boolean b = false;
        return CoToDa(num, start) ? getID() : 0;
    }

    public boolean CoToDa(int num, Inicializacia start) throws Porucha {
        this.step_1 = new boolean[start.zadanie.get(num).size()+1][start.p_stlpcov+1];
        this.step_2 = new boolean[start.zadanie.get(num).size()+1][start.p_stlpcov+1];
        this.c_white = new boolean[start.p_stlpcov];
        Arrays.fill(c_white, true);
        this.c_black = new boolean[start.p_stlpcov];
        Arrays.fill(c_black, false);
     step1(num, start);
     step2(num, start);
     step3(num, start);
     step4(num, start);
     if (step5(num,start)) return true;     
     return false;
    }

    /**
     *
     * @param num riadok krizovky
     * @return true, ak existuje riesenie, ze na prvych j policok ulozime prvych
     * i indicii
     */
    public void step1(int num, Inicializacia start) {
        for (int i=0; i< start.zadanie.get(num).size()+1; i++){
            for(int j = 0; j<= start.p_stlpcov; j++){//j je pocet policok ktore berieme v uvahu
                       
        if (i == 0) {
            if (super.najdi_cierne(num, 0, j-1, start).isEmpty()) {
                step_1[i][j] = true;continue;
            } else {
                step_1[i][j] = false;continue;
            }
        }
        if (j==0) {
            if (start.zadanie.get(num).get(i - 1) != 0) {step_1[i][j] = false;continue;}
            else {step_1[i][j] = true;continue;}}
        if (start.riesenie.get(num).get(j-1).value == 0) {
            step_1[i][j] = step_1[i][j - 1];continue;
        }
        if (start.riesenie.get(num).get(j-1).value == 1) {
           step_1[i][j] = uloz_indiciu(num, i, j, start);continue;
        }
        
        step_1[i][j] = step_1[i][j - 1] || uloz_indiciu(num, i, j, start);
    }
        }}

    public boolean uloz_indiciu(int num, int i, int j, Inicializacia inic) {
        int indicia = inic.zadanie.get(num).get(i - 1);
        if (indicia > j|| (j-indicia-1 <0 && i>1)) return false;//indicia je dlhsia ako pocet policok ktore tam mame k disp.
        return super.najdi_biele(num, j - indicia, j-1, inic).isEmpty()
                && ((j - indicia - 1 < 0  && i == 1)
                || ((inic.riesenie.get(num).get(j - indicia - 1).value != 1) && step_1[i - 1][j - 1 - indicia]));
    }

    /**
     *
     * @param num riadok krizovky
     * @param i pocet indicii
     * @param j pocet policok od konca
     * @return true, ak existuje riesenie, ze na j policok od konca, ulozime
     * poslednych i indicii
     */
    public void step2(int num, Inicializacia inic) {
            for (int i=0; i< inic.zadanie.get(num).size()+1; i++){
            for(int j = 0; j<= inic.p_stlpcov; j++){//j je posledne policko ktore berieme v uvahu
        
        int from = inic.p_stlpcov - j;
        int to = inic.p_stlpcov - 1;             
        if (i == 0) {
            if (super.najdi_cierne(num, from, to, inic).isEmpty()) {
                step_2[i][j] = true;continue;
            } else {
                step_2[i][j] = false;continue;
            }
        }
        if (j==0) {if (inic.zadanie.get(num).get(inic.zadanie.get(num).size()-i) != 0) {step_1[i][j] = false;continue;}
            else {step_1[i][j] = true;continue;}}
        
        if (inic.riesenie.get(num).get(from).value == 0) {
            step_2[i][j] = step_2[i][j-1];continue;
        }
        if (inic.riesenie.get(num).get(from).value == 1) {
           step_2[i][j] = uloz_indiciu2(num, i, j, inic);continue;
        }
        
        step_2[i][j] = step_2[i][j-1] || uloz_indiciu2(num, i, j, inic);
    }
        }
              
    }

    public boolean uloz_indiciu2(int num, int i, int j, Inicializacia inic) {
        int p_indi = inic.zadanie.get(num).size();
        int indicia = inic.zadanie.get(num).get(p_indi - i);
         if (indicia > j || (j-indicia-1 <0 && i>1)) return false;
        int from = inic.p_stlpcov - j;
        int to = inic.p_stlpcov - 1;     
        return super.najdi_biele(num, from, from + indicia - 1, inic).isEmpty()
                && ((j - indicia - 1 < 0  && i == 1)
                        || ((inic.riesenie.get(num).get(from+indicia).value != 1) && step_2[i - 1][j - 1 - indicia]));
                
    }

    public void step3(int num, Inicializacia inic) {
        for (int w = 0; w < inic.p_stlpcov; w++) {
            if (inic.riesenie.get(num).get(w).value == 3) {
                for (int i = 0; i <= inic.zadanie.get(num).size(); i++) {
                    if (step_1[i][w] && step_2[inic.zadanie.get(num).size()- i][inic.p_stlpcov - w - 1]) {
                        break;                        
                    }
                    if (i == inic.zadanie.get(num).size()) c_white[w] = false;//toto policko nemoze byt biele
                }
            }
        }
    }

    public void step4(int num, Inicializacia inic) {

        for (int w = 0; w < inic.zadanie.get(num).size(); w++) {//w==ktoru indiciu spracuvavame
            int indi = inic.zadanie.get(num).get(w);
            for (int i = 0; i < inic.p_stlpcov; i++) {
                
                if (i + indi > inic.p_stlpcov)break; //indicia sa tam ani nezmesti
                if (!(i == 0 || inic.riesenie.get(num).get(i - 1).value != 1 )){
                    continue;}                
                if (!(i + indi >= inic.p_stlpcov || inic.riesenie.get(num).get(i + indi).value != 1)) {
                    continue;}                //za ulozenou indiciou mozme dat biele policko
                if (!(super.najdi_biele(num, i, i + indi-1, inic).isEmpty())) {
                    continue;}
                
                if (step_1[w][Math.max(0, i-1)] 
                        && step_2[inic.zadanie.get(num).size()-w-1][Math.max(0, inic.p_stlpcov-indi-i-1)])
                 Arrays.fill(c_black, i, i + indi, true);
//               
        }
      }
    }
    

    public boolean step5(int num, Inicializacia inic) throws Porucha{
        boolean check = false;
            for (int i = 0; i< inic.p_stlpcov; i++){
            if(inic.riesenie.get(num).get(i).value == 3){
                if (c_black[i] && !c_white[i]){inic.riesenie.get(num).get(i).value = 1; check= true;}
                if (!c_black[i] && c_white[i]){inic.riesenie.get(num).get(i).value = 0; check= true;}
                if (!c_black[i] && !c_white[i])throw new Porucha("MostPOSSIBLE", num, i, inic.ID);
            }
        }return check;
    }



}
