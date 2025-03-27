package business;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerBusiness {
    public static List<Customer> listsCustomer = new ArrayList<>();

    public static void addCustomer(Scanner scanner){
        Customer customer = new Customer();
        customer.inputData(scanner);
        listsCustomer.add(customer);
        System.out.println("Thêm khách hàng thành công!");
    }

    public static void displayCustomers(){
        if (listsCustomer.isEmpty()) {
            System.out.println("Danh sách khách hàng rỗng");
            return;
        }
        System.out.println("Danh sách khách hàng:");
        listsCustomer.forEach(System.out::println);
    }

    public static List<Customer> getCustomers() {
        return listsCustomer;
    }
}
