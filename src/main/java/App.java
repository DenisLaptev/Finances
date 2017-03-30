import abstr.AbstractFinanceBuilding;
import entity.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Lenovo on 25.03.2017.
 */
public class App {


    public static void main(String[] args) {
        Market market = new Market();

        System.out.println("Selling Hryvnia:");
        market.findBestVariantToSellHryvnia("USD", 20_000);

        System.out.println("------------------------------------------------------");

        System.out.println("Taking Credit:");
        market.findBestVariantToTakeCredit(50_000);

        System.out.println("------------------------------------------------------");

        System.out.println("Making Deposit:");
        market.findBestVariantToMakeDeposit(5000, 12);

        System.out.println("------------------------------------------------------");

        System.out.println("Making Money Transfer:");
        market.findBestVariantToMakeMoneyTransfer(1000);

        System.out.println("------------------------------------------------------");

        System.out.println("Sort list of finance buildings:");
        market.printSortedList();
    }
}
