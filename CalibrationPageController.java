package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalibrationPageController {
	@FXML
	public Text label;
	private String dataFilePath = "";
	
	private ArrayList<MusicSurveyOption> sureOptions;
	
	@FXML
	public void onTextClicked(MouseEvent event) throws InterruptedException{
		Stage stage = (Stage) label.getScene().getWindow();
	    stage.close();
    	File dir = new File("C:\\Users\\Saran\\workspace\\IntegratedSystem\\Music\\Standard");
    	File[] files = dir.listFiles();
    	writeToFile(dataFilePath, "\nCalibration Process Started\n");
    	for (int i = 0; i < files.length; i++){
    		String filePath = "Music/Standard/"+files[i].getName();
    		writeToFile(dataFilePath, "\n"+files[i].getName()+":");
    		
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/app/MusicPlayer.fxml"));
			try{
				loader.load();
			} catch(IOException e){
				e.printStackTrace();
			}
    		MusicPlayerController mpContr = loader.getController();
			Parent root = loader.getRoot();
			Scene scene = new Scene(root);
			Stage stage1 = new Stage();
			stage1.setScene(scene);
			mpContr.sendData(filePath, scene, dataFilePath);
			stage1.setResizable(false);
			stage1.showAndWait();
			
			if (i < files.length - 1){
				FXMLLoader loader2 = new FXMLLoader();
				loader2.setLocation(getClass().getResource("/app/SimpleTimer.fxml"));
				try{
					loader2.load();
				} catch(IOException e){
					e.printStackTrace();
				}
				Parent root2 = loader2.getRoot();
				Scene scene2 = new Scene(root2);
				Stage stage2 = new Stage();
				stage2.setScene(scene2);
				stage2.setResizable(false);
				stage2.showAndWait();
			}
    	}
    	
    	writeToFile(dataFilePath, "\nCalibration Process Finished\n");
    	
    	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/app/Instructions.fxml"));
		try{
			loader.load();
		} catch(IOException e){
			e.printStackTrace();
		}
		InstructionsController instrContr = loader.getController();
		Parent root = loader.getRoot();
		Scene scene = new Scene(root);
		Stage stage1 = new Stage();
		stage1.setScene(scene);
		instrContr.sendData(sureOptions, dataFilePath);
		stage1.setResizable(false);
		stage1.showAndWait();
		
	}
	
	public void sendData(String s, ArrayList<MusicSurveyOption> m){
		dataFilePath = s;
		sureOptions = m;
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
