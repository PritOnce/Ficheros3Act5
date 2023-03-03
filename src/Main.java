import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.*;

public class Main {
    public static void main(String[] args){
        String matricula = JOptionPane.showInputDialog("Introduce la matricula");
        String marca = JOptionPane.showInputDialog("Introduce la marca");
        Double deposito = Double.valueOf(JOptionPane.showInputDialog("Introduce el tamaño del deposito"));
        String modelo = JOptionPane.showInputDialog("Introduce el modelo");

        try{
            DataInputStream dis = new DataInputStream(new FileInputStream("texto.txt"));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream( "texto.txt", true));
            meterDatos(dos,matricula,marca,deposito,modelo);
            mostrarDatos(dis);

        } catch (EOFException e) {
            System.out.println("Fin lectura");
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }

    public static void meterDatos(DataOutputStream dos, String matricla, String marca, double deposito, String modelo) throws IOException {
        dos.writeUTF(matricla);
        dos.writeUTF(marca);
        dos.writeDouble(deposito);
        dos.writeUTF(modelo);

        dos.flush();
    }

    public static void  mostrarDatos(DataInputStream dis) throws IOException {
        while(true){
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());
        }
    }
}