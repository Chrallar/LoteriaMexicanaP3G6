package controlador;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Juego;
import modelo.Naipe;

public class PantallaJuegoController implements Initializable {

    @FXML
    private ImageView img_AlineacionGanadora;
    @FXML
    private ImageView img_NaipeTablero_1;
    @FXML
    private ImageView img_NaipeTablero_2;
    @FXML
    private ImageView img_NaipeTablero_3;
    @FXML
    private ImageView img_NaipeTablero_4;
    @FXML
    private ImageView img_NaipeTablero_5;
    @FXML
    private ImageView img_NaipeTablero_6;    
    @FXML
    private ImageView img_NaipeTablero_7;    
    @FXML
    private ImageView img_NaipeTablero_8;
    @FXML
    private ImageView img_NaipeTablero_9;
    @FXML
    private ImageView img_NaipeTablero_10;
    @FXML
    private ImageView img_NaipeTablero_11;
    @FXML
    private ImageView img_NaipeTablero_12;
    @FXML
    private ImageView img_NaipeTablero_13;
    @FXML
    private ImageView img_NaipeTablero_14;
    @FXML
    private ImageView img_NaipeTablero_15;
    @FXML
    private ImageView img_NaipeTablero_16;
    @FXML
    private ImageView img_NaipeActual;
    @FXML
    private Button btn_CambiarNaipe;
                
    Juego juegoActual;
    ArrayList<Naipe> masoNaipe;
    int ordenNaipe = 0;
    Naipe naipeActual;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void cargarJuego(Juego juego) 
    {
        juegoActual = juego;
        masoNaipe = juegoActual.getMasoNaipes();
        naipeActual = masoNaipe.get(ordenNaipe);
        cargarDatosJuego();
    }
    

    @FXML
    private void accionMostrarTableroJugador(ActionEvent event) 
    {
        //Cargar los datos del tablero del Jugador Humano
        cargarImagenesTablero(juegoActual.getJugadores().get(0).getTablero());
    }

    @FXML
    private void accionMostrarTableroComputador(ActionEvent event) 
    {
        //Cargar los datos del tablero del Jugador Humano
        cargarImagenesTablero(juegoActual.getJugadores().get(1).getTablero());
    }

    @FXML
    private void accionCambiarNaipe(ActionEvent event) 
    {
        //Evita regresar al mismo naipe
        if(ordenNaipe < 54)
        {            
            cargarNaipeActual();
            cargarImagenNaipeActual();
            ordenNaipe++;
        }
    }
    
    public void cargarDatosJuego()
    {
        //Cargar la foto de alineacion ganadora
        String alineacionURL = Helper.HelperJuego.getAlineacionGanadora(juegoActual.getAlineacion());        
        cargarImagenAlineacion("src/main/resources/formaGanar/"+alineacionURL);
        
        //Cargar los datos del tablero del Jugador Humano
        cargarImagenesTablero(juegoActual.getJugadores().get(0).getTablero());  
        cargarNaipeActual();
        cargarImagenNaipeActual();
    }
    
    public void cargarImagenAlineacion(String imgURL)
    {
        //Cargar la imagen de la alineacion ganadora
        File file;
        file = new File(imgURL);
        Image  image = new Image(file.toURI().toString());
        img_AlineacionGanadora.setImage(image);
        img_AlineacionGanadora.setFitWidth(141);
        img_AlineacionGanadora.setFitHeight(200);        
    }
       
    public void cargarImagenesTablero(Naipe[][] tablero)
    {
        //Primera Fila
       img_NaipeTablero_1.setImage(tablero[0][0].getImagenNaipe());
       img_NaipeTablero_1.setFitWidth(101);
       img_NaipeTablero_1.setFitHeight(116);        
       
       img_NaipeTablero_2.setImage(tablero[0][1].getImagenNaipe());
       img_NaipeTablero_2.setFitWidth(101);
       img_NaipeTablero_2.setFitHeight(116);
       
       img_NaipeTablero_3.setImage(tablero[0][2].getImagenNaipe());
       img_NaipeTablero_3.setFitWidth(101);
       img_NaipeTablero_3.setFitHeight(116);
       
       img_NaipeTablero_4.setImage(tablero[0][3].getImagenNaipe());
       img_NaipeTablero_4.setFitWidth(101);
       img_NaipeTablero_4.setFitHeight(116);
       
       //Segunda Fila
       img_NaipeTablero_5.setImage(tablero[1][0].getImagenNaipe());
       img_NaipeTablero_5.setFitWidth(101);
       img_NaipeTablero_5.setFitHeight(116);
       
       img_NaipeTablero_6.setImage(tablero[1][1].getImagenNaipe());
       img_NaipeTablero_6.setFitWidth(101);
       img_NaipeTablero_6.setFitHeight(116);
       
       img_NaipeTablero_7.setImage(tablero[1][2].getImagenNaipe());
       img_NaipeTablero_7.setFitWidth(101);
       img_NaipeTablero_7.setFitHeight(116);
       
       img_NaipeTablero_8.setImage(tablero[1][3].getImagenNaipe());
       img_NaipeTablero_8.setFitWidth(101);
       img_NaipeTablero_8.setFitHeight(116);
       
       //Tercera fila
       img_NaipeTablero_9.setImage(tablero[2][0].getImagenNaipe());
       img_NaipeTablero_9.setFitWidth(101);
       img_NaipeTablero_9.setFitHeight(116);
       
       img_NaipeTablero_10.setImage(tablero[2][1].getImagenNaipe());
       img_NaipeTablero_10.setFitWidth(101);
       img_NaipeTablero_10.setFitHeight(116);
       
       img_NaipeTablero_11.setImage(tablero[2][2].getImagenNaipe());
       img_NaipeTablero_11.setFitWidth(101);
       img_NaipeTablero_11.setFitHeight(116);
       
       img_NaipeTablero_12.setImage(tablero[2][3].getImagenNaipe());
       img_NaipeTablero_12.setFitWidth(101);
       img_NaipeTablero_12.setFitHeight(116);
       
       //Cuarta Fila
       img_NaipeTablero_13.setImage(tablero[3][0].getImagenNaipe());
       img_NaipeTablero_13.setFitWidth(101);
       img_NaipeTablero_13.setFitHeight(116);
       
       img_NaipeTablero_14.setImage(tablero[3][1].getImagenNaipe());
       img_NaipeTablero_14.setFitWidth(101);
       img_NaipeTablero_14.setFitHeight(116);
       
       img_NaipeTablero_15.setImage(tablero[3][2].getImagenNaipe());
       img_NaipeTablero_15.setFitWidth(101);
       img_NaipeTablero_15.setFitHeight(116);
       
       img_NaipeTablero_16.setImage(tablero[3][3].getImagenNaipe());
       img_NaipeTablero_16.setFitWidth(101);
       img_NaipeTablero_16.setFitHeight(116);
    }
    
    public void cargarNaipeActual()
    {
        juegoActual.setNaipeActual(masoNaipe.get(ordenNaipe));
        naipeActual = juegoActual.getNaipeActual();        
    }
    
    public void cargarImagenNaipeActual()
    {
        img_NaipeActual.setImage(naipeActual.getImagenNaipe());
        img_NaipeActual.setFitWidth(220);
        img_NaipeActual.setFitHeight(300);              
    }
}
