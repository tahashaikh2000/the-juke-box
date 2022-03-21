public class PodcastCatalogue {
    private String podcastname;
    private int episodeno;
    private String duration;
    private  String typename;
    private  String narratorname;
    private  String celebrityname;
    private String podname;

    public PodcastCatalogue(String podcastname, int episodeno, String duration, String typename, String narratorname, String celebrityname,String podname){
        this.podcastname=podcastname;
        this.episodeno=episodeno;
        this.duration=duration;
        this.typename=typename;
        this.narratorname=narratorname;
        this.celebrityname=celebrityname;
        this.podname=podname;
    }
    public String getEpisodename() {
        return podcastname;
    }

    public void setEpisodename(String episodename) {
        this.podcastname = episodename;
    }

    public int getEpisodeno() {
        return episodeno;
    }

    public void setEpisodeno(int episodeno) {
        this.episodeno = episodeno;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getNarratorname() {
        return narratorname;
    }

    public void setNarratorname(String narratorname) {
        this.narratorname = narratorname;
    }

    public String getCelebrityname() {
        return celebrityname;
    }

    public void setCelebrityname(String celebrityname) {
        this.celebrityname = celebrityname;
    }

    public String getPodname() {
        return podname;
    }

    public void setPodname(String podname) {
        this.podname = podname;
    }

    @Override
    public String toString() {
        return podcastname+","+episodeno+","+duration+","+typename+","+narratorname+","+celebrityname+","+podname;

    }
}
