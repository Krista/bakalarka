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
import javaapplication1.Rules.Jednotky;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author krista
 */
public class RulesJednotkyTest {
    ArrayList<ArrayList<Integer>> list;
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Jednotky rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        
        list.add(new ArrayList(Arrays.asList(1, 1, 3)));
        list.add(new ArrayList(Arrays.asList(1, 1, 3)));
        list.add(new ArrayList(Arrays.asList(2, 3)));
        list.add(new ArrayList(Arrays.asList(3, 1, 1)));
        list.add(new ArrayList(Arrays.asList(3, 1, 2)));
        
        list.add(new ArrayList(Arrays.asList(1, 4, 4, 1)));     
        list.add(new ArrayList(Arrays.asList(1, 1, 3, 5, 1)));
        list.add(new ArrayList(Arrays.asList(1, 1, 2, 2, 5, 1, 3)));
                
        inic = new Inicializacia(list, 25, 1);
        rule = r.new Jednotky(inic, inic);
        moje_riesenie= new ArrayList<>();
    }

    @Test
    public void test0() throws Chyba {
        int[][] pom0 = {{3, 9}, {7, 13}, {13, 21}};
        inic.set_hranice(pom0, 0);
          inic.riesenie.get(0).get(13).value = 1;
        inic.riesenie.get(0).get(16).value = 1;
        int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,0,1,3, 3,1,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(0,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));

    }

    @Test
    public void test1() throws Chyba {
        int[][] pom1 = {{3, 11}, {7, 13}, {10, 17}};
        inic.set_hranice(pom1, 1);
          inic.riesenie.get(1).get(10).value = 1;
        int[] a = {3,3,3,3,3, 3,3,3,3,0, 1,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(1,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(1)));
    }
    
    @Test
    public void test2() throws Chyba {
         int[][] pom2 = {{8,13}, {12, 17}};
        inic.set_hranice(pom2, 2);
         inic.riesenie.get(2).get(12).value = 1;
           inic.riesenie.get(2).get(13).value = 1;   
        
        int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,1,1,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(2,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(2)));
    }
    
     @Test
    public void test3() throws Chyba {
        int[][] pom3 = {{0, 6}, {4, 11}, {6, 13}};
        inic.set_hranice(pom3, 3);
          inic.riesenie.get(3).get(6).value = 1;
        
        int[] a =  {3,3,3,3,3, 3,1,0,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(3,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(3)));
    }
    
    @Test
    public void test4() throws Chyba {       
         int[][] pom4 = {{0, 6}, {4, 11}, {6, 13}};
        inic.set_hranice(pom4, 4);
          inic.riesenie.get(4).get(6).value = 1;
        int[] a = {3,3,3,3,3, 3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(4,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(4)));
    }
    
     @Test
    public void test5() throws Chyba {
        int[][] pom5 = {{3, 10}, {9, 14}, {15, 18}, {13, 24}};
        inic.set_hranice(pom5, 5);
        inic.riesenie.get(5).get(9).value = 1;
        inic.riesenie.get(5).get(15).value = 1;
        int[] a = {3,3,3,3,3, 3,3,3,0,1, 3,3,3,3,0, 1,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(5,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(5)));
    }
    
     @Test
    public void test6() throws Chyba {
        int[][] pom6 = {{0, 6}, {2, 8}, {6, 12}, {14, 22}, {20, 24}};
        inic.set_hranice(pom6, 6);
        inic.riesenie.get(6).get(6).value = 1;
        inic.riesenie.get(6).get(22).value = 1;
        inic.riesenie.get(6).get(13).value = 0;
        int[] a = {3,3,3,3,3, 0,1,3,3,3, 3,3,3,0,3, 3,3,3,3,3, 3,3,1,0,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(6,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(6)));
    }
    
     @Test
    public void test7() throws Chyba {
       int[][] pom7 = {{0, 7}, {3, 12}, {5, 8}, {11, 14}, {14, 19}, {17,22}, {19,24}};
        inic.set_hranice(pom7, 7);
        inic.riesenie.get(7).get(5).value = 1;
        inic.riesenie.get(7).get(8).value = 1;
        inic.riesenie.get(7).get(11).value = 1;
        inic.riesenie.get(7).get(19).value = 1;
        int[] a = {3,3,3,3,0, 1,3,3,1,0, 0,1,3,3,3, 3,3,3,3,1, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(7,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(7)));
    }
    
    
}
