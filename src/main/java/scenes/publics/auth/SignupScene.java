package scenes.publics.auth;

import com.jfoenix.controls.*;
import database.models.User;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import scenes.MyGroup;
import scenes.MyScene;

/**
 * Created by ibnujakaria on 3/15/17.
 */
public class SignupScene extends MyGroup {
    JFXButton backButton, signUpButton;
    JFXTextField nameField, usernameField, emailField;
    JFXPasswordField passwordField, passwordConfirmationField;
    JFXTextArea addressField;

    @Override
    protected void prepareLayout() {
        VBox vBox = new VBox();

        Label label = new Label("Sign up Scene");
        label.setFont(new Font(40));

        backButton = new JFXButton("Back");
        signUpButton = new JFXButton("Sign up");

        nameField = new JFXTextField();
        nameField.setPromptText("Name");

        usernameField = new JFXTextField();
        usernameField.setPromptText("Username");

        emailField = new JFXTextField();
        emailField.setPromptText("Email");

        passwordField = new JFXPasswordField();
        passwordField.setPromptText("Password");

        passwordConfirmationField = new JFXPasswordField();
        passwordConfirmationField.setPromptText("Type your password again");

        addressField = new JFXTextArea();
        addressField.setPromptText("Address");

        vBox.getChildren().addAll(backButton, label, nameField, usernameField,
                emailField, addressField, passwordField, passwordConfirmationField,
                signUpButton);
        getChildren().add(vBox);
    }

    @Override
    protected void addListeners() {
        backButton.setOnAction(event -> {
            movePreviousScene();
        });

        signUpButton.setOnAction(event -> {
            doSignUpProcess();
        });
    }

    private void doSignUpProcess() {
        StackPane pane = new StackPane();
        getChildren().add(pane);
        JFXDialog dialog = new JFXDialog();
        dialog.setContent(new Label("Loading.."));
        dialog.show(pane);

        User.createUser(
                nameField.getText(), usernameField.getText(), emailField.getText(), addressField.getText(),
                passwordField.getText(), false, false
        );

        movePreviousScene();
    }
}