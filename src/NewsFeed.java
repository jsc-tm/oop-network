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
        displays.stream().filter(display -> display.isPublished()).map(display -> display.getDisplay())
                .forEach(s -> System.out.println(s + Env.NEWLINE));
    }
    
    public static void main(String[] args) {
        NewsFeed nf = new NewsFeed();
        Author wim = new Author("wim");
        MessagePost mp = new MessagePost(wim, "knap werk!");
        mp.addComment("toch niet helemaal akkoord...");
        mp.like();
        mp.like();
        nf.addDisplay(mp);
        nf.addDisplay(new Publicity("MARS", "Altijd lekker!"));
        Author betty = new Author("betty");
        nf.addDisplay(new MessagePost(betty, "wanneer komen er video's?"));
        nf.addDisplay(new PhotoPost(betty, "vakantie.jpg", "Op vakantie!"));
        nf.addDisplay(new Publicity("DASH", "Wast witter dan wit!"));
        PhotoPost pp = new PhotoPost(betty, "ardennen.jpg", "een dagje erop uit");

        MessagePost spam = new MessagePost(wim, "bowwowow");
        spam.block();
        wim.setCanPublish(false);

        Author tom = new Author("tom");
        EventPost ep1 = new EventPost(tom, Event.BECOME_FRIEND);
        EventPost ep2 = new EventPost(betty, Event.CHANGE_PROFILEPICTURE);
        nf.addDisplay(ep1);
        nf.addDisplay(ep2);

        nf.show();
    }
}
