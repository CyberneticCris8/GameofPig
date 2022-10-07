package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Sample.fxml"));
		Parent fxmlView = fxml.load();
		SampleController view = fxml.getController();
		view.playAgain();

		
		stage.setTitle("Game of Pig");
		stage.setScene(new Scene(fxmlView));
		stage.show();
		
	}

}
