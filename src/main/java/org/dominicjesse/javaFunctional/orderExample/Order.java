package org.dominicjesse.javaFunctional.orderExample;

//in Java functional, class is just collecion of data; data is transparent but immutable
public class Order {
    public final OrderStatus orderStatus;
    public final Integer orderRewards;

    public Order(OrderStatus orderStatus, Integer orderRewards) {
        this.orderStatus = orderStatus;
        this.orderRewards = orderRewards;
    }
}
