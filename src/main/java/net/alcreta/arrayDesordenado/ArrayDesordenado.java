/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.alcreta.arrayDesordenado;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;

/**
 *
 * @author alcreta
 */
public class ArrayDesordenado {

    Integer[] array;
    int count;

    public ArrayDesordenado(int x) {
        this.array = new Integer[x];
        this.count = x;
    }

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    private void insert(Integer x, Integer index) {
        Array.set(array, index, x);
    }

    public void comenzar() {
        File f = new File("./" + count + ".bin");
        if (!f.exists() || f.isDirectory()) {
            System.out.println("El fichero no existe. Creando array:");
            int x = 0;
            while (count != x) {
                Double a = Math.floor(Math.random() * ((-8000000) - 8000000 + 1) + 8000000);
                insert(a.intValue(), x);
                if ((((double) x / (double) count) * 100) % 5 == 0) {
                    System.out.println(((double) x / (double) count) * 100 + "%");
                }
                x++;
            }
            System.out.println("100.0%");
            //guardar();
        } else {
            System.out.println("Exise el fichero");
        }
    }

    private void guardar() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("./" + count + ".bin"));
            oos.writeObject(array);
        } catch (FileNotFoundException e) {
            System.out.println("petada");
        } catch (IOException e) {
            System.out.println("Petada");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("Petada");
                }
            }
        }
    }

    public void cargar() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("./" + count + ".bin"));
            try {
                while (true) {
                    setArray((Integer[]) ois.readObject());
                }
            } catch (EOFException e) {
            } catch (ClassNotFoundException ex) {
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
    }

}
