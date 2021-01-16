package modelo;

import javafx.scene.image.Image;

public class Ficha implements InterfazPosicionObjeto
{
    //Atributo de clase
    private String urlImagenFicha;
    private Image imagenFicha;   

    //Constructor
    public Ficha() {        
    }
    
    public Ficha(String urlImagenFicha, Image imagenFicha) {
        this.urlImagenFicha = urlImagenFicha;
        this.imagenFicha = imagenFicha;
    }

    //Getter and Setter
    public String getUrlImagenFicha() {
        return urlImagenFicha;
    }

    public void setUrlImagenFicha(String urlImagenFicha) {
        this.urlImagenFicha = urlImagenFicha;
    }

    public Image getImagenFicha() {
        return imagenFicha;
    }

    public void setImagenFicha(Image imagenFicha) {
        this.imagenFicha = imagenFicha;
    }

    @Override
    public void ubicarPosicionTablero(double x, double y) {        
    }
    
    
    
    
}
