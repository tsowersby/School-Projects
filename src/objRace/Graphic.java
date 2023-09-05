package objRace;

import java.util.ArrayList;
import java.util.List;

import adt.ContainerEmptyException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Label;


public class Graphic extends Application {
	List<Node> gridButtons = new ArrayList<>();
	List<Node> CPUButtons = new ArrayList<>();

	public static void main(String[] args) throws IllegalAccessException{
		launch(args);

	}

	@Override
	public void start (Stage primaryStage) throws Exception{


		VBox vbox = new VBox(10);

		GridPane battleShip = new GridPane();
		createButton(" ", 0, 0);
		createButton(" ", 0, 1);
		createButton(" ", 0, 2);
		createButton(" ", 0, 3);
		createButton(" ", 0, 4);
		createButton(" ", 1, 0);
		createButton(" ", 1, 1);
		createButton(" ", 1, 2);
		createButton(" ", 1, 3);
		createButton(" ", 1, 4);
		createButton(" ", 2, 0);
		createButton(" ", 2, 1);
		createButton(" ", 2, 2);
		createButton(" ", 2, 3);
		createButton(" ", 2, 4);
		createButton(" ", 3, 0);
		createButton(" ", 3, 1);
		createButton(" ", 3, 2);
		createButton(" ", 3, 3);
		createButton(" ", 3, 4);
		createButton(" ", 4, 0);
		createButton(" ", 4, 1);
		createButton(" ", 4, 2);
		createButton(" ", 4, 3);
		createButton(" ", 4, 4);

		GridPane ctf = new GridPane();
		createButton2(" ", 0, 0);
		createButton2(" ", 0, 1);
		createButton2(" ", 0, 2);
		createButton2(" ", 0, 3);
		createButton2(" ", 0, 4);
		createButton2(" ", 1, 0);
		createButton2(" ", 1, 1);
		createButton2(" ", 1, 2);
		createButton2(" ", 1, 3);
		createButton2(" ", 1, 4);
		createButton2(" ", 2, 0);
		createButton2(" ", 2, 1);
		createButton2(" ", 2, 2);
		createButton2(" ", 2, 3);
		createButton2(" ", 2, 4);
		createButton2(" ", 3, 0);
		createButton2(" ", 3, 1);
		createButton2(" ", 3, 2);
		createButton2(" ", 3, 3);
		createButton2(" ", 3, 4);
		createButton2(" ", 4, 0);
		createButton2(" ", 4, 1);
		createButton2(" ", 4, 2);
		createButton2(" ", 4, 3);
		createButton2(" ", 4, 4);

		//TEXT
		Text text = new Text("Welcome to Objective Race!");
		Text text3 = new Text("Place Mines and a Flag on the top board then click Start");
		Text text1 = new Text("Capture The Flag (CPU)");
		Text text2 = new Text("Battleship (User)");
		Text text4 = new Text("Press End Game when all 3 ships are hit!");
		Text text5 = new Text("Created by Wil Sowersby & Jack Barton");

		text1.setTextAlignment(TextAlignment.CENTER);
		text2.setTextAlignment(TextAlignment.CENTER);

		//START BUTTON
		final Button startButton = new Button ("Start");
		startButton.setOnAction( __ ->
		{
			try {
				System.out.println("Starting Game!");
				//Tile.startGame();
				Tile.runGame();
			} catch (IllegalAccessException | ContainerEmptyException e) {
				System.out.println("Exception");
			}
		});
		Tile.startGame();

		//SCOREBOARD
		VBox scoreBoard = new VBox(10);
		// USER
		Label user = new Label("Your Score:");
		user.setAlignment(Pos.TOP_LEFT);
		// CPU
		Label cpu = new Label("CPU Score:");
		cpu.setAlignment(Pos.TOP_RIGHT);
		// USER score
		Label userScore = new Label();
		userScore.setAlignment(Pos.CENTER_LEFT);
		// CPU score
		Label cpuScore = new Label();
		cpuScore.setAlignment(Pos.CENTER_RIGHT);


		//SCOREBOARD RESTART BUTTON
		final Button restartButton2 = new Button( "Restart" );
		restartButton2.setOnAction( __ ->
		{
			System.out.println( "Restarting" );
			primaryStage.close();
			Platform.runLater( () -> {
				try {
					new Graphic().start( new Stage() );
				} catch (Exception e) {
					e.printStackTrace();
				}
			} );
			Tile.reset();
		} );

		scoreBoard.getChildren().addAll(user, userScore, cpu, cpuScore, restartButton2);
		scoreBoard.setAlignment(Pos.CENTER);

		Scene endGame = new Scene(scoreBoard, 300, 500);

		//END GAME BUTTON
		final Button endButton = new Button ("End Game");
		endButton.setOnAction( __ ->
		{
			if(Tile.userPoints >= 15 && Tile.shipCount == 0) {

				primaryStage.setTitle("Scoreboard");
				cpuScore.setText(Integer.toString(Tile.cpuPoints));
				userScore.setText(Integer.toString(Tile.userPoints));
				primaryStage.setScene(endGame);
				primaryStage.centerOnScreen();
				primaryStage.show();
			}
		});



		vbox.getChildren().addAll(text, text3, startButton, battleShip, text1, ctf, text2, text4, endButton, text5);
		vbox.setAlignment(Pos.CENTER);

		battleShip.setAlignment(Pos.CENTER);
		battleShip.getChildren().addAll(gridButtons);

		ctf.setAlignment(Pos.CENTER);
		ctf.getChildren().addAll(CPUButtons);

		Scene scene = new Scene(vbox, 425,850);
		primaryStage.setTitle("Objective Race");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();


	}

	private Tile createButton(String name, int col, int row) throws IllegalAccessException, ContainerEmptyException {
		Tile tile = new Tile(name, col, row, false);
		GridPane.setConstraints(tile, col, row);
		gridButtons.add(tile);

		return tile;
	}

	private Tile createButton2(String name, int col, int row) throws IllegalAccessException, ContainerEmptyException {
		Tile tile = new Tile(name, col, row, true);
		GridPane.setConstraints(tile, col, row);
		CPUButtons.add(tile);

		return tile;
	}

}

