public class Publicity implements IHasDisplay {
    private String brand;
    private String message;

    public Publicity(String brand, String message) {
        this.brand = brand;
        this.message = message;
    }


    @Override
    public boolean isPublished() {
        return true;
    }


    public String getBrand() {
        return brand;
    }

    /**
     * Get display with all details of this publicity.
     */
    public String getDisplay() {
        return brand + " - " + message;
    }
}
