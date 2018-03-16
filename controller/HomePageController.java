package app;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class HomePageController {
	@FXML
	public Pane option1;
	@FXML
	public Pane option2;
	@FXML
	public void initialize(){
		option1.setOnMouseEntered(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent t) {
	        	option1.setStyle("-fx-background-color:#dae7f3;");
	        }
	    });

		option1.setOnMouseExited(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent t) {
	        	option1.setStyle("-fx-background-color:transparent;");
	        }
	    });
		option1.setOnMousePressed(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent t) {
	        	option1.setStyle("-fx-background-color:#73b6f4;");
	        }
	    });
		
		option1.setOnMouseReleased(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent t) {
	        	option1.setStyle("-fx-background-color:#dae7f3;");
	        }
	    });
		
		option2.setOnMouseEntered(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent t) {
	        	option2.setStyle("-fx-background-color:#dae7f3;");
	        }
	    });

		option2.setOnMouseExited(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent t) {
	        	option2.setStyle("-fx-background-color:transparent;");
	        }
	    });
		
		option2.setOnMousePressed(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent t) {
	        	option2.setStyle("-fx-background-color:#73b6f4;");
	        }
	    });
		
		option2.setOnMouseReleased(new EventHandler<MouseEvent>
	    () {

	        @Override
	        public void handle(MouseEvent t) {
	        	option2.setStyle("-fx-background-color:#dae7f3;");
	        }
	    });
	}
}
