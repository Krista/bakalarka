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
import javaapplication1.Rules.Update1;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author krista
 */
public class RulesUpdate1Test {
    ArrayList<ArrayList<Integer>> list;
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Update1 rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        
        list.add(new ArrayList(Arrays.asList(1, 3, 6)));
        list.add(new ArrayList(Arrays.asList(4, 3, 3, 1)));
        list.add(new ArrayList(Arrays.asList(1, 2, 3, 2)));
        list.add(new ArrayList(Arrays.asList(2, 7)));
        list.add(new ArrayList(Arrays.asList(3)));
        
        list.add(new ArrayList(Arrays.asList(2, 1, 1, 2)));
                
        inic = new Inicializacia(list, 20, 1);
        rule = r.new Update1(inic, inic);
        moje_riesenie= new ArrayList<>();
    }

    @Test
    public void test0() throws Chyba {
        int[][] pom0 = {{0, 4}, {4, 11}, {10, 19}};
        inic.set_hranice(pom0, 0);
        inic.riesenie.get(0).get(5).value = 1;
        inic.riesenie.get(0).get(19).value = 1;
        
        int[][] pom10 = {{0,3},{4,11},{10,19}};   
        rule.run(0,inic);
        assertTrue(Arrays.deepEquals(pom10,inic.pole_hodnot[0]));
    }

    @Test
    public void test1() throws Chyba {
        int[][] pom1 = {{1, 8}, {6, 12}, {11, 16}, {17, 19}};
        inic.set_hranice(pom1, 1);
        inic.riesenie.get(1).get(7).value = 1;
        inic.riesenie.get(1).get(8).value = 1;
        inic.riesenie.get(1).get(9).value = 1;
        inic.riesenie.get(1).get(15).value = 1;
        inic.riesenie.get(1).get(16).value = 1;
        inic.riesenie.get(1).get(17).value = 1;

        int[][] pom11 = {{1,5},{6,12},{11,13},{19,19}};
        rule.run(1,inic);
        assertTrue(Arrays.deepEquals(pom11,inic.pole_hodnot[1]));
    }
    
    @Test
    public void test2() throws Chyba {
        int[][] pom2 = {{0, 0}, {3, 7}, {7, 11}, {11, 16}};
        inic.set_hranice(pom2, 2);
        inic.riesenie.get(2).get(0).value = 1;
        inic.riesenie.get(2).get(5).value = 1;
        inic.riesenie.get(2).get(6).value = 1;
        inic.riesenie.get(2).get(12).value = 1;
        inic.riesenie.get(2).get(17).value = 0;
        inic.riesenie.get(2).get(18).value = 0;
        inic.riesenie.get(2).get(19).value = 0;

        int[][] pom12 = {{0,0},{3,7},{8,10},{11,16}};
        rule.run(2,inic);
        assertTrue(Arrays.deepEquals(pom12,inic.pole_hodnot[2]));
    }
    
     @Test
    public void test3() throws Chyba {
        int[][] pom3 = {{0, 3}, {3, 15}};
        inic.set_hranice(pom3, 3);
        inic.riesenie.get(3).get(4).value = 1;
        inic.riesenie.get(3).get(16).value = 1;
        inic.riesenie.get(3).get(17).value = 0;
        inic.riesenie.get(3).get(18).value = 0;
        inic.riesenie.get(3).get(19).value = 0;

        int[][] pom13 = {{0,2},{3,15}};
        rule.run(3,inic);
        assertTrue(Arrays.deepEquals(pom13,inic.pole_hodnot[3]));
    }
    
    @Test
    public void test4() throws Chyba {       
        int[][] pom4 = {{8, 12}};
        inic.set_hranice(pom4, 4);
        inic.riesenie.get(4).get(7).value = 1;
    
        int[][] pom14 = {{8,12}};
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
    
    
}
