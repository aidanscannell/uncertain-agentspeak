package main.java.uncertain_agentspeak.runtime;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.java.uncertain_agentspeak.environment.Environment;
import main.java.uncertain_agentspeak.environment.grid.GridWorldModel;
import main.java.uncertain_agentspeak.environment.grid.GridWorldView;
import main.java.uncertain_agentspeak.infrastructure.MASLauncher;
import main.java.uncertain_agentspeak.infrastructure.centralised.CentralisedMASLauncher;
import main.java.uncertain_agentspeak.mas.MASProject;
import main.resources.antlr.mas_parser.ProjectParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UncertainAgentspeakGUI extends Application {

    private File file = null;
    private FileInputStream fis = null;
    private MASProject project;

    public void launchGUI(String[] args) {
        Application.launch(args);
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Uncertain AgentSpeak");

        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 700, 200);

        final FileChooser fileChooser = new FileChooser();

        final Button openButton = new Button("Select MAS file...");
        final Button runButton = new Button("Run MAS");

        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        file = fileChooser.showOpenDialog(primaryStage);
                        if (file != null) {
                            loadFile();
                            parseFile();
                            Stage stage = project.getEnvironment().getStage();
                            MASLauncher launcher = new CentralisedMASLauncher();
//                            String title = project.getName();
//                            System.out.println(project.);
//                            GridWorldModel model = new GridWorldModel(40,40,4);
//                            model.add(2, 15, 15);
//                            model.add(4, 15, 19);
//                            runButton.setOnAction(eve-> stage);
                        }
                    }
                });

        runButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        if (file != null && fis != null) {
                            try {
                                project.run();
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });

        root.getChildren().add(openButton);
        root.getChildren().add(runButton);



        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    public void run() {
//        MASProject project = parseFile();
////        project.
//    }

    public void loadFile() {
        try {
            fis = new FileInputStream(file);
            System.out.println("Successfully opened " + file.getName());
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (Exception e) {
            System.out.println("Failed to open " + file.getName());
        }

    }

    public MASProject parseFile() {
        ProjectParser projectParser = new ProjectParser();
        try {
            project = projectParser.parseMASProject(fis);
            System.out.println("Successfully parsed file " + file.getName());
        } catch (Exception e) {
            System.out.println("Failed to parse " + file.getName());
        }
        return project;
    }

}
