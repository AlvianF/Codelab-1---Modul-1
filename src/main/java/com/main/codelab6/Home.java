package com.main.codelab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage primaryStage) {
        String name = "";
        String[] split = Login.nameLogin.split(" ");
        int splitLength = split.length;
        if(splitLength > 2) {
            for (int i = 0; i < splitLength; i++) {
                if(i == 0 || i == 1) {
                    name += split[i];
                }else {
                    name += split[i].charAt(0) + ".";
                }
                name += " ";
            }
        }else {
            name = Login.nameLogin;
        }

        String nim = Login.nimLogin;

        String gender = "";
        if(Login.genderLogin.equals("Male")) {
            gender = "/images/avatar_male_student.png";
        }else {
            gender = "/images/avatar_female_student.png";
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(350, 500);
        Image background = new Image(getClass().getResource("/images/background_info.png").toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(background, null, null, null, null);
        borderPane.setBackground(new Background(backgroundImage));

        AnchorPane topAnchorPane = new AnchorPane();
        topAnchorPane.setPrefSize(350, 266);
        borderPane.setTop(topAnchorPane);

        ImageView profileImageView = new ImageView(new Image(getClass().getResource(gender).toExternalForm()));
        profileImageView.setFitHeight(130);
        profileImageView.setFitWidth(130);
        profileImageView.setLayoutX(110);
        profileImageView.setLayoutY(122);
        topAnchorPane.getChildren().add(profileImageView);

        Label titleLabel = new Label("STUDENT INFORMATION");
        titleLabel.setFont(new Font("Segoe UI Bold", 24));
        titleLabel.setLayoutX(32);
        titleLabel.setLayoutY(54);
        topAnchorPane.getChildren().add(titleLabel);

        AnchorPane centerAnchorPane = new AnchorPane();
        centerAnchorPane.setPrefSize(200, 200);
        borderPane.setCenter(centerAnchorPane);

        Label nimLabel = new Label("NIM");
        nimLabel.setFont(new Font("Segoe UI Bold", 18));
        nimLabel.setLayoutX(36);
        nimLabel.setLayoutY(72);
        centerAnchorPane.getChildren().add(nimLabel);

        Label nameLabel = new Label("NAME");
        nameLabel.setFont(new Font("Segoe UI Bold", 18));
        nameLabel.setLayoutX(36);
        nameLabel.setLayoutY(31);
        centerAnchorPane.getChildren().add(nameLabel);

        Label genderLabel = new Label("GENDER");
        genderLabel.setFont(new Font("Segoe UI Bold", 18));
        genderLabel.setLayoutX(37);
        genderLabel.setLayoutY(110);
        centerAnchorPane.getChildren().add(genderLabel);

        Label nameValueLabel = new Label(": " + name);
        nameValueLabel.setFont(new Font(18));
        nameValueLabel.setLayoutX(120);
        nameValueLabel.setLayoutY(31);
        centerAnchorPane.getChildren().add(nameValueLabel);

        Label nimValueLabel = new Label(": " + nim);
        nimValueLabel.setFont(new Font(18));
        nimValueLabel.setLayoutX(120);
        nimValueLabel.setLayoutY(72);
        centerAnchorPane.getChildren().add(nimValueLabel);

        Label genderValueLabel = new Label(": " + Login.genderLogin);
        genderValueLabel.setFont(new Font(18));
        genderValueLabel.setLayoutX(120);
        genderValueLabel.setLayoutY(110);
        centerAnchorPane.getChildren().add(genderValueLabel);

        Button logoutButton = new Button("Logout");
        logoutButton.setLayoutX(203);
        logoutButton.setLayoutY(153);
        logoutButton.setPrefSize(111, 47);
        centerAnchorPane.getChildren().add(logoutButton);
        logoutButton.setTextFill(Color.WHITE);
        logoutButton.setBackground(Background.fill(Paint.valueOf("#79606D")));
        Rectangle roundedRect = new Rectangle(100, 40);
        roundedRect.setArcWidth(30);
        roundedRect.setArcHeight(30);
        logoutButton.setShape(roundedRect);
        logoutButton.setFont(new Font("Segoe UI Bold", 18));

        logoutButton.setOnAction(actionEvent -> {
            Login login = new Login();
            login.start(primaryStage);
        });

        logoutButton.setOnMouseEntered(mouseEvent -> {
            logoutButton.setBackground(Background.fill(Paint.valueOf("#9B7C8D")));
        });

        logoutButton.setOnMouseExited(mouseEvent -> {
            logoutButton.setBackground(Background.fill(Paint.valueOf("#79606D")));
        });

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Information");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showSecondScene(Stage primaryStage) {
    }
}
