package interfaces;

/**
 * Created by Lenovo on 25.03.2017.
 */
public interface CurrencyExchange {
    double buyCurrency(String currencyName, double currencyAmount);

    double sellCurrency(String currencyName, double hryvniaAmount);

}
