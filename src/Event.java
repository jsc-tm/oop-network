public enum Event {
    BECOME_MEMBER("is lid geworden van"),
    BECOME_FRIEND("is nu bevriend met"),
    CHANGE_PROFILEPICTURE("heeft profielfoto gewijzigd");
    private String description;

    Event(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}