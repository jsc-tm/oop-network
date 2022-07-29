import java.util.ArrayList;

/**
 * The NewsFeed class stores news posts for the news feed in a
 * social network application (like FaceBook or Google+).
 * 
 * Display of the posts is currently simulated by printing the
 * details to the terminal. (Later, this should display in a browser.)
 * 
 * This version does not save the data to disk, and it does not
 * provide any search or ordering functions.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class NewsFeed
{
    private ArrayList<IHasDisplay> displays;

    /**
     * Construct an empty news feed.
     */
    public NewsFeed()
    {
        displays = new ArrayList<IHasDisplay>();
    }

    /**
     * Add a post to the news feed.
     * 
     * @param display  The display to be added.
     */
    public void addDisplay(IHasDisplay display)
    {
        displays.add(display);
    }

    /**
     * Show the news feed. Currently: print the news feed details
     * to the terminal. (To do: replace this later with display
     * in web browser.)
     */
    public void show()
    {
        // display all posts
        displays.stream().map(display -> display.getDisplay())
                .forEach(s -> System.out.println(s + Env.NEWLINE));
    }
    
    public static void main(String[] args) {
        NewsFeed nf = new NewsFeed();
        MessagePost mp = new MessagePost("wim", "knap werk!");
        mp.addComment("toch niet helemaal akkoord...");
        mp.like();
        mp.like();
        nf.addDisplay(mp);
        nf.addDisplay(new Publicity("MARS", "Altijd lekker!"));
        nf.addDisplay(new MessagePost("betty", "wanneer komen er video's?"));
        nf.addDisplay(new PhotoPost("betty", "vakantie.jpg", "Op vakantie!"));
        nf.addDisplay(new Publicity("DASH", "Wast witter dan wit!"));
        PhotoPost pp = new PhotoPost("betty", "ardennen.jpg", "een dagje erop uit");
        nf.show();

        IHasDisplay ih = new MessagePost("wim", "knap werk!");
        System.out.println(ih);
    }
}
