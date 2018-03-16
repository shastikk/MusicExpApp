package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class InterGenreSurveyController {

	@FXML
	public RadioButton rb11;
	@FXML
	public RadioButton rb12;
	@FXML
	public RadioButton rb21;
	@FXML
	public RadioButton rb22;
	@FXML
	public RadioButton rb31;
	@FXML
	public RadioButton rb32;
	@FXML
	public TextArea textArea;
	
	private ToggleGroup grp1 = new ToggleGroup();
	private ToggleGroup grp2 = new ToggleGroup();
	private ToggleGroup grp3 = new ToggleGroup();
	
	private String dataFilePath = "";
	
	@FXML
	public void initialize(){

		rb11.setToggleGroup(grp1);
		rb12.setToggleGroup(grp1);
		rb21.setToggleGroup(grp2);
		rb22.setToggleGroup(grp2);
		rb31.setToggleGroup(grp3);
		rb32.setToggleGroup(grp3);
		
		rb11.setUserData("Yes");
		rb12.setUserData("No");
		rb21.setUserData("Yes");
		rb22.setUserData("No");
		rb31.setUserData("Yes");
		rb32.setUserData("No");
	}
	
	@FXML
	public void onOKClicked(ActionEvent event){
		if (grp1.getSelectedToggle() == null || grp2.getSelectedToggle() == null || grp3.getSelectedToggle() == null){
			Alert alert = new Alert(AlertType.ERROR, "Please fill in all responses before continuing", ButtonType.OK);
	    	alert.showAndWait();
		} else {
			System.out.println(grp1.getSelectedToggle().getUserData());
			System.out.println(grp2.getSelectedToggle().getUserData());
			
			writeToFile(dataFilePath, "\n\nGenre Survey Results:");
			writeToFile(dataFilePath, "\nQN 1 response:\t"+grp1.getSelectedToggle().getUserData());
			writeToFile(dataFilePath, "\nQN 2 response:\t"+grp2.getSelectedToggle().getUserData());
			writeToFile(dataFilePath, "\nQN 3 response:\t"+grp3.getSelectedToggle().getUserData());
			writeToFile(dataFilePath, "\nQN 4 response:\t"+textArea.getText()+"\n");
			
			Stage stage = (Stage) rb11.getScene().getWindow();
		    stage.close();
		}
	}
	
	public void sendData(String s){
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
