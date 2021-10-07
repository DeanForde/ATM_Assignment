package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Accounts;
import com.example.model.Teller;
import com.example.service.AccountService;
import com.example.service.TellerService;


@RestController
@RequestMapping("/teller")
public class Controller {
	@Autowired
	AccountService accountService;
	
	@Autowired
	TellerService tellerService;
	
	@RequestMapping("account/{account_no}/{pin_no}")
	public String getAccount(@PathVariable Integer account_no, @PathVariable Integer pin_no){
		try {
			Accounts acc = accountService.getAccount(account_no);
			if(accountService.checkPin(acc, pin_no))
				return accountService.getBalance(acc);
			return "incorrect pin, try again";
		}
		catch(Exception e) {
			return "incorrect account number, try again";
		}
	}
	
	@RequestMapping("withdraw/{account_no}/{pin_no}/{amount}")
	public String withdraw(@PathVariable Integer account_no, @PathVariable Integer pin_no, @PathVariable Double amount){
		try {

			Accounts acc = accountService.getAccount(account_no);
			Teller teller = tellerService.getTeller(0);
			if(accountService.checkPin(acc, pin_no)) {
				if(amount <= (accountService.availableFunds(acc))) {
					if(amount <= tellerService.getTotalFunds(teller)) {
						String notes = tellerService.dispenseCash(teller, amount);
						tellerService.updateTotal(teller);
						accountService.updateBalance(acc, amount);
						return notes + "\n" + accountService.getBalance(acc);
					}
					return "Not enough money in atm machine. \n" + "Amount requested: " + Double.toString(amount) + "\n" + "Total Amount in ATM: " + Double.toString(teller.getTotal());  
				}
				return "insufficient funds";
			}
			return "incorrect pin, try again";
			}
			catch(Exception e) {
				return "incorrect account number, try again \n" + e ;
			}
	}
	
}


