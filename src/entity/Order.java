package entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Order implements IApp{
    private int autoIncreaId = 0;
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status;

    public Order() {
        this.id = ++autoIncreaId;
        this.status = false;
    }

    public int getAutoIncreaId() {
        return autoIncreaId;
    }

    public void setAutoIncreaId(int autoIncreaId) {
        this.autoIncreaId = autoIncreaId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập ngày đặt hàng (YYYY-MM-DD): ");
        this.orderDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Nhập tổng tiền: ");
        this.totalAmount = Double.parseDouble(scanner.nextLine());
        this.status = false;
    }

    @Override
    public String toString() {
        return "Đơn hàng{id=" + id + ", khách hàng=" + customer.getName() + ", ngày đặt=" + orderDate + ", tổng tiền=" + totalAmount + ", trạng thái=" + (status ? "Đã giao" : "Chưa giao") + "}";
    }
}
