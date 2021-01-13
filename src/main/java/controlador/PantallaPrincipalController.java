package controlador;

import leab.loteriamexicana.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PantallaPrincipalController implements Initializable {

    @FXML
    private Button btn_Configuraciones;
    @FXML
    private Button btn_NuevoJuego;
    @FXML
    private Button btn_Reporte;
    @FXML
    private Button btn_Reporte1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionConfiguraciones(ActionEvent event) throws IOException
    {
        Helper.HelperJuego.cargarReportes();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PantallaConfiguracion" + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Configuración del Juego");
        stage.setMaxWidth(600);
        stage.setMaxHeight(375);
        stage.setScene(new Scene(root));  
        stage.show();                    
    }

    @FXML
    private void accionNuevoJuego(ActionEvent event) {
    }

    @FXML
    private void accionReporte(ActionEvent event) throws IOException
    {
        //Helper.HelperJuego.cargarReportes();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PantallaReporte" + ".fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Tabla de reportes");
        stage.setMaxWidth(600);
        stage.setMaxHeight(375);
        stage.setScene(new Scene(root));  
        stage.show();                    
        
    }

    @FXML
    private void accionSalir(ActionEvent event) 
    {
        System.exit(0);
    }
    
}
