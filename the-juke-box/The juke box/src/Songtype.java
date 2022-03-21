public class Songtype extends PlaylistContent{
    String name;
    String songDuration;

    public Songtype(String playlistname, String playlistDuration, String name, String songDuration){
        super(playlistname,playlistDuration);
        this.name=name;
        this.songDuration = songDuration;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getSongDuration(){
        return songDuration;
    }
    public void setSongDuration(String songDuration){
        this.songDuration = songDuration;
    }
    @Override
    public String toString(){
        return super.toString()+" , "+name+" , "+ songDuration;
    }

}
