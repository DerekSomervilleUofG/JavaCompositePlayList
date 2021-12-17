import java.net.URL;

public class SongGenerator {

    private static SongComponent generate(){
        String path = "src/main/resources/music/";
        SongComponent allMusic = new PlayList("All Music","All Music");
        SongComponent ninetiesDance = new PlayList("Nineties Dance","Dance music from the 90s");
        SongComponent dance = new PlayList("Dance Music","Dance music");
        SongComponent twoThusandDance = new PlayList("2000 Dance","Dance music from the 00s");

        allMusic.add(dance);
        dance.add(ninetiesDance);
        dance.add(twoThusandDance);
        Song stepOn = new Song("Step On", "Happy Mondays", 1990,path + "Happy Mondays - Step On.mp3");
        Song foolsGold = new Song("Fool,s Gold", "Stone Roses", 1989, path + "The Stone Roses - Fool's Gold.mp3");
        ninetiesDance.add(stepOn);
        ninetiesDance.add(foolsGold);
        Song crazy = new Song("Crazy", "Gnarls Barkley", 2006,path + "Gnarls Barkley - Crazy.mp3");
        twoThusandDance.add(crazy);
        Song requiem = new Song("Requiem", "Mozart", 1791, "");
        allMusic.add(requiem);

        return allMusic;
    }
    public static void main(String[] args) {
        SongComponent allMusic = generate();
        Player player = new Player(allMusic);
        player.displaySongInfo();
        player.playSong();

    }

}
