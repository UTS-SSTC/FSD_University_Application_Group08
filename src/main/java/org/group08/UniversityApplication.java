package org.group08;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.group08.view.UniSysView;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
@SpringBootApplication
public class UniversityApplication extends AbstractJavaFxApplicationSupport {
    public static Map<String, Object> controllers = new HashMap<>();
    public static String role = "unknown";
    public static Object user;

    public static void main(String[] args) {
        launch(UniversityApplication.class, UniSysView.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm exit");
            alert.setHeaderText("Do you want to exit the program?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.CANCEL) {
                event.consume();
            }
        });
        super.start(stage);
    }
}
