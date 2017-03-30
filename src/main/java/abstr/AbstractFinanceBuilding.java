package abstr;

import interfaces.Credit;
import interfaces.CurrencyExchange;
import interfaces.Deposit;
import interfaces.TransferMoney;

/**
 * Created by Lenovo on 25.03.2017.
 */
public abstract class AbstractFinanceBuilding {

    public String name;
    public String address;

    public AbstractFinanceBuilding(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "AbstractFinanceBuilding{" +
                "name=" + name +
                ", address=" + address +
                '}';
    }
}
