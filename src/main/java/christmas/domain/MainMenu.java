package christmas.domain;

public enum MainMenu {
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private final String name;
    private final int price;
    private static int orderCount = 0;

    MainMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static void addOrderCount(int orderCount) {
        MainMenu.orderCount += orderCount;
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
