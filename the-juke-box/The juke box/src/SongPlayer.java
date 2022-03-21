import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongPlayer {
        List<String> songs;
        int i = 0;
        Scanner sc = new Scanner(System.in);

        public void Music(List<PlaylistContent>plist,String fileName,String playlistName) throws UnsupportedAudioFileException, IOException, LineUnavailableException
        {
            String choice = "";
            try
            {
                songs = new ArrayList<String>();
                for(PlaylistContent p:plist)
                {
                    if(p.getPlaylistName().equalsIgnoreCase(playlistName))
                    {
                        if(p instanceof Songtype)
                        {
                            songs.add(fileName+((Songtype)p).getName()+".wav");
                        }
                        else
                        {
                            songs.add(fileName+((PodcastType)p).getEpisodeName()+".wav");
                        }
                    }
                }
                AudioInputStream stream = AudioSystem.getAudioInputStream(new File(songs.get(i)).getAbsoluteFile());
                Clip c = AudioSystem.getClip();
                c.open(stream);
                while (!choice.equalsIgnoreCase("C"))
                {
                    System.out.println("P - Play, S - Stop, R - Reset, N - Next, PR - Previous, C - Close");
                    System.out.println("Enter your options");
                    choice = sc.next();
                    choice = choice.toUpperCase();
                    switch(choice)
                    {
                        case("P"):
                            c.start();
                            System.out.println("playing");
                            break;
                        case ("S"):
                            c.stop();
                            System.out.println("stopped");
                            break;
                        case ("R"):
                            int t = sc.nextInt();
                            System.out.println("enter the reset seconds");
                            c.setMicrosecondPosition(t);
                            System.out.println("Reset  songlist to period");
                            break;
                        case ("N"):
                            int count = 0;
                            try
                            {
                                if(count<songs.size())
                                {
                                    c.stop();
                                    stream = AudioSystem.getAudioInputStream(new File(songs.get(++i)).getAbsoluteFile());
                                    c = AudioSystem.getClip();
                                    c.open(stream);
                                    c.start();
                                    System.out.println("Next song is playing");
                                }
                            }
                            catch(Exception e)
                            {
                                System.out.println("No more songs in playlist");
                            }
                            break;
                        case ("PR"):
                            int count1 = 0;
                            try
                            {
                                if(count1<songs.size())
                                {
                                    c.stop();
                                    stream = AudioSystem.getAudioInputStream(new File(songs.get(--i)).getAbsoluteFile());
                                    c = AudioSystem.getClip();
                                    c.open(stream);
                                    c.start();
                                    System.out.println("Previous song is playing");
                                }
                            }
                            catch(Exception e)
                            {
                                System.out.println("No more songs in playlist");
                            }
                            break;
                        case("C"):
                            c.close();
                            System.out.println("Application is closed");
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }