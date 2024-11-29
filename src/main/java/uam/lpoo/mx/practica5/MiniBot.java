package uam.lpoo.mx.practica5;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase MiniBot se crea el objeto MiniBot que usa variables tipo Consulta consulta
 * @author Jesus Enriquez, Omar Castillo, Edgar Angeles
 */
public class MiniBot implements Serializable{
    /**
     * Parametro tipo Consulta
     * @see Consulta
     */
    private Consulta consulta;
    /**
     * Constructor por omision.
     * sirve para inicializar los atributos en 0 o en null.
     */
    public MiniBot() {
    }
    /**
     * Constructor con parametros 
     * Este constructor sirve para inicializar los atributos
     * @param consulta consulta compuesta del mensaje y la hora
     */
    public MiniBot(Consulta consulta) {
        this.consulta = consulta;
    }
     /**
     * metodo de acceso que muestra la consulta
     * @return dato de tipo Consulta
     */ 
    public Consulta getConsulta() {
        return consulta;
    }
    /**
     * metodo de acceso que permite modificar la consulta
     * saldo
     * @param consulta consulta compuesta del mensaje y la hora
     */
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    /**
     * Metodo que identifica las plabras vacias y las vacía
     * @return cadena con las palabras vacias
     * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Clase ArrayList de java </a>
     * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/lang/String.html"> Clase String de java </a>
     */
   public String eliminarPalabrasVacias(){
       String cadena = consulta.getMensaje();
       ArrayList <String> lista = new ArrayList<>();
       lista.add("la");
       lista.add("de");
       lista.add("el");
       lista.add("del");
       lista.add("para");
       lista.add("este");
       lista.add("los");
       lista.add("a");
       lista.add("cuando");
       lista.add("son");
       lista.add("al");
       lista.add("como");
       lista.add("cual");
       lista.add("que");
       lista.add("y");
       for (String palabra : lista) {
           cadena = cadena.replaceAll("\\b"+ palabra +"\\b","");
       }
       return cadena;
   }
   /**
    * Metodo que cuenta las palabraa vacias
    * @return entero con la caantidad de palabras vacias
    * @see eliminarPalabrasVacias()
    * @see <a href= "https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/util/StringTokenizer.html">Clase StringTokenizer de java </a>
    */
   public int contarPalabrasVacias(){
       int contador1;
       int contador2;
       
       String palabras = eliminarPalabrasVacias();
       StringTokenizer st = new StringTokenizer(palabras);
       contador1= st.countTokens();
       StringTokenizer st1 = new StringTokenizer(consulta.getMensaje());                   
       contador2 = st1.countTokens();
       
       return contador2 - contador1;
   }
   /**
    * Metodo que cuenta las palabraa clave
    * @return entero con la caantidad de palabras clave
    * @see eliminarPalabrasVacias()
    * @see <a href= "https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/util/StringTokenizer.html">Clase StringTokenizer de java </a>
    */   
   public int contarPalabrasClave(){
       int contador;
       String claves = eliminarPalabrasVacias();
       StringTokenizer st = new StringTokenizer(claves);
       
       return contador= st.countTokens();
   }
   /**
    * Metodo que genera una respuesta adecuada
    * @return Cadena con la respuesta
    * @see contarPalabrasClave()
    */   
    public String respuestaAdecuada(){
        String cad;
        if(consulta.getMensaje().contains("uam")){
            if(consulta.getMensaje().contains("uam") && consulta.getMensaje().contains("azcapotzalco")){
                return cad = ("La Universidad Autónoma Metropolitana Unidad Azcapotzalco actualmente cuenta con 17 "
                   + "licenciaturas, divididas en 3 áreas de estudio."
                   + "Visita: https://www.azc.uam.mx/");
           }else{
                return cad = ("Fundada en 1974 y con más de 200 mil personas egresadas, la UAM es una institución pública "
                        + "que ofrece en sus cinco unidades académicas. Visita: https://www.uam.mx/");
            }
       }
        else if(consulta.getMensaje().contains("servicio") && consulta.getMensaje().contains("medico")){
            return cad = ("Proporcionamos atención médica a los miembros de la comunidad universitaria. Contamos con 5 "
                   + "médicos y 4 consultorios, solo debes presentar tu credencial de la UAM. "
                   + "Visita: https://csu.azc.uam.mx/medicos/");
        }
        else if(consulta.getMensaje().contains("servicios") && consulta.getMensaje().contains("escolares")){
            return cad = ("La Coordinación de Sistemas Escolares, administra los procesos, entre los que se encuentran el "
                   + "registro, seguimiento y control del ingreso, permanencia y egreso de los alumnos de Licenciatura y "
                   + "Posgrado. Visita: http://cse.azc.uam.mx/");
        }
        else if(consulta.getMensaje().contains("covid") || consulta.getMensaje().contains("coviuam")){
            return cad = ("Es una nueva aplicación para conocer el estado de salud de la comunidad UAM en el regreso presencial. "
                   + "Visita: https://coviuam.uam.mx/");
       }
 
        if(contarPalabrasClave()>=3){
           return cad = ("No tengo información acerca de esa consulta.");
       }else {
           return cad = ("No entiendo tu consulta :(");
        }
    }
    /**
    * Metodo que calcula los milisegundos de respueta
    * y que genera la respuesta final 
    * @return Cadena con la respuesta final
    * @see contarPalabrasVacias()
    * @see contarPalabrasClave()
    * @see respuestaAdecuada()
    * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html"> Clase LocalTime de java </a>
    */  
    public String prepararRespuesta(){
        LocalTime inicio = LocalTime.now();
        long milisegundos = ChronoUnit.MILLIS.between(inicio, consulta.getHora());
        return "El número de palabras vacías: "+contarPalabrasVacias()+
                "\nEl numero de palabras clave: "+contarPalabrasClave()+
                "\nRespuesta: "+respuestaAdecuada()+
                "\nTiempo en responder: "+milisegundos;
    }
}
