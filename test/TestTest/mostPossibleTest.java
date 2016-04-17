package TestTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import javaapplication1.Inicializacia;
import javaapplication1.MostPossible;
import javaapplication1.MyInt;
import javaapplication1.Porucha;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author krista
 */
public class mostPossibleTest {
    public Inicializacia inic;
    public MostPossible rules;
    

   @Before
    public void setUp() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();

        list.add(new ArrayList(Arrays.asList(3,4)));
        list.add(new ArrayList(Arrays.asList(3)));
        list.add(new ArrayList(Arrays.asList(3)));
        
        list.add(new ArrayList(Arrays.asList(2,2)));
        list.add(new ArrayList(Arrays.asList(2,3)));
        list.add(new ArrayList(Arrays.asList(5,4)));

        this.inic = new Inicializacia(list, 10);
        this.rules = new MostPossible(inic);
              
       
          inic.riesenie.get(1).get(3).value = 0;
          inic.riesenie.get(1).get(5).value = 0;
                    
          inic.riesenie.get(2).get(1).value = 1;

          inic.riesenie.get(3).get(1).value = 1;
          inic.riesenie.get(3).get(5).value = 1;
          inic.riesenie.get(3).get(6).value = 0;
             
          inic.riesenie.get(4).get(5).value = 1;
          inic.riesenie.get(4).get(6).value = 0;
            
    }
    
    @Test
    public void prve0() throws Porucha{
      boolean[] pom0 = {true, true,true,true,true,true, true,true,true,true,true};
      boolean[] pom1 = {false, false,false,true,true,true, true,true,true,true,true};
      boolean[] pom2 = {false, false,false,false,false,false, false,false,true,true,true};
      rules.CoToDa(0);
//        System.out.println(Arrays.toString(rules.step_1[1]));
//        System.out.println(Arrays.toString(rules.step_1[2]));
      assertTrue(Arrays.equals(pom0, rules.step_1[0]));
      assertTrue(Arrays.equals(pom1, rules.step_1[1]));
      assertTrue(Arrays.equals(pom2, rules.step_1[2]));
    }
    
     @Test
    public void prve1() throws Porucha{
      boolean[] pom0 = {true, true,true,true,true,true, true,true,true,true,true};
      boolean[] pom1 = {false, false,false,true,true,true, true,true,true,true,true};
       rules.CoToDa(1);
//        System.out.println(Arrays.toString(rules.step_1[0]));
//        System.out.println(Arrays.toString(rules.step_1[1]));
      assertTrue(Arrays.equals(pom0, rules.step_1[0]));
      assertTrue(Arrays.equals(pom1, rules.step_1[1]));
       }

     @Test
    public void prve2() throws Porucha{
      boolean[] pom0 = {true, true,false,false,false,false, false,false,false,false,false};
      boolean[] pom1 = {false, false,false,true,true,true, true,true,true,true,true};
      rules.CoToDa(2);
//        System.out.println(Arrays.toString(rules.step_1[0]));
//        System.out.println(Arrays.toString(rules.step_1[1]));
      assertTrue(Arrays.equals(pom0, rules.step_1[0]));
      assertTrue(Arrays.equals(pom1, rules.step_1[1]));
       }
    
     @Test
    public void prve3() throws Porucha{
      boolean[] pom0 = {true, true,false,false,false,false, false,false,false,false,false};
      boolean[] pom1 = {false, false,true,true,true,true, false,false,false,false,false};
      boolean[] pom2 = {false, false,false,false,false,true, true,true,true,true,true};
      rules.CoToDa(3);
//        System.out.println(Arrays.toString(rules.step_1[1]));
//        System.out.println(Arrays.toString(rules.step_1[2]));
      assertTrue(Arrays.equals(pom0, rules.step_1[0]));
      assertTrue(Arrays.equals(pom1, rules.step_1[1]));
      assertTrue(Arrays.equals(pom2, rules.step_1[2]));
    }
    
     @Test
    public void prve4() throws Porucha{
      boolean[] pom0 = {true, true,true,true,true,true, false,false,false,false,false};
      boolean[] pom1 = {false, false,true,true,true,true, true,true,true,true,true};
      boolean[] pom2 = {false, false,false,false,false,false, true,true,true,true,true};
      rules.CoToDa(4);
//        System.out.println(Arrays.toString(rules.step_1[1]));
//        System.out.println(Arrays.toString(rules.step_1[2]));
      assertTrue(Arrays.equals(pom0, rules.step_1[0]));
      assertTrue(Arrays.equals(pom1, rules.step_1[1]));
      assertTrue(Arrays.equals(pom2, rules.step_1[2]));
    }
    
      @Test
    public void prve5() throws Porucha{
      boolean[] pom0 = {true, true,true,true,true,true, true,true,true,true,true};
      boolean[] pom1 = {false, false,false,false,false,true, true,true,true,true,true};
      boolean[] pom2 = {false, false,false,false,false,false, false,false,false,false,true};
      rules.CoToDa(5);
//        System.out.println(Arrays.toString(rules.step_2[1]));
//        System.out.println(Arrays.toString(rules.step_2[2]));
      assertTrue(Arrays.equals(pom0, rules.step_1[0]));
      assertTrue(Arrays.equals(pom1, rules.step_1[1]));
      assertTrue(Arrays.equals(pom2, rules.step_1[2]));
    }
    
    
}
