/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestTest;

import java.util.ArrayList;
import java.util.Arrays;
import javaapplication1.Inicializacia;
import javaapplication1.Logical_rules;
import javaapplication1.MyInt;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author krista
 */
public class VynutenieTest {
    
    
    public Inicializacia inic;
    Logical_rules rules;
    

    @Before
    public void setUp() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
       // ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();

        list.add(new ArrayList(Arrays.asList(3, 3, 1, 9)));
        list.add(new ArrayList(Arrays.asList(3, 3, 1)));
        list.add(new ArrayList(Arrays.asList(1,7,8,1)));
         list.add(new ArrayList(Arrays.asList(2,3,4)));
        this.inic = new Inicializacia(list, 25);
        

        this.rules = new Logical_rules(inic);
        
        //int[][] pom2 = {{0, 5}, {7, 14}, {12, 17}, {21, 23}};
        //inic.set_hranice(pom2, 2);
        inic.riesenie.get(0).get(6).value = 1;
        inic.riesenie.get(0).get(4).value = 1;
        inic.riesenie.get(0).get(3).value = 1;
        
         inic.riesenie.get(1).get(21).value = 1;
        inic.riesenie.get(1).get(22).value = 1;
        inic.riesenie.get(1).get(24).value = 1;
        
        inic.riesenie.get(2).get(23).value = 1;
        inic.riesenie.get(2).get(2).value = 1;
        inic.riesenie.get(2).get(0).value = 1;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void hello() {
          ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
          
         int[] a = {3,3,3,1,1, 0,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rules.vynutenie(0);
        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));
     }
     
      @Test
     public void hello2() {
          ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
          
         int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,1,1,0,1};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        rules.vynutenie(1);
       assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(1)));
       
          
         int[] b = {1,0,1,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(b)));
        rules.vynutenie(2);
       assertTrue(moje_riesenie.get(1).equals(inic.riesenie.get(2)));
       
     }
     
     
     
}
