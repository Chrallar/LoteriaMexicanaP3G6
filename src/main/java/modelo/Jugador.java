package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable,Comparable<Reporte>
{
    //Atributos de clase
    private String nombre;
    private ArrayList<Naipe> masoNaipe;
    private ArrayList<Naipe> tablero;
    
    //Constructor
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        this.masoNaipe = new ArrayList<>();
        this.tablero   = new ArrayList<>();
    }
    
    public Jugador(String nombre, ArrayList<Naipe> masoNaipe, ArrayList<Naipe> tablero) {
        this.nombre = nombre;
        this.masoNaipe = masoNaipe;
        this.tablero = tablero;
    }
    
    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Naipe> getMasoNaipe() {
        return masoNaipe;
    }

    public void setMasoNaipe(ArrayList<Naipe> masoNaipe) {
        this.masoNaipe = masoNaipe;
    }

    public ArrayList<Naipe> getTablero() {
        return tablero;
    }

    public void setTablero(ArrayList<Naipe> tablero) {
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
