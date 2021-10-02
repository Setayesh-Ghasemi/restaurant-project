public class Order {

    private Food food;
    private int number;
    private boolean reserved;

    public Order(Food food, int number) {
        this.food = food;
        this.number = number;
        this.reserved = true;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "ID:" + food.getID() +
                "\tName:" + food.getName() +
                "\tNumber:" + number;
    }
}
