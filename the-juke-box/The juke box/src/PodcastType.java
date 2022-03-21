public class PodcastType extends PlaylistContent {
    String episodeName;
    String episodeDuration;


    public PodcastType(String playlistName,String playlistDuration, String episodeName, String episodeDuration){
        super(playlistName,playlistDuration);
        this.episodeName=episodeName;
        this.episodeDuration=episodeDuration;
    }
    public String getEpisodeName(){
        return episodeName;
    }
    public void setEpisodeName(String episodeName){
        this.episodeName=episodeName;
    }
    public String getEpisodeDuration(){
        return episodeDuration;
    }
    public void setEpisodeDuration(String episodeDuration) {
        this.episodeDuration = episodeDuration;
    }
    @Override
    public String toString(){
        return super.toString()+" , "+episodeName+" , "+episodeDuration;
    }

}
