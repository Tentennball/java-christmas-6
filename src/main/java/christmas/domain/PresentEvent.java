package christmas.domain;

import christmas.constant.EventConstant;

public class PresentEvent extends Event{
    private boolean isEnabled;
    private int totalPrice;
    private int discountPrice;
    public PresentEvent(int totalPrice){
        this.totalPrice = totalPrice;
    }
    @Override
    public Boolean validateEnableEvent() {
        if(totalPrice>=EventConstant.PRESENT_EVENT_TOTAL_PRICE){
            isEnabled = true;
            return true;
        }
        isEnabled = false;
        return false;
    }
    @Override
    public int calculateDiscountPrice() {
        discountPrice = Beverage.CHAMPAGNE.getPrice();
        return discountPrice;
    }

    @Override
    public Boolean getIsEnabled(){
        return isEnabled;
    }

    public int getDiscountPrice(){
        return discountPrice;
    }
}
