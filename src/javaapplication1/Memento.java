package javaapplication1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 *
 * @author krista
 */
public class Memento {
public static String file_name;
    public static int id;
    Inicializacia stlpce;
    Inicializacia riadky;
    int[] statistika;
    public static String oddelovac = ", ";

    public Memento(Inicializacia stlpce, Inicializacia riadky, int[] statistika) {
        this.stlpce = stlpce;
        this.riadky = riadky;
        this.statistika = statistika;
        File theDir = new File("Memento");
        if (!theDir.exists()) theDir.mkdir();
    }
   

    public void uloz_stav() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("Memento/MEM" + stlpce.ID, "UTF-8");
        writer.println("Puzzle number: " + stlpce.ID);
        writer.println("width: " + riadky.p_stlpcov);
        writer.println("height: " + stlpce.p_stlpcov);
        writer.println();

        writer.println("Statistiky");
        writer.println(Arrays.toString(statistika));
        writer.println();
        
        writer.println("Pocet cyklov");
        writer.println(Integer.toString(statistika[0]));
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
    
    public static void uloz_vysledky(int[] statistika) throws IOException{
     FileWriter fw = new FileWriter(file_name, true);
//      fw.write(Integer.toString(riadky.ID));
//        fw.write(" : ");
        fw.write(Integer.toString(statistika[0]));
        fw.write(oddelovac);
        fw.write(Integer.toString(statistika[14]));//+"\n");
        fw.write(oddelovac);
        fw.close();
    }
    
    public static void uloz_vysledky(int[] statistika, boolean b) throws IOException{
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
   
       public static void uloz_sety(int ID, ArrayList<Set<Integer>> mnozina) throws IOException{        
        System.out.println(ID);
        FileWriter fw = new FileWriter(file_name, true);
//        BufferedWriter bw = new BufferedWriter(out);
//        PrintWriter fw = new PrintWriter(bw);
        oddelovac = " ";
        fw.write(Integer.toString(ID));
        fw.write(oddelovac);
        for(Set s: mnozina){
            fw.write(s.toString());
            fw.write(oddelovac);
        }
        fw.write("\n");
        fw.close();
    }
}
