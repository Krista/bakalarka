/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javaapplication1.Inicializacia;
import javaapplication1.Logical_rules;
import javaapplication1.MyInt;
import javaapplication1.Porucha;
import javaapplication1.Read_nono;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author krista
 */
public class celaTest {
    static Inicializacia inic;
    static Inicializacia inic2;
    static Logical_rules p;
    static Logical_rules r;
    static ArrayList<ArrayList<MyInt>> moje_R;
    static ArrayList<ArrayList<MyInt>> moje_S;
    
 @BeforeClass
    public static void oneTimeSetUp() throws IOException {
        Read_nono krizovka = new Read_nono(353);        
        inic = krizovka.zrob_stlpce();
        //inic.riesenie.get(0).get(2).value = 1;
        
        //System.out.println(inic.p_stlpcov);
        inic2 = krizovka.zrob_riadky(inic.riesenie);
         p = new Logical_rules(inic);
         r = new Logical_rules(inic2);
         
         int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
      int[] b = {3,3,3,3,3, 3,3,3,3,3};
         moje_R = new ArrayList<>();
         for (int i=0; i < inic.p_stlpcov; i++){
             moje_R.add(new ArrayList(MyInt.asList(a)));
              }
         
         moje_S = new ArrayList<>();
         for (int i=0; i<inic2.p_stlpcov; i++){
             moje_S.add(new ArrayList(MyInt.asList(b))) ;
         }
         }
        
        @Test
        public void prvy_prienik() throws Porucha{
           
            
            int[] a = {3,3,3,3,3, 3,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,3,3,3,3};
            moje_R.set(1, MyInt.asList(a));
           int[] b = {3,3,3,3,3, 3,3,3,3,3, 1,1,1,3,3, 3,3,3,3,3, 3,3,3,3,3};
            moje_R.set(4, MyInt.asList(b));
            moje_R.get(5).get(11).value = 1;
            int[] c = {3,3,3,1,1, 1,1,3,3,3};
            moje_S.set(13, MyInt.asList(c));
             int[] d = {3,3,3,1,1, 1,1,1,1,3};
            moje_S.set(14, MyInt.asList(d));
             int[] e = {3,1,1,1,3, 3,1,1,1,3};
            moje_S.set(15, MyInt.asList(e));
            
            for (int i= 0; i<inic2.pole_hodnot.length; i++){
                r.prienik(i);
//                MyInt.jeden_toString(inic2.riesenie.get(0));
//                System.out.println("");
//                MyInt.jeden_toString(moje_R.get(0));
                 assertTrue(moje_R.get(0).equals(inic2.riesenie.get(0)));
            }
            for (int i= 0; i<inic.pole_hodnot.length; i++){
                p.prienik(i);
                assertTrue(moje_S.get(0).equals(inic.riesenie.get(0)));
            }
//        p.update1(10);
//        System.out.print(Arrays.toString(inic.pole_hodnot[10][1]));
//        System.out.print(Arrays.toString(inic.pole_hodnot[10][2]));
//            System.out.println("");
//            System.out.println("");
        
}
        
        @Test
        public void PrecoPadas(){
            int[] a = {3,1,3,3,1, 3,3,3,3,3};
           
            moje_S.set(10, MyInt.asList(a));
            int[][] pom10 = {{0, 4}, {2, 7}, {5, 9}};
          assertTrue(moje_S.get(0).equals(inic.riesenie.get(10)));
           
          inic.riesenie.set(10, MyInt.asList(a));
            p.update1(10);
            int[][] pom11 = {{0, 4}, {3, 7}, {6, 9}};           
            assertTrue(Arrays.deepEquals(pom11,inic.pole_hodnot[10]));

        }
}