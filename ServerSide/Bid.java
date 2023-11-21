package ServerSide;

public class Bid {
    private String bidId;
    private Customer customer;
    private Item item;
    private double bidAmount;

    public Bid(Customer customer, Item item, double bidAmount){
        try {
            this.customer = customer;
            this.item = item;
            this.bidAmount = bidAmount;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
