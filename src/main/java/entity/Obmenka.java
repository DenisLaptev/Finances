package entity;

import abstr.AbstractFinanceBuilding;
import interfaces.CurrencyExchange;

/**
 * Created by Lenovo on 25.03.2017.
 */
public class Obmenka extends AbstractFinanceBuilding implements CurrencyExchange {

    public Obmenka(String name, String address) {
        super(name, address);
    }

    @Override
    public double buyCurrency(String currencyName, double hryvniaAmount) {
        double result = 0;
        switch (currencyName) {
            case "USD":
                result = hryvniaAmount / 27;
                break;

            case "EUR":
                result = hryvniaAmount / 30;
                break;

            default:
                System.out.println("wrong data!");
                break;
        }
        return result;
    }

    @Override
    public double sellCurrency(String currencyName, double currencyAmount) {
        double result = 0;
        switch (currencyName) {
            case "USD":
                result = currencyAmount * 28;
                break;

            case "EUR":
                result = currencyAmount * 31;
                break;

            default:
                System.out.println("wrong data!");
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Obmenka{" +
                "name=" + name +
                ", address=" + address +
                '}';
    }
}
