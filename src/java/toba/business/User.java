package toba.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import toba.account.Account;
import toba.account.AccountDB;
import toba.transaction.Transaction;

@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String username;
    private String password;
   
    public User() {
        firstName = "";
        lastName = "";
        phone = "";
        address = "";
        city = "";
        state = "";
        zip = "";
        email = "";
        username = lastName + zip;
        password = "welcome1";
    }

    public User(String firstName, String lastName, String phone, String address, 
            String city, String state, String zip, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        username = lastName + zip;
        password = "welcome1";
    }
    
    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }  

    public List<Transaction> getTransactionHistory(){
        
        ArrayList<Transaction> checking = AccountDB
                                    .findByUserId(this.getUserId(), "CHECKING")
                                    .getList();
        
        List<Transaction> allTransactions = new ArrayList<Transaction>(checking);

        ArrayList<Transaction> savings = AccountDB
                                    .findByUserId(this.getUserId(), "SAVINGS")
                                    .getList();
        
        allTransactions.addAll(savings);
        return allTransactions;
    }
}
