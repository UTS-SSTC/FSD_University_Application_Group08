package org.group08.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.group08.entity.Students;
import org.group08.service.StudentsService;

import javax.annotation.Resource;
import java.util.List;

@FXMLController
public class AdminController {

    @FXML
    private TabPane mainTabPane;

    @FXML
    private TableView<Students> studentTableView;

    @FXML
    private TableColumn<Students, String> idColumn;

    @FXML
    private TableColumn<Students, String> nameColumn;

    @FXML
    private TableColumn<Students, String> emailColumn;

    @Resource
    private StudentsService studentsService;

    @FXML
    public void initialize() {

    }

    @FXML
    private void showStudents() {
        List<Students> studentList = studentsService.getAllStudents();
        studentList.add(new Students("12", "123", "qwe", "asd.zxc.university.com"));
        studentList.add(new Students("124", "123", "qwe", "add.zxc.university.com"));
        studentList.add(new Students("121", "123", "qwe", "ahd.zxc.university.com"));
        studentList.add(new Students("126", "123", "qwe", "ard.zxc.university.com"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        studentTableView.setItems(FXCollections.observableArrayList(studentList));
    }

    @FXML
    private void handleExitButton() {
        Platform.exit();  // 关闭JavaFX应用程序
        System.exit(0);   // 终止JVM进程
    }
}
