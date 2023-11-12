package christmas.domain;

public class Order {
    private int totalPrice = 0;
    private int totalOrderCount = 0;
    private int dessertOrderCount = 0;
    private int mainMenuOrderCount = 0;
    private int beverageOrderCount = 0;

    public void addTotalPrice(int price) {
        totalPrice += price;
    }

    public void addTotalOrderCount(int orderCount) {
        totalOrderCount += orderCount;
    }

    public void addDessertOrderCount(int dessertOrderCount) {
        this.dessertOrderCount += dessertOrderCount;
    }

    public void addMainMenuOrderCount(int mainMenuOrderCount) {
        this.mainMenuOrderCount += mainMenuOrderCount;
    }

    public void addBeverageOrderCount(int beverageOrderCount) {
        this.beverageOrderCount += beverageOrderCount;
    }

    public int getTotalOrderCount() {
        return totalOrderCount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}
