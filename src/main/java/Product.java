public class Product {
    private String name;
    private String extension;
    private Double price;
    private Integer sellNumber;

    public Product(String name, String extension, Double price, Integer sellNumber) {
        this.name = name;
        this.extension = extension;
        this.price = price;
        this.sellNumber = sellNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(Integer sellNumber) {
        this.sellNumber = sellNumber;
    }
}
