package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InstructionsController {
	@FXML
	private AnchorPane anchor;
	@FXML
	public Text label;
	
	private ArrayList<MusicSurveyOption> sureOptions;
	private Scene scene;
	private String dataFilePath = "";
	
	@FXML
	public void initialize(){
		
	}
	
	@FXML
	public void onTextClicked(MouseEvent event){
		Stage stage = (Stage) label.getScene().getWindow();
	    stage.close();
	    
	    randomiseArrayList();
	    writeToFile(dataFilePath, "\nOptions sure of (in randomised order):\n");
	    for (int i = 0; i < sureOptions.size(); i++){
	    	writeToFile(dataFilePath, sureOptions.get(i).getLabelName()+"\n");
	    }
	    
	    for (int i = 0; i < sureOptions.size(); i++){
	    	Random r = new Random();
	    	String genreChosen = sureOptions.get(i).getLabelName();
	    	
	    	File dir = new File("C:\\Users\\Saran\\workspace\\IntegratedSystem\\Music\\"+genreChosen);
		    File[] files = dir.listFiles();
		    ArrayList<String> allSongs = new ArrayList<String>();
		    
		    for (int j = 0; j < files.length; j++){
		    	if (files[j].getName().endsWith("-shortened.wav")) allSongs.add(files[j].getName());
		    }
		    
		    int size = allSongs.size();
		    
		    for (int k = 0; k < size; k++){
			    int num2 = r.nextInt(allSongs.size());
			    
			    String filePath = "Music/"+genreChosen+"/"+allSongs.get(num2);
		    	allSongs.remove(num2);
			    
		    	writeToFile(dataFilePath, "\nSong "+(k+1)+" from Genre "+genreChosen+":\t"+filePath+"\n");
		    	
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
				
				FXMLLoader loader2 = new FXMLLoader();
				loader2.setLocation(getClass().getResource("/app/InterMusicSurvey.fxml"));
				try{
					loader2.load();
				} catch(IOException e){
					e.printStackTrace();
				}
				InterMusicSurveyController imContr = loader2.getController();
				Parent root2 = loader2.getRoot();
				Scene scene2 = new Scene(root2);
				Stage stage2 = new Stage();
				stage2.setScene(scene2);
				stage2.setResizable(false);
				imContr.setData(dataFilePath);
				stage2.showAndWait();
				
				if (k < size-1){
					FXMLLoader loader3 = new FXMLLoader();
					loader3.setLocation(getClass().getResource("/app/SimpleTimer.fxml"));
					try{
						loader3.load();
					} catch(IOException e){
						e.printStackTrace();
					}
					Parent root3 = loader3.getRoot();
					Scene scene3 = new Scene(root3);
					Stage stage3 = new Stage();
					stage3.setScene(scene3);
					stage3.setResizable(false);
					stage3.showAndWait();
				}
		    }
		    
		    FXMLLoader loader3 = new FXMLLoader();
			loader3.setLocation(getClass().getResource("/app/InterGenreSurvey.fxml"));
			try{
				loader3.load();
			} catch(IOException e){
				e.printStackTrace();
			}
			InterGenreSurveyController intGenController = loader3.getController();
			Parent root3 = loader3.getRoot();
			Scene scene3 = new Scene(root3);
			Stage stage3 = new Stage();
			stage3.setScene(scene3);
			stage3.setResizable(false);
			intGenController.sendData(dataFilePath);
			stage3.showAndWait();
			
			if (i < sureOptions.size()-1){
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
	    
	    FXMLLoader loader4 = new FXMLLoader();
		loader4.setLocation(getClass().getResource("/app/EndScreen.fxml"));
		try{
			loader4.load();
		} catch(IOException e){
			e.printStackTrace();
		}
		Parent root4 = loader4.getRoot();
		Scene scene4 = new Scene(root4);
		Stage stage4 = new Stage();
		stage4.setScene(scene4);
		stage4.setResizable(false);
		stage4.showAndWait();
	}
	
	public void sendData(ArrayList<MusicSurveyOption> s, String d){
		sureOptions = s;
		dataFilePath = d;
	}
	
	private void randomiseArrayList(){
		Collections.shuffle(sureOptions);
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
