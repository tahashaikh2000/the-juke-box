import java.util.*;
public class Songmain {
    public static void main(String args[]){
        //Task 1
        Scanner sc = new Scanner(System.in);
        SongDBoperation db = new SongDBoperation();
        Songsort s = new Songsort();
        // display(...) to be defined

        List<Catalogue> songs = db.allSongs();
        s.display(songs);
        System.out.println("Press 1 : for Viewing all the Songs \n Press 2 : for Adding Song  " + "\n Press 3 : sort based on Artist "
                + "\n Press 4 :  sort based upon Album \n press 5 : sort based upon Genre" );


        System.out.println("Enter your Choice: -> ");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                s.display(songs);
//                }
                break;
            case 2:
                System.out.println("-----------Insert the Song-------  ");
                String songname = sc.next();
                String duration = sc.next();
                String artist = sc.next();
                String albumName = sc.next();
                String genre = sc.next();
                db.getSongId(songname);
                //if(db.getSongId(songname)==0) {
                    db.addSong(songname, duration, artist, albumName, genre);
                    System.out.println("Song Inserted Successfully");
                    songs = db.allSongs();
                //}
                /*
                db.getSongId(songname);
                if(db.getSongId(songname)==0) {
                    db.addSong(songname, duration, artist, albumName, genre);
                    System.out.println("Song Inserted Successfully");
                    songs = db.allSongs();
                }*/
                break;
            case 3:
                System.out.println("Order List by Artist");
                String Artist = sc.next();
                List<Catalogue>artist1=s.orderListArtist(songs,Artist);
                s.display(artist1);
//                for(Catalogue c: artist1){
//                    System.out.println(c);
//                }
                break;
            case 4:
                System.out.println("Order list by Album");
                String Album = sc.next();
                List<Catalogue>album=s.orderListAlbum(songs,Album);
                s.display(album);
//                for(Catalogue c: album){
//                    System.out.println(c);
//                }
                break;
            case 5:
                System.out.println("Order list by Genre");
                String Genre = sc.next();
                List<Catalogue> genre1 = s.orderListGenre(songs,Genre);
                s.display(genre1);
//                for(Catalogue c: genre1){
//                    System.out.println(c);
//                }
                break;
            default: System.out.println("Invalid Entry Provided!");
        }
    }
}
