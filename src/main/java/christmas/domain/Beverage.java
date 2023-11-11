package christmas.domain;

public enum Beverage {
    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    private final String name;
    private final int price;
    private static int orderCount = 0;

    Beverage(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static void addOrderCount(int orderCount) {
        Beverage.orderCount += orderCount;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static int getOrderCount() {
        return orderCount;
    }
}