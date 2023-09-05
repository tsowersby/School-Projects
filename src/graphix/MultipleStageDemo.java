package graphix;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MultipleStageDemo extends Application{
	@Override
	public void start(Stage primaryStage) {
		Pane topPane = new Pane();
		Pane pane = new Pane();
		
		Rectangle crownBase = new Rectangle(100, 170, 100, 40);
		crownBase.setFill(Color.RED);
		Rectangle crownSpoke1 = new Rectangle(90, 125, 10, 50);
		crownSpoke1.setRotate(-22.5);
		crownSpoke1.setFill(Color.GOLD);
		Rectangle crownSpoke2 = new Rectangle(130, 141, 10, 30);
		crownSpoke2.setRotate(-10);
		crownSpoke2.setFill(Color.GOLD);
		Rectangle crownSpoke3 = new Rectangle(160, 141, 10, 30);
		crownSpoke3.setRotate(10);
		crownSpoke3.setFill(Color.GOLD);
		Rectangle crownSpoke4 = new Rectangle(200, 125, 10, 50);
		crownSpoke4.setRotate(22.5);
		crownSpoke4.setFill(Color.GOLD);
		
		Circle crownBell1 = new Circle(85, 130, 10);
		crownBell1.setFill(Color.SADDLEBROWN);
		Circle crownBell2 = new Circle(132.5, 141, 10);
		crownBell2.setFill(Color.SADDLEBROWN);
		Circle crownBell3 = new Circle(167.5, 141, 10);
		crownBell3.setFill(Color.SADDLEBROWN);
		Circle crownBell4 = new Circle(215, 130, 10);
		crownBell4.setFill(Color.SADDLEBROWN);
		
		topPane.getChildren().addAll(crownSpoke2, crownSpoke3, crownBase, crownSpoke1, crownSpoke4, crownBell1, crownBell2, crownBell3, crownBell4);
		Pane botPane = topPane;
		
		Reflection reflection = new Reflection();
		reflection.setBottomOpacity(1);
		reflection.setTopOpacity(1);
		reflection.setTopOffset(30);
		reflection.setFraction(1);
		botPane.setEffect(reflection);

		Ellipse ellipse1 = new Ellipse(150, 225, 60, 25);
		ellipse1.setFill(Color.WHITE);
		Ellipse ellipse2 = new Ellipse(150, 225, 55, 35);
		ellipse2.setFill(Color.GOLDENROD);
		
		Rectangle diamond1 = new Rectangle(10, 10, 40, 40);
		diamond1.setFill(Color.RED);
		diamond1.setRotate(45);
		Rectangle diamond2 = new Rectangle(250, 400, 40, 40);
		diamond2.setFill(Color.RED);
		diamond2.setRotate(45);
		
		pane.getChildren().addAll(botPane,ellipse2, ellipse1, diamond1, diamond2);
		
		Scene scene = new Scene(pane, 300, 450);
		primaryStage.setTitle("Playing Card");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main (String[] args) {
		Application.launch(args);
	}
}
