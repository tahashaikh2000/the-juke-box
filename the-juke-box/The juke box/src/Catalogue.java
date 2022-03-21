import java.lang.*;
public class Catalogue {
    private String songName,songsDuration,artistName,albumName,genreName;


    public Catalogue(String songName, String songsDuration, String artistName, String albumName, String genreName)
    {
        this.songName = songName;
        this.songsDuration = songsDuration;
        this.artistName = artistName;
        this.albumName = albumName;
        this.genreName = genreName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongsDuration() {
        return songsDuration;
    }

    public void setSongsDuration(String songsDuration) {
        this.songsDuration = songsDuration;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "CatalogueView{" + "songName='" + songName + '\'' + ", songsDuration='" + songsDuration + '\'' + ", artistName='"
                + artistName + '\'' + ", albumName='" + albumName + '\'' + ", genreName='" + genreName + '\'' + '}';
    }
}
