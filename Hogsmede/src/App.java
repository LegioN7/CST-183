import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        Scene scene = null; // Scene contains all content
        GridPane gridPane = null; // Positions components within scene
        Label amountLabel = null; // Label for amount
        Label hogsHeadLabel = null; // Label for HogsHead
        Label gallonsLabel = null; // Label for gallons
        Label costLabel = null; // Label for gallons
        Label USDLabel = null; // Label for USD
        Label BritishPoundLabel = null; // Label for GBP
        Label galleonsLabel = null; // Label for Galleons
        Label sicklesLabel = null; // Label for Sickles
        Label knutsLabel = null; // Label for Knuts
        TextField hogsHeadAle = null; // Displays yearly salary
        TextField hogsHeadGallons = null; // Displays hourly wage

        // Create Stage
        Stage newWindow = new Stage();
        newWindow.setTitle("Hogshead Ale Calculator");
        // Create view in Java
        Label title = new Label("Welcome to the Hogshead Ale Calculator.");
        Button nextButton = new Button("Next");
        nextButton.setOnAction(event -> {
            // handle button press
        });
        VBox container = new VBox(title, nextButton);
        // Style container
        container.setSpacing(15);
        container.setPadding(new Insets(25));
        container.setAlignment(Pos.CENTER);
        // Set view in window
        newWindow.setScene(new Scene(container));
        container.setMinSize(720, 720);
        // Launch
        newWindow.show();

        gridPane = new GridPane(); // Create an empty pane

        gridPane.setMinSize(720, 720);

        amountLabel = new Label("Amount: ");
        costLabel = new Label("Cost: ");
        hogsHeadLabel = new Label("xx Hogshead Ale");
        gallonsLabel = new Label("xx.xx USD");
        USDLabel = new Label("xx.xx USD");

        gridPane.add(amountLabel, 0, 0); // Add wage label to location (0, 0)
        gridPane.add(hogsHeadLabel, 1, 0); // Add wage text field to location (1, 0)
        gridPane.add(gallonsLabel, 0, 2); // Add wage text field to location (1, 0)
        gridPane.add(costLabel, 0, 1); // Add salary label to location (0, 1)
        gridPane.add(USDLabel, 1, 1); // Add salary text field to location (1, 1)

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10); // Spacing between columns
        gridPane.setVgap(10); // Spacing between rows
        gridPane.setAlignment(Pos.CENTER); // alignment center

        // Creates an Exit Button
        Button exitButton = new Button();

        // Set Button Text
        exitButton.setText("Quit");

        // Positions the button
        exitButton.setLayoutX(125);
        exitButton.setLayoutY(250);
        gridPane.getChildren().add(exitButton); // Adds the exit button

        // Exits the Scene

        exitButton.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        scene = new Scene(gridPane); // Create a scene containing the pane

        // Set the stage
        primaryStage.setTitle("Hogshead Receipt"); // Set window's title
        primaryStage.setScene(scene); // Set window's scene
        primaryStage.show(); // Display window
    }

    public static void main(String[] args) {
        launch(args); // Launch application
    }
}