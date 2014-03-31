public class FitnessRecord 
{
	
	public int cardio = 0;
	public int strength = 0;
	public int work = 0;
	public int sleep = 0;
	public int weight = 0;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	public int getAllInfo()
	{
		return cardio;
		//return strength;
		//return work;
		//return sleep;
		//return weight;
		
		
	}
	public int getCardio()
	{
		return cardio;
		
	}
	public int getStrength()
	{
		return strength;
		
	}
	public int getWork()
	{
		return work;
	}
	public int getSleep()
	{
		return sleep;
		
	}
	public int getWeight()
	{
		return weight;
		
	}
	public void changeCardioTime(int newTime)
	{
		cardio = newTime;
		
	}
	public void changeStrength(int newStrength)
	{
		strength = newStrength;
	}
	public void changeWork(int newWork)
	{
		work = newWork;
		
	}
	public void changeSleep(int newSleep)
	{
		sleep = newSleep;
		
	}
	public void changeWeight(int newWeight)
	{
		weight = newWeight;
	}
}