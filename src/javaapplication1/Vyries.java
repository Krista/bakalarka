/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author krista
 */
public class Vyries {
     
    int cislo;
    boolean[] pravidla;
    
    public Vyries(int cislo) throws IOException, Porucha {
        this.cislo = cislo;
        Ries();
    }
    
    public Vyries(int cislo, boolean[] pravidla) throws IOException, Porucha {
        this.cislo = cislo;
        this.pravidla = pravidla;
        Ries();
    }
    
//    public void Vytvor_sadu(boolean[] pravidla){
//        ArrayList<Boolean> a = new ArrayList<>();
//        for (int i= 0; i < pravidla.length; i++){
//            if (pravidla[i]==true)
//        }
//    }
    
    /**
     * 
     * @throws IOException
     * @throws Porucha 
     * nacita si krizovku z txt suboru, pouziva pravidla pokym to ide, vysledok ulozi do suboru MEM0xxx, 
     * kde xxx je cislo krizovky
     */
    public void Ries() throws IOException, Porucha{
     Read_nono krizovka = new Read_nono(cislo);        
        Inicializacia inic = krizovka.zrob_stlpce();
        //inic.riesenie.get(0).get(2).value = 1;
        if (inic == null) return;
        System.out.println(cislo);
        Inicializacia inic2 = krizovka.zrob_riadky(inic.riesenie);
        Logical_rules p = new Logical_rules(inic);
        Logical_rules r = new Logical_rules(inic2);
        MostPossible m = new MostPossible(inic);
         MostPossible n = new MostPossible(inic2);
        int[] statistika = new int[12];
        int pocet_cyklov = 0;
        int sum=0;
        
        boolean[] us_r = new boolean[inic.p_stlpcov];
        boolean[] us_s = new boolean[inic2.p_stlpcov];
        
             Memento mem = new Memento(inic, inic2);
                do{ sum=0;
                    pocet_cyklov++;
                    
                System.out.println("    riadky");
                for (int i = 0; i <inic.p_stlpcov; i++){
                    if (us_r[i])continue;
                    //r.update0(i);r.update1(i);r.update2(i);
                 //   r.prienik(i);
                    // if(n.CoToDa(i)) {statistika[11]++; sum++;}
                    if(r.prienik(i)) {statistika[0]++; sum++;  }//r.update0(i);r.update1(i);r.update2(i);}
                    if(r.jed_medzery(i)) {statistika[1]++; sum++; }//  r.update0(i);r.update1(i);r.update2(i);}
                    if(r.jednotky(i)) {statistika[2]++; sum++;  }// r.update0(i);r.update1(i);r.update2(i);}
                   if(r.lepidlo(i)) {statistika[3]++; sum++;  }// r.update0(i);r.update1(i);r.update2(i);}
                    if(r.update0(i)) {statistika[4]++; sum++;}
                   if(r.vynutenie(i)) {statistika[5]++; sum++; }// r.update0(i);r.update1(i);r.update2(i);}
                   if(r.update1(i)) {statistika[6]++; sum++;}
                    if(r.update2(i)) {statistika[7]++; sum++;}
                    if(r.medzivypln(i)) {statistika[8]++;sum++;  }//r.update0(i);r.update1(i);r.update2(i);}
                   // if(r.nekryjuce(i)){statistika[9]++;sum++; r.update0(i);r.update1(i);r.update2(i);}
                  if(r.prve_cierne(i)){statistika[9]++;sum++; }// r.update0(i);r.update1(i);r.update2(i);}
                  if(r.prekazka(i)){statistika[7]++;sum++; }// r.update0(i);r.update1(i);r.update2(i);}
                  if(r.rozdelenie(i)){statistika[6]++;sum++; }// r.update0(i);r.update1(i);r.update2(i);}
                    if(r.okliestenie(i)){statistika[10]++;sum++;  }//r.update0(i);r.update1(i);r.update2(i);}
                    
                    if(check_r(inic2.riesenie.get(i))) us_r[i]=true;
                         } System.out.println(Arrays.toString(statistika));
                        // MyInt.toString(inic2.riesenie);
                System.out.println("   stlpce");
                  for (int i = 0; i <inic2.p_stlpcov; i++){
                      if(us_s[i]) continue;
                     // p.prienik(i);
                  //    if(m.CoToDa(i)) {statistika[11]++; sum++;}
                    //  p.update0(i);  p.update1(i); p.update2(i);
                    if(p.prienik(i)) {statistika[0]++; sum++; }// p.update0(i);  p.update1(i); p.update2(i);}
                    if(p.jed_medzery(i)) {statistika[1]++; sum++;  }//p.update0(i);  p.update1(i); p.update2(i);}
                   if(p.jednotky(i)) {statistika[2]++; sum++;  }//p.update0(i);  p.update1(i); p.update2(i);}
                  if(p.lepidlo(i)) {statistika[3]++; sum++;  }//p.update0(i);  p.update1(i); p.update2(i);}

                    if(p.update0(i)) {statistika[4]++; sum++;}
                    if(p.vynutenie(i)) {statistika[5]++; sum++; }// p.update0(i);  p.update1(i); p.update2(i);}
                   if(p.update1(i)) {statistika[6]++; sum++;}
            if(p.update2(i)) {statistika[7]++; sum++;}
                  if(p.medzivypln(i)) {statistika[8]++;sum++; }// p.update0(i);  p.update1(i); p.update2(i);}
                  //if(p.nekryjuce(i)){statistika[9]++;sum++; p.update0(i);  p.update1(i); p.update2(i);}
                if(p.prve_cierne(i)){statistika[9]++;sum++;  }//p.update0(i);  p.update1(i); p.update2(i);}
                if(p.prekazka(i)){statistika[7]++;sum++; }// p.update0(i);  p.update1(i); p.update2(i);}
                 if(p.rozdelenie(i)){statistika[6]++;sum++; }// p.update0(i);  p.update1(i); p.update2(i);}
                   if(p.okliestenie(i)){statistika[10]++;sum++;  }//p.update0(i);  p.update1(i); p.update2(i);}
                  if(check_r(inic.riesenie.get(i))) us_s[i]=true;
                         }
               //  MyInt.toString(inic2.riesenie);
                System.out.println(Arrays.toString(statistika));
//mem.uloz_stav(cislo, statistika, pocet_cyklov);
                }while(sum!=0);

         
             // mem.uloz_stav(cislo, statistika, pocet_cyklov);
                boolean dokoncena = check(inic2.riesenie);
                
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
