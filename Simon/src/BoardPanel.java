import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardPanel extends JPanel
{
	JFrame frame;
	JLabel title;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	
	{
	JButton[] array = new JButton[4];
	array[0] = button0;
	array[1] = button1;
	array[2] = button2;
	array[3] = button3;
	}
	
	public BoardPanel()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);//new FlowLayout());
	    
	    title = new JLabel("Welcome to Simon, bitch");
	    title.setFont(new Font("Courier", Font.PLAIN, 32)); 
	    title.setHorizontalAlignment(SwingConstants.CENTER);
	    title.setVerticalAlignment(SwingConstants.TOP);
	    title.setOpaque(true);
	    title.setBackground(Color.black);
	    title.setForeground(Color.white);
	    title.setBounds(0,0,600,50); 
	    
	    button0 = new JButton();
	    button0.setBackground(Color.RED);
	    button0.setBounds(0,50,300,300);
	    
	    button1 = new JButton();
	    button1.setBackground(Color.YELLOW);
	    button1.setBounds(300,50,300,300);
	    
	    button2 = new JButton();
	    button2.setBackground(Color.BLUE);
	    button2.setBounds(0,350,300,300);
	    
	    
	    button3 = new JButton();
	    button3.setBackground(Color.GREEN);
	    button3.setBounds(300,350,300,300);
	    
	    frame.add(button0);
	    frame.add(button1);
	    frame.add(button2);
	    frame.add(button3);
	    frame.add(title);
	    frame.setSize(600,690);// TOP BAR is fucking 40 pixels thick, i counted
	    frame.setLocation(900, 250);
	    frame.setResizable(false);

	    frame.setVisible(true);
	}
	
	
}
