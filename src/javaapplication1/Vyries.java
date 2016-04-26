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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javaapplication1.Rules.*;

/**
 *
 * @author krista
 */
public class Vyries {
     
    int cislo;
    ArrayList<Pravidla> pravidla;
    Inicializacia inic,inic2;
    int[] statistika;
    
    public Vyries(int cislo, int[] pole) throws IOException, Porucha {
        this.cislo = cislo;
        Read_nono krizovka = new Read_nono(cislo);
        this.inic = krizovka.zrob_stlpce(); if (inic == null) {return;}        
        this.inic2 = krizovka.zrob_riadky(inic);    
    
        this.pravidla = Vytvor_sadu(pole, inic2, inic);
  //      System.out.println(cislo);

        this.statistika = new int[15];
       
        Ries();
     }
    
//    public Vyries(int cislo, ArrayList<Pravidla> pravidla) throws IOException, Porucha {
//        this.cislo = cislo;
//        Read_nono krizovka = new Read_nono(cislo);
//        this.inic = krizovka.zrob_stlpce(); if (inic == null) {return;}        
//        this.inic2 = krizovka.zrob_riadky(inic);    
//    
//        this.pravidla = pravidla;
//  //      System.out.println(cislo);
//
//        this.statistika = new int[15];
//        statistika[0]=-1;
//     }
      
    public boolean Ries() throws IOException, Porucha {    
        statistika[0]=-1;
        int sum;
        int result;

        boolean[] us_r = new boolean[inic.p_stlpcov];
        boolean[] us_s = new boolean[inic2.p_stlpcov];

        Memento mem = new Memento(inic, inic2, statistika);
        do {
            sum = 0;
            statistika[0]++;

      //      System.out.println("    riadky");
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
         //   System.out.println(Arrays.toString(statistika));

            
   //         System.out.println("   stlpce");
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
//           MyInt.toString(inic2.riesenie);
//           System.out.println(Arrays.toString(statistika));
            //mem.uloz_stav(cislo, statistika, pocet_cyklov);
        } while (sum != 0);
        
       
        // mem.uloz_stav(cislo, statistika, pocet_cyklov);
        boolean dokoncena = check(inic2.riesenie);
     //  mem.uloz_vysledky(dokoncena);
      // MyInt.toString(inic2.riesenie);
    //  System.out.println(cislo);
//if (pravidla.size()==1) mem.uloz_vysledky();
//else
    // mem.uloz_vysledky(dokoncena);
//mem.uloz_stav(this.inic.ID, statistika, statistika[0]);
    //  if (pravidla.size()> 1 && !check_with(inic2.riesenie)) System.out.println("si to DOSRALA!!! "+ cislo);
        if (!dokoncena){
         // mem.uloz_stav(this.inic.ID, statistika, statistika[0]);
            //System.out.println(cislo);
            return false;
        }
        return true;
        
    }
    
    public static ArrayList<Pravidla> Vytvor_sadu(int[] pravidla, Inicializacia inic_R, Inicializacia inic_S){
        ArrayList<Pravidla> a = new ArrayList<>();
        ArrayList<Pravidla> zoznam = new ArrayList<>();
            Rules r = new Rules();
            zoznam.add(r.new Prienik(inic_R, inic_S));          //rule 1
            zoznam.add(r.new Jed_medzery(inic_R, inic_S));      //rule 2
            zoznam.add(r.new Jednotky(inic_R, inic_S));         //rule 3
            zoznam.add(r.new Vynutenie(inic_R, inic_S));        //rule 4
            zoznam.add(r.new Lepidlo(inic_R, inic_S));          //rule 5
            zoznam.add(r.new Update0(inic_R, inic_S));          //rule 6
            zoznam.add(r.new Update1(inic_R, inic_S));          //rule 7
            zoznam.add(r.new Update2(inic_R, inic_S));          //rule 8
            zoznam.add(r.new Medzivypln(inic_R, inic_S));       //rule 9
            zoznam.add(r.new Okliestenie(inic_R, inic_S));      //rule 10 
            zoznam.add(r.new Prve_cierne(inic_R, inic_S));      //rule 11
            zoznam.add(r.new Prekazka(inic_R, inic_S));         //rule 12    
            zoznam.add(r.new Rozdelenie(inic_R, inic_S));       //rule 13
            zoznam.add(new MostPossible(inic_R, inic_S));       //rule 14
            
//        for (int i= 0; i < pravidla.length; i++){  
//            a.add(zoznam.get(pravidla[i]-1));
//        }
            
            for (int i = 0; i<pravidla.length; i++){
                if (pravidla[i]!=0)a.add(zoznam.get(i));
            }
        return a;
    }
    
    public Set povedzSadu(){
        Set a = new HashSet();
        for(int i= 0; i< this.pravidla.size(); i++){
            a.add(this.pravidla.get(i).getID());
        }
        return a;
    }
       
    public static void tieto_ries(Path file, int[] pravidla) throws IOException, Porucha{
       Charset charset = Charset.forName("ISO-8859-1");
        List<String> databaza = Files.readAllLines(file, charset);
        for (String num: databaza){
         // if (Integer.parseInt(num)>149346){
            Vyries v= new Vyries(Integer.parseInt(num), pravidla);}
      // }
    }
    
    public static void tieto_ries(Path file) throws IOException, Porucha{
       Charset charset = Charset.forName("ISO-8859-1");
        List<String> databaza = Files.readAllLines(file, charset);
        for (String num: databaza){
         //  if (Integer.parseInt(num)>154711){
            Subset s = new Subset(Integer.parseInt(num));}
       //}
    }
    
     public static void ries_dvojako(Path file) throws IOException, Porucha{
         int[] LG = {1,2,3,4,5, 6,7,8,9,10, 11,12,13};
         int[] MP = {0,0,0,0,0, 0,0,0,0,0, 0,0,0,14};
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> databaza = Files.readAllLines(file, charset);
        for (String num : databaza) {
           // if (Integer.parseInt(num)==163481){
            Vyries v1 = new Vyries(Integer.parseInt(num), MP);           
            MyInt.reset(v1.inic2.riesenie);                  
            v1.pravidla = Vytvor_sadu(LG, v1.inic2, v1.inic);
            v1.statistika = new int[15];
            v1.Ries();
            //Vyries v2 = new Vyries(Integer.parseInt(num), LG);
        }
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
    
    public boolean check_with(ArrayList<ArrayList<MyInt>> riesenie) throws IOException, Porucha{
        int[] p = {0,0,0,0,0, 0,0,0,0,0, 0,0,0,1};
        Vyries v = new Vyries(cislo, p);
         //MostPossible m = new MostPossible(v.inic2, v.inic);
         ArrayList<ArrayList<MyInt>> mostPossible = v.inic2.riesenie;
         for (int i= 0 ; i< riesenie.size(); i++){
             for (int j = 0; j<riesenie.get(i).size(); j++){
             if( riesenie.get(i).get(j).value == 1 && mostPossible.get(i).get(j).value == 0 )return false;
             if( riesenie.get(i).get(j).value == 0 && mostPossible.get(i).get(j).value == 1 )return false;
         }
         } return true;  
    }
}
