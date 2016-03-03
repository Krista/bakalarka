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
public class Inicializacia {

    int[][][] pole_hodnot;
    int p_stlpcov;
    ArrayList<ArrayList<Integer>> zadanie;
    ArrayList<ArrayList<MyInt>> riesenie = new ArrayList<>();

    public Inicializacia(ArrayList<ArrayList<Integer>> zadanie, int p_stlpcov) {
        this.zadanie = zadanie;
        this.pole_hodnot = new int[zadanie.size()][][];
        this.p_stlpcov = p_stlpcov;
        for (int i = 0; i < zadanie.size(); i++) {
            this.pole_hodnot[i] = inic(zadanie.get(i), p_stlpcov);

            ArrayList<MyInt> pom = new ArrayList<>();
            for (int j = 0; j < p_stlpcov; j++) {
                pom.add(new MyInt(3));
            }
            this.riesenie.add(pom);
        }
    }

    public Inicializacia(ArrayList<ArrayList<Integer>> zadanie, int p_stlpcov, ArrayList<ArrayList<MyInt>> rr) {
        this.pole_hodnot = new int[zadanie.size()][][];
        this.p_stlpcov = p_stlpcov;
        for (int i = 0; i < zadanie.size(); i++) {
            this.pole_hodnot[i] = inic(zadanie.get(i), p_stlpcov);
            ArrayList<MyInt> pom = new ArrayList<>();
            this.riesenie.add(pom);
        }
        for (int i = 0; i < zadanie.size(); i++) {
            for (int j = 0; j < rr.size(); j++) {
                this.riesenie.get(i).add(rr.get(j).get(i));
               // this.riesenie.get(i).add(new MyInt());
            }
        }
       
    }

    public static int[][] inic(ArrayList<Integer> zadanie, int size) {
        int pocet = zadanie.size();
        int[][] j = new int[pocet][2];

        int suma = zadanie.get(0) + 1;
        j[0][0] = 0;
        for (int i = 1; i < pocet; i++) {  //
            j[i][0] = suma;
            suma += zadanie.get(i) + 1;

        }

        suma = size - zadanie.get(pocet - 1) - 2;
        j[pocet - 1][1] = size - 1;
        for (int i = pocet - 2; i >= 0; i--) {
            j[i][1] = suma;
            suma -= zadanie.get(i) + 1;

        }

        /*for (int i = 0; i < pocet; i++) {
            System.out.println(Arrays.toString(j[i]));
        }*/
        return j;
    }

    public void set(int[][] list, int i) {
        this.pole_hodnot[i] = list;
    }

}
