package altajugador;

/**
 * @author Víctor
 */
public class Jugador {
    
    String nombre;
    char[] passwd;
    Integer edad;

    public Jugador(String nombre, char[] passwd, Integer edad) {
        this.nombre = nombre;
        this.passwd = passwd;
        this.edad = edad;
    }
    
    public Jugador(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    

    @Override
    public String toString() {
        return "Jugador: " + nombre + " de " + edad + " años.";
        
    } 
}
