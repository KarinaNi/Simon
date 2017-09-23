import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardPanel extends JPanel
{
	JFrame frame;
	JLabel title;
	
	public BoardPanel()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new FlowLayout());
	    
	    title = new JLabel("Welcome to Simon, bitch");
	    title.setFont(new Font("Courier", Font.PLAIN, 32)); 
	    title.setHorizontalAlignment(SwingConstants.CENTER);
	    title.setVerticalAlignment(SwingConstants.TOP);
	    title.setOpaque(true);
	    title.setBackground(Color.black);
	    title.setForeground(Color.white);
	    title.setPreferredSize(new Dimension(600, 400)); 
	    
	    frame.add(title);
		frame.pack();
		frame.setVisible(true);
	}
}
