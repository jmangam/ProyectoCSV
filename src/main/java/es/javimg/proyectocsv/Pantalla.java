
package es.javimg.proyectocsv;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class Pantalla {
    static TextArea textarea = new TextArea();
    static String textoGuardar;
    public static void itemsPantalla(VBox root){
        
        root.setSpacing(10);
        Label label = new Label("Elige un año del 1970 al 2017 para saber el numero de muertes por terrorismo mundialmente");
        TextField textfield = new TextField();
            textfield.setMinWidth(50);
            textfield.setMaxWidth(50);
        Button buttonvisualizar = new Button("Visualizar");
            textarea.setMaxWidth(300);
            textarea.setMinWidth(300);
        root.getChildren().addAll(label, textfield, buttonvisualizar, textarea); //añade por pantalla los elementos creados anteriormente
        buttonvisualizar.setOnAction((t) -> {
            int añoSeleccionado;
            añoSeleccionado = Integer.valueOf(textfield.getText());
            UtilCSV.leerContenido(añoSeleccionado);
            textarea.setText("Numero de muertes en el " + textfield.getText() + ": " + String.valueOf(UtilCSV.muertestotales) + " muertos");
            UtilCSV.borrarContenidoMuertes();
        });
        Button buttonguardar = new Button("Guardar Contenido");
        buttonguardar.setOnAction((t) -> {
             
            textoGuardar = textarea.getText();
            UtilCSV.guardarContenido();
        });
        root.getChildren().add(buttonguardar);

    }
            
}
