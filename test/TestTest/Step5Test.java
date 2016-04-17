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
public class Step5Test {
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
    public void result0() throws Porucha{
        int[] a ={3,3,1,3,3, 3,1,1,3,3};
        ArrayList<MyInt> pom0 = MyInt.asList(a);
      
      rules.CoToDa(0);
    //  MyInt.jeden_toString(inic.riesenie.get(0));
      assertTrue(inic.riesenie.get(0).equals(pom0));
    
    }
    
       @Test
    public void result1() throws Porucha{
      int[] a ={3,3,3,0,0, 0,3,3,3,3};
      ArrayList<MyInt> pom0 = MyInt.asList(a);
        
      rules.CoToDa(1);
 
      //MyInt.jeden_toString(inic.riesenie.get(1));
      assertTrue(pom0.equals(inic.riesenie.get(1)));
    
    }
    
       @Test
    public void result2() throws Porucha{
      int[] a ={3,1,1,3,0, 0,0,0,0,0};
        ArrayList<MyInt> pom0 = MyInt.asList(a);
      
      rules.CoToDa(2);
     //MyInt.jeden_toString(inic.riesenie.get(2));
      assertTrue(pom0.equals(inic.riesenie.get(2)));
    
    }
    
       @Test
    public void result3() throws Porucha{
      int[] a ={3,1,3,0,1, 1,0,0,0,0};
        ArrayList<MyInt> pom0 = MyInt.asList(a);
      rules.CoToDa(3);
      
    //MyInt.jeden_toString(inic.riesenie.get(3));
      assertTrue(pom0.equals(inic.riesenie.get(3)));
    
    }
    
       @Test
    public void result4() throws Porucha{
     int[] a ={3,3,0,3,1, 1,0,3,3,3};
        ArrayList<MyInt> pom0 = MyInt.asList(a);
      
      rules.CoToDa(4);
      
    // MyInt.jeden_toString(inic.riesenie.get(4));
      assertTrue(pom0.equals(inic.riesenie.get(4)));
    
    }
    
      @Test
    public void result5() throws Porucha{
      int[] a ={1,1,1,1,1, 0,1,1,1,1};
        ArrayList<MyInt> pom0 = MyInt.asList(a);
      rules.CoToDa(5);
      
    // MyInt.jeden_toString(inic.riesenie.get(5));
     assertTrue(pom0.equals(inic.riesenie.get(5)));
    
    }
}
