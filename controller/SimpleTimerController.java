package app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SimpleTimerController {
	@FXML
	public Button button;
	@FXML
	public Label label1;
	@FXML
	public Label label2;
	private Timeline timeline;
	
	@FXML
	public void initialize(){
		label2.setVisible(false);
		button.setVisible(false);
		button.fire();
	}
	private int time = 9;
	@FXML
	public void onButtonPressed(ActionEvent event){
		timeline = new Timeline(new KeyFrame(
		        Duration.millis(1000),
		        ae -> labelUpdate(time--)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	private void labelUpdate(int i){
		if (i > 0) {
			label1.setText(""+i);
			label1.setAlignment(Pos.CENTER);
			if (i < 6) label2.setVisible(true);
		}
		else{
			timeline.stop();
			Stage stage = (Stage)label1.getScene().getWindow();
			stage.close();
		}
	}
}
