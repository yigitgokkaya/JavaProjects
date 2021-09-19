import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    public static  void Menu() throws JSONException, IOException {
        HashMap<Integer, String> currencynumbers = new HashMap<Integer, String>();

        currencynumbers.put(1, "TRY");
        currencynumbers.put(2, "USD");
        currencynumbers.put(3, "EUR");
        currencynumbers.put(4, "CAD");
        currencynumbers.put(5, "HKD");
        currencynumbers.put(6, "INR");

        // Enter your API KEY HERE
        String api_key = "YOUR-API-KEY";
        String from_cur, to_cur;
        Double ammount;
        int choice;
        do {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Currency Converter.Please press '1' for conversion and press '2' if u wish to exit:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please Select the currency that you want to convert from:");
                    System.out.println("1:TRY(TURKISH LIRA)\t 2:USD(US DOLLAR)\t 3:EUR(EURO)\t 4:CAD(CANADIAN DOLLAR)\t   5:HKD(HONG KONG DOLLAR)\t 6:INR(INDIAN RUPEE)\t");
                    from_cur = currencynumbers.get(scanner.nextInt());

                    System.out.println("Please Select the currency that you want to convert to:");
                    System.out.println("1:TRY(TURKISH LIRA)\t 2:USD(US DOLLAR)\t 3:EUR(EURO)\t 4:CAD(CANADIAN DOLLAR)\t   5:HKD(HONG KONG DOLLAR)\t 6:INR(INDIAN RUPEE)\t");
                    to_cur = currencynumbers.get(scanner.nextInt());

                    System.out.println("Please enter the ammount that you wish to convert:");
                    ammount = scanner.nextDouble();

                    SendHttpGETRequest.get_request(api_key,from_cur,to_cur,ammount);

                    break;

                case 2:
                    System.out.println("Thank you for using the Currency Converter!");
                    System.exit(0);
                default:
                    System.out.println(choice + " is not a valid option!");

            }
        } while (choice != 2);
    }
}
