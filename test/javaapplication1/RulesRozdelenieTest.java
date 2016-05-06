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
import javaapplication1.Rules.Rozdelenie;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author krista
 */
public class RulesRozdelenieTest {
    ArrayList<ArrayList<Integer>> list;
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Rozdelenie rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
               
        list.add(new ArrayList(Arrays.asList(4,3,1)));
        list.add(new ArrayList(Arrays.asList(7,2)));
        list.add(new ArrayList(Arrays.asList(4,3)));
                        
        inic = new Inicializacia(list, 25, 1);
        rule = r.new Rozdelenie(inic, inic);
        moje_riesenie= new ArrayList<>();
    }

    @Test
    public void test0() throws Chyba {
        int[][] pom0 = {{0, 7}, {8, 14}, {15, 19}};
        inic.set_hranice(pom0, 0);
        inic.riesenie.get(0).get(1).value = 1;
        inic.riesenie.get(0).get(5).value = 1;
        inic.riesenie.get(0).get(9).value = 1;
        inic.riesenie.get(0).get(11).value = 1;
        inic.riesenie.get(0).get(18).value = 1;
        
        int[][] pom10 = {{0,3}, {8,14}, {15,19}};    
        rule.run(0,inic);
        assertTrue(Arrays.deepEquals(pom10,inic.pole_hodnot[0]));
    }

    @Test
    public void test1() throws Chyba {
        int[][] pom1 = {{0, 20}, {13, 24}};
        inic.set_hranice(pom1, 1);
        inic.riesenie.get(1).get(5).value = 1;
        inic.riesenie.get(1).get(8).value = 1;
        inic.riesenie.get(1).get(9).value = 1;
        inic.riesenie.get(1).get(11).value = 1;
        inic.riesenie.get(1).get(15).value = 1;
        
        int[][] pom11 = {{0,13}, {13,24}};
        rule.run(1,inic);
        assertTrue(Arrays.deepEquals(pom11,inic.pole_hodnot[1]));
    }
    
    @Test
    public void test2() throws Chyba {
        int[][] pom2 = {{0, 20}, {5, 24}};
        inic.set_hranice(pom2, 2);
        inic.riesenie.get(2).get(2).value = 1;
        inic.riesenie.get(2).get(3).value = 1;
        inic.riesenie.get(2).get(5).value = 1;
        inic.riesenie.get(2).get(6).value = 1;
                
        int[][] pom12 = {{0,3}, {5,24}};
        rule.run(2,inic);
        assertTrue(Arrays.deepEquals(pom12,inic.pole_hodnot[2]));
    }
    
    /*
     @Test
    public void test3() throws Chyba {
        inic.riesenie.get(3).get(7).value = 1;
        
        int[][] pom13 = {{0,24}};
        int[] a = {3,3,3,3,3, 3,3,1,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(3,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(3)));
        assertTrue(Arrays.deepEquals(pom13,inic.pole_hodnot[3]));
    }
    
    @Test
    public void test4() throws Chyba {       
        inic.riesenie.get(4).get(7).value = 1;
        inic.riesenie.get(4).get(12).value = 0;
        
        int[][] pom14 = {{0, 24}};
        int[] a = {3,3,3,3,1, 1,1,1,3,3, 3,3,0,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(4,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(4)));
        assertTrue(Arrays.deepEquals(pom14,inic.pole_hodnot[4]));
    }
    
     @Test
    public void test5() throws Chyba {
        inic.riesenie.get(5).get(5).value = 1;
        inic.riesenie.get(5).get(9).value = 0;
        
        int[][] pom15 = {{0, 24}};
        int[] a = {3,1,1,1,1, 1,1,1,3,0, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(5,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(5)));
        assertTrue(Arrays.deepEquals(pom15,inic.pole_hodnot[5]));
    }
    
     @Test
    public void test6() throws Chyba {        
        int[][] pom6 = {{0, 9}, {2, 13}, {5, 19}, {11, 24}};
        inic.set_hranice(pom6, 6);
        inic.riesenie.get(6).get(11).value = 0;
        inic.riesenie.get(6).get(13).value = 1;
        inic.riesenie.get(6).get(15).value = 1;
        inic.riesenie.get(6).get(16).value = 1;
        inic.riesenie.get(6).get(24).value = 1;
        
        int[][] pom16 = {{0, 9}, {2, 13}, {5, 19}, {21, 24}};
        int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,0,3,1,1, 1,1,3,3,3, 0,1,1,1,1};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(6,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(6)));
        assertTrue(Arrays.deepEquals(pom16,inic.pole_hodnot[6]));
    }
    
     @Test
    public void test7() throws Chyba {        
        int[][] pom7 = {{1, 6}, {3, 17}, {6, 20}, {13, 24}};
        inic.set_hranice(pom7, 7);
        inic.riesenie.get(7).get(0).value = 0;
        inic.riesenie.get(7).get(5).value = 1;
        inic.riesenie.get(7).get(6).value = 1;
        inic.riesenie.get(7).get(11).value = 0;
        inic.riesenie.get(7).get(12).value = 0;
        inic.riesenie.get(7).get(13).value = 1;
        inic.riesenie.get(7).get(23).value = 1;
        
        int[][] pom17 = {{1, 6}, {3, 17}, {6, 20}, {13, 24}};
        int[] a = {0,3,3,3,3, 1,1,3,3,3, 3,0,0,1,1, 1,0,3,3,3, 3,3,1,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(7,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(7)));
        assertTrue(Arrays.deepEquals(pom17,inic.pole_hodnot[7]));
    }
    
     @Test
    public void test8() throws Chyba {   
        inic.riesenie.get(8).get(11).value = 1;
        inic.riesenie.get(8).get(12).value = 1;
        
        int[][] pom18 = {{0, 24}};
        int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,1,1,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(8,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(8)));
        assertTrue(Arrays.deepEquals(pom18,inic.pole_hodnot[8]));
    }
    
    */
}
