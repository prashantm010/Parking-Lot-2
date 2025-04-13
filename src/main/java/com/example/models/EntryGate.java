package com.example.models;

import lombok.Data;

@Data
public class EntryGate {
    Integer gateNo;

    public EntryGate(Integer gateNo) {
        this.gateNo = gateNo;
    }
}
