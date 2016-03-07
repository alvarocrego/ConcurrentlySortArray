/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.alcreta.main;

import net.alcreta.arrayDesordenado.ArrayDesordenado;
import net.alcreta.ordenacion.ConcurrentSort;
import net.alcreta.ordenacion.Ordenacion;

/**
 *
 * @author alcreta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Integer[] a = {9, 4, 5, 2, 6, 7, 5, 1, 3, 8, 0};
//        //Ordenacion.mergeSort1(a);
//        Ordenacion.quickSort(a);
//        System.out.println(a.toString());

        ArrayDesordenado array = new ArrayDesordenado(1000);
        array.comenzar();

        long startTime = System.currentTimeMillis();
        array.cargar();
        Integer[] b = array.getArray();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " en leer");
        long totalTime = 0L;
        for (int i = 0; i < 100; i++) {
            Integer[] tmp = b;
            startTime = System.currentTimeMillis();
            ConcurrentSort.sort(tmp);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }

        System.out.println((totalTime / 100) + " en ordenar concurrentemente");

        totalTime = 0L;
        for (int i = 0; i < 100; i++) {
            Integer[] tmp = b;
            startTime = System.currentTimeMillis();
            Ordenacion.quickSort(tmp);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println((totalTime / 100) + " en ordenar secuencialmente");
        System.out.println("Fin");
    }

}
