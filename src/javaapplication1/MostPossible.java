/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;

/**
 *
 * @author krista
 */
public class MostPossible extends Logical_rules {

    Inicializacia inic;
    public boolean[][] step_1;
    boolean[][] step_2;
    boolean[] c_white;
    boolean[] c_black;

    public MostPossible(Inicializacia start) {
        super(start);
        this.inic = start;
        //Start(0);
    }

    public void Start(int num) {
        this.step_1 = new boolean[inic.zadanie.get(num).size()+1][inic.p_stlpcov];
        this.step_2 = new boolean[inic.zadanie.get(num).size()+1][inic.p_stlpcov];
        this.c_white = new boolean[inic.p_stlpcov];
        Arrays.fill(c_white, true);
        this.c_black = new boolean[inic.p_stlpcov];
        Arrays.fill(c_black, false);
        
    }

    /**
     *
     * @param num riadok krizovky
     * @param i pocet indicii
     * @param j pocet policok od zaciatku
     * @return true, ak existuje riesenie, ze na prvych j policok ulozime prvych
     * i indicii
     */
    public void step1(int num) {
        for (int i=0; i< inic.zadanie.get(num).size()+1; i++){
            for(int j = 0; j< inic.p_stlpcov; j++){//j je posledne policko ktore berieme v uvahu
                       
        if (i == 0) {
            if (super.najdi_cierne(num, 0, j - 1).isEmpty()) {
                step_1[i][j] = true;continue;
            } else {
                step_1[i][j] = false;continue;
            }
        }
        if (j==0) {step_1[i][j] = false;continue;}
        if (inic.riesenie.get(num).get(j).value == 0) {
            step_1[i][j] = step_1[i][j - 1];continue;
        }
        if (inic.riesenie.get(num).get(j).value == 1) {
           step_1[i][j] = uloz_indiciu(num, i, j);continue;
        }
        
        step_1[i][j] = step_1[i][j - 1] || uloz_indiciu(num, i, j);
    }
        }}

    public boolean uloz_indiciu(int num, int i, int j) {
        int indicia = inic.zadanie.get(num).get(i - 1);
        if (indicia > j + 1 || (j-indicia-1 <0 && i>1)) return false;
        return super.najdi_biele(num, j - indicia +1, j).isEmpty()
                && ((j - indicia - 1 < 0  && i == 1)|| ((inic.riesenie.get(num).get(j - indicia - 1).value != 1)
                && step_1[i - 1][j - 1 - indicia]));
    }

    /**
     *
     * @param num riadok krizovky
     * @param i pocet indicii
     * @param j pocet policok od konca
     * @return true, ak existuje riesenie, ze na j policok od konca, ulozime
     * poslednych i indicii
     */
    public boolean step2(int num, int i, int j) {
        int from = inic.p_stlpcov - j;
        int to = inic.p_stlpcov - 1;
        if (i == 0) {
            if (super.najdi_cierne(num, from, to).isEmpty()) {
                return step_2[i][j] = true;
            } else {
                return step_2[i][j] = false;
            }
        }
        // if (j<=0)return step_1[i][j-1] = false;
        if (inic.riesenie.get(num).get(from).value == 0) {
            return step_2[i][j] = step2(num, i, j - 1);
        }
        if (inic.riesenie.get(num).get(from).value == 1) {
            return step_2[i][j] = uloz_indiciu2(num, i, j);
        }
       // if (j == 0) return
        return step_2[i][j] = step2(num, i, j - 1) || uloz_indiciu2(num, i, j);
    }

    public boolean uloz_indiciu2(int num, int i, int j) {
        int indicia = inic.zadanie.get(num).get(i - 1);
        return super.najdi_biele(num, j - indicia, j - 1).isEmpty()
                && //(j-indicia-1<0 || inic.riesenie.get(num).get(j-indicia-1).value!=1) && 
                (j >= inic.p_stlpcov || inic.riesenie.get(num).get(j).value != 1)
                && //toto nebolo 
                step2(num, i - 1, j - 1 - indicia);
    }

    public void step3(int num) {
        for (int w = 0; w < inic.p_stlpcov; w++) {
            if (inic.riesenie.get(num).get(w).value == 3) {
                for (int i = 0; i < inic.zadanie.size(); i++) {
                    if (step_1[i][w] && step_2[inic.zadanie.get(num).size() - i][inic.p_stlpcov - w - 1]) {
                        break;
                    }
                }
                c_white[w] = false;//toto policko nemoze byt biele
            }
        }
    }

    public void step4(int num) {

        for (int w = 0; w < inic.zadanie.get(num).size(); w++) {
            int indi = inic.zadanie.get(num).get(w);
            for (int i = 0; i < inic.p_stlpcov; i++) {
                if (!(i - 1 == 0 || inic.riesenie.get(num).get(i - 1).value != 1 || i + indi > inic.p_stlpcov || inic.riesenie.get(num).get(i + indi).value != 1)) {
                    break;
                }
                if (!(super.najdi_biele(num, i, i + indi).isEmpty())) {
                    break;
                }
                if (step_1[w + 1][i] && step_2[inic.zadanie.size() - w][inic.p_stlpcov - w - i]);
                Arrays.fill(c_black, i, i + indi, true);
            }
        }
    }
    
    public void step5(int num) throws Porucha{
        for (int i = 0; i< inic.p_stlpcov; i++){
            if(inic.riesenie.get(num).get(i).value == 3){
                if (c_black[i] && !c_white[i])inic.riesenie.get(num).get(i).value = 1;
                if (!c_black[i] && c_white[i])inic.riesenie.get(num).get(i).value = 0;
            }
            else throw new Porucha("MostPOSSIBLE", num, i);
        }
    }

}
