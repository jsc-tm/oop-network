public class EventPost extends Post {
    private Event eventType;

    public EventPost(Author author, Event eventType) {
        super(author);
        this.eventType = eventType;
    }

    @Override
    protected String getContent() {
        return " " + eventType.toString();
    }
}
