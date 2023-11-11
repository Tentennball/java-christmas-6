package christmas.domain;


public class Order {
    private int totalPrice = 0;
    private int totalOrderCount = 0;
    private Date date;
    private Menu menu;

    public Order(Date date, Menu menu) {
        this.date = date;
        this.menu = menu;

    }

    public void addTotalPrice(int price) {
        totalPrice += price;
    }

    public void addTotalOrderCount(int orderCount) {
        totalOrderCount += orderCount;
    }

    public int getTotalOrderCount(){
        return totalOrderCount;
    }

    public int getTotalPrice(){
        return totalPrice;
    }
}
