package modelo;

import java.util.ArrayList;

public class Juego {

    //Atributos de clase
    private ArrayList<Jugador> jugadores;
    private ArrayList<Naipe> tableroGanador;
    
    //Constructor
    public Juego(ArrayList<Jugador> jugadores, ArrayList<Naipe> tableroGanador) {
        this.jugadores = jugadores;
        this.tableroGanador = tableroGanador;
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
