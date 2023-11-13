package christmas.domain;

public class Order {
    private int totalPrice;
    private int totalOrderCount;
    private int totalDisCountPrice;
    private int dessertOrderCount;
    private int mainMenuOrderCount;
    private int beverageOrderCount;

    public Order() {
        this.totalPrice = 0;
        this.totalOrderCount = 0;
        this.dessertOrderCount = 0;
        this.mainMenuOrderCount = 0;
        this.beverageOrderCount = 0;
        this.totalDisCountPrice = 0;
    }

    public void addTotalPrice(int price) {
        totalPrice += price;
    }

    public void addTotalOrderCount(int orderCount) {
        totalOrderCount += orderCount;
    }

    public void addTotalDiscountPrice(int discountPrice){
        totalDisCountPrice += discountPrice;
    }

    public int getTotalDiscountPrice(){
        return totalDisCountPrice;
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
