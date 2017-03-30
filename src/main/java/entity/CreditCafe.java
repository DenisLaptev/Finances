package entity;

import abstr.AbstractFinanceBuilding;
import interfaces.Credit;

/**
 * Created by Lenovo on 25.03.2017.
 */
public class CreditCafe extends AbstractFinanceBuilding implements Credit {
    public CreditCafe(String name, String address) {
        super(name, address);
    }

    @Override
    public double giveCredit(double creditAmount) {
        double result = 0;

        if (creditAmount <= 4_000) {
            result = creditAmount + creditAmount * 2;
        } else {
            try {
                throw (new Exception(name + ": too big sum!"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "CreditCafe{" +
                "name=" + name +
                ", address=" + address +
                '}';
    }
}
