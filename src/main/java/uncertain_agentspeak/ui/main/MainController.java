package main.java.uncertain_agentspeak.ui.main;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

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

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private MASProject project;
    private File projectDirectory;

    private final static Logger LOGGER = LogManager.getLogger("Main Controller");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ThreadContext.put("logFilename","Main");
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

        locationTreeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newVlaue) -> {
            TreeItem<File> selectedItem = locationTreeView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                File selectedFile = selectedItem.getValue();
                if (selectedFile.isFile()) {
                    loadFileContents(selectedFile);
                }
            }
        });

//        loadFileContents(projectDirectory);
    }

    @FXML
    private void runProject(ActionEvent event) {
        File file = null;
        FileInputStream fis = null;
        try {
            for (File fileMAS : projectDirectory.listFiles()) {

                if (fileMAS.getName().contains(".mas")) {
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
            executor.submit(callableTask);
        } catch (Exception e) {
            LOGGER.error("Error running project: " + e);
        }

    }



    @FXML
    public void stopProject(ActionEvent event) {
        for (Agent agent : project.getAgents()) {
            agent.setRunning(false);
        }
        stop();
    }

    public void stop() {
        if (project != null) {
            project.stop();
        }
        ThreadContext.put("logFilename","Main");
        try {
            LOGGER.info("Attempt to shutdown main project executor");
            executor.shutdown();
            executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e) {
            LOGGER.info("Tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                LOGGER.error("Cancel non-finished tasks");
            }
            executor.shutdownNow();
            LOGGER.info("Shutdown finished");
        }
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
                item.setGraphic(new ImageView(getClass().getResource("/main/java/uncertain_agentspeak/ui/icons/folder.png").toExternalForm()));
            }
        }
        return item;
    }

    public void loadFileContents(File file) {
        try {
            textArea.clear();
            List<String> lines = new ArrayList<>();
            String line;
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                textArea.appendText("\n" + line);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            LOGGER.error("Error loading file into text area: " + ex);
        } catch (IOException ex) {
            LOGGER.error("Error loading file into text area: " + ex);
        }
    }

}
