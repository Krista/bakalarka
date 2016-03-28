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
public class Rules1Test {
      
    public Inicializacia inic;
    public Logical_rules rules;
    

    @Before
    public void setUp() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();

        list.add(new ArrayList(Arrays.asList(1, 1, 3)));
        list.add(new ArrayList(Arrays.asList(1, 1, 3)));
        list.add(new ArrayList(Arrays.asList(2, 3)));
        list.add(new ArrayList(Arrays.asList(3, 1, 1)));
        list.add(new ArrayList(Arrays.asList(3, 1, 2)));
        
        list.add(new ArrayList(Arrays.asList(1, 4, 4, 1)));//1.3        
        list.add(new ArrayList(Arrays.asList(2, 3, 1)));
        list.add(new ArrayList(Arrays.asList(5)));
        list.add(new ArrayList(Arrays.asList(7, 10)));
        list.add(new ArrayList(Arrays.asList(6, 3, 2)));
        
        list.add(new ArrayList(Arrays.asList(3, 4, 5)));
        list.add(new ArrayList(Arrays.asList(4, 1, 3)));       
        list.add(new ArrayList(Arrays.asList(5,4)));//1.5        
        list.add(new ArrayList(Arrays.asList(10)));
        list.add(new ArrayList(Arrays.asList(10)));
        
        list.add(new ArrayList(Arrays.asList(5,7)));
        list.add(new ArrayList(Arrays.asList(8)));
        list.add(new ArrayList(Arrays.asList(8)));
        list.add(new ArrayList(Arrays.asList(8)));
        list.add(new ArrayList(Arrays.asList(1,3,5,4)));
        
        list.add(new ArrayList(Arrays.asList(1,3,3,3)));
        list.add(new ArrayList(Arrays.asList(5)));

        this.inic = new Inicializacia(list, 25);

        this.rules = new Logical_rules(inic);
        
        int[][] pom0 = {{3, 9}, {7, 13}, {13, 21}};
        inic.set_hranice(pom0, 0);
          inic.riesenie.get(0).get(13).value = 1;
        inic.riesenie.get(0).get(16).value = 1;
        
        int[][] pom1 = {{3, 11}, {7, 13}, {10, 17}};
        inic.set_hranice(pom1, 1);
          inic.riesenie.get(1).get(10).value = 1;
       
        
        int[][] pom2 = {{8,13}, {12, 17}};
        inic.set_hranice(pom2, 2);
         inic.riesenie.get(2).get(12).value = 1;
           inic.riesenie.get(2).get(13).value = 1;     
         
        int[][] pom3 = {{0, 6}, {4, 11}, {6, 13}};
        inic.set_hranice(pom3, 3);
          inic.riesenie.get(3).get(6).value = 1;
        
        int[][] pom4 = {{0, 6}, {4, 11}, {6, 13}};
        inic.set_hranice(pom4, 4);
          inic.riesenie.get(4).get(6).value = 1;
               
        int[][] pom5 = {{3, 10}, {9, 14}, {15, 18}, {13, 24}};
        inic.set_hranice(pom5, 5);
        inic.riesenie.get(5).get(9).value = 1;
        inic.riesenie.get(5).get(15).value = 1;
          
        int[][] pom6 = {{2, 9}, {5, 11}, {9, 15}};
        inic.set_hranice(pom6, 6);
        inic.riesenie.get(6).get(7).value = 1;
         inic.riesenie.get(6).get(8).value = 1;
          inic.riesenie.get(6).get(10).value = 1;
          
            int[][] pom7 = {{0, 24}};
        inic.set_hranice(pom7, 7);
        inic.riesenie.get(7).get(9).value = 1;
         inic.riesenie.get(7).get(10).value = 1;
          inic.riesenie.get(7).get(12).value = 1;
           inic.riesenie.get(7).get(13).value = 1;
          inic.riesenie.get(7).get(14).value = 1;
          
            int[][] pom8 = {{0, 10}, {8, 24}};
        inic.set_hranice(pom8, 8);
        inic.riesenie.get(8).get(0).value = 1;
         inic.riesenie.get(8).get(2).value = 1;
          inic.riesenie.get(8).get(3).value = 1;
           inic.riesenie.get(8).get(4).value = 1;
            inic.riesenie.get(8).get(5).value = 1;
            inic.riesenie.get(8).get(6).value = 1;
         inic.riesenie.get(8).get(16).value = 1;
          inic.riesenie.get(8).get(20).value = 1;
          
          
            int[][] pom9 = {{0, 14}, {7, 21}, {23, 24}};
        inic.set_hranice(pom9, 9);
        inic.riesenie.get(9).get(7).value = 1;
         inic.riesenie.get(9).get(8).value = 1;
          inic.riesenie.get(9).get(10).value = 1;
           inic.riesenie.get(9).get(20).value = 1;
         inic.riesenie.get(9).get(21).value = 1;
          inic.riesenie.get(9).get(23).value = 1;
          inic.riesenie.get(9).get(24).value = 1;
          
            int[][] pom10 = {{0, 13}, {4, 18}, {9, 24}};
        inic.set_hranice(pom10, 10);
        inic.riesenie.get(10).get(11).value = 1;
         inic.riesenie.get(10).get(12).value = 1;
          inic.riesenie.get(10).get(14).value = 1;
          
            int[][] pom11 = {{0, 7}, {5, 14}, {9, 19}};
        inic.set_hranice(pom11, 11);
        inic.riesenie.get(11).get(7).value = 1;
         inic.riesenie.get(11).get(9).value = 1;
         
               int[][] pom12 = {{7, 15}, {11, 19}};
        inic.set_hranice(pom12, 12);
        inic.riesenie.get(12).get(12).value = 1;
         inic.riesenie.get(12).get(13).value = 1;
          inic.riesenie.get(12).get(15).value = 1;
            inic.riesenie.get(12).get(16).value = 1;

            
      int[][] pom13 = {{0,20}};
       inic.set_hranice(pom13, 13);
        inic.riesenie.get(13).get(0).value = 1;
         inic.riesenie.get(13).get(18).value = 0;
          inic.riesenie.get(13).get(19).value = 0;
          
        inic.riesenie.get(14).get(1).value = 1;
         inic.riesenie.get(14).get(5).value = 1;
         
      int[][] pom15 = {{0,14}, {6,19}};
       inic.set_hranice(pom15, 15);
        inic.riesenie.get(15).get(0).value = 1;
         inic.riesenie.get(15).get(6).value = 1;
     
        inic.riesenie.get(16).get(7).value = 1;
        
         inic.riesenie.get(17).get(7).value = 1;
          inic.riesenie.get(17).get(12).value = 0;
          
            inic.riesenie.get(18).get(5).value = 1;
             inic.riesenie.get(18).get(9).value = 0;
             
      int[][] pom19 = {{0,9},{2,13},{5,19},{11,24}};
       inic.set_hranice(pom19, 19);
        inic.riesenie.get(19).get(11).value = 0;
         inic.riesenie.get(19).get(13).value = 1;
          inic.riesenie.get(19).get(15).value = 1;
            inic.riesenie.get(19).get(16).value = 1;
              inic.riesenie.get(19).get(24).value = 1;
              
      int[][] pom20 = {{1,6},{3,17},{6,20},{13,24}};
        inic.set_hranice(pom20, 20);
        inic.riesenie.get(20).get(0).value = 0;
         inic.riesenie.get(20).get(5).value = 1;
          inic.riesenie.get(20).get(6).value = 1;
           inic.riesenie.get(20).get(11).value = 0;
            inic.riesenie.get(20).get(12).value = 0;
            inic.riesenie.get(20).get(13).value = 1;
              inic.riesenie.get(20).get(23).value = 1;
              
               inic.riesenie.get(21).get(11).value = 1;
            inic.riesenie.get(21).get(12).value = 1;
             }
  
  
  @Test
  public void jednotky() throws Porucha{
     ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
     
      int[] pom0 = {3,3,3,3,3, 3,3,3,3,3, 3,3,0,1,3, 3,1,3,3,3, 3,3,3,3,3};
      int[] pom1 = {3,3,3,3,3, 3,3,3,3,0, 1,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom2 = {3,3,3,3,3, 3,3,3,3,3, 3,3,1,1,3, 3,3,3,3,3, 3,3,3,3,3}; //toto by vsak pravidlo malo urcit ako zmenu
      int[] pom3 = {3,3,3,3,3, 3,1,0,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom4 = {3,3,3,3,3, 3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom5 = {3,3,3,3,3, 3,3,3,0,1, 3,3,3,3,0, 1,3,3,3,3, 3,3,3,3,3};
      
        moje_riesenie.add(new ArrayList(MyInt.asList(pom0)));
          moje_riesenie.add(new ArrayList(MyInt.asList(pom1)));
            moje_riesenie.add(new ArrayList(MyInt.asList(pom2)));
              moje_riesenie.add(new ArrayList(MyInt.asList(pom3)));
                moje_riesenie.add(new ArrayList(MyInt.asList(pom4)));
                  moje_riesenie.add(new ArrayList(MyInt.asList(pom5)));
                
      
      for (int i = 0; i<6; i++){
          rules.jednotky(i);
          //assertTrue(moje_riesenie.get(i).equals(inic.riesenie.get(i)));
      }
      assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));
       assertTrue(moje_riesenie.get(1).equals(inic.riesenie.get(1)));
        assertTrue(moje_riesenie.get(2).equals(inic.riesenie.get(2)));
         assertTrue(moje_riesenie.get(3).equals(inic.riesenie.get(3)));
          assertTrue(moje_riesenie.get(4).equals(inic.riesenie.get(4)));
           assertTrue(moje_riesenie.get(5).equals(inic.riesenie.get(5)));
         
    
    
  }
  
  
   @Test
  public void vynutenie() throws Porucha{
     ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
     
      int[] pom0 = {3,3,3,3,3, 3,3,1,1,0, 1,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom1 = {3,3,3,3,3, 3,3,3,3,1, 1,0,1,1,1, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom2 = {1,3,1,1,1, 1,1,3,3,3, 3,3,3,3,3, 3,1,3,3,3, 1,3,3,3,3}; 
      int[] pom3 = {3,3,3,3,3, 3,3,1,1,3, 1,3,3,3,3, 3,3,3,3,3, 1,1,0,1,1};
      int[] pom4 = {3,3,3,3,3, 3,3,3,3,3, 3,1,1,3,1, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom5 = {3,3,3,3,3, 3,3,1,0,1, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom6 = {3,3,3,3,3, 3,3,3,3,3, 3,3,1,1,0, 1,1,3,3,3, 3,3,3,3,3};

      
        moje_riesenie.add(new ArrayList(MyInt.asList(pom0)));
          moje_riesenie.add(new ArrayList(MyInt.asList(pom1)));
            moje_riesenie.add(new ArrayList(MyInt.asList(pom2)));
              moje_riesenie.add(new ArrayList(MyInt.asList(pom3)));
                moje_riesenie.add(new ArrayList(MyInt.asList(pom4)));
                  moje_riesenie.add(new ArrayList(MyInt.asList(pom5)));
                   moje_riesenie.add(new ArrayList(MyInt.asList(pom6)));
                
      
      for (int i = 6; i<13; i++){
          rules.vynutenie(i);
          //assertTrue(moje_riesenie.get(i-6).equals(inic.riesenie.get(i)));
      }
      MyInt.jeden_toString(inic.riesenie.get(6));
      assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(6)));
       assertTrue(moje_riesenie.get(1).equals(inic.riesenie.get(7)));
        assertTrue(moje_riesenie.get(2).equals(inic.riesenie.get(8)));
         assertTrue(moje_riesenie.get(3).equals(inic.riesenie.get(9)));
          assertTrue(moje_riesenie.get(4).equals(inic.riesenie.get(10)));
           assertTrue(moje_riesenie.get(5).equals(inic.riesenie.get(11)));
           assertTrue(moje_riesenie.get(6).equals(inic.riesenie.get(12)));
         
    
    
  }
  @Test
  public void lepidlo() throws Porucha{
     ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
     
      int[] pom0 = {1,1,1,1,1, 1,1,1,1,1, 0,3,3,3,3, 3,3,3,0,0, 3,3,3,3,3};
      int[] pom1 = {3,1,1,1,1, 1,1,1,1,1, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom2 = {1,1,1,1,1, 0,1,1,1,1, 1,1,1,0,3, 3,3,3,3,3, 3,3,3,3,3}; 
      int[] pom3 = {3,3,3,3,3, 3,3,1,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom4 = {3,3,3,3,1, 1,1,1,3,3, 3,3,0,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom5 = {3,1,1,1,1, 1,1,1,3,0, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom6 = {3,3,3,3,3, 3,3,3,3,3, 3,0,3,1,1, 1,1,3,3,3, 0,1,1,1,1};
      int[] pom7 = {0,3,3,3,3, 1,1,3,3,3, 3,0,0,1,1, 1,0,3,3,3, 3,3,1,1,3};
      int[] pom8 = {3,3,3,3,3, 3,3,3,3,3, 3,1,1,3,3, 3,3,3,3,3, 3,3,3,3,3};
      
      int[][] pom10 = {{0,9}};
      int[][] pom11 = {{0,24}};
      int[][] pom12 = {{0,4},{6,12}};
      int[][] pom13 = {{0,24}};
      int[][] pom14 = {{0,24}};
      int[][] pom15 = {{0,24}};
      int[][] pom16 = {{0,9},{2,13},{5,19},{21,24}};
      int[][] pom17 = {{1,6},{3,17},{6,20},{13,24}};
      int[][] pom18 = {{8,15}};//na to lepidlo nesaha
      
        moje_riesenie.add(new ArrayList(MyInt.asList(pom0)));
          moje_riesenie.add(new ArrayList(MyInt.asList(pom1)));
            moje_riesenie.add(new ArrayList(MyInt.asList(pom2)));
              moje_riesenie.add(new ArrayList(MyInt.asList(pom3)));
                moje_riesenie.add(new ArrayList(MyInt.asList(pom4)));
                  moje_riesenie.add(new ArrayList(MyInt.asList(pom5)));
                   moje_riesenie.add(new ArrayList(MyInt.asList(pom6)));
                    moje_riesenie.add(new ArrayList(MyInt.asList(pom7)));
                     moje_riesenie.add(new ArrayList(MyInt.asList(pom8)));
      
      for (int i = 13; i<22; i++){
          rules.lepidlo(i);
          //assertTrue(moje_riesenie.get(i-6).equals(inic.riesenie.get(i)));
      }
     
      MyInt.jeden_toString(inic.riesenie.get(21));
      System.out.print(Arrays.toString(inic.pole_hodnot[21][0]));
      
      assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(13)));
       assertTrue(moje_riesenie.get(1).equals(inic.riesenie.get(14)));
        assertTrue(moje_riesenie.get(2).equals(inic.riesenie.get(15)));
         assertTrue(moje_riesenie.get(3).equals(inic.riesenie.get(16)));
          assertTrue(moje_riesenie.get(4).equals(inic.riesenie.get(17)));
           assertTrue(moje_riesenie.get(5).equals(inic.riesenie.get(18)));
           assertTrue(moje_riesenie.get(6).equals(inic.riesenie.get(19)));
             assertTrue(moje_riesenie.get(7).equals(inic.riesenie.get(20)));
          assertTrue(moje_riesenie.get(8).equals(inic.riesenie.get(21)));
          
     assertTrue(Arrays.deepEquals(pom10,inic.pole_hodnot[13]));
      assertTrue(Arrays.deepEquals(pom11,inic.pole_hodnot[14]));
      assertTrue(Arrays.deepEquals(pom12,inic.pole_hodnot[15]));
      assertTrue(Arrays.deepEquals(pom13,inic.pole_hodnot[16]));
     assertTrue(Arrays.deepEquals(pom14,inic.pole_hodnot[17]));
      assertTrue(Arrays.deepEquals(pom15,inic.pole_hodnot[18]));
     assertTrue(Arrays.deepEquals(pom16,inic.pole_hodnot[19]));
         assertTrue(Arrays.deepEquals(pom17,inic.pole_hodnot[20]));
          assertTrue(Arrays.deepEquals(pom18,inic.pole_hodnot[21]));//tu by som chcela aby skracovalintervali ak je nieco uz vyfarbene
  }
  
  
  @Test
  public void jed_medzery() throws Porucha{
       ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
     
      int[] pom0 = {0,0,0,3,3, 3,3,3,3,3, 3,3,0,1,3, 3,1,3,3,3, 3,3,0,0,0};
      int[] pom1 = {0,0,0,3,3, 3,3,3,3,0, 1,3,3,3,3, 3,3,3,0,0, 0,0,0,0,0};
      int[] pom2 = {3,3,3,3,3, 3,3,3,3,3, 3,3,1,1,3, 3,3,3,3,3, 3,3,3,3,3}; //toto by vsak pravidlo malo urcit ako zmenu
      int[] pom3 = {3,3,3,3,3, 3,1,0,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom4 = {3,3,3,3,3, 3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] pom5 = {3,3,3,3,3, 3,3,3,0,1, 3,3,3,3,0, 1,3,3,3,3, 3,3,3,3,3};
      
        moje_riesenie.add(new ArrayList(MyInt.asList(pom0)));
          moje_riesenie.add(new ArrayList(MyInt.asList(pom1)));
            moje_riesenie.add(new ArrayList(MyInt.asList(pom2)));
              moje_riesenie.add(new ArrayList(MyInt.asList(pom3)));
                moje_riesenie.add(new ArrayList(MyInt.asList(pom4)));
                  moje_riesenie.add(new ArrayList(MyInt.asList(pom5)));
                  
                  for (int i=0; i<6; i++){
                      rules.jed_medzery(i);
                  }
  }
  
}
