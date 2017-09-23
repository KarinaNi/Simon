import java.applet.*;
import java.net.*;

public class Audio {
    
    URL audio1URL;
    URL audio2URL;
    URL audio3URL;
    URL audio4URL;
    
    public static void playSound(int soundNumber) {
        try
        {
            myURL = new URL("http://example.com/pages/");
            AudioClip clip = Applet.newAudioClip(audio1URL);
            clip.play();
        } catch (MalformedURLException murle) {
            System.out.println(murle);
        }
    }
}