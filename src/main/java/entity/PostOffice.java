package entity;

import abstr.AbstractFinanceBuilding;
import interfaces.TransferMoney;

/**
 * Created by Lenovo on 25.03.2017.
 */
public class PostOffice extends AbstractFinanceBuilding implements TransferMoney {
    public PostOffice(String name, String address) {
        super(name, address);
    }

    @Override
    public double makeTransfer(double transferAmount) {
        double comission;
        comission = 0.02 * transferAmount;
        return comission;
    }

    @Override
    public String toString() {
        return "PostOffice{" +
                "name=" + name +
                ", address=" + address +
                '}';
    }
}
