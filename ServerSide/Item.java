package ServerSide;
import java.util.Timer;
import java.util.TimerTask;
import java.io.Serializable;
import java.net.URL;

public class Item implements Serializable {
    private String itemID;
    private String itemName;
    private String description;
    private String imageRef;
    private double startPrice;
    private double curPrice;    //min acceptable price is this +0.01
    private double minPrice;
    private double buyNowPrice;

    //private Timer timer;
    private boolean sold = false;
    private int timerDuration;


    /*private TimerTask timeRanOut = new TimerTask(){
        @Override
                public void run(){
                    sold = true;
        }
    }; */

    public Item(String itemID, String itemName, String description, String imageRef, double startPrice, double buyNowPrice, int timerDuration){
        this.itemID= itemID;
        this.itemName = itemName;
        this.description = description;
        this.imageRef = imageRef;
        this.startPrice = startPrice;
        this.minPrice = startPrice +0.01;
        this.buyNowPrice = buyNowPrice;
        this.timerDuration = timerDuration;
    }

    public int getTimerDuration(){
        return this.timerDuration;
    }
    public String getImageRef(){
        return this.imageRef;
    }

    public String getItemName(){
        return this.itemName;
    }

}
