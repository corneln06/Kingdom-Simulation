module org.store.kingdomsimulation {
  requires javafx.controls;
  requires javafx.fxml;

  opens org.store.kingdomsimulation to javafx.fxml;
  exports org.store.kingdomsimulation;
}