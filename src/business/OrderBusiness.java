package business;

import entity.Customer;
import entity.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderBusiness implements IOrderBusiness{
    public static List<Order> listOrder = new ArrayList<>();

    @Override
    public void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);
        System.out.println("Chọn khách hàng theo ID:");
        CustomerBusiness.displayCustomers();
        int customerId = Integer.parseInt(scanner.nextLine());
        Customer customer = CustomerBusiness.getCustomers().stream().filter(c -> c.getId() == customerId).findFirst().orElse(null);
        if (customer != null) {
            order.setCustomer(customer);
            listOrder.add(order);
            System.out.println("Thêm đơn hàng thành công!");
        } else {
            System.out.println("Không tìm thấy khách hàng!");
        }
    }

    @Override
    public void displayOrders() {
        if (listOrder.isEmpty()) {
            System.out.println("Danh sách đơn hàng rỗng");
            return;
        }
        System.out.println("Danh sách đơn hàng:");
        listOrder.forEach(System.out::println);
    }

    @Override
    public void updateOrderStatus(Scanner scanner) {
        System.out.println("Vui lòng nhập ID để cập nhật trạng thái đơn hàng");
        int id = Integer.parseInt(scanner.nextLine());
        listOrder.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        order -> {
                            order.setStatus(true);
                            System.out.println("Cập nhật trạng thái thành công!");
                        },
                        () -> System.out.println("Không tìm thấy đơn hàng")
                );
    }

    @Override
    public List<Order> getOrderOverdue() {
        LocalDate now = LocalDate.now();
        return listOrder.stream().filter(o -> !o.isStatus() && o.getOrderDate().isBefore(now.minusDays(7))).collect(Collectors.toList());
    }

    @Override
    public double getTotalRevenue() {
        return listOrder.stream().filter(Order::isStatus).mapToDouble(Order::getTotalAmount).sum();
    }

    @Override
    public long getOrderDelivied() {
        long delivered = listOrder.stream().filter(Order::isStatus).count();
        return delivered;
    }
}
