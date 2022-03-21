public class PlaylistContent {
    String playlistName;
    String playlistDuration;

    public PlaylistContent(String playlistName, String PlaylistDuration){
        this.playlistName=playlistName;
        this.playlistDuration=PlaylistDuration;
    }
    public String getPlaylistName(){
        return playlistName;
    }
    public void setPlaylistName(String PlaylistName){
        this.playlistName=playlistName;
    }
    public String getPlaylistDuration(){
        return playlistDuration;
    }
    public void setPlaylistDuration(String playlistDuration){
        this.playlistDuration=playlistDuration;
    }
    @Override
    public String toString(){
        return playlistName+" , "+playlistDuration;
    }

}
