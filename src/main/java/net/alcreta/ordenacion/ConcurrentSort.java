/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.alcreta.ordenacion;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Álvaro
 */
public class ConcurrentSort {

    public static void sort(Integer[] array) {
        int cores = Runtime.getRuntime().availableProcessors();
        double part = (double) (array.length - 1) / cores;
        ConcurrentQuickSort[] c = new ConcurrentQuickSort[cores];
        for (int i = 0; i < cores; i++) {
            ConcurrentQuickSort tmp = new ConcurrentQuickSort(Arrays.copyOfRange(array, (int) (part * i), (int) (part * (i + 1))));
            tmp.start();
            Array.set(c, i, tmp);
        }

        for (ConcurrentQuickSort f : c) {
            try {
                f.join();
            } catch (InterruptedException ex) {
                System.out.println("Miau");
            }
        }

    }
}
