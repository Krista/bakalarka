/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krista
 */
public class RulesS {
    
    class Prienik extends Pravidla{

        public Prienik(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }
        
         @Override
        public int getID() {return 1;}

        @Override
        public int run(int num, Inicializacia start) throws Chyba{
             int poc_cisel = start.pole_hodnot[num].length;
        int rozdiel = 0;
        int act_cislo;
        int farbi;
        int zaciatok;
        boolean check = false;
        for (int i = 0; i < poc_cisel; i++) {
            zaciatok = start.pole_hodnot[num][i][0];
            rozdiel = start.pole_hodnot[num][i][1] + 1 - zaciatok;
            act_cislo = start.zadanie.get(num).get(i);
            if (rozdiel < act_cislo) throw new Chyba("PRIENIK", num, i, start.ID_nono);
            if (act_cislo * 2 > rozdiel) {
                farbi = rozdiel - act_cislo;
                for (int x = 0; x < (act_cislo * 2 - rozdiel); x++, farbi++) {
                    if (start.riesenie.get(num).get(zaciatok + farbi).value != 1) {
                            if (start.riesenie.get(num).get(zaciatok + farbi).value == 0) throw new Chyba("prienik", num, i, start.ID_nono);
                            System.out.println("riadok: " + num + " rule 1.1 , policko: " + (zaciatok + farbi));
                            start.riesenie.get(num).get(zaciatok + farbi).value = 1;
                            check = true;
                    }
                }
          }if (act_cislo == 0) { for(int w=0; w< start.p_stlpcov; w++) start.riesenie.get(num).get(w).value = 0; check = true;}
        }return check ? 1 : 0 ;
    }

       
        
    }
    
    class Jed_medzery extends Pravidla{

        public Jed_medzery(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  2;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
            boolean check = false;
        int poc_indicii = start.zadanie.get(num).size() - 1;
        for (int i = 0; i < start.pole_hodnot[num][0][0]; i++) { //rule 1.2 (1)
            if (start.riesenie.get(num).get(i).value != 0) {
                if (start.riesenie.get(num).get(i).value == 1) throw new Chyba("jed_medzery0", num, i, start.ID_nono);
                System.out.println("riadok: " + num + " rule 1.2.1 , policko: " + i);
                start.riesenie.get(num).get(i).value = 0;
                check = true;
            }
        }
        for (int i = start.pole_hodnot[num][poc_indicii][1] + 1; i < start.p_stlpcov; i++) { //rule 1.2 (2)
            if (start.riesenie.get(num).get(i).value != 0) {
                if (start.riesenie.get(num).get(i).value == 1) throw new Chyba("jed_medzery1", num, i, start.ID_nono);
                System.out.println("riadok: " + num + " rule 1.2.2 , policko: " + i);
                start.riesenie.get(num).get(i).value = 0;
                check = true;
            }
        }
        for (int i = 0; i < poc_indicii; i++) { // rule 1.2 (3)
            // if (start.pole_hodnot[num][i + 1][0] < start.pole_hodnot[num][i][1]) {
            for (int x = start.pole_hodnot[num][i][1] + 1; x < start.pole_hodnot[num][i + 1][0]; x++) {
                if (start.riesenie.get(num).get(x).value != 0) {
                    if (start.riesenie.get(num).get(x).value == 1) throw new Chyba("jed_medzery2", num, i, start.ID_nono);
                    System.out.println("riadok: " + num + " rule 1.2.3 , policko: " + x);
                    start.riesenie.get(num).get(x).value = 0;
                    check = true;
                }
            }
            // }
        }return check ? 2 : 0 ;}

    }
    
    class Jednotky extends Pravidla {

        public Jednotky(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  3;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
           int pocet_indicii = start.zadanie.get(num).size();
        int s_pozicia;
        boolean check = false;
        for (int i = 1; i < pocet_indicii; i++) {
            s_pozicia = start.pole_hodnot[num][i][0];
            if (start.riesenie.get(num).get(s_pozicia).value == 1 && start.riesenie.get(num).get(s_pozicia - 1).value == 3) {
                ArrayList<Integer> pom = najdi_cisla(num, s_pozicia, start);
                pom.remove(Integer.valueOf(i));
                if (maximum(num, pom, start) == 1) {
                    if (start.riesenie.get(num).get(s_pozicia - 1).value == 1) throw new Chyba("jednotky", num, i, start.ID_nono);
                    System.out.println("riadok: " + num + " rule 1.3.1 , policko: " + (s_pozicia - 1));
                    start.riesenie.get(num).get(s_pozicia - 1).value = 0;
                    check = true;
                }
                }
            }
            boolean check2 = jednotky_za(num, check, start);
            return (check || check2) ? 3 : 0;
        }
        
         public boolean jednotky_za(int num, boolean check, Inicializacia start) throws Chyba { //rule 1.3 - za 
        int pocet = start.zadanie.get(num).size();
        int e_pozicia;
        for (int i = 0; i < pocet - 1; i++) {
            e_pozicia = start.pole_hodnot[num][i][1];
            if (start.riesenie.get(num).get(e_pozicia).value == 1) {
                ArrayList<Integer> pom = najdi_cisla(num, e_pozicia, start);
                pom.remove(Integer.valueOf(i));
                if (maximum(num, pom, start) == 1 && start.riesenie.get(num).get(e_pozicia + 1).value == 3) {
                    if (start.riesenie.get(num).get(e_pozicia + 1).value == 1) throw new Chyba("jednotky_za", num, i, start.ID_nono);
                    System.out.println("riadok: " + num + " rule 1.3.2 , policko: " + (e_pozicia + 1));
                    start.riesenie.get(num).get(e_pozicia + 1).value = 0;
                    check = true;
                }
            }
        }return check;
    }
        
    }
    
    class Vynutenie extends Pravidla{

        public Vynutenie(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  4;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
             boolean check = false;
        for (int i = 0; i < start.riesenie.get(num).size() - 2; i++) {
            if (start.riesenie.get(num).get(i).value == 1 && start.riesenie.get(num).get(i + 1).value == 3 && start.riesenie.get(num).get(i + 2).value == 1) {
                //riesenie.get(num).get(i + 1).value = 1; //skusame zafarbit
                int d1 = dlzka_sek(num, i, start);
                int d2 = dlzka_sek(num, i+2, start);
                ArrayList<Integer> pom = najdi_cisla(num, i-d1+1, i+d2+1, start);
                //ArrayList<Integer> pom2 = najdi_cisla(num, i+d2+1);
               // pom.retainAll(pom2);//v pom necha len tie indicie, ktore su v oboch arraylistoch
        //System.out.println(pom.toString());
                if (pom.isEmpty() || d1+d2+1 > maximum(num, pom, start)) {
                    System.out.println("riadok: " + num + " rule 1.4 , policko: " + (i + 1));
                    start.riesenie.get(num).get(i + 1).value = 0;
                    check = true;
                }
            }
        }return check ? 4: 0 ;}
        
    }
    
      class Lepidlo extends Pravidla{

        public Lepidlo(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  5;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
            int min, max;
        ArrayList<Integer> sek;
        int biele, biele2;
        boolean check;
       check = (lep_zac(num,start) || lep_kon(num,start));       
       
        for (int i = 1; i < start.p_stlpcov; i++) {//bod 0
            if (start.riesenie.get(num).get(i - 1).value != 1 && start.riesenie.get(num).get(i).value == 1) {
                sek = najdi_cisla(num, i, start);
                min = minimum(num, sek, start);//bod 1
                biele = -1;
                biele2 = start.p_stlpcov;
                for (int j = Math.max(i - 1, 0); j >= Math.max(i - min + 1, 0); j--) {//hladame biely stvorcek niekde vpredu - bod 2
                    if (start.riesenie.get(num).get(j).value == 0) {
                        biele = j;
                        break;
                    }
                }
                if (biele != -1 || (i - min + 1) < 0) {//ak sa naslo, alebo je to na zaciatku
                    for (int x = i + 1; x <= biele + min; x++) { //nemusime sa bat pretecenia, keby sa stalo, je problem v krizovke
                        if (start.riesenie.get(num).get(x).value != 1) {
                            System.out.println("riadok: " + num + "rule 1.5.2 , policko: " + x);
                            start.riesenie.get(num).get(x).value = 1;
                            check = true;}   } }
                
                
                for (int j = i + 1; j < Math.min(i + min, start.p_stlpcov); j++) {//bod 3 hladame biely vzadu
                    if (start.riesenie.get(num).get(j).value == 0) {
                        biele2 = j;
                        break;
                    }
                }

                if (biele2 != start.p_stlpcov || (i + min) > start.p_stlpcov) {
                    for (int x = i - 1; x >= biele2 - min; x--) {
                        if (start.riesenie.get(num).get(x).value != 1) {
                            System.out.println("riadok: " + num + "rule 1.5.3 , policko: " + x);
                            start.riesenie.get(num).get(x).value = 1;
                            check = true;
                        }
                    }
                }
                
                max = maximum(num, sek,start);//bod 4
                int[] w=hranice_sek(num,i,start);
                if (min == max && min == w[1]-w[0]+1) {
                    if (w[0]-1>=0 && start.riesenie.get(num).get(w[0]-1).value != 0) {
                        System.out.println("riadok: " + num + "rule 1.5.4 , policko: " + (w[0]- 1));
                        start.riesenie.get(num).get(w[0] - 1).value = 0;
                        check = true;
                    }
                    if (w[1]+1 < start.p_stlpcov && start.riesenie.get(num).get(w[1]+1).value != 0) {
                        System.out.println("riadok: " + num + "rule 1.5.5 , policko: " + (w[1]+1));
                        start.riesenie.get(num).get(w[1]+1).value = 0;
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
        return check ? 5 : 0 ;
    }
    /**
     * 
     * @param num cislo riadka
     * specialny pripad pravidla 1.5 - LEPIDLO, ked je prvé políčko v riadku čierne
     */
    public boolean lep_zac(int num, Inicializacia start){
        boolean check = false;
         if (start.riesenie.get(num).get(0).value == 1) {
            int cislo = start.zadanie.get(num).get(0);
            for (int x = 1; x < cislo; x++) { //nemusime sa bat pretecenia, keby sa stalo, je problem v krizovke
                if (start.riesenie.get(num).get(x).value != 1) {
                    System.out.println("riadok: " + num + "rule 1.5.2f , policko: " + x);
                    start.riesenie.get(num).get(x).value = 1;
                    check = true;
                }
            }
            if (cislo < start.p_stlpcov && start.riesenie.get(num).get(cislo).value != 0) {
                System.out.println("riadok: " + num + "rule 1.5.0f , policko: " + cislo);
                start.riesenie.get(num).get(cislo).value = 0;
                start.pole_hodnot[num][0][1] = cislo-1; //upravime koncovu hranicu
                check = true;
            }
        }return check;}
    
    /**
     * 
     * @param num cislo riadka
     * specialny pripad pravidla 1.5 - LEPIDLO, ked je posledné políčko v riadku čierne
     */
    public boolean lep_kon(int num, Inicializacia start){
        boolean check = false;
         if (start.riesenie.get(num).get(start.p_stlpcov - 1).value == 1) { 
            int posledne = start.zadanie.get(num).size() - 1;
            int cislo = start.zadanie.get(num).get(posledne);
            if (start.p_stlpcov - cislo > 0 && start.riesenie.get(num).get(start.p_stlpcov - cislo - 1).value != 0) {
                System.out.println("riadok: " + num + "rule 1.5.0l , policko: " + (start.p_stlpcov - cislo - 1));
                start.riesenie.get(num).get(start.p_stlpcov - cislo - 1).value = 0;
                start.pole_hodnot[num][posledne][0] = start.p_stlpcov - cislo - 1;
                check = true;
            }
            for (int x = start.p_stlpcov - cislo; x < start.p_stlpcov; x++) {
                if (start.riesenie.get(num).get(x).value != 1) {
                    System.out.println("riadok: " + num + "rule 1.5.2l , policko: " + x);
                    start.riesenie.get(num).get(x).value = 1;
                    check = true;
                }
            }
        }return check;
        
    }
}
    
    class Update0 extends Pravidla{

        public Update0(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }
        
        @Override
        public int getID() {return  6;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
              boolean check = false;
        for (int i = 0; i < start.zadanie.get(num).size() - 1; i++) {
            if (start.pole_hodnot[num][i][0] + start.zadanie.get(num).get(i) >= start.pole_hodnot[num][i + 1][0]) {
                System.out.println("update0a riadok" + num + "indicia " + (i+1) + " na policko " + (start.pole_hodnot[num][i][0] + start.zadanie.get(num).get(i) + 1));
                start.pole_hodnot[num][i + 1][0] = start.pole_hodnot[num][i][0] + start.zadanie.get(num).get(i) + 1;
                check = true;
            }
            if (start.pole_hodnot[num][i][1] >= start.pole_hodnot[num][i + 1][1] - start.zadanie.get(num).get(i + 1)) {
                System.out.println("update0b riadok" + num + "indicia " + i +" na policko " + (start.pole_hodnot[num][i + 1][1] - start.zadanie.get(num).get(i + 1) - 1));
                start.pole_hodnot[num][i][1] = start.pole_hodnot[num][i + 1][1] - start.zadanie.get(num).get(i + 1) - 1;
                check = true;
            }
        }return check ? 6 : 0 ; }
    }
    
    class Update1 extends Pravidla{

        public Update1(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return 7;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
            int poz_e, poz_s;
        boolean check = false;

        for (int i = 0; i < start.zadanie.get(num).size() - 1; i++) {
            poz_e = start.pole_hodnot[num][i][1];
            poz_s = start.pole_hodnot[num][i + 1][0];
            if (start.riesenie.get(num).get(poz_e + 1).value == 1) {
                int x = poz_e;
                while (start.riesenie.get(num).get(x).value == 1) {
                    x--;
                }
                System.out.println("update1a riadok" + num + "indicia: " + i);
                start.pole_hodnot[num][i][1] = x - 1;
                check = true;
            }
            if (start.riesenie.get(num).get(poz_s - 1).value == 1) {
                int x = poz_s;
                while (start.riesenie.get(num).get(x).value == 1) {
                    x++;
                }
                System.out.println("update1b riadok" + num + "indicia: " + (i + 1));
                start.pole_hodnot[num][i + 1][0] = x + 1;
                check = true;
            }
        }return check ? 7 : 0 ;}
    }
    
    class Update2 extends Pravidla{

        public Update2(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  8;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
            int indicia, dlzka_seg;
        int x = 0;
        boolean check = false;
        ArrayList<ArrayList<Integer>> sek;
        for (int i = 0; i < start.zadanie.get(num).size(); i++) {
            indicia = start.zadanie.get(num).get(i);
            sek = seg_cierne(num, i, start);            
            for (int j = 0; j < sek.size(); j++) {
                dlzka_seg = sek.get(j).get(1) - sek.get(j).get(0) + 1;
                if (dlzka_seg > indicia) { // toto sa robi v RULE 3.2 - blbost, tam sa updatuju prilis kratke segmenty
                    ArrayList<Integer> cisla = najdi_cisla(num, sek.get(j).get(0), start);
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
        }return check ? 8 : 0 ; }
    }
    
    class Medzivypln extends Pravidla{

        public Medzivypln(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  9;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
            int zac, kon;           //pred tymto pravidloom NUTNE aplikovat UPDATE 1---urcite??
        ArrayList<Integer> list;
        boolean check = false;
        for (int i = 1; i < start.zadanie.get(num).size() - 1; i++) {
            zac = Math.max(start.pole_hodnot[num][i - 1][1]+1, start.pole_hodnot[num][i][0]);
            kon = Math.min(start.pole_hodnot[num][i + 1][0]-1, start.pole_hodnot[num][i][1]);
            list = najdi_cierne(num, zac, kon, start);//zac a kon zabezpecuju, ze najdene cierne budu patrit len 1 indicii
            if (list.size() > 1) {
                for (int x = list.get(0); x < list.get(list.size()-1); x++) {//spaja vsetky cierne sekvencie dokopy
                    if (start.riesenie.get(num).get(x).value == 3) {
                        System.out.println("riadok: " + num + "rule 3.1 , policko: " + x);
                        start.riesenie.get(num).get(x).value = 1;
                        check = true;
                    }else if (start.riesenie.get(num).get(x).value==0) throw new Chyba("Medzivypln", num, i, start.ID_nono);
                    
                }
                int[] hr = hranice_sek(num, list.get(0), start);
                int u = start.zadanie.get(num).get(i) - (hr[1]-hr[0]+1); //kolko zostava vyfarbit
               // System.out.println("prestavujem inic 3.1 na " + num );
                start.pole_hodnot[num][i][0] = Math.max(hr[0] - u, start.pole_hodnot[num][i][0]);
                start.pole_hodnot[num][i][1] = Math.min(hr[1] + u, start.pole_hodnot[num][i][1]);
                   System.out.println("prestavujem inic 3.1 na " + num + " ["+  start.pole_hodnot[num][i][0]+ start.pole_hodnot[num][i][1] +"]");
                check = true;
            }
        }return check ?  9 : 0;}
        
    }
    
    class Okliestenie extends Pravidla{

        public Okliestenie(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  10;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
             ArrayList<ArrayList<Integer>> list;
        int dlzka;
        boolean check = false;
        for (int i = 0; i < start.zadanie.get(num).size(); i++) {
            list = segmenty(num, i, start);

            for (int x = 0; x < list.size(); x++) {//pozerame zlava
                dlzka = list.get(x).get(1) - list.get(x).get(0) + 1;
                if (start.pole_hodnot[num][i][0] != list.get(x).get(0)) { //nastavujeme na zaciatok potencionalnej sekvencie
                    System.out.println("rule 3.2a " + num);
                    start.pole_hodnot[num][i][0] = list.get(x).get(0);//ak nam to pretecie, tak je chyba v krizovke
                check = true;
                }
                if (dlzka >= start.zadanie.get(num).get(i)) {
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
                if (dlzka >= start.zadanie.get(num).get(i)) {
                    break;
                }
            }
        }return check ? 10 : 0; }
        
    }
    
    class Prve_cierne extends Pravidla{

        public Prve_cierne(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  11;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
             int zac, dlzka, kon;
        boolean check = false;
        int pocet = start.zadanie.get(num).size();
        for (int i = 1; i < pocet-1; i++) {
            zac = start.pole_hodnot[num][i][0];
            kon = start.pole_hodnot[num][i][1];
            dlzka = start.zadanie.get(num).get(i);
            if (start.pole_hodnot[num][i - 1][1] < zac) {//pravidlo robime, len ak sa cisla neprekryvaju 

                if (start.riesenie.get(num).get(zac).value == 1) {//case 1//nepotrebuje i==0
                    for (int x = 1; x < dlzka; x++) {
                        if (start.riesenie.get(num).get(x + zac).value == 3) {
                            System.out.println("riadok: " + num + "rule 3.3.1 , policko: " + (x + zac));
                            start.riesenie.get(num).get(x + zac).value = 1;
                            check = true;
                        }
                    }
                    if (start.riesenie.get(num).get(zac - 1).value != 0) {//len nastavime predchadzajuce policko prazdne
                        System.out.println("riadok: " + num + "rule 3.3.1b , policko: " + (zac - 1));
                        start.riesenie.get(num).get(zac - 1).value = 0;
                        check = true;
                    }
                    if (start.riesenie.get(num).get(dlzka + zac).value != 0) {//kedze je prve vyfarbene za sekvenciou musi nasledovat prazdne policko
                        start.riesenie.get(num).get(dlzka + zac).value = 0;
                        check = true;
                    }
                    //System.out.println("rule 3.3a " + num);
                    start.pole_hodnot[num][i][1] = zac + dlzka - 1;
                }
             }
        }return check ? 11 : 0;}
    }
    
    class Prekazka extends Pravidla{

        public Prekazka(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  12;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
          int zac, dlzka, kon;
        boolean check = false;
        int pocet = start.zadanie.get(num).size();
        for (int i = 0; i < pocet; i++) {
            zac = start.pole_hodnot[num][i][0];
            kon = start.pole_hodnot[num][i][1];
            dlzka = start.zadanie.get(num).get(i);
            if (i == 0 || start.pole_hodnot[num][i - 1][1] < zac) {//pravidlo robime, len ak sa cisla neprekryvaju 
                boolean bola_cierna = false;
                for (int y = zac; y <= kon; y++) {//case 2
                    if (start.riesenie.get(num).get(y).value == 1) {
                        bola_cierna = true;
                    }
                    if (bola_cierna == true && start.riesenie.get(num).get(y).value == 0) {
                        System.out.println("rule 3.3d " + num);
                        start.pole_hodnot[num][i][1] = y - 1;
                        check = true;
                        break;
                    }
                }
            }
         }return check ? 12:0;    
        }
        
    }
    
    class Rozdelenie extends Pravidla{

        public Rozdelenie(Inicializacia start_R, Inicializacia start_S) {
            super(start_R, start_S);
        }

        @Override
        public int getID() {return  13;}
        
        @Override
        public int run(int num, Inicializacia start) throws Chyba {
            int zac, dlzka, kon;
        boolean check = false;
        int pocet = start.zadanie.get(num).size();
        for (int i = 0; i < pocet; i++) {
            zac = start.pole_hodnot[num][i][0];
            kon = start.pole_hodnot[num][i][1];
            dlzka = start.zadanie.get(num).get(i);
            if (i == 0 || start.pole_hodnot[num][i - 1][1] < zac) {//pravidlo robime, len ak sa cisla neprekryvaju 
               ArrayList<ArrayList<Integer>> seg = seg_cierne(num, i, start);
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
         }return check ? 13 : 0;  }
        
    }
    
    
    
}
