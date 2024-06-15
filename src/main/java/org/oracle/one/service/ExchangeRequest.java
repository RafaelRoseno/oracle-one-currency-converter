package org.oracle.one.service;

public class ExchangeRequest {

    int menuOperationSelected;
    Long amount;

    public ExchangeRequest(int optionSelected, Long amount) {
        this.menuOperationSelected = optionSelected;
        this.amount = amount;
    }

    public int getMenuOperationSelected() {
        return menuOperationSelected;
    }

    public void setMenuOperationSelected(int menuOperationSelected) {
        this.menuOperationSelected = menuOperationSelected;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
