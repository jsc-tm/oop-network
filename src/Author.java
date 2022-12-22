public class Author {
    private String name;
    private boolean canPublish;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean canPublish() {
        return canPublish;
    }

    public void setCanPublish(boolean canPublish) {
        this.canPublish = canPublish;
    }
}