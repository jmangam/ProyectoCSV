
package es.javimg.proyectocsv;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class Pantalla {
    
    public void itemsPantalla(VBox root){
        
        TextField textfield = new TextField();
        Button buttonvisualizar = new Button("Visualizar");
        root.getChildren().addAll(textfield, buttonvisualizar);
        buttonvisualizar.setOnAction((t) -> {
            int añoSeleccionado;
            añoSeleccionado = Integer.valueOf(textfield.getText());
            
        });
        
    }
            
}
