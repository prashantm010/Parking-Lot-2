package com.example.models;

import lombok.Data;

@Data
public class ExitGate {
    Integer gateNo;

    public ExitGate(Integer gateNo) {
        this.gateNo = gateNo;
    }
}
