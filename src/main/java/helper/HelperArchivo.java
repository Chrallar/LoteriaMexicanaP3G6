package helper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HelperArchivo 
{
    
    public static String rutaGeneral = Paths.get("").toAbsolutePath().toString();
    public static String rutaArchivo = rutaGeneral+"/src/main/java/archivo";    

    //Permite leer las lineas que provienen del archivo 
    public static ArrayList<String> leerLineasArchivo(String name)
    {    
        ArrayList<String> lineasArchivo = new ArrayList<>();        
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader(name));
            String line = reader.readLine();
            while (line != null) 
            {    
                lineasArchivo.add(line);
                // read next line
                line = reader.readLine();                
            }
            reader.close();
        } catch (IOException e) {
                e.printStackTrace();
        }     
        return lineasArchivo;                 
    }
    
}
