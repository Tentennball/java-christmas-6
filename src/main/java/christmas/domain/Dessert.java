package christmas.domain;

public enum Dessert {
    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String name;
    private final int price;

    Dessert(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Dessert getOrderInfo(String key) {
        for (Dessert value : Dessert.values()) {
            if (key.equals(value.getName())) {
                return value;
            }
        }
        return null;
    }
    
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}