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
import javaapplication1.Rules.Medzivypln;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author krista
 */
public class RulesMedzivyplnTest {
    ArrayList<ArrayList<Integer>> list;
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Medzivypln rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        
        list.add(new ArrayList(Arrays.asList(5,7,4)));
        list.add(new ArrayList(Arrays.asList(4,1,5,2)));
        list.add(new ArrayList(Arrays.asList(3,7,3)));
        list.add(new ArrayList(Arrays.asList(1,20,1)));
        list.add(new ArrayList(Arrays.asList(3,2,3,3,1)));
        
        list.add(new ArrayList(Arrays.asList(5,3,4)));//3.1 
                
        inic = new Inicializacia(list, 25, 1);
        rule = r.new Medzivypln(inic, inic);
        moje_riesenie= new ArrayList<>();
    }

    @Test
    public void test0() throws Chyba {
        int[][] pom0 = {{0, 9}, {8, 18}, {18, 24}};
        inic.set_hranice(pom0, 0);
        inic.riesenie.get(0).get(12).value = 1;
        inic.riesenie.get(0).get(13).value = 1;
        inic.riesenie.get(0).get(15).value = 1;

        int[][] pom10 = {{0,9}, {9,18}, {18,24}};      
        int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,1,1,1, 1,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(0,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));
        assertTrue(Arrays.deepEquals(pom10,inic.pole_hodnot[0]));
    }

    @Test
    public void test1() throws Chyba {         
        int[][] pom1 = {{0,9}, {10,13},{12,19}, {19,24}};
        inic.set_hranice(pom1, 1);
          inic.riesenie.get(1).get(4).value = 1;
          inic.riesenie.get(1).get(6).value = 1;
          inic.riesenie.get(1).get(14).value = 1;
          inic.riesenie.get(1).get(18).value = 1;
        
        int[][] pom11 =  {{3,7},{10,13},{14,18},{19,24}};
        int[] a =  {3,3,3,3,1, 1,1,3,3,3, 3,3,3,3,1, 1,1,1,1,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(1,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(1)));
        assertTrue(Arrays.deepEquals(pom11,inic.pole_hodnot[1]));
    }
    
    @Test
    public void test2() throws Chyba {
         int[][] pom2 = {{0,9}, {8,17}, {17,24}};
        inic.set_hranice(pom2, 2);
          inic.riesenie.get(2).get(8).value = 1;
          inic.riesenie.get(2).get(9).value = 1;
          inic.riesenie.get(2).get(11).value = 1;
          inic.riesenie.get(2).get(13).value = 1;
          inic.riesenie.get(2).get(20).value = 1;
          inic.riesenie.get(2).get(21).value = 1;

        int[][] pom12 = {{0,9}, {8,17}, {19,22}};
        int[] a = {3,3,3,3,3, 3,3,3,1,1, 3,1,1,1,3, 3,3,3,3,3, 1,1,3,3,3}; 
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(2,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(2)));
        assertTrue(Arrays.deepEquals(pom12,inic.pole_hodnot[2]));
    }
    
     @Test
    public void test3() throws Chyba {
        int[][] pom3 = {{0,6},{2,22},{22,24}};
        inic.set_hranice(pom3, 3);
          inic.riesenie.get(3).get(8).value = 1;
          inic.riesenie.get(3).get(9).value = 1;
          inic.riesenie.get(3).get(15).value = 1;
          inic.riesenie.get(3).get(20).value = 1;
          inic.riesenie.get(3).get(21).value = 1;
        
        int[][] pom13 = {{0,6}, {2,22}, {22,24}};
        int[] a = {3,3,3,3,3, 3,3,3,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(3,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(3)));
        assertTrue(Arrays.deepEquals(pom13,inic.pole_hodnot[3]));
    }
    
    @Test
    public void test4() throws Chyba {       
         int[][] pom4 = {{1,11}, {7,13}, {12,19},{16,22},{20,24}};
        inic.set_hranice(pom4, 4);
          inic.riesenie.get(4).get(0).value = 0;
          inic.riesenie.get(4).get(4).value = 1;
          inic.riesenie.get(4).get(10).value = 1;
          inic.riesenie.get(4).get(17).value = 1;
          inic.riesenie.get(4).get(19).value = 1;
        
        int[][] pom14 = {{2,6}, {9,11},{12,19},{16,22},{20,24}};
        int[] a = {0,3,3,3,1, 3,3,3,3,3, 1,3,3,3,3, 3,3,1,3,1, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(4,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(4)));
        assertTrue(Arrays.deepEquals(pom14,inic.pole_hodnot[4]));
    }
    
     @Test
    public void test5() throws Chyba {
         int[][] pom5 = {{0,19}, {7,14}, {13,24}};
        inic.set_hranice(pom5, 5);
          inic.riesenie.get(5).get(9).value = 1;
          inic.riesenie.get(5).get(11).value = 1;
        
        int[][] pom15 = {{0,19}, {7,14}, {13,24}}; 
        int[] a = {3,3,3,3,3, 3,3,3,3,1, 3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(5,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(5)));
        assertTrue(Arrays.deepEquals(pom15,inic.pole_hodnot[5]));
    }
    
     
    
    
}
