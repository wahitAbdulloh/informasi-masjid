package scenes.dashboard;

import com.jfoenix.controls.JFXButton;
import core.auth.Auth;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import scenes.MyGroup;
import scenes.publics.auth.LoginScene;


/**
 * Created by ibnujakaria on 3/15/17.
 */
public class DashboardScene extends MyGroup {
    private JFXButton logoutButton;

    @Override
    protected void prepareLayout() {
        Label label = new Label("Dashboard");
        label.setFont(new Font(40));
        Label welcome = new Label("Selamat datang: " + Auth.getUser().get("name"));
        logoutButton = new JFXButton("Logout");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, welcome, logoutButton);
        getChildren().add(vBox);
    }

    @Override
    protected void addListeners() {
        logoutButton.setOnAction(event -> {
            Auth.logout();

            setPreviousScene(new LoginScene());
            movePreviousScene();
        });
    }
}
