/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author krista
 */
public class Subset {

    int cislo_krizovky;
    static int N = 13;
    ArrayList<Set<Integer>> mnozina;
  //  FileWriter fw;

    public Subset(int cislo_krizovky) throws IOException, Porucha {
        this.cislo_krizovky = cislo_krizovky;
        this.mnozina = new ArrayList<>();
   //     otvorDoc();
       // if(cislo_krizovky >154154){
        vytvor();
    //} else return;
    }

    public void vytvor() throws IOException, Porucha {
        ArrayList<int[]> zoznam;
        int [] pom ={0};
        Vyries v = new Vyries(cislo_krizovky,pom );
        for (int i = 1; i <= N; i++) {
            zoznam = combinations(i);
            for (int[] t : zoznam) {                              
                 v.pravidla = Vyries.Vytvor_sadu(t, v.inic2, v.inic);
                 v.statistika = new int[15];
                 Inicializacia.reset(v.inic, v.inic2);                
                 v.Ries();
              if (v.Ries()) {
                    Set s = v.povedzSadu();
                    //System.out.println("nasla som " + s.toString());
                    pridajSadu(s);
                    
                }
                // System.out.println(Arrays.toString(t));
            }
            
        }
        ulozUdaje();
    }

    public ArrayList<int[]> combinations(int k) {
        ArrayList<int[]> a = new ArrayList<>();
        int[] pom = new int[N];
        Arrays.fill(pom, N - k, N, 1);
        do {
            a.add(pom);
            pom = pom.clone();
        } while (hasNext(pom));
        return a;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean hasNext(int[] a) {
        int N = a.length;

        int k;
        for (k = N - 1; k > 0; k--) {//najdeme miesto, kde treba zmenit cislo za vacsie
            if (a[k] > a[k - 1]) {
                break;
            }
            if (k == 1) {
                return false;//ak sme uz nasli najvasciu permutaciu
            }
        }
        swap(a, k, k - 1);

        for (int i = k; i < N - 1; i++) {//kedze mame len 0,1 staci ak zvysnu cas pola usporiadame tak, 
            //aby vsetky 1 boli na konci
            if (a[i] > a[i + 1]) {
                swap(a, i, i + 1);
            }
        }
        return true;

    }
/**
 * 
 * @param nova sada pravidiel, pomocou ktorej sa da vyriesit krizovka
 * prida sa, len ak nie je nadmnozinou uz vyhovujucej sady
 */
    public void pridajSadu(Set nova) {
        for(Set m: this.mnozina){
            if(nova.containsAll(m)){
               return;
            }            
        } this.mnozina.add(nova);
    }
    
//    public void otvorDoc() throws IOException{
//        this.fw = new FileWriter("Sets.txt", true);
//         String oddelovac = "    ";
//        fw.write(this.cislo_krizovky);
//        fw.write(oddelovac);
//    }
    
    public void ulozUdaje() throws IOException{
        
       Integer i = this.cislo_krizovky;
        System.out.println(i);
        FileWriter fw = new FileWriter("Setiky.txt", true);
//        BufferedWriter bw = new BufferedWriter(out);
//        PrintWriter fw = new PrintWriter(bw);
        String oddelovac = " ";
        fw.write(Integer.toString(i));
        fw.write(oddelovac);
        for(Set s: mnozina){
            fw.write(s.toString());
            fw.write(oddelovac);
        }
        fw.write("\n");
        fw.close();
    }
}
