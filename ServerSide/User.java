package ServerSide;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User {

    private String name;
    private String password;

    private List<Bid> userBidHistory;

    public User(String name, String password){
        this.name = name;
        this.password = StringEncryptorDecryptor.encrypt(password);
        userBidHistory = new ArrayList<>();
    }










}
