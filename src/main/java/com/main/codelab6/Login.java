package com.main.codelab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Login extends Application {

    static ArrayList<User> userList = new ArrayList<>();
    static String genderLogin, nameLogin, nimLogin;

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(350, 500);
        Image background = new Image(getClass().getResource("/images/background.png").toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(background, null, null, null, null);
        borderPane.setBackground(new Background(backgroundImage));

        AnchorPane topPane = new AnchorPane();
        topPane.setPrefSize(350, 185);
        topPane.setBackground(Background.fill(Color.TRANSPARENT));

        ImageView topImageView = new ImageView(new Image(getClass().getResource("/images/image_student_login.png").toExternalForm()));
        topImageView.setFitHeight(128);
        topImageView.setFitWidth(130);
        topImageView.setLayoutX(113);
        topImageView.setLayoutY(28);
        topImageView.setPickOnBounds(true);
        topImageView.setPreserveRatio(true);

        Label topLabel = new Label("Student Login");
        topLabel.setLayoutX(92);
        topLabel.setLayoutY(155);
        topLabel.setFont(new Font("Segoe UI Bold", 25));

        topPane.getChildren().addAll(topImageView, topLabel);
        borderPane.setTop(topPane);

        AnchorPane centerPane = new AnchorPane();
        centerPane.setPrefSize(350, 200);

        Label usernameLabel = new Label("Username");
        usernameLabel.setLayoutX(77);
        usernameLabel.setLayoutY(14);
        usernameLabel.setFont(new Font("Calibri", 16));

        Label passwordLabel = new Label("Password");
        passwordLabel.setLayoutX(77);
        passwordLabel.setLayoutY(85);
        passwordLabel.setFont(new Font("Calibri", 16));

        ImageView userIcon = new ImageView(new Image(getClass().getResource("/images/vector_user.png").toExternalForm()));
        userIcon.setFitHeight(35);
        userIcon.setFitWidth(35);
        userIcon.setLayoutX(37);
        userIcon.setLayoutY(42);
        userIcon.setPickOnBounds(true);
        userIcon.setPreserveRatio(true);

        ImageView keyIcon = new ImageView(new Image(getClass().getResource("/images/vector_key.png").toExternalForm()));
        keyIcon.setFitHeight(35);
        keyIcon.setFitWidth(35);
        keyIcon.setLayoutX(37);
        keyIcon.setLayoutY(110);
        keyIcon.setPickOnBounds(true);
        keyIcon.setPreserveRatio(true);

        TextField nimField = new TextField();
        nimField.setBorder(Border.stroke(Color.TRANSPARENT));
        setColorEditTextNim(nimField, false);
        nimField.setLayoutX(81);
        nimField.setLayoutY(42);
        nimField.setPrefHeight(35);
        nimField.setPrefWidth(210);
        nimField.setPromptText("Enter your Username");
        nimField.setFont(new Font("Calibri BOLD", 16));

        PasswordField passwordField = new PasswordField();
        passwordField.setBorder(Border.stroke(Color.TRANSPARENT));
        setColorEditTextPassword(passwordField, false);
        passwordField.setLayoutX(81);
        passwordField.setLayoutY(110);
        passwordField.setPrefHeight(35);
        passwordField.setPrefWidth(210);
        passwordField.setPromptText("Enter your Password");
        passwordField.setFont(new Font(14));

        TextField showPasswordField = new TextField();
        showPasswordField.setBorder(Border.stroke(Color.TRANSPARENT));
        setColorEditTextNim(showPasswordField, true);
        showPasswordField.setLayoutX(81);
        showPasswordField.setLayoutY(110);
        showPasswordField.setPrefHeight(35);
        showPasswordField.setPrefWidth(210);
        showPasswordField.setPromptText("Enter your Password");
        showPasswordField.setFont(new Font("Calibri BOLD", 16));
        showPasswordField.setVisible(false);

        Button loginButton = new Button("Login");
        loginButton.setBackground(Background.fill(Paint.valueOf("#79606D")));
        loginButton.setLayoutX(85);
        loginButton.setLayoutY(216);
        loginButton.setPrefHeight(49);
        loginButton.setPrefWidth(179);
        loginButton.setTextFill(Color.WHITE);
        Rectangle roundedRect = new Rectangle(100, 40);
        roundedRect.setArcWidth(30);
        roundedRect.setArcHeight(30);
        loginButton.setShape(roundedRect);
        loginButton.setFont(new Font("Segoe UI Bold", 18));

        CheckBox showPasswordCheckBox = new CheckBox();
        showPasswordCheckBox.setLayoutX(264.0);
        showPasswordCheckBox.setLayoutY(119.0);
        showPasswordCheckBox.setMnemonicParsing(false);

        Label errorLabel = new Label("Label");
        errorLabel.setLayoutX(77);
        errorLabel.setLayoutY(175);
        errorLabel.setPrefHeight(18);
        errorLabel.setPrefWidth(221);
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(new Font("Segoe UI BOLD", 14));
        errorLabel.setVisible(false);

        centerPane.getChildren().addAll(usernameLabel, passwordLabel, userIcon, keyIcon, nimField, passwordField, showPasswordField, loginButton, showPasswordCheckBox, errorLabel);
        borderPane.setCenter(centerPane);

        loginButton.setOnAction(actionEvent -> {
            errorLabel.setVisible(false);
            String inputNIM = nimField.getText().trim();
            String inputPassword = "";
            if(showPasswordField.isVisible()) {
                inputPassword = showPasswordField.getText().trim();
            }else {
                inputPassword = passwordField.getText().trim();
            }

            if(inputNIM.isEmpty() || inputPassword.isEmpty()) {
                if(inputNIM.isEmpty() && inputPassword.isEmpty()) {
                    errorLabel.setText("NIM and password is empty.");
                    errorLabel.setVisible(true);
                }else if(inputNIM.isEmpty()) {
                    errorLabel.setText("NIM is empty.");
                    errorLabel.setVisible(true);
                }else {
                    errorLabel.setText("Password is empty.");
                    errorLabel.setVisible(true);
                }
            }else {
                boolean found = false;
                for (int i = 0; i < userList.size(); i++) {
                    if(userList.get(i).getNim().equals(inputNIM)) {
                        found = true;
                        String checkPW = "password" + inputNIM.substring(inputNIM.length()-3);
                        if(inputPassword.equals(checkPW)) {
                            genderLogin = userList.get(i).getGender();
                            nameLogin = userList.get(i).getName();
                            nimLogin = userList.get(i).getNim();

                            Home home = new Home();
                            home.start(primaryStage);
                            return;
                        }else {
                            errorLabel.setText("Incorrect password.");
                            errorLabel.setVisible(true);
                        }
                    }
                }
                if(!found) {
                    errorLabel.setText("NIM not found.");
                    errorLabel.setVisible(true);
                }
            }
        });

        showPasswordCheckBox.setOnAction(event -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setVisible(false);
                setColorEditTextNim(showPasswordField, true);
                showPasswordField.setVisible(true);
                showPasswordField.setText(passwordField.getText());
            } else {
                passwordField.setVisible(true);
                setColorEditTextPassword(passwordField, true);
                showPasswordField.setVisible(false);
                passwordField.setText(showPasswordField.getText());
            }
        });

        nimField.focusedProperty().addListener((obervable, oldValue, newValue) -> {
            if(newValue) {
                setColorEditTextNim(nimField, newValue);
                setColorEditTextPassword(passwordField, false);
                setColorEditTextNim(showPasswordField, false);
            }else {
                setColorEditTextNim(nimField, false);
            }
        });

        passwordField.focusedProperty().addListener((obervable, oldValue, newValue) -> {
            if(newValue) {
                setColorEditTextPassword(passwordField, newValue);
            }else {
                setColorEditTextPassword(passwordField, false);
            }
        });

        showPasswordField.focusedProperty().addListener((obervable, oldValue, newValue) -> {
            if(newValue) {
                setColorEditTextNim(showPasswordField, newValue);
            }else {
                setColorEditTextNim(showPasswordField, false);
            }
        });

        loginButton.setOnMouseEntered(mouseEvent -> {
            loginButton.setBackground(Background.fill(Paint.valueOf("#9B7C8D")));
        });

        loginButton.setOnMouseExited(mouseEvent -> {
            loginButton.setBackground(Background.fill(Paint.valueOf("#79606D")));
        });

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Login");
        primaryStage.show();
    }

    private void setColorEditTextNim(TextField textField, boolean clicked) {
        if(clicked) {
            Image backgroundUsername = new Image(getClass().getResource("/images/input_edittext_brown.png").toExternalForm());
            BackgroundImage backgroundImageUsername = new BackgroundImage(backgroundUsername, null, null, null, null);
            textField.setBackground(new Background(backgroundImageUsername));
        }else {
            Image backgroundUsername = new Image(getClass().getResource("/images/input_edittext_black.png").toExternalForm());
            BackgroundImage backgroundImageUsername = new BackgroundImage(backgroundUsername, null, null, null, null);
            textField.setBackground(new Background(backgroundImageUsername));
        }
    }

    private void setColorEditTextPassword(PasswordField passwordField, boolean clicked) {
        if(clicked) {
            Image backgroundPassword = new Image(getClass().getResource("/images/input_edittext_brown.png").toExternalForm());
            BackgroundImage backgroundImagePassword = new BackgroundImage(backgroundPassword, null, null, null, null);
            passwordField.setBackground(new Background(backgroundImagePassword));
        }else {
            Image backgroundPassword = new Image(getClass().getResource("/images/input_edittext_black.png").toExternalForm());
            BackgroundImage backgroundImagePassword = new BackgroundImage(backgroundPassword, null, null, null, null);
            passwordField.setBackground(new Background(backgroundImagePassword));
        }
    }


    public static void main(String[] args) {
        addTempUser();
        launch(args);
    }

    public static void addTempUser() {
        userList.add(new User("Muhammad Shaumi Rayyanullah", "202310370311399", "Male"));
        userList.add(new User("Evan Alfredio", "202310370311400", "Male"));
        userList.add(new User("Rhima Muthiya Qanita", "202310370311401", "Female"));
        userList.add(new User("Suryo Wisodono Prayogo", "202310370311402", "Male"));
        userList.add(new User("Chaidir Karnanda Batu Bara", "202310370311403", "Male"));
        userList.add(new User("Zaidan Kholis", "202310370311404", "Male"));
        userList.add(new User("Muhammad Bagus Al Hikma Azhar", "202310370311405", "Male"));
        userList.add(new User("Akhmad Zamri Ardani", "202310370311406", "Male"));
        userList.add(new User("Adifa Ar-Rayan", "202310370311407", "Male"));
        userList.add(new User("Muhammad Wahyudiono Putra", "202310370311408", "Male"));
        userList.add(new User("Reyvaldi Febryan Widya Utomo", "202310370311409", "Male"));
        userList.add(new User("Bintang Mars Satria Tuhu", "202310370311410", "Male"));
        userList.add(new User("Arya Affif Ramadhani", "202310370311411", "Male"));
        userList.add(new User("Dyata Lintar Akbar", "202310370311412", "Female"));
        userList.add(new User("Dhi'fan Faza Sukamto", "202310370311413", "Male"));
        userList.add(new User("Muhammad Anggara", "202310370311414", "Male"));
        userList.add(new User("Alfito Afdhan Nugraha", "202310370311415", "Male"));
        userList.add(new User("Muhammad Zaky Praditama", "202310370311416", "Male"));
        userList.add(new User("Siti Zahwa Nabila Putri", "202310370311417", "Female"));
        userList.add(new User("Panuel Giban", "202310370311418", "Male"));
        userList.add(new User("Ahmad Andik Septian Qomarudin", "202310370311419", "Male"));
        userList.add(new User("Muhammad Wilky", "202310370311420", "Male"));
        userList.add(new User("Leandra Chelsea Geovani Karyono", "202310370311421", "Male"));
        userList.add(new User("Muhammad Dzaky Hari Fitra", "202310370311422", "Male"));
        userList.add(new User("Zidane Amir", "202310370311423", "Male"));
        userList.add(new User("Mohammad Faiz Ulil Albab", "202310370311424", "Male"));
        userList.add(new User("Rima Marsya Putri Sabrina", "202310370311425", "Female"));
        userList.add(new User("Raditya Zeliq Amanda", "202310370311426", "Male"));
        userList.add(new User("Tengku Rabbani Fitrah Jayakaton", "202310370311427", "Male"));
        userList.add(new User("Nabila Nabatan Hasana", "202310370311429", "Female"));
        userList.add(new User("Achmad Rizqy Nur", "202310370311430", "Male"));
        userList.add(new User("Sabian Franstiawan Wahyu Bagaskara", "202310370311431", "Male"));
        userList.add(new User("Nawaf Sulaiman Al Hunaiti", "202310370311433", "Male"));
        userList.add(new User("M. Dava Arya Nada Putra", "202310370311434", "Male"));
        userList.add(new User("Anisa Nabila Zahwa", "202310370311435", "Female"));
        userList.add(new User("Alvian Farhat", "202310370311436", "Male"));
        userList.add(new User("Wiji Fiko Teren", "202310370311437", "Male"));
        userList.add(new User("Nazwa Sulistiyawat", "202310370311438", "Male"));
        userList.add(new User("Unzila Putri Asran", "202310370311439", "Female"));
        userList.add(new User("Devis Triansyah", "202310370311440", "Male"));
        userList.add(new User("Muchammad Rifqi Dzaki Arrafi", "202310370311441", "Male"));
        userList.add(new User("Chita Anudya Sulung Anugrah", "202310370311442", "Female"));

    }
}
