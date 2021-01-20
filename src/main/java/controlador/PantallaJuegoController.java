package controlador;

import Helper.HelperJuego;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Alineacion;
import modelo.Configuracion;
import modelo.Juego;
import modelo.Jugador;
import modelo.Naipe;
import modelo.Reporte;

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
    int ordenNaipe = 1;
    Naipe naipeActual;  
    Alineacion alineacionGanadora;
    double coordenadaX,coordenadaY; 
    int jugadorActual = 1;
    static int interval;
    static Timer timer;
    
    Naipe[][] tableroJugadorHumano = new Naipe[4][4];
    Naipe[][] tableroJugadorPC1 = new Naipe[4][4];
    Naipe[][] tableroJugadorPC2 = new Naipe[4][4];
    Naipe[][] tableroActual = new Naipe[4][4];
    
    Jugador jugadorHumano;
    Jugador jugadorPC1;
    Jugador jugadorPC2;
    String imgURL;    
    Naipe naipeSeleccionado;
    Date horaInicio;
    Date horaFin;
    int cantJugadores;
    int cantOponentes;
    boolean visibilidadCartasOponentes;
    Configuracion configuracion;    
        
    @FXML
    private Label lbl_tablero_actual;
    private Button btn_Computadador;
    @FXML
    private Button btn_ComputadadorPC2;
    @FXML
    private Button btn_ComputadadorPC21;
    @FXML
    private Button btn_ComputadadorPC211;
    @FXML
    private Label lbl_tiempo_regresivo;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Metodo que se encarga de cargar los datos del juego que se va a ejecutar
     public void cargarJuego(Juego juego) 
    {
        horaInicio = new Date();
        juegoActual = juego;
        cantJugadores = juegoActual.getJugadores().size();
        
        configuracion = HelperJuego.getConfiguracion();        
        alineacionGanadora = juegoActual.getAlineacion();
        jugadorHumano = juegoActual.getJugadores().get(0);
        tableroJugadorHumano = jugadorHumano.getTablero();

        jugadorPC1 = juegoActual.getJugadores().get(1);
        tableroJugadorPC1 = jugadorPC1.getTablero();
                
        if(cantJugadores > 2)
        {
            jugadorPC2 = juegoActual.getJugadores().get(2);
            tableroJugadorPC2 = jugadorPC2.getTablero();
        }
        
        //Obtiene la configuracion del maso barajado
        masoNaipe = juegoActual.getMasoNaipes();
        
        //Obtiene el naipe actual en curso 
        naipeActual = masoNaipe.get(0);    
        
        //Setea como tablero inicial el tablero del humano
        tableroActual = tableroJugadorHumano;     
        
        cargarConfiguracion();
        cargarDatosJuego();
        iniciarConteoRegresivoNaipe();  
    }
    

    @FXML
    private void accionMostrarTableroJugador(ActionEvent event) 
    {
        jugadorActual = 1;
        //Cargar los datos del tablero del Jugador Humano
        tableroActual = tableroJugadorHumano;
        cargarImagenesTablero(juegoActual.getJugadores().get(0).getTablero());
        lbl_tablero_actual.setText("Tablero "+jugadorHumano.getNombre());        
    }

    @FXML
    private void accionMostrarTableroComputador(ActionEvent event) 
    {
        jugadorActual = 2;
        //Cargar los datos del tablero del Jugador PC 1
        tableroActual = tableroJugadorPC1;
        cargarImagenesTablero(juegoActual.getJugadores().get(1).getTablero());
        lbl_tablero_actual.setText("Tablero "+jugadorPC1.getNombre());
        
    }
    
    @FXML
    private void accionMostrarTableroComputador2(ActionEvent event) 
    {
        jugadorActual = 3;
        //Cargar los datos del tablero del Jugador PC 2
        tableroActual = tableroJugadorPC2;
        cargarImagenesTablero(juegoActual.getJugadores().get(2).getTablero());
        lbl_tablero_actual.setText("Tablero "+jugadorPC2.getNombre());
                
    }

    @FXML
    private void accionCambiarNaipe(ActionEvent event) 
    {
        cambiarNaipe();        
    }
    
    public void cargarDatosJuego()
    {
        //Cargar la foto de alineacion ganadora
        String alineacionURL = Helper.HelperJuego.getAlineacionGanadora(juegoActual.getAlineacion());        
        cargarImagenAlineacion("src/main/resources/formaGanar/"+alineacionURL);
        lbl_tablero_actual.setText("Tablero "+jugadorHumano.getNombre());
        
        //Cargar los datos del tablero del Jugador Humano
        cargarImagenesTablero(juegoActual.getJugadores().get(0).getTablero());  
        juegoActual.setNaipeActual(masoNaipe.get(0));
        cargarImagenNaipeActual();
    }
    
    public void cargarConfiguracion()
    {
        cantOponentes = configuracion.getMaxCantOponentes() + 1;
        System.out.println("cantOponentes=>"+cantOponentes);
        visibilidadCartasOponentes = configuracion.isVisibilidadNaipe();        
        if(cantOponentes == 3)
            btn_ComputadadorPC2.setVisible(true);        
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
       
    //Carga las imagenes del tablero de juego
    public void cargarImagenesTablero(Naipe[][] tablero)
    {
        //Primera Fila
       img_NaipeTablero_1.setImage(tablero[0][0].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_1.setFitWidth(101);
       img_NaipeTablero_1.setFitHeight(116);        
       
       img_NaipeTablero_2.setImage(tablero[0][1].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_2.setFitWidth(101);
       img_NaipeTablero_2.setFitHeight(116);
       
       img_NaipeTablero_3.setImage(tablero[0][2].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_3.setFitWidth(101);
       img_NaipeTablero_3.setFitHeight(116);
       
       img_NaipeTablero_4.setImage(tablero[0][3].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_4.setFitWidth(101);
       img_NaipeTablero_4.setFitHeight(116);
       
       //Segunda Fila
       img_NaipeTablero_5.setImage(tablero[1][0].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_5.setFitWidth(101);
       img_NaipeTablero_5.setFitHeight(116);
       
       img_NaipeTablero_6.setImage(tablero[1][1].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_6.setFitWidth(101);
       img_NaipeTablero_6.setFitHeight(116);
       
       img_NaipeTablero_7.setImage(tablero[1][2].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_7.setFitWidth(101);
       img_NaipeTablero_7.setFitHeight(116);
       
       img_NaipeTablero_8.setImage(tablero[1][3].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_8.setFitWidth(101);
       img_NaipeTablero_8.setFitHeight(116);
       
       //Tercera fila
       img_NaipeTablero_9.setImage(tablero[2][0].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_9.setFitWidth(101);
       img_NaipeTablero_9.setFitHeight(116);
       
       img_NaipeTablero_10.setImage(tablero[2][1].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_10.setFitWidth(101);
       img_NaipeTablero_10.setFitHeight(116);
       
       img_NaipeTablero_11.setImage(tablero[2][2].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_11.setFitWidth(101);
       img_NaipeTablero_11.setFitHeight(116);
       
       img_NaipeTablero_12.setImage(tablero[2][3].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_12.setFitWidth(101);
       img_NaipeTablero_12.setFitHeight(116);
       
       //Cuarta Fila
       img_NaipeTablero_13.setImage(tablero[3][0].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_13.setFitWidth(101);
       img_NaipeTablero_13.setFitHeight(116);
       
       img_NaipeTablero_14.setImage(tablero[3][1].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_14.setFitWidth(101);
       img_NaipeTablero_14.setFitHeight(116);
       
       img_NaipeTablero_15.setImage(tablero[3][2].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_15.setFitWidth(101);
       img_NaipeTablero_15.setFitHeight(116);
       
       img_NaipeTablero_16.setImage(tablero[3][3].getImagenNaipe(jugadorActual,visibilidadCartasOponentes));
       img_NaipeTablero_16.setFitWidth(101);
       img_NaipeTablero_16.setFitHeight(116);
    }
    
    //Dependiendo del numero de la carta se va a ir mostrando un naipe
    public void cargarNaipeActual()
    {
        if(ordenNaipe < 54)
        {
            juegoActual.setNaipeActual(masoNaipe.get(ordenNaipe));
            naipeActual = juegoActual.getNaipeActual();    
            System.out.println("NaipeActual=>"+naipeActual.getNombre());
        }
    }
    
    public void cargarImagenNaipeActual()
    {
        img_NaipeActual.setImage(naipeActual.getImagenNaipe(jugadorActual,true));
        img_NaipeActual.setFitWidth(220);
        img_NaipeActual.setFitHeight(300);              
    }
    
    
    public Image cargarImagenFrejol(String imgURL)
    {
        String url = "src/main/resources/imagenesNaipe/"+imgURL;
        File file;
        file = new File(url);
        Image  image = new Image(file.toURI().toString());
        return image;        
    }
    
    
    //Cada una de las imagenes tiene asociado un evento onclick
    @FXML
    private void accionNaipe1(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[0][0];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
                
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_1.setImage(cargarImagenFrejol(imgURL));
            tableroActual[0][0].setEsSeleccionado(true);            
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe2(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[0][1];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_2.setImage(cargarImagenFrejol(imgURL));
            tableroActual[0][1].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe3(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[0][2];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
                
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_3.setImage(cargarImagenFrejol(imgURL));
            tableroActual[0][2].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe4(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[0][3];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_4.setImage(cargarImagenFrejol(imgURL));
            tableroActual[0][3].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe5(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[1][0];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_5.setImage(cargarImagenFrejol(imgURL));
            tableroActual[1][0].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe6(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[1][1];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_6.setImage(cargarImagenFrejol(imgURL));
            tableroActual[1][1].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe7(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[1][2];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_7.setImage(cargarImagenFrejol(imgURL));
            tableroActual[1][2].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe8(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[1][3];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_8.setImage(cargarImagenFrejol(imgURL));
            tableroActual[1][3].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe9(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[2][0];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_9.setImage(cargarImagenFrejol(imgURL));
            tableroActual[2][0].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe10(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[2][1];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_10.setImage(cargarImagenFrejol(imgURL));
            tableroActual[2][1].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe11(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[2][2];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_11.setImage(cargarImagenFrejol(imgURL));
            tableroActual[2][2].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe12(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[2][3];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_12.setImage(cargarImagenFrejol(imgURL));
            tableroActual[2][3].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe13(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[3][0];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_13.setImage(cargarImagenFrejol(imgURL));
            tableroActual[3][0].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe14(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[3][1];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_14.setImage(cargarImagenFrejol(imgURL));
            tableroActual[3][1].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe15(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[3][2];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_15.setImage(cargarImagenFrejol(imgURL));
            tableroActual[3][2].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }

    @FXML
    private void accionNaipe16(MouseEvent event) 
    {
        actualizarTablero();
        naipeSeleccionado = tableroActual[3][3];
        if(naipeSeleccionado.isEsSeleccionado())
            return;
        
        System.out.println("NaipeActual=> ("+naipeActual.getNombre()+" naipeseleccionado=>"+naipeSeleccionado.getNombre());
        if(HelperJuego.validarNaipeSeleccionado(naipeSeleccionado.getNumero(),naipeActual.getNumero()))
        {
            imgURL = jugadorActual == 1  ? naipeSeleccionado.getNumero()+"seleccionado.png" : "match.png" ;
            img_NaipeTablero_16.setImage(cargarImagenFrejol(imgURL));
            tableroActual[3][3].setEsSeleccionado(true); 
            actualizarTablero();
        }
        else       
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Validar Naipe",null,"Naipe seleccionado es el incorrecto!");                                             
    }
    
    //Actualiza el tablero de juego dependiendo de que tablero se esta viendo
    public void actualizarTablero()
    {
        System.out.println("Jugador Actual==>"+jugadorActual);
        switch(jugadorActual)
        {
            case 1:
                tableroJugadorHumano = tableroActual;
                break;
                
            case 2:
                tableroJugadorPC1 = tableroActual;
                break;
            
            case 3:
                tableroJugadorPC2 = tableroActual;
                break;
        }
      
    }

    @FXML
    private void accionVerificarLoteria(ActionEvent event) throws Exception
    {
        if(HelperJuego.verificarJuegoGanado(tableroActual,alineacionGanadora))
        {
            Jugador jugador = null;
            if(jugadorActual == 1)
                jugador = jugadorHumano;
            else if(jugadorActual == 2)
                jugador = jugadorPC1;
            else if(jugadorActual == 3) 
                jugador = jugadorPC2;
            
            horaFin = new Date();
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.INFORMATION),"Loteria.. ",null,"Usted ha ganado!");                                             
            long diferenciaTiempo = horaFin.getTime() - horaInicio.getTime();    
            int minutos = (int)diferenciaTiempo / (60 * 1000);
            Reporte reporte = new Reporte(horaFin,minutos,jugador.getNombre(),cantOponentes,alineacionGanadora.name());
            Reporte.guardarReporte(reporte);
            Stage stageActual = (Stage) lbl_tablero_actual.getScene().getWindow();            
            stageActual.close(); 
        }
        else        
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Error.. ",null,"Usted no ha ganado, favor continue con su juego!");                                                     
    }  
    
    //Permite iniciar el conteo regresivo del naipe que se va a mostrar
    private void iniciarConteoRegresivoNaipe()
    {
        interval = 4;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if(interval > 0)
                {
                    Platform.runLater(() -> mostrarConteoRegresivo(interval));                    
                    interval--;
                }
                else
                {
                    timer.cancel();
                    Platform.runLater(() -> cambiarNaipe());
                }                    
            }
        }, 1000,1000);
    }
    
    private void mostrarConteoRegresivo(int interval)
    {
        lbl_tiempo_regresivo.setText(String.valueOf(interval));
    }
    
    //Cambia el naipe que se va mostrando cada 3 segundos
    private void cambiarNaipe()
    {        
        //Evita regresar al mismo naipe
        if(ordenNaipe < 54)
        {                        
            ordenNaipe++;           
            cargarNaipeActual();
            cargarImagenNaipeActual();
            iniciarConteoRegresivoNaipe();
        }
        else
            Helper.HelperJuego.showMessage(new Alert(Alert.AlertType.ERROR),"Mensaje del Sistema.. ",null,"Se han acabado los naipes!");                                                     
    }
}
