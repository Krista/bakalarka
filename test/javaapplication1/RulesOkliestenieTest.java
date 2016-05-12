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
import javaapplication1.Rules.Okliestenie;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author krista
 */
public class RulesOkliestenieTest {
    ArrayList<ArrayList<Integer>> list;
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Okliestenie rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        
        list.add(new ArrayList(Arrays.asList(4,3,1)));
        list.add(new ArrayList(Arrays.asList(3,3,4)));
        list.add(new ArrayList(Arrays.asList(4,4,2)));
        list.add(new ArrayList(Arrays.asList(3)));
        list.add(new ArrayList(Arrays.asList(3,2)));
                
        inic = new Inicializacia(list, 25, 1);
        rule = r.new Okliestenie(inic, inic);
        moje_riesenie= new ArrayList<>();
    }

    @Test
    public void test0() throws Chyba {
        int[][] pom0 = {{0,15}, {8,23},{19,24}};            
        inic.set_hranice(pom0, 0);
        inic.riesenie.get(0).get(9).value = 0;
        inic.riesenie.get(0).get(11).value = 0;
        inic.riesenie.get(0).get(12).value = 0;
        inic.riesenie.get(0).get(15).value = 1;
        inic.riesenie.get(0).get(16).value = 0;
        inic.riesenie.get(0).get(18).value = 0;
        inic.riesenie.get(0).get(20).value = 1;
        inic.riesenie.get(0).get(22).value = 0;


        int[][] pom10 = {{0,8}, {13,21},{19,24}};  
        rule.run(0,inic);
        assertTrue(Arrays.deepEquals(pom10,inic.pole_hodnot[0]));
    }

    @Test
    public void test1() throws Chyba {         
       int[][] pom1 = {{0,8}, {4,21}, {15,24}};
        inic.set_hranice(pom1, 1);
          inic.riesenie.get(1).get(4).value = 0;
          inic.riesenie.get(1).get(6).value = 0;
          inic.riesenie.get(1).get(8).value = 1;
          inic.riesenie.get(1).get(9).value = 1;
          inic.riesenie.get(1).get(12).value = 0;
          inic.riesenie.get(1).get(16).value = 0;
          inic.riesenie.get(1).get(19).value = 1;
          inic.riesenie.get(1).get(21).value = 0;
        
        int[][] pom11 =  {{0,3}, {7,20}, {17,20}};
        rule.run(1,inic);
        assertTrue(Arrays.deepEquals(pom11,inic.pole_hodnot[1]));
    }
    
    @Test
    public void test2() throws Chyba {
          int[][] pom2 = {{0,8}, {5,21},{20,24}};
          inic.set_hranice(pom2, 2);
          inic.riesenie.get(2).get(5).value = 0;
          inic.riesenie.get(2).get(10).value = 0;
          inic.riesenie.get(2).get(12).value = 0;
          inic.riesenie.get(2).get(14).value = 1;
          inic.riesenie.get(2).get(15).value = 1;
          inic.riesenie.get(2).get(18).value = 0;
          inic.riesenie.get(2).get(21).value = 0;

        int[][] pom12 = {{0,4}, {6,17},{22,24}};
        rule.run(2,inic);
        assertTrue(Arrays.deepEquals(pom12,inic.pole_hodnot[2]));
    }
    
     @Test
    public void test3() throws Chyba {
        int[][] pom3 = {{0,14}};
        inic.set_hranice(pom3, 3);
          inic.riesenie.get(3).get(1).value = 0;
          inic.riesenie.get(3).get(3).value = 0;
          inic.riesenie.get(3).get(4).value = 0;
          inic.riesenie.get(3).get(7).value = 1;
          inic.riesenie.get(3).get(9).value = 0;
          inic.riesenie.get(3).get(11).value = 0;
        
        int[][] pom13 = {{5,14}};
        int[] a = {3,0,3,0,0, 3,3,1,3,0, 0,0,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(3,inic);
        //MyInt.jeden_toString(inic.riesenie.get(3));
        //System.out.println(Arrays.toString(inic.pole_hodnot[3][0]));
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(3)));
        assertTrue(Arrays.deepEquals(pom13,inic.pole_hodnot[3]));
    }
    
    @Test
    public void test4() throws Chyba {       
         int[][] pom4 = {{0,11}, {4,14}};
        inic.set_hranice(pom4, 4);
          inic.riesenie.get(4).get(5).value = 0;
          inic.riesenie.get(4).get(9).value = 0;
          inic.riesenie.get(4).get(10).value = 1;
          inic.riesenie.get(4).get(14).value = 0;
        
        int[][] pom14 = {{0,8}, {6,13}};
        int[] a = {3,3,3,3,3, 0,3,3,3,0, 1,3,3,3,0, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rule.run(4,inic);
        //MyInt.jeden_toString(inic.riesenie.get(4));
//        System.out.println(Arrays.toString(inic.pole_hodnot[4][0]));
//        System.out.println(Arrays.toString(inic.pole_hodnot[4][1]));
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(4)));
        assertTrue(Arrays.deepEquals(pom14,inic.pole_hodnot[4]));
    }
    
   /*  @Test
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
    
     */
    
    
}
