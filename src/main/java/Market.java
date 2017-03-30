import abstr.AbstractFinanceBuilding;
import entity.*;
import interfaces.Credit;
import interfaces.CurrencyExchange;
import interfaces.Deposit;
import interfaces.TransferMoney;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by Lenovo on 25.03.2017.
 */
public class Market {
    public List<AbstractFinanceBuilding> financeBuildings;

    public Market() {
        this.financeBuildings = makeListFromArray(generateFinanceBuildingsArray());
    }

    public AbstractFinanceBuilding[] generateFinanceBuildingsArray() {
        AbstractFinanceBuilding[] financeBuildings = new AbstractFinanceBuilding[14];
        financeBuildings[0] = new Bank("Privat Bank", "Kharkov city", 2000);
        financeBuildings[1] = new Bank("Ukr Sib Bank", "Kharkov city", 2001);
        financeBuildings[2] = new CreditCafe("Credit Cafe Name 1", "Kharkov city");
        financeBuildings[3] = new CreditCafe("Credit Cafe Name 2", "Kiev city");
        financeBuildings[4] = new CreditUnity("Credit Unity Name 1", "Kharkov city");
        financeBuildings[5] = new CreditUnity("Credit Unity Name 2", "Kiev city");
        financeBuildings[6] = new Lombard("Lombard Name 1", "Kharkov city");
        financeBuildings[7] = new Lombard("Lombard Name 2", "Sumy city");
        financeBuildings[8] = new Obmenka("Rosa", "Kharkov city");
        financeBuildings[9] = new Obmenka("Obmenka", "Poltava city");
        financeBuildings[10] = new PIF("PIF Name 1", "Kharkov city", 1999);
        financeBuildings[11] = new PIF("PIF Name 2", "Kiev city", 2009);
        financeBuildings[12] = new PostOffice("Post Office Name 1", "Kharkov city");
        financeBuildings[13] = new PostOffice("Post Office Name 2", "Kharkov city");

        return financeBuildings;
    }

    public List<AbstractFinanceBuilding> makeListFromArray(AbstractFinanceBuilding[] financeBuildingsArray) {
        List<AbstractFinanceBuilding> financeBuildingsList = new ArrayList<>();
        financeBuildingsList = Arrays.asList(financeBuildingsArray);
        return financeBuildingsList;
    }

    public void findBestVariantToSellHryvnia(
            //AbstractFinanceBuilding[] financeBuildings,
            String currencyName,
            double hryvniaAmount) {

        List<CurrencyExchange> currencyExchangeBuildingsList = new ArrayList<>();
        int indexOfTheBestVariant = 0;
        double bestVariant = 0;

        for (int i = 0; i < financeBuildings.size(); i++) {
            if (financeBuildings.get(i) instanceof CurrencyExchange) {
                currencyExchangeBuildingsList.add((CurrencyExchange) financeBuildings.get(i));
            }
        }
        bestVariant = currencyExchangeBuildingsList.get(0).sellCurrency(currencyName, hryvniaAmount);

        for (int i = 0; i < currencyExchangeBuildingsList.size(); i++) {
            double tempVariant = 0;
            tempVariant = currencyExchangeBuildingsList.get(i).sellCurrency(currencyName, hryvniaAmount);
            if (bestVariant < tempVariant) {
                indexOfTheBestVariant = i;
                bestVariant = tempVariant;
            }
        }

        System.out.println("Best solution:");
        System.out.println(hryvniaAmount + " UAH = " + bestVariant + " " + currencyName);
        System.out.println("Exchange building info:");
        System.out.println(currencyExchangeBuildingsList.get(indexOfTheBestVariant).toString());
    }


    public void findBestVariantToTakeCredit(
            //AbstractFinanceBuilding[] financeBuildings,
            double creditAmount) {

        List<Credit> creditBuildingsList = new ArrayList<>();
        int indexOfTheBestVariant = 0;
        double bestVariant = 0;

        for (int i = 0; i < financeBuildings.size(); i++) {
            if (financeBuildings.get(i) instanceof Credit) {
                creditBuildingsList.add((Credit) financeBuildings.get(i));
            }
        }
        bestVariant = creditBuildingsList.get(0).giveCredit(creditAmount);

        for (int i = 0; i < creditBuildingsList.size(); i++) {
            double tempVariant = 0;
            tempVariant = creditBuildingsList.get(i).giveCredit(creditAmount);
            if (bestVariant > tempVariant) {
                indexOfTheBestVariant = i;
                bestVariant = tempVariant;
            }
        }

        System.out.println("Best solution:");
        System.out.println("To get " + creditAmount + " UAH you need to give " + bestVariant + " UAH");
        System.out.println("Credit building info:");
        System.out.println(creditBuildingsList.get(indexOfTheBestVariant).toString());
    }


    public void findBestVariantToMakeDeposit(
            //AbstractFinanceBuilding[] financeBuildings,
            double depositAmount,
            int monthsAmount) {

        List<Deposit> depositBuildingsList = new ArrayList<>();
        int indexOfTheBestVariant = 0;
        double bestVariant = 0;

        for (int i = 0; i < financeBuildings.size(); i++) {
            if (financeBuildings.get(i) instanceof Deposit) {
                depositBuildingsList.add((Deposit) financeBuildings.get(i));
            }
        }
        bestVariant = depositBuildingsList.get(0).takeDeposit(depositAmount, monthsAmount);

        for (int i = 0; i < depositBuildingsList.size(); i++) {
            double tempVariant = 0;
            tempVariant = depositBuildingsList.get(i).takeDeposit(depositAmount, monthsAmount);
            if (bestVariant < tempVariant) {
                indexOfTheBestVariant = i;
                bestVariant = tempVariant;
            }
        }

        System.out.println("Best solution:");
        System.out.println("If you make deposit = " + depositAmount + " UAH you will get " + bestVariant + " UAH");
        System.out.println("Deposit building info:");
        System.out.println(depositBuildingsList.get(indexOfTheBestVariant).toString());
    }


    public void findBestVariantToMakeMoneyTransfer(
            //AbstractFinanceBuilding[] financeBuildings,
            double transferAmount) {

        List<TransferMoney> transferBuildingsList = new ArrayList<>();
        int indexOfTheBestVariant = 0;
        double bestVariant = 0;

        for (int i = 0; i < financeBuildings.size(); i++) {
            if (financeBuildings.get(i) instanceof TransferMoney) {
                transferBuildingsList.add((TransferMoney) financeBuildings.get(i));
            }
        }
        bestVariant = transferBuildingsList.get(0).makeTransfer(transferAmount);

        for (int i = 0; i < transferBuildingsList.size(); i++) {
            double tempVariant = 0;
            tempVariant = transferBuildingsList.get(i).makeTransfer(transferAmount);
            if (bestVariant > tempVariant) {
                indexOfTheBestVariant = i;
                bestVariant = tempVariant;
            }
        }

        System.out.println("Best solution:");
        System.out.println("If you make money transfer = " + transferAmount + " UAH you will give comission " + bestVariant + " UAH");
        System.out.println("Deposit building info:");
        System.out.println(transferBuildingsList.get(indexOfTheBestVariant).toString());
    }

    public void printSortedList() {
        System.out.println("Unsorted List:");
        printList();

        Collections.sort(financeBuildings, new Comparator<AbstractFinanceBuilding>() {
            @Override
            public int compare(AbstractFinanceBuilding o1, AbstractFinanceBuilding o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        System.out.println("Sorted List:");
        printList();
    }

    private void printList() {
        Iterator iterator = financeBuildings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
