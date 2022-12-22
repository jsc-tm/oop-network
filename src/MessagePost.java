/**
 * This class stores information about a post in a social network. 
 * The main part of the post consists of a (possibly multi-line)
 * text message. Other data, such as author and time, are also stored.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class MessagePost extends CommentedPost
{
    private String message;   // an arbitrarily long, multi-line message

    /**
     * Constructor for objects of class MessagePost.
     * 
     * @param author    The username of the author of this post.
     * @param text      The text of this post.
     */
    public MessagePost(Author author, String text)
    {
        super(author);
        message = text;
    }

    /**
     * Return the text of this post.
     * 
     * @return The post's text.
     */
    public String getText()
    {
        return message;
    }

    public String getShortDetails() {
        return "Message post from " + getAuthor().getName();
    }

    protected String getContent() {
        return Env.NEWLINE + message;
    }
    @Override
    public String toString() {
        return getShortDetails();
    }
}
