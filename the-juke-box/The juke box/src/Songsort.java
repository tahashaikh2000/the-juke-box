import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Songsort {
    Consumer<Catalogue> disp=(d)->System.out.println(d);
    public void display(List<Catalogue> songsCatalog)
    {
        songsCatalog.stream().forEach(disp);
    }
    public List<Catalogue> orderListArtist(List<Catalogue>SongsView, String artistName){
        List<Catalogue>orderArtist = SongsView.stream().filter(p->(p.getArtistName().equalsIgnoreCase(artistName))).sorted(Comparator.comparing(Catalogue::getSongName)).collect(Collectors.toList());
        Optional<Catalogue> an = SongsView.stream().filter(p->p.getArtistName().equalsIgnoreCase(artistName)).findAny();
        if(an.isPresent()){
            orderArtist = SongsView.stream().filter(p->(p.getArtistName().equalsIgnoreCase(artistName))).sorted(Comparator.comparing(Catalogue::getSongName)).collect(Collectors.toList());
        }
        else{
            System.out.println("No matches found for this artist");
        }
        return  orderArtist;
    }
    public List<Catalogue> orderListAlbum(List<Catalogue>SongsView,String albumName){
        List<Catalogue>orderAlbum = SongsView.stream().filter(p->(p.getAlbumName().equalsIgnoreCase(albumName))).sorted(Comparator.comparing(Catalogue::getAlbumName)).collect(Collectors.toList());
        Optional<Catalogue> oab = SongsView.stream().filter(p->p.getAlbumName().equalsIgnoreCase(albumName)).findAny();
        if(oab.isPresent()){
            orderAlbum = SongsView.stream().filter(p->(p.getAlbumName().equalsIgnoreCase(albumName))).sorted(Comparator.comparing(Catalogue::getAlbumName)).collect(Collectors.toList());
        }
        else{
            System.out.println("No matches found for this album");
        }
        return orderAlbum;
    }
    public List<Catalogue> orderListGenre(List<Catalogue>SongsView,String genre){
        List<Catalogue>orderGenre = SongsView.stream().filter(p->(p.getGenreName().equalsIgnoreCase(genre))).sorted(Comparator.comparing(Catalogue::getGenreName)).collect(Collectors.toList());
        Optional<Catalogue> og = SongsView.stream().filter(p->p.getGenreName().equalsIgnoreCase(genre)).findAny();
        if(og.isPresent()){
            orderGenre = SongsView.stream().filter(p->(p.getGenreName().equalsIgnoreCase(genre))).sorted(Comparator.comparing(Catalogue::getGenreName)).collect(Collectors.toList());
        }
        else{
            System.out.println("No matches found for this genre");
        }
        return orderGenre;
    }
}
