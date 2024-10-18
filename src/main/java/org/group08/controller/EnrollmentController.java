package org.group08.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
@FXMLController
public class EnrollmentController {
    @FXML
    private TableView<?> selectedSubjectsTable;
    @FXML
    private TableColumn<?, ?> subjectNameColumn;
    @FXML
    private TableColumn<?, ?> scoreColumn;
    @FXML
    private TableView<?> allSubjectsTable;
    @FXML
    private TableColumn<?, ?> allSubjectNameColumn;
    @FXML
    private TableColumn<?, ?> selectedStatusColumn;
    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField oldPasswordField;

    @FXML
    private void removeSubject() {
        //TODO: 删除已选科目的逻辑
    }

    @FXML
    private void addSubject() {
        //TODO: 添加科目的逻辑
    }

    @FXML
    private void changePassword() {
        //TODO: 修改密码的逻辑
    }
}
