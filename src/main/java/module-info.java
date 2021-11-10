module bsu.comp152.webdataonwindowmw {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens bsu.comp152.webdataonwindowmw to javafx.fxml;
    exports bsu.comp152.webdataonwindowmw;
}