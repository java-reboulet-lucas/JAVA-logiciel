module tamagotchi {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens tamagotchi to javafx.fxml;
    exports tamagotchi;
}
