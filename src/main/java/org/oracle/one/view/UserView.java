package org.oracle.one.view;

import org.oracle.one.service.ExchangeRateResponse;

public class UserView {



    public void printMenu() {
        System.out.println(
        """
        *************************************
        Escolha uma opção para realizar a conversão
        1)  Real Brasileiro -> Dólar
        2)  Real Brasileiro -> Euro
        3)      Dólar       -> Real Brasileiro
        4)      Dólar       -> Peso Argentino
        5)      Dólar       -> Euro
        6)      Dólar       -> Peso Colombiano
        7)  Peso Argentino  -> Dólar
        8)  Peso Colombiano -> Dólar
        9)      Euro        -> Real Brasileiro
        10)     Euro        -> Dólar
        0) Sair
        *************************************
        """
        );
    }

    public void printGetAmount() {
        System.out.print(
                """
                Digite o valor:
                """
        );
    }

    public void invalidInputWarning(){
        System.out.print(
                """
                Valor inválido. Digite uma opção entre 0 e 10.:
                """
        );
    }

    public void invalidAmountWarning(){
        System.out.print(
                """
                Valor inválido. Digite um valor inteiro.:
                """
        );
    }

    public void printExchangeCurrencyResult(Long amount, ExchangeRateResponse response){
        String exchangeCurencyResult =
                """
                %d %s = %.4f %s
                """;
        System.out.printf((exchangeCurencyResult) + "%n",amount, response.getBaseCode(), response.getConversionResult(), response.getTargetCode());
    }

    public void newOperation(){
        System.out.print(
                """
                Insira qualquer valor para continuar.
                """
        );
    }
}
