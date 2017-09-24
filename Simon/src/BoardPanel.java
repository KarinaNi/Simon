import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.ColorModel;
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
	
	JButton[] buttons = new JButton[4];
	
	public BoardPanel()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(null);//new FlowLayout());
	    
	    title = new JLabel("Play Simon");
	    title.setFont(new Font("Courier", Font.PLAIN, 32)); 
	    title.setHorizontalAlignment(SwingConstants.CENTER);
	    title.setVerticalAlignment(SwingConstants.TOP);
	    title.setOpaque(true);
	    title.setBackground(Color.black);
	    title.setForeground(Color.white);
	    title.setBounds(0,0,600,50); 
	    
	    button0 = new JButton();
	    button0.setBackground(new Color(150,0,0));
	    button0.setBounds(0,50,300,300);
	    
	    button1 = new JButton();
	    button1.setBackground(new Color(150,150,0));
	    button1.setBounds(300,50,300,300);
	    
	    button2 = new JButton();
	    button2.setBackground(new Color(0,0,150));
	    button2.setBounds(0,350,300,300);
	    
	    
	    button3 = new JButton();
	    button3.setBackground(new Color(0,150,0));
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
	    
	    buttons[0] = button0;
		buttons[1] = button1;
		buttons[2] = button2;
		buttons[3] = button3;
	}
	
	public void play()
	{
		SimonLogic game = new SimonLogic();
		ArrayList<Integer> currentList = game.getList();
		game.nextTurn();
//		<Integer> currentList = new ArrayList<Integer>();
//		currentList.add(0);
//		currentList.add(1);
//		currentList.add(2);
//		currentList.add(3);
		loopLight(currentList);
	}
	
	public void loopLight(ArrayList<Integer> currentList)
	{
		for (int i = 0; i < currentList.size(); i++)
		{
			Color c = buttons[currentList.get(i)].getBackground();
			Color cc = c.brighter();
			buttons[currentList.get(i)].setBackground(cc.brighter());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buttons[currentList.get(i)].setBackground(c);
		}
	}
}
