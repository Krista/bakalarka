/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krista
 */
public class RulesTest {
    
      ArrayList<ArrayList<Integer>> list;
      ArrayList<Pravidla> pravidla= new ArrayList<>();
    Rules r = new Rules();
    ArrayList<Pravidla> zoznam;
    Inicializacia inic;
    ArrayList<ArrayList<MyInt>> moje_riesenie;
    Rules.Vynutenie rule;

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        
        list.add(new ArrayList(Arrays.asList(3, 2, 1)));
//        list.add(new ArrayList(Arrays.asList(5)));
//        list.add(new ArrayList(Arrays.asList(7, 10)));
//        list.add(new ArrayList(Arrays.asList(6, 3, 2)));
//        
//        list.add(new ArrayList(Arrays.asList(3, 4, 5)));
//        list.add(new ArrayList(Arrays.asList(4, 1, 3)));       
//        list.add(new ArrayList(Arrays.asList(5,4)));
                
        inic = new Inicializacia(list, 20, 1);
        rule = r.new Vynutenie(inic, inic);
        moje_riesenie= new ArrayList<>();
        
        int[] pom = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        pravidla=Vyries.Vytvor_sadu(pom, inic, inic);
   
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() throws Chyba {
        int[][] pom0 = {{0, 4}, {4, 16}, {12, 18}};
        inic.set_hranice(pom0, 0);
        inic.riesenie.get(0).get(2).value = 1;
        inic.riesenie.get(0).get(7).value = 1;
        inic.riesenie.get(0).get(12).value = 1;
        inic.riesenie.get(0).get(6).value = 0;
        inic.riesenie.get(0).get(19).value = 0;
        
        int[] a = {3,3,1,3,3, 0,0,1,1,0, 0,0,1,0,0, 0,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       /* for (Pravidla p: pravidla){
            System.out.println(p.run(0, inic));
        }*/
        System.out.println(pravidla.get(4).run(0, inic));
        System.out.println(Arrays.toString(inic.pole_hodnot[0][2]));
        System.out.println(pravidla.get(8).run(0, inic));
        System.out.println(pravidla.get(1).run(0, inic));
        //rule.run(0,inic);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));
    }
    
}
