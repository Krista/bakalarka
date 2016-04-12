/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.sun.media.sound.InvalidFormatException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class Logical_rules {

    private Inicializacia start; //obsahuje hranice jednotlivych cisel zadani
    private ArrayList<ArrayList<Integer>> zadanie;
    private ArrayList<ArrayList<MyInt>> riesenie;

    public Logical_rules(Inicializacia start) {
        this.start = start;
        this.zadanie = start.zadanie;
        this.riesenie = start.riesenie;
    }

    public void set_r(ArrayList<MyInt> list, int i) {
        this.riesenie.set(i, list);
    }

    public boolean prienik(int num) throws Porucha { //rule 1.1
        int poc_cisel = start.pole_hodnot[num].length;
        int rozdiel = 0;
        int act_cislo;
        int farbi;
        int zaciatok;
        boolean check = false;
        for (int i = 0; i < poc_cisel; i++) {
            zaciatok = start.pole_hodnot[num][i][0];
            rozdiel = start.pole_hodnot[num][i][1] + 1 - zaciatok;
            act_cislo = zadanie.get(num).get(i);
            if (rozdiel < act_cislo) {
                throw new Porucha("PRIENIK", num, i);
            }
            if (act_cislo * 2 > rozdiel) {
                farbi = rozdiel - act_cislo;
                for (int x = 0; x < (act_cislo * 2 - rozdiel); x++, farbi++) {
                    if (riesenie.get(num).get(zaciatok + farbi).value != 1) {
                        if (riesenie.get(num).get(zaciatok + farbi).value == 0) throw new Porucha("prienik", num, i);
                        System.out.println("riadok: " + num + " rule 1.1 , policko: " + (zaciatok + farbi));
                        riesenie.get(num).get(zaciatok + farbi).value = 1;
                        check = true;
                    }
                }
            }if (act_cislo == 0) { for(int w=0; w< start.p_stlpcov; w++) riesenie.get(num).get(w).value = 0; check = true;}
        }return check;
    }

    public boolean jed_medzery(int num) throws Porucha {//rule 1.2
        boolean check = false;
        int poc_indicii = zadanie.get(num).size() - 1;
        for (int i = 0; i < start.pole_hodnot[num][0][0]; i++) { //rule 1.2 (1)
            if (riesenie.get(num).get(i).value != 0) {
                if (riesenie.get(num).get(i).value == 1) throw new Porucha("jed_medzery0", num, i);
                System.out.println("riadok: " + num + " rule 1.2.1 , policko: " + i);
                riesenie.get(num).get(i).value = 0;
                check = true;
            }
        }
        for (int i = start.pole_hodnot[num][poc_indicii][1] + 1; i < start.p_stlpcov; i++) { //rule 1.2 (2)
            if (riesenie.get(num).get(i).value != 0) {
                if (riesenie.get(num).get(i).value == 1) throw new Porucha("jed_medzery1", num, i);
                System.out.println("riadok: " + num + " rule 1.2.2 , policko: " + i);
                riesenie.get(num).get(i).value = 0;
                check = true;
            }
        }
        for (int i = 0; i < poc_indicii; i++) { // rule 1.2 (3)
            // if (start.pole_hodnot[num][i + 1][0] < start.pole_hodnot[num][i][1]) {
            for (int x = start.pole_hodnot[num][i][1] + 1; x < start.pole_hodnot[num][i + 1][0]; x++) {
                if (riesenie.get(num).get(x).value != 0) {
                    if (riesenie.get(num).get(x).value == 1) throw new Porucha("jed_medzery2", num, i);
                    System.out.println("riadok: " + num + " rule 1.2.3 , policko: " + x);
                    riesenie.get(num).get(x).value = 0;
                    check = true;
                }
            }
            // }
        }return check;
    }

    public boolean jednotky(int num) throws Porucha { // rule 1.3 - pred
        int pocet_indicii = zadanie.get(num).size();
        int s_pozicia;
        boolean check = false;
        for (int i = 1; i < pocet_indicii; i++) {
            s_pozicia = start.pole_hodnot[num][i][0];
            if (riesenie.get(num).get(s_pozicia).value == 1 && riesenie.get(num).get(s_pozicia - 1).value == 3) {
                ArrayList<Integer> pom = najdi_cisla(num, s_pozicia);
                pom.remove(Integer.valueOf(i));
                if (maximum(num, pom) == 1) {
                    if (riesenie.get(num).get(s_pozicia - 1).value == 1) throw new Porucha("jednotky", num, i);
                    System.out.println("riadok: " + num + " rule 1.3.1 , policko: " + (s_pozicia - 1));
                    riesenie.get(num).get(s_pozicia - 1).value = 0;
                    check = true;
                }
            }
        } boolean check2 = jednotky_za(num, check);
        return check||check2;
    }

    public boolean jednotky_za(int num, boolean check) throws Porucha { //rule 1.3 - za 
        int pocet = zadanie.get(num).size();
        int e_pozicia;
        for (int i = 0; i < pocet - 1; i++) {
            e_pozicia = start.pole_hodnot[num][i][1];
            if (riesenie.get(num).get(e_pozicia).value == 1) {
                ArrayList<Integer> pom = najdi_cisla(num, e_pozicia);
                pom.remove(Integer.valueOf(i));
                if (maximum(num, pom) == 1 && riesenie.get(num).get(e_pozicia + 1).value == 3) {
                    if (riesenie.get(num).get(e_pozicia + 1).value == 1) throw new Porucha("jednotky_za", num, i);
                    System.out.println("riadok: " + num + " rule 1.3.2 , policko: " + (e_pozicia + 1));
                    riesenie.get(num).get(e_pozicia + 1).value = 0;
                    check = true;
                }
            }
        }return check;
    }

    public boolean vynutenie(int num) {//rule 1.4
        boolean check = false;
        for (int i = 0; i < riesenie.get(num).size() - 2; i++) {
            if (riesenie.get(num).get(i).value == 1 && riesenie.get(num).get(i + 1).value == 3 && riesenie.get(num).get(i + 2).value == 1) {
                //riesenie.get(num).get(i + 1).value = 1; //skusame zafarbit
                int d1 = dlzka_sek(num, i);
                int d2 = dlzka_sek(num, i+2);
                ArrayList<Integer> pom = najdi_cisla(num, i-d1+1, i+d2+1);
                //ArrayList<Integer> pom2 = najdi_cisla(num, i+d2+1);
               // pom.retainAll(pom2);//v pom necha len tie indicie, ktore su v oboch arraylistoch
        //System.out.println(pom.toString());
                if (pom.isEmpty() || d1+d2+1 > maximum(num, pom)) {
                    System.out.println("riadok: " + num + " rule 1.4 , policko: " + (i + 1));
                    riesenie.get(num).get(i + 1).value = 0;
                    check = true;
                }
            }
        }return check;
    }

    public boolean lepidlo(int num) { // problem ak je vyfarbene prve policko v riadku
        int min, max;
        ArrayList<Integer> sek;
        int biele, biele2;
        boolean check;
       check = (lep_zac(num) || lep_kon(num));       
       
        for (int i = 1; i < start.p_stlpcov; i++) {//bod 0
            if (riesenie.get(num).get(i - 1).value != 1 && riesenie.get(num).get(i).value == 1) {
                sek = najdi_cisla(num, i);
                min = minimum(num, sek);//bod 1
                biele = -1;
                biele2 = start.p_stlpcov;
                for (int j = Math.max(i - 1, 0); j >= Math.max(i - min + 1, 0); j--) {//hladame biely stvorcek niekde vpredu - bod 2
                    if (riesenie.get(num).get(j).value == 0) {
                        biele = j;
                        break;
                    }
                }
                if (biele != -1 || (i - min + 1) < 0) {//ak sa naslo, alebo je to na zaciatku
                    for (int x = i + 1; x <= biele + min; x++) { //nemusime sa bat pretecenia, keby sa stalo, je problem v krizovke
                        if (riesenie.get(num).get(x).value != 1) {
                            System.out.println("riadok: " + num + "rule 1.5.2 , policko: " + x);
                            riesenie.get(num).get(x).value = 1;
                            check = true;
                        }
                    }
                }
                
                
                for (int j = i + 1; j < Math.min(i + min, start.p_stlpcov); j++) {//bod 3 hladame biely vzadu
                    if (riesenie.get(num).get(j).value == 0) {
                        biele2 = j;
                        break;
                    }
                }

                if (biele2 != start.p_stlpcov || (i + min) > start.p_stlpcov) {
                    for (int x = i - 1; x >= biele2 - min; x--) {
                        if (riesenie.get(num).get(x).value != 1) {
                            System.out.println("riadok: " + num + "rule 1.5.3 , policko: " + x);
                            riesenie.get(num).get(x).value = 1;
                            check = true;
                        }
                    }
                }
                
                max = maximum(num, sek);//bod 4
                int[] w=hranice_sek(num,i);
                if (min == max && min == w[1]-w[0]+1) {
                    if (w[0]-1>=0 && riesenie.get(num).get(w[0]-1).value != 0) {
                        System.out.println("riadok: " + num + "rule 1.5.4 , policko: " + (w[0]- 1));
                        riesenie.get(num).get(w[0] - 1).value = 0;
                        check = true;
                    }
                    if (w[1]+1 < start.p_stlpcov && riesenie.get(num).get(w[1]+1).value != 0) {
                        System.out.println("riadok: " + num + "rule 1.5.5 , policko: " + (w[1]+1));
                        riesenie.get(num).get(w[1]+1).value = 0;
                        check = true;
                    }
                    if (sek.size() == 1) {// sekvencia patri len jednej indicii
                        if (start.pole_hodnot[num][sek.get(0)][0] != w[0]) {
                            System.out.println("update1.5+ " + num);
                            start.pole_hodnot[num][sek.get(0)][0] = w[0];
                            check = true;
                        }
                        if (start.pole_hodnot[num][sek.get(0)][1] != w[1]) {
                            start.pole_hodnot[num][sek.get(0)][1] = w[1];
                            System.out.println("update1.5- " + num);
                            check = true;
                            //System.out.println(Arrays.toString(start.pole_hodnot[num][sek.get(0)]));
                        }
                    }
                }

            }

        }
        return check;
    }
    /**
     * 
     * @param num cislo riadka
     * specialny pripad pravidla 1.5 - LEPIDLO, ked je prvé políčko v riadku čierne
     */
    public boolean lep_zac(int num){
        boolean check = false;
         if (riesenie.get(num).get(0).value == 1) {
            int cislo = start.zadanie.get(num).get(0);
            for (int x = 1; x < cislo; x++) { //nemusime sa bat pretecenia, keby sa stalo, je problem v krizovke
                if (riesenie.get(num).get(x).value != 1) {
                    System.out.println("riadok: " + num + "rule 1.5.2f , policko: " + x);
                    riesenie.get(num).get(x).value = 1;
                    check = true;
                }
            }
            if (cislo < start.p_stlpcov && riesenie.get(num).get(cislo).value != 0) {
                System.out.println("riadok: " + num + "rule 1.5.0f , policko: " + cislo);
                riesenie.get(num).get(cislo).value = 0;
                start.pole_hodnot[num][0][1] = cislo-1; //upravime koncovu hranicu
                check = true;
            }
        }return check;
    }
    
    /**
     * 
     * @param num cislo riadka
     * specialny pripad pravidla 1.5 - LEPIDLO, ked je posledné políčko v riadku čierne
     */
    public boolean lep_kon(int num){
        boolean check = false;
         if (riesenie.get(num).get(start.p_stlpcov - 1).value == 1) { 
            int posledne = start.zadanie.get(num).size() - 1;
            int cislo = start.zadanie.get(num).get(posledne);
            if (start.p_stlpcov - cislo > 0 && riesenie.get(num).get(start.p_stlpcov - cislo - 1).value != 0) {
                System.out.println("riadok: " + num + "rule 1.5.0l , policko: " + (start.p_stlpcov - cislo - 1));
                riesenie.get(num).get(start.p_stlpcov - cislo - 1).value = 0;
                start.pole_hodnot[num][posledne][0] = start.p_stlpcov - cislo - 1;
                check = true;
            }
            for (int x = start.p_stlpcov - cislo; x < start.p_stlpcov; x++) {
                if (riesenie.get(num).get(x).value != 1) {
                    System.out.println("riadok: " + num + "rule 1.5.2l , policko: " + x);
                    riesenie.get(num).get(x).value = 1;
                    check = true;
                }
            }
        }return check;
    }

    public boolean update0(int num) {
        boolean check = false;
        for (int i = 0; i < zadanie.get(num).size() - 1; i++) {
            if (start.pole_hodnot[num][i][0] + zadanie.get(num).get(i) >= start.pole_hodnot[num][i + 1][0]) {
                System.out.println("update0a riadok" + num + "indicia " + (i+1) + " na policko " + (start.pole_hodnot[num][i][0] + zadanie.get(num).get(i) + 1));
                start.pole_hodnot[num][i + 1][0] = start.pole_hodnot[num][i][0] + zadanie.get(num).get(i) + 1;
                check = true;
            }
            if (start.pole_hodnot[num][i][1] >= start.pole_hodnot[num][i + 1][1] - zadanie.get(num).get(i + 1)) {
                System.out.println("update0b riadok" + num + "indicia " + i +" na policko " + (start.pole_hodnot[num][i + 1][1] - zadanie.get(num).get(i + 1) - 1));
                start.pole_hodnot[num][i][1] = start.pole_hodnot[num][i + 1][1] - zadanie.get(num).get(i + 1) - 1;
                check = true;
            }
        }return check;
    }

    public boolean update1(int num) {
        int poz_e, poz_s;
        boolean check = false;

        for (int i = 0; i < zadanie.get(num).size() - 1; i++) {
            poz_e = start.pole_hodnot[num][i][1];
            poz_s = start.pole_hodnot[num][i + 1][0];
            if (riesenie.get(num).get(poz_e + 1).value == 1) {
                int x = poz_e;
                while (riesenie.get(num).get(x).value == 1) {
                    x--;
                }
                System.out.println("update1a riadok" + num + "indicia: " + i);
                start.pole_hodnot[num][i][1] = x - 1;
                check = true;
            }
            if (riesenie.get(num).get(poz_s - 1).value == 1) {
                int x = poz_s;
                while (riesenie.get(num).get(x).value == 1) {
                    x++;
                }
                System.out.println("update1b riadok" + num + "indicia: " + (i + 1));
                start.pole_hodnot[num][i + 1][0] = x + 1;
                check = true;
            }
        }return check;
    }


    public boolean update2(int num) {// treba predtym spravit predchadzajuce updaty
        int indicia, dlzka_seg;
        int x = 0;
        boolean check = false;
        ArrayList<ArrayList<Integer>> sek;
        for (int i = 0; i < zadanie.get(num).size(); i++) {
            indicia = zadanie.get(num).get(i);
            sek = seg_cierne(num, i);            
            for (int j = 0; j < sek.size(); j++) {
                dlzka_seg = sek.get(j).get(1) - sek.get(j).get(0) + 1;
                if (dlzka_seg > indicia) { // toto sa robi v RULE 3.2 - blbost, tam sa updatuju prilis kratke segmenty
                    ArrayList<Integer> cisla = najdi_cisla(num, sek.get(j).get(0));
                    if (sek.get(j).get(0) - start.pole_hodnot[num][i][0] - 1 < indicia //cize sa indicia dopredu nezmesti
                            || (cisla.size() == 2 && cisla.get(1).equals(i))) {
                        System.out.println("    update2a riadok " + num + " indicia " + i + "["+ (sek.get(j).get(1) + 2)+"]");
                        start.pole_hodnot[num][i][0] = sek.get(j).get(1) + 2;
                        check = true;
                    } else if (start.pole_hodnot[num][i][1] - sek.get(j).get(1) - 1 < indicia
                            || (cisla.size() == 2  && cisla.get(0).equals(i))) {
                        System.out.println("    update2b riadok " + num + " indicia " + i + "["+(sek.get(j).get(0) - 2)+"]");
                        start.pole_hodnot[num][i][1] = sek.get(j).get(0) - 2;
                        check = true;
                        break;//vdaka tomu nemusime prechadzat z oboch stran, pri prvom nastaveni E koncime
                    }
                }
            }
        }return check;
    }

    public boolean medzivypln(int num) throws Porucha {// rule 3.1
        int zac, kon;           //pred tymto pravidloom NUTNE aplikovat UPDATE 1---urcite??
        ArrayList<Integer> list;
        boolean check = false;
        for (int i = 1; i < zadanie.get(num).size() - 1; i++) {
            zac = Math.max(start.pole_hodnot[num][i - 1][1]+1, start.pole_hodnot[num][i][0]);
            kon = Math.min(start.pole_hodnot[num][i + 1][0]-1, start.pole_hodnot[num][i][1]);
            list = najdi_cierne(num, zac, kon);//zac a kon zabezpecuju, ze najdene cierne budu patrit len 1 indicii
            if (list.size() > 1) {
                for (int x = list.get(0); x < list.get(list.size()-1); x++) {//spaja vsetky cierne sekvencie dokopy
                    if (riesenie.get(num).get(x).value == 3) {
                        System.out.println("riadok: " + num + "rule 3.1 , policko: " + x);
                        riesenie.get(num).get(x).value = 1;
                        check = true;
                    }else if (riesenie.get(num).get(x).value==0) throw new Porucha("Medzivypln", num, i);
                    
                }
                int[] hr = hranice_sek(num, list.get(0));
                int u = zadanie.get(num).get(i) - (hr[1]-hr[0]+1); //kolko zostava vyfarbit
               // System.out.println("prestavujem inic 3.1 na " + num );
                start.pole_hodnot[num][i][0] = Math.max(hr[0] - u, start.pole_hodnot[num][i][0]);
                start.pole_hodnot[num][i][1] = Math.min(hr[1] + u, start.pole_hodnot[num][i][1]);
                   System.out.println("prestavujem inic 3.1 na " + num + " ["+  start.pole_hodnot[num][i][0]+ start.pole_hodnot[num][i][1] +"]");
                check = true;
            }
        }return check;
    }

    public boolean okliestenie(int num) {// rule3.2
        ArrayList<ArrayList<Integer>> list;
        int dlzka;
        boolean check = false;
        for (int i = 0; i < zadanie.get(num).size(); i++) {
            list = segmenty(num, i);

            for (int x = 0; x < list.size(); x++) {//pozerame zlava
                dlzka = list.get(x).get(1) - list.get(x).get(0) + 1;
                if (start.pole_hodnot[num][i][0] != list.get(x).get(0)) { //nastavujeme na zaciatok potencionalnej sekvencie
                    System.out.println("rule 3.2a " + num);
                    start.pole_hodnot[num][i][0] = list.get(x).get(0);//ak nam to pretecie, tak je chyba v krizovke
                check = true;
                }
                if (dlzka >= zadanie.get(num).get(i)) {
                    break;
                }

            }

            for (int x = list.size() - 1; x >= 0; x--) { //pozerame sprava
                dlzka = list.get(x).get(1) - list.get(x).get(0) + 1;
                if (start.pole_hodnot[num][i][1] != list.get(x).get(1)) {
                    System.out.println("rule 3.2b " + num);
                    start.pole_hodnot[num][i][1] = list.get(x).get(1);//ak nam to pretecie, tak je chyba v krizovke
                check = true;
                }
                if (dlzka >= zadanie.get(num).get(i)) {
                    break;
                }
            }
        }return check;
    }
    
    public boolean prve_cierne(int num){//rule 3.3.1
         int zac, dlzka, kon;
        boolean check = false;
        int pocet = zadanie.get(num).size();
        for (int i = 1; i < pocet-1; i++) {
            zac = start.pole_hodnot[num][i][0];
            kon = start.pole_hodnot[num][i][1];
            dlzka = zadanie.get(num).get(i);
            if (start.pole_hodnot[num][i - 1][1] < zac) {//pravidlo robime, len ak sa cisla neprekryvaju 

                if (riesenie.get(num).get(zac).value == 1) {//case 1//nepotrebuje i==0
                    for (int x = 1; x < dlzka; x++) {
                        if (riesenie.get(num).get(x + zac).value == 3) {
                            System.out.println("riadok: " + num + "rule 3.3.1 , policko: " + (x + zac));
                            riesenie.get(num).get(x + zac).value = 1;
                            check = true;
                        }
                    }
                    if (riesenie.get(num).get(zac - 1).value != 0) {//len nastavime predchadzajuce policko prazdne
                        System.out.println("riadok: " + num + "rule 3.3.1b , policko: " + (zac - 1));
                        riesenie.get(num).get(zac - 1).value = 0;
                        check = true;
                    }
                    if (riesenie.get(num).get(dlzka + zac).value != 0) {//kedze je prve vyfarbene za sekvenciou musi nasledovat prazdne policko
                        riesenie.get(num).get(dlzka + zac).value = 0;
                        check = true;
                    }
                    //System.out.println("rule 3.3a " + num);
                    start.pole_hodnot[num][i][1] = zac + dlzka - 1;
                }
             }
        }return check;
    }
    
    public boolean prekazka(int num){
         int zac, dlzka, kon;
        boolean check = false;
        int pocet = zadanie.get(num).size();
        for (int i = 0; i < pocet; i++) {
            zac = start.pole_hodnot[num][i][0];
            kon = start.pole_hodnot[num][i][1];
            dlzka = zadanie.get(num).get(i);
            if (i == 0 || start.pole_hodnot[num][i - 1][1] < zac) {//pravidlo robime, len ak sa cisla neprekryvaju 
                boolean bola_cierna = false;
                for (int y = zac; y <= kon; y++) {//case 2
                    if (riesenie.get(num).get(y).value == 1) {
                        bola_cierna = true;
                    }
                    if (bola_cierna == true && riesenie.get(num).get(y).value == 0) {
                        System.out.println("rule 3.3d " + num);
                        start.pole_hodnot[num][i][1] = y - 1;
                        check = true;
                        break;
                    }
                }
            }
         }return check;
    }

    public boolean rozdelenie(int num){
          int zac, dlzka, kon;
        boolean check = false;
        int pocet = zadanie.get(num).size();
        for (int i = 0; i < pocet; i++) {
            zac = start.pole_hodnot[num][i][0];
            kon = start.pole_hodnot[num][i][1];
            dlzka = zadanie.get(num).get(i);
            if (i == 0 || start.pole_hodnot[num][i - 1][1] < zac) {//pravidlo robime, len ak sa cisla neprekryvaju 
               ArrayList<ArrayList<Integer>> seg = seg_cierne(num, i);
                 for (int p = 1; p < seg.size(); p++) {//case 3
                    if (seg.get(p).get(1) - seg.get(0).get(0) + 1 > dlzka) {
                      //  MyInt.jeden_toString(riesenie.get(num));
                        System.out.println("    rule 3.3e " + num + "indi "+ i + "na" + (seg.get(p).get(0) - 2));
                        start.pole_hodnot[num][i][1] = seg.get(p).get(0) - 2;//toto ide aj tesnejsie obkolesit
                        check = true;
                        break;
                    }

                }
            }
         }return check;
    }
    
    public boolean nekryjuce(int num) {//rule 3.3
        int zac, dlzka, kon;
        boolean check = false;
        int pocet = zadanie.get(num).size();
        for (int i = 0; i < pocet; i++) {
            zac = start.pole_hodnot[num][i][0];
            kon = start.pole_hodnot[num][i][1];
            dlzka = zadanie.get(num).get(i);
            if (i == 0 || start.pole_hodnot[num][i - 1][1] < zac) {//pravidlo robime, len ak sa cisla neprekryvaju 

                if (riesenie.get(num).get(zac).value == 1) {//case 1//nepotrebuje i==0
                    for (int x = 1; x < dlzka; x++) {
                        if (riesenie.get(num).get(x + zac).value == 3) {
                            System.out.println("riadok: " + num + "rule 3.3.1 , policko: " + (x + zac));
                            riesenie.get(num).get(x + zac).value = 1;
                            check = true;
                        }
                    }
                    if (i != 0 && riesenie.get(num).get(zac - 1).value != 0) {//len nastavime predchadzajuce policko prazdne
                        System.out.println("riadok: " + num + "rule 3.3.1b , policko: " + (zac - 1));
                        riesenie.get(num).get(zac - 1).value = 0;
                        check = true;
                    }
                    if (dlzka + zac < start.p_stlpcov && riesenie.get(num).get(dlzka + zac).value != 0) {//kedze je prve vyfarbene za sekvenciou musi nasledovat prazdne policko
                        riesenie.get(num).get(dlzka + zac).value = 0;
                        check = true;
                    }
                    //System.out.println("rule 3.3a " + num);
                    start.pole_hodnot[num][i][1] = zac + dlzka - 1;

//                    if (i + 1 != pocet && start.pole_hodnot[num][i + 1][0] < start.pole_hodnot[num][i][1] + 1) {
//                        System.out.println("rule 3.3b " + num);
//                        start.pole_hodnot[num][i + 1][0] = start.pole_hodnot[num][i][1] + 2;
//                    }
//                    if (i != 0 && start.pole_hodnot[num][i - 1][1] > zac - 1) {
//                        System.out.println("rule 3.3c " + num);                   //riesi sa v update1
//                        start.pole_hodnot[num][i - 1][1] = zac - 2;
//                    }
                }

                boolean bola_cierna = false;
                for (int y = zac; y <= kon; y++) {//case 2
                    if (riesenie.get(num).get(y).value == 1) {
                        bola_cierna = true;
                    }
                    if (bola_cierna == true && riesenie.get(num).get(y).value == 0) {
                        System.out.println("rule 3.3d " + num);
                        start.pole_hodnot[num][i][1] = y - 1;
                        check = true;
                        break;
                    }
                }

                ArrayList<ArrayList<Integer>> seg = new ArrayList<>();
                seg = seg_cierne(num, i);

                for (int p = 1; p < seg.size(); p++) {//case 3
                    if (seg.get(p).get(1) - seg.get(0).get(0) + 1 > dlzka) {
                        System.out.println("rule 3.3e " + num);
                        start.pole_hodnot[num][i][1] = seg.get(p).get(0) - 2;//toto ide aj tesnejsie obkolesit
                        check = true;
                        break;
                    }

                }

            }
        }return check;
    }

    
    /**
     * 
     * @param num cislo riadka
     * @param from index stvorceka
     * @return dlzka sekvencie, ktora obsahuje stvorcek from, vracia 0, ak stvorcek from nie je cierny
     */    
    private int dlzka_sek(int num, int from) {//pocet za sebou iducich ciernych policok obsahujuci policko from
        int dlzka = 0;
        if (riesenie.get(num).get(from).value == 0) { //ak FROM nie je cierne, nema zmysel volat tuto funckiu
            return 0;
        }
        int pom = from - 1;
        while (pom > 0 && riesenie.get(num).get(pom).value == 1) {//ak su nejake cierne este pred tymto polickom
            dlzka++;
            pom--;
        }
        while (from < start.p_stlpcov && riesenie.get(num).get(from).value == 1) {
            dlzka++;
            from++;
        }
        //System.out.println(dlzka);
        return dlzka;
    }
    
       /**
     * 
     * @param num cislo riadka
     * @param cell index stvorceka
     * @return krajne hodnoty sekvencie, ktora obsahuje stvorcek cell, vracia null, ak stvorcek cell nie je cierny
     */    
    private int[] hranice_sek(int num, int cell) {//pocet za sebou iducich ciernych policok obsahujuci policko cell
         if (riesenie.get(num).get(cell).value == 0) { //ak FROM nie je cierne, nema zmysel volat tuto funckiu
            return null;
        }
        int pom = cell - 1;
        while (pom > 0 && riesenie.get(num).get(pom).value == 1) {//ak su nejake cierne este pred tymto polickom
          pom--;
        }
        while (cell < start.p_stlpcov && riesenie.get(num).get(cell).value == 1) {
           cell++;
        }
       
        int i[]= {pom+1,cell-1}; 
        //System.out.println(Arrays.toString(i));
        return i;
    }
    
/**
 * 
 * @param num cislo riadka
 * @return hodnotu najvacsej indicie
 */
    private int naj_cislo(int num) {//vracia najvacsie cislo v riadku
        int naj = 0;
        for (int i = 0; i < zadanie.get(num).size(); i++) {
            if (zadanie.get(num).get(i) > naj) {
                naj = zadanie.get(num).get(i);
            }
        }
        return naj;
    }

    /**
     * 
     * @param num cislo riadka
     * @param cell index stvorceka
     * @return zoznam indicii, ktore mozu byt na policku cell, vracia poradove cisla z riadka
     */
    private ArrayList<Integer> najdi_cisla(int num, int cell) { 
        int pocet = zadanie.get(num).size();
        ArrayList<Integer> zoznam = new ArrayList<>();
        for (int i = 0; i < pocet; i++) {
            if (start.pole_hodnot[num][i][0] <= cell && start.pole_hodnot[num][i][1] >= cell) {
                zoznam.add(i);
            }
        }
        return zoznam;
    }
    
    /**
     * 
     * @param num cislo riadka
     * @param from zaciatocne policko intevalu
     * @param to posledne policko z intevalu
     * @return zoznam indicii, ktore mozu pokryvat interval from-to, vracia poradove cisla z riadka
     */
    private ArrayList<Integer> najdi_cisla(int num, int from, int to) { 
        int pocet = zadanie.get(num).size();
        ArrayList<Integer> zoznam = new ArrayList<>();
        for (int i = 0; i < pocet; i++) {
            if (start.pole_hodnot[num][i][0] <= from && start.pole_hodnot[num][i][1] >= to) {
                zoznam.add(i);
            }
        }
        return zoznam;
    }
 
    /**
     * 
     * @param num cislo riadka
     * @param cislo index indicie
     * @return v hraniciach indicie najde zaciatky vsetkych ciernych sekvencii, ktore sa v hraniciach nachadzaju
     */
    private ArrayList<Integer> najdi_cierne(int num, int cislo) {
        ArrayList<Integer> zoznam = new ArrayList<>();
        for (int i = start.pole_hodnot[num][cislo][0]; i <= start.pole_hodnot[num][cislo][1]; i++) {
            if (riesenie.get(num).get(i).value == 1) {
                zoznam.add(i);
                i++; //medzi 2 black run musi byt aspon jedno policko aj tak prazdne
                while (i < start.pole_hodnot[num][cislo][1] && riesenie.get(num).get(i).value == 1) {
                    i++;
                }
            }
        }
        return zoznam;
    }

    /**
     * 
     * @param num cislo riadka
     * @param zac zaciatocne policko
     * @param kon koncove policko
     * @return na intervale ohranicenom zac a kon najde vsetky zaciatky ciernych sekvencii nachadzajucich sa tu. Ak je zac cierne, 
     * ale cierna sekvencia obsahujuca toto policko ma zaciatok pred tymto polickom, do zoznamu sa dostane policko zac. 
     * Vracia zoznam vsetkych zaciatkov.
     */
    protected ArrayList<Integer> najdi_cierne(int num, int zac, int kon) {
        ArrayList<Integer> zoznam = new ArrayList<>();
        for (int i = zac; i <= kon; i++) {
            if (riesenie.get(num).get(i).value == 1) {
                zoznam.add(i);
                i++; //medzi 2 black run musi byt aspon jedno policko aj tak prazdne
                while (i < kon && riesenie.get(num).get(i).value == 1) {
                    i++;
                }
            }
        }
        return zoznam;
    }
    
       /**
     * 
     * @param num cislo riadka
     * @param zac zaciatocne policko
     * @param kon koncove policko
     * @return na intervale ohranicenom zac a kon najde vsetky zaciatky ciernych sekvencii nachadzajucich sa tu. Ak je zac cierne, 
     * ale cierna sekvencia obsahujuca toto policko ma zaciatok pred tymto polickom, do zoznamu sa dostane policko zac. 
     * Vracia zoznam vsetkych zaciatkov.
     */
    protected ArrayList<Integer> najdi_biele(int num, int zac, int kon) {
        ArrayList<Integer> zoznam = new ArrayList<>();
        for (int i = zac; i <= kon; i++) {
            if (riesenie.get(num).get(i).value == 0) {
                zoznam.add(i);
                i++; //medzi 2 black run musi byt aspon jedno policko aj tak prazdne
                while (i < kon && riesenie.get(num).get(i).value == 0) {
                    i++;
                }
            }
        }
        return zoznam;
    }

    /**
     * 
     * @param num cislo riadka
     * @param cislo index indicie
     * @return v hraniciach indicie najde vsetky cierne sekvencie, vracia ako dvojicu [i,j], 
     * kde i je zaciatok a j koncove policko
     */
    private ArrayList<ArrayList<Integer>> seg_cierne(int num, int cislo) {//pozor, ak je len jedno cierne policko na 1. pozicii, dostaneme hodnotu [0,0] ale dlzka je 1
        ArrayList<ArrayList<Integer>> zoznam = new ArrayList<>();
        ArrayList<Integer> a;

        for (int i = start.pole_hodnot[num][cislo][0]; i <= start.pole_hodnot[num][cislo][1]; i++) {
            if (riesenie.get(num).get(i).value == 1) {
                a = new ArrayList<>();
                a.add(i);
                i++;
                while (i <= start.pole_hodnot[num][cislo][1] && riesenie.get(num).get(i).value == 1) {
                    i++;
                }
                a.add(i - 1);
                zoznam.add(a);
            }

        }
        return zoznam;
    }

    /**
     * 
     * @param num cislo riadka
     * @param cislo index indicie
     * @return v hraniciach indicie najde vsetky potencionalne sekvencie. Tie maju medzi sebou volne policko. 
     * Vracia ako dvojice [i,j], kde i je zaciatok a j koncove policko
     */
    private ArrayList<ArrayList<Integer>> segmenty(int num, int cislo) {//pozor, ak je len jedno cierne policko na 1. pozicii, dostaneme hodnotu [0,0] ale dlzka je 1
        ArrayList<ArrayList<Integer>> zoznam = new ArrayList<>();
        ArrayList<Integer> a;

        for (int i = start.pole_hodnot[num][cislo][0]; i <= start.pole_hodnot[num][cislo][1]; i++) {
            if (riesenie.get(num).get(i).value != 0) {
                a = new ArrayList<>();
                a.add(i);
                i++;
                while (i <= start.pole_hodnot[num][cislo][1] && riesenie.get(num).get(i).value != 0) {
                    i++;
                }
                a.add(i - 1);
                zoznam.add(a);
            }

        }
        return zoznam;
    }

    /**
     * 
     * @param num cislo riadka
     * @param list zoznam obsahujuci indexy indicii
     * @return hodnotu navacsej indicie
     */
    private int maximum(int num, ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (Integer i : list) {
            if (zadanie.get(num).get(i) > max) {
                max = zadanie.get(num).get(i);
            }
        }
        //System.out.println(max);
        return max;
    }

    /**
     * 
     * @param num cislo riadka
     * @param list zoznam obsahujuci indexy indicii
     * @return hodnotu najmensej indiicie
     */
    private int minimum(int num, ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int min = 100;
        for (Integer i : list) {
            if (zadanie.get(num).get(i) < min) {
                min = zadanie.get(num).get(i);
            }
        }
        return min;
    }

}
