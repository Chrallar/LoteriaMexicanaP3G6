/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import leab.loteriamexicana.App;
import modelo.Alineacion;
import modelo.Juego;
import modelo.Jugador;
import modelo.Naipe;

/**
 * FXML Controller class
 *
 * @author Octavio Lucero
 */
public class PantallaInicioJuegoController implements Initializable {

    @FXML
    private Label lbl_SinMaterias;
    @FXML
    private TextField txt_NombreJugador;
    @FXML
    private ImageView img_Alineacion;
    @FXML
    private Button btnComenzarJuego;
    
    
    Alineacion alineacionGanadora;
    String nombreJugador;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarInicioJuego();
    }    

    @FXML
    private void generarAlineacion(ActionEvent event) 
    {
        alineacionGanadora = Helper.HelperJuego.generarAlineacionGanadora();
        String alineacionString = Helper.HelperJuego.getAlineacionGanadora(alineacionGanadora);
        String alineacion = "src/main/resources/formaGanar/"+alineacionString;
        cargarImagenAlineacion(alineacion);        
    }

    @FXML
    private void ComenzarJuego(ActionEvent event) 
    {
        nombreJugador = txt_NombreJugador.getText().trim();
        if(nombreJugador.isEmpty() || alineacionGanadora.equals(Alineacion.ALINEACION_NO_SELECCIONADA))
           Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.WARNING),"Inicio de Juego",null,"Debe ingresar un nombre y haber generado la alineacion ganadora!");
        else
            cargarPanelJuego();
                
    }
    
    
    public void cargarImagenAlineacion(String imgURL)
    {
        //Cargar la imagen de la alineacion ganadora
        File file;
        file = new File(imgURL);
        Image  image = new Image(file.toURI().toString());
        img_Alineacion.setImage(image);
        img_Alineacion.setFitWidth(175);
        img_Alineacion.setFitHeight(200);        
    }         
    
    public void cargarInicioJuego()
    {
        alineacionGanadora = Alineacion.ALINEACION_NO_SELECCIONADA;
        String imagenInicial = "src/main/resources/imagenesNaipe/back.png";
        cargarImagenAlineacion(imagenInicial);
    }
    
    public void cargarPanelJuego()
    {
        Naipe[][] tableroJugadorHumano = Helper.HelperJuego.generarTableroJugador();
        Jugador jugadorHumano = new Jugador(nombreJugador,tableroJugadorHumano);                
        
        Naipe[][] tableroJugadorPC1 = null;
        boolean tableroIgual = true;
        while(tableroIgual)
        {             
            tableroJugadorPC1 = Helper.HelperJuego.generarTableroJugador();
            if(!tableroJugadorHumano.equals(tableroJugadorPC1))
                tableroIgual = false;
        }                
        Jugador jugadorPC1 = new Jugador("Jugador PC 1",tableroJugadorPC1);
        
        Naipe[][] tableroJugadorPC2 = null;
        tableroIgual = true;
        while(tableroIgual)
        {             
            tableroJugadorPC2 = Helper.HelperJuego.generarTableroJugador();
            if(!tableroJugadorPC1.equals(tableroJugadorPC2))
                tableroIgual = false;
        }                
        Jugador jugadorPC2 = new Jugador("Jugador PC 2",tableroJugadorPC2);
                
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorHumano);
        jugadores.add(jugadorPC1);
        jugadores.add(jugadorPC2);
        
        ArrayList<Naipe> masoJuego = Helper.HelperJuego.generarMasoNaipes();        
        Juego juego = new Juego(jugadores,alineacionGanadora,masoJuego);   
        System.out.println("termino el proceso");
        mostrarPanelJuego(juego);
    }
    
    public void mostrarPanelJuego(Juego juego)
    {
        try
        {
            //Muestra la pantalla del juego comenzado
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PantallaJuego.fxml"));     
            Parent root = (Parent)fxmlLoader.load();                  
            PantallaJuegoController controlador = fxmlLoader.<PantallaJuegoController>getController();                                
            controlador.cargarJuego(juego);
            Stage stage = new Stage();
            stage.setTitle("Juego Comenzado");
            stage.setScene(new Scene(root, 1050, 600));
            stage.show();  
            Stage stageActual = (Stage) txt_NombreJugador.getScene().getWindow();            
            stageActual.close();            
        }
        catch(Exception e)
        {
                       
        }
        
    }
}
