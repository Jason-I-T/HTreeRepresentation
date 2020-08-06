/*
 * Tejada, Jason	
 * CS2013
 * 02/06/2020
 *
 * Desc: The main class for homework 1.
 */

package Hw01;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;

import java.lang.NumberFormatException;

public class Main extends Application {
	public HTreePane hTreePane = new HTreePane(600, 600); 

	@Override
	public void start(Stage primaryStage) {

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(this.hTreePane);
		borderPane.setBottom(enterOrderPane());

		Scene scene = new Scene(borderPane, 600, 600);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("HTree - Homework01");
		primaryStage.show();

		primaryStage.setResizable(false);
		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(600);
	}

	public HBox enterOrderPane() {
		TextField tfOrder = new TextField();
		tfOrder.setAlignment(Pos.CENTER);
		
		tfOrder.setOnAction(e -> {
			try{
				this.hTreePane.setOrder(Integer.parseInt(tfOrder.getText()));
				tfOrder.setText("");	
			}

			catch(NumberFormatException ex) {
				tfOrder.setText("");	
			}
		});	
		
		HBox hBox = new HBox();
		hBox.getChildren().add(tfOrder);
		hBox.setAlignment(Pos.CENTER);

		return hBox;
	}


	public static void main(String[] args) {
		Application.launch(args);	
	}
}
