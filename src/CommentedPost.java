import java.util.ArrayList;

abstract public class CommentedPost extends Post {
    private int likes;
    private ArrayList<String> comments;

    public CommentedPost(Author author) {
        super(author);
        likes = 0;
        comments = new ArrayList<String>();
    }

    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }

    /**
     * Add a comment to this post.
     *
     * @param text  The new comment to add.
     */
    public void addComment(String text)
    {
        comments.add(text);
    }

    public String getDisplay() {
        String display = super.getDisplay();

        if (likes > 0) {
            display += "  -  " + likes + " people like this.";
        }

        display += Env.NEWLINE;
        if(comments.isEmpty()) {
            display += "   No comments.";
        } else {
            display += "   " + comments.size() + " comment(s). Click here to view.";
        }
        return display;
    }
}
