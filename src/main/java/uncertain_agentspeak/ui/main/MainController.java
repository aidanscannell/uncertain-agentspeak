/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.uncertain_agentspeak.ui.main;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import main.java.uncertain_agentspeak.agentspeak.Agent;
import main.java.uncertain_agentspeak.mas.MASProject;
import main.resources.antlr.mas_parser.ProjectParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author aidanscannell
 */
public class MainController implements Initializable {

    @FXML
    private Button runButton;
    @FXML
    private Button stopButton;
    @FXML
    private Button settingsButton;
    @FXML
    private MenuItem openProjectButton;
    @FXML
    private TextArea urlTextField;
    @FXML
    private TextArea linesTextArea;
    @FXML
    private TreeView<File> locationTreeView;
    @FXML
    private TextArea textArea;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private MASProject project;
    private File projectDirectory;

    private final static Logger LOGGER = LogManager.getLogger(Main.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void openProject(ActionEvent event) {
        MenuItem source = (MenuItem) event.getSource();
        Window stage = source.getParentPopup().getOwnerWindow();
        final DirectoryChooser fileChooser = new DirectoryChooser();
        projectDirectory = fileChooser.showDialog(stage);

        locationTreeView.setRoot(createTree(projectDirectory));
        locationTreeView.setCellFactory((e) -> new TreeCell<>(){
            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                if(item != null) {
                    setText(item.getName());
                    setGraphic(getTreeItem().getGraphic());
                } else {
                    setText("");
                    setGraphic(null);
                }
            }
        });
    }

    @FXML
    private void runProject(ActionEvent event) {

        File file = null;
        FileInputStream fis = null;
        try {

            for (File fileMAS : projectDirectory.listFiles()) {

                if (fileMAS.getName().contains(".mas")) {
                    System.out.println(fileMAS.getName());
                    file = fileMAS;
                }
            }
            fis = new FileInputStream(file);
            LOGGER.info("Successfully read file " + file.getName());
        } catch (Exception e) {
            LOGGER.error("File not found " + file.getName());
        }

        // Parse mas file here and create parse
        try {
            ProjectParser parser = new ProjectParser();
            project = parser.parseMASProject(fis);
            LOGGER.info("Successfully parsed file " + file.getName());
        } catch (Exception e) {
            LOGGER.error("Parsing errors found: " + e);
        }

        // Run MAS project on new thread
        try {
            Callable<String> callableTask = () -> {
                project.run();
                return null;
            };
            executorService.submit(callableTask);
        } catch (Exception e) {
            LOGGER.error("Error running project: " + e);
        }

    }

    @FXML
    private void stopProject(ActionEvent event) {
        project.stop();
        executorService.shutdownNow();
    }

    @FXML
    private void openSettings(ActionEvent event) {
    }

    private TreeItem<File> createTree(File file) {
        TreeItem<File> item = new TreeItem<>(file);
        File[] childs = file.listFiles();
        if (childs != null) {
            for (File child : childs) {
                item.getChildren().add(createTree(child));
            }
            item.setGraphic(new ImageView(getClass().getResource("../icons/folder.png").toExternalForm()));
        } else {
//            item.setGraphic(new ImageView(getClass().getResource("text-x-generic.png").toExternalForm()));
        }
        return item;
    }

    //    public void loadTreeItems() {
//        TreeView<File> tree = new TreeView<>();
//        tree.setRoot(createTree(new File(".")));
//        tree.setCellFactory((e) -> new TreeCell<File>(){
//            @Override
//            protected void updateItem(File item, boolean empty) {
//                super.updateItem(item, empty);
//                if(item != null) {
//                    setText(item.getName());
//                    setGraphic(getTreeItem().getGraphic());
//                } else {
//                    setText("");
//                    setGraphic(null);
//                }
//            }
//        });
//        locationTreeView.setRoot(createTree(new File(".")));
//    }


//    @FXML
//    @SuppressWarnings("NestedAssignment")
//    public void showFileLines() throws InterruptedException, ExecutionException {
//
//        future = executorService.submit(new Callable<List<String>>() {
//            public List<String> call() throws Exception {
//                return reader.read(new File(MainController.this.urlTextField.getText()));
//            }
//        });
//
//        List<String> lines = future.get();
//        executorService.shutdownNow();
//        linesTextArea.clear();
//        for (String line : lines ) {
//            linesTextArea.appendText(line + "\n");
//        }
//
//
//    }

    
}
