public class Publicity {
    private String brand;
    private String message;

    public Publicity(String brand, String message) {
        this.brand = brand;
        this.message = message;
    }

    public String getBrand() {
        return brand;
    }

    public void display() {
        System.out.println(brand + " - " + message);
    }
}
