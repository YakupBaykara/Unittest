package com.yb.unittest.assertj;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Customer {

    private String username;
    private String email;
    private List<Gift> gifts = new ArrayList<Gift>();

    public void addGift(Gift gift) {
        gifts.add(gift);
    }

    public Customer(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
