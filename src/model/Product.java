package model;

public class Product {

    private long eanCode;
    private String name;
    private int quantity;

    public Product(long eanCode, String name, int quantity) {
        this.eanCode = eanCode;
        this.name = name;
        this.quantity = quantity;
    }

    public long getEanCode() {
        return eanCode;
    }

    public void setEanCode(long eanCode) {
        this.eanCode = eanCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
