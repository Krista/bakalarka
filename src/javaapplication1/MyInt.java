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
      int value;

    MyInt() {
        this(0);
    }

        MyInt(int val) {
        value = val;
    }

   
    int value() {
        return value;
    }

  
    void setValue(int val) {
        value = val;
    }
    
   static void toString(ArrayList<ArrayList<MyInt>> list) {
        for (ArrayList<MyInt> a : list) {
            for (MyInt m : a) {
                System.out.print(m.value + " ");
            }
            System.out.println("");
        }
    }

    static void jeden_toString(ArrayList<MyInt> list) {
        for (MyInt m : list) {
            System.out.print(m.value + " ");
        }
    }
}
