package entity;

import business.CustomerBusiness;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp {
    private int autoIncreaId = 0;
    private int id;
    private String name;
    private Optional<String> email;

    public Customer() {
        this.id = ++autoIncreaId;
        this.email = Optional.empty();
    }

    public int getAutoIncreaId() {
        return autoIncreaId;
    }

    public void setAutoIncreaId(int autoIncreaId) {
        this.autoIncreaId = autoIncreaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{ id=" + id + ", name='" + name + '\'' + ", email=" + email.orElse("Không có") + '}';
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên khách hàng: ");
        this.name = scanner.nextLine();
        System.out.println("Nhập email khách hàng: ");
        String emailInput = scanner.nextLine();
        this.email = emailInput.isEmpty() ? Optional.empty() : Optional.of(emailInput);
    }
}
