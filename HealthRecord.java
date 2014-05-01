import java.util.Scanner;
public class HealthRecord {
	public String bloodSugar;
	public String bloodPressure;
	public String pulse;
	
	HealthRecord(){
		bloodSugar = "Not Measured Yet";
		bloodPressure = "Not Measured Yet";
		pulse = "Not Measured Yet";		
	}
	public String toString(){
		return "<html>" +bloodPressure + "<br><br>"
				+bloodSugar+"<br><br>"
				+pulse + "<br><br>"
				+"<html>";
	}
	
	public String getSugar(){
		return bloodSugar;	
	}
	public String getPressure(){
		return bloodPressure;
	}
	public String getPulse(){
		return pulse;
			
	}
	public void changeSugar(String newSugar){
		bloodSugar = newSugar;
	}
	public void changePressure(String newPressure){
		bloodPressure = newPressure;	
	}
	public void changePulse(String newPulse){
		pulse = newPulse;
	}
}


