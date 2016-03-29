package javaapplication1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author krista
 */
public class Memento {

    public static int id;
    int por_cislo;
    Inicializacia stlpce;
    Inicializacia riadky;

    public Memento(Inicializacia stlpce, Inicializacia riadky) {
        this.por_cislo = id;
        this.stlpce = stlpce;
        this.riadky = riadky;
    }

    public void uloz_stav(String krizovka) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("MEM" + por_cislo + krizovka, "UTF-8");
        writer.println("Puzzle number: " + krizovka);
        writer.println("width: " + riadky.p_stlpcov);
        writer.println("height: " + stlpce.p_stlpcov);
        writer.println();

        writer.println("riesenie");
        for (ArrayList<MyInt> a : riadky.riesenie) {
            for (MyInt m : a) {
                writer.print(m.value + " ");
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
    
    public void import_stav(String name){
        
    }
}
