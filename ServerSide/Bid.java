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

    public String customerName(){
        return this.customer.getCustomerName();
    }

    public String itemName(){
        return this.item.getItemName();
    }

    public String forItemString(){
        return "Customer : " + customer.getCustomerName() +  " Amount: " + bidAmount;
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
