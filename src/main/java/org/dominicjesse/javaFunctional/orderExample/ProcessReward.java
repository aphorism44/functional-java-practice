package org.dominicjesse.javaFunctional.orderExample;


public class ProcessReward {

    //in functional Java, functions should be static
    public static Order issueRewards(Order order) {
        return new Order(OrderStatus.REWARDS_ISSUED, order.orderRewards);
    }

    //avoid void - always pass back same object
    public static Customer updateRewardBalance(Order order, Customer customer) {
        if (order.orderRewards != null) {
            Customer newCustomer = new Customer(customer.rewardBalance + order.orderRewards);
            return newCustomer;
        }
        return customer;
    }


}
