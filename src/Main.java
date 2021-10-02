import java.util.Scanner;
public class Main {
    
    Food foods[];
    Customer customers[];
    Scanner input;
    int lengthCustomer = 0;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        foods = new Food[500];
        customers = new Customer[1000];
        input = new Scanner(System.in);
        mainMenu();
    }

    public void mainMenu() {
        System.out.println("***Welcome to restaurant system***");
        int x = 0;
        do {
            System.out.println("1)Login as manager");
            System.out.println("2)Login as customer");
            System.out.println("3)Exit");
            x = input.nextInt();
        } while (x > 3 || x < 1);
        switch (x) {
            case 1:
                managerMenu();
                break;
            case 2:
                customers[lengthCustomer++] = new Customer(input);
                customerMenu();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    public void managerMenu() {
        System.out.println("***Manager Menu***");
        int x = 0;
        do {
            System.out.println("1)Add to dinner menu");
            System.out.println("2)Add to lunch menu");
            System.out.println("3)Customer info");
            System.out.println("4)Back to main menu");
            x = input.nextInt();
        } while (x > 4 || x < 1);
        switch (x) {
            case 1:
                addDinnerMenu();
                break;
            case 2:
                addLunchMenu();
                break;
            case 3:
                customerInfo();
                break;
            case 4:
                mainMenu();
                break;
        }
    }

    public void customerMenu() {
        System.out.println("***Customer Menu***");
        int x = 0;
        do {
            System.out.println("1)Add new Order");
            System.out.println("2)Show order details");
            System.out.println("3)Cancel an order");
            System.out.println("4)Back to main menu");
            x = input.nextInt();
        } while (x > 4 || x < 1);
        switch (x) {
            case 1:
                getOrder();
                break;
            case 2:
                orderDetails();
                break;
            case 3:
                cancelOrder();
                break;
            case 4:
                mainMenu();
                break;
        }
    }

    public void addDinnerMenu() {
        System.out.println("***Menu add Food Dinner***");
        int x = 0;
        do {
            System.out.println("1)Food");
            System.out.println("2)Drink");
            x = input.nextInt();
        } while (x > 2 || x < 1);
        switch (x) {
            case 1:
                foods[findIndexEmpty()] = new Food(Type.DinnerFood, input);
                break;
            case 2:
                foods[findIndexEmpty()] = new Food(Type.DinnerDrink, input);
        }
        managerMenu();
    }

    public void addLunchMenu() {
        System.out.println("***Menu add Food Lunch***");
        int x = 0;
        do {
            System.out.println("1)Food");
            System.out.println("2)Drink");
            x = input.nextInt();
        } while (x > 2 || x < 1);
        switch (x) {
            case 1:
                foods[findIndexEmpty()] = new Food(Type.LunchFood, input);
                break;
            case 2:
                foods[findIndexEmpty()] = new Food(Type.LunchDrink, input);
        }
        managerMenu();
    }

    public void customerInfo() {
        System.out.println("***Customer Info***");
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null)
                System.out.println(customers[i].toString());

        }
        managerMenu();
    }

    public int findIndexEmpty() {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] == null)
                return i;
        }
        return -1;
    }

    public int existFood(int id) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].getID() == id)
                return i;
        }
        return -1;
    }

    public void getOrder() {
        System.out.println("***Get Order***");
        int x = 0;
        do {
            System.out.println("1)Lunch");
            System.out.println("2)Dinner");
            x = input.nextInt();
        } while (x > 2 || x < 1);
        switch (x) {
            case 1:
                System.out.println("Lunch Menu:");
                System.out.println("Foods:");
                for (int i = 0; i < foods.length; i++) {
                    if (foods[i].getType() == Type.LunchFood)
                        System.out.println(foods[i].toString());
                }
                System.out.println("Drinks:");
                for (int i = 0; i < foods.length; i++) {
                    if (foods[i].getType() == Type.LunchDrink)
                        System.out.println(foods[i].toString());
                }
                break;
            case 2:
                System.out.println("Dinner Menu:");
                System.out.println("Foods:");
                for (int i = 0; i < foods.length; i++) {
                    if (foods[i].getType() == Type.DinnerFood)
                        System.out.println(foods[i].toString());
                }
                System.out.println("Drinks:");
                for (int i = 0; i < foods.length; i++) {
                    if (foods[i].getType() == Type.DinnerDrink)
                        System.out.println(foods[i].toString());
                }
                break;
        }
        String listOrder = input.nextLine();
        String array[] = listOrder.split(" ");
        for (int i = 0; i < array.length; i++) {
            int index = existFood(Integer.parseInt(array[i]));
            if (index != -1 && foods[index].getNumber() > 0) {
                customers[lengthCustomer - 1].addOrder(new Order(foods[index], 1));
                System.out.println("Food " + Integer.parseInt(array[i]) + " Ordered Successfully.");
                foods[index].setNumber(foods[index].getNumber() - 1);
            } else {
                System.out.println("Food " + Integer.parseInt(array[i]) + " not exist");
            }
        }
        customerMenu();
    }

    public void orderDetails() {
        System.out.println("***Get Order***");
        for (int i = 0; i < customers[lengthCustomer - 1].orders.length; i++) {
            if (customers[lengthCustomer - 1].orders[i] != null && customers[lengthCustomer - 1].orders[i].isReserved())
                System.out.println(customers[lengthCustomer - 1].orders[i]);
        }
        customerMenu();
    }

    public void cancelOrder() {
        System.out.println("***Cancel Order***");
        if (customers[lengthCustomer - 1].lengthOrder == 0) {
            System.out.println("Order is Empty.");
            return;
        }
        for (int i = 0; i < customers[lengthCustomer - 1].orders.length; i++) {
            if (customers[lengthCustomer - 1].orders[i] != null && customers[lengthCustomer - 1].orders[i].isReserved())
                System.out.println(customers[lengthCustomer - 1].orders[i]);
        }
        System.out.println("Enter a Id for Reserved Order:");
        int index = input.nextInt();
        customers[lengthCustomer - 1].reservedOrder(index);
        customerMenu();
    }
}

