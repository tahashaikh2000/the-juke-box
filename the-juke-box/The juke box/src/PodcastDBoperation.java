import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodcastDBoperation {
    //Add episode on the basis of desired input in the
    public boolean addEpisodes(String epsiodename, int episodeno, String duration, String typename, String narratorname, String celebrityname, String podcastname) {
        int typeid=getTypeid(typename);
        int narratorid=getNarratorid(narratorname);
        int celebrityid=getCelebrityid(celebrityname);
        int podid=getPodid(podcastname,typeid,narratorid,celebrityid);
        int episodeid=getEpisodeid(epsiodename,episodeno,duration,podid);
        boolean result=false;

        return result;
    }
        public int getTypeid(String typename){
            int result = 0;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
                String query = "select genreId from PodcastGenre where genreName=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,typename);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    result=rs.getInt(1);
                }else{
                    result=addTypeid(typename);
                }
                rs.close();
                con.close();
                ps.close();
            }
            catch (Exception IO){
                System.out.println(IO.getMessage());
            }
            return result;
        }
    private int addTypeid(String typename) {
        int addType = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query = "insert into PodcastGenre(genreName) values (?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, typename);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    addType = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return addType;
    }
    public int getNarratorid(String narratorname){
            int result = 0;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
                String query = "select narratorId from narrator where narratorName=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,narratorname);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    result=rs.getInt(1);
                }else {
                    result=addNarratorid(narratorname);
                }
                rs.close();
                ps.close();
                con.close();

            }
            catch(Exception IO){
                System.out.println(IO.getMessage());
            }
            return result;
    }
    public int addNarratorid(String narratorname){
            int addNarratorid = 0;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
                String query = "insert into narrator(narratorName)values(?)";
                PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,narratorname);
                if(ps.executeUpdate()==1){
                    ResultSet rs = ps.getGeneratedKeys();
                    if(rs.next()){
                        addNarratorid=rs.getInt(1);
                    }
                }
                ps.close();
                con.close();
            }catch(Exception IO){
                System.out.println(IO.getMessage());
        }
            return addNarratorid;
    }
    public int getCelebrityid(String celebrityname) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query = "select celebrityId from celebrity where celebrityName=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, celebrityname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            } else {
                result = addCelebrityid(celebrityname);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    public int addCelebrityid(String celebrityname) {
        int addcelebrity = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query = "insert into celebrity(celebrityName) values (?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, celebrityname);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    addcelebrity = rs.getInt(1);
                }
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return addcelebrity;
    }
    public int getPodid(String podname, int typeid, int narid, int celid)
    {int result=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query="select podcastId from podcast where podcastName=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, podname);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                result= rs.getInt(1);
            }
            else {
                result=addPodid(podname,typeid, narid, celid);
            }
            rs.close();
            ps.close();
            con.close();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    public int addPodid(String podname, int typeid, int narid, int celid)
    {int resultPodcast=0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query="insert into podcast(podcastName,genreId,narratorId,celebrityId)values(?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,podname);
            ps.setInt(2,typeid);
            ps.setInt(3,narid);
            ps.setInt(4,celid);
            if(ps.executeUpdate()==1) {
                ResultSet rs= ps.getGeneratedKeys();
                if(rs.next()) {
                    resultPodcast= rs.getInt(1);
                }
            }
            ps.close();
            con.close();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultPodcast;
    }
    public int getEpisodeid(String epdname,int epdno,String duration, int podid)
    {
        int result=0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query="select episodeId from podcastEpisode where episodeName=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, epdname);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                result= rs.getInt(1);
            }
            else {
                result=addEpisodeid(epdname,epdno, duration,podid);
            }
            rs.close();
            ps.close();
            con.close();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int addEpisodeid(String episodename,int episodeno,String duration, int podid)
    {
        int addEpisode=0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query="insert into podcastEpisode (episodeName,episodeNumber,episodeDuration,podcastId) values (?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,episodename);
            ps.setInt(2,episodeno);
            ps.setString(3,duration);
            ps.setInt(4,podid);
            if(ps.executeUpdate()==1)
            {
                ResultSet rs= ps.getGeneratedKeys();
                if(rs.next())
                {
                    addEpisode= rs.getInt(1);
                }
            }
            ps.close();
            con.close();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return addEpisode;
    }

    //list returned for showing of all the episodes
    public List<PodcastCatalogue> showAllEpisodes() {
        List<PodcastCatalogue> episodes = new ArrayList<PodcastCatalogue>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query = "select * from podcastpv";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PodcastCatalogue pc = new PodcastCatalogue(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                episodes.add(pc);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return episodes;
    }

}

