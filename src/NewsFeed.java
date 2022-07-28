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
    private ArrayList<MessagePost> messages;
    private ArrayList<PhotoPost> photos;
    private ArrayList<Publicity> publicityMessages;

    /**
     * Construct an empty news feed.
     */
    public NewsFeed()
    {
        messages = new ArrayList<MessagePost>();
        photos = new ArrayList<PhotoPost>();
        publicityMessages = new ArrayList<Publicity>();
    }

    /**
     * Add a text post to the news feed.
     * 
     * @param message  The message post to be added.
     */
    public void addMessagePost(MessagePost message)
    {
        messages.add(message);
    }

    /**
     * Add a photo post to the news feed.
     * 
     * @param photo  The photo post to be added.
     */
    public void addPhotoPost(PhotoPost photo)
    {
        photos.add(photo);
    }

    /**
     * Add publicity to the feed
     *
     * @param publicity The publicity to be added
     */
    public void addPublicity(Publicity publicity) { publicityMessages.add(publicity); }

    /**
     * Show the news feed. Currently: print the news feed details
     * to the terminal. (To do: replace this later with display
     * in web browser.)
     */
    public void show()
    {
        // display all messages
        messages.stream().map(message -> message.getDisplay())
                .forEach(s -> System.out.println(s + Env.NEWLINE));

        // display all photos
        photos.stream().map(photo -> photo.getDisplay())
                .forEach(s -> System.out.println(s + Env.NEWLINE));

        // display all publicity
        publicityMessages.stream().map(publicity -> publicity.getDisplay())
                .forEach(s -> System.out.println(s + Env.NEWLINE));
    }
    
    public static void main(String[] args) {
        NewsFeed nf = new NewsFeed();
        MessagePost mp = new MessagePost("wim", "knap werk!");
        mp.addComment("toch niet helemaal akkoord...");
        mp.like();
        mp.like();
        nf.addMessagePost(mp);
        nf.addPublicity(new Publicity("MARS", "Altijd lekker!"));
        nf.addMessagePost(new MessagePost("betty", "wanneer komen er video's?"));
        nf.addPhotoPost(new PhotoPost("betty", "vakantie.jpg", "Op vakantie!"));
        nf.addPublicity(new Publicity("DASH", "Wast witter dan wit!"));
        PhotoPost pp = new PhotoPost("betty", "ardennen.jpg", "een dagje erop uit");
        nf.show();
    }
}
