package modelo;

import javafx.scene.image.Image;

public class Naipe 
{
    //Atributos de clase
    private int numero;
    private String nombre;
    private String urlImagenNaipe;
    private Image imagenNaipe;
    private Image imagenNaipeSeleccionado;
    private boolean esSeleccionado;
    
    //Constructor
    public Naipe(int numero, String nombre, String urlImagenNaipe, Image imagenNaipe,Image imagenNaipeSeleccionado) {
        this.numero = numero;
        this.nombre = nombre;
        this.urlImagenNaipe = urlImagenNaipe;
        this.imagenNaipe = imagenNaipe;
        this.imagenNaipeSeleccionado = imagenNaipeSeleccionado;
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

    public Image getImagenNaipe() 
    {
        if(esSeleccionado)
            return imagenNaipeSeleccionado;
        return imagenNaipe;
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
}
