/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class JavaApplication1 {

    

    /* public static void main(String[] args) throws IOException {
         Document doc = Jsoup.connect("http://www.griddlers.net/griddlers?p_p_id=griddlers_WAR_puzzles&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=html&p_p_cacheability=cacheLevelPage&p_p_col_id=column-2&p_p_col_count=1&_griddlers_WAR_puzzles_view=detail&_griddlers_WAR_puzzles_id=134071").get();
        //String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        //Document doc = Jsoup.parse(html);

        //spracuj(doc);
        Path file = Paths.get("C:\\Users\\User\\Downloads\\puzzles.sql\\puzzles.sql");
        //                                                                                                                                                                                  zisti(file);
        // tahaj(file);
       // PrintWriter writer = new PrintWriter("143177", "UTF-8");
        //spracuj("143177", writer);

        //} while (c.equals("topHeader"));
        //System.out.println(b);
//String text = doc.body().text(); // "An example link"
        /* String linkHref = link.attr("href"); // "http://example.com/"
        String linkText = link.text(); // "example""

        String linkOuterH = link.outerHtml();
        // "<a href="http://example.com"><b>example</b></a>"
        String linkInnerH = link.html(); // "<b>example</b>"
        System.out.println(linkHref);*/
    //}
    
    
    
    /*public static void main(String[] args) throws IOException {
        ArrayList<Integer> zadanie = new ArrayList<>();
        zadanie.add(3);
        zadanie.add(1);
        zadanie.add(1);
        //zadanie.add(1);
        //zadanie.add(3);
       // int[] riadok = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //t metody.jednoduche_medzery(zadanie, riadok, 15);

        ArrayList<ArrayList<Integer>> top = new ArrayList<>();
        top.add(zadanie);
       // Inicializacia skus = new Inicializacia(top, 14);
        /* System.out.println(Arrays.toString(skus.pole_hodnot[0][0]));
        System.out.println(Arrays.toString(skus.pole_hodnot[0][1]));
        System.out.println(Arrays.toString(skus.pole_hodnot[0][2]));
         */
        //Logical_rules pracuj = new Logical_rules(skus, top);
        //pracuj.prienik(0);
        //System.out.println(pracuj.riesenie.get(0).toString());
        //int[][] pom = {{1, 3}, {5, 7}, {10, 14}};
        //skus.set(pom, 0);
        //pracuj.jed_medzery(0);

        //int[][] t = {{0, 3}, {2, 6}, {8, 9}, {11, 13}};
       // int[][] t = {{0, 1}, {3, 11}, {8, 11}};
        //skus.set(t, 0);

       /* System.out.println(Arrays.toString(skus.pole_hodnot[0][0]));
        System.out.println(Arrays.toString(skus.pole_hodnot[0][1]));
        System.out.println(Arrays.toString(skus.pole_hodnot[0][2]));
        // System.out.println(Arrays.toString(skus.pole_hodnot[0][3]));
        System.out.println("");

      /*int[] a =  {3, 3, 3, 3, 3, 1, 3, 1, 1, 3, 1, 1, 3, 3};
        //Integer[] a = {0, 3, 0, 3, 0, 0, 3, 3, 1, 0, 3, 0, 3, 1, 3, 0, 3, 3};
        ArrayList<MyInt> riesenie = new ArrayList<>();
        riesenie.addAll(Arrays.asList(a));
        pracuj.set_r(riesenie, 0);*/

        //pracuj.jednotky(0);
        //pracuj.jednotky_za(0);
        //pracuj.vynutenie(0);
        //pracuj.lepidlo(0);
        // pracuj.update0(0);
        // pracuj.update1(0);
        //pracuj.update2(0);
        //pracuj.medzivypln(0);
        //pracuj.okliestenie(0);
        // pracuj.nekryjuce(0);

        //System.out.println("segmenty:" + pracuj.seg_cierne(0, 2).toString());
      /*  System.out.println(Arrays.toString(skus.pole_hodnot[0][0]));
        System.out.println(Arrays.toString(skus.pole_hodnot[0][1]));
        System.out.println(Arrays.toString(skus.pole_hodnot[0][2]));*/
        //System.out.println(Arrays.toString(skus.pole_hodnot[0][3]));
      //  MyInt.toString(pracuj.riesenie);

        // pom = logical_rules.inicializacia(zadanie, 15);
        //System.out.println(top.get(0));
        //metody.lepidlo(zadanie, riadok);
        //System.out.println(Arrays.toString(riadok));
   // }
    
    
    public static void main(String[] args) throws IOException, Porucha {
       // PrintWriter writer = new PrintWriter("143330.txt", "UTF-8");
//        PrintWriter writer = new PrintWriter(new FileWriter("4938.txt"), true);
//        Files_creator.spracuj("4938", writer);
////       
       int cislo = 317;//11502;//337(364)365,(379)
   int[] pravidla = {1,2,3,4,5,6,7,8,9,10,11,12,13};
     //int[] pravidla = {0,0,0,0,0, 0,0,0,0,0, 0,0,0,14};
     Vyries v = new Vyries(cislo, pravidla);
       
        Path data = Paths.get("puzzles.sql");
  // Files_creator.tahaj(data);
     //   Files_creator.zisti(data);y
         Path file = Paths.get("zoznam.txt");
    //Vyries.ries_dvojako(file);//, pravidla);
     //  Vyries.tieto_ries(file);//, pravidla);
    
      // int cislo= 317;
      //   Vyries v = new Vyries(cislo, pravidla);
      //   v.Ries();
//         Subset s = new Subset(cislo);
//         
       /*Read_nono krizovka = new Read_nono(cislo);        
        Inicializacia inic = krizovka.zrob_stlpce();
        //inic.riesenie.get(0).get(2).value = 1;
        
        System.out.println(cislo);
        Inicializacia inic2 = krizovka.zrob_riadky(inic.riesenie);
        Logical_rules p = new Logical_rules(inic);
        Logical_rules r = new Logical_rules(inic2);*/
//    System.out.println("riadky1");
//    for(int i = 0; i<inic.p_stlpcov ;i++){  
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i); 
//         r.medzivypln(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//        
//         r.jed_medzery(i);
//         r.okliestenie(i);
//        // r.nekryjuce(i);
//         r.vynutenie(i);}
//         
//    MyInt.toString(inic2.riesenie); 
//    
//        System.out.println("stlpce1");
//while(true){
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//       
//        p.prienik(i);
//         p.update0(i);
//         p.prienik(i);
//         p.update1(i);
//         p.prienik(i);
//         p.update2(i);
//         p.prienik(i);
//         p.lepidlo(i);
//         p.prienik(i);
//         p.jednotky(i);
//         p.prienik(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.prienik(i);
//         p.jed_medzery(i);
//         p.prienik(i);
//         p.okliestenie(i);
//         p.prienik(i);
//         p.nekryjuce(i);
//         p.vynutenie(i);
//     }
//       System.out.println("");
//           
//        System.out.println("riadky2");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//                
//   //MyInt.jeden_toString(inic2.riesenie.get(i));
//        System.out.println("");
//        r.prienik(i);
//         r.update0(i);
//         r.prienik(i);
//          r.update1(i);
//          r.prienik(i);
//         r.update2(i); 
//r.prienik(i);         
//         r.lepidlo(i);
//         r.prienik(i);
//         r.jednotky(i);
//         r.prienik(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.prienik(i);
//         r.jed_medzery(i);
//         r.prienik(i);
//         r.okliestenie(i);
//         r.prienik(i);
//        r.nekryjuce(i);
//        r.prienik(i);
//         r.vynutenie(i);
//         r.prienik(i);
//         
//     } 
//}
//    
//       MyInt.toString(inic2.riesenie);  
//     System.out.println("stlpce2");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//            
////            for( int j = 0; j < inic.zadanie.get(i).size(); j++){
////                System.out.print(Arrays.toString(inic.pole_hodnot[i][j]));
////            }
////            System.out.println("");
//       
//        p.prienik(i);
//         p.update0(i);
//         p.prienik(i);
//         p.update1(i);
//         p.prienik(i);
//         p.update2(i);
//         p.prienik(i);
//         p.lepidlo(i);
//         p.prienik(i);
//         p.jednotky(i);
//         p.prienik(i);
//         p.jednotky_za(i);
//         p.prienik(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.prienik(i);
//         p.jed_medzery(i);
//         p.prienik(i);
//         p.okliestenie(i);
//         p.prienik(i);
//        // p.nekryjuce(i);
//         p.vynutenie(i);
//         p.prienik(i);   
////            for( int j = 0; j < inic.zadanie.get(i).size(); j++){
////                System.out.print(Arrays.toString(inic.pole_hodnot[i][j]));
////            }
////            System.out.println("");
//       
//     }
//        
//        System.out.println("riadky3");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
////           for( int j = 0; j < inic2.zadanie.get(i).size(); j++){
////                System.out.print(Arrays.toString(inic2.pole_hodnot[i][j]));
////            }
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//        // r.nekryjuce(i);
//         r.vynutenie(i);
////            for( int j = 0; j < inic2.zadanie.get(i).size(); j++){
////                System.out.print(Arrays.toString(inic2.pole_hodnot[i][j]));
////            }
////     }
//     }
//      MyInt.toString(inic2.riesenie);  
//     System.out.println("stlpce3");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//       //  p.nekryjuce(i);
//         p.vynutenie(i);
//           
//     }
//        System.out.println("");
//        System.out.println("riadky4");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//         r.nekryjuce(i);
//         r.vynutenie(i);
//     }
//   
//       System.out.println("stlpce4");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update0(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//        p.nekryjuce(i);
//         p.vynutenie(i);
//     }
//    
//     System.out.println("");
//        System.out.println("riadky5");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//        r.nekryjuce(i);
//         r.vynutenie(i);
//     }
//     System.out.println("stlpce5");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update0(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//         p.nekryjuce(i);
//         p.vynutenie(i);
//     }
//     System.out.println("");
//        System.out.println("riadky6");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//         r.nekryjuce(i);
//         r.vynutenie(i);
//     }
//     System.out.println("stlpce6");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update0(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//         p.nekryjuce(i);
//         p.vynutenie(i);
//     }
//     System.out.println("");
//        System.out.println("riadky7");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//       r.nekryjuce(i);
//         r.vynutenie(i);
//     }
//     System.out.println("stlpce8");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update0(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//         p.nekryjuce(i);
//         p.vynutenie(i);
//     }
//
//     System.out.println("");
//        System.out.println("riadky8");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//       r.nekryjuce(i);
//         r.vynutenie(i);
//     }
//     System.out.println("stlpce7");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update0(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//         p.nekryjuce(i);
//         p.vynutenie(i);
//     }
//    
//     System.out.println("");
//        System.out.println("riadky9");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//       r.nekryjuce(i);
//         r.vynutenie(i);
//     }
//     System.out.println("stlpce9");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update0(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//         p.nekryjuce(i);
//         p.vynutenie(i);
//     }
//    
//     System.out.println("");
//        System.out.println("riadky10");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//       r.nekryjuce(i);
//         r.vynutenie(i);
//     }
//     System.out.println("stlpce10");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update0(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//         p.nekryjuce(i);
//         p.vynutenie(i);
//     }
//    
//     System.out.println("");
//        System.out.println("riadky11");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//       r.nekryjuce(i);
//         r.vynutenie(i);
//     }
//     System.out.println("stlpce11");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update0(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//         p.nekryjuce(i);
//         p.vynutenie(i);
//     }
//    
//     System.out.println("");
//        System.out.println("riadky12");
//    for(int i = 0; i<inic.p_stlpcov ;i++){
//        r.prienik(i);
//         r.update0(i);
//          r.update1(i);
//         r.update2(i);          
//         r.lepidlo(i);
//         r.jednotky(i);
//         r.jednotky_za(i);
//         r.update1(i);
//         r.medzivypln(i);
//         r.jed_medzery(i);
//         r.okliestenie(i);
//       r.nekryjuce(i);
//         r.vynutenie(i);
//     }
//     System.out.println("stlpce12");
//    for(int i = 0; i<inic2.p_stlpcov ;i++){
//        p.prienik(i);
//         p.update0(i);
//         p.update1(i);
//         p.update2(i);
//         p.lepidlo(i);
//         p.jednotky(i);
//         p.jednotky_za(i);
//         p.update1(i);
//         p.medzivypln(i);
//         p.jed_medzery(i);
//         p.okliestenie(i);
//         p.nekryjuce(i);
//         p.vynutenie(i);
//     }
   /*
   r.riesenie.get(7).get(2).value=1;
     r.riesenie.get(7).get(4).value=1;
       r.riesenie.get(7).get(6).value=1;
         r.riesenie.get(7).get(3).value=0;
           r.riesenie.get(7).get(5).value=0; 
           r.riesenie.get(7).get(7).value=0;
           
            MyInt.toString(inic2.riesenie);
    System.out.print(Arrays.toString(inic2.pole_hodnot[7][0]));
        System.out.print(Arrays.toString(inic2.pole_hodnot[7][1]));
         System.out.print(Arrays.toString(inic2.pole_hodnot[7][2]));
         
       r.lepidlo(7);
       System.out.print(Arrays.toString(inic2.pole_hodnot[7][0]));
        System.out.print(Arrays.toString(inic2.pole_hodnot[7][1]));
         System.out.print(Arrays.toString(inic2.pole_hodnot[7][2]));
       
        System.out.println("");
       r.lepidlo(7);
        System.out.println("");
   
      
       int i = 7;
        p.prienik(i);
         p.update0(i);
         p.update1(i);
         p.update2(i);
         p.lepidlo(i);
         p.jednotky(i);
         p.jednotky_za(i);
         p.medzivypln(i);
         p.jed_medzery(i);
         p.okliestenie(i);
         p.nekryjuce(i);
         p.vynutenie(i);*/
   
   
//        System.out.println("     vysledne riesenie");
//       MyInt.toString(inic2.riesenie);
//       //System.out.println(inic.zadanie.get(0).toString());
//     // System.out.println(Arrays.toString(inic.pole_hodnot[0][0]));
//        for (int i = 0 ; i < inic.p_stlpcov; i++){
//            for( int j = 0; j < inic2.zadanie.get(i).size(); j++){
//                System.out.print(Arrays.toString(inic2.pole_hodnot[i][j]));
//            }
//            System.out.println("");
//        }
        
        
//        
//        System.out.println("");
//        System.out.println("stlpce");
//          for (int i = 0 ; i < inic2.p_stlpcov; i++){
//            for( int j = 0; j < inic.zadanie.get(i).size(); j++){
//                System.out.print(Arrays.toString(inic.pole_hodnot[i][j]));
//            }
//            System.out.println("");
//        }
       /* ArrayList<Integer> zadanie = new ArrayList<>();
        zadanie.add(5);
        ArrayList<ArrayList<Integer>> top = new ArrayList<>();
        top.add(zadanie);
      Inicializacia skuska = new Inicializacia (top, 10);*/
    }
}
