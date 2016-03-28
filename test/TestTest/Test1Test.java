package TestTest;

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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krista
 */
public class Test1Test {

    public Inicializacia inic;
    Logical_rules rules;
    

    @Before
    public void setUp() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();

        list.add(new ArrayList(Arrays.asList(5, 3, 1, 9)));
        list.add(new ArrayList(Arrays.asList(4, 4, 4, 4, 5)));
        list.add(new ArrayList(Arrays.asList(3, 3, 3, 1)));
        list.add(new ArrayList(Arrays.asList(5, 5)));
        list.add(new ArrayList(Arrays.asList(6, 4)));
        list.add(new ArrayList(Arrays.asList(8, 16)));
        list.add(new ArrayList(Arrays.asList(8, 6)));
        list.add(new ArrayList(Arrays.asList(9, 5)));
        list.add(new ArrayList(Arrays.asList(10, 5)));
        list.add(new ArrayList(Arrays.asList(3, 3, 1, 5, 3)));
        list.add(new ArrayList(Arrays.asList(3, 3, 1, 5, 3)));
        list.add(new ArrayList(Arrays.asList(1, 1, 3, 5, 1)));
        list.add(new ArrayList(Arrays.asList(1, 1, 2, 2, 5, 1, 3)));
        list.add(new ArrayList(Arrays.asList(5, 2)));
        list.add(new ArrayList(Arrays.asList(2, 1)));
       

        this.inic = new Inicializacia(list, 25);

        this.rules = new Logical_rules(inic);
        
        int[][] pom2 = {{0, 5}, {7, 14}, {12, 17}, {21, 23}};
        inic.set_hranice(pom2, 2);
        inic.riesenie.get(2).get(6).value = 0;
        inic.riesenie.get(2).get(24).value = 0;
        
        int[][] pom3 = {{2, 8}, {15, 19}};
        inic.set_hranice(pom3, 3);
        inic.riesenie.get(3).get(5).value = 1;
        inic.riesenie.get(3).get(16).value = 1;
        inic.riesenie.get(3).get(17).value = 1;
        
        int[][] pom4 = {{3, 8}, {11, 13}};
        inic.set_hranice(pom4, 4);
         
        int[][] pom6 = {{0, 11}, {10, 20}};
        inic.set_hranice(pom6, 6);
        inic.riesenie.get(6).get(4).value = 1;
        inic.riesenie.get(6).get(5).value = 1;
        inic.riesenie.get(6).get(6).value = 1;
        inic.riesenie.get(6).get(7).value = 1;
        inic.riesenie.get(6).get(16).value = 1;
        inic.riesenie.get(6).get(15).value = 1;
        inic.riesenie.get(6).get(21).value = 0;
        inic.riesenie.get(6).get(22).value = 0;
        inic.riesenie.get(6).get(23).value = 0;
        inic.riesenie.get(6).get(24).value = 0;
        
        int[][] pom7 = {{3, 14}, {17, 22}};
        inic.set_hranice(pom7, 7);
        inic.riesenie.get(7).get(8).value = 1;
        inic.riesenie.get(7).get(13).value = 0;
        
        int[][] pom8 = {{0, 18}, {12, 17}};
        inic.set_hranice(pom8, 8);
        inic.riesenie.get(8).get(9).value = 1;
        
        inic.riesenie.get(9).get(0).value = 1;
        inic.riesenie.get(9).get(5).value = 1;
        inic.riesenie.get(9).get(6).value = 1;
        inic.riesenie.get(9).get(8).value = 1;
        inic.riesenie.get(9).get(17).value = 1;
        inic.riesenie.get(9).get(18).value = 1;
        inic.riesenie.get(9).get(19).value = 1;
        inic.riesenie.get(9).get(21).value = 1;
        inic.riesenie.get(9).get(23).value = 1;
        
         
        inic.riesenie.get(10).get(0).value = 1;
        inic.riesenie.get(10).get(5).value = 1;
        inic.riesenie.get(10).get(6).value = 1;
        inic.riesenie.get(10).get(8).value = 1;
        inic.riesenie.get(10).get(17).value = 1;
        inic.riesenie.get(10).get(18).value = 1;
        inic.riesenie.get(10).get(19).value = 1;
        inic.riesenie.get(10).get(21).value = 1;
        inic.riesenie.get(10).get(23).value = 1;
        inic.riesenie.get(10).get(12).value = 0;
        inic.riesenie.get(10).get(13).value = 0;
        
        int[][] pom11 = {{0, 6}, {2, 8}, {6, 12}, {14, 22}, {20, 24}};
        inic.set_hranice(pom11, 11);
        inic.riesenie.get(11).get(6).value = 1;
        inic.riesenie.get(11).get(22).value = 1;
        inic.riesenie.get(11).get(13).value = 0;
        
        int[][] pom12 = {{0, 7}, {3, 12}, {5, 8}, {11, 14}, {14, 19}, {17,22}, {19,24}};
        inic.set_hranice(pom12, 12);
        inic.riesenie.get(12).get(5).value = 1;
        inic.riesenie.get(12).get(8).value = 1;
        inic.riesenie.get(12).get(11).value = 1;
        inic.riesenie.get(12).get(19).value = 1;
        
        inic.riesenie.get(13).get(1).value = 1;
        inic.riesenie.get(13).get(23).value = 1;
        
        inic.riesenie.get(14).get(3).value = 1;
        inic.riesenie.get(14).get(2).value = 0;
        inic.riesenie.get(14).get(4).value = 0;
        
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() throws Porucha {
        System.out.println("hello");
        rules.prienik(0);
        ArrayList<MyInt> expected = new ArrayList<>();
        for (int i = 0; i < inic.p_stlpcov; i++) {
            expected.add(new MyInt(3));
        }

        assertTrue(inic.riesenie.get(0).size() == 25);
    }

    @Test
    public void testPrienik() throws Porucha {
       ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
           
        int[] a = {3,3,3,3,1, 3,3,3,3,3, 3,3,3,3,3, 3,1,1,1,1, 1,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       
        int[] b = {1,1,1,1,3, 1,1,1,1,3, 1,1,1,1,3, 1,1,1,1,3, 1,1,1,1,1};
        moje_riesenie.add(new ArrayList(MyInt.asList(b)));
       
        int[] c = {3,3,3,3,3, 3,0,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(c)));
        
        int[] d = {3,3,3,3,1, 1,1,3,3,3, 3,3,3,3,3, 1,1,1,1,1, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(d)));
        
        int[] e = {3,3,3,1,1, 1,1,1,1,3, 3,3,3,3,3, 3,3,3,3,3, 3,1,1,1,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(e)));

        int[] f = {1,1,1,1,1, 1,1,1,3,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1};
        moje_riesenie.add(new ArrayList(MyInt.asList(f)));
       
        int[] g = {3,3,3,3,1, 1,1,1,3,3, 3,3,3,3,3, 1,1,3,3,3, 3,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(g)));
       
        int[] h = {3,3,3,3,3, 3,1,1,1,1, 1,1,3,0,3, 3,3,3,1,1, 1,1,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(h)));
         
        int[] i = {3,3,3,3,3, 3,3,3,3,1, 3,3,3,1,1, 1,1,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(i)));
       
        int[] j = {1,3,3,3,3, 1,1,3,1,3, 3,3,3,3,3, 3,3,1,1,1, 3,1,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(j)));
        
        int[] k = {1,3,3,3,3, 1,1,3,1,3, 3,3,0,0,3, 3,3,1,1,1, 3,1,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(k)));
       
        int[] l = {3,3,3,3,3, 3,1,3,3,3, 3,3,3,0,3, 3,3,3,1,3, 3,3,1,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(l)));
        
        int[] m = {3,3,3,3,3, 1,3,3,1,3, 3,1,3,3,3, 1,1,1,1,1, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(m)));
       
        int[] n = {3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(n)));
       
        int[] o = {3,3,0,1,0, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(o)));
        
         for (int w=0; w<15; w++){
            if (w==4)continue;
            rules.prienik(w);
            assertTrue(moje_riesenie.get(w).equals(inic.riesenie.get(w)));
       
        }
    }
    
    @Test
    public void chybaPrienik() throws Porucha{
          boolean thrown = false;

  try {
    rules.prienik((4));
  } catch (Porucha e) {
    thrown = true;
  }

  assertTrue(thrown);
}
    
    @Test
    public void Jed_medzery() throws Porucha{
        ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
         int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       
        int[] b = {3,3,3,3,0, 3,3,3,3,0, 3,3,3,3,0, 3,3,3,3,0, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(b)));
            
        int[] c = {3,3,3,3,3, 3,0,3,3,3, 3,3,3,3,3, 3,3,3,0,0, 0,3,3,3,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(c)));
        
        int[] d = {0,0,3,3,3, 1,3,3,3,0, 0,0,0,0,0, 3,1,1,3,3, 0,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(d)));
        
        int[] e = {0,0,0,3,3, 3,3,3,3,0, 0,3,3,3,0, 0,0,0,0,0, 0,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(e)));
        
        int[] f = {3,3,3,3,3, 3,3,3,0,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(f)));
        
        int[] g = {3,3,3,3,1, 1,1,1,3,3, 3,3,3,3,3, 1,1,3,3,3, 3,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(g)));
        
        int[] h = {0,0,0,3,3, 3,3,3,1,3, 3,3,3,0,3, 0,0,3,3,3, 3,3,3,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(h)));
        
        int[] i = {3,3,3,3,3, 3,3,3,3,1, 3,3,3,3,3, 3,3,3,0,0, 0,0,0,0,0}; 
//treba urobit update0 az potom by sa to prestavilo
        moje_riesenie.add(new ArrayList(MyInt.asList(i)));
       
        int[] j = {1,3,3,3,3, 1,1,3,1,3, 3,3,3,3,3, 3,3,1,1,1, 3,1,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(j)));
        
        int[] k = {1,3,3,3,3, 1,1,3,1,3, 3,3,0,0,3, 3,3,1,1,1, 3,1,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(k)));
       
        int[] l = {3,3,3,3,3, 3,1,3,3,3, 3,3,3,0,3, 3,3,3,3,3, 3,3,1,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(l)));
        
        int[] m = {3,3,3,3,3, 1,3,3,1,0, 0,1,3,3,3, 3,3,3,3,1, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(m)));
        
        int[] n = {3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(n)));
       
        int[] o = {3,3,0,1,0, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(o)));
        
        for(int w=0;w>15; w++){
            rules.jed_medzery(w);
            assertTrue(moje_riesenie.get(w).equals(inic.riesenie.get(w)));
        }
    }
    
   @Test
    public void Jednotky() throws Porucha{
        ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
         int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
//        rules.jednotky(0);
//        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));
//        rules.jednotky_za(0);
//        assertTrue(moje_riesenie.get(0).equals(inic.riesenie.get(0)));


        int[] b = {3,3,3,3,0, 3,3,3,3,0, 3,3,3,3,0, 3,3,3,3,0, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(b)));
//        rules.jed_medzery(1);
//        assertTrue(moje_riesenie.get(1).equals(inic.riesenie.get(1)));
//        
    
        int[] c = {3,3,3,3,3, 3,0,3,3,3, 3,3,3,3,3, 3,3,3,0,0, 0,3,3,3,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(c)));
//        rules.jed_medzery(2);
//        assertTrue(moje_riesenie.get(2).equals(inic.riesenie.get(2)));

        int[] d = {3,3,3,3,3, 1,3,3,3,3, 3,3,3,3,3, 3,1,1,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(d)));
//        rules.jednotky(3);
//    assertTrue(moje_riesenie.get(3).equals(inic.riesenie.get(3)));
//        rules.jednotky_za(3);
//    assertTrue(moje_riesenie.get(3).equals(inic.riesenie.get(3)));

        int[] e = {0,0,0,3,3, 3,3,3,3,0, 0,3,3,3,0, 0,0,0,0,0, 0,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(e)));
//        rules.jed_medzery(4);
//        assert(moje_riesenie.get(4).equals(inic.riesenie.get(4)));

        int[] f = {3,3,3,3,3, 3,3,3,0,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(f)));
////        rules.jed_medzery(5);
////        assertTrue(moje_riesenie.get(5).equals(inic.riesenie.get(5)));
        
        int[] g = {3,3,3,3,1, 1,1,1,3,3, 3,3,3,3,3, 1,1,3,3,3, 3,0,0,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(g)));
//        rules.jed_medzery(6);
//        assertTrue(moje_riesenie.get(6).equals(inic.riesenie.get(6)));
        
        int[] h = {0,0,0,3,3, 3,3,3,1,3, 3,3,3,0,3, 0,0,3,3,3, 3,3,3,0,0};
        moje_riesenie.add(new ArrayList(MyInt.asList(h)));
//        rules.jed_medzery(7);
//        assertTrue(moje_riesenie.get(7).equals(inic.riesenie.get(7)));
        
        int[] i = {3,3,3,3,3, 3,3,3,3,1, 3,3,3,3,3, 3,3,3,0,0, 0,0,0,0,0}; 
//treba urobit update0 az potom by sa to prestavilo
        moje_riesenie.add(new ArrayList(MyInt.asList(i)));
//        rules.jed_medzery(8);
//        assertTrue(moje_riesenie.get(8).equals(inic.riesenie.get(8)));

        int[] j = {1,3,3,3,3, 1,1,3,1,3, 3,3,3,3,3, 3,3,1,1,1, 3,1,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(j)));
//        rules.jed_medzery(9);
//        assertTrue(moje_riesenie.get(9).equals(inic.riesenie.get(9)));
        
        int[] k = {1,3,3,3,3, 1,1,3,1,3, 3,3,0,0,3, 3,3,1,1,1, 3,1,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(k)));
//        rules.jed_medzery(10);
//        assertTrue(moje_riesenie.get(10).equals(inic.riesenie.get(10)));
        

        int[] l = {3,3,3,3,3, 0,1,3,3,3, 3,3,3,0,3, 3,3,3,3,3, 3,3,1,0,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(l)));
        rules.jednotky(11);
        assertTrue(moje_riesenie.get(11).equals(inic.riesenie.get(11)));
       
        
        int[] m = {3,3,3,3,0, 1,3,3,1,0, 0,1,3,3,3, 3,3,3,3,1, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(m)));
        rules.jednotky(12);
        assertTrue(moje_riesenie.get(12).equals(inic.riesenie.get(12)));
       
        int[] n = {3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,1,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(n)));
//        rules.jed_medzery(13);
//        assertTrue(moje_riesenie.get(13).equals(inic.riesenie.get(13)));
//        
        int[] o = {3,3,0,1,0, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
        moje_riesenie.add(new ArrayList(MyInt.asList(o)));
//        rules.jed_medzery(14);
//        assertTrue(moje_riesenie.get(14).equals(inic.riesenie.get(14)));
    }
     
    @Test
    public void random() throws Porucha{
         ArrayList<ArrayList<MyInt>> moje_riesenie= new ArrayList<>();
     int[] a = {3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3};
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
//       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
//       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
//        moje_riesenie.add(new ArrayList(MyInt.asList(a)));
//       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
//       moje_riesenie.add(new ArrayList(MyInt.asList(a)));
       int[] b = {3,1,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,1,3};
          moje_riesenie.add(new ArrayList(MyInt.asList(b)));
       rules.jednotky(13);
       rules.jednotky_za(13);
       rules.medzivypln(13);
       rules.nekryjuce(0);
       rules.okliestenie(0);
       rules.vynutenie(0);
       //rules.lepidlo(13);
       assertTrue(moje_riesenie.get(13).equals(inic.riesenie.get(13)));
        int[] c = {3,1,1,1,1, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,3,3, 3,3,3,1,3};
          moje_riesenie.add(new ArrayList(MyInt.asList(c)));
     
       rules.lepidlo(13);
       assertTrue(moje_riesenie.get(14).equals(inic.riesenie.get(13)));

       int[] d = {1,3,3,3,3, 1,1,0,1,3, 3,3,0,0,3, 3,3,1,1,1, 0,1,3,1,3};
          moje_riesenie.add(new ArrayList(MyInt.asList(d)));
      rules.vynutenie(10);MyInt.jeden_toString(inic.riesenie.get(10));
       assertTrue(moje_riesenie.get(15).equals(inic.riesenie.get(10)));
        
       
    }
            
    

    @Test
    public void test02() {
        //moje_riesenie.add(new ArrayList(Arrays.asList(1,1,1,1,3, 1,1,1,1,3, 1,1,1,1,3, 1,1,1,1,1)));
        //moje_riesenie.add(new ArrayList(Arrays.asList(3,3,3,3,1, 3,3,3,3,3, 3,1,1,1,1, 1,3,3,3,3)));

//        for (int i =0; i< moje_riesenie.size(); i++){
//            assertTrue(moje_riesenie.get(i).equals(inic.riesenie.get(i)));
//        }
    }

}
