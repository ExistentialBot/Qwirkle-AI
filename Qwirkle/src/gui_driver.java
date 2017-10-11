package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class gui_driver extends Application {

	private Stage primaryStage;
	private BorderPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("GUI");
		showMainView();
	}

	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(gui_driver.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}



	public static void main(String[] args) {
		launch(args);
	}
}

