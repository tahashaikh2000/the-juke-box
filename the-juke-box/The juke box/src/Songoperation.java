
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Songoperation {
    int newArtistId=0;
    int newAlbumId=0;
    int newGenreId=0;
    int songId=0;

     int getArtistId(String name){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query = "select * from artist where artistname=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                newArtistId=rs.getInt(1);
            }
            con.close();
            ps.close();
        }
        catch (Exception IO){
            System.out.println(IO.getMessage());
        }
        return newArtistId;
    }
    public int addArtistId(String name){
        if(newArtistId==0){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox", "root", "Arm@1234");
                String query = "insert into artist (artistname) values (?);";
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,name);
                int result = ps.executeUpdate();
                if(result ==1){
                    ResultSet rs= ps.getGeneratedKeys();
                    if (rs.next())
                    {
                        newArtistId=rs.getInt(1);
                    }
                }
                con.close();
                ps.close();
            }
            catch(Exception E){System.out.println(E.getMessage());}
        }
        return newArtistId;
    }
    int getAlbumId(String albumname){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox", "root", "Arm@1234");
             String query = "select * from where albumname=?;";
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1,albumname);
             ResultSet rs = ps.executeQuery();
             if(rs.next()){
                 newAlbumId=rs.getInt(1);
             }
             con.close();
             ps.close();
         }
         catch (Exception IO){
             System.out.println(IO.getMessage());
         }
         return newAlbumId;
    }
    public int addAlbumId(String albumname){
         if(newAlbumId==0){
             try{
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox", "root", "Arm@1234");
                 String query = "insert into album (albumname,releaseyear) values(?,?)";
                 PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                 ps.setString(1,albumname);
                 ps.setString(2,"2020");
                 int result = ps.executeUpdate();
                 if(result==1){
                     ResultSet rs = ps.getGeneratedKeys();
                     if(rs.next()){
                         newAlbumId=rs.getInt(1);
                     }
                 }
                 con.close();
                 ps.close();
             }
             catch (Exception IO){
                 System.out.println(IO.getMessage());
             }
         }
         return newAlbumId;
    }

    int getGenreId(String genrename){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox", "root", "Arm@1234");
             String query = "select * from genre where genrename=?";
             PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1,genrename);
             ResultSet rs = ps.executeQuery();
             if(rs.next()){
                 newGenreId=rs.getInt(1);
             }
             con.close();
             ps.close();
         }
         catch (Exception IO){
             System.out.println(IO.getMessage());
         }
         return newGenreId;
    }
    public int addGenreId(String genrename){
         if(newGenreId==0){
             try{
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox", "root", "Arm@1234");
                 String query = "insert into genre(genrename) values(?)";
                 PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                 ps.setString(1,genrename);
                 int result = ps.executeUpdate();
                 if(result==1){
                     ResultSet rs = ps.getGeneratedKeys();
                     if(rs.next()){
                         newGenreId=rs.getInt(1);
                     }
                 }
                 con.close();
                 ps.close();
             }
             catch (Exception IO){
                 System.out.println(IO.getMessage());
             }
         }
         return newGenreId;
    }
    // ADD SONG TO DATABASE
    public int getSongId(String songname){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox", "root", "Arm@1234");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("Select * from song where songname = '"+songname+"'");
             if(rs.next()){
                 songId = rs.getInt(1);
             }
             con.close();
         }
         catch (Exception IO){
             System.out.println(IO.getMessage());
         }
         return songId;
    }

    public boolean addSong(String songname, String songsduration, String artist, String albumName, String genreid){
         boolean result = false;

         int artistId=0;
        int albumId = 0;
        int genreId = 0;

        if (getArtistId(artist)!=0){
            artistId = getArtistId(artist);
        }else{
            artistId = addArtistId(artist);
        }

        //check if album found or not
        if (getAlbumId(albumName)!= 0) {
            albumId = getAlbumId(albumName);
        } else {
            albumId = addAlbumId(albumName);
        }

        //check if the genre exists
        if (getGenreId(genreid)!= 0) {
            genreId = getGenreId(genreid);
        }
        else {
            genreId = addGenreId(genreid);
        }
        if(songId==0){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox", "root", "Arm@1234");
                String query1 = "insert into song (songname,duration,artistid,albumid,genreid) values(?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1,songname);
                pst.setString(2,songsduration);
                pst.setString(3,artist);
                pst.setString(4,albumName);
                pst.setString(5,genreid);
                int result1 = pst.executeUpdate();
                if(result1==1){
                    ResultSet rs1 = pst.getGeneratedKeys();
                    if(rs1.next()){
                        result=true;
                        System.out.println("Song added");
                    }
                }
            }
            catch(Exception IO){
                System.out.println(IO.getMessage());
            }
        }
        return result;
    }

    public List<Catalogue> allSongs() {
        List<Catalogue> SongsView = new ArrayList<Catalogue>();// for view
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox", "root", "Arm@1234");
            String query = "select * from Catalogue;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Catalogue c = new Catalogue(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                SongsView.add(c);
            }
        } catch (Exception E) {
            System.out.println(E.getMessage());
        }
        return SongsView;
    }
}