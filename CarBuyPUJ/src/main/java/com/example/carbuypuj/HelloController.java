package com.example.carbuypuj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;



    public void loginButtonOnAction(ActionEvent e){

        if (usernameTextField.getText().isBlank() == false && passwordField.getText().isBlank() == false){

            //loginMessageLabel.setText("Trebate se prijavit!");
            validateLogin();

        }else {

            loginMessageLabel.setText("Unesite korisnicko ime i lozinku");
        }
    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){

        DatabaseConn connectNow = new DatabaseConn();
        Connection connectDB = connectNow.getConnection();
        String verifyLogin = "SELECT COUNT(1) FROM Users WHERE UserName = '"+ usernameTextField.getText() +"' AND Password = '"+ passwordField.getText() +"'";
        try {

            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(verifyLogin);
            while (resultSet.next()){
                if (resultSet.getInt(1) == 1){
                    loginMessageLabel.setText("Dobro dosli");

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("productsearch.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1080, 600);
                    Stage stage = new Stage();
                    stage.setTitle("Pretrazivanje automobila!");
                    stage.setScene(scene);
                    stage.show();
                }else {
                    loginMessageLabel.setText("Greska pokusajte ponovo");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}