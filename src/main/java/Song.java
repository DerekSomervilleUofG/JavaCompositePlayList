import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.io.File;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Song extends SongComponent{
    String songName;
    String bandName;
    int releaseYear;
    String audioFile;

    public Song(String songName, String bandName, String audioFile){
        this.songName = songName;
        this.bandName = bandName;
        this.audioFile = audioFile;
    }

    public String getSongName(){return songName;}
    public String getBandName(){return bandName;}

    private void output(String display){
        System.out.println(display);
    }

    public void displaySongInfo(){
        output(getSongName() + " was recorded by " + getBandName());
    }

    private URL getSongURL() {
        URL audioUrl;
        try {
            audioUrl = new URL(audioFile);
        } catch (Exception ex) {
            audioUrl = null;
            System.out.println("Song failed " + songName + " to create URL for " + audioFile);
        }
        return audioUrl;
    }

    private File getSongFile() {
        File audioLocalFile;
        try {
            audioLocalFile = new File(audioFile);
        } catch (Exception ex) {
            audioLocalFile = null;
            System.out.println("Song failed " + songName + " to create File for " + audioFile);
        }
        return audioLocalFile;
    }

    public void playSong(){
        try {
            if (audioFile != "") {
                File audioAsFile = getSongFile();
                AdvancedPlayer player = new AdvancedPlayer(new FileInputStream(audioAsFile));
                player.play();
            }
        } catch (Exception ex) {
            System.out.println("playSong failed for " + songName + " for url" + audioFile);
            ex.printStackTrace();
        }
    }
}
