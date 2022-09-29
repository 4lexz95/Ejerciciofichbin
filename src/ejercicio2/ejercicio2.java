package ejercicio2;

import java.io.*;

public class ejercicio2 {

    private static File backUp;
    static {
        backUp = new File("estado_partida.dat");

    }
    public static void main(String[] args) {
        EstadoPartida estadoPartida = new EstadoPartida(10, 4);
        guardarPartida(estadoPartida);
        EstadoPartida partidaRecuperada = recuperarPartida();
        if(partidaRecuperada != null){
            System.out.printf("error al cargar");
        }

    }
    private static EstadoPartida recuperarPartida(){

        FileInputStream fis;
        try {
            fis = new FileInputStream(backUp);
            DataInputStream dis = new DataInputStream(fis);
            return new EstadoPartida(dis.readInt(),dis.readInt());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (FileNotFoundException e){

        }
        return null;

    }

    private static void guardarPartida(EstadoPartida estadoPartida) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(backUp);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(estadoPartida.getVidaRestantes());
            dos.writeInt(estadoPartida.getPantallaActual());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}
