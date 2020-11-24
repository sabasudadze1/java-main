package ge.edu.btu.currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import ge.edu.btu.currency.service.CurrencyService;
import ge.edu.btu.currency.service.impl.CurrencyServiceImpl;

public class Main {


	private static Logger logger = Logger.getLogger(ge.edu.btu.currency.Main.class);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		logger.info("Started currency exchange application");
		CurrencyService currencyService = new CurrencyServiceImpl();
		System.out.println("Please enter exchange rate");
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		int eRate = Integer.parseInt(inp.readLine());
		logger.debug("Settring currency exchange rate :-" + eRate);
		currencyService.setExchangeRate(eRate);
		
		System.out.println("Please enter money to exchange");
		BufferedReader inp2 = new BufferedReader (new InputStreamReader(System.in));
		int money = Integer.parseInt(inp2.readLine());
		logger.debug("Converting currency");
		int convertedAmount = currencyService.convertAmount(money);
		logger.info("\nGot " + convertedAmount + " after conversion");

	}

}
