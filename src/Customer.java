import java.util.Scanner;
public class Customer {

    private String first_name;
    private String last_name;
    private long numberPhone;
    private String gender;
    Order orders[];
    int lengthOrder = 0;

    public Customer(String first_name, String last_name, long numberPhone, String gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.numberPhone = numberPhone;
        this.gender = gender;
        orders = new Order[20];
    }

    public Customer(Scanner input) {
        enter(input);
        orders = new Order[20];
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(long numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "firstName:" + first_name + "\tlastName:" + last_name + "\tGender:" + gender + "\tNumberPhone:" + numberPhone;
    }

    public void enter(Scanner input) {
        input.nextLine();
        System.out.println("Enter first_name:");
        this.first_name = input.nextLine();
        System.out.println("Enter lastName:");
        this.last_name = input.nextLine();
        System.out.println("Enter Gender:");
        this.gender = input.nextLine();
        System.out.println("Enter NumberPhone:");
        this.numberPhone = input.nextLong();
        System.out.println("Customer added successfully.");
    }

    public void addOrder(Order o) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                orders[i] = o;
                lengthOrder++;
                return;
            }
        }
    }

    public void reservedOrder(int id) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null && orders[i].getFood().getID() == id) {
                orders[i].setReserved(false);
                ;
                return;
            }
        }
        System.out.println("Food not exist.");
    }

}
