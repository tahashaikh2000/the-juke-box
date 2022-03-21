import java.util.List;
import java.util.Scanner;

public class Podcastmain {
    public static void main(String args[]){
    PodcastDBoperation pdb=new PodcastDBoperation();
    Podcastsort ps=new Podcastsort();
    Scanner scan=new Scanner(System.in);
    System.out.println("List of all episodes");
    List<PodcastCatalogue>list=pdb.showAllEpisodes();
       ps.display(list);
       System.out.println("1.Add a episode     2.Search by Type        3.Search by Narrator      4.Search by Celebrity      5.Search by Pod");
       System.out.println("Select your Option");
    int option=scan.nextInt();
       switch (option)
    {
        case 1:
        {
            System.out.println("Add a episode");
            String epname= scan.next();
            int epno= scan.nextInt();
            String duration= scan.next();
            String type= scan.next();
            String narrator= scan.next();
            String celebrity= scan.next();
            String podcastid= scan.next();
            pdb.addEpisodes(epname,epno,duration,type,narrator,celebrity,podcastid);
            System.out.println("List of all episodes");
            List<PodcastCatalogue>insert=pdb.showAllEpisodes();
            ps.display(insert);
            break;
        }
        case 2:
        {
            System.out.println("Search by Type");
            String typename= scan.next();
            //List<PodcastChannel>orderbyType=ps.searchbyType(list,typename);
            ps.display(list);
        }
        break;
        case 3:
        {
            System.out.println("Search by Narrator");
            String narratorName= scan.next();
            List<PodcastCatalogue>orderbyNarrator=ps.searchbyNarrator(list,narratorName);
            ps.display(orderbyNarrator);
        }
        break;
        case 4:
        {
            System.out.println("Search by Celebrity");
            String celebrityName= scan.nextLine();
            celebrityName= scan.nextLine();

            List<PodcastCatalogue>orderbyCelebrity=ps.searchbyCelebrity(list,celebrityName);
            ps.display(orderbyCelebrity);
        }
        break;
        case 5:
        {
            System.out.println("Search by Pod");
            String podcastName= scan.next();
            List<PodcastCatalogue>orderbyPod=ps.searchbyPod(list,podcastName);
            ps.display(orderbyPod);
        }
        break;
    }
}
}
