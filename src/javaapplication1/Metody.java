/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class Metody {

    public Metody(Inicializacia start) {
        this.start = start;
    }
    
    Inicializacia start;

    public static void lepidlo(ArrayList<Integer> zadanie, int[] riadok) {
        int first = (int) zadanie.get(0);
        for (int i = 0; i < first; i++) {
            if (riadok[i] == 1) {                //stvorcek je zafarbeny
                for (int j = i; j < first; j++) {
                    riadok[j] = 1;
                }
            }
        }
    }

    public static void jednoduche_medzery(ArrayList<Integer> zadanie, int[] riadok, int size) {
        int sucet = 0;
        int max = 0;
        for (Integer i : zadanie) {
            sucet += (int) i;
            if (max < (int) i) {
                max = i;
            }
        }

        int rozdiel = size - sucet - zadanie.size() + 1;
        if (rozdiel < max) { //aby sme neprehladavali riadok zbytocne

            int index = rozdiel;
            for (Integer i : zadanie) {
                if ((int) i - rozdiel <= 0) {
                    index += (int) i + 1;
                } else {
                    for (int col = 0; col < (int) i - rozdiel; col++) {
                        if (riadok[index] == 2) {
                            System.out.println("chyba!!! na indexe" + index);
                        }
                        riadok[index] = 1;
                        index++;
                    }
                    index += rozdiel + 1;
                }
            }
        } else {
            System.out.println(" nic tu neni");
        }
    }

  

}
