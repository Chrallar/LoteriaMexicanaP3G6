package modelo;

import java.util.ArrayList;

public class Juego {

    //Atributos de clase
    private ArrayList<Jugador> jugadores;
    private ArrayList<Naipe> tableroGanador;
    private Alineacion alineacion;
    
    //Constructor
    public Juego(ArrayList<Jugador> jugadores, ArrayList<Naipe> tableroGanador,Alineacion alineacion) {
        this.jugadores = jugadores;
        this.tableroGanador = tableroGanador;
        this.alineacion = alineacion;
    }
    
    //Getter and Setter
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Naipe> getTableroGanador() {
        return tableroGanador;
    }

    public void setTableroGanador(ArrayList<Naipe> tableroGanador) {
        this.tableroGanador = tableroGanador;
    }

    public Alineacion getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(Alineacion alineacion) {
        this.alineacion = alineacion;
    }
    
    
    
    //Metodos de clase
    public static void ubicarNaipe()
    {
        
    }
    
    public static void escogerNaipe()
    {
        
    }
    
    public static void reclamarPremio()
    {
        
    }
    
    public static void verificarJuegoGanado()
    {
        
    }    
}
