package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Person;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        mainWindow();
    }

    public void mainWindow() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    Main.class.getResource("/view/MainWindowView.fxml"));
            AnchorPane pane = loader.load();
            primaryStage.setMinWidth(500.00);
            primaryStage.setMinHeight(600.00);
            Scene scene = new Scene(pane);
            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(this, primaryStage);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
