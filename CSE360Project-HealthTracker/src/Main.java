
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static void main(String []args){
		JFrame frame = new JFrame();
		
		JButton button = new JButton("Create New User");
		JButton button1 = new JButton("Sign In");
		JLabel label = new JLabel("Enter Your Login Information");
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(button1);
		frame.add(panel);
		
		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 500;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);;
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
}
