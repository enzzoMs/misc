package enzzoms;

import java.util.Scanner;

public class CLI {
    private static final CurrencyCommand[] commands = {
        new CurrencyCommand("Dólar =>> Peso Argentino", CurrencyCodes.USD, CurrencyCodes.ARS),
        new CurrencyCommand("Peso Argentino =>> Dólar", CurrencyCodes.ARS, CurrencyCodes.USD),
        new CurrencyCommand("Dólar =>> Real Brasileiro", CurrencyCodes.USD, CurrencyCodes.BRL),
        new CurrencyCommand("Real Brasileiro =>> Dólar", CurrencyCodes.BRL, CurrencyCodes.USD),
        new CurrencyCommand("Dólar =>> Peso Colombiano", CurrencyCodes.USD, CurrencyCodes.COP),
        new CurrencyCommand("Peso Colombiano =>> Dólar", CurrencyCodes.COP, CurrencyCodes.ARS),
        new CurrencyCommand("Sair", null, null)
    };

    public static void printIntroText() {
        System.out.println("*".repeat(60));
        System.out.println("Seja bem-vindo/a ao Conversor de Moedas =]\n");
    }

    public static void printCommands() {
        for (int i = 0; i < commands.length; i++) {
            System.out.printf("%d) %s\n", i + 1, commands[i].command());
        }
    }

    public static CurrencyCommand getUserCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha uma opção válida: ");
        String command = scanner.nextLine();

        try {
            int num = Integer.parseInt(command);
            if (num > commands.length || num < 1) {
                return null;
            }
            return commands[num - 1];
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static double getUserValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor que deseja converter: ");
        String value = scanner.nextLine();

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void printResult(
        double fromValue, CurrencyCodes fromCurrency, double toValue, CurrencyCodes toCurrency
    ) {
        System.out.printf(
            "Valor %.2f [%s] corresponde ao valor final de =>> %.2f [%s]\n",
            fromValue, fromCurrency.toString(), toValue, toCurrency.toString()
        );
    }
}
