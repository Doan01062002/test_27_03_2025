package business;

import entity.Order;

import java.util.List;
import java.util.Scanner;

public interface IOrderBusiness {
    void addOrder(Scanner scanner);
    void displayOrders();
    void updateOrderStatus(Scanner scanner);
    List<Order> getOrderOverdue();
    default double getTotalRevenue() {
        return 0;
    }
    long getOrderDelivied();
}
