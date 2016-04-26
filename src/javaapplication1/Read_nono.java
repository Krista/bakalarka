/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.FileWriter;
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
 * rozparsuje subor, v ktorom mame ulozene zadanie krizovky a vytvori Inicializaciu, s ktorou mozeme dalej pracovat
 * 
 */
public class Read_nono {

    Path file;
    int number_nono;

    public Read_nono(int number) {
        this.number_nono = number;
       file = Paths.get("nonograms/" + this.number_nono + ".txt");
     // file = Paths.get("" + this.number_nono + ".txt");
        //System.out.println(file);
    }

    public Inicializacia zrob_stlpce() throws IOException {

        int width, heigh, value, p_ciernych, sekundy;
        p_ciernych = 0;
        String time, count;
        ArrayList<ArrayList<Integer>> zadanie = new ArrayList<>();
        ArrayList<Integer> line;
        Charset charset = Charset.forName("ISO-8859-1");
        try{
        List<String> riadky = Files.readAllLines(this.file, charset);
        
        String[] sirka = riadky.get(1).split(":");
        width = Integer.parseInt(sirka[1].trim());

        String[] vyska = riadky.get(2).split(":");
        heigh = Integer.parseInt(vyska[1].trim());

        String[] cas = riadky.get(4).split("  ");
        time = cas[1].trim().replaceAll("'","");
        cas = time.split(":");
        if(time.equals("NULL"))sekundy=0;
        else sekundy = (Integer.parseInt(cas[0].trim())*3600) + (Integer.parseInt(cas[1].trim())*60)+ Integer.parseInt(cas[2].trim());
        
        String[] poc = riadky.get(5).split(":");
        count = poc[1].trim();
                
        String bez_zatv;
        String[] pom;
        for (int i = 8; i < width + 8; i++) {
            bez_zatv = riadky.get(i).replace("[", "");
            bez_zatv = bez_zatv.replace("]", "");
            // System.out.println(i-8 + ":  "+ bez_zatv);
            pom = bez_zatv.split(",");
            line = new ArrayList<>();
            for (String a : pom) {
                if (a.equals(""))line.add(0);
                else {
                    value = Integer.parseInt(a.trim());
                    p_ciernych += value;
                    line.add(value);
                }
            }
            zadanie.add(line);
        } 
        
        
        String oddelovac = Memento.oddelovac;
        FileWriter fw = new FileWriter(Memento.file_name, true);
        fw.write(Integer.toString(number_nono));
        fw.write(oddelovac);
        fw.write(Integer.toString(width));
        fw.write(oddelovac);
        fw.write(Integer.toString(heigh));
        fw.write(oddelovac);
        fw.write(Integer.toString(heigh * width));
        fw.write(oddelovac);
        fw.write(Integer.toString(p_ciernych));
        fw.write(oddelovac);  
        fw.write(Integer.toString(sekundy));
        fw.write(oddelovac);
        fw.write(count);
        fw.write(oddelovac);
        fw.close();
        
        return new Inicializacia(zadanie, heigh, number_nono);
            }catch(IOException e){
            System.out.println("Krizovku " + this.number_nono + " sa nepodarilo najst");
        }return null;
    }

   public Inicializacia zrob_riadky(Inicializacia rr) throws IOException {
try{
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
                if (a.equals(""))line.add(0);
                else line.add(Integer.parseInt(a.trim()));
            }
            zadanie.add(line);
        }
        /* for (ArrayList<Integer> x : zadanie) {
            System.out.println(x.toString());
        }*/
        //System.out.println(Arrays.toString(riadok));
        return new Inicializacia(zadanie, width, rr);
 }catch(IOException e){
            System.out.println("Krizovku " + this.number_nono + " sa nepodarilo najst");
        }return null;
    }
}
