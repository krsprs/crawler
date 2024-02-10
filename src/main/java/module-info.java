module com.ksp.APP {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.web;
    requires org.jsoup;

    // Open JavaFX packages to TestFX

    opens com.ksp.APP to javafx.fxml;
    exports com.ksp.APP;
    exports com.ksp.APP.Validators;
    opens com.ksp.APP.Validators to javafx.fxml;
    opens com.ksp.APP.Controllers to javafx.fxml;

}
