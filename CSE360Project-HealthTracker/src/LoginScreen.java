import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


public class LoginScreen extends JFrame{
	//JFrame frame = new JFrame();
	private JPanel panel, panel2, panel3;
	private JButton createUser, loginButton, viewRecord, viewSummary;
	private JLabel label;
	private JTextField userName, password;
	private Profile[] arrayOfProfiles;
	final int width = 700; //frame width
	final int height = 700;
	
	public static void main(String []args){
		JFrame frame = new LoginScreen();
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);	
	}
	
	public LoginScreen(){
		panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(0,0);
		panel.setSize(700,700);
		createUser = new JButton("Create New User");
		createUser.setLocation(185,450);
		createUser.setSize(150,30);
		loginButton = new JButton("Sign In");
		loginButton.setLocation(360,450);
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
		arrayOfProfiles = new Profile[20];
		ActionListener listener = new ClickListener();
		createUser.addActionListener(listener);
		loginButton.addActionListener(listener);
		
		add(panel);
	}
	
	void MainMenu(){
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setLocation(0,0);
		panel2.setSize(700,700);
		JLabel success;

		viewRecord = new JButton("View Record");
		viewRecord.setLocation(175,350);
		viewRecord.setSize(150,30);
		viewSummary = new JButton("View Summary");
		viewSummary.setLocation(350,350);
		viewSummary.setSize(150,30);
		success = new JLabel("Login Successful");
		success.setLocation(300,100);
		success.setSize(150,30);
		ActionListener listener = new ClickListener();
		viewRecord.addActionListener(listener);
		//viewSummary.addActionListener(listener);

		panel2.add(viewRecord);
		panel2.add(viewSummary);
		panel2.add(success);
	}
	
	void ViewRecordOverview(){
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setLocation(0,0);
		panel3.setSize(width,height);
		JButton cancel,create;
		JLabel notice1 ,notice2 , physical, health, cardio, strength, work, slept, pressure, sugar, rate;
		cancel = new JButton("Cancel to Main Menu");
		cancel.setLocation(175,350);
		cancel.setSize(150,30);
		create = new JButton("Edit Daily Record");
		create.setLocation(350,350);
		create.setSize(150,30);
		physical = new JLabel("Physical Activities");
		physical.setLocation(150,50);
		physical.setSize(150,30);
		
		panel3.add(cancel);
		panel3.add(create);
		panel3.add(physical);
	}
	
	public void createNewProfile(String aName, String aPassword){
		Profile anewProfile = new Profile(aName, aPassword);
		int i = 0;
		while(arrayOfProfiles[i] != null && i<arrayOfProfiles.length)
			i++;
		arrayOfProfiles[i] = anewProfile;
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
	
	public class ClickListener implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			String name = userName.getText();
			String enterPassword = password.getText();
			if(source == createUser){
				createNewProfile(name, enterPassword);
				if(verifyLogin(name, enterPassword)){
					MainMenu();
					getContentPane().removeAll();
					getContentPane().add(panel2);
					setTitle("Main Menu");
					validate();
					repaint();
				}
			}
			else if(source == loginButton){
				if(verifyLogin(name, enterPassword)){
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
				setTitle("View Record Overview");
				validate();
				repaint();
			}
			//else if(source == viewSummary){
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
	
}
