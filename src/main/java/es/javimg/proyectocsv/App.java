package es.javimg.proyectocsv;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pantalla pantalla = new Pantalla();
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        Pantalla.itemsPantalla(root);//llamada al metodo itemspantalla, solo se llama a este por que en el llamamos a los demas metodos necesarios
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}