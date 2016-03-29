/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author krista
 */
public class Files_creator {
    /**
     * 
     * @param id krizovky
     * @param writer odkaz na otvoreny subor
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException 
     * z portalu griddlers.txt nam stiahne zadanie krizovky a ulozi do suboru id.txt
     */
    public static void spracuj(String id, PrintWriter writer) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //PrintWriter writer = new PrintWriter("filexy.txt", "UTF-8");
        String addr = "http://www.griddlers.net/griddlers?p_p_id=griddlers_WAR_puzzles&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=html&p_p_cacheability=cacheLevelPage&p_p_col_id=column-2&p_p_col_count=1&_griddlers_WAR_puzzles_view=detail&_griddlers_WAR_puzzles_id=";
        addr += id;
        Document doc = Jsoup.connect(addr).get();

        Element link = doc.select("link").first();

        Element table = doc.select("table").first();
        Element size = table.select("td").last();
        String s = size.text(); //Size: 15x25 |  Author: Nicky |  Id: 134071 | Time:
        String[] p = s.split(" ")[1].split("x");
        //System.out.println(p[0]);
        int width = Integer.parseInt(p[0]);
        int height = Integer.parseInt(p[1]);
        Element title;
        String value;
        Integer a;

        Element top_table = doc.select("table").get(6);
        Element left_header = doc.select("table").get(7);
        ArrayList<ArrayList<Integer>> top = new ArrayList<>();
        ArrayList<ArrayList<Integer>> left = new ArrayList<ArrayList<Integer>>();

        for (int kk = 0; kk < width; kk++) {
            ArrayList<Integer> k = new ArrayList<>();
            top.add(kk, k);
        }
        for (int kk = 0; kk < height; kk++) {
            ArrayList<Integer> k = new ArrayList<>();
            left.add(kk, k);
        }

        Integer[] pom_pole = new Integer[width];
        Element tr = top_table.select("tr").first();
        int i = 0;
        int j = 0;

        //System.out.println("top_values");
        writer.println("top_values");
        do { //top_values
            title = tr.select("td").first();
            if (title.attr("title").equals("")) {
                break;
            }
            do {
                value = title.attr("title");
                //pom_pole[i] = Integer.parseInt(value);
                a = Integer.parseInt(value);
                if (a != 0) {
                    //top.get(i).add(Integer.parseInt(value));
                    top.get(i).add(a);
                }
                title = title.nextElementSibling();
                i++;
            } while (title != null);
            //top_values.add(pom_pole);
            tr = tr.nextElementSibling();
            j++;
            i = 0;
            //System.out.println(Arrays.toString(top.get(j - 1)));
            // System.out.println("dalsi riadok");
        } while (tr != null);

        for (int kk = 0; kk < width; kk++) {
            //System.out.println();
            writer.println(top.get(kk).toString());
        }

        writer.println();
        writer.println("left_values");
        tr = left_header.select("tr").first();
        title = tr.select("td").first(); //pocet cisel v riadku
        int x = 0;
        while (title != null) {
            value = title.attr("title");
            if (value.equals("")) {
                break;
            }
            title = title.nextElementSibling();
            x++;
        }

        Integer[] pom_pole2 = new Integer[x];
        j = 0;
        do { //left_values
            title = tr.select("td").first();
            if (title.attr("title").equals("")) {
                break;
            }
            do {
                value = title.attr("title");
                if (value.equals("")) {
                    break;
                }
                a = Integer.parseInt(value);
                if (a != 0) {
                    //left.get(j).add(Integer.parseInt(value));
                    left.get(j).add(a);
                }
                //pom_pole2[i] = Integer.parseInt(value);
                title = title.nextElementSibling();
                i++;
            } while (title != null);
            tr = tr.nextElementSibling();
            j++;
            i = 0;
            //System.out.println(Arrays.toString(left_values.get(j - 1)));
            writer.println(left.get(j - 1).toString());

        } while (tr != null);

        writer.close();
    }

    /**
     * 
     * @param file informacie o krizovkach
     * @throws IOException 
     * z databazy pre krizovky ktore su 2 farebne, jednoduche vytiahne informacie o pocte riesitelov, strednom case..
     * vytvori subor obsahujuci id krizovky a takto rozpracovany subor posle funcii spracuj
     */
    public static void tahaj(Path file) throws IOException {
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> databaza = Files.readAllLines(file, charset);
        for (String line : databaza) {
            if (line.startsWith("INSERT") || line.startsWith("SET") || line.startsWith("/") || line.isEmpty()) {
            } else {
                line = line.replaceAll("[()]", "");
                String[] riadok = line.split(",");
                //System.out.println(Arrays.toString(riadok));
                int dote = Integer.parseInt(riadok[0]);
                if ((dote > 155386) && riadok[4].equals(" 2") && riadok[3].equals(" 'f'")) {
                    PrintWriter writer = new PrintWriter(riadok[0], "UTF-8");
                    writer.println("Puzzle number: " + riadok[0]);
                    writer.println("width: " + riadok[1]);
                    writer.println("height: " + riadok[2]);
                    writer.println("solved_count: " + riadok[6]);
                    writer.println("AVE_TIME: " + riadok[7]);
                    writer.println("ave_time_count: " + riadok[8]);
                    writer.println("");

                    spracuj(riadok[0], writer);
                    //nepodarilo sa : 143177,143330,143516,154753,154875,155386
                    /*System.out.println("puzzle number: " + riadok[0]);
                 System.out.println("width: " + riadok[1]);
                 System.out.println("height: " + riadok[2]);
                System.out.println("solved_count: " + riadok[6]);
                System.out.println("AVE_TIME: " + riadok[7]);
                System.out.println("ave_time_count: " + riadok[8]);
               System.out.println("");*/
                }
            }
        }
    }

    /**
     * 
     * @param file
     * @throws IOException 
     * vytiahne nam cisla krizoviek, ktore su dvojfarebne a ulozi ich do suboru classic.txt alebo do trojuholnikove2.txt 
     */
    public static void zisti(Path file) throws IOException {
        //PrintWriter writer = new PrintWriter("trojuholnikove2", "UTF-8");
        //  PrintWriter writer2 = new PrintWriter("classic", "UTF-8");
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> databaza = Files.readAllLines(file, charset);
        for (String line : databaza) {
            if (line.startsWith("INSERT") || line.startsWith("SET") || line.startsWith("/") || line.isEmpty()) {
            } else {
                line = line.replaceAll("[()]", "");
                String[] riadok = line.split(",");
                //System.out.println(Arrays.toString(riadok));
                if (riadok[4].equals(" 2")) {
                    if (riadok[3].equals(" 't'")) { //dvojfarebne trojuholnikove

                        //writer.print(riadok[0]);
                        //writer.print(", ");
                    }
                }
                /* else {
                    writer2.print(riadok[0]);
                    writer2.print(", ");
                    }*/
            }
        }
        // writer.close();
        //writer2.close();
    }
}
