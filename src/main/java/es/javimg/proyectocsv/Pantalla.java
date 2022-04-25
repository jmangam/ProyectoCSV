
package es.javimg.proyectocsv;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class Pantalla {
    
    public static void itemsPantalla(VBox root){
        
        
        TextField textfield = new TextField();
            textfield.setMinWidth(50);
            textfield.setMaxWidth(50);
        Button buttonvisualizar = new Button("Visualizar");
        TextArea textarea = new TextArea();
            textarea.setMaxWidth(300);
            textarea.setMinWidth(300);
        root.getChildren().addAll(textfield, buttonvisualizar, textarea);
        buttonvisualizar.setOnAction((t) -> {
            int añoSeleccionado;
            añoSeleccionado = Integer.valueOf(textfield.getText());
            UtilCSV.leerContenido(añoSeleccionado);
            textarea.setText("Numero de muertes en ese año es: " + String.valueOf(UtilCSV.muertestotales));
            UtilCSV.borrarContenidoMuertes();
            
        });
        
        
    }
            
}
