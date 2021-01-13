package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Configuracion;

public class PantallaConfiguracionController implements Initializable {

    @FXML
    private TextField txt_cantidad;
    @FXML
    private CheckBox chk_VisibilidadCartas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actualizarConfiguracion(ActionEvent event) throws Exception
    {
        boolean visibilidadCartas = chk_VisibilidadCartas.isSelected();
        int cantidadCartas = Integer.parseInt(txt_cantidad.getText().trim());        
        Configuracion configuracion = new Configuracion(visibilidadCartas,cantidadCartas);
        Configuracion.guardarConfiguracion(configuracion);
    }

    @FXML
    private void accionRegresar(ActionEvent event) 
    {
       Stage stageActual = (Stage) txt_cantidad.getScene().getWindow();            
        stageActual.close();
    }    
}
