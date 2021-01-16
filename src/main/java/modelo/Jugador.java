package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable,Comparable<Reporte>
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
    
    //Metodos de Clase
    public static void escogerNaipe(Naipe naipe)
    {
        
    }
    
    public static void reclamarPremio()
    {
        
    }

    @Override
    public int compareTo(Reporte o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
