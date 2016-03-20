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
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Read_nono {

    Path file;
    int number_nono;

    public Read_nono(int number) {
        this.number_nono = number;
        file = Paths.get("nonograms/" + this.number_nono + ".txt");
       // file = Paths.get("" + this.number_nono + ".txt");
        System.out.println(file);
    }

    public Inicializacia zrob_stlpce() throws IOException {

        int width;
        int heigh;
        ArrayList<ArrayList<Integer>> zadanie = new ArrayList<>();
        ArrayList<Integer> line;
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> riadky = Files.readAllLines(this.file, charset);

        String[] sirka = riadky.get(1).split(":");
        width = Integer.parseInt(sirka[1].trim());

        String[] vyska = riadky.get(2).split(":");
        heigh = Integer.parseInt(vyska[1].trim());

        String bez_zatv;
        String[] pom;
        for (int i = 8; i < width + 8; i++) {
            bez_zatv = riadky.get(i).replace("[", "");
            bez_zatv = bez_zatv.replace("]", "");
            // System.out.println(i-8 + ":  "+ bez_zatv);
            pom = bez_zatv.split(",");
            line = new ArrayList<>();
            for (String a : pom) {
                line.add(Integer.parseInt(a.trim()));
            }
            zadanie.add(line);
        }
       /* for (ArrayList<Integer> x : zadanie) {
            System.out.println(x.toString());
        }*/
        //System.out.println(Arrays.toString(riadok));
        return new Inicializacia(zadanie, heigh);

    }

   public  Inicializacia zrob_riadky(ArrayList<ArrayList<MyInt>> rr) throws IOException {

        int width;
        int heigh;
        ArrayList<ArrayList<Integer>> zadanie = new ArrayList<>();
        ArrayList<Integer> line;
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> riadky = Files.readAllLines(this.file, charset);

        String[] sirka = riadky.get(1).split(":");
        width = Integer.parseInt(sirka[1].trim());

        String[] vyska = riadky.get(2).split(":");
        heigh = Integer.parseInt(vyska[1].trim());

        String bez_zatv;
        String[] pom;
        for (int i = 10 + width; i < width + heigh + 10; i++) {
            bez_zatv = riadky.get(i).replace("[", "");
            bez_zatv = bez_zatv.replace("]", "");
            // System.out.println(i-8 + ":  "+ bez_zatv);
            pom = bez_zatv.split(",");
            line = new ArrayList<>();
            for (String a : pom) {
                line.add(Integer.parseInt(a.trim()));
            }
            zadanie.add(line);
        }
        /* for (ArrayList<Integer> x : zadanie) {
            System.out.println(x.toString());
        }*/
        //System.out.println(Arrays.toString(riadok));
        return new Inicializacia(zadanie, width, rr);

    }
}
