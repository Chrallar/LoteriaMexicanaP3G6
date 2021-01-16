package modelo;

import java.util.ArrayList;

public class Juego {

    //Atributos de clase
    private ArrayList<Jugador> jugadores;   
    private ArrayList<Naipe> masoNaipes;
    private Alineacion alineacion;
    private int ordenNaipe;
    private Naipe naipeActual;
    
    //Constructor
    public Juego(ArrayList<Jugador> jugadores,Alineacion alineacion, ArrayList<Naipe> naipes) {
        this.jugadores = jugadores;        
        this.alineacion = alineacion;
        this.masoNaipes = naipes;
    }
    
    //Getter and Setter
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    public Alineacion getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(Alineacion alineacion) {
        this.alineacion = alineacion;
    }

    public ArrayList<Naipe> getMasoNaipes() {
        return masoNaipes;
    }

    public void setMasoNaipes(ArrayList<Naipe> masoNaipes) {
        this.masoNaipes = masoNaipes;
    }

    public int getOrdenNaipe() {
        return ordenNaipe;
    }

    public void setOrdenNaipe(int ordenNaipe) {
        this.ordenNaipe = ordenNaipe;
    }

    public Naipe getNaipeActual() {
        return naipeActual;
    }

    public void setNaipeActual(Naipe naipeActual) {
        this.naipeActual = naipeActual;
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
