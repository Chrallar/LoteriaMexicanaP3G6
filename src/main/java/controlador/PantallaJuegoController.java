package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.Juego;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void cargarJuego(Juego juego) 
    {
        juegoActual = juego;        
    }
    

    @FXML
    private void accionMostrarTableroJugador(ActionEvent event) {
    }

    @FXML
    private void accionMostrarTableroComputador(ActionEvent event) {
    }

    @FXML
    private void accionCambiarNaipe(ActionEvent event) {
    }
    
}
