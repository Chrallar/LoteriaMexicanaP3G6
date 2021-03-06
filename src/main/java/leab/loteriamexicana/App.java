package  leab.loteriamexicana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception 
    {
        scene = loadScene("PantallaPrincipal", 300, 280);
        scene = new Scene(loadFXML("PantallaPrincipal"), 300, 280);
        stage.setTitle("Juego Loteria Mexicana v1.1");
        stage.resizableProperty().setValue(Boolean.FALSE);        
        stage.setScene(scene);
        stage.show();                                
    }

    public static void setRoot(String fxml,int width, int height) throws IOException {       
        scene.setRoot(loadFXML(fxml)); 
        //scene = loadScene(fxml, width, height);
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    private static Scene loadScene(String fxml, int width, int height)throws IOException
    {
        return new Scene(loadFXML(fxml),width,height);
    }

    public static void main(String[] args) {
        launch();
    }

}