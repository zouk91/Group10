import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


public class LoginScreen extends JFrame 
						 implements ActionListener{
	private static JFrame frame = new JFrame();
	private  JPanel panel;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JButton createUser, loginButton, viewRecord, viewSummary, cancel, create,edit,logOut,createNew ;
	private JLabel label;
	private JTextField userName, password;
	private JComboBox cardioHours,cardioMinutes,strengthHours,strengthMinutes,workHours,workMinutes,sleepHours,sleepMinutes;
	private JComboBox pressureMeasure,sugarMeasure,pulseMeasure;
	private static Profile[] arrayOfProfiles;
	final int width = 700; //frame width
	final int height = 700;
	private String currentName,currentPassword;
	
	public static void main(String[] args){
		GUIInterface();	
	}
	
	static void GUIInterface() {
		frame = new LoginScreen();
		arrayOfProfiles = new Profile[20];
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);	
	}
	
	LoginScreen(){
		loginScreen();
		add(panel);
	}
	
	void loginScreen(){
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0,0);
		panel.setSize(700,700);
		createUser = new JButton("Create New User");
		createUser.setLocation(150,450);
		createUser.setSize(150,30);
		loginButton = new JButton("Sign In");
		loginButton.setLocation(380,450);
		loginButton.setSize(150,30);
		label = new JLabel("Enter Your Login Information");
		label.setLocation(260,150);
		label.setSize(250,100);
		userName = new JTextField("UserName");
		userName.setLocation(150,250);
		userName.setSize(150,30);
		password = new JTextField("Password");
		password.setLocation(350,250);
		password.setSize(150,30);
		
		panel.add(createUser);
		panel.add(loginButton);
		panel.add(label);
		panel.add(userName);
		panel.add(password);
		createUser.addActionListener(this);
		loginButton.addActionListener(this);
	}
	
	void MainMenu(){
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setLocation(0,0);
		panel2.setSize(700,700);
		JLabel success;

		createNew = new JButton("Create Daily Record");
		createNew.setLocation(275,150);
		createNew.setSize(200,50);
		viewRecord = new JButton("View Record");
		viewRecord.setLocation(275,220);
		viewRecord.setSize(200,50);
		viewSummary = new JButton("View Summary");
		viewSummary.setLocation(275,290);
		viewSummary.setSize(200,50);
		logOut = new JButton("Log Out");
		logOut.setLocation(150,450);
		logOut.setSize(200,50);
		
		success = new JLabel("Select an Option Below");
		success.setLocation(250,100);
		success.setSize(220,30);
		success.setFont(new Font("Dialog",Font.BOLD,18));
		
		viewRecord.addActionListener(this);
		createNew.addActionListener(this);
		logOut.addActionListener(this);
		//viewSummary.addActionListener(listener);

		panel2.add(viewRecord);
		panel2.add(viewSummary);
		panel2.add(logOut);
		panel2.add(createNew);
		panel2.add(success);
	}
	
	void ViewRecordOverview(){
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setLocation(0,0);
		panel3.setSize(width,height);
		JLabel firstNotice ,secondNotice , physical, health, cardio, strength, work, slept, pressure, sugar, rate;
		JLabel fitnessHours, measurements;
		cancel = new JButton("Cancel");
		cancel.setLocation(150,450);
		cancel.setSize(150,30);
		panel3.add(cancel);
		edit = new JButton("Edit Daily Record");
		edit.setLocation(380,450);
		edit.setSize(150,30);
		panel3.add(edit);
		physical = new JLabel("Physical Activities:");
		physical.setLocation(100,50);
		physical.setSize(150,50);
		physical.setFont(new Font("Dialog",1,16));
		panel3.add(physical);
		firstNotice = new JLabel("Below is all the activities done for today");
		firstNotice.setLocation(140,85);
		firstNotice.setSize(250,25);
		panel3.add(firstNotice);
		cardio = new JLabel("Cardio Workout");
		cardio.setLocation(195,110);
		cardio.setSize(130,20);
		panel3.add(cardio);
		strength= new JLabel("Strength Workout");
		strength.setLocation(195,140);
		strength.setSize(130,20);
		panel3.add(strength);
		work = new JLabel("Work Hours");
		work.setLocation(195,170);
		work.setSize(130,20);
		panel3.add(work);
		slept = new JLabel("Time Slept");
		slept.setLocation(195,200);
		slept.setSize(130,20);
		panel3.add(slept);
		health = new JLabel("Health Indicators:");
		health.setLocation(100,220);
		health.setSize(150,50);
		health.setFont(new Font("Dialog",1,16));
		panel3.add(health);
		secondNotice = new JLabel("Below are the measurements taken today");
		secondNotice.setLocation(140,255);
		secondNotice.setSize(300,25);
		panel3.add(secondNotice);
		pressure= new JLabel("Blood Pressure");
		pressure.setLocation(195,280);
		pressure.setSize(130,20);
		panel3.add(pressure);
		sugar = new JLabel("Blood Sugar");
		sugar.setLocation(195,310);
		sugar.setSize(130,20);
		panel3.add(sugar);
		rate = new JLabel("Pulse Rate");
		rate.setLocation(195,340);
		rate.setSize(130,20);
		panel3.add(rate);

		fitnessHours = new JLabel(getCurrentProfile().getAllRecords().getDaily().getFitness().toString());
		fitnessHours.setLocation(420,100);
		fitnessHours.setSize(130,145);
		panel3.add(fitnessHours);
		measurements = new JLabel(getCurrentProfile().getAllRecords().getDaily().getHealth().toString());
		measurements.setLocation(420,270);
		measurements.setSize(130,110);
		panel3.add(measurements);
		
		cancel.addActionListener(this);
		edit.addActionListener(this);
	}
	
	void editOverview(){
		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setLocation(0,0);
		panel4.setSize(width,height);
		
		JLabel topNotice,firstNotice ,secondNotice , physical, health, cardio, strength, work, slept, pressure, sugar, rate, hours,minutes;
		topNotice = new JLabel("Please Select Information Below");
		topNotice.setLocation(180,10);
		topNotice.setSize(300,30);
		topNotice.setFont(new Font("Dialog",Font.BOLD,18));
		panel4.add(topNotice);
		cancel = new JButton("Cancel");
		cancel.setLocation(150,450);
		cancel.setSize(150,30);
		panel4.add(cancel);
		create = new JButton("Save Information");
		create.setLocation(380,450);
		create.setSize(150,30);
		panel4.add(create);
		physical = new JLabel("Physical Activities:");
		physical.setLocation(100,50);
		physical.setSize(150,50);
		physical.setFont(new Font("Dialog",1,16));
		panel4.add(physical);
		firstNotice = new JLabel("Below is all the activities done for today");
		firstNotice.setLocation(140,85);
		firstNotice.setSize(250,25);
		panel4.add(firstNotice);
		cardio = new JLabel("Cardio Workout");
		cardio.setLocation(195,110);
		cardio.setSize(130,20);
		panel4.add(cardio);
		strength= new JLabel("Strength Workout");
		strength.setLocation(195,140);
		strength.setSize(130,20);
		panel4.add(strength);
		work = new JLabel("Work Hours");
		work.setLocation(195,170);
		work.setSize(130,20);
		panel4.add(work);
		slept = new JLabel("Time Slept");
		slept.setLocation(195,200);
		slept.setSize(130,20);
		panel4.add(slept);
		
		hours = new JLabel("Hours");
		hours.setSize(130,20);
		hours.setLocation(420,85);
		panel4.add(hours);
		minutes = new JLabel("Minutes");
		minutes.setSize(130,20);
		minutes.setLocation(530,85);
		panel4.add(minutes);
		
		health = new JLabel("Health Indicators:");
		health.setLocation(100,220);
		health.setSize(150,50);
		health.setFont(new Font("Dialog",1,16));
		panel4.add(health);
		secondNotice = new JLabel("Below are the measurements taken today");
		secondNotice.setLocation(140,255);
		secondNotice.setSize(300,25);
		panel4.add(secondNotice);
		pressure= new JLabel("Blood Pressure");
		pressure.setLocation(195,280);
		pressure.setSize(130,20);
		panel4.add(pressure);
		sugar = new JLabel("Blood Sugar");
		sugar.setLocation(195,310);
		sugar.setSize(130,20);
		panel4.add(sugar);
		rate = new JLabel("Pulse Rate");
		rate.setLocation(195,340);
		rate.setSize(130,20);
		panel4.add(rate);

		//String options presented to the user in combo boxes.
		String[] optionsMinutes = {"0","15","30","45"};
		String[] optionsHours ={"0","1","2","3","4","5","6","7","8","9","10"};
		String[] optionsPressure = {"No Data","<60mmHg","60-80mmHg","90-179mmHg"};
		String[] optionsSugar = {"No Data","<3.5mmol/L","3.5-4.5mmol/L",">4.5mmol/L"};
		String[] optionsPulse = {"No Data","<50BPM","50-60BPM","60-70BPM","70-80BPM",">80BPM"};
		
		//Physical activities uneditable comboBoxes.
		cardioHours = new JComboBox(optionsHours);
		cardioHours.setLocation(420,110);
		cardioHours.setSize(40,20);
		panel4.add(cardioHours);
		cardioMinutes = new JComboBox(optionsMinutes);
		cardioMinutes.setLocation(530,110);
		cardioMinutes.setSize(40,20);
		panel4.add(cardioMinutes);
		strengthHours = new JComboBox(optionsHours);
		strengthHours.setLocation(420,140);
		strengthHours.setSize(40,20);
		panel4.add(strengthHours);
		strengthMinutes = new JComboBox(optionsMinutes);
		strengthMinutes.setLocation(530,140);
		strengthMinutes.setSize(40,20);
		panel4.add(strengthMinutes);
		workHours = new JComboBox(optionsHours);
		workHours.setLocation(420,170);
		workHours.setSize(40,20);
		panel4.add(workHours);
		workMinutes = new JComboBox(optionsMinutes);
		workMinutes.setLocation(530,170);
		workMinutes.setSize(40,20);
		panel4.add(workMinutes);
		sleepHours = new JComboBox(optionsHours);
		sleepHours.setLocation(420,200);
		sleepHours.setSize(40,20);
		panel4.add(sleepHours);
		sleepMinutes = new JComboBox(optionsMinutes);
		sleepMinutes.setLocation(530,200);
		sleepMinutes.setSize(40,20);
		panel4.add(sleepMinutes);
		
		//Health Indicators uneditable combo Boxes.
		pressureMeasure = new JComboBox(optionsPressure);
		pressureMeasure.setLocation(420,280);
		pressureMeasure.setSize(110,20);
		panel4.add(pressureMeasure);
		sugarMeasure = new JComboBox(optionsSugar);
		sugarMeasure.setLocation(420,310);
		sugarMeasure.setSize(110,20);
		panel4.add(sugarMeasure);
		pulseMeasure = new JComboBox(optionsPulse);
		pulseMeasure.setLocation(420,340);
		pulseMeasure.setSize(110,20);
		panel4.add(pulseMeasure);
		
		//Action Listeners added to the buttons
		cancel.addActionListener(this);
		create.addActionListener(this);
	}
	

	
	public int createNewProfile(String aName, String aPassword){
		Profile anewProfile = new Profile(aName, aPassword);
		int i = 0;
		while(arrayOfProfiles[i] != null && i<arrayOfProfiles.length)
			i++;
		arrayOfProfiles[i] = anewProfile;
		return i;
	}
	
	public Profile getCurrentProfile(){
		int i =0;
		while(!arrayOfProfiles[i].getInfo().equals(currentName+currentPassword) && i<arrayOfProfiles.length){
			i++;
		}
		return arrayOfProfiles[i];
	}
	
	public boolean verifyLogin(String name, String password){
		int i = 0;
		while(arrayOfProfiles[i] != null && i<arrayOfProfiles.length){
			if((name + password).equals(arrayOfProfiles[i].getInfo()))
				return true;
			i++;
		}
		return false;
	}
	
	public void getUserInput(){
		int tempH, tempM;
		String temp;
		tempH = Integer.parseInt((String)cardioHours.getSelectedItem());
		tempM = Integer.parseInt((String)cardioMinutes.getSelectedItem());
		getCurrentProfile().getAllRecords().getDaily().getFitness().changeCardioTime(tempH*60 + tempM);
		tempH = Integer.parseInt((String)strengthHours.getSelectedItem());
		tempM = Integer.parseInt((String)strengthMinutes.getSelectedItem());
		getCurrentProfile().getAllRecords().getDaily().getFitness().changeStrength(tempH*60 + tempM);
		tempH = Integer.parseInt((String)workHours.getSelectedItem());
		tempM = Integer.parseInt((String)workMinutes.getSelectedItem());
		getCurrentProfile().getAllRecords().getDaily().getFitness().changeWork(tempH*60 + tempM);
		tempH = Integer.parseInt((String)sleepHours.getSelectedItem());
		tempM = Integer.parseInt((String)sleepMinutes.getSelectedItem());
		getCurrentProfile().getAllRecords().getDaily().getFitness().changeSleep(tempH*60 + tempM);
		temp = (String)pressureMeasure.getSelectedItem();
		getCurrentProfile().getAllRecords().getDaily().getHealth().changePressure(temp);
		temp = (String)sugarMeasure.getSelectedItem();
		getCurrentProfile().getAllRecords().getDaily().getHealth().changeSugar(temp);
		temp = (String)pulseMeasure.getSelectedItem();
		getCurrentProfile().getAllRecords().getDaily().getHealth().changePulse(temp);
	}
	
	public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		int index;
		if(source == createUser){
			currentName = userName.getText();
			currentPassword = password.getText();
			if(!verifyLogin(currentName, currentPassword)){
				index = createNewProfile(currentName, currentPassword);
				MainMenu();
				getContentPane().removeAll();
				getContentPane().add(panel2);
				setTitle("Main Menu");
				validate();
				repaint();
			}
			//else if(verifyLogin(currentName,currentPassword))
			//profile already exist, can't create profile with same name
		}
		else if(source == loginButton){
			currentName = userName.getText();
			currentPassword = password.getText();
			if(verifyLogin(currentName, currentPassword)){
				MainMenu();
				getContentPane().removeAll();
				getContentPane().add(panel2);
				setTitle("Main Menu");
				validate();
				repaint();
			}
		}
		else if(source == viewRecord){
			ViewRecordOverview();
			getContentPane().removeAll();
			getContentPane().add(panel3);
			setTitle("Daily Record Overview");
			validate();
			repaint();
		}
		else if(source == cancel){
			MainMenu();
			getContentPane().removeAll();
			getContentPane().add(panel2);
			setTitle("Main Menu");
			validate();
			repaint();
		}
		else if(source == edit || source == createNew){
			editOverview();
			getContentPane().removeAll();
			getContentPane().add(panel4);
			setTitle("Edit Overview");
			validate();
			repaint();
		}
		else if(source == create){
			getUserInput();
			ViewRecordOverview();
			getContentPane().removeAll();
			getContentPane().add(panel3);
			setTitle("Daily Record Overview");
			validate();
			repaint();
		}
		else if(source == logOut){
			loginScreen();
			ViewRecordOverview();
			getContentPane().removeAll();
			getContentPane().add(panel);
			setTitle("Daily Record Overview");
			validate();
			repaint();
		}
		else if(source == viewSummary){
			//PickSummary();
		//}
		//else if(source == weeklySummary){
			//ViewSummary()
		//}
		//else if(source == monthlySummary){
			//ViewSummary();
		//}
			
		}
	
}
