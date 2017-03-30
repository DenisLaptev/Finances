package entity;

import abstr.AbstractFinanceBuilding;
import interfaces.*;

import java.util.Comparator;

/**
 * Created by Lenovo on 25.03.2017.
 */
public class Bank extends AbstractFinanceBuilding
        implements CurrencyExchange,
        Credit,
        Deposit,
        TransferMoney {

    int yearOfLicense;


    public Bank(String name, String address, int yearOfLicense) {
        super(name, address);

        this.yearOfLicense = yearOfLicense;
    }

    @Override
    public double giveCredit(double creditAmount) {
        double result = 0;

        if (creditAmount <= 200_000) {
            result = creditAmount + creditAmount * 0.25;
        } else {
            try {
                throw (new Exception("too big sum!"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public double takeDeposit(double depositAmount, int monthsAmount) {
        double result = 0;

        if (monthsAmount <= 12) {
            result = depositAmount + depositAmount * 0.3;//30% deposit percents.
        } else {
            try {
                throw (new Exception(name + ": too long period!"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public double makeTransfer(double transferAmount) {
        double comission;
        comission = 0.01 * transferAmount + 5;
        return comission;
    }

    @Override
    public double buyCurrency(String currencyName, double hryvniaAmount) {
        double result = 0;

        switch (currencyName) {
            case "USD":
                result = (hryvniaAmount - 15) / 27;
                break;

            case "EUR":
                result = (hryvniaAmount - 15) / 30;
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
                result = currencyAmount * 28 + 15;
                break;

            case "EUR":
                result = currencyAmount * 31 + 15;
                break;

            default:
                System.out.println("wrong data!");
                break;
        }
        if (result > 12_000) {
            try {
                throw new Exception(name + ": exceeded max currency amount!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name=" + name +
                ", address=" + address +
                ", yearOfLicense=" + yearOfLicense +
                '}';
    }
}
