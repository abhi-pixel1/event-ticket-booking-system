module org.fest.fest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires mysql.connector.j;

    opens org.fest.fest to javafx.fxml;
    exports org.fest.fest;
    exports org.fest.fest.Controller;
    opens org.fest.fest.Controller to javafx.fxml;
}