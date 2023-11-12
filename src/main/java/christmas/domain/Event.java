package christmas.domain;

public abstract class Event {
    public abstract void calculateDiscountPrice();
    public abstract Boolean validateEnableEvent();
}