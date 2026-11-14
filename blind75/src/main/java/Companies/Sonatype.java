package Companies;



import java.util.*;
        import java.util.stream.*;

public class Sonatype {
        public static void main(String[] args) {

            List<Order> orders = Arrays.asList(
                    new Order(1, 101, 500),
                    new Order(2, 101, 900),
                    new Order(3, 101, 200),
                    new Order(4, 101, 1200),
                    new Order(5, 101, 700),
                    new Order(6, 101, 1500),
                    new Order(7, 102, 300),
                    new Order(8, 102, 1000),
                    new Order(9, 102, 800),
                    new Order(10, 102, 2000)
            );

            Map<Integer, List<Order>> result =
                    orders.stream()
                            .collect(Collectors.groupingBy(
                                    Order::getCustomerId,
                                    Collectors.collectingAndThen(
                                            Collectors.toList(),
                                            list -> list.stream()
                                                    .sorted(Comparator.comparingDouble(
                                                            Order::getAmount).reversed())
                                                    .limit(5)
                                                    .collect(Collectors.toList())
                                    )
                            ));



            orders.stream()
                    .collect(Collectors.groupingBy(
                            Order::getCustomerId,
                                    Collectors.collectingAndThen(
                                            Collectors.toList(),list->list.stream().sorted(Comparator.comparingDouble(Order::getAmount).reversed()).limit(5).collect(Collectors.toList()))));

       /*     Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> list.stream()
                            .sorted(Comparator.comparingDouble(
                                    Order::getAmount).reversed())
                            .limit(5)
                            .collect(Collectors.toList())
            )*/

//            Map<Integer, List<Order>> result =
//                    orders.stream()
//                            .collect(Collectors.groupingBy(
//                                    Order::getCustomerId));

            Map<Integer, List<Order>> topOrders=new HashMap<>();
            for(Map.Entry<Integer, List<Order>> entry : result.entrySet()) {
                topOrders.put(entry.getKey(),entry.getValue().stream().sorted(Comparator.comparingDouble(Order::getAmount).reversed()).limit(5).collect(Collectors.toUnmodifiableList()));
            }


//            result.forEach((customerId, topOrders) -> {
//                System.out.println("Customer: " + customerId);
//                topOrders.forEach(System.out::println);
//            });
        }
}


class Order {
    int orderId;
    int customerId;
    double amount;

    Order(int orderId, int customerId, double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId +
                ", amount=" + amount + "}";
    }
}
