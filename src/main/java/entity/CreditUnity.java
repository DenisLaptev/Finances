package entity;

import abstr.AbstractFinanceBuilding;
import interfaces.Credit;

/**
 * Created by Lenovo on 25.03.2017.
 */
public class CreditUnity extends AbstractFinanceBuilding implements Credit {
    public CreditUnity(String name, String address) {
        super(name, address);
    }

    @Override
    public double giveCredit(double creditAmount) {
        double result = 0;

        if (creditAmount <= 100_000) {
            result = creditAmount + creditAmount * 0.2;
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
        return "CreditUnity{" +
                "name=" + name +
                ", address=" + address +
                '}';
    }

}
