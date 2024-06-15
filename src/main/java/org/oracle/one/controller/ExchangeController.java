package org.oracle.one.controller;

import org.oracle.one.service.ExchangeRateService;
import org.oracle.one.service.ExchangeRequest;
import org.oracle.one.view.UserView;

import java.util.Scanner;

public class ExchangeController {
    private final ExchangeRateService service;
    private final UserView view;
    private final Scanner scanner;

    public ExchangeController(ExchangeRateService service, UserView view) {
        this.service = service;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            var operationSelected = getOperation();
            var response = service.processExchangeRate(operationSelected);
            view.printExchangeCurrencyResult(operationSelected.getAmount(), response);
            view.newOperation();
            scanner.next();
        }
    }

    private ExchangeRequest getOperation(){

        int optionSelected = 10;
        do {
            verifyValidOption(optionSelected);
            view.printMenu();
            optionSelected = scanner.nextInt();

        }while (optionSelected > 10);

        if(optionSelected == 0){
            System.exit(0);
        }

        return new ExchangeRequest(optionSelected, getAmount());
    }

    private Long getAmount() {
        long amount;

        while (true) {
            try {
                view.printGetAmount();
                amount = scanner.nextLong();
                break;
            } catch (Exception e) {
                view.invalidAmountWarning();
                scanner.nextLine();
            }
        }
        return amount;
    }

    private void verifyValidOption(int optionSelected){
        if(optionSelected > 10 || optionSelected < 0){
            view.invalidInputWarning();
        }
    }


}
