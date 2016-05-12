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
import javaapplication1.Rules.Update0;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author krista
 */
public class RulesUpdate0Test {
    ArrayList<ArrayList<Integer>> list;
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Update0 rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        
        list.add(new ArrayList(Arrays.asList(5, 3, 1, 8)));
        list.add(new ArrayList(Arrays.asList(5, 1, 3)));
        list.add(new ArrayList(Arrays.asList(5, 4, 2)));
        list.add(new ArrayList(Arrays.asList(5, 2, 3)));
        list.add(new ArrayList(Arrays.asList(1, 4, 1, 2)));
        
        list.add(new ArrayList(Arrays.asList(2, 1, 1, 2)));
        list.add(new ArrayList(Arrays.asList(2, 1, 3)));     
        
        inic = new Inicializacia(list, 20, 1);
        rule = r.new Update0(inic, inic);
        moje_riesenie= new ArrayList<>();
    }

    @Test
    public void test0() throws Chyba {
        
        int[][] pom10 = {{0,4},{6,8},{10,10},{12,19}};    
        rule.run(0,inic);
        assertTrue(Arrays.deepEquals(pom10,inic.pole_hodnot[0]));
    }

    @Test
    public void test1() throws Chyba {
       
        int[][] pom11 = {{0,13},{6,15},{8,19}};
        rule.run(1,inic);
        assertTrue(Arrays.deepEquals(pom11,inic.pole_hodnot[1]));
    }
    
    @Test
    public void test2() throws Chyba {
        int[][] pom2 = {{0, 9}, {6, 12}, {16, 18}};
        inic.set_hranice(pom2, 2);

        int[][] pom12 = {{0,7},{6,12},{16,18}};
        rule.run(2,inic);
        assertTrue(Arrays.deepEquals(pom12,inic.pole_hodnot[2]));
    }
    
     @Test
    public void test3() throws Chyba {
        int[][] pom3 = {{0, 9}, {6, 9}, {7, 16}};
        inic.set_hranice(pom3, 3);
        
        int[][] pom13 = {{0,6},{6,9},{9,16}};
        rule.run(3,inic);
        assertTrue(Arrays.deepEquals(pom13,inic.pole_hodnot[3]));
    }
    
    @Test
    public void test4() throws Chyba {       
        int[][] pom4 = {{1,1}, {2, 10}, {7, 8}, {8, 19}};
        inic.set_hranice(pom4, 4);
        
        int[][] pom14 = {{1,1},{3,6},{8,8},{10,19}};
        rule.run(4,inic);
        assertTrue(Arrays.deepEquals(pom14,inic.pole_hodnot[4]));
    }
    
     @Test
    public void test5() throws Chyba {
        inic.riesenie.get(5).get(9).value = 1;
        inic.riesenie.get(5).get(10).value = 0;
        
        int[][] pom15 = {{0,12},{3,14},{5,16},{7,19}};
        rule.run(5,inic);
        assertTrue(Arrays.deepEquals(pom15,inic.pole_hodnot[5]));
    }
    
      @Test
    public void test6() throws Chyba {
        int[][] pom6 = {{0,8},{4,6},{5,14}};
        inic.set_hranice(pom6, 6);
        inic.riesenie.get(6).get(13).value = 0;
        inic.riesenie.get(6).get(14).value = 0;
        
        int[][] pom16 = {{0,8},{4,6},{5,14}};
        rule.run(6,inic);
        System.out.print(Arrays.toString(inic.pole_hodnot[6][0]));
        System.out.print(Arrays.toString(inic.pole_hodnot[6][1]));
        System.out.print(Arrays.toString(inic.pole_hodnot[6][2]));
        assertTrue(Arrays.deepEquals(pom16,inic.pole_hodnot[6]));
    }
    
    
}
