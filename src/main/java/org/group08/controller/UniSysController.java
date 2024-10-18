package org.group08.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.group08.UniversityApplication;
import org.group08.entity.Managers;
import org.group08.entity.Students;
import org.group08.service.ManagersService;
import org.group08.service.StudentsService;
import org.group08.view.RegisterView;
import org.group08.view.EnrollmentView;

import javax.annotation.Resource;
import java.net.URL;
import java.util.ResourceBundle;

import static org.group08.util.AlertUtil.showAlert;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
@FXMLController
public class UniSysController implements Initializable {
    @FXML
    private TextField idOrEmailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private RadioButton studentRadioButton;
    @FXML
    private RadioButton adminRadioButton;

    @Resource
    private StudentsService studentsService;
    @Resource
    private ManagersService managersService;

    @FXML
    public void register() {
        UniversityApplication.showView(RegisterView.class);
    }

    @FXML
    public void login() {
        String idOrEmail = idOrEmailField.getText().trim();
        String password = passwordField.getText();
        String accountType;
        // 检查是否为空
        if (idOrEmail.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error!", "ID/ Email or password cannot be empty!");
            return;
        }

        if (studentRadioButton.isSelected()) {
            accountType = "student";
        } else if (adminRadioButton.isSelected()) {
            accountType = "manager";
        } else {
            accountType = "unknown";
        }
        UniversityApplication.role=accountType;

        if (accountType.equals("student")) {
            Students stu = studentsService.loginStudents(idOrEmail, password);
            if (stu != null) {
                showAlert(Alert.AlertType.INFORMATION, "Success!", "Login successful!");
                UniversityApplication.user=stu;
                UniversityApplication.getStage().close();
                UniversityApplication.showView(EnrollmentView.class);
            } else {
                showAlert(Alert.AlertType.ERROR, "Error!", "Login failed, ID/ email or password error!");
            }
        } else if (accountType.equals("manager")) {
            Managers man = managersService.loginManager(idOrEmail,password);
            if (man != null) {
                showAlert(Alert.AlertType.INFORMATION, "Success!", "Login successful!！");
                //todo
            } else {
                showAlert(Alert.AlertType.ERROR, "Error!", "Login failed, ID/ email or password error!");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Error!", "Unknown user type!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UniversityApplication.controllers.put(this.getClass().getSimpleName(), this);
    }
}
