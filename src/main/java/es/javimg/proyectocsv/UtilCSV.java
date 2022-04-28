
package es.javimg.proyectocsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class UtilCSV {
    
    static int muertestotales = 0;
    
    public static void leerContenido(int añoSeleccionado){// metodo que se encarga de leer el archivo csv
    String nombreFichero = "fatalities-from-terrorism.csv";
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            String texto = br.readLine();
            texto = br.readLine();
            // Repetir mientras no se llegue al final del fichero
            while(texto != null) {
                String[] valores = texto.split(",");
                Victimas victimas = new Victimas();
                victimas.setAño(Integer.valueOf(valores[3]));
                int muertes = Integer.valueOf(valores[3]);
                int año = Integer.valueOf(valores[2]);
                if( año == añoSeleccionado)
                    muertestotales = muertestotales + victimas.getAño();
                texto = br.readLine();
            }
            System.out.println("Numero de muertes en el año:" + String.valueOf(muertestotales));
            
            
        }
        // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    }
    public static void guardarContenido(){ // fichero que guarda el resultado del textarea a un fichero csv
        String nombreFichero = "Numero de muertes.csv";
        String texto = Pantalla.textoGuardar;
        BufferedWriter bw = null;
        
        try {
        //Crear un objeto BufferedWriter. Si ya existe el fichero, 
        //  se borra automáticamente su contenido anterior.
            bw = new BufferedWriter(new FileWriter(nombreFichero));
        //Escribir en el fichero el texto con un salto de línea
            bw.write(texto + "\n");
        }
// Comprobar si se ha producido algún error
        catch(Exception ex) {
            System.out.println("Error de escritura del fichero");
            ex.printStackTrace();
        }
    // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(bw != null)
                    bw.close();
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        } 
    }
    public static void borrarContenidoMuertes(){ //metodo que borra la variable contenidomuertes
        muertestotales = 0;
    }
}
