package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
        int cantidadCartas;
        boolean visibilidadCartas = chk_VisibilidadCartas.isSelected();
        try
        {
            cantidadCartas = Integer.parseInt(txt_cantidad.getText().trim());
        }
        catch(Exception e)
        {
            cantidadCartas = 0;
        }
        
        //Valida que el usuario ingrese al menos un oponente
        if(cantidadCartas <= 0 || cantidadCartas > 2)
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Configuración",null,"Debe ingresar una cantidad de 1 a 2 oponentes!");                                             
        else
        {
            //Actualiza la configuracion en el archivo serializado
            Configuracion configuracion = new Configuracion(visibilidadCartas,cantidadCartas);
            Configuracion.guardarConfiguracion(configuracion);
        }
    }

    @FXML
    private void accionRegresar(ActionEvent event) 
    {
       Stage stageActual = (Stage) txt_cantidad.getScene().getWindow();            
        stageActual.close();
    }    
}
