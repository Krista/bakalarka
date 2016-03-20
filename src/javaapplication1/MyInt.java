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

    public static void toString(ArrayList<ArrayList<MyInt>> list) {
        for (ArrayList<MyInt> a : list) {
            for (MyInt m : a) {
                System.out.print(m.value + " ");
            }
            System.out.println("");
        }
    }

    public static void jeden_toString(ArrayList<MyInt> list) {
        for (MyInt m : list) {
            System.out.print(m.value + " ");
        }
    }
    
       
    public static ArrayList<MyInt> asList(int[] list){
        ArrayList<MyInt> pom = new ArrayList<>();
        for(int i = 0; i<list.length; i++){
            pom.add(new MyInt(list[i]));
        }
        return pom;
    }
    
  
    @Override
    public boolean equals (Object list){
        MyInt pom = (MyInt)(list);
        //System.out.println(this.value);
       if (pom.value != this.value)return false;
        
       return true;
    }
}
