import java.util.ArrayList;
import java.util.Iterator;

public class SongComponentIterator implements Iterator {
    ArrayList<SongComponent> songComponents;
    int position = 0;

    public SongComponentIterator(ArrayList<SongComponent> songComponents){
        this.songComponents = songComponents;
    }

    public SongComponent next(){
        SongComponent songComponent = songComponents.get(position);
        position ++;
        return songComponent;
    }

    public boolean hasNext(){
        boolean result = true;
        if (songComponents.size() <= position || songComponents.get(position) == null){
            result = false;
        }
        return result;
    }
}
