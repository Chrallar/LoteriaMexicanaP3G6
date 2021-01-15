package Helper;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javafx.scene.control.Alert;
import modelo.Alineacion;
import modelo.Ficha;
import modelo.Jugador;
import modelo.Reporte;

public class HelperJuego {
    
    public static Ficha cargarImagenNaipe(String path)
    {
        Ficha ficha = new Ficha();
        return ficha;
    }
    
    public static Ficha cargarImagenFicha(String path)
    {
        Ficha ficha = new Ficha();
        return ficha;
    }
        
    public static void cargarReportes()
    {
        try
        {
            Jugador jugador;
            Reporte reporte;           

            jugador = new Jugador("Jonathan");            
            reporte = new Reporte(StringToDateTime("2020-01-13 09:12:20"),10,jugador,1,"Linea Vertical");            
            Reporte.guardarReporte(reporte);

            jugador = new Jugador("Josue");
            reporte = new Reporte(StringToDateTime("2020-01-13 12:12:20"),10,jugador,1,"Linea Horizontal");
            Reporte.guardarReporte(reporte);            

            jugador = new Jugador("Luis");
            reporte = new Reporte(StringToDateTime("2020-01-13 16:12:20"),10,jugador,1,"Diagonal Principal");        
            Reporte.guardarReporte(reporte);            
        }
        catch(Exception e)
        {
            
        }
    }
    
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
}
