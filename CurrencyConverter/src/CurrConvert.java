import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;





class CurrConvert {

	

	public static void main(String[] args) throws IOException {
		
		Boolean going = true;
		do {
		// hashmap to store to type of vars and connect them together
		HashMap<Integer, String> currencyCode = new HashMap<Integer,String>();
		 // provide the key to the HashMay and the value connected to the string
		// lets do 8 until we know it works ... might update
		currencyCode.put(1, "USD");
		currencyCode.put(2, "EUR");
		currencyCode.put(3, "AUD");
		currencyCode.put(4, "CAD");
		currencyCode.put(5, "MXN");
		currencyCode.put(6, "THB");
		currencyCode.put(7, "TRY");
		currencyCode.put(8, "JPY");
		
		
		Integer from, to;
		// create two string variables
		String fromCode, toCode;
		// variable to hold the amount
		double amount;
		
		Scanner sc = new Scanner(System.in);
		// user interaction
		System.out.println("Welcome to the currency converter!\n When you are thinking about traveling it is always import to know how your currency transfers");
		
		System.out.println("Currency Converting FROM: ");
		
		System.out.println(" 1: USD - USA Dollar\n 2: EUR - Euro\n 3: AUD - Australia Dollar\n 4: CAD - Canada Dollar\n 5: MXN - Mexican Peso\n 6: THB - Thailand Baht\n 7: TRY - Turkish Iira\n 8: JPY - Japanese Yen");
		// store the integer as the string value ... user response
		from = sc.nextInt();
		while(from < 1 || from > 8) {
			System.out.println("Please select a valid currency");
			System.out.println(" 1: USD - USA Dollar\n 2: EUR - Euro\n 3: AUD - Australia Dollar\n 4: CAD - Canada Dollar\n 5: MXN - Mexican Peso\n 6: THB - Thailand Baht\n 7: TRY - Turkish Iira\n 8: JPY - Japanese Yen");
			from = sc.nextInt();
		}
		fromCode = currencyCode.get(from);
		
		System.out.println("Currency Converting TO: ");
		
		System.out.println(" 1: USD - USA Dollar\n 2: EUR - Euro\n 3: AUD - Australia Dollar\n 4: CAD - Canada Dollar\n 5: MXN - Mexican Peso\n 6: THB - Thailand Baht\n 7: TRY - Turkish Iira\n 8: JPY - Japanese Yen");
		// store the integer as the string value ... user response
		to = sc.nextInt();
		while(to < 1 || to > 8) {
			System.out.println("Please select a valid currency");
			System.out.println(" 1: USD - USA Dollar\n 2: EUR - Euro\n 3: AUD - Australia Dollar\n 4: CAD - Canada Dollar\n 5: MXN - Mexican Peso\n 6: THB - Thailand Baht\n 7: TRY - Turkish Iira\n 8: JPY - Japanese Yen");
			to = sc.nextInt();
		}
		toCode = currencyCode.get(to);
		
		System.out.println("What is the amount you want to convert: ");
		// store the integer as the double value (we need to think about decimals being entered)
		amount = sc.nextFloat();
		
		sendHttpGetRequest(fromCode, toCode, amount);
		
		System.out.println("Would you like to use the converter again? ");
		System.out.println("1: Yes \n 2: No");
		if(sc.nextInt() != 1) {
			going = false;
		}
		} while(going);
		System.out.println("Thank you for using the currency converter!");
	}
	
	private static void sendHttpGetRequest(String fromCode, String toCode, double amount) throws IOException {
		 // using an API through http to get up to date conversion of currency. 
		DecimalFormat f = new DecimalFormat("00.00"); // method to specify how many decimal places you want to have.
		String GET_URL = "https://api.exchangeratesapi.io/latest?base=" + toCode + "&symbols=" + fromCode;
		URL url = new URL(GET_URL); // establishing and building a proper http channel
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // several errors with potential exceptions ... followed recommendation and put IOException
		httpURLConnection.setRequestMethod("GET"); // sending a get request
		int responseCode = httpURLConnection.getResponseCode();
		// looking for a response code of ok == 200
		if(responseCode == HttpURLConnection.HTTP_OK) { // successful
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}in.close();
			// have to download and add JSON file to bring in the JSONObject class. 
			JSONObject obj = new JSONObject(response.toString()); // the API provides a JSON and we must convert the response into a readable file for the compiler
			Double exchangeRate = obj.getJSONObject("rates").getDouble(fromCode);
			System.out.println(obj.getJSONObject("rates"));
			System.out.println(exchangeRate); // keep for debugging
			System.out.println();
			System.out.println("$" + f.format(amount) + " " + fromCode + "=" + "$" + f.format(amount/exchangeRate) + " " + toCode);
		}
		else {
			System.out.println("The request failed");
		}
	}
}
