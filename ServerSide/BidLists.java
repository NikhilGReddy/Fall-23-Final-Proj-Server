package ServerSide;

import java.util.ArrayList;
import java.util.List;

public class BidLists {

    private List<Bid> bids;

    public BidLists(){
        this.bids = new ArrayList<>();
    }

    public void addBid(Bid bid){
        bids.add(bid);
    }

    public List<Bid> getUserBids(Customer customer){
        try {
            List<Bid> custBids = new ArrayList<>();
            for (Bid i : bids) {
                if(i.customerName().equals(customer.getCustomerName())){
                    custBids.add(i);
                }
            }
            return custBids;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
