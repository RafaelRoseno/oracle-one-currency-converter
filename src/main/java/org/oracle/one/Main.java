package org.oracle.one;

import org.oracle.one.controller.ExchangeController;
import org.oracle.one.service.ExchangeRateService;
import org.oracle.one.view.UserView;

public class Main {
    public static void main(String[] args) {
        ExchangeRateService service = new ExchangeRateService();
        UserView view = new UserView();
        ExchangeController controller = new ExchangeController(service, view);
        controller.start();
    }
}