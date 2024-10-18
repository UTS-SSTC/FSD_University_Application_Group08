package org.group08.util;

import javafx.scene.control.Alert;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/18
 */
public class AlertUtil {
    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
