package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MusicPlayerController {
	@FXML
	public Label nameLabel;
	@FXML
	public Label startLabel;
	@FXML
	public Label endLabel;
	@FXML
	public Label statusLabel;
	
	private String musicPath = "";
	private Scene scene;
	private String dataFilePath = "";
	
	@FXML
	public void initialize(){
		
	}
	
	@SuppressWarnings("deprecation")
	public void sendData(String s, Scene sc, String d){
		musicPath = s;
		dataFilePath = d;
		System.out.println(musicPath);
		
		nameLabel.setText(s);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		startLabel.setText(timestamp.toString());
		long startTime = timestamp.getTime();
		writeToFile(dataFilePath, "\nStart:\t"+timestamp.toString());
		
		double durationInSeconds = 0.0;
		
		File file = new File(musicPath);
        try{
        	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        	AudioFormat format = audioInputStream.getFormat();
            long frames = audioInputStream.getFrameLength();
            durationInSeconds = (frames+0.0) / format.getFrameRate(); 
        } catch (Exception e){}
        
        writeToFile(dataFilePath, "\nDuration:\t"+durationInSeconds+"s");
        
        long endTime = startTime + (long) (durationInSeconds*1000);
        Date date = new Date(endTime);
        
        endLabel.setText(new Timestamp(date.getTime()).toString());
        writeToFile(dataFilePath, "\nEnd:\t"+endLabel.getText());
        statusLabel.setText("Playing...");
        
        AePlayWave apw = new AePlayWave(musicPath);
	    apw.start();
        	    
	    try{
	        boolean alive = apw.isAlive();
	        while(alive){
	            //check periodically if the thread is alive         
	            alive = apw.isAlive();
	            Thread.currentThread().sleep(100);
	            	   
	            }
	    } catch(InterruptedException e){
	        System.out.println("Interrupted");
	        e.printStackTrace();
	    }
        
	    
	    statusLabel.setText("Finished");
	    
	    Stage stage = (Stage) nameLabel.getScene().getWindow();
	    
	    PauseTransition delay = new PauseTransition(Duration.seconds(1));
	    delay.setOnFinished( event -> stage.close() );
	    delay.play();
	}
	
	@FXML
	public void onNextClicked(ActionEvent event){
		Stage stage = (Stage) nameLabel.getScene().getWindow();
	    stage.close();
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


