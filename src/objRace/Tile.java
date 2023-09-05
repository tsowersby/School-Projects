package objRace;


import adt.ContainerEmptyException;
import battleship.Coordinate;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

public class Tile extends GridPane {

	private String name;
	private int col;
	private int row;
	private boolean cpuBoard;
	private Button button;

	private final static int BOARDSIZE = 5;
	static int shipCount = 3;
	public static int mineCount = 3;
	private static int flagCount = 1;
	private static boolean win;
	public static Boards boards;
	private static Button[][] userButtons = new Button[BOARDSIZE][BOARDSIZE];

	public static int userPoints = 0;
	public static int cpuPoints = 0;

	public Tile(String title, int c, int r, boolean cpu) throws IllegalAccessException, ContainerEmptyException
	{
		name = title;
		col = c;
		row = r;
		cpuBoard = cpu;

		button = new Button(name);

		button.setPrefSize(50, 50);
		button.setMaxSize(50, 50);

		if (!cpu) {
			userButtons[row][col] = button;
		}

		placeMinesAndFlag();

		getChildren().addAll(button);
	}

	private void placeMinesAndFlag() { //And Attack
		Image mine = new Image(getClass().getResource("mine.png").toExternalForm(), 24, 24, true, true);
		Image flag = new Image(getClass().getResource("flag.png").toExternalForm(), 24, 24, true, true);

		Image hit1 = new Image(getClass().getResource("hit.png").toExternalForm(), 24, 24, true, true);
		Image miss = new Image(getClass().getResource("miss.png").toExternalForm(), 24, 24, true, true);


		button.setOnMouseClicked(event ->
		{
			if (!cpuBoard) {
				if (event.getButton() == MouseButton.PRIMARY && mineCount > 0) {
					button.setGraphic(new ImageView(mine));
					boards.placeMine(row, col);
					mineCount--;
				} else if (event.getButton() == MouseButton.SECONDARY && flagCount > 0) {
					button.setGraphic(new ImageView(flag));
					boards.placeFlag(row, col);
					flagCount--;
				}
			}else if (cpuBoard){ //Attack for Battleship - worked better to put in this method
				if (event.getButton() == MouseButton.PRIMARY) {
					if(boards.selectStrike(row, col) == true) {
						button.setGraphic(new ImageView(hit1));
						shipCount--;
						userPoints = userPoints + 5;
						searching();
						System.out.println("User: " + userPoints + " Cpu: " + cpuPoints);
					}else if(boards.selectStrike(row, col) == false){
						button.setGraphic(new ImageView(miss));
						searching();
						System.out.println("User: " + userPoints + " Cpu: " + cpuPoints);
					}
				} 

			}
		});
	}

	public static void runGame() throws IllegalAccessException, ContainerEmptyException {
		int turns = boards.search();

		//Gameplay

		System.out.println("Select a strike");
		while ((!win) && turns > 0) {
			turns--;
		}

		if(win) {
			System.out.println("User has successfully eliminated the ships! You Win!");
		}

	}

	public static void startGame() {
		win = false;
		boards = new Boards();

		//Computer places ships
		boards.placeShips(shipCount);
	}


	static void reset() {
		shipCount = 3;
		mineCount = 3;
		flagCount = 1;
		win = false;
		boards = new Boards();
		userButtons = new Button[BOARDSIZE][BOARDSIZE];
		cpuPoints = 0;
		userPoints = 0;
	}

	private void searching() {
		try {
			Coordinate searchPath = Boards.searchPath.remove();
			if (boards.isMine(searchPath.row, searchPath.column)) {
				cpuPoints -= 5;
				System.out.println("Explosion");
			}
			if (boards.atEnd(searchPath))
				cpuPoints += 25;
			userButtons[searchPath.row][searchPath.column].setStyle("-fx-background-color: #ff0000");
		} catch (IllegalAccessException e) {
			
		} catch (ContainerEmptyException e) {
			
		}
	}

}
