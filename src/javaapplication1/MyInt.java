/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author User
 * vlastna trieda uchovavajuca hodnoty int
 */
public class MyInt {

    public int value;

    MyInt() {
        this(0);
    }

    public MyInt(int val) {
        value = val;
    }

    int value() {
        return value;
    }

    void setValue(int val) {
        value = val;
    }

    /**
     * 
     * @param list dvojrozmerny ArrayList
     * vypise hodnoty v liste naformatovane ako dvojrozmernu maticu
     */
    public static void toString(ArrayList<ArrayList<MyInt>> list) {
        for (ArrayList<MyInt> a : list) {
            for (MyInt m : a) {
                System.out.print(m.value + " ");
            }
            System.out.println("");
        }
    }

    /**
     * 
     * @param list 
     * vypise hodnoty nachadzajuce sa v tomto ArrayListe za sebou
     */
    public static void jeden_toString(ArrayList<MyInt> list) {
        for (MyInt m : list) {
            System.out.print(m.value + " ");
        }
        System.out.println("");
    }
    
       /**
        * 
        * @param list dvojrozmerne klasicke pole
        * @return list prerobeny na ArrayList<MyInt>
        */
    public static ArrayList<MyInt> asList(int[] list){
        ArrayList<MyInt> pom = new ArrayList<>();
        for(int i = 0; i<list.length; i++){
            pom.add(new MyInt(list[i]));
        }
        return pom;
    }
    
  /**
   * 
   * @param list
   * @return true ak sa hodnoty rovnaju, inak vrati false
   */
    @Override
    public boolean equals (Object list){
        MyInt pom = (MyInt)(list);
        //System.out.println(this.value);
       if (pom.value != this.value)return false;
        
       return true;
    }
}
