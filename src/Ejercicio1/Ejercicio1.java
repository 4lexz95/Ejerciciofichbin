package Ejercicio1;

import java.io.*;
import java.text.NumberFormat;

public class Ejercicio1 {

    public static File registros;

    static {
        registros = new File("registro.dat");


    }
    public static void main(String[] args) {
        crearficheroContable();
        int saldo = 0;
        saldo = leerregistroscontables(saldo);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.printf("Tu saldo es de %s%n", numberFormat.format(saldo));

    }

    private static int leerregistroscontables(int saldo) {
        FileInputStream fis = null;
        try {
            fis = new  FileInputStream(registros);
            DataInputStream dis = new DataInputStream(fis);

            while (true){
                saldo+=dis.readInt();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return saldo;
    }

    private static void crearficheroContable() {

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(registros, true);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int i = 0; i < 1000; i++) {

                int x = (int) (Math.random() * 1501);
                if (i % 2 == 0) {
                    x += -1;
                    dos.writeInt(x);


                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        }

    }



