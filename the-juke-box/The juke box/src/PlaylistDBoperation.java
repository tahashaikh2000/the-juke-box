import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class PlaylistDBoperation {
    public List<PlaylistContent>showAllContents()
    {
        List<PlaylistContent>plist=new ArrayList<PlaylistContent>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query="select *from viewPlaylist";
            PreparedStatement ps= con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                if(rs.getString(3)!=null)
                {
                    Songtype s=new Songtype(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                    plist.add(s);
                }
                else
                {
                    PodcastType e=new PodcastType(rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(6));
                    plist.add(e);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return  plist;
    }
    private int getPlayListId(String playlistname)
    {
        int playlistid = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query = "select playlistid from playlist where playlistname=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,playlistname);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                playlistid = rs.getInt(1);
            }
            else
            {
                playlistid = addPlayListId(playlistname);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return playlistid;
    }

    private int addPlayListId(String playlistname)
    {
        int playlistid = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query = "insert into playlist (playlistname) values(?)";
            PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,playlistname);
            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next())
                {
                    playlistid = rs.getInt(1);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return playlistid;
    }

    public boolean addPlayListContent(String playlistname,String playduration,int trackid)
    {
        boolean result = false;
        int playlistid=getPlayListId(playlistname);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "Arm@1234");
            String query = "insert into playlistContent (playlistId,playlistDuration,trackId) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,playlistid);
            pst.setString(2,playduration);
            pst.setInt(3,trackid);


            if((pst.executeUpdate())==1)
            {
                result = true;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public List<Songtype>filterbySongname(List<PlaylistContent>plist,String playlistname,String songname)
    {
        List<Songtype>sv=new ArrayList<Songtype>();
        for(PlaylistContent v:plist)
        {
            if(v instanceof Songtype)
            {
                Songtype data=(Songtype) v;
                if(v.getPlaylistName().equalsIgnoreCase(playlistname)&& data.getName().equalsIgnoreCase(songname))
                {
                    sv.add(data);
                }
            }

        }
        return  sv;
    }
    public List<PodcastType>filterbyEpisodename(List<PlaylistContent>plist,String playlistname,String episodename)
    {
        List<PodcastType>ev=new ArrayList<PodcastType>();
        for(PlaylistContent e:plist)
        {
            if(e instanceof PodcastType) {
                PodcastType value = (PodcastType) e;
                if (e.getPlaylistName().equalsIgnoreCase(playlistname)&&value.getEpisodeName().equalsIgnoreCase(episodename)) {
                    ev.add(value);
                }
            }
        }

        return  ev;
    }
    public void display(List<PlaylistContent>pv)
    {
        Consumer<PlaylistContent>pvdisplay=i->System.out.println(i);
        if(pvdisplay instanceof Songtype)
        {
            pv.stream().forEach(pvdisplay);
        }
        else
        {
            pv.stream().forEach(pvdisplay);
        }

        System.out.println("-------...------");
    }

}