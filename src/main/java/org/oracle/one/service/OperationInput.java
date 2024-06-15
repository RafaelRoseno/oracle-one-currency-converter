package org.oracle.one.service;

import org.oracle.one.utils.Currencies;

public class OperationInput {

    Currencies base;
    Currencies target;
    Long amount;

    public OperationInput(Currencies base, Currencies target, long amount) {
        this.base = base;
        this.target = target;
        this.amount = amount;
    }

    public Currencies getBase() {
        return base;
    }

    public void setBase(Currencies base) {
        this.base = base;
    }

    public Currencies getTarget() {
        return target;
    }

    public void setTarget(Currencies target) {
        this.target = target;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
