package enzzoms;

public record CurrencyCommand(String command, CurrencyCodes from, CurrencyCodes to) {}
