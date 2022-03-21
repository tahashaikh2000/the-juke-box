import java.util.List;
import java.util.Scanner;

public class PlaylistMain {
    public static void main(String[] args){
        PlaylistDBoperation pvdb= new PlaylistDBoperation();
        System.out.println("List of playlist..");
        Scanner sc=new Scanner(System.in);
        List<PlaylistContent> p=pvdb.showAllContents();
        pvdb.display(p);

        System.out.println("Enter ur choices");
        System.out.println("1.add a playlist  2.Searching");
        int menu= sc.nextInt();
        switch (menu)
        {
            case  1: {
                System.out.println("Enter a details to add");
                String playlistname = sc.next(); // playlistname :new
                String playduration = sc.next(); // duration
                int trackid = sc.nextInt(); // trackid : existing
                pvdb.addPlayListContent(playlistname, playduration, trackid);
                List<PlaylistContent> p1 = pvdb.showAllContents();
                pvdb.display(p1);
            }break;
            case 2: {
                int ch = sc.nextInt();
                System.out.println("Enter your choices:");
                switch (ch) {
                    case 1: {
                        System.out.println("enter a playlist name&song name to search");
                        String playlistname = sc.next();
                        String songname = sc.next();
                        List<Songtype> order = pvdb.filterbySongname(p, playlistname, songname);
                        for (Songtype song : order) {
                            System.out.println(song);
                        }
                    }
                    break;
                    case 2: {
                        System.out.println("searching by episode name");
                        String playname = sc.next();
                        String episodename = sc.next();
                        List<PodcastType> res = pvdb.filterbyEpisodename(p, playname, episodename);
                        for (PodcastType e : res) {
                            System.out.println(e);
                        }

                    }
                    break;
                    default:
                        System.out.println("NO options");

                }
            }

        }
    }
}
