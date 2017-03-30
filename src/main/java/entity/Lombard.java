package entity;

import abstr.AbstractFinanceBuilding;
import interfaces.Credit;

/**
 * Created by Lenovo on 25.03.2017.
 */
public class Lombard extends AbstractFinanceBuilding implements Credit {

    public Lombard(String name, String address) {
        super(name, address);
    }


    public boolean isPossible(double creditAmount) {
        boolean result = false;
        if (creditAmount <= 50_000) {
            result = true;
        }
        return result;
    }

    @Override
    public double giveCredit(double creditAmount) {
        double result = 0;

        if (creditAmount <= 50_000) {
            result = creditAmount + creditAmount * 0.4;
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
        return "Lombard{" +
                "name=" + name +
                ", address=" + address +
                '}';
    }
}
