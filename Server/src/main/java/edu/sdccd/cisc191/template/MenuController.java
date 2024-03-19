package edu.sdccd.cisc191.template;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;

public class MenuController {
    private boolean isOnline = false;
    private boolean isSpecial = false;
    private static ImageView LOGO = new ImageView( new Image("https://static.wikia.nocookie.net/logopedia/images/8/8c/4e173fe993fef3933e455d4a2fa85d66.png/revision/latest?cb=20180225015935", 900, 271.5, true, true) );
    private static HBox buttons = new HBox(30);
    private static VBox root = new VBox(LOGO, buttons);

    public VBox setupRoot() {
        Button local = new Button("Local");
        styleButton(local);
        Button online = new Button("Online");
        styleButton(online);
        Button credits = new Button("Credits!");
        styleButton(credits);

        Button regular = new Button("Regular Mode");
        styleButton(regular);
        Button special = new Button("Special Mode");
        styleButton(special);
        Button back = new Button ("Back");
        styleButton(back);

        Button createLobby = new Button("Create Lobby");
        Button joinLobby = new Button("Join Lobby");


        local.setOnAction( evt -> {
            changeButtons(regular, special, back);
        } );

        online.setOnAction( evt -> {
            changeButtons(regular, special, back);
            isOnline = true;
        } );

        credits.setOnAction( evt -> {
            displayCredits(back);
        } );

        back.setOnAction( evt -> {
            changeButtons(local, online, credits);
            root.getChildren().setAll(LOGO, buttons);
        } );

        changeButtons(local, online, credits);
        buttons.setAlignment(Pos.CENTER);
        buttons.setStyle("-fx-padding: 30px");
        root.setAlignment(Pos.CENTER);
        return root;
    }

    public void changeButtons(Button button1, Button button2, Button button3) {
        buttons.getChildren().setAll(button1, button2, button3);
    }

    public void displayCredits(Button back) {
        Label creditsMessage = new Label("Credits will be added later!");
        creditsMessage.setStyle("-fx-font-size: 30px");
        buttons.getChildren().setAll(back);
        root.getChildren().setAll(creditsMessage, buttons);
    }

    public void styleButton(Button button1) {
        buttons.setHgrow(button1, Priority.ALWAYS);
        button1.setMaxWidth(200);
        button1.setMinWidth( button1.getPrefWidth() );
        button1.setStyle("-fx-font-size: 20px");
    }
}
