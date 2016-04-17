/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestTest;

import static TestTest.celaTest.inic;
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
public class UpdateTest {
    
    public Inicializacia inic;
    public Logical_rules rules;
    

    @Before
    public void setUp() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();

        list.add(new ArrayList(Arrays.asList(5, 3, 1, 8)));
        list.add(new ArrayList(Arrays.asList(5, 1, 3)));
        list.add(new ArrayList(Arrays.asList(5, 4, 2)));
        list.add(new ArrayList(Arrays.asList(5, 2, 3)));
        list.add(new ArrayList(Arrays.asList(1, 4, 1, 2)));
        
        list.add(new ArrayList(Arrays.asList(1, 3, 6)));
        list.add(new ArrayList(Arrays.asList(4, 3, 3, 1)));
        list.add(new ArrayList(Arrays.asList(1, 2, 3, 2)));
        list.add(new ArrayList(Arrays.asList(2, 7)));
        list.add(new ArrayList(Arrays.asList(3)));
        
        list.add(new ArrayList(Arrays.asList(3, 2, 1)));
        list.add(new ArrayList(Arrays.asList(2, 1, 1)));
        list.add(new ArrayList(Arrays.asList(1,2,1)));
        list.add(new ArrayList(Arrays.asList(3, 3,2)));
        list.add(new ArrayList(Arrays.asList(1, 2, 1, 2)));
        
        list.add(new ArrayList(Arrays.asList(2)));
        list.add(new ArrayList(Arrays.asList(2, 1, 1, 2)));

        this.inic = new Inicializacia(list, 20);

        this.rules = new Logical_rules(inic);
        
        int[][] pom2 = {{0, 9}, {6, 12}, {16, 18}};
        inic.set_hranice(pom2, 2);
        
        int[][] pom3 = {{0, 9}, {6, 9}, {7, 16}};
        inic.set_hranice(pom3, 3);
        
        int[][] pom4 = {{1,1}, {2, 10}, {7, 8}, {8, 19}};
        inic.set_hranice(pom4, 4);
        
        int[][] pom5 = {{0, 4}, {4, 11}, {10, 19}};
        inic.set_hranice(pom5, 5);
        inic.riesenie.get(5).get(5).value = 1;
        inic.riesenie.get(5).get(19).value = 1;
          
        int[][] pom6 = {{1, 8}, {6, 12}, {11, 16}, {17,19}};
        inic.set_hranice(pom6, 6);
        inic.riesenie.get(6).get(7).value = 1;
         inic.riesenie.get(6).get(8).value = 1;
          inic.riesenie.get(6).get(9).value = 1;
           inic.riesenie.get(6).get(15).value = 1;
            inic.riesenie.get(6).get(16).value = 1;
             inic.riesenie.get(6).get(17).value = 1;
             
        int[][] pom7 = {{0, 0}, {3, 7}, {7, 11}, {11, 16}};
        inic.set_hranice(pom7, 7);
        inic.riesenie.get(7).get(0).value = 1;
         inic.riesenie.get(7).get(5).value = 1;
          inic.riesenie.get(7).get(6).value = 1;
           inic.riesenie.get(7).get(12).value = 1;
            inic.riesenie.get(7).get(17).value = 0;
             inic.riesenie.get(7).get(18).value = 0;              
              inic.riesenie.get(7).get(19).value = 0;
              
        int[][] pom8 = {{0, 3}, {3, 15}};
        inic.set_hranice(pom8, 8);
        inic.riesenie.get(8).get(4).value = 1;
         inic.riesenie.get(8).get(16).value = 1;
          inic.riesenie.get(8).get(17).value = 0;
            inic.riesenie.get(8).get(18).value = 0;              
             inic.riesenie.get(8).get(19).value = 0;
             
             
        int[][] pom9 = {{8, 12}};
        inic.set_hranice(pom9, 9);
        inic.riesenie.get(9).get(7).value = 1;
    
        
        int[][] pom10 = {{0, 7}, {3, 12}, {11, 19}};
        inic.set_hranice(pom10, 10);
        inic.riesenie.get(10).get(3).value = 1;
         inic.riesenie.get(10).get(4).value = 1;
          inic.riesenie.get(10).get(5).value = 1;
          
           inic.riesenie.get(11).get(11).value = 1;              
              inic.riesenie.get(11).get(12).value = 1;                         
   
            inic.riesenie.get(12).get(7).value = 1;
             inic.riesenie.get(12).get(8).value = 1;              
      
         int[][] pom13 = {{0, 9}, {4, 16}, {8, 19}};
        inic.set_hranice(pom13, 13);
             inic.riesenie.get(13).get(10).value = 1;              
              inic.riesenie.get(13).get(11).value = 1;
               inic.riesenie.get(13).get(12).value = 1;
           
        int[][] pom14 = {{1,11}, {2, 12}, {5, 16}, {9, 19}};
        inic.set_hranice(pom14, 14);
        inic.riesenie.get(14).get(1).value = 1;
         inic.riesenie.get(14).get(3).value = 1;
          inic.riesenie.get(14).get(4).value = 1;
           inic.riesenie.get(14).get(11).value = 1;
            inic.riesenie.get(14).get(12).value = 1;
             
         int[][] pom15 = {{0, 8}, {3, 11}, {6, 15}, {10, 18}};
        inic.set_hranice(pom15, 15);    
         inic.riesenie.get(15).get(4).value = 1;
          inic.riesenie.get(15).get(13).value = 1;
          inic.riesenie.get(15).get(15).value = 1;
           inic.riesenie.get(15).get(17).value = 1;
            inic.riesenie.get(15).get(18).value = 1;
            inic.riesenie.get(15).get(19).value = 0;
             
            
            inic.riesenie.get(16).get(9).value = 1;
            inic.riesenie.get(16).get(10).value = 0;
            
    }
    
    
  @Test
  public void Update0(){
    
      int[][] pom0 = {{0,4},{6,8},{10,10},{12,19}};
      int[][] pom1 = {{0,13},{6,15},{8,19}};
      int[][] pom2 = {{0,7},{6,12},{16,18}};
      int[][] pom3 = {{0,6},{6,9},{9,16}};
      int[][] pom4 = {{1,1},{3,6},{8,8},{10,19}};
      int[][] pom16 = {{0,12},{3,14},{5,16},{7,19}};
      
      for (int i = 0; i<5; i++){
          rules.update0(i);
      }
     rules.update0(16);
     
      assertTrue(Arrays.deepEquals(pom0,inic.pole_hodnot[0]));
      assertTrue(Arrays.deepEquals(pom1,inic.pole_hodnot[1]));
      assertTrue(Arrays.deepEquals(pom2,inic.pole_hodnot[2]));
      assertTrue(Arrays.deepEquals(pom3,inic.pole_hodnot[3]));
      assertTrue(Arrays.deepEquals(pom4,inic.pole_hodnot[4]));
     assertTrue(Arrays.deepEquals(pom16,inic.pole_hodnot[16]));
  }
  
  @Test
  public void Update1(){
      int[][] pom5 = {{0,3},{4,11},{10,19}};
      int[][] pom6 = {{1,5},{6,12},{11,13},{19,19}};
      int[][] pom7 = {{0,0},{3,7},{8,10},{11,16}};
      int[][] pom8 = {{0,2},{3,15}};
      int[][] pom9 = {{8,12}};
      int[][] pom16 = {{0,12},{3,14},{5,16},{7,19}};
      
      for (int i = 5; i<10; i++){
          rules.update1(i);
      }
      rules.update1(16);
      
     System.out.print(Arrays.toString(inic.pole_hodnot[16][0]));
     System.out.print(Arrays.toString(inic.pole_hodnot[16][1]));
     System.out.print(Arrays.toString(inic.pole_hodnot[16][2]));
        System.out.print(Arrays.toString(inic.pole_hodnot[16][3]));
//     System.out.print(Arrays.toString(inic.pole_hodnot[14][0]));
//     System.out.print(Arrays.toString(inic.pole_hodnot[14][1]));
//     System.out.print(Arrays.toString(inic.pole_hodnot[14][2]));
////     
      assertTrue(Arrays.deepEquals(pom5,inic.pole_hodnot[5]));
      assertTrue(Arrays.deepEquals(pom6,inic.pole_hodnot[6]));
      assertTrue(Arrays.deepEquals(pom7,inic.pole_hodnot[7]));
      assertTrue(Arrays.deepEquals(pom8,inic.pole_hodnot[8]));
      assertTrue(Arrays.deepEquals(pom9,inic.pole_hodnot[9]));
     assertTrue(Arrays.deepEquals(pom16,inic.pole_hodnot[16]));
  }
  
  @Test
  public void Update2(){
      int[][] pom10 = {{0,7},{7,12},{11,19}};
      int[][] pom11 = {{0,15}, {14,17}, {5,19}};
      int[][] pom12 = {{0,14}, {2,17}, {5,19}};
      int[][] pom13 = {{0,9},{4,16},{14,19}};
      int[][] pom14 = {{1,1},{2,12}, {5,9},{9,19}};
      int[][] pom15 = {{0,8},{3,11},{6,15},{10,18}};
      int[][] pom16 = {{0,12},{3,14},{5,16},{7,19}};
      
      for (int i = 10; i<16; i++){
      rules.update2(i);
      }
  System.out.print(Arrays.toString(inic.pole_hodnot[16][0]));
     System.out.print(Arrays.toString(inic.pole_hodnot[16][1]));
     System.out.print(Arrays.toString(inic.pole_hodnot[16][2]));
   System.out.print(Arrays.toString(inic.pole_hodnot[16][3]));
     
      assertTrue(Arrays.deepEquals(pom10,inic.pole_hodnot[10]));
      assertTrue(Arrays.deepEquals(pom11,inic.pole_hodnot[11]));
      assertTrue(Arrays.deepEquals(pom12,inic.pole_hodnot[12]));
      assertTrue(Arrays.deepEquals(pom13,inic.pole_hodnot[13]));
     assertTrue(Arrays.deepEquals(pom16,inic.pole_hodnot[16]));
      assertTrue(Arrays.deepEquals(pom15,inic.pole_hodnot[15]));
     
  }
}
