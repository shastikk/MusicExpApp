package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MusicSurveyController {
	@FXML
	public TextField nameField;
	@FXML
	public TextField ageField;
	@FXML
	public Button submitButton1;
	@FXML
	public Button submitButton2;
	@FXML
	public Label label1;
	@FXML
	public Label label2;
	@FXML
	public Label label3;
	@FXML
	public Label label4;
	@FXML
	public Label label5;
	@FXML
	public Label label6;
	@FXML
	public RadioButton rb11;
	@FXML
	public RadioButton rb12;
	@FXML
	public RadioButton rb13;
	@FXML
	public RadioButton rb14;
	@FXML
	public RadioButton rb15;
	@FXML
	public RadioButton rb16;
	@FXML
	public RadioButton rb21;
	@FXML
	public RadioButton rb22;
	@FXML
	public RadioButton rb23;
	@FXML
	public RadioButton rb24;
	@FXML
	public RadioButton rb25;
	@FXML
	public RadioButton rb26;
	@FXML
	public RadioButton rb31;
	@FXML
	public RadioButton rb32;
	@FXML
	public RadioButton rb33;
	@FXML
	public RadioButton rb34;
	@FXML
	public RadioButton rb35;
	@FXML
	public RadioButton rb36;
	@FXML
	public RadioButton rb41;
	@FXML
	public RadioButton rb42;
	@FXML
	public RadioButton rb43;
	@FXML
	public RadioButton rb44;
	@FXML
	public RadioButton rb45;
	@FXML
	public RadioButton rb46;
	@FXML
	public RadioButton rb51;
	@FXML
	public RadioButton rb52;
	@FXML
	public RadioButton rb53;
	@FXML
	public RadioButton rb54;
	@FXML
	public RadioButton rb55;
	@FXML
	public RadioButton rb56;
	@FXML
	public RadioButton rb61;
	@FXML
	public RadioButton rb62;
	@FXML
	public RadioButton rb63;
	@FXML
	public RadioButton rb64;
	@FXML
	public RadioButton rb65;
	@FXML
	public RadioButton rb66;
	@FXML
	public RadioButton notSure1;
	@FXML
	public RadioButton notSure2;
	@FXML
	public RadioButton notSure3;
	@FXML
	public RadioButton notSure4;
	@FXML
	public RadioButton notSure5;
	@FXML
	public RadioButton notSure6;
	@FXML
	public Label infoLabel;
	@FXML
	public Label removeLabel1;
	@FXML
	public Label removeLabel2;
	@FXML
	public Label removeLabel3;
	@FXML
	public Line line1;
	@FXML
	public Line line2;
	@FXML
	public Line line3;
	@FXML
	public Line line4;
	@FXML
	public Line line5;
	@FXML
	public Line line6;
	
	private ToggleGroup grp1 = new ToggleGroup();
	private ToggleGroup grp2 = new ToggleGroup();
	private ToggleGroup grp3 = new ToggleGroup();
	private ToggleGroup grp4 = new ToggleGroup();
	private ToggleGroup grp5 = new ToggleGroup();
	private ToggleGroup grp6 = new ToggleGroup();
	
	private ArrayList<RadioButton> col1 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> col2 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> col3 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> col4 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> col5 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> col6 = new ArrayList<RadioButton>();
	
	private ArrayList<RadioButton> row1 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> row2 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> row3 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> row4 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> row5 = new ArrayList<RadioButton>();
	private ArrayList<RadioButton> row6 = new ArrayList<RadioButton>();
	
	private ArrayList<ArrayList<RadioButton>> allRows = new ArrayList<ArrayList<RadioButton>>();
	private ArrayList<ArrayList<RadioButton>> allCols = new ArrayList<ArrayList<RadioButton>>();
	
	private ArrayList<Label> allLabels = new ArrayList<Label>();
	
	private ArrayList<ToggleGroup> allGroups = new ArrayList<ToggleGroup>();
	
	private ArrayList<Line> allLines = new ArrayList<Line>();
	
	private String name;
	private int age;
	private final int MIN_GENRES = 3;
	private String dataFilePath = "";
	
	
	
	@FXML
	public void initialize(){
		Collections.addAll(allLines, line1, line2, line3, line4, line5, line6);
		
		for (int i = 0; i < allLines.size(); i++){
			allLines.get(i).setVisible(false);
		}
		
		removeLabel1.setVisible(false);
		removeLabel2.setVisible(false);
		removeLabel3.setVisible(false);
		
		infoLabel.setVisible(true);
		
		Collections.addAll(row1, rb11, rb12, rb13, rb14, rb15);
		Collections.addAll(row2, rb21, rb22, rb23, rb24, rb25);
		Collections.addAll(row3, rb31, rb32, rb33, rb34, rb35);
		Collections.addAll(row4, rb41, rb42, rb43, rb44, rb45);
		Collections.addAll(row5, rb51, rb52, rb53, rb54, rb55);
		//Collections.addAll(row6, rb61, rb62, rb63, rb64, rb65, rb66);
		
		Collections.addAll(allRows, row1, row2, row3, row4, row5);
		
		Collections.addAll(col1, rb11, rb21, rb31, rb41, rb51);
		Collections.addAll(col2, rb12, rb22, rb32, rb42, rb52);
		Collections.addAll(col3, rb13, rb23, rb33, rb43, rb53);
		Collections.addAll(col4, rb14, rb24, rb34, rb44, rb54);
		Collections.addAll(col5, rb15, rb25, rb35, rb45, rb55);
		//Collections.addAll(col6, rb16, rb26, rb36, rb46, rb56, rb66);
		
		Collections.addAll(allCols, col1, col2, col3, col4, col5);
		
		submitButton1.setDisable(true);
		submitButton2.setDisable(true);
		
		ageField.setPromptText("Optional");
		ageField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    ageField.setText(oldValue);
                }
            }
        });
		
		Collections.addAll(allGroups, grp1, grp2, grp3, grp4, grp5);
		
		for (int i = 0; i < allRows.size(); i++){
			for (int j = 0; j < allRows.get(i).size(); j++){
				allRows.get(i).get(j).setDisable(true);
			}
		}
		
		for (int i = 0; i < allCols.size(); i++){
			for (int j = 0; j < allCols.get(i).size(); j++){
				allCols.get(i).get(j).setToggleGroup(allGroups.get(j));
			}
		}
		
		notSure1.setToggleGroup(grp1);
		notSure2.setToggleGroup(grp2);
		notSure3.setToggleGroup(grp3);
		notSure4.setToggleGroup(grp4);
		notSure5.setToggleGroup(grp5);
		//notSure6.setToggleGroup(grp6);
		
		notSure1.setDisable(true);
		notSure2.setDisable(true);
		notSure3.setDisable(true);
		notSure4.setDisable(true);
		notSure5.setDisable(true);
		//notSure6.setDisable(true);
		
		nameField.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable,
		            String oldValue, String newValue) {

		        if (newValue.equals("")){
		        	submitButton1.setDisable(true);
		        } else{
		        	submitButton1.setDisable(false);
		        }
		    }
		});
		
		setUpRadioButtons();
		
		label1.setOpacity(0.3);
		label2.setOpacity(0.3);
		label3.setOpacity(0.3);
		label4.setOpacity(0.3);
		label5.setOpacity(0.3);
		label6.setOpacity(0.3);
		
		Collections.addAll(allLabels, label1, label2, label3, label4, label5);
		
	}
	
	@FXML
	public void submitButton1Clicked(ActionEvent event){
		for (int i = 0; i < allLines.size(); i++){
			allLines.get(i).setVisible(true);
		}
		
		removeLabel1.setVisible(true);
		removeLabel2.setVisible(true);
		removeLabel3.setVisible(true);
		
		infoLabel.setVisible(false);
		
		name = nameField.getText();
		String ageString = ageField.getText();
		if (ageString.equals("") || ageString.equals(null)) age = 0;
		else age = Integer.parseInt(ageString);
		
		nameField.setEditable(false);
		ageField.setEditable(false);
		submitButton1.setDisable(true);
		submitButton2.setDisable(false);
		
		for (int i = 0; i < allCols.size(); i++){
			for (int j = 0; j < allCols.get(i).size(); j++){
				allCols.get(i).get(j).setDisable(false);
			}
		}
		
		label1.setOpacity(1);
		label2.setOpacity(1);
		label3.setOpacity(1);
		label4.setOpacity(1);
		label5.setOpacity(1);
		//label6.setOpacity(1);
		
		label1.setTextFill(Color.web("#961313"));
		label2.setTextFill(Color.web("#961313"));
		label3.setTextFill(Color.web("#961313"));
		label4.setTextFill(Color.web("#961313"));
		label5.setTextFill(Color.web("#961313"));
		//label6.setTextFill(Color.web("#961313"));
		
		/*notSure1.setDisable(false);
		notSure2.setDisable(false);
		notSure3.setDisable(false);
		notSure4.setDisable(false);*/
		
		System.out.println("Name: "+ name + " Age: " + age);
		dataFilePath = "C:\\Users\\Saran\\workspace\\IntegratedSystem\\Data\\"+name.toUpperCase()+"_data.txt";
		
		try {
			
		      File file = new File(dataFilePath);

		      if (file.createNewFile()){
		        System.out.println("File is created!");
		      }else{
		        System.out.println("File already exists.");
		      }

	    	} catch (IOException e) {
		      e.printStackTrace();
		}
		writeToFile(dataFilePath, "Name: "+name+"\tAge: "+age);
	}
	
	@FXML
	public void submitButton2Clicked(ActionEvent event) throws InterruptedException{
		if (grp1.getSelectedToggle() == null || grp2.getSelectedToggle() == null || grp3.getSelectedToggle() == null || grp4.getSelectedToggle() == null || grp5.getSelectedToggle() == null){
			Alert alert = new Alert(AlertType.ERROR, "Please input responses for all "+allGroups.size()+" genres ", ButtonType.OK);
	    	alert.showAndWait();
		} else {
			ArrayList<MusicSurveyOption> sureOptions = new ArrayList<MusicSurveyOption>();
			for (int i = 0; i < allGroups.size(); i++){
				String s = allGroups.get(i).getSelectedToggle().toString();
				int index = s.indexOf("id");
				if (s.charAt(index+3) == 'r'){
					sureOptions.add(new MusicSurveyOption(allLabels.get(i).getText(), Integer.parseInt(""+s.charAt(index+6))));
				}
			}
			if (sureOptions.size() < MIN_GENRES){
				Alert alert = new Alert(AlertType.ERROR, "You have to be sure of at least "+MIN_GENRES+" genres", ButtonType.OK);
		    	alert.showAndWait();
			} else{
				Collections.sort(sureOptions);
				writeToFile(dataFilePath, "\n\nOptions sure of (in sorted order):\n");
				for (int i = 0; i < sureOptions.size(); i++){
					System.out.println(sureOptions.get(i).getLabelName() + " ");
					writeToFile(dataFilePath, sureOptions.get(i).getLabelName()+"\n");
				}
				
				Stage stage = (Stage) rb11.getScene().getWindow();
			    stage.close();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/app/CalibrationPage.fxml"));
				try{
					loader.load();
				} catch(IOException e){
					e.printStackTrace();
				}
				CalibrationPageController caliContr = loader.getController();
				Parent root = loader.getRoot();
				Scene scene = new Scene(root);
				Stage stage1 = new Stage();
				stage1.setScene(scene);
				caliContr.sendData(dataFilePath, sureOptions);
				stage1.setResizable(false);
				stage1.showAndWait();
			    /*FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/app/MusicPlayer.fxml"));
				try{
					loader.load();
				} catch(IOException e){
					e.printStackTrace();
				}
				MusicPlayerController caliContr = loader.getController();
				Parent root = loader.getRoot();
				Scene scene = new Scene(root);
				Stage stage1 = new Stage();
				stage1.setScene(scene);
				caliContr.sendData(dataFilePath, scene, "");
				stage1.setResizable(false);
				stage1.showAndWait();*/
			   
			}
		}
	}
	
	private void setUpRadioButtons(){
		rb11.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		        if (isNowSelected) { 
		        	label1.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col1.size(); i++){
		            	if (i != 0 && col1.get(i).isSelected()){
		            		col1.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb12.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label1.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col2.size(); i++){
		            	if (i != 0 && col2.get(i).isSelected()){
		            		col2.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb13.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label1.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col3.size(); i++){
		            	if (i != 0 && col3.get(i).isSelected()){
		            		col3.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb14.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label1.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col4.size(); i++){
		            	if (i != 0 && col4.get(i).isSelected()){
		            		col4.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb15.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label1.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col5.size(); i++){
		            	if (i != 0 && col5.get(i).isSelected()){
		            		col5.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb16.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label1.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col6.size(); i++){
		            	if (i != 0 && col6.get(i).isSelected()){
		            		col6.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb21.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label2.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col1.size(); i++){
		            	if (i != 1 && col1.get(i).isSelected()){
		            		col1.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb22.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label2.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col2.size(); i++){
		            	if (i != 1 && col2.get(i).isSelected()){
		            		col2.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb23.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label2.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col3.size(); i++){
		            	if (i != 1 && col3.get(i).isSelected()){
		            		col3.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb24.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label2.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col4.size(); i++){
		            	if (i != 1 && col4.get(i).isSelected()){
		            		col4.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb25.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label2.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col5.size(); i++){
		            	if (i != 1 && col5.get(i).isSelected()){
		            		col5.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb26.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label2.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col6.size(); i++){
		            	if (i != 1 && col6.get(i).isSelected()){
		            		col6.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb31.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label3.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col1.size(); i++){
		            	if (i != 2 && col1.get(i).isSelected()){
		            		col1.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb32.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label3.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col2.size(); i++){
		            	if (i != 2 && col2.get(i).isSelected()){
		            		col2.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb33.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label3.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col3.size(); i++){
		            	if (i != 2 && col3.get(i).isSelected()){
		            		col3.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb34.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label3.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col4.size(); i++){
		            	if (i != 2 && col4.get(i).isSelected()){
		            		col4.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb35.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label3.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col5.size(); i++){
		            	if (i != 2 && col5.get(i).isSelected()){
		            		col5.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb36.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label3.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col6.size(); i++){
		            	if (i != 2 && col6.get(i).isSelected()){
		            		col6.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb41.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label4.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col1.size(); i++){
		            	if (i != 3 && col1.get(i).isSelected()){
		            		col1.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb42.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label4.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col2.size(); i++){
		            	if (i != 3 && col2.get(i).isSelected()){
		            		col2.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb43.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label4.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col3.size(); i++){
		            	if (i != 3 && col3.get(i).isSelected()){
		            		col3.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb44.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label4.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col4.size(); i++){
		            	if (i != 3 && col4.get(i).isSelected()){
		            		col4.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb45.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label4.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col5.size(); i++){
		            	if (i != 3 && col5.get(i).isSelected()){
		            		col5.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb46.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label4.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col6.size(); i++){
		            	if (i != 3 && col6.get(i).isSelected()){
		            		col6.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb51.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label5.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col1.size(); i++){
		            	if (i != 4 && col1.get(i).isSelected()){
		            		col1.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb52.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label5.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col2.size(); i++){
		            	if (i != 4 && col2.get(i).isSelected()){
		            		col2.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb53.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label5.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col3.size(); i++){
		            	if (i != 4 && col3.get(i).isSelected()){
		            		col3.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb54.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label5.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col4.size(); i++){
		            	if (i != 4 && col4.get(i).isSelected()){
		            		col4.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb55.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label5.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col5.size(); i++){
		            	if (i != 4 && col5.get(i).isSelected()){
		            		col5.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb56.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label5.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col6.size(); i++){
		            	if (i != 4 && col6.get(i).isSelected()){
		            		col6.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb61.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label6.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col1.size(); i++){
		            	if (i != 5 && col1.get(i).isSelected()){
		            		col1.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb62.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label6.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col2.size(); i++){
		            	if (i != 5 && col2.get(i).isSelected()){
		            		col2.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb63.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label6.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col3.size(); i++){
		            	if (i != 5 && col3.get(i).isSelected()){
		            		col3.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb64.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label6.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col4.size(); i++){
		            	if (i != 5 && col4.get(i).isSelected()){
		            		col4.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb65.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label6.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col5.size(); i++){
		            	if (i != 5 && col5.get(i).isSelected()) {
		            		col5.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		rb66.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label6.setTextFill(Color.web("#209313"));
		            for (int i = 0; i < col6.size(); i++){
		            	if (i != 5 && col6.get(i).isSelected()) {
		            		col6.get(i).setSelected(false);
		            		allLabels.get(i).setTextFill(Color.web("#961313"));
		            	}
		            }
		        }
		    }
		});
		
		notSure1.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label1.setTextFill(Color.web("#209313"));
		        }
		    }
		});
		
		notSure2.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label2.setTextFill(Color.web("#209313"));
		        }
		    }
		});
		
		notSure3.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label3.setTextFill(Color.web("#209313"));
		        }
		    }
		});
		
		notSure4.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label4.setTextFill(Color.web("#209313"));
		        }
		    }
		});
		
		notSure5.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label5.setTextFill(Color.web("#209313"));
		        }
		    }
		});
		
		notSure6.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
		    	if (isNowSelected) { 
		    		label6.setTextFill(Color.web("#209313"));
		        }
		    }
		});
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
