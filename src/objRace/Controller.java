package objRace;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Controller implements EventHandler<ActionEvent> {

	Graphic gui;
	

	public Controller(Graphic graphic) {
		gui = graphic;
	}

	@Override
	public void handle(ActionEvent event) {
        Button clickedButton = (Button) event.getTarget();
        String buttonLabel = clickedButton.getText();
        
        System.out.println(buttonLabel);
	}
}
