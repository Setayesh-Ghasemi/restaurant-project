import java.util.Scanner;
public class Food {

    private int ID;
    private String name;
    private double price;
    private int number;
    private Type type;
    static int idBase = 1;

    public Food(String name, double price, int number, Type type) {
        ID = idBase++;
        this.name = name;
        this.price = price;
        this.number = number;
        this.type = type;
    }

    public Food(Type type, Scanner input) {
        this.type = type;
        enter(input);

    }

    public Type getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ID:" + ID + "\tName:" + name + "\tPrice:" + price + "\tNumber:" + number;
    }

    public void enter(Scanner input) {
        input.nextLine();
        System.out.println("Enter Name:");
        this.name = input.nextLine();
        System.out.println("Enter Price:");
        this.price = input.nextDouble();
        System.out.println("Enter Number:");
        this.number = input.nextInt();
        System.out.println("Food added successfully.");
    }

}
