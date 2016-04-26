package javaapplication1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author krista
 */
public class Memento {
public static String file_name = "RBoth_ways2.txt";
    public static int id;
    int por_cislo;
    Inicializacia stlpce;
    Inicializacia riadky;
    int[] statistika;
    public static String oddelovac = ", ";

    public Memento(Inicializacia stlpce, Inicializacia riadky, int[] statistika) {
        this.por_cislo = id;
        this.stlpce = stlpce;
        this.riadky = riadky;
        this.statistika = statistika;
    }
   

    public void uloz_stav(int krizovka, int[] statistika, int pocet) throws FileNotFoundException, UnsupportedEncodingException {
        por_cislo++;
        PrintWriter writer = new PrintWriter("MEM" + por_cislo + krizovka, "UTF-8");
        writer.println("Puzzle number: " + krizovka);
        writer.println("width: " + riadky.p_stlpcov);
        writer.println("height: " + stlpce.p_stlpcov);
        writer.println();

        writer.println("Statistiky");
        writer.println(Arrays.toString(statistika));
        writer.println();
        
        writer.println("Pocet cyklov");
        writer.println(pocet);
        writer.println();
        
        writer.println("riesenie");
        for (ArrayList<MyInt> a : riadky.riesenie) {
            for (MyInt m : a) {
                if (m.value==3) writer.print(". ");
                else writer.print(m.value + " ");
            }
            writer.println();
        }
        writer.println();

        writer.println("hranice riadky");
        for (int[][] a : riadky.pole_hodnot) {
            for (int[] m : a) {
                writer.print(Arrays.toString(m));
            }
            writer.println();
        } writer.println();

        writer.println("hranice stlpce");
        for (int[][] a : stlpce.pole_hodnot) {
            for (int[] m : a) {
                writer.print(Arrays.toString(m));
            }
            writer.println();
        } writer.println();
        
        writer.close();
    }
    
    public void uloz_vysledky() throws IOException{
     FileWriter fw = new FileWriter(file_name, true);
//      fw.write(Integer.toString(riadky.ID));
//        fw.write(" : ");
        fw.write(Integer.toString(statistika[0]));
        fw.write(oddelovac);
        fw.write(Integer.toString(statistika[14]));//+"\n");
        fw.write(oddelovac);
        fw.close();
    }
    
    public void uloz_vysledky(boolean b) throws IOException{
     FileWriter fw = new FileWriter(file_name, true);
//      fw.write(Integer.toString(riadky.ID));
//        fw.write(" : ");
        fw.write(Integer.toString(statistika[0]));
        fw.write(oddelovac);
        fw.write(Arrays.toString(statistika));    
        fw.write(oddelovac);
       if(b) fw.write("1\n"); else fw.write("0\n");
        fw.close();
    }
    
    public void import_stav(String name){
        
    }
}
