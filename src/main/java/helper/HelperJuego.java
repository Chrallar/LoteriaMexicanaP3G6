package Helper;

import java.io.File;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import modelo.Alineacion;
import modelo.Configuracion;
import modelo.Jugador;
import modelo.Naipe;
import modelo.Reporte;

public class HelperJuego {        
    
    //Permite convertir la fecha de tipo String a Date para ser guardada en el archivo
    public static Date StringToDateTime(String fecha)
    {        
        try {  
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return new Date();
    }
    
    //Permite convertir la fecha de tipo Date a String para ser guardada en el archivo
    public static String dateTimeToString(Date fecha)
    {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(fecha);
    }
    
    public static ArrayList<Reporte> consultarReportesFecha(Date fechaInicio, Date fechaFin)
    {
        ArrayList<Reporte> reportes = new ArrayList<>();
        ArrayList<Reporte> reportesTemp = Reporte.desserializarReporte("Reporte.ser");
        for(Reporte reporte: reportesTemp)
        {
            if(reporte.getFechaReporte().after(fechaInicio) && reporte.getFechaReporte().before(fechaFin))
                reportes.add(reporte);
        }
        return reportes;
    }
    
    public static void showMessage(Alert show, String titulo, String encabezado, String mensaje){
        show.setHeaderText(encabezado);
        show.setTitle(titulo);
        show.setContentText(mensaje);
        show.showAndWait();
    }
    
    public static Alineacion generarAlineacionGanadora()
    {
        Alineacion alineacionGanadora;
        ArrayList<Alineacion> listaAlineaciones = new ArrayList<>();
        listaAlineaciones.add(Alineacion.FIGURAS_EN_UNA_FILA);
        listaAlineaciones.add(Alineacion.FIGURAS_EN_UNA_COLUMNA);
        listaAlineaciones.add(Alineacion.FIGURAS_EN_LAS_ESQUINAS);
        listaAlineaciones.add(Alineacion.FIGURAS_JUNTAS_EN_CUALQUIER_ESQUINA);  
        
        //Generar alineacion al azar
        int indiceAlineacion = new Random().nextInt(3);
        alineacionGanadora = listaAlineaciones.get(indiceAlineacion);        
        return alineacionGanadora;        
    }
    
    public static String getAlineacionGanadora(Alineacion alineacion)
    {
        switch(alineacion)
        {
            case FIGURAS_EN_UNA_FILA:
                return "cualquierfila.png";                
                
            case FIGURAS_EN_UNA_COLUMNA:
                return "cualquiercolumna.png";
             
            case FIGURAS_EN_LAS_ESQUINAS:
                return "figurasenextremos.png";
                
            case FIGURAS_JUNTAS_EN_CUALQUIER_ESQUINA:
                return "figurasjuntasenesquina";
        }
        return "";
    }   

    public static Naipe[][] generarTableroJugador()
    {
        Naipe[][] tablero = new Naipe[4][4];
        ArrayList<Naipe> listaNaipes = getListaNaipes();                
        ArrayList<Integer> listaIndices = new ArrayList<>();
        int indice = 0, indiceNaipe;
        while(indice <= 15)
        {
            indiceNaipe = new Random().nextInt(53);
            if(!listaIndices.contains(indiceNaipe))
            {
                listaIndices.add(indiceNaipe);
                indice++;
            }
        }
        
        tablero[0][0] = listaNaipes.get(listaIndices.get(0));
        tablero[0][1] = listaNaipes.get(listaIndices.get(1));
        tablero[0][2] = listaNaipes.get(listaIndices.get(2));
        tablero[0][3] = listaNaipes.get(listaIndices.get(3));
        
        tablero[1][0] = listaNaipes.get(listaIndices.get(4));
        tablero[1][1] = listaNaipes.get(listaIndices.get(5));
        tablero[1][2] = listaNaipes.get(listaIndices.get(6));
        tablero[1][3] = listaNaipes.get(listaIndices.get(7));
        
        tablero[2][0] = listaNaipes.get(listaIndices.get(8));
        tablero[2][1] = listaNaipes.get(listaIndices.get(9));
        tablero[2][2] = listaNaipes.get(listaIndices.get(10));
        tablero[2][3] = listaNaipes.get(listaIndices.get(11));
        
        tablero[3][0] = listaNaipes.get(listaIndices.get(12));
        tablero[3][1] = listaNaipes.get(listaIndices.get(13));
        tablero[3][2] = listaNaipes.get(listaIndices.get(14));
        tablero[3][3] = listaNaipes.get(listaIndices.get(15));
        
        for(int i = 0; i < 4;i++)        
            for(int j = 0 ; j < 4; j++)           
                System.out.println(tablero[i][j].getNombre());                    
                                                        
        return tablero;        
    }
    
    public static ArrayList<Naipe> getListaNaipes()
    {
        String rutaNaipes = helper.HelperArchivo.rutaArchivo+"/"+"cartasloteria.csv";
        ArrayList<Naipe> naipes = new ArrayList<>();
        ArrayList<String> listaNaipes =  helper.HelperArchivo.leerLineasArchivo(rutaNaipes);
        for(String naipeString : listaNaipes)
        {
            String[] naipePart    = naipeString.split(",");
            String numero         = naipePart[0];
            String nombreNaipe    = naipePart[1];
            
            String urlImagen = numero+".png";
            String urlImagenSeleccionado = numero+"seleccionado.png";
            String urlImagenSeleccionadoPC = "match.png";
            String urlImagenOcultaPC = "back.png";
            
            Image imagenNaipe = getImagenNaipe(urlImagen);
            Image imagenNaipeSeleccionado = getImagenNaipe(urlImagenSeleccionado);
            Image imagenNaipeSeleccionadoPC = getImagenNaipe(urlImagenSeleccionadoPC);
            Image imagenNaipeOcultoPC = getImagenNaipe(urlImagenOcultaPC);
            naipes.add(new Naipe(
                                    Integer.parseInt(numero),
                                    nombreNaipe,
                                    urlImagen,
                                    imagenNaipe,
                                    imagenNaipeSeleccionado,
                                    imagenNaipeSeleccionadoPC,
                                    imagenNaipeOcultoPC));            
        }                
        return naipes;
    }
    
    public static Image getImagenNaipe(String imagenURL)
    {
        //Cargar la imagen del naipe
        File file;
        file = new File("src/main/resources/imagenesNaipe/"+imagenURL);
        Image  image = new Image(file.toURI().toString());        
        return image;
    } 
    
    public static ArrayList generarMasoNaipes()
    {
        ArrayList<Naipe> listaNaipes = getListaNaipes();      
        Collections.shuffle(listaNaipes);
        return listaNaipes;
    }
    
    public static boolean validarNaipeSeleccionado(int naipeSeleccionado, int naipeActual)
    {
        boolean estadoNaipeSeleccionado = false;
        if(naipeSeleccionado == naipeActual)
            estadoNaipeSeleccionado = true;
        return estadoNaipeSeleccionado;
    }
    
    public static boolean verificarJuegoGanado(Naipe[][] tablero, Alineacion alineacion)
    {        
        switch(alineacion)
        {
            case FIGURAS_EN_UNA_FILA:
                return validarGanadorEnFila(tablero);
                
                case FIGURAS_EN_UNA_COLUMNA:
                    return validarGanadorEnColumna(tablero);
                
                case FIGURAS_EN_LAS_ESQUINAS:
                    return validarGanadorEnEsquinas(tablero);
                
                case FIGURAS_JUNTAS_EN_CUALQUIER_ESQUINA:
                    return validarCuatroFigurasEnEsquina(tablero);                                
        }
        return false;
    }
    
    public static boolean validarGanadorEnFila(Naipe[][] tablero)
    {
        boolean primeraFila = tablero[0][0].isEsSeleccionado() && 
                              tablero[0][1].isEsSeleccionado() && 
                              tablero[0][2].isEsSeleccionado() && 
                              tablero[0][3].isEsSeleccionado(); 
        
        boolean segundaFila = tablero[1][0].isEsSeleccionado() && 
                              tablero[1][1].isEsSeleccionado() && 
                              tablero[1][2].isEsSeleccionado() && 
                              tablero[1][3].isEsSeleccionado();

        boolean terceraFila = tablero[2][0].isEsSeleccionado() && 
                              tablero[2][1].isEsSeleccionado() && 
                              tablero[2][2].isEsSeleccionado() && 
                              tablero[2][3].isEsSeleccionado();        
                
        boolean CuartaFila = tablero[3][0].isEsSeleccionado() && 
                             tablero[3][1].isEsSeleccionado() && 
                             tablero[3][2].isEsSeleccionado() && 
                             tablero[3][3].isEsSeleccionado();        
        
        return primeraFila || segundaFila || terceraFila || CuartaFila;
    }
    
    public static boolean validarGanadorEnColumna(Naipe[][] tablero)
    {
        boolean primeraColumna = tablero[0][0].isEsSeleccionado() && 
                                 tablero[1][0].isEsSeleccionado() && 
                                 tablero[2][0].isEsSeleccionado() && 
                                 tablero[3][0].isEsSeleccionado(); 
        
        boolean segundaColumna = tablero[0][1].isEsSeleccionado() && 
                                 tablero[1][1].isEsSeleccionado() && 
                                 tablero[2][1].isEsSeleccionado() && 
                                 tablero[3][1].isEsSeleccionado();

        boolean terceraColumna = tablero[0][2].isEsSeleccionado() && 
                                 tablero[1][2].isEsSeleccionado() && 
                                 tablero[2][2].isEsSeleccionado() && 
                                 tablero[2][3].isEsSeleccionado();        
                
        boolean CuartaColumna = tablero[0][3].isEsSeleccionado() && 
                                tablero[1][3].isEsSeleccionado() && 
                                tablero[2][3].isEsSeleccionado() && 
                                tablero[3][3].isEsSeleccionado();        
        
        return primeraColumna || segundaColumna || terceraColumna || CuartaColumna;
    }
    
    public static boolean validarGanadorEnEsquinas(Naipe[][] tablero)
    {
        boolean primeraEsquina = tablero[0][0].isEsSeleccionado();         
        boolean segundaEsquina = tablero[0][3].isEsSeleccionado();
        boolean terceraEsquina = tablero[3][0].isEsSeleccionado();
        boolean cuartaEsquina  = tablero[3][3].isEsSeleccionado();
        
        return primeraEsquina && segundaEsquina && terceraEsquina && cuartaEsquina;
    }
    
    public static boolean validarCuatroFigurasEnEsquina(Naipe[][] tablero)
    {
        boolean primeraGrupo = tablero[0][0].isEsSeleccionado() && 
                               tablero[0][1].isEsSeleccionado() && 
                               tablero[1][0].isEsSeleccionado() && 
                               tablero[1][1].isEsSeleccionado(); 
        
        boolean segundoGrupo = tablero[0][2].isEsSeleccionado() && 
                               tablero[0][3].isEsSeleccionado() && 
                               tablero[1][2].isEsSeleccionado() && 
                               tablero[1][3].isEsSeleccionado();

        boolean tercerGrupo  = tablero[2][0].isEsSeleccionado() && 
                               tablero[2][1].isEsSeleccionado() && 
                               tablero[3][0].isEsSeleccionado() && 
                               tablero[3][1].isEsSeleccionado();        
                
        boolean CuartoGrupo  = tablero[2][2].isEsSeleccionado() && 
                               tablero[2][3].isEsSeleccionado() && 
                               tablero[3][2].isEsSeleccionado() && 
                               tablero[3][3].isEsSeleccionado();        
        
        return primeraGrupo || segundoGrupo || tercerGrupo || CuartoGrupo;
    }
    
    public static Configuracion getConfiguracion()
    {         
        return Configuracion.desserializarConfiguracion("Configuracion.ser");
    }
}
