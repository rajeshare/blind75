package streams;

import java.util.List;
import java.util.Random;

public class Customer {

    String name;
    String id;
    List<Order> order;

    public Customer(String name, String id, List<Order> order) {
        this.name = name;
        this.id = id;
        this.order = order;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public List<Order> getOrder() {
        return order;
    }
}

class Order {
    Integer id;
    Integer price;
    Integer customerId;
    public Order(Integer id, Integer price, Integer customerId) {
        this.id = id;
        this.price = price;
        this.customerId = customerId;
    }
    public Integer getId() {
        return id;
    }
    public Integer getPrice() {
        return price;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    @Override
    public String toString() {
        return customerId + " " + id + " " + price;
    }
}
