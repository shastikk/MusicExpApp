package app;

public class MusicSurveyOption implements Comparable<MusicSurveyOption>{
	private String labelName;
	private Integer order;
	
	public MusicSurveyOption(String s, Integer o){
		labelName = s;
		order = o;
	}
	
	public int compareTo(MusicSurveyOption other){
		return order.compareTo(other.order);
	}
	
	public int getOrder(){
		return order;
	}
	
	public String getLabelName(){
		return labelName;
	}
}
