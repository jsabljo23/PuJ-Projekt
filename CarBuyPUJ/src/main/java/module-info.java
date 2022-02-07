module com.example.carbuypuj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.carbuypuj to javafx.fxml;
    exports com.example.carbuypuj;
}