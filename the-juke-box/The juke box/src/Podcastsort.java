import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Podcastsort {
    Consumer<PodcastCatalogue> display= i->System.out.println(i);
    public List<PodcastCatalogue> searchbyType(List<PodcastCatalogue>episodes, String typename)
    {
        List<PodcastCatalogue>listbyType=new ArrayList<PodcastCatalogue>();
        Optional<PodcastCatalogue> byType=episodes.stream().filter(p->(p.getTypename().equalsIgnoreCase(typename))).findAny();
        if(byType.isPresent())
        {
            listbyType=episodes.stream().filter(p->(p.getTypename().equalsIgnoreCase(typename))).sorted(Comparator.comparing(PodcastCatalogue::getEpisodename)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("No matches found of this particular type");
        }
        return listbyType;
    }
    public List<PodcastCatalogue>searchbyNarrator(List<PodcastCatalogue>episodes,String narratorname)
    {
        List<PodcastCatalogue>listbyNarrator=new ArrayList<PodcastCatalogue>();
        Optional<PodcastCatalogue>byTypeofNar=episodes.stream().filter(p->(p.getNarratorname().equalsIgnoreCase(narratorname))).findAny();
        if(byTypeofNar.isPresent())
        {
            listbyNarrator=episodes.stream().filter(p->(p.getNarratorname().equalsIgnoreCase(narratorname))).sorted(Comparator.comparing(PodcastCatalogue::getEpisodename)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("No matches found of this particular type");
        }
        return listbyNarrator;
    }
    public List<PodcastCatalogue>searchbyCelebrity(List<PodcastCatalogue>episodes,String celebrityname) {
        List<PodcastCatalogue> listbyCelebrity = new ArrayList<PodcastCatalogue>();
        Optional<PodcastCatalogue> byTypeofClb = episodes.stream().filter(p -> (p.getCelebrityname().equalsIgnoreCase(celebrityname))).findAny();
        if (byTypeofClb.isPresent()) {
            listbyCelebrity = episodes.stream().filter(p -> (p.getCelebrityname().equalsIgnoreCase(celebrityname))).sorted(Comparator.comparing(PodcastCatalogue::getEpisodename)).collect(Collectors.toList());
        } else {
            System.out.println("No matches found of this particular type");
        }
        return listbyCelebrity;
    }
    public List<PodcastCatalogue>searchbyPod(List<PodcastCatalogue>episodes,String podname) {
        List<PodcastCatalogue> listbyPod = new ArrayList<PodcastCatalogue>();
        Optional<PodcastCatalogue> byTypeofPod = episodes.stream().filter(p -> (p.getPodname().equalsIgnoreCase(podname))).findAny();
        if (byTypeofPod.isPresent()) {
            listbyPod = episodes.stream().filter(p -> (p.getPodname().equalsIgnoreCase(podname))).sorted(Comparator.comparing(PodcastCatalogue::getEpisodename)).collect(Collectors.toList());
        } else {
            System.out.println("No matches found of this particular type");
        }
        return listbyPod;
    }
    public void display(List<PodcastCatalogue> episodes)
    {
        episodes.stream().forEach(display);
    }
}
