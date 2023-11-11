package christmas.domain;

public enum Appetizer {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private final String name;
    private final int price;
    private static int orderCount = 0;

    Appetizer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static void addOrderCount(int orderCount) {
        Appetizer.orderCount += orderCount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getOrderCount() {
        return orderCount;
    }
}
