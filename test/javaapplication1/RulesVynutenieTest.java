/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javaapplication1.Rules.Vynutenie;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author krista
 */
public class RulesVynutenieTest {
    ArrayList<ArrayList<Integer>> list;
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Vynutenie rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        
        list.add(new ArrayList(Arrays.asList(2, 3, 1)));
        list.add(new ArrayList(Arrays.asList(5)));
        list.add(new ArrayList(Arrays.asList(7, 10)));
        list.add(new ArrayList(Arrays.asList(6, 3, 2)));
        
        list.add(new ArrayList(Arrays.asList(3, 4, 5)));
        list.add(new ArrayList(Arrays.asList(4, 1, 3)));       
        list.add(new ArrayList(Arrays.asList(5,4)));
                
        inic = new Inicializacia(list, 25, 1);
        rule = r.new Vynutenie(inic, inic);
        moje_riesenie= new ArrayList<>();
    }

    @Test
    public void test0() throws Chyba {
        int[][] pom0 = {{2, 9}, {5, 11}, {9, 15}};
        inic.set_hranice(pom0, 0);
        inic.riesenie.get(0).get(7).value = 1;
         inic.riesenie.get(0).get(8).value = 1;
          inic.riesenie.get(0).get(10).value = 1;
        int[] a = {3,3,3,3,3, 3,3,1,1,0, 1,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(0,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));

    }

    @Test
    public void test1() throws Chyba {
        int[][] pom1 = {{0, 24}};
        inic.set_hranice(pom1, 1);
        inic.riesenie.get(1).get(9).value = 1;
         inic.riesenie.get(1).get(10).value = 1;
          inic.riesenie.get(1).get(12).value = 1;
           inic.riesenie.get(1).get(13).value = 1;
          inic.riesenie.get(1).get(14).value = 1;
        int[] a = {3,3,3,3,3, 3,3,3,3,1, 1,0,1,1,1, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(1,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(1)));
    }
    
    @Test
    public void test2() throws Chyba {
       int[][] pom2 = {{0, 10}, {8, 24}};
        inic.set_hranice(pom2, 2);
        inic.riesenie.get(2).get(0).value = 1;
         inic.riesenie.get(2).get(2).value = 1;
          inic.riesenie.get(2).get(3).value = 1;
           inic.riesenie.get(2).get(4).value = 1;
            inic.riesenie.get(2).get(5).value = 1;
            inic.riesenie.get(2).get(6).value = 1;
         inic.riesenie.get(2).get(16).value = 1;
          inic.riesenie.get(2).get(20).value = 1;
        int[] a = {1,3,1,1,1, 1,1,3,3,3, 3,3,3,3,3, 3,1,3,3,3, 1,3,3,3,3}; 
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(2,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(2)));
    }
    
     @Test
    public void test3() throws Chyba {
         int[][] pom3 = {{0, 14}, {7, 21}, {23, 24}};
        inic.set_hranice(pom3, 3);
        inic.riesenie.get(3).get(7).value = 1;
         inic.riesenie.get(3).get(8).value = 1;
          inic.riesenie.get(3).get(10).value = 1;
           inic.riesenie.get(3).get(20).value = 1;
         inic.riesenie.get(3).get(21).value = 1;
          inic.riesenie.get(3).get(23).value = 1;
          inic.riesenie.get(3).get(24).value = 1;
        int[] a = {3,3,3,3,3, 3,3,1,1,3, 1,3,3,3,3, 3,3,3,3,3, 1,1,0,1,1};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(3,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(3)));
    }
    
    @Test
    public void test4() throws Chyba {       
         int[][] pom4 = {{0, 13}, {4, 18}, {9, 24}};
        inic.set_hranice(pom4, 4);
        inic.riesenie.get(4).get(11).value = 1;
         inic.riesenie.get(4).get(12).value = 1;
          inic.riesenie.get(4).get(14).value = 1;
        int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,1,1,3,1, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(4,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(4)));
    }
    
     @Test
    public void test5() throws Chyba {
         int[][] pom5 = {{0, 7}, {5, 14}, {9, 19}};
        inic.set_hranice(pom5, 5);
        inic.riesenie.get(5).get(7).value = 1;
         inic.riesenie.get(5).get(9).value = 1;
        int[] a = {3,3,3,3,3, 3,3,1,0,1, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(5,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(5)));
    }
    
     @Test
    public void test6() throws Chyba {        
       int[][] pom6 = {{7, 15}, {11, 19}};
        inic.set_hranice(pom6, 6);
        inic.riesenie.get(6).get(12).value = 1;
         inic.riesenie.get(6).get(13).value = 1;
          inic.riesenie.get(6).get(15).value = 1;
            inic.riesenie.get(6).get(16).value = 1;
        int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,1,1,0, 1,1,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(6,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(6)));
    }
    
    
    
}
