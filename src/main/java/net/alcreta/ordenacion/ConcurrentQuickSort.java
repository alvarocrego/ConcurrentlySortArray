/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.alcreta.ordenacion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Álvaro
 */
public class ConcurrentQuickSort extends Thread {

    Integer[] array;

    public ConcurrentQuickSort(Integer[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Ordenacion.quickSort(array);
    }
}
