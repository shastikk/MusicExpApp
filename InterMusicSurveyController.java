package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class InterMusicSurveyController {
	@FXML
	public Slider slider1;
	@FXML
	public Slider slider2;
	@FXML
	public Slider slider3;
	
	private String dataFilePath = "";
	
	@FXML
	public void initialize(){
		
		slider1.setMajorTickUnit(5);
		slider1.setMinorTickCount(4);
		slider1.setSnapToTicks(true);
		slider1.setShowTickMarks(true);
		
		slider2.setMajorTickUnit(5);
		slider2.setMinorTickCount(4);
		slider2.setSnapToTicks(true);
		slider2.setShowTickMarks(true);
		
		slider3.setMax(5);
		slider3.setMajorTickUnit(5);
		slider3.setMinorTickCount(4);
		slider3.setSnapToTicks(true);
		slider3.setShowTickMarks(true);
		
		slider1.setShowTickLabels(true);
		slider2.setShowTickLabels(true);
		slider3.setShowTickLabels(true);
	}
	
	@FXML
	public void onOkClicked(ActionEvent event){
		if (slider3.getValue() == 0){
			Alert alert = new Alert(AlertType.ERROR, "Please do not leave the rating as 0", ButtonType.OK);
	    	alert.showAndWait();
		} else{
			System.out.println(slider1.getValue());
			System.out.println(slider2.getValue());
			System.out.println(slider3.getValue());
			
			writeToFile(dataFilePath, "\n\nMusic Survey Results: ");
			writeToFile(dataFilePath, "\nQN 1 response:\t"+slider1.getValue());
			writeToFile(dataFilePath, "\nQN 2 response:\t"+slider2.getValue());
			writeToFile(dataFilePath, "\nQN 3 response:\t"+slider3.getValue()+"\n");
			
			Stage stage = (Stage) slider1.getScene().getWindow();
		    stage.close();
		}
	}
	
	public void setData(String s){
		dataFilePath = s;
	}
	
	private void writeToFile(String fileName, String message){
		File log = new File(fileName);
		    try{
		    if(log.exists()==false){
		            System.out.println("We had to make a new file.");
		            log.createNewFile();
		    }
		    PrintWriter out = new PrintWriter(new FileWriter(log, true));
		    out.append(message);
		    out.close();
		    }catch(IOException e){
		        System.out.println("COULD NOT LOG!!");
		    }
	}
}
