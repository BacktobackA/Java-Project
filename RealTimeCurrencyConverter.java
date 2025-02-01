// import java.util.Scanner;

// public class CurrencyConverter {

//     // Predefined list of available currencies
//     public static final String[] availableCurrencies = {
//         "USD", "EUR", "GBP", "INR", "JPY", "AUD", "CAD", "CHF", "CNY", "NZD"
//     };

//     // Method to display available currencies
//     public static void displayCurrencies() {
//         System.out.println("Available Currencies:");
//         for (int i = 0; i < availableCurrencies.length; i++) {
//             System.out.println((i + 1) + ". " + availableCurrencies[i]);
//         }
//     }

//     // Method to get the currency selection from the user
//     public static String selectCurrency(String type, Scanner scanner) {
//         displayCurrencies();
//         System.out.print("Select the " + type + " currency (choose a number from 1 to " + availableCurrencies.length + "): ");
        
//         int choice = scanner.nextInt();
//         while (choice < 1 || choice > availableCurrencies.length) {
//             System.out.print("Invalid choice! Please choose a valid number: ");
//             choice = scanner.nextInt();
//         }
        
//         return availableCurrencies[choice - 1];
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Selecting base currency
//         String baseCurrency = selectCurrency("base", scanner);
//         System.out.println("Base Currency Selected: " + baseCurrency);

//         // Selecting target currency
//         String targetCurrency = selectCurrency("target", scanner);
//         System.out.println("Target Currency Selected: " + targetCurrency);

//         // Asking user for the amount to convert
//         System.out.print("Enter the amount you want to convert: ");
//         double amount = scanner.nextDouble();

//         // Just displaying the selections and amount here
//         // In a real application, you would use these inputs for currency conversion
//         System.out.println("\nYou are converting " + amount + " " + baseCurrency + " to " + targetCurrency + ".");
        
//         // Placeholder for conversion logic (e.g., calling an API for exchange rates)
//         // double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);

//         scanner.close();
//     }
// }

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {

    // Replace with your actual API key from ExchangeRate-API
    public static final String API_KEY = "your_api_key_here";
    public static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    // Method to fetch exchange rate for a given base and target currency
    public static double fetchExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String urlString = API_URL + baseCurrency;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Get the response from the API
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(content.toString());
        if (jsonResponse.getString("result").equals("success")) {
            // Get the exchange rate for the target currency
            double exchangeRate = jsonResponse.getJSONObject("conversion_rates").getDouble(targetCurrency);
            return exchangeRate;
        } else {
            throw new Exception("Error fetching exchange rate: " + jsonResponse.getString("error-type"));
        }
    }

    // Main method to drive the currency converter
    public static void main(String[] args) {
        String baseCurrency = "USD"; // You can change this
        String targetCurrency = "INR"; // You can change this
        double amount = 100; // The amount to convert
        
        try {
            // Fetch exchange rate
            double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);
            
            // Perform the conversion
            double convertedAmount = amount * exchangeRate;
            
            // Display the result
            System.out.printf("%.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

