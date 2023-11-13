package ServerSide;
import javafx.util.Pair;

import java.io.Serializable;
import java.util.*;
public class Item implements Serializable {


    private double currentCost;
    private double startCost;
    private double curCost;
    private double desiredCost;
    private double soldCost;
    private String curHighestBidder;
    private String description;
    List<Pair<Double,String>> bidHistory;
    private boolean sold;


    public Item(double startCost, double desiredCost, String description){
        this.startCost = startCost;
        this.curCost = startCost;
        this.curHighestBidder = "";
        this.desiredCost = desiredCost;
        this.description = description;
        bidHistory = new ArrayList<>();
    }

    public double bidOnItem(double bid, String bidder){
        if(bid>curCost){
            bidHistory.add(new Pair(bid,bidder));
            curCost = bid;
            this.curHighestBidder = bidder;
            if(bid>desiredCost){
                soldCost = bid;
                sell();
            }
            return bid;
        } else {
            return -0.1;    //Return this if bid was lower than current bid max
        }
    }

    public void sell(){
        sold = true;
    }
}
