package modelo;

import java.io.Serializable;
import javafx.scene.image.Image;

public class Naipe implements Serializable,Comparable<Naipe>
{
    //Atributos de clase
    private int numero;
    private String nombre;
    private String urlImagenNaipe;
    private Image imagenNaipe;
    private Image imagenNaipeSeleccionado;
    private Image imagenNaipeSeleccionadoPC;
    private Image imagenNaipeBack;
    private boolean esSeleccionado;
    
    //Constructor
    public Naipe(int numero, String nombre, 
                 String urlImagenNaipe, 
                 Image imagenNaipe,
                 Image imagenNaipeSeleccionado,
                 Image imagenNaipeSeleccionadoPC,
                 Image imagenNaipeBack) {
        this.numero = numero;
        this.nombre = nombre;
        this.urlImagenNaipe = urlImagenNaipe;
        this.imagenNaipe = imagenNaipe;
        this.imagenNaipeSeleccionado = imagenNaipeSeleccionado;
        this.imagenNaipeSeleccionadoPC = imagenNaipeSeleccionadoPC;
        this.imagenNaipeBack = imagenNaipeBack;
    }
    
    //Getter and Setter
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagenNaipe() {
        return urlImagenNaipe;
    }

    public void setUrlImagenNaipe(String urlImagenNaipe) {
        this.urlImagenNaipe = urlImagenNaipe;
    }

    public Image getImagenNaipe(int jugadorSeleccionado, boolean mostrarNaipe) 
    {   
        //JUGADOR HUMANO
        if(jugadorSeleccionado == 1)
        {
            if(esSeleccionado)
                return imagenNaipeSeleccionado;
            else
                return imagenNaipe;
        }
        else
        {
            //JUGADORES COMPUTADOR 1 Y 2
            if(esSeleccionado)
                return imagenNaipeSeleccionadoPC;
            else
                if(mostrarNaipe)
                    return imagenNaipe;
                else 
                    return imagenNaipeBack;            
        }         
    }

    public void setImagenNaipe(Image imagenNaipe) {
        this.imagenNaipe = imagenNaipe;
    }

    public boolean isEsSeleccionado() {
        return esSeleccionado;
    }

    public void setEsSeleccionado(boolean esSeleccionado) {
        this.esSeleccionado = esSeleccionado;
    }    

    public Image getImagenNaipeSeleccionadoPC() {
        return imagenNaipeSeleccionadoPC;
    }

    public void setImagenNaipeSeleccionadoPC(Image imagenNaipeSeleccionadoPC) {
        this.imagenNaipeSeleccionadoPC = imagenNaipeSeleccionadoPC;
    }

    @Override
    public int compareTo(Naipe o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
