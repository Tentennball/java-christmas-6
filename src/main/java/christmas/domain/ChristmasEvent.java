package christmas.domain;

public class ChristmasEvent extends Event {
    int reservationDate;

    public ChristmasEvent(int reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public Boolean validateEnableEvent() {
        return (reservationDate <= 25);

    }

    @Override
    public void calculateDiscountPrice() {
        // TODO Auto-generated method stub

    }

}
