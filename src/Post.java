import java.util.ArrayList;

abstract public class Post implements IHasDisplay, IHasAuthor {
    private Author author;  // username of the post's author
    private long timestamp;

    /**
     * Constructor for objects of class Post.
     *
     * @param author    The username of the author of this post.
     */
    public Post(Author author) {
        this.author = author;
        timestamp = System.currentTimeMillis();
    }

    public Author getAuthor() {
        return author;
    }


    @Override
    public String getName() {
        return author.getName();
    }

    @Override
    public void block() {
        author.setCanPublish(false);
    }

    @Override
    public boolean isPublished() {
        return author.canPublish();
    }

    /**
     * Return the time of creation of this post.
     *
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }

    /**
     * Get display with all details of this post.
     */
    public String getDisplay() {
        String display = author.getName();
        display += getContent();
        display += Env.NEWLINE + timeString(timestamp);

        return display;
    }

    abstract protected String getContent();

    /**
     * Create a string describing a time point in the past in terms
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     *
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */

    private String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
