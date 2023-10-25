package com.app.Task1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);   // Default currency
        exchangeRates.put("EUR", 0.85);  // Euro
        exchangeRates.put("JPY", 111.07); // Japanese Yen
        exchangeRates.put("GBP", 0.74);  // British Pound
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return amount * (toRate / fromRate);
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter");
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the source currency (e.g., USD, EUR, JPY): ");
        String sourceCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., USD, EUR, JPY): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        double result = converter.convert(amount, sourceCurrency, targetCurrency);

        System.out.printf("%.2f %s is equal to %.2f %s\n", amount, sourceCurrency, result, targetCurrency);

        scanner.close();
    }
}

