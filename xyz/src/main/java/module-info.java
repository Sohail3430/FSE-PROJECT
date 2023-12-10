module com.mycompany.xyz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.xyz to javafx.fxml;
    exports com.mycompany.xyz;
}
