/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import javaapplication1.Inicializacia;
import javaapplication1.Logical_rules;
import javaapplication1.MyInt;
import javaapplication1.Porucha;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author krista
 */
public class Rule3_3Test {
    
  public Inicializacia inic;
    public Logical_rules rules;
    

    @Before
    public void setUp() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();

        list.add(new ArrayList(Arrays.asList(1,5,3)));
        list.add(new ArrayList(Arrays.asList(3,3,3)));
        list.add(new ArrayList(Arrays.asList(2,4,3)));
        
        list.add(new ArrayList(Arrays.asList(1,2,2)));
        list.add(new ArrayList(Arrays.asList(2,2)));
        list.add(new ArrayList(Arrays.asList(3,2)));
        
        list.add(new ArrayList(Arrays.asList(4,3,1)));
        list.add(new ArrayList(Arrays.asList(7,2)));
        list.add(new ArrayList(Arrays.asList(4,3)));
       

        this.inic = new Inicializacia(list, 25);

        this.rules = new Logical_rules(inic);
        
        int[][] pom0 = {{0, 4}, {7,15}, {9,19}};
        inic.set_hranice(pom0, 0);
        inic.riesenie.get(0).get(0).value = 1;
        inic.riesenie.get(0).get(7).value = 1;
          inic.riesenie.get(0).get(8).value = 1;
            inic.riesenie.get(0).get(9).value = 1;
        
        int[][] pom1 = {{0,4}, {5,10},{11,17}};
        inic.set_hranice(pom1, 1);
          inic.riesenie.get(1).get(5).value = 1;
          
          int[][] pom2 = {{2,7}, {10,16},{20,24}};
        inic.set_hranice(pom2, 2);
          inic.riesenie.get(2).get(2).value = 0;
          inic.riesenie.get(2).get(3).value = 1;
          inic.riesenie.get(2).get(10).value = 1;
          inic.riesenie.get(2).get(20).value = 1;
          
             int[][] pom3 = {{0,7}, {9,14},{16,23}};
        inic.set_hranice(pom3, 3);
          inic.riesenie.get(3).get(2).value = 1;
          inic.riesenie.get(3).get(3).value = 0;
          inic.riesenie.get(3).get(9).value = 1;
          inic.riesenie.get(3).get(14).value = 0;
          inic.riesenie.get(3).get(16).value = 1;
          
             int[][] pom4 = {{2,15}, {15,24}};
        inic.set_hranice(pom4, 4);
          inic.riesenie.get(4).get(5).value = 0;
          inic.riesenie.get(4).get(7).value = 1;
          inic.riesenie.get(4).get(10).value = 0;
          inic.riesenie.get(4).get(12).value = 0;
          inic.riesenie.get(4).get(17).value = 1;
          inic.riesenie.get(4).get(21).value = 0;
          
             int[][] pom5 = {{6,13},{17,23}};
        inic.set_hranice(pom5, 5);
          inic.riesenie.get(5).get(10).value = 0;
          inic.riesenie.get(5).get(20).value = 1;
          inic.riesenie.get(5).get(22).value = 0;
          
             int[][] pom6 = {{0,7}, {8,14},{15,19}};
        inic.set_hranice(pom6, 6);
          inic.riesenie.get(6).get(1).value = 1;
          inic.riesenie.get(6).get(5).value = 1;
          inic.riesenie.get(6).get(9).value = 1;
          inic.riesenie.get(6).get(11).value = 1;
          inic.riesenie.get(6).get(18).value = 1;
            
                     int[][] pom7 = {{0,20}, {13,24}};
        inic.set_hranice(pom7, 7);
          inic.riesenie.get(7).get(5).value = 1;
          inic.riesenie.get(7).get(8).value = 1;
          inic.riesenie.get(7).get(9).value = 1;
          inic.riesenie.get(7).get(11).value = 1;
          inic.riesenie.get(7).get(15).value = 1;
          
                     int[][] pom8 = {{0,20},{5,24}};
        inic.set_hranice(pom8, 8);
          inic.riesenie.get(8).get(2).value = 1;
          inic.riesenie.get(8).get(3).value = 1;
          inic.riesenie.get(8).get(5).value = 1;
          inic.riesenie.get(8).get(6).value = 1;
          inic.riesenie.get(6).get(18).value = 1;
                          
          
    }
    
    
    @Test
  public void prve() throws Porucha{
     ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
     
      int[] pom0 = {1,0,3,3,3, 3,0,1,1,1, 1,1,0,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom1 = {3,3,3,3,0, 1,1,1,0,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom2 = {3,3,0,1,3, 3,3,3,3,0, 1,1,1,1,0, 3,3,3,3,0, 1,1,1,0,3}; 
  
        moje_riesenie.add(new ArrayList(MyInt.asList(pom0)));
          moje_riesenie.add(new ArrayList(MyInt.asList(pom1)));
            moje_riesenie.add(new ArrayList(MyInt.asList(pom2)));
             
      
      for (int i = 0; i<3; i++){
          rules.nekryjuce(i);
          assertTrue(moje_riesenie.get(i).equals(inic.riesenie.get(i)));
      }
               
    int[][] a = {{0,0}, {7,11}, {9,19}};
    int[][] b = {{0,4}, {5,7}, {11,17}};
    int[][] c = {{2,7}, {10,13}, {20,22}};
    
//       System.out.print(Arrays.toString(inic.pole_hodnot[2][0]));
//     System.out.print(Arrays.toString(inic.pole_hodnot[2][1]));
//     System.out.print(Arrays.toString(inic.pole_hodnot[2][2]));
//     
//    
     assertTrue(Arrays.deepEquals(a,inic.pole_hodnot[0]));
      assertTrue(Arrays.deepEquals(b,inic.pole_hodnot[1]));
       assertTrue(Arrays.deepEquals(c,inic.pole_hodnot[2]));
          
  }
    @Test
  public void prekazka() throws Porucha{
  
     for (int i = 3; i<6; i++){
          rules.nekryjuce(i);          
      }
                
    int[][] a = {{0,2}, {9,10}, {16,17}};
    int[][] b = {{2,9}, {15,20}};
    int[][] c = {{6,13}, {17,21}};
//    
//       System.out.print(Arrays.toString(inic.pole_hodnot[5][0]));
//     System.out.print(Arrays.toString(inic.pole_hodnot[5][1]));
//   //  System.out.print(Arrays.toString(inic.pole_hodnot[3][2]));
//     
    
     assertTrue(Arrays.deepEquals(a,inic.pole_hodnot[3]));
      assertTrue(Arrays.deepEquals(b,inic.pole_hodnot[4]));
       assertTrue(Arrays.deepEquals(c,inic.pole_hodnot[5]));
          
  }
    @Test
  public void rozdel() throws Porucha{
     for (int i = 6; i<9; i++){
          rules.nekryjuce(i);
           }    
     
    int[][] a = {{0,3}, {8,14}, {15,19}};
    int[][] b = {{0,13}, {13,24}};
    int[][] c = {{0,3}, {5,7}};
//    
//       System.out.print(Arrays.toString(inic.pole_hodnot[8][0]));
//     System.out.print(Arrays.toString(inic.pole_hodnot[8][1]));
//    // System.out.print(Arrays.toString(inic.pole_hodnot[6][2]));
//     
    
     assertTrue(Arrays.deepEquals(a,inic.pole_hodnot[6]));
      assertTrue(Arrays.deepEquals(b,inic.pole_hodnot[7]));
       assertTrue(Arrays.deepEquals(c,inic.pole_hodnot[8]));
          
  }
}




