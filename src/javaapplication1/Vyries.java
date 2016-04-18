/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javaapplication1.Rules.*;

/**
 *
 * @author krista
 */
public class Vyries {
     
    int cislo;
    ArrayList<Pravidla> pravidla;
    
      
    public Vyries(int cislo, int[] pole) throws IOException, Porucha {
        this.cislo = cislo;
        Read_nono krizovka = new Read_nono(cislo);
        Inicializacia inic = krizovka.zrob_stlpce(); if (inic == null) {return;}        
        Inicializacia inic2 = krizovka.zrob_riadky(inic.riesenie);    
    
        ArrayList<Pravidla> pravidla = Vytvor_sadu(pole, inic2, inic);
        System.out.println(cislo);

        int[] statistika = new int[15];
        statistika[0]=-1;
        int sum;
        int result;

        boolean[] us_r = new boolean[inic.p_stlpcov];
        boolean[] us_s = new boolean[inic2.p_stlpcov];

        Memento mem = new Memento(inic, inic2);
        do {
            sum = 0;
            statistika[0]++;

            System.out.println("    riadky");
            for (int i = 0; i < inic.p_stlpcov; i++) {
             if (us_r[i]) {continue;}//pokracujeme, len ak uz nemame vyrieseny riadok
                for (Pravidla pr : pravidla) {
                    result = pr.run(i, inic2);
                    if (result != 0) {
                        statistika[result]++;
                        sum++;
                    }
                }
                if (check_r(inic2.riesenie.get(i))) {
                    us_r[i] = true;
                }
            }
            System.out.println(Arrays.toString(statistika));

            
            System.out.println("   stlpce");
            for (int i = 0; i < inic2.p_stlpcov; i++) {
              if (us_s[i]) {continue;}//pokracujeme, len ak uz nemame vyrieseny stlpec               
                for (Pravidla pr : pravidla) {
                    result = pr.run(i, inic);
                    if (result != 0) {
                        statistika[result]++;
                        sum++;
                    }
                }
                if (check_r(inic.riesenie.get(i))) {
                    us_s[i] = true;
                }
            }
            System.out.println(Arrays.toString(statistika));
            //mem.uloz_stav(cislo, statistika, pocet_cyklov);
        } while (sum != 0);

        // mem.uloz_stav(cislo, statistika, pocet_cyklov);
        boolean dokoncena = check(inic2.riesenie);
    }
    
    public ArrayList<Pravidla> Vytvor_sadu(int[] pravidla, Inicializacia inic_R, Inicializacia inic_S){
        ArrayList<Pravidla> a = new ArrayList<>();
        ArrayList<Pravidla> zoznam = new ArrayList<>();
            Rules r = new Rules();
            zoznam.add(r.new Prienik(inic_R, inic_S));
            zoznam.add(r.new Jed_medzery(inic_R, inic_S));
            zoznam.add(r.new Jednotky(inic_R, inic_S));
            zoznam.add(r.new Vynutenie(inic_R, inic_S));
            zoznam.add(r.new Lepidlo(inic_R, inic_S));
            zoznam.add(r.new Update0(inic_R, inic_S));
            zoznam.add(r.new Update1(inic_R, inic_S));
            zoznam.add(r.new Update2(inic_R, inic_S));
            zoznam.add(r.new Medzivypln(inic_R, inic_S));
            zoznam.add(r.new Okliestenie(inic_R, inic_S));
            zoznam.add(r.new Prve_cierne(inic_R, inic_S));
            zoznam.add(r.new Prekazka(inic_R, inic_S));            
            zoznam.add(r.new Rozdelenie(inic_R, inic_S));
            zoznam.add(new MostPossible(inic_R, inic_S));
            
        for (int i= 0; i < pravidla.length; i++){  
            a.add(zoznam.get(pravidla[i]-1));
        }
        return a;
    }
    
       
    public static void tieto_ries(Path file, int[] pravidla) throws IOException, Porucha{
       Charset charset = Charset.forName("ISO-8859-1");
        List<String> databaza = Files.readAllLines(file, charset);
        for (String num: databaza){
         //  if (Integer.parseInt(num)>154711){
            Vyries v= new Vyries(Integer.parseInt(num), pravidla);}
       //}
    }
    
    public static void roznymi_sposobmi(int num, ArrayList<int[]> zoznam) throws IOException, Porucha{
        for(int [] takto: zoznam){
            Vyries v = new Vyries(num, takto);
        }
    }
  
    
    public boolean check(ArrayList<ArrayList<MyInt>> riesenie){
        for (ArrayList<MyInt> i: riesenie){
            for(MyInt j: i){
                if (j.value==3)return false;
            }
        }return true;
    }
    
    public boolean check_r(ArrayList<MyInt> riesenie){
        for (MyInt i: riesenie){
            if (i.value==3)return false;
        }return true;
    }
}
