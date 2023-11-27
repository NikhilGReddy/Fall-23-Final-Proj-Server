package ServerSide;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BidLists {

    private static List<Bid> bids;
    static Gson gson = new Gson();

    static Item[] items;
    static Customer[] customers;

    public void readJson(){
        try {
           items = gson.fromJson(new FileReader("ServerSide/DataBase/item.json"), Item[].class);
           System.out.println(" 1 " + items[0].getItemName());
           customers = gson.fromJson(new FileReader("ServerSide/DataBase/customer.json"),Customer[].class);
           System.out.println(" 2 " + customers[0].getCustomerName());
           bids = new ArrayList<Bid>(Arrays.asList(gson.fromJson(new FileReader("ServerSide/DataBase/bid.json"), Bid[].class)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Customer customerLookup(String name){
        for(Customer c : customers){
            if(c.getCustomerName().equals(name)){
                return c;
            }
        }
        return null;
    }
    public BidLists(){
        this.bids = new ArrayList<>();
    }

    public static void addBid(Bid bid){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("ServerSide/DataBase/bid.json");
            bids.add(bid);
            gson.toJson(bids, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
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

    public static boolean checkUserLogin(String name, String password){
        String decryptedPassword = StringEncryptorDecryptor.decrypt(password);
        for(Customer c : customers){
            if(c.getCustomerName().equals(name) && c.getCustomerPassword().equals(decryptedPassword)) return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String s = "";
        for(Bid b : bids){
            s += b.toString();
            s+= "\n";
        }
        return s;
    }




}
