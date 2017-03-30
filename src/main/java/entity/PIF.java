package entity;

import abstr.AbstractFinanceBuilding;
import interfaces.Deposit;

/**
 * Created by Lenovo on 25.03.2017.
 */
public class PIF extends AbstractFinanceBuilding implements Deposit {
    int yearOfStart;

    public PIF(String name, String address, int yearOfStart) {
        super(name, address);

        this.yearOfStart = yearOfStart;
    }


    @Override
    public double takeDeposit(double depositAmount, int monthsAmount) {
        double result = 0;

        if (monthsAmount >= 12) {
            result = depositAmount + depositAmount * 0.3;//30% deposit percents.
        } else {
            try {
                throw (new Exception(name + ": too short period!"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Obmenka{" +
                "name=" + name +
                ", address=" + address +
                ", year of start=" + yearOfStart +
                '}';
    }
}
