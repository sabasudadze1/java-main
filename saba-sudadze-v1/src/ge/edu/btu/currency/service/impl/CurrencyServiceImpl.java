package ge.edu.btu.currency.service.impl;

import ge.edu.btu.currency.service.CurrencyService;

public class CurrencyServiceImpl implements CurrencyService {
	
	private int exchangeRate;
	
	@Override
	public int convertAmount(int money) {
		return this.exchangeRate * money;
	}

	@Override
	public void setExchangeRate(int eRate) {
		this.exchangeRate = eRate;

	}

}
