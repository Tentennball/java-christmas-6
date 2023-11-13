package christmas.domain;

import christmas.constant.EventConstant;

public class PresentEvent extends Event{
    private boolean isEnabled;
    private int totalPrice;

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
        return Beverage.CHAMPAGNE.getPrice();
    }

    @Override
    public Boolean getIsEnabled(){
        return isEnabled;
    }
}
