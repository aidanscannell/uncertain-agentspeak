//package main.java.uncertain_agentspeak.util;
//
//import javafx.application.Application;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//
//public class ConfigGUI extends Application {
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("Uncertain AgentSpeak(L)");
//        StackPane root = new StackPane();
//        root.getChildren().add(createGUI());
//        Scene scene = new Scene(root, 400, 200);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public void start(Stage primaryStage) {
//
//        primaryStage.setTitle("PrimaryStage");
//
//        FlowPane root = new FlowPane();
//        root.setAlignment(Pos.CENTER);
//        Scene scene = new Scene(root, 700, 200);
//
//        Button btn = new Button("Open New Stage");
//        btn.setOnAction(eve-> new NewStage());
//
//        root.getChildren().add(btn);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private Pane createGUI() {
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(5, 5, 5, 5));
//        grid.setHgap(5);
//        grid.setVgap(5);
//        grid.add(new Label("User Name"), 0, 0);
//        grid.add(new TextField(), 1, 0);
//        grid.add(new Label("Password"), 0, 1);
//        grid.add(new PasswordField(), 1, 1);
//        grid.add(new Button("Login"), 1, 2);
//        return grid;
//    }
//
//}
