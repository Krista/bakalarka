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
import javaapplication1.Rules.Update2;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author krista
 */
public class RulesUpdate2Test {
    ArrayList<ArrayList<Integer>> list;
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Update2 rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        
        list.add(new ArrayList(Arrays.asList(3, 2, 1)));
        list.add(new ArrayList(Arrays.asList(2, 1, 1)));
        list.add(new ArrayList(Arrays.asList(1,2,1)));
        list.add(new ArrayList(Arrays.asList(3, 3,2)));
        list.add(new ArrayList(Arrays.asList(1, 2, 1, 2)));
        
        list.add(new ArrayList(Arrays.asList(2)));
        list.add(new ArrayList(Arrays.asList(2, 1, 1, 2)));
                
        inic = new Inicializacia(list, 20, 1);
        rule = r.new Update2(inic, inic);
        moje_riesenie= new ArrayList<>();
    }

    @Test
    public void test0() throws Chyba {
        int[][] pom0 = {{0, 7}, {3, 12}, {11, 19}};
        inic.set_hranice(pom0, 0);
        inic.riesenie.get(0).get(3).value = 1;
        inic.riesenie.get(0).get(4).value = 1;
        inic.riesenie.get(0).get(5).value = 1;
        
        int[][] pom10 = {{0,7},{7,12},{11,19}};   
        rule.run(0,inic);
        assertTrue(Arrays.deepEquals(pom10,inic.pole_hodnot[0]));
    }

    @Test
    public void test1() throws Chyba {
        int[][] pom1 = {{0, 15}, {3, 17}, {14, 19}};
        inic.set_hranice(pom1, 1);
        inic.riesenie.get(1).get(11).value = 1;              
        inic.riesenie.get(1).get(12).value = 1; 

        int[][] pom11 = {{0,15}, {14, 17}, {14,19}};
        rule.run(1,inic);
        assertTrue(Arrays.deepEquals(pom11,inic.pole_hodnot[1]));
    }
    
    @Test
    public void test2() throws Chyba {
        inic.riesenie.get(2).get(7).value = 1;
        inic.riesenie.get(2).get(8).value = 1;

        int[][] pom12 = {{0,14}, {2,17}, {5,19}};
        rule.run(2,inic);
        assertTrue(Arrays.deepEquals(pom12,inic.pole_hodnot[2]));
    }
    
     @Test
    public void test3() throws Chyba {
        int[][] pom3 = {{0, 9}, {4, 16}, {8, 19}};
        inic.set_hranice(pom3, 3);
        inic.riesenie.get(3).get(10).value = 1;
        inic.riesenie.get(3).get(11).value = 1;
        inic.riesenie.get(3).get(12).value = 1;

        int[][] pom13 = {{0,9},{4,16},{14,19}};
        rule.run(3,inic);
        assertTrue(Arrays.deepEquals(pom13,inic.pole_hodnot[3]));
    }
    
    @Test
    public void test4() throws Chyba {       
        int[][] pom4 = {{1, 11}, {2, 12}, {5, 16}, {9, 19}};
        inic.set_hranice(pom4, 4);
        inic.riesenie.get(4).get(1).value = 1;
        inic.riesenie.get(4).get(3).value = 1;
        inic.riesenie.get(4).get(4).value = 1;
        inic.riesenie.get(4).get(11).value = 1;
        inic.riesenie.get(4).get(12).value = 1;

        int[][] pom14 = {{1,1},{2,12}, {5,16},{9,19}};
        rule.run(4,inic);
        assertTrue(Arrays.deepEquals(pom14,inic.pole_hodnot[4]));
    }
    
     @Test
    public void test5() throws Chyba {
        int[][] pom5 = {{0, 8}, {3, 11}, {6, 15}, {10, 18}};
        inic.set_hranice(pom5, 5);
        inic.riesenie.get(5).get(4).value = 1;
        inic.riesenie.get(5).get(13).value = 1;
        inic.riesenie.get(5).get(15).value = 1;
        inic.riesenie.get(5).get(17).value = 1;
        inic.riesenie.get(5).get(18).value = 1;
        inic.riesenie.get(5).get(19).value = 0;
           
        int[][] pom15 = {{0,8},{3,11},{6,15},{10,18}};
        rule.run(5,inic);
        assertTrue(Arrays.deepEquals(pom15,inic.pole_hodnot[5]));
    }
    
     @Test
    public void test6() throws Chyba {
        inic.riesenie.get(6).get(9).value = 1;
        inic.riesenie.get(6).get(10).value = 0;
        
        int[][] pom16 = {{0,12},{3,14},{5,16},{7,19}};
        rule.run(6,inic);
        assertTrue(Arrays.deepEquals(pom16,inic.pole_hodnot[6]));
    }
    
}
