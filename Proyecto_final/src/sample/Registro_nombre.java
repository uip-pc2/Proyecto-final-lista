package sample;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Registro_nombre {

    @FXML
    TextField Nombre;
    @FXML
    TextField Cedula;
    @FXML
    Button Agregar;
    @FXML
    TextField Lista;
    @FXML
    Button btn_siguinte;

    public void Agregar(ActionEvent actionEvent) {
        String nombre = Nombre.getName();
        String cedula = Cedula.getName();
        Vector<String> vector = new Vector<String>();
        Vector<String> vector_2 = new Vector<String>();
        int x, y;


        for (x = 0; x <= 100000; x++) {
            vector.add(nombre);
            System.out.println(vector);
            for (y = 0; y <= 100000; y++) {
                vector_2.add(cedula);
                System.out.println(cedula);
            }
        }


    }

    public void Avanzar(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btn_siguinte.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Registro_nombre"));
        Parent root = fxmlLoader.load();
        try {
            root = (Parent) fxmlLoader.load();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de Aplicacion");
            alerta.setHeaderText("Mira, hubo un error...");
            alerta.setContentText("Lo siento. Llama al administrador.");
            alerta.showAndWait();
            Platform.exit();
        }
        FadeTransition ft = new FadeTransition(Duration.millis(1500), root);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}



