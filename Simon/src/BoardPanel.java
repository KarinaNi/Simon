import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

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

	ArrayList<Integer> playerInput = new ArrayList<Integer>();
	File[] sounds = new File[4];
	
	String[] gratification = {"Nice", "Superb", "Well done", "Fantastic", "Amazing", "Wonderful", "Splendid",
            "Extraordinary", "Scandalous", "Nasty", "Delicious", "Supreme skill", "Sensational",
            "Magnificent"};

	public BoardPanel()
	{		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);//new FlowLayout());

		title = new JLabel("Welcome to Simon!");

		title.setFont(new Font("Comic Sans MS", Font.PLAIN, 32)); //HAHAHA COMIC SANS
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.TOP);
		title.setOpaque(true);
		title.setBackground(Color.black);
		title.setForeground(Color.white);
		title.setBounds(0,0,600,50); 
		
		//CHANGE THESE PATHS TO LOCAL, idk how
		File beep = new File("src/beep.wav");
		File button = new File("src/button.wav");
		File snap = new File("src/snap.wav");
		File switchs = new File("src/switch.wav");
		sounds[0] = beep;
		sounds[1] = button;
		sounds[2] = snap;
		sounds[3] = switchs;
		
		button0 = new JButton();
		button0.setBackground(new Color(150,0,0));
		handleMacColors(button0);
		button0.setBounds(0,50,300,300);
		button0.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				playerInput.add(0);
				Main.PlaySound(beep);
			} 
		} );

		button1 = new JButton();
		button1.setBackground(new Color(150,150,0));
		handleMacColors(button1);
		button1.setBounds(300,50,300,300);
		button1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				playerInput.add(1);
				Main.PlaySound(button);
			} 
		} );

		button2 = new JButton();
		button2.setBackground(new Color(0,0,150));
		handleMacColors(button2);
		button2.setBounds(0,350,300,300);
		button2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				playerInput.add(2);
				Main.PlaySound(snap);

			} 
		} );


		button3 = new JButton();
		button3.setBackground(new Color(0,150,0));
		handleMacColors(button3);
		button3.setBounds(300,350,300,300);
		button3.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				playerInput.add(3);
				Main.PlaySound(switchs);

			} 
		} );

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
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int score = 0;
		title.setText("New game beginning...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SimonLogic game = new SimonLogic();
		ArrayList<Integer> currentList = game.getList();
		title.setText("Begin!");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bigLoop:
			while (true)
			{
				playerInput.clear();
				game.nextTurn();
				loopLight(currentList, score);

				while (playerInput.size()< currentList.size())
				{
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int ii = 0; ii < playerInput.size(); ii++)
				{
					if (playerInput.get(ii) != currentList.get(ii))
					{
						break bigLoop;
					}

				}
				title.setText(gratification[new Random().nextInt(gratification.length)] + "! Next up...");
				score++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				title.setText(">:)");
			}
		title.setText("Game Over!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		title.setText("Your score: " + score);
	}
	
	public void handleMacColors(JButton button) {
		button.setOpaque(true);
		button.setBorderPainted(false);
	}

	public void loopLight(ArrayList<Integer> currentList, int score)
	{
		for (int i = 0; i < currentList.size(); i++)
		{
			Color c = buttons[currentList.get(i)].getBackground();
			Color cc = c.brighter();
			buttons[currentList.get(i)].setBackground(cc.brighter());
			Main.PlaySound(sounds[currentList.get(i)]);
			try {
//				Thread.sleep(1500 - 10*score);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			buttons[currentList.get(i)].setBackground(c);
		}
		playerInput.clear();
		title.setText("Your turn");
	}
}
