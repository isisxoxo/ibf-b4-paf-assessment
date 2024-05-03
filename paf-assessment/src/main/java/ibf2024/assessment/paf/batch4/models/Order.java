package ibf2024.assessment.paf.batch4.models;

public class Order {
    private int beerId;
    private int quantity;

    public Order() {
    }

    public Order(int beerId, int quantity) {
        this.beerId = beerId;
        this.quantity = quantity;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order [beerId=" + beerId + ", quantity=" + quantity + "]";
    }

}
