import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


public class LoginScreen extends JFrame{
	JFrame frame = new JFrame();
	private JPanel panel, panel2;
	private JButton createUser, loginButton;
	private JLabel label;
	private JTextField userName, password;
	private Profile[] arrayOfProfiles;
	//final int FRAME_WIDTH = 500;
	//final int FRAME_HEIGHT = 500;
	
	public static void main(String []args){
		JFrame frame = new LoginScreen();
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);	
	}
	
	public LoginScreen(){
		panel = new JPanel();
		createUser = new JButton("Create New User");
		loginButton = new JButton("Sign In");
		label = new JLabel("Enter Your Login Information");
		userName = new JTextField("UserName");
		password = new JTextField("Password");
		
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
		JButton viewRecord, viewSummary;
		JLabel success;

		viewRecord = new JButton("View Record");
		viewSummary = new JButton("View Record");
		success = new JLabel("Login Successful");

		panel2.add(viewRecord);
		panel2.add(viewSummary);
		panel2.add(success);
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
					validate();
					repaint();
				}
			}
			else if(source == loginButton){
				if(verifyLogin(name, enterPassword)){
					//JFrame frame = new MainMenu();
					/*frame.setTitle("Main Menu");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					frame.setVisible(true);*/
				}
			}
			
		}
	}
	
}
