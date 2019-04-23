package org.o7planning.javafx;
 
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MyController implements Initializable {
 
   @FXML
   private Button myButton;
  
   @FXML
   private TextField myTextField;
  
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   // When user click on myButton
   // this method will be called.
   public void showDateTime(ActionEvent event) {
       System.out.println("Boton Clickeado!");
       
       
       String ip = "ipconfig";
       String pingResult = "";

       // Contiene la instruccion a ejecutar...
       // Esta instruccion podria ser cambiada por cualquier otra
       String pingCmd =ip;

       try
       {
           Runtime r = Runtime.getRuntime();
           Process p = r.exec(pingCmd);

           // Inicializa el lector del buffer
           BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

           String inputLine;
           // Bucle mientas reciba parametros del buffer
           while ((inputLine = in.readLine()) != null)
           {
               // Muestra por pantalla cada una de las lineas que recibe
               System.out.println(inputLine);
               // Si deseamos capturar el resultado para posteriormente
               // utilizarlo en nuestra aplicacion
               pingResult += inputLine;
           }
           in.close();
       } catch (IOException e) {
           System.out.println(e);
       }
      
       Date now= new Date();
      
       DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
      
      
        // Model Data
        String dateTimeString = df.format(now);
        
        // Show in VIEW
        myTextField.setText(dateTimeString);
        
        // Ejecuto comando 
    
      
   }
  
}