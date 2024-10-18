package org.group08.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.group08.UniversityApplication;
import org.group08.entity.Students;
import org.group08.service.StudentsService;
import org.group08.util.RegEX;
import org.group08.view.UniSysView;

import javax.annotation.Resource;

import static org.group08.util.AlertUtil.showAlert;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
@FXMLController
public class RegisterController {
    @FXML
    private TextField emailField;
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label errorLabel;

    @Resource
    private StudentsService studentsService;

    @FXML
    private void returnIndex() {
        UniversityApplication.showView(UniSysView.class);
    }

    @FXML
    private void register() {
        String email = emailField.getText();
        String name = nameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // 检查密码是否匹配
        if (!password.equals(confirmPassword)) {
            errorLabel.setText("Passwords don't match!");
            return;
        }

        // 检查邮箱、密码等字段的合法性
        if (email.isEmpty() || name.isEmpty() || password.isEmpty()) {
            errorLabel.setText("All fields must be filled!");
            return;
        }

        if (RegEX.isValidEmail(email)) {
            errorLabel.setText("Email is invalided!");
            return;
        }

        if (studentsService.checkEmail(email) == 1) {
            errorLabel.setText("This email has already been registered!");
            return;
        }

        // 注册逻辑，例如存储用户信息或发送到服务器
        errorLabel.setText(""); // 清除错误信息
        Students stu = new Students();
        stu.setEmail(email);
        stu.setName(name);
        stu.setPassword(password);
        int state = studentsService.saveStudent(stu);
        if (state == 1) {
            showAlert(Alert.AlertType.INFORMATION, "Success!", "Registered successfully!");
            UniversityApplication.showView(UniSysView.class);
        } else {
            showAlert(Alert.AlertType.ERROR, "Error!", "Registration failed, please try again later!");
        }
    }
}
