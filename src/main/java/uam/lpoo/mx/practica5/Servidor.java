package uam.lpoo.mx.practica5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase Test Servidor
 * Esta clase recibe a la consulta del cliente pra depues deserializarlo.
 * Una mquina se conecta a este servidor mediante el numero de puerto, recibe la peticion del cliente,  
 * la consulta recibida la procesa, la serializa y envia la respuesta final 
 * @author Jesus Alberto, Omar Castillo, Edgar Angeles 
 * @version 1.0
 */
public class Servidor {
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
        * @see <a href = "https://www.programarya.com/Cursos-Avanzados/Java/Sockets"/>Clase Socket</a>
        * @see <a href = "https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/io/ObjectOutputStream.html"/>Clase ObjectOutputStream</a>
        * @see <a href = "https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/io/ObjectInputStream.html"/>Clase ObjectInputStream</a>
        * @see Consulta
        */
            ServerSocket servidor; 
            ObjectInputStream in;
            ObjectOutputStream out;
            MiniBot bot = null;
            Socket s1;
            Consulta consulta;
            try{
                servidor = new ServerSocket(12345);
            while(true){
                System.out.println("\n.....Servidor en espera.... \n");
                s1= servidor.accept();
                System.out.println("Conexion aceptada....");
                in = new ObjectInputStream(s1.getInputStream());
                consulta = (Consulta)  in.readObject();
                bot = new MiniBot(consulta);
                System.out.println("Objeto Deserializado...");
                out = new ObjectOutputStream(s1.getOutputStream());
                out.writeObject(bot.prepararRespuesta());
                out.close();
                in.close();
                s1.close();
              } 
            } catch (IOException ex1) {
                System.out.println("Error1" + ex1.getMessage());
            } catch (ClassNotFoundException ex2) {
                System.out.println("Error2" + ex2.getMessage());
        }
    }
}
