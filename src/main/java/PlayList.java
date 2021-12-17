import java.util.ArrayList;
import java.util.Iterator;

public class PlayList extends SongComponent{

    ArrayList<SongComponent> songComponents = new ArrayList<SongComponent>();

    String playListName;
    String playListDescription;

    public PlayList(String playListName, String playListDescription){
        this.playListName = playListName;
        this.playListDescription = playListDescription;
    }

    public String getPlayListName(){
        return playListName;
    }
    public String getPlayListDescription(){
        return playListDescription;
    }

    public void add(SongComponent songComponent){
        songComponents.add(songComponent);
    }
    public void remove(SongComponent songComponent){
        songComponents.remove(songComponent);
    }

    public SongComponent getComponent(int componentIndex){
        return songComponents.get(componentIndex);
    }

    public void displaySongInfo(){
        System.out.println(getPlayListName() + " " + getPlayListDescription() + "\n");

        SongComponentIterator songIterator = new SongComponentIterator(songComponents);

        while(songIterator.hasNext()){
            SongComponent songInfo = songIterator.next();
            songInfo.displaySongInfo();
        }
    }

    public void playSong() {
        SongComponentIterator songIterator = new SongComponentIterator(songComponents);
        while(songIterator.hasNext()) {
            SongComponent songInfo = songIterator.next();
            songInfo.playSong();
        }
    }
}
