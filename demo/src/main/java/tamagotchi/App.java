package tamagotchi;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    Stage Window;
    Scene scene1, scene2, scene3, scene4;
    private ListView<String> taskListView;
    private TextField taskInputField;
    private ObservableList<String> tasks;
    public int compteur = 100;
    private Label labelCompteur;
    private Label article, article1, article2, article3, article4;
    private Label inventaire, inventaire1, inventaire2, inventaire3, inventaire4;
    private int inventaireCompteur, inventaireCompteur1, inventaireCompteur2, inventaireCompteur3, inventaireCompteur4;

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
        labelCompteur = new Label("100");
        Button validButton = new Button("valider une tache");
        validButton.setOnAction(e -> {
            String selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                tasks.remove(selectedTask);
                compteur += 10;
                labelCompteur.setText(String.valueOf(compteur));
            }
        });

        //initialisation iventaire vide
        inventaire = new Label("inventaire de gateau vide");
        inventaire1 = new Label("inventaire de sac vide");
        inventaire2 = new Label("inventaire de veste vide");
        inventaire3 = new Label("inventaire de chapeau vide");
        inventaire4 = new Label("inventaire de bijoux vide");


        //boutton pour achat shop et ajout dans l'inventaire
        article = new Label("gateau");
        Button achatButton = new Button("acheter pour 3€");
        achatButton.setOnAction(e -> {
            if (compteur >= 3) {
                compteur -= 3;
                labelCompteur.setText(String.valueOf(compteur));
                inventaireCompteur ++;
                inventaire.setText("gateau: " + inventaireCompteur);
            }
        });

        article1 = new Label("sac");
        Button achatButton1 = new Button("acheter pour 10€");
        achatButton1.setOnAction(e -> {
            if (compteur >= 10) {
                compteur -= 10;
                labelCompteur.setText(String.valueOf(compteur));
                inventaireCompteur1 ++; 
                inventaire1.setText("sac: " + inventaireCompteur1);
            }
        });

        article2 = new Label("veste");
        Button achatButton2 = new Button("acheter pour 15€");
        achatButton2.setOnAction(e -> {
            if (compteur >= 15) {
                compteur -= 15;
                labelCompteur.setText(String.valueOf(compteur));
                inventaireCompteur2 ++;
                inventaire2.setText("veste: " + inventaireCompteur2);
            }
        });

        article3 = new Label("chapeau");
        Button achatButton3 = new Button("acheter pour 14€");
        achatButton3.setOnAction(e -> {
            if (compteur >= 14) {
                compteur -= 14;
                labelCompteur.setText(String.valueOf(compteur));
                inventaireCompteur3 ++;
                inventaire3.setText("chapeau: " + inventaireCompteur3);
            }
        });

        article4 = new Label("bijoux");
        Button achatButton4 = new Button("acheter pour 60€");
        achatButton4.setOnAction(e -> {
            if (compteur >= 60) {
                compteur -=   60;
                labelCompteur.setText(String.valueOf(compteur));
                inventaireCompteur4 ++;
                inventaire4.setText("bijoux: " + inventaireCompteur4);
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
        layout1.setAlignment(Pos.CENTER);

        //config scene 2 taches
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(button2, taskListView, taskInputField, addButton, deleteButton, validButton, labelCompteur);
        scene2 = new Scene(layout2, 500, 500);
        
        //config scene 3 shop
        VBox layout3 = new VBox(10);
        layout3.getChildren().addAll(article, achatButton, article1, achatButton1, article2, achatButton2, article3, achatButton3, article4, achatButton4, labelCompteur, button4);
        scene3 = new Scene(layout3, 500, 500);
        layout3.setAlignment(Pos.CENTER);

        //congig scene 4 inventaire
        VBox layout4 = new VBox(20);
        layout4.getChildren().addAll(button6, inventaire, inventaire1, inventaire2, inventaire3, inventaire4);
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