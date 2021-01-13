package modelo;

import javafx.scene.image.Image;

public class Naipe implements InterfazPosicionObjeto
{
    //Atributos de clase
    private int numero;
    private String nombre;
    private String urlImagenNaipe;
    private Image imagenNaipe;
    
    //Constructor
    public Naipe(int numero, String nombre, String urlImagenNaipe, Image imagenNaipe) {
        this.numero = numero;
        this.nombre = nombre;
        this.urlImagenNaipe = urlImagenNaipe;
        this.imagenNaipe = imagenNaipe;
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

    public Image getImagenNaipe() {
        return imagenNaipe;
    }

    public void setImagenNaipe(Image imagenNaipe) {
        this.imagenNaipe = imagenNaipe;
    }               

    @Override
    public void ubicarPosicionTablero(int x, int y) {
        
    }
}
