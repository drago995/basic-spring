package com.example.nob2v2.transaction;

import lombok.Data;

@Data
public class TransferDTO {

    private String fromUser;
    private String toUser;
    private double amount;
}
