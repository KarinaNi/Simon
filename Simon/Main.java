import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Main {


	public static void main(String[] args)
	{		
		BoardPanel boardpanel = new BoardPanel();
		boardpanel.play();
	}
	static void PlaySound(File Sound)
	{
		try 
		{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
		}
		catch(Exception e)
		{

		}
	}
}
