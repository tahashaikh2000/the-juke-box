import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class SongPlayerMain {
    public static void main (String args[]) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        PlaylistDBoperation pldb = new PlaylistDBoperation();
        SongPlayer sp = new SongPlayer();
        List<PlaylistContent> plv = pldb.showAllContents();
        String fileName=("E:\\ProjectWAVE\\");
        sp.Music(plv,fileName,"wworld");
    }
}
