package org.group08;

import org.group08.entity.Managers;
import org.group08.entity.Students;
import org.group08.service.ManagersService;
import org.group08.service.StudentsService;
import org.group08.util.RegEX;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.Scanner;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/17
 */
@SpringBootApplication
public class CliApplication implements CommandLineRunner {

    @Value("${application.type}")
    private String type;

    @Resource
    private StudentsService studentsService;

    @Resource
    private ManagersService managersService;

    public static void main(String[] args) {
        SpringApplication.run(CliApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (type.equals("cli")) {
            index();
        }
    }

    private void index() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("University System: (l)ogin, (r)egister or (e)xit: ");
        String action = scanner.nextLine();
        if (action.equals("l")) {
            login();
        } else if (action.equals("r")) {
            register();
        } else if (!action.equals("e")) {
            System.out.println("Invalid input!");
            index();
        }
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter role(s/m): ");
        String role = scanner.nextLine();

        System.out.print("Enter userid or email: ");
        String idOrEmail = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (role.equals("s")) {
            Students stu = studentsService.loginStudents(idOrEmail, password);
            if (stu == null) {
                System.out.println("Invalid credentials");
                return;
            }
            courseManagement();
        } else if (role.equals("m")) {
            Managers man = managersService.loginManager(idOrEmail, password);
            if (man == null) {
                System.out.println("Invalid credentials");
                return;
            }
            gradeManagement();
        } else {
            System.out.println("Invalid role");
            index();
        }
    }

    private void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Reenter your password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords don't match!");
            System.out.println("Do you want to continue registering? (Y/n)");
            String quit = scanner.nextLine();
            if (quit.equals("Y") || quit.equals("y")) {
                index();
            } else {
                register();
            }
        }

        if (studentsService.checkEmail(email) == 1) {
            System.out.println("This email has already been registered!");
            index();
        }

        Students stu = new Students();
        stu.setName(name);
        stu.setPassword(password);
        stu.setEmail(email);

        if (RegEX.isValidEmail(email)) {
            int state = studentsService.saveStudent(stu);
            if (state == 1) {
                System.out.println("Registered successfully!");
                courseManagement();
            } else {
                System.out.println("Registration failed, please try again later!");
                register();
            }
        } else {
            System.out.println("Invalid email");
            register();
        }
    }

    private void courseManagement() {
        System.out.println("course management system");
    }

    private void gradeManagement() {
        System.out.println("grade management system");
    }
}
