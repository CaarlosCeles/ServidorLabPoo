package uam.lpoo.mx.practica5;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Clase Consulta, se crea el objeto consulta que usa variables tipo String mensjae y
 * localTime.
 * @author Jesus Enriquez, Omar Castillo, Edgar Angeles
 * @version 1.0
 */
public class Consulta implements Serializable{
    /**
     * Parametro tipo String
     */
    private String mensaje;
    /**
     * Parametro tipo LocalDate
     * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html"> Clase LocalTime de java </a>
     */
    private LocalTime hora;
    /**
     * Constructor por omisión 
     * sirve para incializar los atributos en 0 o en null
     */
    public Consulta() {
    }
    /**
     * Constructor por parametros
     * se encarga de que los atributos se inicializen con valores adecuados 
     * @param mensaje valor de tipo String 
     * @param hora valor de tipo LocalTime
     * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html"> Clase LocalTime de java </a>
     */
    public Consulta(String mensaje, LocalTime hora) {
        this.mensaje = mensaje;
        this.hora = hora;
    }
    /**
     * Metodo de acceso get
     * sirvepara poder ver el valor del atributo mensaje 
     * @return variable mensaje
     */
    public String getMensaje() {
        return mensaje;
    }
    /**
     * Metodo de acceso set
     * Metodo de acceso que permite modificar el valor dentro de la variable 
     * @param mensaje recibe una varibale de tipo String
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
     * metodo de acceso get
     * sirve para observar el valor del atributo hora
     * @return valor de tipo hora 
     */
    public LocalTime getHora() {
        return hora;
    }
    /**
     * Metodo de aceso set
     * Permite modificare el valor de la hora dentro de la variable hora 
     * @param hora recibe un parametro de tipo LocalDate
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    /**
     * Metodo toString
     * Metodo de la clase Object que retorna una cadena de texto con los atributos de la clase Consulta
     * @return cadena de texto
     */
    @Override
    public String toString() {
        return "Consulta" + "mensaje=" + mensaje + ", hora=" + hora ;
    }
}
