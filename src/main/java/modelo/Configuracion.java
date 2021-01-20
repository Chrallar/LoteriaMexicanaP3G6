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
    private int maxCantOponentes;    
    
    public Configuracion(boolean visibilidadNaipe, int maxcantidad)
    {
        this.visibilidadNaipe = visibilidadNaipe;
        this.maxCantOponentes = maxcantidad;        
    }    

    public boolean isVisibilidadNaipe() {
        return visibilidadNaipe;
    }

    public void setVisibilidadNaipe(boolean visibilidadNaipe) {
        this.visibilidadNaipe = visibilidadNaipe;
    }

    public int getMaxCantOponentes() {
        return maxCantOponentes;
    }

    public void setMaxCantOponentes(int maxCantOponentes) {
        this.maxCantOponentes = maxCantOponentes;
    }
    
    

    @Override
    public int compareTo(Configuracion o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Metodos de Clase
    
    //Permite gaurdar en un archivo seralizado la configuracion del juego
    public static void serializarConfiguracion(Configuracion conf, String ruta){
        try(ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(ruta))){
            a.writeObject(conf);
        }catch(IOException e){}
    }
    
    //Permite extraer la informacion del archivo serializado
    public static Configuracion desserializarConfiguracion(String ruta){
        try(ObjectInputStream a = new ObjectInputStream(new FileInputStream(ruta))){
            return (Configuracion) a.readObject();
        }catch(Exception e)
        {            
            return new Configuracion(false, 0);
        }
    }
    
    //Permite guardar en un archivo seralizado la configuracion del juego
    public static void guardarConfiguracion(Configuracion conf) throws Exception{        
        Configuracion.serializarConfiguracion(conf, "Configuracion.ser");        
    }
    
}
