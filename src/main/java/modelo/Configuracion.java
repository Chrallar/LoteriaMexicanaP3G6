package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Configuracion implements Serializable,Comparable<Configuracion>{
    
    //Atributos de clase
    private boolean visibilidadNaipe;
    private int maxCantNaipes;
    private ArrayList<Naipe> tablero;
    
    public Configuracion(boolean visibilidadNaipe, int maxcantidad)
    {
        this.visibilidadNaipe = visibilidadNaipe;
        this.maxCantNaipes = maxcantidad;
        this.tablero = new ArrayList<>();                
    }
    
    public static void modificarVisibilidadNaipeOponentes(boolean e)
    {
        
    }
    
    public static void modificarMaxCantOponentes(int c)
    {
        
    }

    @Override
    public int compareTo(Configuracion o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Metodos de Clase
    public static void serializarConfiguracion(Configuracion conf, String ruta){
        try(ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(ruta))){
            a.writeObject(conf);
        }catch(IOException e){}
    }
        
    public static Configuracion desserializarConfiguracion(String ruta){
        try(ObjectInputStream a = new ObjectInputStream(new FileInputStream(ruta))){
            return (Configuracion) a.readObject();
        }catch(Exception e)
        {            
            return new Configuracion(false, 0);
        }
    }
    
    public static void guardarConfiguracion(Configuracion conf) throws Exception{        
        Configuracion.serializarConfiguracion(conf, "Configuracion.ser");        
    }
    
}
