package ibf2024.assessment.paf.batch4.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class OrdersForm {

    private String orderId;
    private Date date;
    private int breweryId;
    private List<Order> orders = new LinkedList<>();

    public OrdersForm() {
    }

    public OrdersForm(String orderId, Date date, int breweryId, List<Order> orders) {
        this.orderId = orderId;
        this.date = date;
        this.breweryId = breweryId;
        this.orders = orders;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrdersForm [orderId=" + orderId + ", date=" + date + ", breweryId=" + breweryId + ", orders=" + orders
                + "]";
    }

}