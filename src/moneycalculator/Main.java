
package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.persistence.RestExchangeRateLoader;
import moneycalculator.persistence.files.FIleCurrencyListLoader;


public class Main {

   
    public static void main(String[] args) {
        CurrencyListLoader currencyloader = new FIleCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyloader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }
}
