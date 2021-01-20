package modelo;

import java.io.Serializable;

public class Jugador implements Serializable,Comparable<Jugador>
{
    //Atributos de clase
    private String nombre;    
    private Naipe[][] tablero;
    
    //Constructor       
    public Jugador(String nombre, Naipe[][] tablero) {
        this.nombre = nombre;        
        this.tablero = tablero;
    }
    
    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Naipe[][] getTablero() {
        return tablero;
    }

    public void setTablero(Naipe[][] tablero) {
        this.tablero = tablero;
    }       

    @Override
    public int compareTo(Jugador o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
