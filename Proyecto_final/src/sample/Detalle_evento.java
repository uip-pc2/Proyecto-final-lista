package sample;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import java.awt.TextField;
import java.io.IOException;
import java.time.LocalDate;

public class Detalle_evento {

    @FXML
    DatePicker dia_even;
    @FXML
    TextField tex_evento;
    @FXML
    TextField tex_cantidad;
    @FXML
    Button btn_siguiente;

    public void Tipo_evento() {
        TextField evento = tex_evento;

        return;
    }

    public TextField getTex_cantidad() {
        return tex_cantidad;
    }

    public void Cantidad_personas() {
     int max = Integer.parseInt(String.valueOf(tex_cantidad));
     try {
         if (max <= -1000000) {
             Alert alerta = new Alert(Alert.AlertType.ERROR);
             alerta.setTitle("Error de Aplicacion");
             alerta.setHeaderText("Mira, hubo un error...");
             alerta.setContentText("Lo siento. solo son numeros positivos.");
             alerta.showAndWait();
             Platform.exit();
         }
         }
         catch (NullPointerException e){
             Alert alerta = new Alert(Alert.AlertType.ERROR);
             alerta.setTitle("Error de Aplicacion");
            // alerta.setHeaderText("Fecha incorrecta: valores nulos");
             alerta.setContentText("Intenta nuevamente.");
             alerta.showAndWait();
             return;
         }


    }

    public void Avanzar() throws IOException {
        Stage stage = (Stage) btn_siguiente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Registro_nombre.fxml"));
        Parent root = fxmlLoader.load();


        FadeTransition ft = new FadeTransition(Duration.millis(1500), root);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Fecha()
    {

        LocalDate dia = dia_even.getValue();

        try {
            if (dia.isBefore(LocalDate.now())) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error de Aplicacion");
                alerta.setHeaderText("Fecha incorrecta: no puede ser hoy");
                alerta.setContentText("Intenta nuevamente.");
                alerta.showAndWait();
                return;
            }
        } catch (NullPointerException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de Aplicacion");
            alerta.setHeaderText("Fecha incorrecta: valores nulos");
            alerta.setContentText("Intenta nuevamente.");
            alerta.showAndWait();
            return;
        }

        Stage stage = (Stage) btn_siguiente.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Registro_nombres.fxml"));
        Parent root = null;
        try {
            root = (Parent)fxmlLoader.load();
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

