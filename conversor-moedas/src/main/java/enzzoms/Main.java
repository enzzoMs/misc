package enzzoms;

public class Main {
    public static void main(String[] args) {
        CLI.printIntroText();
        CLI.printCommands();

        CurrencyCommand currencyCommand = null;
        while (true) {
            currencyCommand = CLI.getUserCommand();
            if (currencyCommand != null) {
                if (currencyCommand.command().equals("Sair")) {
                    break;
                }
                double value = CLI.getUserValue();
                double conversionRate = ExchangeAPI.getConversionRate(currencyCommand.from(), currencyCommand.to());
                CLI.printResult(
                    value, currencyCommand.from(),
                    value * conversionRate, currencyCommand.to()
                );
            }
        }
    }
}