package christmas.domain;

public abstract class Event {
    public abstract int calculateDiscountPrice();
    public abstract Boolean validateEnableEvent();
    public abstract Boolean getIsEnabled();
}