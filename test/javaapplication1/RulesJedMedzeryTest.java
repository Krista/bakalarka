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
import javaapplication1.Rules.Jed_medzery;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author krista
 */
public class RulesJedMedzeryTest {
    ArrayList<ArrayList<Integer>> list;
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Jed_medzery rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        
        list.add(new ArrayList(Arrays.asList(5, 3, 1, 9)));
        list.add(new ArrayList(Arrays.asList(4, 4, 4, 4, 5)));
        list.add(new ArrayList(Arrays.asList(3, 3, 3, 1)));
        list.add(new ArrayList(Arrays.asList(5, 5)));
        list.add(new ArrayList(Arrays.asList(6, 4)));

        list.add(new ArrayList(Arrays.asList(8, 16)));
        list.add(new ArrayList(Arrays.asList(8, 6)));
        list.add(new ArrayList(Arrays.asList(9, 5)));
        list.add(new ArrayList(Arrays.asList(10, 5)));
        list.add(new ArrayList(Arrays.asList(3, 3, 1, 5, 3)));

        list.add(new ArrayList(Arrays.asList(3, 3, 1, 5, 3)));
        list.add(new ArrayList(Arrays.asList(1, 1, 3, 5, 1)));
        list.add(new ArrayList(Arrays.asList(1, 1, 2, 2, 5, 1, 3)));
        list.add(new ArrayList(Arrays.asList(5, 2)));
        list.add(new ArrayList(Arrays.asList(2, 1)));
        
        inic = new Inicializacia(list, 25, 1);
        rule = r.new Jed_medzery(inic, inic);
        moje_riesenie= new ArrayList<>();
    }

    @Test
    public void test0() throws Chyba {
        int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(0,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));

    }

    @Test
    public void test1() throws Chyba {
        int[] a = {3,3,3,3,0, 3,3,3,3,0, 3,3,3,3,0, 3,3,3,3,0, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(1,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(1)));
    }
    
     @Test
    public void test2() throws Chyba {
        int[][] pom2 = {{0, 5}, {7, 14}, {12, 17}, {21, 23}};
        inic.set_hranice(pom2, 2);
        inic.riesenie.get(2).get(6).value = 0;
        inic.riesenie.get(2).get(24).value = 0;
        
        int[] a = {3,3,3,3,3, 3,0,3,3,3, 3,3,3,3,3, 3,3,3,0,0, 0,3,3,3,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(2,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(2)));
    }
    
     @Test
    public void test3() throws Chyba {
        int[][] pom3 = {{2, 8}, {15, 19}};
        inic.set_hranice(pom3, 3);
        inic.riesenie.get(3).get(5).value = 1;
        inic.riesenie.get(3).get(16).value = 1;
        inic.riesenie.get(3).get(17).value = 1;
        
        int[] a = {0,0,3,3,3, 1,3,3,3,0, 0,0,0,0,0, 3,1,1,3,3, 0,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(3,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(3)));
    }
    
    @Test
    public void test4() throws Chyba {       
        int[][] pom4 = {{3, 8}, {11, 13}};
        inic.set_hranice(pom4, 4);
        int[] a = {0,0,0,3,3, 3,3,3,3,0, 0,3,3,3,0, 0,0,0,0,0, 0,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(4,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(4)));
    }
    
     @Test
    public void test5() throws Chyba {
        int[] a = {3,3,3,3,3, 3,3,3,0,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(5,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(5)));
    }
    
     @Test
    public void test6() throws Chyba {
         int[][] pom6 = {{0, 11}, {10, 20}};
        inic.set_hranice(pom6, 6);
        inic.riesenie.get(6).get(4).value = 1;
        inic.riesenie.get(6).get(5).value = 1;
        inic.riesenie.get(6).get(6).value = 1;
        inic.riesenie.get(6).get(7).value = 1;
        inic.riesenie.get(6).get(16).value = 1;
        inic.riesenie.get(6).get(15).value = 1;
        inic.riesenie.get(6).get(21).value = 0;
        inic.riesenie.get(6).get(22).value = 0;
        inic.riesenie.get(6).get(23).value = 0;
        inic.riesenie.get(6).get(24).value = 0;
        int[] a = {3,3,3,3,1, 1,1,1,3,3, 3,3,3,3,3, 1,1,3,3,3, 3,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(6,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(6)));
    }
    
     @Test
    public void test7() throws Chyba {
        int[][] pom7 = {{3, 14}, {17, 22}};
        inic.set_hranice(pom7, 7);
        inic.riesenie.get(7).get(8).value = 1;
        inic.riesenie.get(7).get(13).value = 0;
        int[] a = {0,0,0,3,3, 3,3,3,1,3, 3,3,3,0,3, 0,0,3,3,3, 3,3,3,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(7,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(7)));
    }
    
     @Test
    public void test8() throws Chyba {
        int[][] pom8 = {{0, 18}, {12, 17}};
        inic.set_hranice(pom8, 8);
        inic.riesenie.get(8).get(9).value = 1;
        int[] a = {3,3,3,3,3, 3,3,3,3,1, 3,3,3,3,3, 3,3,3,0,0, 0,0,0,0,0}; 
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(8,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(8)));
    }
     @Test
    public void test9() throws Chyba {
        inic.riesenie.get(9).get(0).value = 1;
        inic.riesenie.get(9).get(5).value = 1;
        inic.riesenie.get(9).get(6).value = 1;
        inic.riesenie.get(9).get(8).value = 1;
        inic.riesenie.get(9).get(17).value = 1;
        inic.riesenie.get(9).get(18).value = 1;
        inic.riesenie.get(9).get(19).value = 1;
        inic.riesenie.get(9).get(21).value = 1;
        inic.riesenie.get(9).get(23).value = 1;
        int[] a = {1,3,3,3,3, 1,1,3,1,3, 3,3,3,3,3, 3,3,1,1,1, 3,1,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(9,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(9)));
    }
     @Test
    public void test10() throws Chyba {
        inic.riesenie.get(10).get(0).value = 1;
        inic.riesenie.get(10).get(5).value = 1;
        inic.riesenie.get(10).get(6).value = 1;
        inic.riesenie.get(10).get(8).value = 1;
        inic.riesenie.get(10).get(17).value = 1;
        inic.riesenie.get(10).get(18).value = 1;
        inic.riesenie.get(10).get(19).value = 1;
        inic.riesenie.get(10).get(21).value = 1;
        inic.riesenie.get(10).get(23).value = 1;
        inic.riesenie.get(10).get(12).value = 0;
        inic.riesenie.get(10).get(13).value = 0;
        int[] a = {1,3,3,3,3, 1,1,3,1,3, 3,3,0,0,3, 3,3,1,1,1, 3,1,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(10,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(10)));
    }
     @Test
    public void test11() throws Chyba {
        int[][] pom11 = {{0, 6}, {2, 8}, {6, 12}, {14, 22}, {20, 24}};
        inic.set_hranice(pom11, 11);
        inic.riesenie.get(11).get(6).value = 1;
        inic.riesenie.get(11).get(22).value = 1;
        inic.riesenie.get(11).get(13).value = 0;
        int[] a = {3,3,3,3,3, 3,1,3,3,3, 3,3,3,0,3, 3,3,3,3,3, 3,3,1,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(11,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(11)));
    }
     @Test
    public void test12() throws Chyba {
        int[][] pom12 = {{0, 7}, {3, 12}, {5, 8}, {11, 14}, {14, 19}, {17,22}, {19,24}};
        inic.set_hranice(pom12, 12);
        inic.riesenie.get(12).get(5).value = 1;
        inic.riesenie.get(12).get(8).value = 1;
        inic.riesenie.get(12).get(11).value = 1;
        inic.riesenie.get(12).get(19).value = 1;
        int[] a = {3,3,3,3,3, 1,3,3,1,0, 0,1,3,3,3, 3,3,3,3,1, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(12,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(12)));
    }
     @Test
    public void test13() throws Chyba {
         inic.riesenie.get(13).get(1).value = 1;
        inic.riesenie.get(13).get(23).value = 1;
        int[] a = {3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(13,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(13)));
    }
     @Test
    public void test14() throws Chyba {
        inic.riesenie.get(14).get(3).value = 1;
        inic.riesenie.get(14).get(2).value = 0;
        inic.riesenie.get(14).get(4).value = 0;
        int[] a =  {3,3,0,1,0, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(14,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(14)));
    }
    
}
