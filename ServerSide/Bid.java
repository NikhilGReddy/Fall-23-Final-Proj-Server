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

    public String toString(){
        try {
            return "Customer : " + customer.getCustomerName() + " Item: " + item.getItemName() + " Amount: " + bidAmount;
        }catch (Exception e ){
            e.printStackTrace();
        }
        return null;
    }


}
