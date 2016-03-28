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
import javaapplication1.Porucha;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author krista
 */
public class Rules3Test {
    
    public Inicializacia inic;
    public Logical_rules rules;
    

    @Before
    public void setUp() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();

        list.add(new ArrayList(Arrays.asList(5,7,4)));
        list.add(new ArrayList(Arrays.asList(4,1,5,2)));
        list.add(new ArrayList(Arrays.asList(3,7,3)));
        list.add(new ArrayList(Arrays.asList(1,20,1)));
        list.add(new ArrayList(Arrays.asList(3,2,3,3,1)));
        
        list.add(new ArrayList(Arrays.asList(5,3,4)));//3.1       
        list.add(new ArrayList(Arrays.asList(4, 3, 1)));
        list.add(new ArrayList(Arrays.asList(3,3,4)));
        list.add(new ArrayList(Arrays.asList(4,4,2)));//3.2
        list.add(new ArrayList(Arrays.asList(6, 3, 2)));
        
        list.add(new ArrayList(Arrays.asList(3, 4, 5)));
        list.add(new ArrayList(Arrays.asList(4, 1, 3)));       
        list.add(new ArrayList(Arrays.asList(5,4))); //1.5
        
        list.add(new ArrayList(Arrays.asList(10)));
        list.add(new ArrayList(Arrays.asList(10)));
        list.add(new ArrayList(Arrays.asList(5,7)));
        list.add(new ArrayList(Arrays.asList(8)));
        list.add(new ArrayList(Arrays.asList(8)));
        list.add(new ArrayList(Arrays.asList(8)));
        list.add(new ArrayList(Arrays.asList(1,3,5,4)));
        list.add(new ArrayList(Arrays.asList(1,3,3,3)));
       

        this.inic = new Inicializacia(list, 25);

        this.rules = new Logical_rules(inic);
        
        int[][] pom0 = {{0, 9}, {8, 18}, {18, 24}};
        inic.set_hranice(pom0, 0);
        inic.riesenie.get(0).get(12).value = 1;
          inic.riesenie.get(0).get(13).value = 1;
            inic.riesenie.get(0).get(15).value = 1;
        
        int[][] pom1 = {{0,9}, {10,13},{12,19}, {19,24}};
        inic.set_hranice(pom1, 1);
          inic.riesenie.get(1).get(4).value = 1;
          inic.riesenie.get(1).get(6).value = 1;
          inic.riesenie.get(1).get(14).value = 1;
          inic.riesenie.get(1).get(18).value = 1;
          
          int[][] pom2 = {{0,9}, {8,17}, {17,24}};
        inic.set_hranice(pom2, 2);
          inic.riesenie.get(2).get(8).value = 1;
          inic.riesenie.get(2).get(9).value = 1;
          inic.riesenie.get(2).get(11).value = 1;
          inic.riesenie.get(2).get(13).value = 1;
          inic.riesenie.get(2).get(20).value = 1;
          inic.riesenie.get(2).get(21).value = 1;
          
           int[][] pom3 = {{0,6},{2,22},{22,24}};
        inic.set_hranice(pom3, 3);
          inic.riesenie.get(3).get(8).value = 1;
          inic.riesenie.get(3).get(9).value = 1;
          inic.riesenie.get(3).get(15).value = 1;
          inic.riesenie.get(3).get(20).value = 1;
          inic.riesenie.get(3).get(21).value = 1;
          
            
          int[][] pom4 = {{1,11}, {7,13}, {12,19},{16,22},{20,24}};
        inic.set_hranice(pom4, 4);
          inic.riesenie.get(4).get(0).value = 0;
          inic.riesenie.get(4).get(4).value = 1;
          inic.riesenie.get(4).get(10).value = 1;
          inic.riesenie.get(4).get(17).value = 1;
          inic.riesenie.get(4).get(19).value = 1;
          
            
          int[][] pom5 = {{0,19}, {7,14}, {13,24}};
        inic.set_hranice(pom5, 5);
          inic.riesenie.get(5).get(9).value = 1;
          inic.riesenie.get(5).get(11).value = 1;
          
            int[][] pom6 = {{0,15}, {8,23},{19,24}}; 
            int[][] pom7 = {{0,8}, {4,21}, {15,24}};
            int[][] pom8 = {{0,8}, {5,21},{20,24}};
          
        inic.set_hranice(pom6, 6);
          inic.riesenie.get(6).get(9).value = 0;
          inic.riesenie.get(6).get(11).value = 0;
          inic.riesenie.get(6).get(12).value = 0;
          inic.riesenie.get(6).get(15).value = 1;
          inic.riesenie.get(6).get(16).value = 0;
          inic.riesenie.get(6).get(18).value = 0;
          inic.riesenie.get(6).get(20).value = 1;
          inic.riesenie.get(6).get(22).value = 0;
           
        inic.set_hranice(pom7, 7);
          inic.riesenie.get(7).get(4).value = 0;
          inic.riesenie.get(7).get(6).value = 0;
          inic.riesenie.get(7).get(8).value = 1;
          inic.riesenie.get(7).get(9).value = 1;
          inic.riesenie.get(7).get(12).value = 0;
          inic.riesenie.get(7).get(16).value = 0;
          inic.riesenie.get(7).get(19).value = 1;
          inic.riesenie.get(7).get(21).value = 0;
           
        inic.set_hranice(pom8, 8);
          inic.riesenie.get(8).get(5).value = 0;
          inic.riesenie.get(8).get(10).value = 0;
          inic.riesenie.get(8).get(12).value = 0;
          inic.riesenie.get(8).get(14).value = 1;
          inic.riesenie.get(8).get(15).value = 1;
          inic.riesenie.get(8).get(18).value = 0;
          inic.riesenie.get(8).get(21).value = 0;
          
    }
    
    
         @Test
  public void medzivypln() throws Porucha{
     ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
     
      int[] pom0 = {3,3,3,3,3, 3,3,3,3,3, 3,3,1,1,1, 1,3,3,3,3, 3,3,3,3,3};
      int[] pom1 = {3,3,3,3,1, 3,1,3,3,3, 3,3,3,3,1, 1,1,1,1,3, 3,3,3,3,3};
      int[] pom2 = {3,3,3,3,3, 3,3,3,1,1, 3,1,1,1,3, 3,3,3,3,3, 1,1,3,3,3}; 
      int[] pom3 = {3,3,3,3,3, 3,3,3,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,3,3,3};
      int[] pom4 = {0,3,3,3,1, 3,3,3,3,3, 1,3,3,3,3, 3,3,1,3,1, 3,3,3,3,3};
      int[] pom5 = {3,3,3,3,3, 3,3,3,3,1, 3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      
        moje_riesenie.add(new ArrayList(MyInt.asList(pom0)));
          moje_riesenie.add(new ArrayList(MyInt.asList(pom1)));
            moje_riesenie.add(new ArrayList(MyInt.asList(pom2)));
              moje_riesenie.add(new ArrayList(MyInt.asList(pom3)));
                moje_riesenie.add(new ArrayList(MyInt.asList(pom4)));
                  moje_riesenie.add(new ArrayList(MyInt.asList(pom5)));
                
      
      for (int i = 0; i<6; i++){
          rules.medzivypln(i);
          assertTrue(moje_riesenie.get(i).equals(inic.riesenie.get(i)));
      }
//      assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));
//       assertTrue(moje_riesenie.get(1).equals(inic.riesenie.get(1)));
//        assertTrue(moje_riesenie.get(2).equals(inic.riesenie.get(2)));
//         assertTrue(moje_riesenie.get(3).equals(inic.riesenie.get(3)));
//          assertTrue(moje_riesenie.get(4).equals(inic.riesenie.get(4)));
//           assertTrue(moje_riesenie.get(5).equals(inic.riesenie.get(5)));
         
    int[][] a = {{0,9}, {9,18}, {18,24}};
    int[][] b = {{0,9}, {10,13},{14,18}, {19,24}};
    int[][] c = {{0,9}, {8,17}, {17,24}};
    int[][] d = {{0,6}, {2,22}, {22,24}};
    int[][] e = {{1,11}, {7,13},{12,19},{16,22},{20,24}};
    int[][] f = {{0,19}, {7,14}, {13,24}}; 
    
//       System.out.print(Arrays.toString(inic.pole_hodnot[2][0]));
//     System.out.print(Arrays.toString(inic.pole_hodnot[2][1]));
//     System.out.print(Arrays.toString(inic.pole_hodnot[2][2]));
     
    
     assertTrue(Arrays.deepEquals(a,inic.pole_hodnot[0]));
      assertTrue(Arrays.deepEquals(b,inic.pole_hodnot[1]));
       assertTrue(Arrays.deepEquals(c,inic.pole_hodnot[2]));
        assertTrue(Arrays.deepEquals(d,inic.pole_hodnot[3]));
         assertTrue(Arrays.deepEquals(e,inic.pole_hodnot[4]));
          assertTrue(Arrays.deepEquals(f,inic.pole_hodnot[5]));
          
  }
    @Test
  public void vynutenie() throws Porucha{
     ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
//     
//      int[] pom0 = {3,3,3,3,3, 3,3,3,3,3, 3,3,1,1,1, 1,3,3,3,3, 3,3,3,3,3};
//      int[] pom1 = {3,3,3,3,1, 3,1,3,3,3, 3,3,3,3,1, 1,1,1,1,3, 3,3,3,3,3};
//      int[] pom2 = {3,3,3,3,3, 3,3,3,1,1, 3,1,1,1,3, 3,3,3,3,3, 1,1,3,3,3}; 
//      int[] pom3 = {3,3,3,3,3, 3,3,3,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,3,3,3};
//      int[] pom4 = {0,3,3,3,1, 3,3,3,3,3, 1,3,3,3,3, 3,3,1,3,1, 3,3,3,3,3};
//      int[] pom5 = {3,3,3,3,3, 3,3,3,3,1, 3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
//      
//        moje_riesenie.add(new ArrayList(MyInt.asList(pom0)));
//          moje_riesenie.add(new ArrayList(MyInt.asList(pom1)));
//            moje_riesenie.add(new ArrayList(MyInt.asList(pom2)));
//              moje_riesenie.add(new ArrayList(MyInt.asList(pom3)));
//                moje_riesenie.add(new ArrayList(MyInt.asList(pom4)));
//                  moje_riesenie.add(new ArrayList(MyInt.asList(pom5)));
                
//      
      for (int i = 6; i< 9; i++){
          rules.okliestenie(i);
          //assertTrue(moje_riesenie.get(i).equals(inic.riesenie.get(i)));
      }
//      assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));
//       assertTrue(moje_riesenie.get(1).equals(inic.riesenie.get(1)));
//        assertTrue(moje_riesenie.get(2).equals(inic.riesenie.get(2)));
//         assertTrue(moje_riesenie.get(3).equals(inic.riesenie.get(3)));
//          assertTrue(moje_riesenie.get(4).equals(inic.riesenie.get(4)));
//           assertTrue(moje_riesenie.get(5).equals(inic.riesenie.get(5)));
         
 
            int[][] pom6 = {{0,8}, {13,21},{19,24}}; 
            int[][] pom7 = {{0,3}, {7,20}, {17,20}};
            int[][] pom8 = {{0,4}, {6,17},{22,24}};
   
     assertTrue(Arrays.deepEquals(pom6,inic.pole_hodnot[6]));
      assertTrue(Arrays.deepEquals(pom7,inic.pole_hodnot[7]));
       assertTrue(Arrays.deepEquals(pom8,inic.pole_hodnot[8]));
//        assertTrue(Arrays.deepEquals(d,inic.pole_hodnot[3]));
//         assertTrue(Arrays.deepEquals(e,inic.pole_hodnot[4]));
//          assertTrue(Arrays.deepEquals(f,inic.pole_hodnot[5]));
//          
  }
  
}
