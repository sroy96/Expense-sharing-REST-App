package com.split.split.DAO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document
public class Accounts {
    @Id
    private String id;
    private  String name;
    private int balance;
    private String mail;

    public Accounts() {
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Accounts(String name, String mail, int balance) {
        this.name = name;
        this.mail = mail;
        this.balance=balance;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    @Override
    public String toString() {
        return "Accounts{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mail='" + mail +
                '}';
    }
}
