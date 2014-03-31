import java.util.Scanner;
public class HealthRecord 
{
	public int bloodSugar = 0;
	public int bloodPressure = 0;
	public int pulse = 0;
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		
	}
		public int getSugar()
		{
			return bloodSugar;
			
		}
		public int getPressure()
		{
			return bloodPressure;
		}
		public int getPulse()
		{
			return pulse;
			
		}
		
		
		public void changeSugar(int newSugar)
		{
			bloodSugar = newSugar;
		}
		public void changePressure(int newPressure)
		{
			bloodPressure = newPressure;
			
		}
		public void changePulse(int newPulse)
		{
			pulse = newPulse;
		}
	}


