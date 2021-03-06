package main.java.uncertain_agentspeak.ui.main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.stage.WindowEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 *
 * @author aidanscannell
 */
public class Main extends Application {

    private final static Logger LOGGER = LogManager.getLogger("Main");

    public static void main(String[] args) {
        ThreadContext.put("logFilename","Main");
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
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    controller.stop();
                }
            });
            LOGGER.info("Loaded Uncertain AgentSpeak IDE");
        } catch (Exception e) {
            LOGGER.error("Error loading main.fxml : " + e);
        }
    }
}
