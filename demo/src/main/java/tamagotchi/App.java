package tamagotchi;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    Stage Window;
    Scene scene1, scene2, scene3, scene4;
    private ListView<String> taskListView;
    private TextField taskInputField;
    private ObservableList<String> tasks;
    public int compteur = 0;
    private Label labelCompteur;
    private Label article, article1, article2, article3, article4;

    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage primaryStage) throws Exception {
        Window = primaryStage;

        // Créer la liste des tâches
        tasks = FXCollections.observableArrayList();
        taskListView = new ListView<>(tasks);

        // Créer le champ de saisie des tâches
        taskInputField = new TextField();

        // add taches
        Button addButton = new Button("Ajouter");
        addButton.setOnAction(event -> addTask());
        taskListView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                String selectedTask = taskListView.getSelectionModel().getSelectedItem();
                if (selectedTask != null) {
                    taskInputField.setText(selectedTask);
                }
            }
        });

        //supp taches
        Button deleteButton = new Button("Supprimer");
        deleteButton.setOnAction(e -> {
            String selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                tasks.remove(selectedTask);
            }
        });

        //valider taches
        labelCompteur = new Label("0");
        Button validButton = new Button("valider une tache");
        validButton.setOnAction(e -> {
            String selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                tasks.remove(selectedTask);
                compteur += 10;
                labelCompteur.setText(String.valueOf(compteur));
            }
        });

        //differents articlee et button pour le shop
        article = new Label("gateau");
        Button achatButton = new Button("acheter pour 3€");
        achatButton.setOnAction(e -> {
            if (compteur >= 3) {
                compteur -= 3;
                labelCompteur.setText(String.valueOf(compteur));
            }
        });

        article1 = new Label("sac");
        Button achatButton1 = new Button("acheter pour 10€");
        achatButton1.setOnAction(e -> {
            if (compteur >= 10) {
                compteur -= 10;
                labelCompteur.setText(String.valueOf(compteur));
            }
        });

        article2 = new Label("veste");
        Button achatButton2 = new Button("acheter pour 15€");
        achatButton2.setOnAction(e -> {
            if (compteur >= 15) {
                compteur -= 15;
                labelCompteur.setText(String.valueOf(compteur));
            }
        });

        article3 = new Label("chapeau");
        Button achatButton3 = new Button("acheter pour 14€");
        achatButton3.setOnAction(e -> {
            if (compteur >= 14) {
                compteur -= 14;
                labelCompteur.setText(String.valueOf(compteur));
            }
        });

        article4 = new Label("bijoux");
        Button achatButton4 = new Button("acheter pour 60€");
        achatButton4.setOnAction(e -> {
            if (compteur >= 60) {
                compteur -=   60;
                labelCompteur.setText(String.valueOf(compteur));
            }
        });



        //Button scene 1 vers scene 2
        Button button1 = new Button("taches");
        button1.setOnAction(e -> Window.setScene(scene2));

        //button scene 2 vers scene 1
        Button button2 = new Button("retour");
        button2.setOnAction(e -> Window.setScene(scene1));

        //Button scene 1 vers scene 3
        Button button3 = new Button("shop");
        button3.setOnAction(e -> Window.setScene(scene3));

        //button scene 3 vers scene 1
        Button button4 = new Button("retour");
        button4.setOnAction(e -> Window.setScene(scene1));

        //Button scene 1 vers scene 4
        Button button5 = new Button("inventaire");
        button5.setOnAction(e -> Window.setScene(scene4));

        //Button scene 4 vers scene 1
        Button button6 = new Button("retour");
        button6.setOnAction(e -> Window.setScene(scene1));
        



        //config scene 1 base
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(button1, button3, button5);
        scene1 = new Scene(layout1, 500, 500);

        //config scene 2 taches
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(button2, taskListView, taskInputField, addButton, deleteButton, validButton, labelCompteur);
        scene2 = new Scene(layout2, 500, 500);
        
        //config scene 3 shop
        VBox layout3 = new VBox(10);
        layout3.getChildren().addAll(article, achatButton, article1, achatButton1, article2, achatButton2, article3, achatButton3, article4, achatButton4, labelCompteur, button4);
        scene3 = new Scene(layout3, 500, 500);

        //congig scene 4 inventaire
        VBox layout4 = new VBox(20);
        layout4.getChildren().addAll(button6);
        scene4 = new Scene(layout4, 500, 500);

        Window.setScene(scene1);
        Window.show();
    }


    private void addTask() {
        String task = taskInputField.getText();
        if (!task.isEmpty()) {
            if (taskListView.getSelectionModel().getSelectedIndex() != -1) {
                // Modifier la tâche existante
                int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
                tasks.set(selectedIndex, task);
            } else {
                // Ajouter une nouvelle tâche
                tasks.add(task);
            }
            taskInputField.clear();
        }
    }

}