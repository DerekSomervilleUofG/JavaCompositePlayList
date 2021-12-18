import java.io.File;
import java.net.URL;

public class SongGenerator {

    private Song getSong(File songFile){
        String[] bandAndSong = songFile.getName().split(" - ");
        return new Song(bandAndSong[1], bandAndSong[0], songFile.getAbsolutePath());
    }

    private SongComponent navigateDirectory(File musicDirectory){
        PlayList playList = new PlayList(musicDirectory.getName());
        File[] musicFiles = musicDirectory.listFiles();
        for (File musicFile : musicFiles){
            if (musicFile.isFile()){
                playList.add(getSong(musicFile));
            } else if (musicFile.isDirectory()){
                SongComponent songComponent = navigateDirectory(musicFile.getAbsoluteFile());
                playList.add(songComponent);
            }
        }
        return playList;
    }

    private SongComponent generate(){
        File musicDirectory = new File("src/main/resources/Music/");
        SongComponent music = navigateDirectory(musicDirectory);

        return music;
    }
    public static void main(String[] args) {
        SongGenerator songGenerator = new SongGenerator();
        SongComponent allMusic = songGenerator.generate();
        Player player = new Player(allMusic);
        player.displaySongInfo();
        player.playSong();

    }

}
