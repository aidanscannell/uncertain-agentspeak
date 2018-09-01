package main.java.uncertain_agentspeak.ui.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author aidanscannell
 */
public class Main extends Application {

    private final static Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Loading application...");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        final FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        try {
            final Parent root = loader.load();
            final MainController controller = loader.getController();
            primaryStage.setTitle("Uncertain Agentspeak IDE");
            primaryStage.setScene(new Scene(root, 900, 500));
            primaryStage.show();
            LOGGER.info("Loaded Uncertain AgentSpeak IDE");
        } catch (Exception e) {
            LOGGER.error("Error loading main.fxml : " + e);
        }
    }
}
