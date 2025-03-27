package presentation;

import business.CustomerBusiness;
import business.OrderBusiness;

import java.util.Scanner;

public class ShopManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerBusiness customer = new CustomerBusiness();
    private static OrderBusiness order = new OrderBusiness();

    public static void main(String[] args) {
        while (true) {
            menuShop();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: menuCustomer();
                    break;
                case 2: menuOrder();
                    break;
                case 3:
                        System.out.println("Bạn đã thoát chương trình");
                        return;
                default:
                    System.out.println("Vui lòng nhập lại sự lựa chọn của bạn");
            }
        }
    }

    private static void menuShop(){
            System.out.println("**********************SHOP MENU*******************");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            System.out.println("Vui lòng nhập sự lựa chọn của bạn");
    }

    private static void menuCustomer(){
        System.out.println("***********************CUSTOMER MENU******************\n");
        System.out.println("1. Danh sách khách hàng");
        System.out.println("2. Thêm mới khách hàng");
        System.out.println("3. Thoát ");
        System.out.println("Vui lòng nhập sự lựa chọn của bạn");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                customer.displayCustomers();
                break;
            case 2:
                customer.addCustomer(scanner);
                break;
            case 3:
                return;
            default:
                System.out.println("Vui lòng nhập lại sự lựa chọn của bạn");
        }
    }

    private static void menuOrder(){
        System.out.println("***********************ORDER MENU**********************");
        System.out.println("1. Danh sách đơn hàng");
        System.out.println("2. Thêm mới đơn hàng");
        System.out.println("3. Cập nhật trạng thái đơn hàng");
        System.out.println("4. Danh sách đơn hàng quá hạn");
        System.out.println("5. Thống kê số lượng đơn hàng đã giao (Trạng thái true)");
        System.out.println("6. Tính tổng doanh thu các đơn hàng đã giao");
        System.out.println("7. Thoát");
        System.out.println("Vui lòng nhập sự lựa chọn của bạn");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                order.displayOrders();
                break;
            case 2:
                order.addOrder(scanner);
                break;
            case 3:
                order.updateOrderStatus(scanner);
                break;
            case 4:
                order.getOrderOverdue().forEach(System.out::println);
                break;
            case 5:
                System.out.println("Số đơn hàng đã giao: " + order.getOrderDelivied());
                break;
            case 6:
                System.out.println("Tổng doanh thu: " + order.getTotalRevenue());
                break;
            case 7:
                return;
            default:
                System.out.println("Vui lòng nhập lại sự lựa chọn của bạn");
        }
    }
}
