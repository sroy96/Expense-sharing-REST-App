package com.split.split.DAO;


import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Transactions {
    @Id
    private String id;
    private String TrId;
    private String GivenBy;
    private String TakenBy;
    private int Amount;

    public Transactions() {
    }

    public Transactions(String trId, String givenBy, String takenBy, int amount) {
        TrId = trId;
        GivenBy = givenBy;
        TakenBy = takenBy;
        Amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrId() {
        return TrId;
    }

    public void setTrId(String trId) {
        TrId = trId;
    }

    public String getGivenBy() {
        return GivenBy;
    }

    public void setGivenBy(String givenBy) {
        GivenBy = givenBy;
    }

    public String getTakenBy() {
        return TakenBy;
    }

    public void setTakenBy(String takenBy) {
        TakenBy = takenBy;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
    @Override
    public String toString() {
        return "account{" +
                "id='" + id + '\'' +
                ", TrId='" + TrId + '\'' +
                ", GivenBy='" + GivenBy +'\'' +
                ", TakenBy='" + TakenBy +'\'' +
                ", Amount='" + Amount +
                '}';
    }

}
