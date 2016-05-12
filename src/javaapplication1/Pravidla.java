/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author krista
 */
public abstract class Pravidla {
    private final Inicializacia start_R; //obsahuje hranice jednotlivych cisel zadani
    private final Inicializacia start_S; //obsahuje hranice jednotlivych cisel zadani
   // protected Memento mem;
    
    public Pravidla(Inicializacia start_R, Inicializacia start_S) {
    this.start_R = start_R;
    this.start_S = start_S;
    //this.mem = new Memento(start_R, start_S, new int[2]);
    }

    public void set_r(ArrayList<MyInt> list, int i, Inicializacia inic) {
        inic.riesenie.set(i, list);
    }
    
    public abstract int getID();
    public abstract int run(int num, Inicializacia start) throws Chyba;
    
     
    /**
     * 
     * @param num cislo riadka
     * @param from index stvorceka
     * @return dlzka sekvencie, ktora obsahuje stvorcek from, vracia 0, ak stvorcek from nie je cierny
     */    
    protected int dlzka_sek(int num, int from, Inicializacia start) {//pocet za sebou iducich ciernych policok obsahujuci policko from
        int dlzka = 0;
        if (start.riesenie.get(num).get(from).value == 0) { //ak FROM nie je cierne, nema zmysel volat tuto funckiu
            return 0;
        }
        int pom = from - 1;
        while (pom > 0 && start.riesenie.get(num).get(pom).value == 1) {//ak su nejake cierne este pred tymto polickom
            dlzka++;
            pom--;
        }
        while (from < start.p_stlpcov && start.riesenie.get(num).get(from).value == 1) {
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
    protected int[] hranice_sek(int num, int cell, Inicializacia start) {//pocet za sebou iducich ciernych policok obsahujuci policko cell
         if (start.riesenie.get(num).get(cell).value == 0) { //ak FROM nie je cierne, nema zmysel volat tuto funckiu
            return null;
        }
        int pom = cell - 1;
        while (pom > 0 && start.riesenie.get(num).get(pom).value == 1) {//ak su nejake cierne este pred tymto polickom
          pom--;
        }
        while (cell < start.p_stlpcov && start.riesenie.get(num).get(cell).value == 1) {
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
    protected int naj_cislo(int num, Inicializacia start) {//vracia najvacsie cislo v riadku
        int naj = 0;
        for (int i = 0; i < start.zadanie.get(num).size(); i++) {
            if (start.zadanie.get(num).get(i) > naj) {
                naj = start.zadanie.get(num).get(i);
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
    protected ArrayList<Integer> najdi_cisla(int num, int cell, Inicializacia start) { 
        int pocet = start.zadanie.get(num).size();
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
    protected ArrayList<Integer> najdi_cisla(int num, int from, int to, Inicializacia start) { 
        int pocet = start.zadanie.get(num).size();
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
     * @param from zaciatocne policko intevalu
     * @param to posledne policko z intevalu
     * @return zoznam indicii, ktore sa akokolvek dotykaju intervalu from-to, vracia poradove cisla z riadka
     */
    protected ArrayList<Integer> najdi_cisla_vsetky(int num, int from, int to, Inicializacia start) { 
        int pocet = start.zadanie.get(num).size();
        ArrayList<Integer> zoznam = new ArrayList<>();
        for (int i = 0; i < pocet; i++) {
            if (!(start.pole_hodnot[num][i][1] < from || start.pole_hodnot[num][i][0] > to)) {
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
    protected ArrayList<Integer> najdi_cierne(int num, int cislo, Inicializacia start) {
        ArrayList<Integer> zoznam = new ArrayList<>();
        for (int i = start.pole_hodnot[num][cislo][0]; i <= start.pole_hodnot[num][cislo][1]; i++) {
            if (start.riesenie.get(num).get(i).value == 1) {
                zoznam.add(i);
                i++; //medzi 2 black run musi byt aspon jedno policko aj tak prazdne
                while (i < start.pole_hodnot[num][cislo][1] && start.riesenie.get(num).get(i).value == 1) {
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
    protected ArrayList<Integer> najdi_cierne(int num, int zac, int kon, Inicializacia start) {
        ArrayList<Integer> zoznam = new ArrayList<>();
        for (int i = zac; i <= kon; i++) {
            if (start.riesenie.get(num).get(i).value == 1) {
                zoznam.add(i);
                i++; //medzi 2 black run musi byt aspon jedno policko aj tak prazdne
                while (i < kon && start.riesenie.get(num).get(i).value == 1) {
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
    protected ArrayList<Integer> najdi_biele(int num, int zac, int kon, Inicializacia start) {
        ArrayList<Integer> zoznam = new ArrayList<>();
        for (int i = zac; i <= kon; i++) {
            if (start.riesenie.get(num).get(i).value == 0) {
                zoznam.add(i);
                i++; //medzi 2 black run musi byt aspon jedno policko aj tak prazdne
                while (i < kon && start.riesenie.get(num).get(i).value == 0) {
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
    protected ArrayList<ArrayList<Integer>> seg_cierne(int num, int cislo, Inicializacia start) {//pozor, ak je len jedno cierne policko na 1. pozicii, dostaneme hodnotu [0,0] ale dlzka je 1
        ArrayList<ArrayList<Integer>> zoznam = new ArrayList<>();
        ArrayList<Integer> a;

        for (int i = start.pole_hodnot[num][cislo][0]; i <= start.pole_hodnot[num][cislo][1]; i++) {
            if (start.riesenie.get(num).get(i).value == 1) {
                a = new ArrayList<>();
                a.add(i);
                i++;
                while (i <= start.pole_hodnot[num][cislo][1] && start.riesenie.get(num).get(i).value == 1) {
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
    protected ArrayList<ArrayList<Integer>> segmenty(int num, int cislo, Inicializacia start) {//pozor, ak je len jedno cierne policko na 1. pozicii, dostaneme hodnotu [0,0] ale dlzka je 1
        ArrayList<ArrayList<Integer>> zoznam = new ArrayList<>();
        ArrayList<Integer> a;

        for (int i = start.pole_hodnot[num][cislo][0]; i <= start.pole_hodnot[num][cislo][1]; i++) {
            if (start.riesenie.get(num).get(i).value != 0) {
                a = new ArrayList<>();
                a.add(i);
                i++;
                while (i <= start.pole_hodnot[num][cislo][1] && start.riesenie.get(num).get(i).value != 0) {
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
    protected int maximum(int num, ArrayList<Integer> list, Inicializacia start) {
        if (list.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (Integer i : list) {
            if (start.zadanie.get(num).get(i) > max) {
                max = start.zadanie.get(num).get(i);
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
    protected int minimum(int num, ArrayList<Integer> list, Inicializacia start) {
        if (list.isEmpty()) {
            return 0;
        }
        int min = 100;
        for (Integer i : list) {
            if (start.zadanie.get(num).get(i) < min) {
                min = start.zadanie.get(num).get(i);
            }
        }
        return min;
    }
    
  
}