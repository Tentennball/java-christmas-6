package christmas.domain;

public enum Dessert {
    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String name;
    private final int price;

    private static int orderCount = 0;

    Dessert(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static void addOrderCount(int orderCount) {
        Dessert.orderCount += orderCount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getOrderCount(){
        return orderCount;
    }
}